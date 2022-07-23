package br.com.curso.udemy.controller

import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.repository.ClienteRepository
import br.com.curso.udemy.service.ClienteService
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
    private val service: ClienteService
) {

    @Post
    fun cadastrar(@Body cliente: Cliente) = service.cadastrar(cliente)

    @Get
    fun listarTodos(): List<Cliente> = service.listarTodos()

    @Get("/{id}")
    fun listarPorId(@PathVariable id: Long): Cliente = service.listarPorId(id)

    @Delete("/{id}")
    fun deletar(@PathVariable id: Long): Unit = service.deletar(id)

    @Put("/{id}")
    open fun atualizar(@PathVariable id: Long, @Body cliente: Cliente) {
        service.atualizar(id, cliente)
    }

}