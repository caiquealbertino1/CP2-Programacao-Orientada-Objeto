# FiapDelivery — Check Point 2

## Sobre o Projeto

Atividade prática de refatoração de um sistema legado de logística chamado **FiapDelivery**.

O código original foi escrito com diversas violações de boas práticas de Engenharia de Software. O objetivo foi diagnosticar cada problema e reescrever a solução aplicando os pilares da **Orientação a Objetos**.

---

## Problemas Identificados no Código Legado

| # | Problema | Solução Aplicada |
|---|----------|-----------------|
| 1 | Nomes sem sentido (`pl`, `cap`, `p`, `s`) | Renomeados para `placa`, `capacidadeKg`, `pesoKg`, `status` |
| 2 | Todos os atributos `public` | Atributos `private` com getters públicos |
| 3 | Código duplicado em `caminhao` e `moto` | Classe abstrata `Veiculo` — `Caminhao` e `Moto` herdam dela |
| 4 | `Rota` acoplada apenas ao `Caminhao` | `Rota` referencia `Veiculo` (polimorfismo) |
| 5 | Sem validação (`cap = -500` era aceito) | Construtores com `IllegalArgumentException` |
| 6 | Sem documentação | Javadoc completo em todas as classes |

---

## Arquitetura da Solução

```
         ┌──────────────────────────┐
         │       «abstract»         │
         │         Veiculo          │
         │ - placa : String         │
         │ - capacidadeKg : double  │
         └────────────┬─────────────┘
              ┌───────┴───────┐
       ┌──────┴──────┐  ┌─────┴──────┐
       │   Caminhao  │  │    Moto    │
       │ - eixos:int │  │ - bau:bool │
       └─────────────┘  └────────────┘

    ┌────────────────────────────────┐
    │             Rota               │
    │ - pacote  : Pacote             │
    │ - veiculo : Veiculo  ←(polim.) │
    │ + iniciarEntrega() : void      │
    └────────────────────────────────┘

    ┌────────────────────────────────┐
    │            Pacote              │
    │ - codigoRastreio : String      │
    │ - pesoKg : double              │
    │ - status : String              │
    │ + atualizarStatus(s) : void    │
    └────────────────────────────────┘
```

---

## Estrutura do Repositório

```
FiapDelivery/
├── Veiculo.java        # Classe abstrata — base de todos os veículos
├── Caminhao.java       # Herda Veiculo — adiciona número de eixos
├── Moto.java           # Herda Veiculo — adiciona informação de baú
├── Pacote.java         # Representa o pacote a ser entregue
├── Rota.java           # Associa Pacote + Veiculo (polimorfismo)
├── Principal.java      # Classe main — demonstra o funcionamento
└── diagrama_uml.png    # Diagrama de classes exportado do Astah
```

---

## Como Executar

### Pré-requisitos
- Java JDK 11 ou superior

### Compilar
```bash
javac *.java
```

### Rodar
```bash
java Principal
```

### Saída esperada
```
=== Iniciando Entrega ===
Pacote : Pacote [código=BR999, peso=10.5kg, status=Em trânsito]
Veículo: Caminhão [placa=ABC1234, capacidade=5000.0kg, eixos=6]
========================

=== Iniciando Entrega ===
Pacote : Pacote [código=SP001, peso=2.0kg, status=Em trânsito]
Veículo: Moto [placa=XYZ5678, capacidade=30.0kg, baú=sim]
========================
```

---

## Conceitos Aplicados

**Encapsulamento**  
Todos os atributos são `private`. Nenhuma classe externa acessa ou modifica dados diretamente — apenas pelos métodos públicos definidos.

**Herança**  
`Caminhao` e `Moto` estendem a classe abstrata `Veiculo`, reaproveitando `placa` e `capacidadeKg` sem duplicar código.

**Associação (Polimorfismo)**  
`Rota` possui uma referência do tipo `Veiculo` — aceita qualquer subtipo (`Caminhao`, `Moto`, ou futuros veículos) sem necessidade de alteração.

**Construtores com Validação**  
Dados inválidos (placa vazia, capacidade negativa, peso zero) são rejeitados imediatamente via `IllegalArgumentException`, impedindo objetos em estado inconsistente.
