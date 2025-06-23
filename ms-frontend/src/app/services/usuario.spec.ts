import { TestBed } from '@angular/core/testing';

import { Usuario, UsuarioService } from './usuario.service';

describe('Usuario', () => {
  let service: Usuario;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsuarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
