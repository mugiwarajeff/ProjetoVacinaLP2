package ProjetoVacina.models;

import java.util.Date;

import ProjetoVacina.models.SignaturesObjects.Dose;
import ProjetoVacina.models.SignaturesObjects.Manufacturer;

public class VaccinationRecord {
    Person person;
    Date applicationDate;
    Manufacturer manufacturer;
    Dose dose;

    VaccinationRecord(Person person, Date applicationDate, Manufacturer manufacture, Dose dose){
        this.person = person;
        this.applicationDate = applicationDate;
        this.manufacturer = manufacture; 
        this.dose = dose;
    }

}