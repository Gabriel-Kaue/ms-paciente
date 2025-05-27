package br.com.dto

data class CompraDto(
    val idCompra: Int,
    val valor: Float,
    val qtdPontos: Int,
    val dtCompra: String,
    val cpf: String,
)