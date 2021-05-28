# 🛠 Desafio
Me candidatei a um desafio spring proposto a uma vaga, no back-end.
API de resposta desenvolvida durante o fim de semana.
Atualizando em 15h!
# 

# 🚀 Arranque
## Antes de iniciar o projeto:
* Inicie um docker postgresql
* Limpe o esquema public
* Crie o schema desafio
# 

## ⚡ Tecnologias
* [Spring Framework]: Plataforma Java que fornece suporte abrangente à infraestrutura para o desenvolvimento de aplicativos Java.
* [PostgreSQL]: Sistema gerenciador de banco de dados objeto relacional, desenvolvido como projeto de código aberto.

## ⚙️ Depencencias
* Spring Web
* Spring Boot DevTools
* Sprint Data JPA
* PostgreSQL Driver

## 📘 API endpoints
* GET /api/clientes - Lista os clientes.
* GET /api/clientes/1 - Obtém os dados do cliente 1.
* POST /api/clientes - Cria um novo cliente.
* PUT /api/clientes/1 - Altera o cliente 1.
* DELETE /api/clientes/1 - Remove o cliente 1.

```json
{
	"nome": "Cliente 2",
	"cpf": "58448991435",
	"telefones": [
		{
		"telefone": "123",
		"tipo":"CO"
		},
		{
		"telefone": "456",
		"tipo": "CE"
		}
	],
	"emails":  [{"email": "teste@teste.com"}, {"email": "ae@ae.com"}],
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


