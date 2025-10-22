package principal;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);

        if (valor < atual.valor)
            atual.esquerda = inserirRec(atual.esquerda, valor);
        else
            atual.direita = inserirRec(atual.direita, valor);

        return atual;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int contarNos() {
        return contarNosRec(raiz);
    }

    private int contarNosRec(No atual) {
        if (atual == null) return 0;
        return 1 + contarNosRec(atual.esquerda) + contarNosRec(atual.direita);
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No atual) {
        if (atual == null) return 0;
        int alturaEsq = alturaRec(atual.esquerda);
        int alturaDir = alturaRec(atual.direita);
        return 1 + Math.max(alturaEsq, alturaDir);
    }

    public void imprimirEstrutura() {
        imprimirEstruturaRec(raiz, 0);
    }

    private void imprimirEstruturaRec(No no, int nivel) {
        if (no != null) {
            imprimirEstruturaRec(no.direita, nivel + 1);
            System.out.println("    ".repeat(nivel) + no.valor);
            imprimirEstruturaRec(no.esquerda, nivel + 1);
        }
    }

    public void percorrerPreOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemRec(no.esquerda);
            preOrdemRec(no.direita);
        }
    }

    public void percorrerEmOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }

    public void percorrerPosOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(No no) {
        if (no != null) {
            posOrdemRec(no.esquerda);
            posOrdemRec(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public void percorrerEmLargura() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.remove();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        System.out.println();
    }
    
    public void imprimirFolhas() {
        imprimirFolhasRec(raiz);
        System.out.println();
    }

    private void imprimirFolhasRec(No no) {
        if (no == null) return;

        if (no.esquerda == null && no.direita == null) {
            System.out.print(no.valor + " ");
            return;
        }

        imprimirFolhasRec(no.esquerda);
        imprimirFolhasRec(no.direita);
    }
}