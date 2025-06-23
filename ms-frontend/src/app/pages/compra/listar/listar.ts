import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Compra } from '../../../shared/interfaces/compra';
import { listarCompras } from '../../../services/compra.service';
import { Usuario } from '../../../shared/interfaces/usuario';
import { listarUsuarios } from '../../../services/usuario.service';

@Component({
  selector: 'app-listar-compras',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar.html',
  styleUrl: './listar.css'
})
export class ListarComprasComponent implements OnInit {
  compras: Compra[] = [];
  usuarios: Usuario[] = [];

  getNomeUsuario(usuarioId: number): string {
    const usuario = this.usuarios.find(u => u.id === usuarioId);
    return usuario ? usuario.nome : 'Desconhecido';
  }

  ngOnInit(): void {
    listarCompras()
      .then(dados => this.compras = dados)
      .catch(() => alert('Erro ao carregar compras.'));

    listarUsuarios()
      .then(dados => this.usuarios = dados)
      .catch(() => alert('Erro ao carregar usuários.'));
  }
}
