package br.com.service

import br.com.data.Usuario
import br.com.data.model.UsuarioDto
import br.com.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    private fun converterEpDto(usuario: Usuario): UsuarioDto {
        return UsuarioDto(
            id = usuario.id,
            nome = usuario.nome,
            cpf = usuario.cpf,
            tipo = usuario.tipo,
            email = usuario.email,
            senha = usuario.senha,
            endereco = usuario.endereco,
            saldoPontos = usuario.saldoPontos
        )
    }

    fun getAllUsuarios(): List<UsuarioDto> = repository.findAll().map { converterEpDto(it) }

    fun getUsuarioById(id: Long): UsuarioDto? {
        return try {
            converterEpDto(repository.encontrarById(id))
        } catch (e: Exception) {
            null
        }
    }

    fun getUsuarioPorEmail(email: String): UsuarioDto? {
        return try {
            converterEpDto(repository.encontrarPorEmail(email))
        } catch (e: Exception) {
            null
        }
    }

    fun getUsuariosPorTipo(tipo: String): List<UsuarioDto> {
        return try {
            repository.encontrarPorTipo(tipo).map { converterEpDto(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun createUsuario(usuario: Usuario): UsuarioDto = converterEpDto(repository.save(usuario))

    fun updateUsuario(usuario: Usuario): UsuarioDto = converterEpDto(repository.save(usuario))

    fun deleteUsuario(id: Long) = repository.deleteById(id)
}