package ProjetoVacina.models.interfaces;

import ProjetoVacina.models.Manufacturer;

public interface Manufacturers {
    final static Manufacturer sinovac = new Manufacturer("Sinovac", 2);
    final static Manufacturer astraZeneca = new Manufacturer("AstraZeneca", 2);
    final static Manufacturer pfizer = new Manufacturer("Pfizer", 2);
    final static Manufacturer Janssen = new Manufacturer("Janssen", 1);
}   
