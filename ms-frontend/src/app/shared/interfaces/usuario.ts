export interface Usuario {
  id?: number;
  nome: string;
  cpf: string;
  email: string;
  senha: string;
  endereco: string;
  saldoPontos: number;
  tipo: 'PACIENTE' | 'MEDICO';
}
