package com.zup.edu.autor.cadastro

import com.zup.edu.autor.Autor
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoAutor(

    @field:NotBlank
    val nome:String,

    @field:NotBlank
    val email:String,

    @field:NotBlank
    @field:Size(max = 400)
    val descricao:String
){

    fun toModel(): Autor {
        return Autor(
            nome = this.nome,
            email = this.email,
            descricao = this.descricao
        )
    }
}