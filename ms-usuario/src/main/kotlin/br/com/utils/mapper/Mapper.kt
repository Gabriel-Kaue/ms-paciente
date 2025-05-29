package br.com.utils.mapper

interface Mapper<D, E> {
    fun fromDomainToEntity(domain: D): E
    fun fromEntityToDomain(entity: E): D
}