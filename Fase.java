
/**
 *
 * @author Peter
 */
public class Fase {
    
    //identificador da fase
    public int id;
    
    //cenario de cada fase
    private final String [] descricao = {
        "Uma nova etapa começou em sua vida, o sonho de entrar numa universidade do século XXI está prestes a se realizar, é hora do seu primeiro desafio... o ENEM! ",
        "Que coisa linda, vida de universitário finalmente!! Você entrou na UFABC, quer se formar em 5 anos e mal pode esperar para... O QUE??? JÁ TEM P1??? MATRICULA POR ORDEM DE CHEGADA PRO PRÓXIMO QUAD?????",
        "Parece que tudo deu certo, apesar do sistema de matrículas cair umas 3 vezes, você conseguiu... pegou FUV com aquele professor gente boa e seguiu a vida com seus quadrimestres ideais... até que chegou a hora de fazer ELETROMAG.......",
        "Você está orgulhoso, passou em FUV, FVV e EletroMag! Ninguém te segura agora... mas a sua família ainda não sabe o que é esse tal de BCT/BCH ou como você tem férias em setembro. Sua querida tia fez a pergunta de ouro enquanto toda sua família está reunida na mesa de jantar, não há como escapar dessa, todos te olhando fixamente esperando sua resposta... É agora ou nunca... ",
        "Você está quase lá...mas você ainda precisa ser inserido no mercado de trabalho, é hora de encontrar um estágio sem ter qualquer experiência, participar de dinâmicas de grupo, fazer redações em 7 línguas, entrevistas...",
        "Está na hora de acabar com tudo isso, esta é a chance que você estava esperando, derrote a UFABC de uma vez por todas para se formar logo!!!!"
    };
    
    //titulo de cada fase
    private final String [] titulo = {
        "ENEM", "Matricula do segundo Quadrimestre", 
        "EletroMag", "Explicar para a familia", 
        "Estágios", "Se formar"
    };
    
    //construtor da fase, auto incrementa id e exibe a descricao e titulo
    public Fase(int i){
        this.id = i+1;
        System.out.println("\n\nFase "+id+" - "+this.titulo[i]+"\n\n");
        System.out.println(this.descricao[i]);
    }
}
