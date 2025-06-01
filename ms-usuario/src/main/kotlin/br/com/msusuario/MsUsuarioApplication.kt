package br.com.msusuario

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class MsUsuarioApplication {
    @GetMapping
    fun hello() = "Hello World"
}

fun main(args: Array<String>) {
    runApplication<MsUsuarioApplication>(*args)
}
