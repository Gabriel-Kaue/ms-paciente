package br.com.repository

import br.com.data.Historico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface HistoricoRepository: JpaRepository<Historico, Long> {

    @Query("SELECT h FROM Historico h WHERE h.usuario.id = :usuarioId")
    fun encontrarPorId(usuarioId: Long): List<Historico>

    @Query("SELECT h FROM Historico h WHERE h.tipo = :tipoTransacao")
    fun encontrarPorTipoTransacao(tipoTransacao: String): List<Historico>
}