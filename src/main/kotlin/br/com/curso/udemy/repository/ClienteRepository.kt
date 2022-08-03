package br.com.curso.udemy.repository

import br.com.curso.udemy.model.Cliente
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
abstract class ClienteRepository(private val entityManager: EntityManager) : JpaRepository<Cliente, Long> {
    abstract fun findByNome(nome: String, pageable: Pageable): Page<Cliente>

    @Query("select c from Cliente c")
    abstract fun listar(): List<Cliente>

    @Transactional
    fun listarComImplementacao(nome: String?): List<Cliente> {

        var queryDefinicao = "SELECT c FROM Cliente cliente"
        if (!nome.isNullOrEmpty()) {
            queryDefinicao += " WHERE cliente.nome = :nome ORDER BY cliente.nome"
        }

        val query = entityManager.createQuery(queryDefinicao)
        if (!nome.isNullOrEmpty()) {
            query.setParameter("nome", nome)
        }

        val clientes = query.resultList
        return clientes as List<Cliente>
    }

}