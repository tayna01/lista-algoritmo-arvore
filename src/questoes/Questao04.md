# 04 - Identifique se uma árvore dada (desenho ou código) é uma árvore de busca binária (BST).

Para identificar se uma árvore é BST, podemos validar algumas regrinhas: 

- Todos os valores na subárvore esquerda são menores que o valor do nó.

- Todos os valores na subárvore direita são maiores que o valor do nó.

- A árvore é binária, ou seja, cada nó tem no máximo dois filhos.

## Identificando: 

        10
       /  \
      5    15
     / \
    2   7


- 5 < 10 → ok
- 15 > 10 → ok
- 2 < 5 → ok
- 7 > 5 → ok

- Resultado: é uma busca binária (BST).