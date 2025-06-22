import { Routes } from '@angular/router';

import { ListarComponent as ListarPacientesComponent } from './pages/pacientes/listar/listar';
import { Novo as NovoPacienteComponent } from './pages/pacientes/novo/novo';
import { Editar as EditarPacienteComponent } from './pages/pacientes/editar/editar';

import { Listar as ListarFuncionariosComponent } from './pages/funcionarios/listar/listar';
import { Novo as NovoFuncionarioComponent } from './pages/funcionarios/novo/novo';
import { Editar as EditarFuncionarioComponent } from './pages/funcionarios/editar/editar';

import { Layout } from './layout/layout';

export const routes: Routes = [
  {
    path: '',
    component: Layout,
    children: [
      { path: '', redirectTo: 'pacientes', pathMatch: 'full' },
      { path: 'pacientes', component: ListarPacientesComponent },
      { path: 'pacientes/novo', component: NovoPacienteComponent },
      { path: 'pacientes/editar/:id', component: EditarPacienteComponent },
      { path: 'funcionarios', component: ListarFuncionariosComponent },
      { path: 'funcionarios/novo', component: NovoFuncionarioComponent },
      { path: 'funcionarios/editar/:id', component: EditarFuncionarioComponent }
    ]
  }
];
