package com.mariroco.todoapp1

import android.icu.text.CaseMap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val dateTime: LocalDateTime
): Parcelable
