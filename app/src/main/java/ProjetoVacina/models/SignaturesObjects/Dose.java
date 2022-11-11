package ProjetoVacina.models.SignaturesObjects;

public class Dose {

    private String tipo;

    private Dose(String tipo){
        this.tipo = tipo;
    }

    final static Dose firts = new Dose("Primeira");
    final static Dose second = new Dose("Segunda");
    final static Dose unique = new Dose("Unica");
}
