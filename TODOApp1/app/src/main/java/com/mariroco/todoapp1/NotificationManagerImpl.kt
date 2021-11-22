package com.mariroco.todoapp1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationManagerImpl(private val context: Context,params:WorkerParameters):Worker(context,params) {



    private fun createNotification(task: Task) {
        val builder = NotificationCompat.Builder(context,"TASK_CHANNEL")
            .setSmallIcon(R.drawable.ic_clock)
            .setContentTitle(task.title)
            .setContentText(task.description)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)){
            notify(task.id, builder.build())
        }
    }

    override fun doWork(): Result {
        val id = inputData.getInt("notificationID",0)
        val title = inputData.getString("notificationTitle")?: ""
        val description = inputData.getString("notificationDescription")?: ""

        createNotification(Task(id,title,description))
        return Result.success()
    }
}