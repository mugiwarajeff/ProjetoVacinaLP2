/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ProjetoVacina;

import java.util.Scanner;

import ProjetoVacina.Repository.Repository;
import ProjetoVacina.utils.DataUtils;
import ProjetoVacina.utils.RegisterUtils;
import ProjetoVacina.utils.UtilPerson;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        
        boolean whileController = true;
        Scanner input = new Scanner(System.in);

        while(whileController){
            int opcao = 0;
            System.out.println("=======Menu de opções========");  
            System.out.println("Digite 1 para Registrar uma nova Pessoa");
            System.out.println("Digite 2 para realizar um novo registro de vacinaçao");
            System.out.println("Digite 3 para pesquisar pessoa cadastradas");
            System.out.println("Digite 4 para pesquisar pessoa que não foram vacinadas");
            System.out.println("Digite 5 para imprimir registros de vacinaçao");
            System.out.println("Digite 6 para Dados das vacinas");
            System.out.println("Digite 0 para Sair do Programa");
            opcao = input.nextInt();

            switch(opcao){
                case 1: 
                    input.nextLine();
                    UtilPerson.personRegister(repository.getPeopleList(), input);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;
                case 2: 
                    input.nextLine();
                    RegisterUtils.recordRegister(repository.getPeopleList(), repository.getVaccinationList(), input);
                    break;
                case 3:
                    repository.searchRegisterByCPF(input);
                    break;
                case 4: 
                    input.nextLine();
                    repository.showPeoplewithoutVaccine();
                    break;
                case 5:
                    repository.showAllRecords();
                    break;
                case 6:
                    DataUtils.showOption();
                    DataUtils.selectedOption(repository, input);
                    break;
                case 0:
                    whileController = false;
                    break;
                default:
                    System.out.println("Tentativa invalida, tente novamente...");
            }
        }

    }
}