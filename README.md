# 🛠 Desafio (Em Atualização)
Me candidatei a um desafio spring proposto a uma vaga, no back-end.
API de resposta desenvolvida durante o fim de semana.
Estou atualizando!
# 

## ⚡ Tecnologias
* [Spring Framework]: Plataforma Java que fornece suporte abrangente à infraestrutura para o desenvolvimento de aplicativos Java.
* [PostgreSQL]: Sistema gerenciador de banco de dados objeto relacional, desenvolvido como projeto de código aberto.

## 📘 API endpoints
### 😎 Clientes ClienteResource
#### GET
* Clientes - Listar: /api/clientes
* Clientes - Buscar: /api/clientes/8
#### POST
* Clientes - Adicionar: /api/clientes
```json
{
	"nome": "Cliente 2",
	"cpf": "58448991435",
	"telefones": [
		{
		"telefone": "123"
		},
		{
		"telefone": "456"
		}
	],
	"email":  "2019",
	"cep": "",
	"logradouro": "logradouro",
	"bairro": "bairro",
	"complemento": "complemento",
	"cidade": "cidade",
	"uf": "uf"
}
```
### PUT
* Clientes - Atualizar: /api/clientes/13
```json
{
	"nome": "Cliente 2",
	"cpf": "58448991435",
	"telefones": [
		{
		"telefone": "123"
		},
		{
		"telefone": "456"
		}
	],
	"email":  "2019",
	"cep": "",
	"logradouro": "logradouro",
	"bairro": "bairro",
	"complemento": "complemento",
	"cidade": "cidade",
	"uf": "uf"
}
```
### DEL
* Escluir Cliente - Excluir: /api/clientes/13

[Spring Framework]: <https://spring.io/projects/spring-framework>
[PostgreSQL]: <https://www.postgresql.org>
