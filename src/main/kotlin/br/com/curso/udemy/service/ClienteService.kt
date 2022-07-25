package br.com.curso.udemy.service

import br.com.curso.udemy.exception.RegistroNaoEncontradoException
import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.repository.ClienteRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class ClienteService(
    private val repository: ClienteRepository
) {

    fun cadastrar(cliente: Cliente): Cliente {
        return repository.save(cliente)
    }

    fun listarTodos(pageable: Pageable): Page<Cliente> {
        return repository.findAll(pageable)
    }

    fun listarPorId(id: Long): Cliente {
        return repository.findById(id).orElseThrow {
            RegistroNaoEncontradoException("Registro não encontrado!")
        }
    }

    fun deletar(id: Long): Unit {
        val clienteDB: Cliente = listarPorId(id)
        repository.delete(clienteDB)
    }

    @Transactional
    open fun atualizar(id: Long, cliente: Cliente) {
        val clienteDB: Cliente = listarPorId(id)
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        repository.save(clienteDB)
    }

}