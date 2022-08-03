package br.com.curso.udemy.exception

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Singleton
@Requires(classes = [RegistroNaoEncontradoException::class]) // no array ficam as exeções que podem ser tratadas pelo Handler
class ClienteExceptionHandler : ExceptionHandler<RegistroNaoEncontradoException, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: RegistroNaoEncontradoException?): HttpResponse<*> {
        val msg = ErrorMessage(
            mensagem = exception?.mensagem.toString()
        )
        return HttpResponse.notFound<ErrorMessage>().body(msg)
    }

}