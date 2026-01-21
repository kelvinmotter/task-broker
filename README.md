## 🧠 Task-Broker

Serviço backend para quebra automática de tarefas usando IA

O Task-Broker é um serviço backend que utiliza Inteligência Artificial para transformar descrições de alto nível em tarefas menores e acionáveis, facilitando o planejamento técnico de projetos.

---

## 🎯 Objetivo

Quebrar requisitos genéricos em tarefas claras

Reduzir ambiguidade na criação de issues

Apoiar planejamento técnico com IA

---

## 🤖 Uso da IA

A IA é utilizada para:

Analisar texto livre

Identificar entidades e regras

Decompor tarefas grandes em issues independentes

--- 

## 🛠️ Tecnologias

Java 17

Spring Boot

API REST

Gemini

---

## ▶️ Execução

```
mvn clean install
mvn spring-boot:run
```

---

## 📈 Evolução do projeto

- [x] Gerar o serviço task-broker (https://start.spring.io/)
- [x] Definir estrutura de diretórios
- [x] Integrar com a Gemini
- [x] API para enviar requisitos e obter o retorno
- [x] MVP funcional
- [ ] Refinar prompt para obter tarefas mais detalhadas e objetivas.
- [ ] Camada de segurança para criptografar o token da API
- [ ] Autenticação
- [ ] Front-end
- [ ] Integrar com mais LLMs
