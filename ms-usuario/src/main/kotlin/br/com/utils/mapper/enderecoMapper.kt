package br.com.utils.mapper

import br.com.dto.EnderecoDto
import br.com.entidade.Endereco
import jakarta.persistence.EntityManager

class enderecoMapper(
    private val entityManager: EntityManager
) : mapper<EnderecoDto, Endereco> {

    override fun fromDomainToEntity(domain: EnderecoDto): Endereco {
        return Endereco(
            idEndereco = domain.idEndereco,
            estado = domain.estado,
            cidade = domain.cidade,
            rua = domain.rua,
            numero = domain.numero
        )
    }

    override fun fromEntityToDomain(entity: Endereco): EnderecoDto {
        return EnderecoDto(
            idEndereco = entity.idEndereco,
            estado = entity.estado,
            cidade = entity.cidade,
            rua = entity.rua,
            numero = entity.numero
        )
    }
}