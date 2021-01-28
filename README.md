# Orientação para executar o projeto

 - Entrar na pasta raiz do projeto
 - Fazer deploy da aplicação java
 
# Docker
  - docker build ./ -t springbootapp

	Executar: docker create -v /var/lib/postgresql/data --name PostgresData alpine

  -	docker-compose up

  - URL aplicação java: http://localhost:8091/api

# NGINX
	- Foi feito a configuração do Proxy reverso
    - URL para teste: http://localhost/
  
# Cadastrar usuário

  - http://localhost:8091api/usuarios

	corpo do método:
	{
		"usuario": "nome",
		"senha": 123
	}

#Login
    http://localhost:8091/api/login
	corpo: 
	{
		"usuario": "nome",
		"senha": 123
	} 

	O endpoint retornará o Token de autorização do usuário válido por 5 minutos. Usar para testar as demais funcionalidades.

#Get Artistas + Ordem + Filtro por nome que contém
	http://localhost:8091/api/artistas?ordem=1&filtro=Serj

#Post Artistas
	http://localhost:8091/api/artistas
	Corpo: 
		{ "nome": "artista" }
	
#Put Artistas
http://localhost:8091/api/artistas/{codArtista}

	Corpo: 
		{ "nome": "artista alterado" }

#Get Album + Paginação + Ordem + Filtro por nome que contém
	Ordem : 0 - crescente, 1 - Descrescente
	http://localhost:8091/api/albuns/1?ordem=1&filtro=Mic

#Post Album
	http://localhost:8091/api/albuns

	Corpo: {
		"nome": "nome",
		"artista": {"id": 1001 } /// id_de_artista
	  }
  
#Put Album
	http://localhost:8091/api/albuns/{id} - id do album
	Corpo: {
		"nome": "nome alterado",
		"artista": {"id": 1001 } /// id_de_artista
	}

#Imagens

#Post
	http://localhost:8091/api/albuns/upload
	No Postman, fazer upload de multiplas imagens pelo form-data
	
#Get	
	http://localhost:8091/api/albuns/getImagens
	