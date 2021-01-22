Orientação para executar o projeto:

Entrar na pasta raiz do projeto pela linha de comando;
Nesse diretório possui os arquivos Dockerfile e docker-compose.yml

Executar no Docker:
docker build ./ -t springbootapp
docker-compose up

Salvando docker:
docker save -o ./springbootapp.tar springbootapp
docker save -o ./postgres.tar postgres

Carregar Docker:
docker load -i ./springbootapp.tar
docker load -i ./postgres.tar

caminho da aplicação java: http://localhost:8091/api
------------------------------------------------------------------

Método Post para cadastrar usuario:
http://localhost:8091/api/usuarios

corpo do método:
{
    "usuario": "nome",
    "senha": 123
}
------------------------------------------------------------------
Login:
http://localhost:8091/api/login

corpo: 

{
    "usuario": "nome",
    "senha": 123
} 

Utilizando o PostMan, o esse endpoint retornará o Token de autorização do usuário válido por 5 minutos. Usar para testar as demais funcionalidades.
------------------------------------------------------------------

Get Artistas com de ordem e filtro por nome que contém:
http://localhost:8091/api/artistas?ordem=1&filtro=Serj

Post Artistas:
http://localhost:8091/api/artistas
Corpo: 
	{ "nome": "artista" }
	
Put Artistas:
http://localhost:8091/api/artistas/{codArtista}

Corpo: 
	{ "nome": "artista alterado" }
------------------------------------------------------------------
Get Album com paramêtro de pagina, ordem e filtro por nome que contém: 
Ordem : 0 - crescente, 1 - Descrescente
http://localhost:8091/api/albuns/1?ordem=1&filtro=Mic

Post album:
http://localhost:8091/api/albuns

Corpo: {
	"nome": "nome",
	"artista": {"id": 1001 } /// id_de_artista
  }
  
put album:
http://localhost:8091/api/albuns/{id} - id do album
Corpo: {
	"nome": "nome alterado",
	"artista": {"id": 1001 } /// id_de_artista
  }


http://localhost:8091/api/albuns/upload
através do postman, é possível fazer upload de multiplas imagens pelo form-data