![1](https://i.imgur.com/XcivDaA.png)

# Quarkus_Stork

-Este projeto foi desenvolvido seguindo o tutorial do Quarkus para rodar uma aplicação dividindo a carga de trabalho em 2 instâncias.
-No projeto temos o 'stork-server-1' e o 'stork-server-2', ambos projetos tem a mesma ideia e nesse cenário seria a representação de cada instância da aplicação, apenas fizemos modificações como o nome do retorno para separar de onde está vindo.
-Também temos o 'stork-api', esse cara basicamente faz uma chamada para o 'consul' e ele administra esse mapeamento entre as 2 instâncias.

# Exemplo de uso

- 1 - Precisamos ter o Docker instalado na máquina.
- 2 - Pós Docker instalado e configurado, utilize este comando para subir o Consul: docker run --rm --name consul -p 8500:8500 -p 8501:8501 consul:1.7 agent -dev -ui --client=0.0.0.0 --bind=0.0.0.0 --https-port=8501
- 3 - Pós Consul rodando no Docker, subimos a instância 1 e a 2, no caso: 'stork-server-1' e 'stork-server-2'. Para rodar cada aplicação entre em sua pasta: 'quarkus-stork\stork-server-1' e utilize o comando no console: 'mvn quarkus:dev'
- 4 - Pós as 2 instâncias estarem funcionando e conectadas ao consul tudo já está preparado para uso.
- 5 - Para testar o funcionamento da aplicação, temos a aplicação: 'stork-api', rode ela como os anteriores 'mvn quarkus:dev' e com isso essa aplicação ficará disponível em: 'http://localhost:8080/q/swagger-ui/', lá nós temos 1 endpoint que faz apenas 1 chamada e o retorno dele dirá 'Red' ou 'Blue'.

![1](https://i.imgur.com/tFEOYig.png)
