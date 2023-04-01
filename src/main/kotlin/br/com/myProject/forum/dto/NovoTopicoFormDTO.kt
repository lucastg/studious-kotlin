package br.com.myProject.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class NovoTopicoFormDTO(
    @field:NotEmpty
    @Size(min = 5, max = 100)
    var titulo: String,
    @field:NotEmpty
    val mensagem: String,
    @field:NotEmpty
    val idCurso: Long,
    @field:NotEmpty
    val idAutor: Long
)