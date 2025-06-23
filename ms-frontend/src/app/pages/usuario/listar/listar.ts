import { Component, OnInit } from '@angular/core';
import { listarUsuarios } from '../../../services/usuario.service';
import { Usuario } from '../../../shared/interfaces/usuario';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';


@Component({
  selector: 'app-listar',
  standalone: true,
  templateUrl: './listar.html',
  styleUrls: ['./listar.css'],
  imports: [CommonModule, RouterModule] 
})
export class ListarUsuarioComponent implements OnInit {
  usuarios: Usuario[] = [];
  erro = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    listarUsuarios()
      .then((dados) => this.usuarios = dados)
      .catch((erro) => console.error('Erro ao listar usuários', erro));
  }

  editarUsuario(id: number) {
    this.router.navigate(['/usuario/editar', id]);
  }
  // excluirUsuario(id: number) {
  //   excluirUsuarioPorId(id)
  //     .then(() => this.usuarios = this.usuarios.filter(u => u.id !== id))
  //     .catch(() => this.erro = 'Erro ao excluir usuário.');
  // }
}
