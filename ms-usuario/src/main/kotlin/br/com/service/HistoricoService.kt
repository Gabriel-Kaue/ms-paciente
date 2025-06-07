package br.com.service

import br.com.data.Historico
import br.com.data.model.HistoricoDto
import br.com.repository.HistoricoRepository
import org.springframework.stereotype.Service
import kotlin.collections.mapNotNull

@Service
class HistoricoService(private val repository: HistoricoRepository) {

    private fun converterEpDto(historico: Historico): HistoricoDto? {
        val usuario = historico.usuario ?: return null
        val data = historico.data ?: return null
        val tipo = historico.tipo ?: return null
        val valor = historico.valor ?: return null

        return HistoricoDto(
            id = historico.id,
            usuario = usuario.id,
            descricao = historico.descricao,
            tipoTransacao = tipo,
            dataTransacao = data,
            valor = valor
        )
    }

    fun getAllHistoricos(): List<HistoricoDto> = repository.findAll().mapNotNull { converterEpDto(it) }
    
    fun getHistoricosPorUsuario(usuarioId: Long): List<HistoricoDto> = 
        repository.encontrarPorId(usuarioId).mapNotNull { converterEpDto(it) }
    
    fun getHistoricosPorTipo(tipoTransacao: String): List<HistoricoDto> = 
        repository.encontrarPorTipoTransacao(tipoTransacao).mapNotNull { converterEpDto(it) }
    
    fun createHistorico(historico: Historico): HistoricoDto? = converterEpDto(repository.save(historico))
    
    fun updateHistorico(historico: Historico): HistoricoDto? = converterEpDto(repository.save(historico))
    
    fun deleteHistorico(id: Long) = repository.deleteById(id)
}