package ProjetoVacina.models;

import java.util.Date;

import ProjetoVacina.models.interfaces.Dose;

public class VaccinationRecord {
    Person person;
    Date applicationDate;
    String manufacturer;
    Dose dose;

    VaccinationRecord(Person person, Date applicationDate, String manufacture, Dose dose){
        this.person = person;
        this.applicationDate = applicationDate;
        this.manufacturer = manufacture; 
        this.dose = dose;
    }

}