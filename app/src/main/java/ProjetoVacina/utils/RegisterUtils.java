package ProjetoVacina.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import ProjetoVacina.models.Person;
import ProjetoVacina.models.VaccinationRecord;
import ProjetoVacina.models.SignaturesObjects.Dose;
import ProjetoVacina.models.SignaturesObjects.Manufacturer;

public class RegisterUtils {
    public static void recordRegister(LinkedList<Person> people, LinkedList<VaccinationRecord> vaccinationRecords, Scanner input){
        System.out.println("Registrar novo registro");
        String cpfOfPerson;
        Person person=null;
        Date date = new Date();
        Manufacturer manufacturer;
        Dose dose=null;
        int option = 0;
        
        boolean cpfSearchError = true;
        while(cpfSearchError){
            System.out.println("Digite o CPF da pessoa que deseja vacinar");
            cpfOfPerson = input.nextLine();
            person = searchPerson(people, cpfOfPerson);

            if(person != null){
                cpfSearchError = false;
                System.out.printf("Pessoa selecionada: %s \n", person.getName());
            }else{
                System.out.println("Valor digitado é invalido, tente novamente!");
            }

        }
        if(isFullVaccinated(person, vaccinationRecords)){
            System.out.println("Pessoa ja está totalmente vacinada");
        }else{
            manufacturer = haveOneDose(person, vaccinationRecords);
            if(manufacturer == null){
                boolean manufacturerError = true;
                while(manufacturerError){
                    showManufacturesList();
                    option = input.nextInt();
                    manufacturer = selectManufacture(option);
                   
                    if(manufacturer != null){
                       manufacturerError = false;
                       System.out.printf("Fornecedor selecionado: %s\n", manufacturer.getName());
                    }else{
                        System.out.println("Valor invalido, selecione novamente");
                    }
                }

                dose = testDose(option);
                System.out.println("Primeira dose aplicada");
                VaccinationRecord vacinationRecord = new VaccinationRecord(person, date, manufacturer, dose);
                vaccinationRecords.add(vacinationRecord);
                
            }else{
                dose = Dose.second;
                System.out.println("Segunda dose aplicada");
                VaccinationRecord vacinationRecord = new VaccinationRecord(person, date, manufacturer, dose);
                vaccinationRecords.add(vacinationRecord);
            }
        }
    }

    private static Person searchPerson(LinkedList<Person> people, String cpfSearch){
        Iterator<Person> personIterator = people.iterator();

        while(personIterator.hasNext()){
            Person personTemp = personIterator.next();
            if(personTemp.getCpf().equals(cpfSearch)){
                return personTemp;
            }
        }

        return null;
    }

    private static boolean isFullVaccinated(Person person, LinkedList<VaccinationRecord> vaccinationRecords){
        Iterator<VaccinationRecord> vaccinationIterator = vaccinationRecords.iterator();

        while(vaccinationIterator.hasNext()){
            VaccinationRecord vaccinationTemp = vaccinationIterator.next();

           if(vaccinationTemp.getPerson().equals(person)){
                if(vaccinationTemp.isFullVaccinated()) 
                return true;
            }
        }

        return false;
    } 

    private static Manufacturer haveOneDose(Person person, LinkedList<VaccinationRecord> vaccinationRecords){
        Iterator<VaccinationRecord> vaccinationIterator = vaccinationRecords.iterator();

        while(vaccinationIterator.hasNext()){
            VaccinationRecord vaccinationTemp = vaccinationIterator.next();

           if(vaccinationTemp.getPerson().equals(person)){
                return vaccinationTemp.getManufacture();
            }
        }
        return null;
    }

    private static void showManufacturesList(){
        System.out.println("Escolha uma opçao de vacina: ");
        System.out.println("1 - Sinovac");
        System.out.println("2 - AstraZenece");
        System.out.println("3 - Pfizer");
        System.out.println("4 - Janssen");
    }

    private static Manufacturer selectManufacture(int option){
        switch(option){
            case 1:
                return Manufacturer.sinovac;
            case 2:
                return Manufacturer.astraZeneca;
            case 3:
                return Manufacturer.pfizer;
            case 4:
                return Manufacturer.Janssen;
            default:
                return null;
        }
    }
    private static Dose testDose(int option){
        switch(option){
            case 1:
                return Dose.firts;
            case 2:
                return Dose.firts;
            case 3: 
                return Dose.firts;
            case 4:
                return Dose.unique;
            default:
                return null;
        }
    }
}
