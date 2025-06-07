package br.com.data

import br.com.data.model.TipoUsuario
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "usuario")
 class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

   @Column(name = "nome", nullable = false)
    var nome: String = ""

   @Column(name = "cpf", nullable = false, unique = true, length = 11)
    var cpf: String = ""

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    var tipo: TipoUsuario = TipoUsuario.PACIENTE

   @Column(name = "email", nullable = false, unique = true)
    var email: String = ""

   @Column(name = "senha", nullable = false)
    var senha: String = ""

   @Column(name = "endereco", nullable = false)
    var endereco: String = ""

   @Column(name = "saldoPontos", nullable = false)
   var saldoPontos: Int = 0

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var compras: MutableList<Compra> = mutableListOf()

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var historicos: MutableList<Historico> = mutableListOf()

}
