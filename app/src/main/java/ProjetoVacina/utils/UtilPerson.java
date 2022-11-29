package ProjetoVacina.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ProjetoVacina.models.Person;
import ProjetoVacina.models.SignaturesObjects.PriorityGroup;
import ProjetoVacina.models.SignaturesObjects.Sexo;

public class UtilPerson {

    public static void personRegister(LinkedList<Person> people, Scanner input){
        int option = 0;
        String name;
        String cpf = null;
        Sexo sexo = null;
        PriorityGroup priorityGroup = null;

        System.out.print("Digite o nome da pessoa: ");
        name = input.nextLine();
       
        boolean cpfError = true;
        while(cpfError){
            System.out.print("Digite o CPF da pessoa: ");
            cpf = input.nextLine();
            cpfValidator(cpf);
            if(!cpfVerify(cpf, people)){
                System.out.println("CPF ja existente... cadastre novamente");
            }
            else{
                if (cpfValidator(cpf)){
                    cpfError = false;
                }else {
                    System.out.println("CPF digitado nos padroes incorretos");
                }
                
            }
        }
        
        boolean sexError = true;
        while(sexError){
            System.out.println("Escolha Sexo da pessoas: ");
            listSexoOptions();
            option = input.nextInt();
            sexo = selectedSexoOption(option);
            
            if(sexo != null){
                sexError = false;
            }
            else{
                System.out.println("Valor escolhido é invalido, tente novamente...");
            }
        }
       

        boolean priorityGroupError = true;
        while(priorityGroupError){
        System.out.println("Selecione o Grupo Prioritario da pessoa");
        listPriorityGroup();
        option = input.nextInt();
        priorityGroup = selectedPriorityGroup(option);
 
        if(priorityGroup != null)
            priorityGroupError = false;
        else
            System.out.println("Valor escolhido é invalido, tente novamente...");
        }

        Person newPerson = new Person(name, cpf, sexo, priorityGroup);
        people.add(newPerson);
    }

    private static void listSexoOptions(){
        System.out.println("1 - Homem");
        System.out.println("2 - Mulher");
    }

    private static Sexo selectedSexoOption(int option){
        switch(option){
            case 1: 
                return Sexo.homem;
            case 2: 
                return Sexo.mulher;
            default:
                System.out.println("valor invalido, retorno nulo");
                return null;
        }
    }

    private static void listPriorityGroup(){
        System.out.println("1 - Trabalhador da Saúde");
        System.out.println("2 - Portador de idade igual ou superior a 60 anos");
        System.out.println("3 - Indígena residente em terras indígenas");
        System.out.println("4 - Portador de comorbidades");
        System.out.println("5 - Funcionário do sistema de privação de liberdade");
        System.out.println("6 - Membro de forças de segurança e salvamento");
        System.out.println("7 - Trabalhador da educação");
    }

    private static PriorityGroup selectedPriorityGroup(int option){
        switch(option){
            case 1:
                return PriorityGroup.HEALH_GROUP;
            case 2: 
                return PriorityGroup.OLDER_GROUP;
            case 3:
                return PriorityGroup.INDIGENA_GROUP;
            case 4:
                return PriorityGroup.COMORBITIES_GROUP;
            case 5:
                return PriorityGroup.PRISON_GROUP;
            case 6:
                return PriorityGroup.SECURITY_GROUP;
            case 7:
                return PriorityGroup.EDUCATION_GROUP;
            default:
                System.out.println("valor invalido, retorno nulo");
                return null;
        }
    }
    
    private static boolean cpfVerify(String cpf, LinkedList<Person> people){
        Iterator<Person> personIterator = people.iterator();

        while(personIterator.hasNext()){
            Person personTemp = personIterator.next();
            if (personTemp.getCpf().equals(cpf)) return false;
        }

        return true;
    }

    private static boolean cpfValidator(String cpf){
        Pattern pattern = Pattern.compile("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
          } else {
            return false;
          }
    }

}
