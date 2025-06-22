import { Component, OnInit } from '@angular/core';
import { PacienteService } from '../../../services/usuario';
import { Paciente } from '../../../services/usuario';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-listar',
  standalone: true,
  templateUrl: './listar.html',
  styleUrls: ['./listar.css'],
  imports: [CommonModule] 
})
export class ListarComponent implements OnInit {
  pacientes: Paciente[] = [];

  constructor(private pacienteService: PacienteService) {}

  ngOnInit(): void {
    this.pacienteService.listar().subscribe({
      next: (dados) => this.pacientes = dados,
      error: (erro) => console.error('Erro ao listar pacientes', erro)
    });
  }
}
