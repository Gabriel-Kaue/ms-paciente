package br.com.msusuario

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["br.com"])
@EnableJpaRepositories(basePackages = ["br.com.repository"])
@EntityScan(basePackages = ["br.com.data"])
class MsUsuarioApplication

fun main(args: Array<String>) {
    runApplication<MsUsuarioApplication>(*args)
}
