package br.com.data

import br.com.data.model.TipoTransacao
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "Historico")
class Historico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    var usuario: Usuario? = null

    @Column(name = "descricao", nullable = false)
    var descricao: String = ""

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    var tipo: TipoTransacao? = null

    @Column(name = "data", nullable = false)
    var data: LocalDateTime? = null

    @Column(name = "valor", nullable = false)
    var valor: Double? = null

}