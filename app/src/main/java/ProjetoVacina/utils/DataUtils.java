package ProjetoVacina.utils;

import java.util.Scanner;
import ProjetoVacina.Repository.Repository;

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
                showPercentPerPriorityGroupWithouVaccination(repository);
                break;
            case 3:
                showPercentOfCompleteVaccination(repository);
                break;
            case 4:
                showPercentOfVaccination(repository);
                break;
            case 5: 
                showQuantRecordsPerManufacture(repository);
                break;
            default:
                System.out.println("valor invalido!");
        }
    }

    private static void showQuantPersonWithoutCompleteVaccination(Repository repository){
        System.out.printf("%d pessoas terminaram o ciclo de vacinaçao \n", repository.getQuantPersonsFullVaccinated());
    }

    private static void showPercentPerPriorityGroupWithouVaccination(Repository repository){
        double[] percents = repository.percentPerPriorityGroupWithoutVaccination();
        System.out.println("Percentual de pessoas que nao iniciaram ciclo de vacinaçao");
        System.out.printf("Profissionais da Saude: %.2f%%\n", percents[0]);
        System.out.printf("Pessoas mais velhas: %.2f%%\n",percents[1]);
        System.out.printf("Grupos indigenas: %.2f%%\n", percents[2]);
        System.out.printf("Grupos com comorbidades: %.2f%%\n", percents[3]);
        System.out.printf("Funcionarios de presidios: %.2f%%\n", percents[4]);
        System.out.printf("Grupo de segurança publica: %.2f%%\n", percents[5]);
        System.out.printf("Profissionais da educaçao: %.2f%%\n", percents[6]);
    }

    private static void showPercentOfCompleteVaccination(Repository repository){
        
        System.out.printf("Percentual de pessoas totalmente vacinadas: %.2f%%\n", repository.percentOfCompleteVaccination());
    }

    private static void showPercentOfVaccination(Repository repository){
        double[] percents = repository.getPercentOfVaccinationByPriorityGroup();
        System.out.println("Percentual de pessoas que nao iniciaram ciclo de vacinaçao");
        System.out.printf("Profissionais da Saude: %.2f%%\n", percents[0]);
        System.out.printf("Pessoas mais velhas: %.2f%%\n",percents[1]);
        System.out.printf("Grupos indigenas: %.2f%%\n", percents[2]);
        System.out.printf("Grupos com comorbidades: %.2f%%\n", percents[3]);
        System.out.printf("Funcionarios de presidios: %.2f%%\n", percents[4]);
        System.out.printf("Grupo de segurança publica: %.2f%%\n", percents[5]);
        System.out.printf("Profissionais da educaçao: %.2f%%\n", percents[6]);
    }

    private static void showQuantRecordsPerManufacture(Repository repository){
        int[] quantities = repository.getQuantApplicationsPerManufacture();
        System.out.println("Percentual de pessoas que nao iniciaram ciclo de vacinaçao");
        System.out.printf("Sinovac: %d\n", quantities[0]);
        System.out.printf("Astrazeneca: %d\n",quantities[1]);
        System.out.printf("Pfizer: %d\n", quantities[2]);
        System.out.printf("janssen: %d\n", quantities[3]);
    }
    
}
