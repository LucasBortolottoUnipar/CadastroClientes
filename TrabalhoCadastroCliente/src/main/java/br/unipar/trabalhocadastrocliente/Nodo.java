package br.unipar.trabalhocadastrocliente;

public class Nodo<TipoCliente> {
    
    private TipoCliente cliente;
    private Nodo<TipoCliente> anterior;
    private Nodo<TipoCliente> proximo;
    
     public Nodo(TipoCliente cliente) {
        this.cliente = cliente;
    }
    
    public TipoCliente getCliente(){
        return cliente;
    }    
    
    public Nodo<TipoCliente> getAnterior(){
        return anterior;
    } 
    
    public Nodo<TipoCliente> getProximo(){
        return proximo;
    }
    
    public void setAnterior(Nodo<TipoCliente> anterior){
        this.anterior = anterior;
    }
    
    public void setProximo(Nodo<TipoCliente> proximo){
        this.proximo = proximo;
    }
    
    
}
