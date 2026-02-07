# 🎟️ Sistema de Venda de Ingressos - Show 2026

Este é o meu **primeiro projeto Spring Boot**, desenvolvido após um ano de estudos dedicados à linguagem Java. O sistema simula a venda de ingressos para um show, com gerenciamento de setores e geração de tickets personalizados.

## 🚀 Funcionalidades
* **Listagem de Setores:** Consulta dinâmica de preços e vagas disponíveis via API.
* **Processamento de Venda:** Validação de disponibilidade de ingressos.
* **Geração de Ticket (PNG):** Criação automática de um arquivo de imagem com os dados do comprador (Nome e CPF) usando Java AWT.
* **Interface Web:** Front-end interativo que consome a API do Back-end.

## 🛠️ Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3.x** (Web)
* **Maven** (Gerenciamento de dependências)
* **JavaScript/HTML/CSS** (Interface do usuário)
* **IntelliJ IDEA**

## 🏗️ Arquitetura
O projeto segue o padrão **MVC (Model-View-Controller)** para garantir a organização e separação de responsabilidades:
- `Controller`: Gerencia as rotas da API.
- `Service`: Contém a lógica de negócio e geração da imagem.
- `Model`: Define as entidades (Cliente, Setor).

## 📥 Como rodar o projeto
1. Clone este repositório:
   ```bash
   git clone [https://github.com/SaraVitoria2006/WEB_INGRESSOS.git](https://github.com/SaraVitoria2006/WEB_INGRESSOS.git)
