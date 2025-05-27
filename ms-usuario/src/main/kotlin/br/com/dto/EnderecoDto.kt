package br.com.dto

data class EnderecoDto(
    val idEndereco: Int,
    val estado: String,
    val cidade: String,
    val rua: String,
    val numero: String,
)