package com.zup.edu.autor.cadastro

import com.zup.edu.CadastroAutorRequest

fun CadastroAutorRequest.toModel() : NovoAutor{
    return NovoAutor(
        nome = nome,
        email = email,
        descricao = descricao
    )
}