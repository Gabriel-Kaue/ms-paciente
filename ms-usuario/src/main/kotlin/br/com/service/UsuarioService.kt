package br.com.service

import br.com.dto.UsuarioDto

interface UsuarioService {
    fun createUsuario(UsuarioDto: UsuarioDto)
}