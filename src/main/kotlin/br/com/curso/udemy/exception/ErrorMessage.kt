package br.com.curso.udemy.exception

import java.time.LocalDateTime

data class ErrorMessage(
    val dataHora: String = LocalDateTime.now().toString(),
    val mensagem: String
)
