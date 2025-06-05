package br.com.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "Compra")
class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    var usuario: Usuario? = null

    @Column(name = "valor", nullable = false)
    var valor: Double = 0.0

    @Column(name = "qtdPontos", nullable = false)
    var qtdPontos: Int = 0

    @Column(name = "dataCompra", nullable = false)
    var dataCompra: LocalDateTime? = null

}