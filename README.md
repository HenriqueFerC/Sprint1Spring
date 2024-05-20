# Sprint2Spring

PluSoluções

552399 - VICTOR FUSCO MARTINS

552325 - HENRIQUE FERREIRA CARDOSO

552431 - MATHEUS DA SILVA FERREIRA

552426 - LUCAS DE LAVOR ANDRADE

98315 - Leonardo Buonanno Del Matto

Projeto desenvolvido com Spring, para rodar a aplicação, basta entrar no projeto, mudar o application.properties para o seu banco de dados oracle e mudar para "create" para a primeira aplicação. Os métodos CRUD estão no
/perfis, /chatbots, /pagamentos, /usuarios, e para consultar o filme, /chatbots/filme, você entra no método GET, coloca o url, com um JSON dos 3 atributos do chatbot, e retorna o filme desejado.

No sprint 2 foi feita alterações nos relacionamentos que não estavam funcionando como deveriam, o MER foi alterado, adicionado o modelo de banco de dados, implementado validações e alterado os métodos da camada controller, além de correções de bugs.

Link: https://youtu.be/agYTmd2_w1I
Link: https://youtu.be/agYTmd2_w1I?s1=aTbzT8zR2XgBKrhJ


http://localhost:8080/usuarios
http://localhost:8080/usuarios/{id}/pagamento
http://localhost:8080/usuarios/{id}/perfil
http://localhost:8080/usuarios/{id}

http://localhost:8080/perfis
http://localhost:8080/perfis/{id}/chatbot
http://localhost:8080/perfis/{id}
http://localhost:8080/perfis/{idPerfil/usuario/{idUsuario}

http://localhost:8080/chatbots/filme
http://localhost:8080/chatbots
http://localhost:8080/chatbots/{id}
http://localhost:8080/chatbots/{idChatbot}/perfil/{idPerfil}

http://localhost:8080/pagamentos
http://localhost:8080/pagamentos/{id}
http://localhost:8080/pagamentos/{idPagamento}/usuario/{idUsuario}

![image](https://github.com/HenriqueFerC/Sprint1Spring/assets/129521477/044f2a21-ade0-423c-9522-c354d47a763c)



![image](https://github.com/HenriqueFerC/Sprint1Spring/assets/129521477/1fa90c84-f26c-4195-8d1e-34aba57c5204)
