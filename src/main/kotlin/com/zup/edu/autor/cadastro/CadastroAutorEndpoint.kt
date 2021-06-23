package com.zup.edu.autor.cadastro

import com.zup.edu.CadastroAutorRequest
import com.zup.edu.CadastroAutorResponse
import com.zup.edu.CadastroAutorServiceGrpc
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class CadastroAutorEndpoint(private val cadastroAutorService: CadastroAutorService) :
    CadastroAutorServiceGrpc.CadastroAutorServiceImplBase(){

    override fun cadatro(request: CadastroAutorRequest?,
                         responseObserver: StreamObserver<CadastroAutorResponse>?) {


        val novoAutor = request?.toModel()
        val autorCadastrado = novoAutor?.let { cadastroAutorService.cadastro(it) }

        responseObserver?.onNext(CadastroAutorResponse.newBuilder()
            .setNome(autorCadastrado?.nome.toString())
            .setEmail(autorCadastrado?.email.toString())
            .setDescricao(autorCadastrado?.descricao.toString())
            .build()
        )

        responseObserver?.onCompleted()
    }
}