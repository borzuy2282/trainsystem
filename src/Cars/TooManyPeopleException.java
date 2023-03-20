package Cars;

public class TooManyPeopleException extends Exception {
    TooManyPeopleException(String errorMessage){
        super(errorMessage);
    }
}
