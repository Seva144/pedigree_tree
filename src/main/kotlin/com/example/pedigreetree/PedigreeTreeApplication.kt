package com.example.pedigreetree

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@EnableWebSecurity
class PedigreeTreeApplication

fun main(args: Array<String>) {
	runApplication<PedigreeTreeApplication>(*args)
}
