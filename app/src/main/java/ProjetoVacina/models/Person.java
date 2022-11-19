package ProjetoVacina.models;

import ProjetoVacina.models.SignaturesObjects.PriorityGroup;
import ProjetoVacina.models.SignaturesObjects.Sexo;

public class Person {
    private String name;
    private String cpf;
    private Sexo sex;
    private PriorityGroup priorityGroup;
    private boolean isVaccinated = false;
    public Person(String name, String cpf, Sexo sex, PriorityGroup priorityGroup){
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.priorityGroup = priorityGroup;
    }

    public String getCpf(){
        return this.cpf;
    }
    public String getName(){
        return this.name;
    }

    public boolean getIsVaccined(){
        return this.isVaccinated;
    }

    public void setIsVaccinated(boolean isVaccinated){
        this.isVaccinated = isVaccinated;
    }
    
    public void print(){
        System.out.println("Nome: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Sexo: " + sex.toString());
        System.out.println("Grupo de Prioridade: " + priorityGroup.toString());
        System.out.println("========================");
    }
}

