public class Excepciones extends Exception{
    private int codigoError;

    public Excepciones(int codigoError) {
        super();
        setCodigoError(codigoError);
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    @Override
    public String getMessage() {
        String txt = "";
        switch (getCodigoError()){
            case 1:
                txt = "Error, el numero que has introducido no puede ser un nif";
                break;
            case 2:
                txt = "Contraseña incorrecta";
                break;
            default:
                txt = "Error no contemplado";
                break;
        }
        return txt;
    }
}
