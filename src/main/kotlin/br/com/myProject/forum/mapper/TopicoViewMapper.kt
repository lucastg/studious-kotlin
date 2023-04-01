package br.com.myProject.forum.mapper

import br.com.myProject.forum.dto.TopicoViewDTO
import br.com.myProject.forum.models.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper <Topico, TopicoViewDTO> {
    override fun map(t: Topico): TopicoViewDTO {
        return TopicoViewDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}