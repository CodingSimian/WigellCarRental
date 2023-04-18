package ostrand.wigellcarrental.custom.exception;




public class BusinessException extends RuntimeException{

    private int status;


   public BusinessException(String message,int status){
       super(message);
       this.status = status;
   }

    public BusinessException() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
