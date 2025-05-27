package br.com.entidade

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Usuario(
    @Id
    val cpf: String,
    val nome: String,
    @ManyToOne
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
    val endereco: Endereco,
    val saldoPontos: Float,
    val email: String,
    val senha: String,
    val tipo: String,
)
