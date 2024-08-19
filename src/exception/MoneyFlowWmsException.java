package exception;

public class MoneyFlowWmsException extends RuntimeException{

  public MoneyFlowWmsException() {
    super();
  }

  public MoneyFlowWmsException(String message) {
    super(message);
  }

  public MoneyFlowWmsException(String message, Throwable cause) {
    super(message, cause);
  }

  public MoneyFlowWmsException(Throwable cause) {
    super(cause);
  }
}
