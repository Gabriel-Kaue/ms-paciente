package br.com.entidade

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Historico(
    @Id
    val idTransacoes: Int,
    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    val usuario: Usuario,
    val descricao: String,
    val tipoTransacao: String,
    val dtTransacao: String,
    val valor: Float,
)
