package br.com.controller

import br.com.data.Usuario
import br.com.data.model.UsuarioDto
import br.com.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(private val service: UsuarioService) {

    @GetMapping
    fun getAllUsuarios(): ResponseEntity<List<UsuarioDto>> =
        ResponseEntity(service.getAllUsuarios(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getUsuarioById(@PathVariable id: Long): ResponseEntity<UsuarioDto> {
        val usuario = service.getUsuarioById(id)
        return if (usuario != null) {
            ResponseEntity(usuario, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/email/{email}")
    fun getUsuarioPorEmail(@PathVariable email: String): ResponseEntity<UsuarioDto> {
        val usuario = service.getUsuarioPorEmail(email)
        return if (usuario != null) {
            ResponseEntity(usuario, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/tipo/{tipo}")
    fun getUsuariosPorTipo(@PathVariable tipo: String): ResponseEntity<List<UsuarioDto>> =
        ResponseEntity(service.getUsuariosPorTipo(tipo), HttpStatus.OK)

    @PostMapping
    fun createUsuario(
        @Valid @RequestBody usuarioDto: UsuarioDto
    ): ResponseEntity<UsuarioDto> {
        return try {
            val usuario = converterDtoParaEntity(usuarioDto)
            val createdUsuario = service.createUsuario(usuario)
            ResponseEntity(createdUsuario, HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping("/{id}")
    fun updateUsuario(
        @PathVariable id: Long,
        @Valid @RequestBody usuarioDto: UsuarioDto
    ): ResponseEntity<UsuarioDto> {
        return try {
            val existingUsuario = service.getUsuarioById(id)
            if (existingUsuario != null) {
                val usuarioAtualizado = converterDtoParaEntity(usuarioDto, id)
                val updatedUsuario = service.updateUsuario(usuarioAtualizado)
                ResponseEntity(updatedUsuario, HttpStatus.OK)
            } else {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUsuario(@PathVariable id: Long): ResponseEntity<Unit> {
        return try {
            val existingUsuario = service.getUsuarioById(id)
            if (existingUsuario != null) {
                service.deleteUsuario(id)
                ResponseEntity(HttpStatus.NO_CONTENT)
            } else {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    private fun converterDtoParaEntity(usuarioDto: UsuarioDto, idExistente: Long? = null): Usuario {
        val usuario = Usuario()
        usuario.id = idExistente ?: usuarioDto.id
        usuario.nome = usuarioDto.nome
        usuario.cpf = usuarioDto.cpf
        usuario.tipo = usuarioDto.tipo
        usuario.email = usuarioDto.email
        usuario.senha = usuarioDto.senha
        usuario.endereco = usuarioDto.endereco
        usuario.saldoPontos = usuarioDto.saldoPontos
        return usuario
    }
}