import { Component } from '@angular/core';
import { Usuario } from '../../../shared/interfaces/usuario';
import { criarUsuario } from '../../../services/usuario.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-novo-usuario',
  templateUrl: './novo.html',
  styleUrls: ['./novo.css'],
  standalone: true,
  imports: [CommonModule, FormsModule],
})
export class NovoUsuarioComponent {
  usuario: Usuario = {
    nome: '',
    cpf: '',
    email: '',
    senha: '',
    endereco: '',
    saldoPontos: 0,
    tipo: 'PACIENTE'
  };

  criarUsuario() {
    criarUsuario(this.usuario)
      .then(() => alert('Usuário criado com sucesso!'))
      .catch(() => alert('Erro ao criar usuário.'));
  }
}
