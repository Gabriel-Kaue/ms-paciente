import axios from 'axios';
import { Compra } from '../shared/interfaces/compra';

const API = 'http://localhost:8080/compra';

export const criarCompra = async (compra: Compra) => {
  const response = await axios.post<Compra>(API, compra);
  return response.data;
};

export const listarCompras = async () => {
  const response = await axios.get<Compra[]>(API);
  return response.data;
};
