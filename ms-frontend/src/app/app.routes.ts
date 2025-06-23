import { Routes } from '@angular/router';
import { Layout } from './layout/layout';

export const routes: Routes = [
  {
    path: '',
    component: Layout,
    children: [
      { path: '', redirectTo: 'usuario', pathMatch: 'full' },
      { path: 'usuario', loadComponent: () => import('./pages/usuario/listar/listar').then(m => m.ListarUsuarioComponent) },
      { path: 'usuario/editar/:id', loadComponent: () => import('./pages/usuario/editar/editar').then(m => m.EditarUsuarioComponent) },
      { path: 'usuario/novo', loadComponent: () => import('./pages/usuario/novo/novo').then(m => m.NovoUsuarioComponent) },
      { path: 'compra/novo', loadComponent: () => import('./pages/compra/novo/novo').then(m => m.CriarCompraComponent)},
      { path: 'compra/listar', loadComponent: () => import('./pages/compra/listar/listar').then(m => m.ListarComprasComponent)}
    ]
  }
];
 