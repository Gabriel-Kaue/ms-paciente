package br.com.dto

data class UsuarioDto(
    val cpf: String,
    val nome: String,
    val idEndereco: Int,
    val saldoPontos: Float,
    val email: String,
    val senha: String,
    val tipo: String,
)