package ProjetoVacina.utils;

import java.util.LinkedList;
import java.util.Scanner;

import ProjetoVacina.Repository.Repository;
import ProjetoVacina.models.Person;
import ProjetoVacina.models.VaccinationRecord;

public class DataUtils {

    public static void showOption(){
        System.out.println("1 - Quantidade de pessoas registradas que concluiram ciclo de imunização");
        System.out.println("2 - Percentual de pessoas registradas por grupo prioritario que ainda não iniciaram ciclo de imunização");
        System.out.println("3 - Percentual de cobertura vacinal considerando conjunto de pessoas registradas dentre aquelas que concluiram ciclo de imunização");
        System.out.println("4 - Percentual de cobertura vacinal por grupo prioritario");
        System.out.println("5 - Quantidade de registro de aplicação de dose por vacinante");
    }

    public static void selectedOption(Repository repository, Scanner input){

        int option = input.nextInt();
        switch(option){
            case 1:
                showQuantPersonWithoutCompleteVaccination(repository);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5: 
                break;
            default:
                System.out.println("valor invalido!");
        }
    }

    private static void showQuantPersonWithoutCompleteVaccination(Repository repository){
        System.out.printf("%d pessoas terminaram o ciclo de vacinaçao \n", repository.getQuantPersonsFullVaccinated());
    }

    
}
