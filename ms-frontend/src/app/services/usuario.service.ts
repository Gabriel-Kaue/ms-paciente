import axios from 'axios';
import { Usuario } from '../shared/interfaces/usuario';

const API = 'http://localhost:8080/usuario';

export const criarUsuario = async (usuario: Usuario) => {
  const response = await axios.post<Usuario>(API, usuario);
  return response.data;
};

export const listarUsuarios = async () => {
  const response = await axios.get<Usuario[]>(API);
  return response.data;
};

export const getUsuarioById = async (id: number) => {
  const response = await axios.get<Usuario>(`${API}/${id}`);
  return response.data;
};

export const atualizarUsuario = async (id: number, usuario: Usuario) => {
  const response = await axios.patch<Usuario>(`${API}/${id}`, usuario);
  return response.data;
};
