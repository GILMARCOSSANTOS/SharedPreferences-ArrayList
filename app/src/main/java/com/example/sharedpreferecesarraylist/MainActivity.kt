package com.example.sharedpreferecesarraylist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd: Button
    private lateinit var etTaskEntry: EditText
    private lateinit var recyclerView: RecyclerView
    private var adapter: TaskAdapter? = null
    private lateinit var taskList: MutableList<TaskModel>

    // private var taskList: List<TaskModel>? = null
    // private var taskList: MutableList<TaskModel?>? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // var taskList: MutableList<TaskModel>? = null

        btnAdd = findViewById(R.id.btn_addItem_actvtMain)
        recyclerView = findViewById(R.id.rccvw_actvtMain)
        etTaskEntry = findViewById(R.id.edtTxt_addItem_actvtMain)
        taskList = PrefConfig.readListFromPref(this) as MutableList<TaskModel>

        if (taskList == null) taskList = ArrayList()

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = TaskAdapter(applicationContext, taskList)
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener(View.OnClickListener {
            val taskModel = TaskModel(etTaskEntry.text.toString(), date)
            taskList!!.add(taskModel)
            PrefConfig.writeListInPref(applicationContext, taskList)
            Collections.reverse(taskList)
            adapter!!.setTaskModelList(taskList)
            if (etTaskEntry.text.toString() != "") etTaskEntry.setText("")
        })
    }

    private val date: String
        private get() {
            val cal = Calendar.getInstance()
            val date = cal.time
            val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")
            return dateFormat.format(date).toString()
        }
}



