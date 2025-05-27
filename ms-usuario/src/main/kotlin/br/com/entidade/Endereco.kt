package br.com.entidade

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Endereco(
    @Id
    val idEndereco: Int,
    val estado: String,
    val cidade: String,
    val rua: String,
    val numero: String,
)
