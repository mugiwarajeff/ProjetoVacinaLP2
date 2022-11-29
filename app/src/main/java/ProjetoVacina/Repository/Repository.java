package ProjetoVacina.Repository;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import ProjetoVacina.models.Person;
import ProjetoVacina.models.VaccinationRecord;
import ProjetoVacina.models.SignaturesObjects.Dose;
import ProjetoVacina.models.SignaturesObjects.Manufacturer;
import ProjetoVacina.models.SignaturesObjects.PriorityGroup;
import ProjetoVacina.models.SignaturesObjects.Sexo;

public class Repository {
    
    private LinkedList<Person> people = new LinkedList<Person>();
    private LinkedList<VaccinationRecord> vaccinationRecords = new LinkedList<VaccinationRecord>();

    public void readBd(){
        File file = new File("BD.txt");
        FileInputStream fi;
        try {
            fi = new FileInputStream(file);
            Scanner sc1 = new Scanner(fi, "UTF-8");
            while(sc1.hasNext()){
                String linha = sc1.nextLine();
                if(linha != null && !linha.isEmpty()){
                    String[] dados = linha.split("\\;");
                    Person ps = new Person("","",null,null);
                    ps.setName(dados[0]);
                    ps.setCpf(dados[1]);
                    Sexo sext;
                    if(dados[2].toLowerCase().charAt(0) == 'f'){
                        sext = Sexo.mulher;
                    }else{
                        sext = Sexo.homem;
                    }
                    ps.setSex(sext);
                    PriorityGroup prit ;
                    switch(dados[3]){
                        case "Trabalhador da Sa�de":
                            prit = PriorityGroup.HEALH_GROUP;
                            break;
                        case "Portador de idade igual ou superior a 60 anos":
                            prit = PriorityGroup.OLDER_GROUP;
                            break;
                        case "Ind�gena residente em terras ind�genas":
                            prit = PriorityGroup.INDIGENA_GROUP;
                            break;
                        case "Portador de comorbidades":
                            prit = PriorityGroup.COMORBITIES_GROUP;
                            break;
                        case "Funcion�rio do sistema de priva��o de liberdade":
                            prit = PriorityGroup.PRISON_GROUP;
                            break;
                        case "Membro de for�as de seguran�a e salvamento":
                            prit = PriorityGroup.SECURITY_GROUP;
                            break;
                        case "Trabalhador da educa��o":
                            prit = PriorityGroup.EDUCATION_GROUP;
                            break;
                        default :
                            prit = null;
                            
                        }
                        ps.setPriorityGroup(prit);
                        boolean vd;
                        if(dados[4].charAt(0) == 'f'){
                            vd = false;
                        }else{
                            vd = true;
                        }
                        ps.setIsVaccinated(vd);
                        people.add(ps);
                    }
                }
            sc1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }    
    }   
    public void writeBd(){
        File file = new File("BD.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            Iterator<Person> wIterator = people.iterator();
            while(wIterator.hasNext()){
                bw.write(wIterator.next().toString());
                bw.newLine();
            }
            //bw.write(newPerson.toString()+"\n");
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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


    public double[] percentPerPriorityGroupWithoutVaccination(){
        double[] quantities = new double[7];

        Iterator<Person> personIterator = people.iterator();
        while(personIterator.hasNext()){
            Person personTemp = personIterator.next();
            if(personTemp.getIsVaccinated() == false){
                addQuantToArrayQuantsOfPerson(quantities, personTemp);
            }
        }

        return transformQuantToPercent(quantities);
    }

    private void addQuantToArrayQuantsOfPerson(double[] quantities, Person person){
        if(person.getPriorityGroup().getTipo().equals(PriorityGroup.HEALH_GROUP.getTipo())) quantities[0]++;
        else if(person.getPriorityGroup().getTipo().equals(PriorityGroup.OLDER_GROUP.getTipo())) quantities[1]++;
        else if(person.getPriorityGroup().getTipo().equals(PriorityGroup.INDIGENA_GROUP.getTipo())) quantities[2]++;
        else if(person.getPriorityGroup().getTipo().equals(PriorityGroup.COMORBITIES_GROUP.getTipo())) quantities[3]++;
        else if(person.getPriorityGroup().getTipo().equals(PriorityGroup.PRISON_GROUP.getTipo())) quantities[4]++;
        else if(person.getPriorityGroup().getTipo().equals(PriorityGroup.SECURITY_GROUP.getTipo())) quantities[5]++;
        else if(person.getPriorityGroup().getTipo().equals(PriorityGroup.EDUCATION_GROUP.getTipo())) quantities[6]++;
    }

    private void addQuantToArrayQuantsOfRecords(int[] quantities, VaccinationRecord vaccination){
        if(vaccination.getManufacture().getName().equals(Manufacturer.sinovac.getName())) quantities[0]++;
        else if(vaccination.getManufacture().getName().equals(Manufacturer.astraZeneca.getName())) quantities[1]++;
        else if(vaccination.getManufacture().getName().equals(Manufacturer.pfizer.getName())) quantities[2]++;
        else if(vaccination.getManufacture().getName().equals(Manufacturer.Janssen.getName())) quantities[3]++;
    }
    private double[] transformQuantToPercent(double[] quantities){
        double[] percents = new double[7];

        for(int i = 0; i < quantities.length; i++){
            try{
                double toPercent = (quantities[i] / this.people.size()) * 100;
                if (Double.isNaN(toPercent))percents[i] = 0;
                else percents[i] = toPercent;
            }catch (ArithmeticException e){
                percents[i] = 0.0;
            }
           
        }

        return percents;
    }

    public double percentOfCompleteVaccination(){
       double quantPersonsFullVaccinated = getQuantPersonsFullVaccinated();
       
        try{
            double percentOfPersonsFullVaccinated = (quantPersonsFullVaccinated / this.people.size()) * 100;
            System.out.println(percentOfPersonsFullVaccinated);
            System.out.println(quantPersonsFullVaccinated);
            System.out.println(this.people.size());
            if (Double.isNaN(percentOfPersonsFullVaccinated)) return 0.0;
            return percentOfPersonsFullVaccinated;
        }catch (ArithmeticException e){
            return 0.0;
        }
    }

    public double[] getPercentOfVaccinationByPriorityGroup(){
        double[] quantities = new double[7];
        Iterator<Person> personIterator = this.people.iterator();

        while(personIterator.hasNext()){
            Person personTemp = personIterator.next();
            if(personHaveAnyVaccination(personTemp)){
                addQuantToArrayQuantsOfPerson(quantities, personTemp);
            }
        }

        return transformQuantToPercent(quantities);
    }

    private boolean personHaveAnyVaccination(Person person){
        Iterator<VaccinationRecord> vaccinationIterator = this.vaccinationRecords.iterator();

        while(vaccinationIterator.hasNext()){
            VaccinationRecord vaccinationTemp = vaccinationIterator.next();
            if(person.getCpf() == vaccinationTemp.getPerson().getCpf()){
                return true;
            }
        }
        return false;
    }

    public int[] getQuantApplicationsPerManufacture(){
        int[] quantities = new int[4];

        Iterator<VaccinationRecord> vaccinationIterator = this.vaccinationRecords.iterator();

        while(vaccinationIterator.hasNext()){
            VaccinationRecord vaccinationTemp = vaccinationIterator.next();
            addQuantToArrayQuantsOfRecords(quantities, vaccinationTemp);
        }

        return quantities;
    }


}
