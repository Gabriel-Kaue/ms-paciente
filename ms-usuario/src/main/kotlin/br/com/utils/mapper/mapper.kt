package br.com.utils.mapper

interface mapper<D, E> {
    fun fromDomainToEntity(domain: D): E
    fun fromEntityToDomain(entity: E): D
}