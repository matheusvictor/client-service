package br.com.curso.udemy.controller

import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.repository.ClienteRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/clientes")
class ClienteController(
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

}