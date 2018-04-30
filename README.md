# Keep Simple CS/GO Rest Service

Sistema de histórico e ranqueamento de partidas FFA de CS:GO disputadas entre jogadores VIPs.

## Obtendo o projeto

Você pode obter a versão mais recente deste projeto no repositório [Git Hub](https://github.com/slzvieira/keepsimple-csgo-rest/archive/master.zip) ou realizando o clone através do Git com o comando:

```
git clone https://github.com/slzvieira/keepsimple-csgo-rest.git
```

Seguem abaixo as instruções para montagem do ambiente de desenvolvimento em máquina local, execução de testes unitários, bem com como notas para deployment/distribuição da aplicação em ambiente JEE. 

## Compilação / Montagem do pacote

### Pré-requisitos

São necessários para execução / desenvolvimento do projeto CS/GO Rest Service:

* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - Versão 8 ou posterior
* [Maven](https://maven.apache.org/) - Gerenciador de dependências

### Compilando o projeto

A compilação do projeto e montagem do pacote para distribuição/execução é realizada por maven.

Para isto, utilize o comando

```
mvn install
```

Ou ainda, para remover versões anteriores do pacote

```
mvn clean install
```

## Executando os Testes Unitários

O projeto está equipado com os testes unitários (JUnit) para os serviços utilizados no sistema.
O mesmo pode ser executado via ferramenta de desenvolvimento (Eclipse ou afins), bem como por mavem pelo comando:

```
mvn test
```

## Deployment

O projeto pode ser executado de forma standalone (Tomcat Embbed) ou ser implantado em algum servidor JEE bastando apenas o Servlet Container.

## Autores

* **Sandro Vieira** - *Versão Inicial* - [slzvieira](https://github.com/slzvieira)


