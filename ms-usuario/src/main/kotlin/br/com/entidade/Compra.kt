package br.com.entidade


import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Compra(
    @Id
    val idCompra: Int,
    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    val usuario: Usuario,
    val valor: Float,
    val qtdPontos: Int,
    val dtCompra: String,
)
