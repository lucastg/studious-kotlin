package br.com.myProject.forum.service

import br.com.myProject.forum.dto.AtualizarTopicoFormDTO
import br.com.myProject.forum.dto.NovoTopicoFormDTO
import br.com.myProject.forum.dto.TopicoViewDTO
import br.com.myProject.forum.mapper.TopicoFormMapper
import br.com.myProject.forum.mapper.TopicoViewMapper
import br.com.myProject.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
) {

    fun listar(): List<TopicoViewDTO> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoViewDTO {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicoViewMapper.map(topico)

    }

    fun cadastrar(form: NovoTopicoFormDTO) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atualizar(form: AtualizarTopicoFormDTO) {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topicos = topicos.minus(topico).plus(
            Topico(
                id = form.id,
                titulo = form.titulo,
                mensagem = form.mensagem,
                autor = topico.autor,
                curso = topico.curso,
                respostas = topico.respostas,
                status = topico.status,
                dataCriacao = topico.dataCriacao,
            )
        )
    }
}