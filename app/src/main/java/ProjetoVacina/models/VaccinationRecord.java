package ProjetoVacina.models;

import java.util.Date;

import ProjetoVacina.models.SignaturesObjects.Dose;
import ProjetoVacina.models.SignaturesObjects.Manufacturer;

public class VaccinationRecord {
    Person person;
    Date applicationDate;
    Manufacturer manufacturer;
    Dose dose;

    public VaccinationRecord(Person person, Date applicationDate, Manufacturer manufacture, Dose dose){
        this.person = person;
        this.applicationDate = applicationDate;
        this.manufacturer = manufacture; 
        this.dose = dose;
    }

    public Dose getDose(){
        return this.dose;
    }

    public Person getPerson(){
        return this.person;
    }

    public Manufacturer getManufacture(){
        return this.manufacturer;
    }

    public boolean isFullVaccinated(){
        int dosetemp = (dose.getTipo().equals("Primeira") || dose.getTipo().equals("Unica")) ? 1 : 2;
        return dosetemp == manufacturer.getDoses();
    }

    public void Print(){
        person.print();
        System.out.println("Data = " + applicationDate + " Empresa = "+ manufacturer +" dose = " + dose);
    }

}