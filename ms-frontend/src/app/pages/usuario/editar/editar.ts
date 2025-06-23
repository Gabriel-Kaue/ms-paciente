import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../../../shared/interfaces/usuario';
import { getUsuarioById, atualizarUsuario } from '../../../services/usuario.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-editar',
  standalone: true,
  templateUrl: './editar.html',
  styleUrls: ['./editar.css'],
  imports: [CommonModule, FormsModule]
})
export class EditarUsuarioComponent implements OnInit {
  usuario!: Usuario;
  id!: number;

  constructor(public route: ActivatedRoute, public router: Router) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    getUsuarioById(this.id)
      .then((usuario) => this.usuario = usuario)
      .catch(() => alert('Erro ao buscar usuário.'));
  }

  salvarAlteracoes() {
    atualizarUsuario(this.id, this.usuario)
      .then(() => {
        alert('Usuário atualizado com sucesso!');
        this.router.navigate(['/usuario']);
      })
      .catch(() => alert('Erro ao atualizar usuário.'));
  }
}
