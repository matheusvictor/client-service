package br.com.curso.udemy.controller

import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.service.ClienteService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/clientes")
class ClienteController(
    private val service: ClienteService
) {

    @Post
    fun cadastrar(@Body cliente: Cliente): HttpResponse<Cliente> {
        val clienteDB: Cliente = service.cadastrar(cliente)
        return HttpResponse.created(clienteDB)
    }

    @Get
    fun listarTodos(): List<Cliente> = service.listarTodos()

    @Get("/{id}")
    fun listarPorId(@PathVariable id: Long): Cliente = service.listarPorId(id)

    @Delete("/{id}")
    fun deletar(@PathVariable id: Long): HttpResponse<Unit> {
        service.deletar(id)
        return HttpResponse.noContent()
    }

    @Put("/{id}")
    fun atualizar(@PathVariable id: Long, @Body cliente: Cliente) {
        service.atualizar(id, cliente)
    }

}