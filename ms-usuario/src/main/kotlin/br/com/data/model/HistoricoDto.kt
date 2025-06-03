package br.com.data.model

data class HistoricoDto(
    val id: Long,
    val usuario: Long,
    val tipoTransacao: TipoTransacao,
    val valor: Double,
    val dataTransacao: String
)
