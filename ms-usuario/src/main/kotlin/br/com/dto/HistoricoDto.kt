package br.com.dto

data class HistoricoDto(
    val idTransacoes: Int,
    val cpf: String,
    val descricao: String,
    val tipoTransacao: String,
    val dtTransacao: String,
    val valor: Float,
)