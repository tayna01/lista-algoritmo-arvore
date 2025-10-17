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
}
