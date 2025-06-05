package br.com.repository

import br.com.data.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    fun encontrarById(id: Long): Usuario

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    fun encontrarPorEmail(email: String): Usuario

    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    fun encontrarPorTipo(tipo: String): List<Usuario>

}