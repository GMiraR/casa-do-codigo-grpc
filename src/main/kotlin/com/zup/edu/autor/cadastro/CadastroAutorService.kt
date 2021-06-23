package com.zup.edu.autor.cadastro

import com.zup.edu.autor.Autor
import com.zup.edu.autor.AutorRepository
import io.micronaut.validation.Validated
import java.lang.IllegalStateException
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.Valid

@Singleton
@Validated
class CadastroAutorService(private val autorRepository: AutorRepository) {

    @Transactional
    fun cadastro(@Valid novoAutor: NovoAutor): Autor {

        if(autorRepository.existsByEmail(novoAutor.email)){
            throw IllegalStateException("Email já cadastrado!")
        }

        val autor = novoAutor.toModel()

        autorRepository.save(autor)

        return autor
    }
}