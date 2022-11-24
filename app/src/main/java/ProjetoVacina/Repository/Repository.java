package ProjetoVacina.Repository;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import ProjetoVacina.models.Person;
import ProjetoVacina.models.VaccinationRecord;
import ProjetoVacina.models.SignaturesObjects.Dose;

public class Repository {
    
    private LinkedList<Person> people = new LinkedList<Person>();
    private LinkedList<VaccinationRecord> vaccinationRecords = new LinkedList<VaccinationRecord>();

    public LinkedList<Person> getPeopleList(){
        return this.people;
    }

    public LinkedList<VaccinationRecord> getVaccinationList(){
        return this.vaccinationRecords;
    }

    public void searchRegisterByCPF(Scanner input){
        input.nextLine();
        System.out.println("Digite o CPF a ser pesquisado");
        String cpfSearch = input.nextLine();
        System.out.println(this.vaccinationRecords.isEmpty());
        Iterator<VaccinationRecord> vaccinationIterator = this.vaccinationRecords.iterator();
        boolean isEmpty = true;

        while(vaccinationIterator.hasNext()){
            VaccinationRecord vaccinationTemp = vaccinationIterator.next();
            
            if(vaccinationTemp.getPerson().getCpf().equals(cpfSearch)){
                vaccinationTemp.print();
                isEmpty = false;
            }
        }
        if(isEmpty){
            System.out.println("Nenhum registro para o CPF pesquisado");
        }
    }

    public void showAllRecords(){
        Iterator<VaccinationRecord> vaccinationIterator = this.vaccinationRecords.iterator();
        int cont = 1;

        while(vaccinationIterator.hasNext()){
            System.out.printf("REGISTRO %d \n", cont);
            vaccinationIterator.next().print();
            cont++;
        }
    }

    public void showPeoplewithoutVaccine(){
        Iterator<Person> peopleIterator = this.people.iterator();
        boolean isEmpty = true;

        while(peopleIterator.hasNext()){
            Person personTemp = peopleIterator.next();

            if(!checkIfPersonHaveRegister(personTemp)){
                personTemp.print();
                isEmpty = false;
            }
        }

        if(isEmpty == true){
            System.out.println("Todas as pessoas cadastradas foram vacinadas!");
        }
    }

    private boolean checkIfPersonHaveRegister(Person person){
        Iterator<VaccinationRecord> vaccinationIterator = this.vaccinationRecords.iterator();
            
            while(vaccinationIterator.hasNext()){
                VaccinationRecord vaccinationTemp = vaccinationIterator.next();
                if(vaccinationTemp.getPerson().getCpf().equals(person.getCpf())){
                    return true;
                }

            }
        return false;
    }

    public int getQuantPersonsFullVaccinated(){
        int quantPersons = 0;
        Iterator<Person> peopleIterator = this.people.iterator();

        while(peopleIterator.hasNext()){
            Person personTemp = peopleIterator.next();
            if(personHaveFinishedVaccination(personTemp)){
                quantPersons++;
            };

        }

        return quantPersons;
    }

    private boolean personHaveFinishedVaccination(Person person){
        Iterator<VaccinationRecord> vaccinationIterator = this.vaccinationRecords.iterator();

        while(vaccinationIterator.hasNext()){
            VaccinationRecord vaccinationTemp = vaccinationIterator.next();
            if(isFinishedDose(vaccinationTemp, person) ){
                return true;
            }
        }
        return false;
    }

    private boolean isFinishedDose(VaccinationRecord vaccinationRecord, Person person){
        boolean isThePerson = vaccinationRecord.getPerson().getCpf().equals(person.getCpf());
        boolean haveFinishedDose = (vaccinationRecord.getDose() == Dose.unique || vaccinationRecord.getDose() == Dose.second);
        return isThePerson && haveFinishedDose;
    }
}
