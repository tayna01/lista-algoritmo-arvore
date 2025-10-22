package principal;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(12);
        arvore.inserir(18);

        System.out.println("=== Estrutura da Árvore ===");
        arvore.imprimirEstrutura();

        System.out.println("\n=== Testes de Percursos ===");
        System.out.print("Pré-Ordem: ");
        arvore.percorrerPreOrdem();

        System.out.print("Em-Ordem: ");
        arvore.percorrerEmOrdem();

        System.out.print("Pós-Ordem: ");
        arvore.percorrerPosOrdem();

        System.out.print("Em Largura: ");
        arvore.percorrerEmLargura();

        System.out.println("\n=== Outras Informações ===");
        System.out.println("Árvore está vazia? " + arvore.estaVazia());
        System.out.println("Total de nós: " + arvore.contarNos()); // 7
        System.out.println("Altura da árvore: " + arvore.altura()); // 3

        System.out.print("\nNós folhas: ");
        arvore.imprimirFolhas();

        System.out.println("\n=== Fim dos Testes ===");
    }
}