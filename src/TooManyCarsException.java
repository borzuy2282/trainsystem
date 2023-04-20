public class TooManyCarsException extends Exception {
    TooManyCarsException(String errorMessage){
        super("Problem with adding cars!");
    }
}
