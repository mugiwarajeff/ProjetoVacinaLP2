package ProjetoVacina.models.SignaturesObjects;

public class PriorityGroup {
    private String tipo;

    private PriorityGroup(String tipo){
        this.tipo = tipo;
    }


    public final static PriorityGroup HEALH_GROUP = new PriorityGroup("Trabalhador da Saúde");
    public final static PriorityGroup OLDER_GROUP = new PriorityGroup("Portador de idade igual ou superior a 60 anos");
    public final static PriorityGroup INDIGENA_GROUP = new PriorityGroup("Indígena residente em terras indígenas");
    public final static PriorityGroup COMORBITIES_GROUP = new PriorityGroup("Portador de comorbidades");
    public final static PriorityGroup PRISON_GROUP = new PriorityGroup("Funcionário do sistema de privação de liberdade");
    public final static PriorityGroup SECURITY_GROUP = new PriorityGroup("Membro de forças de segurança e salvamento");
    public final static PriorityGroup EDUCATION_GROUP = new PriorityGroup("Trabalhador da educação");

    public String toString(){
    return this.tipo;
 }
}
