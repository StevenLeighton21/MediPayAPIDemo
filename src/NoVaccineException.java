/*
 This class is not really standard, but intended as a demonstration of
 returning a custom exception. In this case, it is used to clearly show that
 there has been an attempt to process a vaccination transaction without any vaccinations.
 */

public class NoVaccineException extends Exception {
    public NoVaccineException(String message) {
        super(message);
    }
}
