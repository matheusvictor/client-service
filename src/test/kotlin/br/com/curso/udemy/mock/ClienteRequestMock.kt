package br.com.curso.udemy.mock

import br.com.curso.udemy.request.ClienteRequest
import io.micronaut.core.annotation.Introspected

@Introspected
class ClienteRequestMock {

    companion object {

        fun criar() = ClienteRequest(
            nome = "Lorem Ipsum",
            email = "lorem@ipsum.com",
            endereco = "Rua dos Bobos"
        )

        fun criarComCamposVazios() = ClienteRequest(
            nome = "",
            email = "",
            endereco = ""
        )

        fun criarComCamposInvalidos() = ClienteRequest(
            nome = "Peter Pan",
            email = "outro@email.com",
            endereco = "Terra do Nunca"
        )

    }

}
