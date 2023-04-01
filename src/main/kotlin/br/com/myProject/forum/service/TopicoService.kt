package br.com.myProject.forum.service

import br.com.myProject.forum.dto.NovoTopicoFormDTO
import br.com.myProject.forum.dto.TopicoViewDTO
import br.com.myProject.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val usuarioService: UsuarioService,
    private val cursoService: CursoService
) {

    fun listar(): List<TopicoViewDTO> {
        return topicos.stream().map { t ->  TopicoViewDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        ) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoViewDTO {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return TopicoViewDTO(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )

    }

    fun cadastrar(topico: NovoTopicoFormDTO) {
        topicos = topicos.plus(Topico(
                id = topicos.size.toLong() + 1,
                titulo = topico.titulo,
                mensagem = topico.mensagem,
                curso = cursoService.buscarPorId(topico.idCurso),
                autor = usuarioService.buscarPorId(topico.idAutor),
            )
        )
    }
}