package br.com.myProject.forum.mapper

import br.com.myProject.forum.dto.NovoTopicoFormDTO
import br.com.myProject.forum.models.Topico
import br.com.myProject.forum.service.CursoService
import br.com.myProject.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val usuarioService: UsuarioService,
    private val cursoService: CursoService,
) : Mapper<NovoTopicoFormDTO, Topico> {
    override fun map(t: NovoTopicoFormDTO): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }
}
