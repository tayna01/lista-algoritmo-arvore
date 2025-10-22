package principal;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserirValor(int valor){
        raiz = inserirValorRecursivo(raiz, valor);
    }

    private No inserirValorRecursivo(No atual, int valor){

        if(atual == null){
            return new No(valor);
        }

        if(valor < atual.valor){
            atual.esquerda = inserirValorRecursivo(atual.esquerda, valor);
        }
        else{
            atual.direita = inserirValorRecursivo(atual.direita, valor);
        }

        return atual;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int contarNos(){
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No atual){
        if(atual == null) return 0;

        return 1 + contarNosRecursivo(atual.esquerda) + contarNosRecursivo(atual.direita);
    }

    public int retornaAltura(){
        return retornaAlturaRecursivo(raiz);
    }

    private int retornaAlturaRecursivo(No atual){
        if(atual == null) return 0;


        int alturaEsquerda = retornaAlturaRecursivo(atual.esquerda);
        int alturaDireita = retornaAlturaRecursivo(atual.direita);


        return 1 + Math.max(alturaDireita, alturaEsquerda);
    }

    public void preOrdem(){
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(No no){
        if(no != null){
            System.out.print(no.valor + " ");
            preOrdemRec(no.esquerda);
            preOrdemRec(no.direita);
        }
    }

    public void emOrdem() {
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

    public void posOrdem() {
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

    public void emLargura() {
        if (raiz == null) return;

        LinkedList<Object> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = (No) fila.remove();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        System.out.println();
    }
}
