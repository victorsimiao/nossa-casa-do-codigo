package br.com.zup.autores.controller

import br.com.zup.autores.repository.AutorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import javax.transaction.Transactional


@Controller("/api/autores/{id}")
class DeletaAutorController(val autorRepository: AutorRepository) {

    @Delete
    @Transactional
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {
        val possivelAutor = autorRepository.findById(id)
        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }
        autorRepository.deleteById(id)
        return HttpResponse.ok()
    }
}