package br.com.myProject.forum.service

import br.com.myProject.forum.models.Curso
import br.com.myProject.forum.models.Topico
import br.com.myProject.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {
    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao",
            ),
            autor = Usuario(
                id = 1,
                nome = "Lucas Tadeu",
                email = "lucas@gmail.com",
            )
        )
        return Arrays.asList(topico, topico, topico)
    }

}