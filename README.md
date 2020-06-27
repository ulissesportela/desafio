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
* Listar: GET /api/clientes
* Buscar: GET /api/clientes/8
* Adicionar: POST /api/clientes
* Excluir: DEL /api/clientes/13
* Atualizar: PUT /api/clientes/13
JSON:
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


[Spring Framework]: <https://spring.io/projects/spring-framework>
[PostgreSQL]: <https://www.postgresql.org>
