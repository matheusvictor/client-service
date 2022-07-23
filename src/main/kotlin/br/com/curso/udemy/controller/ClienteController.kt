package br.com.curso.udemy.controller

import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.repository.ClienteRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import javax.transaction.Transactional

@Controller("/clientes")
open class ClienteController(
    private val repository: ClienteRepository
) {

    @Post
    fun cadastrar(@Body cliente: Cliente) {
        repository.save(cliente)
    }

    @Get
    fun listarTodos(): List<Cliente> {
        return repository.findAll()
    }

    @Get("/{id}")
    fun listarPorId(@PathVariable id: Long): Cliente = repository.findById(id).get()

    @Delete("/{id}")
    fun deletar(@PathVariable id: Long): Unit = repository.deleteById(id)

    @Put("/{id}")
    @Transactional
    open fun atualizar(@PathVariable id: Long, @Body cliente: Cliente) {
        val clienteDB = repository.findById(id).get()
        clienteDB.nome = cliente.nome
        clienteDB.documento = cliente.documento
        clienteDB.endereco = cliente.endereco
        repository.save(clienteDB)
    }


}