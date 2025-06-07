package br.com.data.model

import java.time.LocalDateTime

data class CompraDTO(
    val id: Long,
    val usuario: Long,
    val valor: Double,
    val qtdPontos: Int,
    val dataCompra: LocalDateTime,
)
