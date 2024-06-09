package br.unipar.trabalhocadastrocliente;

import java.util.Scanner;

public class Lista<TipoCliente> {
    private Nodo<TipoCliente> primeiro;
    private Nodo<TipoCliente> ultimo;
    private int tamanho;
    private final int capacidadeMaxima;

    public Lista(int capacidadeMaxima) {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
        this.capacidadeMaxima = capacidadeMaxima;
    }
     
    public void adicionar(TipoCliente cliente) throws Exceptions.DuplicateCodeException{
        if (tamanho >= capacidadeMaxima) {
            throw new Exceptions.ListaCheiaException("A lista está cheia. Não é possível adicionar mais clientes.");
        }
        Cliente novoCliente = (Cliente) cliente;
        if (codigoExiste(novoCliente.getCodigo())) {
            throw new Exceptions.DuplicateCodeException("Código já existe. Não foi possível adicionar este cliente.");
        }

        Nodo<TipoCliente> novoNodo = new Nodo<>(cliente);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.setProximo(novoNodo);
            novoNodo.setAnterior(ultimo);
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public boolean codigoExiste(int codigo) {
        Nodo<TipoCliente> atual = primeiro;
        while (atual != null) {
            Cliente cliente = (Cliente) atual.getCliente();
            if (cliente.getCodigo() == codigo) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void remover(int codigo) {
        if (tamanho == 0) {
            throw new Exceptions.ListaVaziaException("A lista está vazia. Não é possível remover clientes.");
        }
        Nodo<TipoCliente> atual = primeiro;
        boolean encontrado = false;
        while (atual != null) {
        Cliente cliente = (Cliente) atual.getCliente();
            if (cliente.getCodigo() == codigo) {
                encontrado = true;
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                } else {
                    primeiro = atual.getProximo();
                }

                if (atual.getProximo() != null) {
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    ultimo = atual.getAnterior();
                }

                tamanho--;
                return; 
            }
                atual = atual.getProximo();
            }
            if (!encontrado) {
                System.out.println("Cliente não encontrado.");
        }
    }

    public Nodo<TipoCliente> buscar(int codigo) {
        Nodo<TipoCliente> atual = primeiro;
        while (atual != null) {
            Cliente cliente = (Cliente) atual.getCliente();
            if (cliente.getCodigo() == codigo) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void exibirTodos() {
        if (tamanho == 0) {
            throw new Exceptions.ListaVaziaException("A lista está vazia. Não há clientes para exibir.");
        }
        Nodo<TipoCliente> atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getCliente());
            atual = atual.getProximo();
        }
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public void atualizar(int codigo, Scanner s, int opcaoAtt) {
        Nodo<TipoCliente> nodo = buscar(codigo);
        if (nodo != null) {
            Cliente cliente = (Cliente) nodo.getCliente();
        System.out.println("Atualizar informações do cliente (código: " + codigo + "):");
        switch(opcaoAtt) {
            case 1:
                System.out.println("Informe o novo nome do cliente: ");
                try {
                    cliente.setNome(s.nextLine());
                } catch (Exceptions.InvalidInputException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("Informe a nova data de nascimento do cliente: ");
                try {
                    cliente.setDataNascimento(s.nextLine());
                } catch (Exceptions.InvalidDateFormatException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 3:
                System.out.println("Informe o novo telefone do cliente: ");
                try {
                    cliente.setTelefone(s.nextLine());
                } catch (Exceptions.InvalidPhoneNumberException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
        }
    }
}
