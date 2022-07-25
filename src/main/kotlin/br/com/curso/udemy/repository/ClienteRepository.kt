package br.com.curso.udemy.repository

import br.com.curso.udemy.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {
    fun findByNome(nome: String, pageable: Pageable) : Page<Cliente>

}