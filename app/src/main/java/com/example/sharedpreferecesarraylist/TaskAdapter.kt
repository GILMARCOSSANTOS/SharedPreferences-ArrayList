package com.example.sharedpreferecesarraylist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.String
import java.util.*
import kotlin.Int

class TaskAdapter(private val context: Context, private var taskModelList: List<TaskModel?>?) :
    RecyclerView.Adapter<TaskAdapter.Holder>() {
    fun setTaskModelList(taskModelList: List<TaskModel?>?) {
        this.taskModelList = taskModelList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(context)
                .inflate(R.layout.layout_task_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("Daily", "taskModelList: $taskModelList")
        holder.txtTaskName.setText(taskModelList!![position]?.getTaskName())
        holder.txtTaskAddTime.setText(String.valueOf(taskModelList!![position]?.getTaskAddedTime()))
    }

    override fun getItemCount(): Int {
        return if (taskModelList != null) taskModelList!!.size else 0
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTaskName: TextView
        var txtTaskAddTime: TextView

        init {
            txtTaskName = itemView.findViewById(R.id.txt_task_name)
            txtTaskAddTime = itemView.findViewById(R.id.txt_date)
        }
    }

    init {
        Collections.reverse(taskModelList)
    }
}