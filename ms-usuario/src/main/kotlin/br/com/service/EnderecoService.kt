package br.com.service

import br.com.dto.EnderecoDto

interface EnderecoService {
    fun createEndereco(EnderecoDto: EnderecoDto)
}