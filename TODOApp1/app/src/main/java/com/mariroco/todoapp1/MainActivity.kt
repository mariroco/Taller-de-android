package com.mariroco.todoapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.Month

class MainActivity : AppCompatActivity() {

    companion object{
        val NEW_TASK=200
        val NEW_TASK_KEY = "newTask"
        val UPDATE_TASK = 201
    }
    private lateinit var rcvTask: RecyclerView
    private lateinit var btnAddTask: FloatingActionButton

    private val SAVED_TASKS = "tasks"
    private lateinit var adapter: TasksAdapter

    private var tasks = mutableListOf<Task>()

    private lateinit var  db: TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            val savedTasks = it.getParcelableArrayList<Task>(SAVED_TASKS)?.toMutableList() ?: tasks
            tasks = savedTasks
        }

        initView()

    }

    override fun onResume() {
        super.onResume()
        db = Room.databaseBuilder(this, TaskDatabase::class.java, "Tasks").build()

        MainScope().launch {
            tasks = db.taskDao().getPendingTasks().toMutableList()
            setAdapter()
        }
    }

    private fun initView() {
        rcvTask = findViewById(R.id.rcvTasks)
        btnAddTask = findViewById(R.id.btnAddTask)
        btnAddTask.setOnClickListener {
            //adapter.add( Task(1,"new task", "decription1", LocalDateTime.now()))
            startActivityForResult(Intent(this,FormActivity::class.java), NEW_TASK)
        }
    }

    private fun setAdapter(){
        adapter = TasksAdapter(tasks, onClickDoneTask ={ task, position ->
            MainScope().launch{
                db.taskDao().updateTask(task.apply {
                    status = false
                })
                adapter.remove(position)
            }

        }, onClickDetailTask={ task ->
            startActivityForResult(Intent(this,FormActivity::class.java).apply {
                putExtra("isTaskDetail", true)
                putExtra("task", task)
            }, UPDATE_TASK)
        } )

        rcvTask.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcvTask.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putParcelableArrayList(SAVED_TASKS, tasks as ArrayList<Task>)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == NEW_TASK){
            data?.getParcelableExtra<Task>(NEW_TASK_KEY)?.let {
                MainScope().launch(Dispatchers.Main) {
                    adapter.add(it)
                }

                MainScope().launch(Dispatchers.IO) {
                    db.taskDao().saveNewTask(it)
                }

            }
        //data?.let {
                //adapter.add(it.getParcelableExtra<Task>("newTask")?: Task())
            //}

        }
        else if (requestCode == UPDATE_TASK){
            data?.getParcelableExtra<Task>("newTask")?.let {
                MainScope().launch(Dispatchers.Main) {
                    adapter.update(it)
                }

                MainScope().launch(Dispatchers.IO) {
                    db.taskDao().updateTask(it)
                }
            }

        }

    }
}