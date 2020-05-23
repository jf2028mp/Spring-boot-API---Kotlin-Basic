package com.example.drop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DropApplication

fun main(args: Array<String>) {
	runApplication<DropApplication>(*args)
}
