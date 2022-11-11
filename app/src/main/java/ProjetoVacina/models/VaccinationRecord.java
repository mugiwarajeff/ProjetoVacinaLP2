package ProjetoVacina.models;

import java.util.Date;

import ProjetoVacina.models.interfaces.Dose;

public class VaccinationRecord {
    Person person;
    Date applicationDate;
    Manufacturer manufacturer;
    String dose;

    VaccinationRecord(Person person, Date applicationDate, Manufacturer manufacture, String dose){
        this.person = person;
        this.applicationDate = applicationDate;
        this.manufacturer = manufacture; 
        this.dose = dose;
    }

}