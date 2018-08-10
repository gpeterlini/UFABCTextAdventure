

/**
 *
 * @author Peter
 */
public abstract class Personagem {
    protected int vida;
    protected int ataque;
    protected int vidaTotal;
    protected String nome;

    //getters e setters dos atributos dos personagens
    public int getVidaTotal(){
        return vidaTotal;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public String getNome() {
        return nome;
    }
    
}
