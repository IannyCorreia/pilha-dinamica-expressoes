public class Pilha {
    private No topo;
    public Pilha(){
        this.topo = null;
    }
    public void empilhar(char dado){
        No novoNo = new No(dado);
        if(topo != null){
            novoNo.proximo = topo;
        }
        topo = novoNo;
    }
    public char desempilhar(){
        if(isEmpty()){
            throw new RuntimeException("A pilha está vazia. ");
        }
        else{
            char dado = topo.dado;
            topo = topo.proximo;
            return dado;
        }

    }
    public boolean isEmpty(){
        return topo == null;
    }
}
