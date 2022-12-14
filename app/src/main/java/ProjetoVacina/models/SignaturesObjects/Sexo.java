package ProjetoVacina.models.SignaturesObjects;

public class Sexo {
    private char tipo;

    private Sexo(char tipo){
        this.tipo = tipo;
    }

    public final static Sexo homem = new Sexo('H');
    public final static Sexo mulher = new Sexo('M');

    public String toString(){
    if(tipo == 'H'){
        return "Masculino";
    }
    if(tipo == 'M'){
        return "Feminino";
    }
    return null;
 }
}