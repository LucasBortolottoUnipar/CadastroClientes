package br.unipar.trabalhocadastrocliente;

public class Exceptions {

    public static class ListaCheiaException extends RuntimeException {
        public ListaCheiaException(String message) {
            super(message);
        }
    }

    public static class ListaVaziaException extends RuntimeException {
        public ListaVaziaException(String message) {
            super(message);
        }
    }
    
    public static class InvalidDateFormatException extends Exception {
        public InvalidDateFormatException(String message) {
            super(message);
        }
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
    
    public class InvalidStringException extends Exception {
        public InvalidStringException(String message) {
            super(message);
        }
    }
    
    public static class InvalidPhoneNumberException extends Exception {
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }
    
    public static class InvalidCodeFormatException extends Exception {
        public InvalidCodeFormatException(String message) {
            super(message);
        }
    }
    
    public static class DuplicateCodeException extends Exception {
        public DuplicateCodeException(String message) {
            super(message);
        }
    }

}
