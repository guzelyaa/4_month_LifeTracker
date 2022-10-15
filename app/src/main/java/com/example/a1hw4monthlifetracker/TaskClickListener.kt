package com.example.a1hw4monthlifetracker

import com.example.a1hw4monthlifetracker.room.TaskModel

interface TaskClickListener {

    fun itemClick(taskModel: TaskModel)
    fun deleteItemClick(taskModel: TaskModel)
}