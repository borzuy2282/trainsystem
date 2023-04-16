package Cars;

public class TooManyPeopleException extends Exception {
    public TooManyPeopleException(String errorMessage){
        super(errorMessage);
    }
}
