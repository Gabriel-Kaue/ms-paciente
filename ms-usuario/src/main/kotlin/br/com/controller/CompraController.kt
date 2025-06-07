package br.com.controller

import br.com.data.model.CompraDTO
import br.com.service.CompraService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/compra")
class CompraController(private val service: CompraService) {

    @GetMapping
    fun getAllCompras(): ResponseEntity<List<CompraDTO>> = 
        ResponseEntity(service.getAllCompras(), HttpStatus.OK)

    @PostMapping
    fun createCompra(
        @Valid @RequestBody compra: CompraDTO
    ): ResponseEntity<CompraDTO> {
        val createdCompra = service.createCompra(compra)
        return if (createdCompra != null) {
            ResponseEntity(createdCompra, HttpStatus.CREATED)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping("/{id}")
    fun updateCompra(
        @PathVariable id: Long,
        @Valid @RequestBody compra: CompraDTO
    ): ResponseEntity<CompraDTO> {
        val updatedCompra = service.updateCompra(id, compra)
        return if (updatedCompra != null) {
            ResponseEntity(updatedCompra, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @DeleteMapping("/{id}")
    fun deleteCompra(@PathVariable id: Long): ResponseEntity<Unit> {
        val deleted = service.deleteCompra(id)
        return if (deleted) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}