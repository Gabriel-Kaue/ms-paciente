import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Compra } from '../../../shared/interfaces/compra';
import { Usuario } from '../../../shared/interfaces/usuario';
import { criarCompra } from '../../../services/compra.service';
import { listarUsuarios } from '../../../services/usuario.service';

@Component({
  selector: 'app-nova-compra',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './novo.html',
  styleUrl: './novo.css'
})
export class CriarCompraComponent implements OnInit {
    compra: Compra = {
        id: 0,
        usuario: 0,
        valor: 0.0,
        qtdPontos: 0,
        dataCompra: ''
    };

    usuarios: Usuario[] = [];

    ngOnInit(): void {
        listarUsuarios()
        .then(dados => this.usuarios = dados)
        .catch(() => alert('Erro ao carregar usuários.'));
    }

    salvar() {
        const now = new Date().toISOString().split('.')[0]; // remove .000Z

        this.compra.dataCompra = now;
        this.compra.valor = this.compra.qtdPontos * 0.10;

        criarCompra(this.compra)
            .then(() => alert('Compra registrada com sucesso!'))
            .catch((err) => {
            console.error('Erro ao registrar compra:', err);
            alert('Erro ao registrar compra.');
        });
    }


}
