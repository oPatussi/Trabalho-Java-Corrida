# Vehicle Race Simulation

Este projeto simula uma corrida de veículos (carros e motos) usando Java. Cada veículo percorre uma pista representada por um array, e a posição de cada veículo é atualizada em cada iteração até que um deles cruze a linha de chegada.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes:

### Main

- **Main.java**: Classe principal que inicializa o programa, exibe o menu de opções e gerencia a interação do usuário.
- **Track.java**: Representa a pista da corrida.
- **Vehicle.java**: Classe base para veículos, contendo atributos e métodos comuns para todos os veículos.
- **Car.java**: Classe que estende `Vehicle` para representar um carro.
- **Moto.java**: Classe que estende `Vehicle` para representar uma moto.
- **VehicleController.java**: Classe para gerenciar os veículos, incluindo métodos para criar, listar e encontrar o veículo mais potente.
- **UserInteract.java**: Classe para interações com o usuário, como exibir menus e coletar entradas.
- **desafio.java**: Código de referência para a impressão da pista de corrida.

## Funcionalidades

### Menu de Opções

O programa exibe um menu com as seguintes opções:

1. Listar todos os veículos da corrida
2. Adicionar um carro à corrida
3. Adicionar uma moto à corrida
4. Remover um veículo
5. Encontrar o carro mais potente
6. Iniciar a corrida
0. Sair

### Veículos

Cada veículo (carro ou moto) possui os seguintes atributos:

- Marca
- Modelo
- Peso
- Potência (cavalos de potência)

### Corrida

A corrida exibirá o modelo do veículo e em qual posição está no momento, atualizando a cada ciclo.

## Como Executar

1. Compile todas as classes Java.
2. Execute a classe `Main`.
3. Siga as instruções exibidas no menu.
