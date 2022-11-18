package ProjetoVacina.models.SignaturesObjects;

public class Manufacturer {
    private String name;
    private int quantDoses; 

    private Manufacturer(String name, int quantDoses){
        this.name = name;
        this.quantDoses = quantDoses;
    }

    public final static Manufacturer sinovac = new Manufacturer("Sinovac", 2);
    public final static Manufacturer astraZeneca = new Manufacturer("AstraZeneca", 2);
    public final static Manufacturer pfizer = new Manufacturer("Pfizer", 2);
    public final static Manufacturer Janssen = new Manufacturer("Janssen", 1);

    public int getDoses(){
        return this.quantDoses;
    }

    public String getName(){
        return this.name;
    }
}
