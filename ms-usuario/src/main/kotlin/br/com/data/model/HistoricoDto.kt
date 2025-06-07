package br.com.data.model

import java.time.LocalDateTime

data class HistoricoDto(
    val id: Long,
    val usuario: Long,
    val descricao: String,
    val tipoTransacao: TipoTransacao,
    val valor: Double,
    val dataTransacao: LocalDateTime
)
