package com.example.sharedpreferecesarraylist

import java.io.Serializable

class TaskModel(toString: String?, date: String) : Serializable {

    private var task_name: String? = null
    private var task_added_time: String? = null

    fun TaskModel() {
    }

    fun TaskModel(taskName: String, taskAddedTime: String) {
        this.task_name = taskName
        this.task_added_time = taskAddedTime
    }

    fun getTaskName(): String? {
        return task_name
    }

    fun getTaskAddedTime(): String? {
        return task_added_time
    }
}

//class TaskModel : Serializable {
//    var taskName: String? = null
//        private set
//    var taskAddedTime: String? = null
//        private set
//
//    constructor() {}
//    constructor(taskName: String?, taskAddedTime: String?) {
//        this.taskName = taskName
//        this.taskAddedTime = taskAddedTime
//    }
//
//}










