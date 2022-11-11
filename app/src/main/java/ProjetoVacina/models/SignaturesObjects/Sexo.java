package ProjetoVacina.models.SignaturesObjects;

public class Sexo {
    private char tipo;

    private Sexo(char tipo){
        this.tipo = tipo;
    }

    final static Sexo homem = new Sexo('H');
    final static Sexo mulher = new Sexo('M');
}
