package br.com.curso.udemy.model

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity // toda Classe anotada com @Entity já possui também, implicitamente, @Introspected
class Cliente(
    @field:NotBlank var nome: String,
    @field:NotBlank @Email var email: String,
    @field:NotBlank @Size(max = 40) var endereco: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var dataCriacao: LocalDateTime = LocalDateTime.now()
}
