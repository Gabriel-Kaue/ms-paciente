package br.com.data.model

data class UsuarioDto(
    val id: Long,
    val nome: String,
    val cpf: String,
    val tipo: TipoUsuario,
    val email: String,
    val senha: String,
    val endereco: String,
    val saldoPontos: Int
)
