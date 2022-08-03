package br.com.curso.udemy.exception

class RegistroNaoEncontradoException(
    var mensagem: String = "Registro não encontrado!"
) : RuntimeException() {}