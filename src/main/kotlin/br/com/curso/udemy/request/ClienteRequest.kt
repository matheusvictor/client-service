package br.com.curso.udemy.request

import br.com.curso.udemy.model.Cliente
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected // Anotação que permite que os atributos da classe possam ser "lidos"
// Essa classe vai funcionar como um DTO
data class ClienteRequest(
    @field:NotBlank var nome: String,
    @field:NotBlank @Email var email: String,
    @field:NotBlank @Size(max = 50) var endereco: String
) {
    fun fromCliente(): Cliente {
        return Cliente(nome, email, endereco) // os dados recebidos como parâmtro já foram validados pelo BeanValidation
    }
}
