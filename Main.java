

import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class Main {
    public static void main(String[] args){
        int menu;
        boolean status = true;
        Scanner tec = new Scanner(System.in);
        System.out.println("---------- Bem vindo ao UFABC Text Adventure ----------");
        
        while(status){
        System.out.println("1 - Começar um novo jogo");
        System.out.println("2 - Tutorial");
        System.out.println("0 - Sair");
        menu = tec.nextInt();
        try{
            switch(menu){
                case 1:
                    Game newGame = new Game(); //constroi novo jogo
                    System.out.print("Loading"); 
                    for(int i = 0; i<3;i++){
                        System.out.print(".");
                        Thread.sleep(1000);                        
                    }
                    System.out.print("\n");
                    status = false;
                    newGame.start();
                    break;
                case 2: //exibir tutorial
                    exibirTutorial();
                    break;
                case 0: //sai do jogo
                    status = false;
                    break;
                default: //tratamento de casos invalido
                    System.out.println("Comando inválido.");
                    break;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            }
        }
    }    

    private static void exibirTutorial() { //tutorial e regras do jogo
        System.out.println("\n\n------------ Tutorial ------------");
        System.out.println("Neste jogo você controlará um futuro aluno da UFABC que passará por momentos marcantes durante sua graduação onde suas habilidades serão testadas ao extremo.");
        System.out.println("Você possui 3 atributos basícos neste jogo: ");
        System.out.println("Vida: Determina sua resistência, o quanto de dano você pode receber até ser derrotado. A vida é calculada pelo resultado de dois dados mais 12.");
        System.out.println("Ataque: Determina sua força, quanto maior esse número, maior a chance de você acertar seu inimigo. O ataque é calculado pelo resultado de um dado mais 6. (O máximo de ataque que um personagem pode possuir é 12)");
        System.out.println("Créditos no RU: Créditos no RU podem ser utilizados após as batalhas para se curar em 6 pontos de vida. O jogador começa com 2 créditos e não pode exceder sua vida máxima total, ou seja, se ele tentar curar com 15 pontos de vida e sua vida máxima for 20, sua vida final será 20 e não 21. ");
        System.out.println("O jogador podera escolher uma habilidade especial na criação de seu personagem para melhorar um de seus atributos.");
        System.out.println("\n---- Combate ----");
        System.out.println("No combate, tanto o jogador quanto o inimigo jogam um dado, o resultado do dado é somado ao poder de ataque de cada um e quem possuir o maior número vence. O vencedor causa 2 de dano em seu adversário. Em casos de empate, ambos saem ilesos.");
        System.out.println("Vence aquele que reduzir os pontos de vida do adversário para 0.");
        System.out.print("\n\n");
    }
}
