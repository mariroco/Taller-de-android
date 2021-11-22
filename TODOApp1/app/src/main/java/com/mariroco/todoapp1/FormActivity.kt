package com.mariroco.todoapp1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.mariroco.todoapp1.MainActivity.Companion.NEW_TASK
import com.mariroco.todoapp1.MainActivity.Companion.NEW_TASK_KEY
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        initViews()
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
                    NEW_TASK,
                    Intent().putExtra(
                        NEW_TASK_KEY,
                        Task(
                            0,
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