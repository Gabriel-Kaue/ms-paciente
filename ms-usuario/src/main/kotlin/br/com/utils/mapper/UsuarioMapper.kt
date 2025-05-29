package br.com.utils.mapper

import br.com.dto.UsuarioDto
import br.com.entidade.Usuario
import br.com.entidade.Endereco
import jakarta.persistence.EntityManager

class UsuarioMapper(
    private val entityManager: EntityManager
) : Mapper<UsuarioDto, Usuario> {
    
    override fun fromDomainToEntity(domain: UsuarioDto): Usuario {
        val endereco = entityManager.find(Endereco::class.java, domain.idEndereco)
            ?: throw IllegalArgumentException("Endereço não encontrado para o ID: ${domain.idEndereco}")
            
        return Usuario(
            cpf = domain.cpf,
            nome = domain.nome,
            endereco = endereco,
            saldoPontos = domain.saldoPontos,
            email = domain.email,
            senha = domain.senha,
            tipo = domain.tipo
        )
    }
    
    override fun fromEntityToDomain(entity: Usuario): UsuarioDto = UsuarioDto(
        cpf = entity.cpf,
        nome = entity.nome,
        idEndereco = entity.endereco.idEndereco,
        saldoPontos = entity.saldoPontos,
        email = entity.email,
        senha = entity.senha,
        tipo = entity.tipo
    )
}