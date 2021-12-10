package com.mariroco.todoapp1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.mariroco.todoapp1.MainActivity.Companion.NEW_TASK
import com.mariroco.todoapp1.MainActivity.Companion.NEW_TASK_KEY
import com.mariroco.todoapp1.MainActivity.Companion.UPDATE_TASK
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class FormActivity : AppCompatActivity() {
    private lateinit var edtTitle : EditText
    private lateinit var edtDescription : EditText
    private lateinit var edtDate : EditText
    private lateinit var edtTime : EditText
    private lateinit var btnAdd : Button
    private var isDetailTask= false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        isDetailTask = intent.getBooleanExtra("isTaskDetail", false)
        initViews()
        if(isDetailTask){
            setTaskInfo(intent.getParcelableExtra("task")?: Task())
        }
    }

    private fun setTaskInfo(task:Task){
        edtTitle.setText(task.title)
        edtDescription.setText(task.description)
        edtDate.setText(task.dateTime?.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
        edtTime.setText(task.dateTime?.format(DateTimeFormatter.ofPattern("HH:mm")))
        btnAdd.text ="Update"
    }

    private fun initViews() {
        edtTitle = findViewById(R.id.edtTitle)
        edtTime = findViewById(R.id.edtTime)
        edtDescription = findViewById(R.id.edtDescription)
        edtDate = findViewById(R.id.edtDate)
        btnAdd = findViewById(R.id.btnAdd)

        edtDate.setOnClickListener{
            val nowDate = LocalDate.now()
            DatePickerDialog(this,
                { _, year, month, dayOfMonth ->
                    val realMonth= month +1
                    //year
                    edtDate.setText(
                        "${if(dayOfMonth<10) "0$dayOfMonth" else dayOfMonth}/${if(realMonth < 10)"0$realMonth" else realMonth}/$year"
                    )
                },
                nowDate.year,
                nowDate.monthValue-1,
                nowDate.dayOfMonth
            ).apply {
                datePicker.minDate= Calendar.getInstance().timeInMillis
            }.show()
        }

        edtTime.setOnClickListener{
            val nowTime = LocalTime.now()
            TimePickerDialog(
                this,
                { _, hour, minute ->
                    val realMinute = if (minute<10)"0$minute" else minute
                    val realHour = if(hour<10) "0$hour" else hour
                    edtTime.setText("$realHour:$realMinute")
                },
                nowTime.hour,
                nowTime.minute,
                true
            ).show()
        }

        btnAdd.setOnClickListener {
            if (edtTitle.text.isEmpty() || edtDescription.text.isEmpty() || edtTime.text.isEmpty()){
                Toast.makeText(this,"Fill form",Toast.LENGTH_SHORT).show()
            }else {
                setResult(
                    if(isDetailTask) UPDATE_TASK else NEW_TASK,
                    Intent().putExtra(
                        "newTask",
                        Task(
                            intent.getParcelableExtra<Task>("task")?.id ?:0,
                            edtTitle.text.toString(),
                            edtDescription.text.toString(),
                            LocalDateTime.of(
                                LocalDate.parse(
                                    edtDate.text,
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                ),
                                LocalTime.parse(edtTime.text, DateTimeFormatter.ofPattern("HH:mm"))
                            )
                        )
                    )
                )
            }
            finish()
        }
    }
}