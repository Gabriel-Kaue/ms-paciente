package br.com.service

import br.com.data.Compra
import br.com.data.model.CompraDTO
import br.com.repository.CompraRepository
import org.springframework.stereotype.Service

@Service
class CompraService(private val repository: CompraRepository) {

    private fun converterEpDto(compra: Compra): CompraDTO? {

        val usuario = compra.usuario ?: return null
        val dataCompra = compra.dataCompra ?: return null

        return CompraDTO(
            id = compra.id,
            usuario = usuario.id,
            valor = compra.valor,
            qtdPontos = compra.qtdPontos,
            dataCompra = dataCompra
        )
    }

    fun getAllCompras(): List<CompraDTO> = repository.findAll().mapNotNull { converterEpDto(it) }
    fun getCompraByData(): List<CompraDTO> = repository.findAll().mapNotNull { converterEpDto(it) }
    fun createCompra(compra: Compra): CompraDTO? = converterEpDto(repository.save(compra))
    fun updateCompra(compra: Compra): CompraDTO? = converterEpDto(repository.save(compra))
    fun deleteCompra(id: Long) = repository.deleteById(id)
}

