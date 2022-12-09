package ProjetoVacina.models;

import java.io.Serializable;

import ProjetoVacina.models.SignaturesObjects.PriorityGroup;
import ProjetoVacina.models.SignaturesObjects.Sexo;

public class Person implements Serializable{
    private String name;
    private String cpf;
    private Sexo sex;
    private PriorityGroup priorityGroup;
    private boolean isVaccinated;

    public Person(String name, String cpf, Sexo sex, PriorityGroup priorityGroup){
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.priorityGroup = priorityGroup;
        isVaccinated = false;
    }

    public boolean getIsVaccinated(){
        return this.isVaccinated;
    }

    public void setIsVaccinated(Boolean state){
        this.isVaccinated = state;
    }

    public String getCpf(){
        return this.cpf;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSex(Sexo sex) {
        this.sex = sex;
    }

    public void setPriorityGroup(PriorityGroup priorityGroup) {
        this.priorityGroup = priorityGroup;
    }

    public PriorityGroup getPriorityGroup(){
        return this.priorityGroup;
    }
    
    public void print(){
        System.out.println("Nome: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Sexo: " + sex.toString());
        System.out.println("Grupo de Prioridade: " + priorityGroup.toString());
        System.out.println("========================");
    }
}

