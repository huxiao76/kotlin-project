package com.example.todolist.controller

import com.example.todolist.entity.Task
import com.example.todolist.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/api/tasks")
class TaskResource(private val taskService: TaskService) {

    @GetMapping
    fun getTasks(): List<Task> = taskService.getTasks()

    @PostMapping
    fun addTask(@RequestBody task: Task): ResponseEntity<Task> = taskService.addTask(task)

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable(value = "id") taskId: Long): ResponseEntity<Task> = taskService.getTaskById(taskId)

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable(value = "id") taskId: Long): ResponseEntity<Void> = taskService.deleteTask(taskId)
}
