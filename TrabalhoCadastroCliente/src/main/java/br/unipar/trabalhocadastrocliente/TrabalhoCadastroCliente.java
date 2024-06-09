package br.unipar.trabalhocadastrocliente;

import java.util.Scanner;

public class TrabalhoCadastroCliente {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Lista<Cliente> listaClientes = new Lista<>(10);
        int opcao;
        boolean valido = false;

        do {
            System.out.println("1. Gravar novo Cadastro");
            System.out.println("2. Excluir Cadastro");
            System.out.println("3. Alterar Cadastro");
            System.out.println("4. Recuperar e exibir cadastro");
            System.out.println("5. Exibir todos os cadastros");
            System.out.println("6. Sair");
            opcao = s.nextInt();
            s.nextLine();  
            
            switch (opcao) {
                case 1:
                    
                    Cliente c = new Cliente();
                        do{
                            System.out.println("Informe o código do cliente: ");
                            String codigo = s.nextLine();
                            try{
                                c.setCodigo(ValidacaoCliente.validaCodigo(codigo));
                                valido = true;
                            }
                            catch(Exception e){
                                System.out.println("Erro: " + e.getMessage());
                                valido = false;
                            }
                        }
                        
                        while(valido==false);
                        
                        do{
                            System.out.println("Informe o nome do cliente: ");
                            String nome = s.nextLine();
                            try{
                                c.setNome(nome);
                                valido = true;
                            }
                            catch(Exception e){
                                System.out.println("Erro: " + e.getMessage());
                                valido = false;
                            }
                        }
                        
                        while(valido==false);
                        
                        do{
                            System.out.println("Informe a data de nascimento do cliente (DD/MM/AAAA): ");
                            String dataNascimento = s.nextLine();
                            try{
                                c.setDataNascimento(dataNascimento);
                                valido = true;
                            }
                            catch(Exception e){
                                System.out.println("Erro: " + e.getMessage());
                                valido = false;
                            }
                        }
                        
                        while(valido==false);
                        
                        do{
                            System.out.println("Informe o telefone do cliente: ");
                            String telefone = s.nextLine();
                            try{
                                c.setTelefone(telefone);
                                valido = true;
                            }
                        catch(Exception e){
                            System.out.println("Erro: " + e.getMessage());
                                valido = false;
                            }
                        }
                        
                        while(valido==false);
                        
                        try {
                            listaClientes.adicionar(c);
                        }
                        
                        catch(Exception e){
                            System.out.println("Erro: " + e.getMessage());
                            }
                        break;

                case 2:
                    try {
                        System.out.println("Informe o código do cliente: ");
                        int codigo = s.nextInt();
                        listaClientes.remover(codigo);
                    } catch (Exceptions.ListaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Informe o código do cliente: ");
                        int codigo = s.nextInt();
                        s.nextLine();
                        System.out.println("O que deseja alterar?\n"
                                + "1- Nome\n"
                                + "2-Data de Nascimento\n"
                                + "3- Telefone ");
                        int opcaoAtt = s.nextInt();
                        s.nextLine();
                        listaClientes.atualizar(codigo, s, opcaoAtt);
                        
                    } catch (Exceptions.ListaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Informe o código do cliente: ");
                        int codigo = s.nextInt();
                        Nodo<Cliente> nodo = listaClientes.buscar(codigo);
                        if (nodo != null) {
                            System.out.println(nodo.getCliente());
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                    } catch (Exceptions.ListaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        listaClientes.exibirTodos();
                    } catch (Exceptions.ListaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Fechando o Sistema");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }
}
