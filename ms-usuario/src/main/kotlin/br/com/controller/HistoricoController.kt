package br.com.controller

import br.com.data.model.HistoricoDto
import br.com.service.HistoricoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/historico")
class HistoricoController(private val service: HistoricoService) {

    @GetMapping
    fun getAllHistoricos(): ResponseEntity<List<HistoricoDto>> =
        ResponseEntity(service.getAllHistoricos(), HttpStatus.OK)

    @GetMapping("/usuario/{usuarioId}")
    fun getHistoricosPorUsuario(@PathVariable usuarioId: Long): ResponseEntity<List<HistoricoDto>> =
        ResponseEntity(service.getHistoricosPorUsuario(usuarioId), HttpStatus.OK)

    @GetMapping("/tipo/{tipoTransacao}")
    fun getHistoricosPorTipo(@PathVariable tipoTransacao: String): ResponseEntity<List<HistoricoDto>> =
        ResponseEntity(service.getHistoricosPorTipo(tipoTransacao), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun deleteHistorico(@PathVariable id: Long): ResponseEntity<Unit> {
        service.deleteHistorico(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    private fun createResponseEntity(
        condition: Boolean,
        successStatus: HttpStatus,
        failureStatus: HttpStatus
    ): ResponseEntity<Unit> {
        return if (condition) {
            ResponseEntity(successStatus)
        } else {
            ResponseEntity(failureStatus)
        }
    }
}