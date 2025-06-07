package br.com.service

import br.com.data.Compra
import br.com.data.Usuario
import br.com.data.model.CompraDTO
import br.com.repository.CompraRepository
import br.com.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CompraService(
    private val repository: CompraRepository,
    private val usuarioRepository: UsuarioRepository
) {

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

    private fun converterDtoParaEntity(compraDTO: CompraDTO, compraExistente: Compra? = null): Compra? {
        val usuario = usuarioRepository.findById(compraDTO.usuario).orElse(null) ?: return null
        
        val compra = compraExistente ?: Compra()
        compra.usuario = usuario
        compra.valor = compraDTO.valor
        compra.qtdPontos = compraDTO.qtdPontos
        compra.dataCompra = compraDTO.dataCompra
        
        return compra
    }

    fun getAllCompras(): List<CompraDTO> = 
        repository.findAll().mapNotNull { converterEpDto(it) }

    fun createCompra(compraDTO: CompraDTO): CompraDTO? {
        val compra = converterDtoParaEntity(compraDTO) ?: return null
        return converterEpDto(repository.save(compra))
    }

    fun updateCompra(id: Long, compraDTO: CompraDTO): CompraDTO? {
        val compraExistente = repository.findById(id).orElse(null) ?: return null
        val compraAtualizada = converterDtoParaEntity(compraDTO, compraExistente) ?: return null
        compraAtualizada.id = id // Garante que o ID não seja alterado
        return converterEpDto(repository.save(compraAtualizada))
    }

    fun deleteCompra(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }

    fun getCompraById(id: Long): CompraDTO? {
        val compra = repository.findById(id).orElse(null) ?: return null
        return converterEpDto(compra)
    }
}