package br.com.curso.udemy.controller

import br.com.curso.udemy.model.Cliente
import br.com.curso.udemy.request.ClienteRequest
import br.com.curso.udemy.service.ClienteService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/clientes")
// Essa classe vai funcionar como um DTO
class ClienteController(
    private val service: ClienteService
) {

    @Post
    fun cadastrar(@Body @Valid clienteRequest: ClienteRequest): HttpResponse<Cliente> {
        val cliente: Cliente = clienteRequest.fromCliente() // converte a requisição (DTO) para obj. de domínio

        val clienteDB: Cliente = service.cadastrar(cliente)
        return HttpResponse.created(clienteDB)
    }

    @Get("/pesquisar")
    fun listar(@QueryValue nome: String?): List<Cliente> {
        return service.listar(nome)
    }

    @Get
    fun listarTodos(@QueryValue nome: String?, pageable: Pageable): Page<Cliente> {
        return service.listarTodos(nome, pageable)
    }

    @Get("/{id}")
    fun listarPorId(@PathVariable id: Long): Cliente = service.listarPorId(id)

    @Delete("/{id}")
    fun deletar(@PathVariable id: Long): HttpResponse<Unit> {
        service.deletar(id)
        return HttpResponse.noContent()
    }

    @Put("/{id}")
    fun atualizar(@PathVariable id: Long, email: String?, endereco: String?): HttpResponse<Cliente> {

        return if (!email.isNullOrBlank() && !endereco.isNullOrBlank()) {
            service.atualizar(id, email, endereco)
            val clienteModificado: Cliente = service.listarPorId(id)
            HttpResponse.ok(clienteModificado)
        } else {
            println("deu ruim")
            HttpResponse.notModified()
        }
    }

}