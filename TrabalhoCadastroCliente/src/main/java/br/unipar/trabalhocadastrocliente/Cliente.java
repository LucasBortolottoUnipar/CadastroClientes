package br.unipar.trabalhocadastrocliente;

import java.util.regex.Pattern;

/**
 *
 * @author Lucas
 */

public class Cliente {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String dataNascimento, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exceptions.InvalidInputException {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exceptions.InvalidInputException {
        for (int i = 0; i < nome.length(); i++) {
            if (!Character.isLetter(nome.charAt(i))) {
                throw new Exceptions.InvalidInputException("Nome deve conter apenas letras.");
            }
        }
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws Exceptions.InvalidDateFormatException {
        if (!Pattern.matches("\\d{2}/\\d{2}/\\d{4}", dataNascimento)) {
            throw new Exceptions.InvalidDateFormatException("Data de nascimento deve estar no formato DD/MM/AAAA.");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exceptions.InvalidPhoneNumberException {
        if (!Pattern.matches("\\d+", telefone)) {
            throw new Exceptions.InvalidPhoneNumberException("Telefone deve possuir apenas números.");
        }
        this.telefone = telefone;
        }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + '}';
    }
    
    
}
