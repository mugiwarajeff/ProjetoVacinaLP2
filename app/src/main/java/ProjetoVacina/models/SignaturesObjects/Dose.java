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
}
