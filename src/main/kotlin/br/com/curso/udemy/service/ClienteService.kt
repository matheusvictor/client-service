package br.com.curso.udemy.service

import br.com.curso.udemy.exception.RegistroNaoEncontradoException
import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.repository.ClienteRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import java.time.LocalDateTime
import javax.transaction.Transactional

@Singleton
open class ClienteService(
    private val repository: ClienteRepository
) {

    fun cadastrar(cliente: Cliente): Cliente {
        return repository.save(cliente)
    }

    fun listarTodos(nome: String?, pageable: Pageable): Page<Cliente> {
        val clientes = if (nome.isNullOrBlank()) {
            repository.findAll(pageable)
        } else {
            repository.findByNome(nome, pageable)
        }
        return clientes
    }

    fun listarPorId(id: Long): Cliente {
        return repository.findById(id).orElseThrow {
            RegistroNaoEncontradoException()
        }
    }

    fun deletar(id: Long) {
        val clienteDB: Cliente = listarPorId(id)
        repository.delete(clienteDB)
    }

    @Transactional
    open fun atualizar(id: Long, email: String, endereco: String) {
        val clienteDB: Cliente = listarPorId(id) // identificando qual é o cliente que possui o ID passado na URI

        clienteDB.email = email
        clienteDB.endereco = endereco
        clienteDB.dataModificacao = LocalDateTime.now()
        // repository.save(clienteDB)
        repository.update(clienteDB)


    }

    fun listar(nome: String?): List<Cliente> {
        return repository.listarComImplementacao(nome)
    }

}