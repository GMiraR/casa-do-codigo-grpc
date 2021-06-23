package com.zup.edu.autor

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import kotlin.math.max

@Entity
class Autor(
    @Column(nullable = false)
    @field:NotBlank
    var nome: String,

    @Column(nullable = false)
    @field:NotBlank
    @field:Email
    var email: String,

    @Column(nullable = false, length = 400)
    @field:NotBlank
    @field:Size(max = 400)
    var descricao: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val instante: LocalDateTime = LocalDateTime.now()
}