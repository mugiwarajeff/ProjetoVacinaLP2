package ProjetoVacina.models.SignaturesObjects;

public class PriorityGroup {
    private String tipo;

    private PriorityGroup(String tipo){
        this.tipo = tipo;
    }


    final static PriorityGroup HEALH_GROUP = new PriorityGroup("Trabalhador da Saúde");
    final static PriorityGroup OLDER_GROUP = new PriorityGroup("Portador de idade igual ou superior a 60 anos");
    final static PriorityGroup INDIGENA_GROUP = new PriorityGroup("Indígena residente em terras indígenas");
    final static PriorityGroup COMORBITIES_GROUP = new PriorityGroup("Portador de comorbidades");
    final static PriorityGroup PRISON_GROUP = new PriorityGroup("Funcionário do sistema de privação de liberdade");
    final static PriorityGroup SECURITY_GROUP = new PriorityGroup("Membro de forças de segurança e salvamento");
    final static PriorityGroup EDUCATION_GROUP = new PriorityGroup("Trabalhador da educação");
}
