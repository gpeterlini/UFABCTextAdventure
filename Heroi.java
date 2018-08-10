

import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class Heroi extends Personagem { //herda metodos e variaveis de personagem
    private int creditos;
    
    public Heroi(){ //construtor do personagem principal
        int dado1 = 0, dado2 = 0; //valores para calcular os atributos
        Scanner in = new Scanner(System.in);
        this.creditos = 1; //padrao inicial de creditos
        System.out.println("\nBem vindo ao UFABC Text Adventure, primeiro vamos criar seu personagem!");
        System.out.print("Qual seu nome: ");
        this.nome = in.nextLine();
        System.out.print("Olá "+nome+". Calcule sua vida total.\n");
        MetodosComuns.pressEnterToContinue();
        dado1 = MetodosComuns.jogarD6(); 
        dado2 = MetodosComuns.jogarD6();
        this.vida = dado1 + dado2 + 12; //calcula vida de acordo com as regras do jogo
        this.vidaTotal = vida;
        System.out.println("Você tirou : "+dado1+" e "+dado2+", que vão te garantir "+vida+" pontos de vida!");
        System.out.println("Calcule seu ataque. ");
        MetodosComuns.pressEnterToContinue();
        dado1 = MetodosComuns.jogarD6();
        this.ataque = dado1 + 6; //calcula ataque de acordo com as regras do jogo
        System.out.println("Você tirou "+dado1+" o que vai te garantir "+ataque+" pontos de ataque!");
        MetodosComuns.pressEnterToContinue();
        System.out.println("Escolha uma habilidade especial para sua aventura");
        System.out.println("1 - 2 anos de cursinho (+4 de vida inicial)");
        System.out.println("2 - Passar na primeira chamada do SISU (+1 de ataque inicial)");
        System.out.println("3 - Créditos do RU (comece com 2 créditos adicionais no RU)");
        char valido = 0;
        while(valido == 0){
            int opcao = in.nextInt();
            switch(opcao){
                case 1:
                    this.vida += 4;
                    this.vidaTotal = vida;
                    valido = 1;
                    break;
                case 2:
                    if(this.ataque == 12){
                        System.out.println("Você já tem o máximo de ataque");
                        break;
                    }
                    else{
                        this.ataque += 1;
                        valido = 1;
                        break;
                    }
                case 3:
                    this.creditos += 2;
                    valido = 1;
                    break;
                default: //tratar casos onde usuario digita outro numero
                    System.out.println("Comando inválido");
                    break;
            }
        }
        try {
            // exibir atributos finais do jogador
            System.out.println("Suas estatísticas finais: ");
            System.out.println("Vida: "+this.vidaTotal);
            System.out.println("Ataque: "+this.ataque);
            System.out.println("Créditos no Ru: "+this.creditos);
            MetodosComuns.pressEnterToContinue();
            System.out.println("Pronto, agora vamos começar...");
            Thread.sleep(2000);
            System.out.println("\n\n\n\n\n\n\n\n");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
}
