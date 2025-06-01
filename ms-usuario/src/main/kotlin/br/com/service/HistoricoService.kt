package br.com.service

import br.com.dto.HistoricoDto

interface HistoricoService {
    fun createHistorico(HistoricoDto: HistoricoDto)
}