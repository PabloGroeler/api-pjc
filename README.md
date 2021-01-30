# DADOS
	Candidato: Pablo Henrique Groeler
	E-mail: pablo_groeler@hotmail.com
	Vaga: Analista Desenvolvedor

# ORIENTAÇÕES

	- Entrar na pasta raiz do projeto
	- Fazer deploy da aplicação java
 
# DOCKER
	- docker build ./ -t springbootapp

	Executar: docker create -v /var/lib/postgresql/data --name PostgresData alpine

	-	docker-compose up

	- URL aplicação java: http://localhost:8091/api

# NGINX
	- Foi feito a configuração do Proxy reverso
    - URL para teste: http://localhost/

# USUÁRIOS 
 
# Cadastrar

	- http://localhost:8091api/usuarios

	corpo do método:
	{
		"usuario": "nome",
		"senha": 123
	}

# Login

    http://localhost:8091/api/login
	corpo: 
	{
		"usuario": "nome",
		"senha": 123
	} 

	O endpoint retornará o Token de autorização do usuário válido por 5 minutos. Usar para testar as demais funcionalidades.

# ARTISTAS

# Get + Ordem + Filtro por nome que contém
	http://localhost:8091/api/artistas?ordem=1&filtro=Serj

# Post
	http://localhost:8091/api/artistas
	Corpo: 
		{ "nome": "artista" }
	
# Put
	http://localhost:8091/api/artistas/{codArtista}

	Corpo: 
		{ "nome": "artista alterado" }

# ALBUM

# Get + Paginação + Ordem + Filtro por nome que contém
	Ordem : 0 - crescente, 1 - Descrescente
	http://localhost:8091/api/albuns/1?ordem=1&filtro=Mic

# Post
	http://localhost:8091/api/albuns

	Corpo: {
		"nome": "nome",
		"artista": {"id": 1001 } /// id_de_artista
	  }
  
# Put
	http://localhost:8091/api/albuns/{id} - id do album
	Corpo: {
		"nome": "nome alterado",
		"artista": {"id": 1001 } /// id_de_artista
	}

# IMAGENS

# Post
	http://localhost:8091/api/albuns/upload
	No Postman, fazer upload de multiplas imagens pelo form-data
	definir o parametro da chave como 'file' e o nome 'imagem'
	
# Get	
	http://localhost:8091/api/albuns/getImagens
	