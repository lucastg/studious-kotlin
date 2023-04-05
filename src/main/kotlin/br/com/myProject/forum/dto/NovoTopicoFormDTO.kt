package br.com.myProject.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NovoTopicoFormDTO(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    var titulo: String,
    @field:NotEmpty
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long
)