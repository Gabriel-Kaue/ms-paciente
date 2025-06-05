package br.com.repository

import br.com.data.Compra
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CompraRepository: JpaRepository<Compra, Long> {

    @Query("SELECT c FROM Compra c WHERE c.usuario.id = :usuarioId")
    fun encontrarPorUsuarioId(usuarioId: Long): List<Compra>

}