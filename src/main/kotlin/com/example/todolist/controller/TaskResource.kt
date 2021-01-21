package com.example.todolist.controller

import com.example.todolist.entity.Task
import com.example.todolist.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/api/tasks")
class TaskResource(private val taskService: TaskService) {

    @GetMapping
    fun list(): List<Task> = taskService.getTasks()

    @GetMapping("/{id}")
    fun query(@PathVariable(value = "id") taskId: Long): ResponseEntity<Task> = taskService.getTaskById(taskId)

    @PostMapping
    fun create(@RequestBody task: Task): ResponseEntity<Task> = taskService.addTask(task)

    @PutMapping("/{id}")
    fun update(@PathVariable(value = "id") taskId: Long, @RequestBody task: Task): ResponseEntity<Task> = taskService.putTask(taskId, task)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") taskId: Long): ResponseEntity<Void> = taskService.deleteTask(taskId)
}
