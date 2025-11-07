package principal;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    //Questão 06
    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No atual, int valor) {
        if (atual == null) return new No(valor);

        if (valor < atual.valor)
            atual.esquerda = inserir(atual.esquerda, valor);
        else
            atual.direita = inserir(atual.direita, valor);

        return atual;
    }

    //Questão 07
    public boolean estaVazia() {
        return raiz == null;
    }

    //Questão 08
    public int contarNos() {
        return contarNosRec(raiz);
    }

    private int contarNosRec(No atual) {
        if (atual == null) return 0;
        return 1 + contarNosRec(atual.esquerda) + contarNosRec(atual.direita);
    }

    //Questão 09
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

    //Questão 10
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

    //Questão 11
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

    //Questão 12
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

    //Questão 13
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

    //Questão 14
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

    //Questão 15
    public boolean buscarElemento(int valor) {
        return buscarElementoRec(raiz, valor);
    }

    private boolean buscarElementoRec(No atual, int valor) {
        if (atual == null) return false;

        if (atual.valor == valor) return true;

        if (valor < atual.valor) {
            return buscarElementoRec(atual.esquerda, valor);
        } else {
            return buscarElementoRec(atual.direita, valor);
        }
    }
}