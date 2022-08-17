package br.com.curso.udemy

import br.com.curso.udemy.controller.ClienteController
import br.com.curso.udemy.mock.ClienteRequestMock
import br.com.curso.udemy.repository.ClienteRepository
import br.com.curso.udemy.service.ClienteService
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@MicronautTest(application = Application::class)
class ClientServiceTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var service: ClienteService

    @Inject
    lateinit var controller: ClienteController

    @Inject
    lateinit var repository: ClienteRepository

    @Test
    fun testItWorks() = Assertions.assertTrue(application.isRunning)

    @Test
    fun `deve instanciar um Cliente com sucesso`() {

        val cliente = ClienteRequestMock.criar()

        assertAll(
            { Assertions.assertNotNull(cliente) }
        )
    }

    @Test
    fun `deve verificar se Cliente possui campos vazios`() {

        val cliente = ClienteRequestMock.criarComCamposVazios()

        assertAll(
            { Assertions.assertEquals("", cliente.nome) },
            { Assertions.assertEquals("", cliente.email) },
            { Assertions.assertEquals("", cliente.endereco) },
        )
    }

    @Test
    fun `deve verificar se Cliente possui campos invalidos`() {

        val cliente = ClienteRequestMock.criarComCamposInvalidos()

        assertAll(
            { Assertions.assertNotEquals("Lorem Ipsum", cliente.nome) },
            { Assertions.assertNotEquals("lorem@ipsum.com", cliente.email) },
            { Assertions.assertNotEquals("Casa", cliente.endereco) }
        )
    }

    @Test
    fun `deve cadastrar um Cliente com sucesso no banco de dados`() {

        val cliente = ClienteRequestMock.criar()

        controller.cadastrar(cliente)

        assertAll(
            { Assertions.assertNotNull(cliente) },
            { Assertions.assertEquals(1, repository.listar().size) }
        )

    }

}

//    @Test
//    fun `deve retornar a mensagem Hello, World!`() {
//
//        val helloController = mockk<HelloController>()
//        val mensagemEsperada = "Hello, World!"
//
//        every { helloController.hello() } returns mensagemEsperada
//
//        val result = helloController.hello()
//
//        Assertions.assertEquals(mensagemEsperada, result)
//        verify { helloController.hello() }
//
//
//    }
//
//    @Test
//    fun `dado que quero cadastrar um cliente`() {
//
//        val service = mockk<ClienteService>()
//        val controller = mockk<ClienteController>()
//
//        val cliente = ClienteRequestMock.criar()
//
//        every { controller.cadastrar(cliente) } returns HttpResponse.ok()
//
//        controller.cadastrar(cliente)
//
//        verify { controller.cadastrar(cliente) }
//
//    }

