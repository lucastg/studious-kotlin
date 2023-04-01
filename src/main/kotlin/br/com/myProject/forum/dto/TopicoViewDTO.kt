package br.com.myProject.forum.dto

import br.com.myProject.forum.models.StatusTopico
import java.time.LocalDateTime

data class TopicoViewDTO(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)