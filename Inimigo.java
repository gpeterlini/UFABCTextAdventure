
/**
 *
 * @author Peter
 */
public class Inimigo extends Personagem{ //herda metodos e variaveis de personagem
    public Inimigo(int i){ //construtor do inimigo correspondente a fase "i" que o jogador se encontra
        this.ataque = ataques[i];
        this.vida = vidas[i];
        this.vidaTotal = vidas[i];
        this.nome = inimigos[i];
    }
    
    private static final int [] ataques = { //ataques dos inimigos de cada fase
        8,9,9,8,10,11
    };
    
    private static final int [] vidas = { //vidas dos inimigos de cada fase
        10,8,12,14,15,18
    };

    private static final String [] inimigos = {//nomes dos inimigos de cada fase
        "ENEM", "Servidor do Sistema Matrícula", "EletroMag",
        "Sua Familia", "RH da Empresa", "UFABC"
    };    
}
