package br.com.utils.mapper

import br.com.dto.CompraDto
import br.com.entidade.Compra
import br.com.entidade.Usuario
import jakarta.persistence.EntityManager

class CompraMapper(
    private val entityManager: EntityManager
) : Mapper<CompraDto, Compra> {
    
    override fun fromDomainToEntity(domain: CompraDto): Compra {
        val usuario = entityManager.find(Usuario::class.java, domain.cpf)
            ?: throw IllegalArgumentException("Usuário não encontrado para o CPF: ${domain.cpf}")
            
        return Compra(
            idCompra = domain.idCompra,
            usuario = usuario,
            valor = domain.valor,
            qtdPontos = domain.qtdPontos,
            dtCompra = domain.dtCompra
        )
    }

    override fun fromEntityToDomain(entity: Compra): CompraDto = CompraDto(
        idCompra = entity.idCompra,
        valor = entity.valor,
        qtdPontos = entity.qtdPontos,
        dtCompra = entity.dtCompra,
        cpf = entity.usuario.cpf
    )
}