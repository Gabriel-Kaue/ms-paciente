# MS-DAC - Frontend

Interface web para gerenciamento de usuários, compras de pontos e transações. Desenvolvido em **Angular standalone** com consumo de API via `axios`.

---

## 🔧 Requisitos

* Node.js **v18+**
* Angular CLI **v17+**
* Gerenciador de pacotes (`npm` ou `yarn`)

---

## ▶️ Como rodar o projeto

1. **Clone o repositório**

```bash
git clone https://github.com/seu-usuario/ms-dac-frontend.git
cd ms-dac-frontend
```

2. **Instale as dependências**

```bash
npm install
# ou
yarn install
```

3. **Execute o servidor de desenvolvimento**

```bash
ng serve
```

4. **Acesse**

```
http://localhost:4200
```

---

## 📂 Estrutura de pastas relevante

```
├── src/
│   ├── app/
│   │   ├── pages/
│   │   │   ├── usuario/
│   │   │   │   ├── editar/
│   │   │   │   ├── novo/
│   │   │   │   └── listar/
│   │   │   ├── compra/
│   │   │   └── historico/
│   ├── shared/interfaces/
│   └── services/
```

---

## 🌐 Backend

Este projeto consome a API REST hospedada em:

```
http://localhost:8080
```

Certifique-se de que o backend esteja rodando antes de utilizar o frontend.

---


## ⚖️ Licença

Este projeto está licenciado sob os termos da **MIT License**.
