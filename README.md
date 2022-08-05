# Sobre o repositório

Essa simples API foi desenvolvida para exercitar conceitos de aplicações RESTful com a utilização do framework Micronaut,
tendo o Kotlin como linguagem usada na implementação da aplicação.

A aplicação consiste em uma API responsável por lidar com Clientes como recurso, onde um **CRUD** é feito e os registros
salvos em um banco de dados MySQL local. Assim, os a aplicação é capaz de:

- Listar todos os clientes cadastrados na base de dados 
- Listar os dados de um cliente com base em seu ID
- Registrar um novo cliente na base de dados
- Atualizar os dados de um cliente com base no seu ID
- Excluir um cliente da base de dados

Esta API foi desenvolvida com base em dois minicursos:

- [Kotlin com Micronaut básico - Criando uma API do zero até a publicação na AWS](https://www.udemy.com/course/kotlin-com-micornaut-basico/) (Curso pago, disponível na Udemy)
- [Micronaut e Kotlin com Yuri Matheus e Rafael Ponte | 🐱‍👤Decodificando🔍](https://www.youtube.com/watch?v=skeo3-wKDDA&list=PLkX9oUrQ1ev5kA20Es7aFk5DAho16YDzz) (Gratuito)

-----

## Documentação da API

A documentação da API pode ser acessada [clicando aqui](https://documenter.getpostman.com/view/19098148/VUjLKRpo). Lá estarão
listadas todos os _endpoints_ (com seus respectivos verbos de acesso e retornos esperados) com mais detalhes.

-----

## O que é Micronaut:

O Micronaut é um framewotk baseado em JVM, utilizado para construir microserviços modulares facilmente testáveis,
e também aplicações _serverless_.

### Vantagens:

- Rápido tempo de inicialização (já que acontece em tempo de compilação) - além de não ser baseado em _reflections_. 
O *build* da aplicação tende a demorar um pouco mais justamente por ocorrer em tempo de compilação, mas isso traz 
vantagem no tempo de inicialização.
- Baixo consumo de memória

Essas vantagens também acabam por reduzir custos durante o _deploy_ da aplicação, por exemplo. Isso porque tanto o tempo
de inicialização da aplicação desenvolvida quanto o consumo de memória não estão vinculados ao tamanho de sua base de
código.

### Anotações utilizadas e para que servem (WIP)

- ``@Transactional``