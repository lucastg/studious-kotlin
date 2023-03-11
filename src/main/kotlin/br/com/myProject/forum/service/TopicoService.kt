package br.com.myProject.forum.service

import br.com.myProject.forum.models.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList()) {

    fun listar(): List<Topico> {

        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

    }

    fun cadastrar(topico: Topico) {
        topicos.plus(topico)
    }
}