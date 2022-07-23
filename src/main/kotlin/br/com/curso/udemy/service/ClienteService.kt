package br.com.curso.udemy.service

import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.repository.ClienteRepository
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
class ClienteService(
    private val repository: ClienteRepository
) {

    fun cadastrar(cliente: Cliente) {
        repository.save(cliente)
    }

    fun listarTodos(): List<Cliente> {
        return repository.findAll()
    }

    fun listarPorId(id: Long): Cliente = repository.findById(id).get()

    fun deletar(id: Long): Unit = repository.deleteById(id)

    @Transactional
    open fun atualizar(id: Long, cliente: Cliente) {
        val clienteDB = repository.findById(id).get()
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        repository.save(clienteDB)
    }

}