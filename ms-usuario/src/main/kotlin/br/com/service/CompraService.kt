package br.com.service

import br.com.dto.CompraDto

interface CompraService {
    fun createCompra(compraDto: CompraDto)
}