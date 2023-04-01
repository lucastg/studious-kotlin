package br.com.myProject.forum.dto

data class NovoTopicoFormDTO(
    var titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)