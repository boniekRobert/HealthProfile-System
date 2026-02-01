# Computadorização dos Registros de Saúde (HealthProfile)

Este projeto é um exercício de programação em Java focado na criação de um sistema inicial para registros de saúde eletrônicos. O objetivo é modelar um perfil de saúde (`HealthProfile`) e realizar cálculos biométricos fundamentais.

## 📄 Descrição do Problema

A computadorização dos registros de saúde é um tema atual e relevante. Embora haja preocupações com privacidade e segurança, o compartilhamento eficiente de históricos médicos pode:

- Aprimorar a qualidade da assistência médica.
- Evitar conflitos e prescrições erradas de medicamentos.
- Reduzir custos em ambulatórios.
- Salvar vidas.

Este programa serve como um protótipo de classe para armazenar e processar esses dados vitais.

## 🚀 Funcionalidades

O projeto consiste em uma classe `HealthProfile` que gerencia os seguintes dados e cálculos:

### Atributos do Paciente
- **Nome e Sobrenome**
- **Sexo**
- **Data de Nascimento** (Dia, Mês e Ano)
- **Altura** (em metros)
- **Peso** (em quilogramas)

### Cálculos Automáticos
A classe fornece métodos para calcular:
1.  **Idade** (em anos).
2.  **Índice de Massa Corporal (IMC)** (Referência: Exercício 2.33).
3.  **Frequência Cardíaca Máxima** (Referência: Exercício 3.16).
4.  **Frequência Cardíaca Alvo** (Intervalo ideal para exercícios).

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **Conceitos:** Programação Orientada a Objetos (POO), Encapsulamento, Construtores.

## 📋 Estrutura da Classe

A classe `HealthProfile` deve conter:
- **Construtor:** Para inicializar os dados do paciente.
- **Setters e Getters:** Para acessar e modificar os atributos.
- **Métodos de Serviço:** Para realizar os cálculos de saúde.

## 📊 Tabela de Referência IMC

O sistema exibe o IMC calculado juntamente com a tabela de classificação oficial:

| Classificação      | IMC            |
| :----------------- | :------------- |
| Abaixo do peso     | Menor que 18.5 |
| Normal             | 18.5 – 24.9    |
| Sobrepeso          | 25 – 29.9      |
| Obesidade          | 30 ou mais     |

## 📚 Referência Acadêmica

Este projeto foi desenvolvido como solução prática para o **Exercício 3.17** do livro:
* **Java: Como Programar** (Paul Deitel & Harvey Deitel).

O exercício propõe a aplicação de conceitos de POO para informatização de registros médicos.

## 📷 Demonstração
Abaixo, um exemplo da execução do programa no terminal:

![Resultado da Execução](execution-result.png)

## ▶️ Como Executar

1. **Clone o repositório** (ou baixe os arquivos).
2. **Compile o código Java:**
   ```bash
   javac HealthProfile.java HealthProfileTest.java
   ```
3. **Execute o programa:**
   ```bash
   java HealthProfileTest
   ```