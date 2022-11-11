package ProjetoVacina.models;

import ProjetoVacina.models.interfaces.PriorityGroup;
import ProjetoVacina.models.interfaces.Sexo;

public class Person {
    private String name;
    private String cpf;
    private char sex;
    private String priorityGroup;

    public Person(String name, String cpf, char sex, String priorityGroup){
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.priorityGroup = priorityGroup;
    }
}
