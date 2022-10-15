package com.example.a1hw4monthlifetracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.a1hw4monthlifetracker.databinding.TaskItemBinding
import com.example.a1hw4monthlifetracker.room.TaskModel

class TaskAdapter(private val list : List<TaskModel>, private val listener: TaskClickListener) :
    Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TaskViewHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(taskModel: TaskModel) {
            binding.taskName.text = taskModel.task
            binding.date.text = taskModel.date
            binding.regular.text = taskModel.regular
            itemView.setOnClickListener {
                listener.itemClick(taskModel)
            }
            itemView.setOnLongClickListener {
                listener.deleteItemClick(taskModel)
                false
            }
        }

    }
}