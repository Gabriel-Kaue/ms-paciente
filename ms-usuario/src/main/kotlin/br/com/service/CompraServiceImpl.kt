package br.com.service

import br.com.dto.CompraDto
import br.com.repository.CompraRepository
import br.com.utils.mapper.compraMapper

class CompraServiceImpl(
    private val compraRepository: CompraRepository,
    private val compraMapper: compraMapper
) : CompraService {
    override fun createCompra(compraDto: CompraDto) {
        val compraEntity = compraMapper.fromDomainToEntity(compraDto)
        compraRepository.save(compraEntity)
    }
}