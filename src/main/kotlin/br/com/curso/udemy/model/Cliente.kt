package br.com.curso.udemy.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val nome: String,
    val documento: String,
    val endereco: String

)
