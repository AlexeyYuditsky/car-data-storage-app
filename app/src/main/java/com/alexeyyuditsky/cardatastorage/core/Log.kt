package com.alexeyyuditsky.cardatastorage.core

import android.util.Log

fun <T> log(message: T) {
    Log.d("MyLog", message.toString())
}