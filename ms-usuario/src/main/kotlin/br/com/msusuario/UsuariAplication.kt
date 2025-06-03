package br.com.msusuario

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/usuarios")
class UsuariAplication {
/*
    @GetMapping("/{usuarioID}")
    fun getUsuarios(@PathVariable usuarioID:String) = "Hello $usuarioID"

    @PostMapping("/cadastro")
    fun postCadastro(@RequestBody usuario: Usuario): Usuario = usuario

    @PatchMapping("/{usuarioID}")
    fun updatehUsuario(@PathVariable usuarioID: String, @RequestBody usuario: Usuario): Usuario = usuario

    @DeleteMapping("/{usuarioID}")
    fun deleteUsuario(@PathVariable usuarioID: String) = "Usuario $usuarioID deletado"
*/
}