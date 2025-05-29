package br.com.utils.mapper

import br.com.dto.HistoricoDto
import br.com.entidade.Historico
import br.com.entidade.Usuario
import jakarta.persistence.EntityManager

class HistoricoMapper(
    private val entityManager: EntityManager
) : Mapper<HistoricoDto, Historico> {
    
    override fun fromDomainToEntity(domain: HistoricoDto): Historico {
        val usuario = entityManager.find(Usuario::class.java, domain.cpf)
            ?: throw IllegalArgumentException("Usuário não encontrado para o CPF: ${domain.cpf}")
            
        return Historico(
            idTransacoes = domain.idTransacoes,
            usuario = usuario,
            descricao = domain.descricao,
            tipoTransacao = domain.tipoTransacao,
            dtTransacao = domain.dtTransacao,
            valor = domain.valor
        )
    }

    override fun fromEntityToDomain(entity: Historico): HistoricoDto = HistoricoDto(
        idTransacoes = entity.idTransacoes,
        cpf = entity.usuario.cpf,
        descricao = entity.descricao,
        tipoTransacao = entity.tipoTransacao,
        dtTransacao = entity.dtTransacao,
        valor = entity.valor
    )
}