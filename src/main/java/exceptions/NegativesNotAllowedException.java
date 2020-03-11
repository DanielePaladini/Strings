package exceptions;

public class NegativesNotAllowedException extends Exception {

    public NegativesNotAllowedException(String negativeNumbers){
        super("negatives not allowed: "+ negativeNumbers);
    }
}
