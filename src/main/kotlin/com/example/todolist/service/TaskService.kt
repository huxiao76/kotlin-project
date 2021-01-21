package com.example.todolist.service

import com.example.todolist.entity.Task
import com.example.todolist.repository.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getTasks(): List<Task> = taskRepository.findAll()

    fun addTask(task: Task): ResponseEntity<Task> = ResponseEntity.ok(taskRepository.save(task))

    fun getTaskById(taskId: Long): ResponseEntity<Task> = taskRepository.findById(taskId).map { taskId -> ResponseEntity.ok(taskId) }
            .orElse(ResponseEntity.notFound().build())

//    fun putTask(taskId: Long, newTask: Task): ResponseEntity<Task> = taskRepository.findById(taskId).map { currentTask ->
//        val updatedTask: Task =
//                currentTask
//                        .copy(
//                        title = newTask.title,
//                        description = newTask.description,
//                                status = newTask.status,
//                                startDate = newTask.startDate,
//                                priority = newTask.priority,
//                                dueDate = newTask.dueDate
//                )
//        ResponseEntity.ok().body(taskRepository.save(updatedTask))
//    }.orElse(ResponseEntity.notFound().build())

    fun deleteTask(taskId: Long): ResponseEntity<Void> =
            taskRepository.findById(taskId).map { task ->
                taskRepository.delete(task)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())
}
