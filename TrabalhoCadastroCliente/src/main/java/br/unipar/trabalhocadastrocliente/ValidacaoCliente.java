package br.unipar.trabalhocadastrocliente;

public class ValidacaoCliente {
    public static int validaCodigo(String valor) throws Exceptions.InvalidInputException{
        try{
            int codigo = Integer.parseInt(valor);
            if (codigo<0){
                throw new Exceptions.InvalidInputException("O codigo deve ser maior que 0.");
            }
            return codigo;
        }
        catch(NumberFormatException n){
            throw new Exceptions.InvalidInputException("O codigo deve ser um numero.");
        }
    }
}
