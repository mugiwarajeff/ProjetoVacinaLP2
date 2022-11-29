package ProjetoVacina.models.SignaturesObjects;

public class Dose {

    private String tipo;

    private Dose(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    public final static Dose firts = new Dose("Primeira");
    public final static Dose second = new Dose("Segunda");
    public final static Dose unique = new Dose("Unica");

    public static boolean compareDoseTypes(Dose dose1, Dose dose2){
        return dose1 == dose2;
    }

    @Override
    public String toString() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
