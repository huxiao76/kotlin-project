package com.example.todolist.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Task (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "serial")
        val id: Long? = null,

        val title: String = "",
        val description: String? = null,
        val startDate: Date? = null,
        val dueDate: Date? = null,
        val status: Int = 0,
        val priority: Int = 0,
        val createdAt: LocalDateTime? = LocalDateTime.now(),
        val updatedAt: LocalDateTime? = LocalDateTime.now()
)
