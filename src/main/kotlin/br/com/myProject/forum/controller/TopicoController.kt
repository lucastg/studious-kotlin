package br.com.myProject.forum.controller

import br.com.myProject.forum.dto.AtualizarTopicoFormDTO
import br.com.myProject.forum.dto.NovoTopicoFormDTO
import br.com.myProject.forum.dto.TopicoViewDTO
import br.com.myProject.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoViewDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoViewDTO {
        return service.buscarPorId(id)
    }

    @PostMapping()
    fun cadastrar(@RequestBody @Valid form: NovoTopicoFormDTO) {
        service.cadastrar(form)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizarTopicoFormDTO) {
        service.atualizar(form)
    }
}