package br.com.msusuario

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class MsUsuarioApplication

fun main(args: Array<String>) {
    runApplication<MsUsuarioApplication>(*args)
}
