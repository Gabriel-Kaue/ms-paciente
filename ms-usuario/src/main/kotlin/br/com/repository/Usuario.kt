package br.com.repository

import org.springframework.data.repository.CrudRepository

interface Usuario: CrudRepository<Usuario, String>