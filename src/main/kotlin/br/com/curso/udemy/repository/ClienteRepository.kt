package br.com.curso.udemy.repository

import br.com.curso.udemy.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {
}