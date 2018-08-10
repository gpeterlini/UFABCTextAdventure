

import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class Game extends Thread{ //roda o jogo em uma thread
    private static char win; //condicao de vitoria do jogo
    
    public Game(){
        win = 0;
    }//construtor do jogo
        
    private boolean combate(Heroi jogador, Inimigo inimigo){ //logica para o combate
        boolean vitoria; //retornada para verificar se o jogador venceu ou perdeu
        int atqJogador, atqInimigo;
        
        while(true){
            System.out.print("\nSeu HP: "+jogador.getVida()+"/"+jogador.getVidaTotal()+".");
            System.out.println(" HP de "+inimigo.getNome()+": "+inimigo.getVida()+"/"+inimigo.getVidaTotal());
            MetodosComuns.pressEnterToContinue();
            atqJogador = MetodosComuns.jogar2d6() + jogador.getAtaque();
            atqInimigo = MetodosComuns.jogar2d6() + inimigo.getAtaque();
            System.out.println("Você tirou: "+atqJogador+", seu inimigo tirou: "+atqInimigo);
            if(atqJogador > atqInimigo){
                System.out.println("Você ganhou, "+inimigo.getNome()+" recebe 2 de dano!");
                inimigo.setVida(inimigo.getVida()-2);
            }
            else if(atqJogador < atqInimigo){
                System.out.println("Você perdeu, você recebe 2 de dano.");
                jogador.setVida(jogador.getVida()-2);
            }
            else{
                System.out.println("Empate, ninguém sofre dano.");
            }
            
            if(jogador.getVida() <= 0){ //verifica se jogador perdeu
                vitoria = false;
                break;
            }
            else if(inimigo.getVida() <= 0){ // verifica se jogador ganhou
                vitoria = true;
                break;
            }
            else{
                MetodosComuns.pressEnterToContinue(); //combate ainda em progresso
            }            
        }
        
        return vitoria;
    }
    
    private void usarCredito(Heroi jogador){ //logica para o jogador se curar apos combate
        Scanner in = new Scanner(System.in);
        int opcao;
        boolean valido = false; //condicao para comando valido
        System.out.println("\nDeseja utilizar um crédito do RU para recuperar 6 pontos de vida? 1 - Sim, 2 - Não");
        while(valido == false){
            opcao = in.nextInt();
            switch(opcao){
                case 1: //caso onde deseja curar
                    if(jogador.getVida() == jogador.getVidaTotal()){ //se tenta curar com vida cheia
                        System.out.println("Você já esta com a vida cheia.");
                        valido = true;                       
                    }
                    else if(jogador.getVida()+6 > jogador.getVidaTotal()){ //limita quanto o jogador pode curar no caso que ultrapassa sua vida total
                        jogador.setVida(jogador.getVidaTotal());
                        System.out.println("Você tem "+jogador.getVida()+" pontos de vida.");
                        jogador.setCreditos(jogador.getCreditos()-1);
                        valido = true;                        
                    }
                    else{
                        jogador.setVida(jogador.getVida()+6); //cura o jogador normalmente sem restrição
                        System.out.println("Você tem "+jogador.getVida()+" pontos de vida.");
                        jogador.setCreditos(jogador.getCreditos()-1);
                        valido = true;                        
                    }
                    break;
                case 2: //caso onde cancela a cura
                    valido = true;
                    break;
                default: //tratar comandos invalidos/diferentes
                    System.out.println("Comando Inválido");
                    break;
            }
        }
    }
        
    public void verificarVitoria(int i){
        if(i < 5){
            System.out.println("Não foi dessa vez, mas nunca desista, você sempre pode tentar novamente...");
        }
        else{
            System.out.println("Parabéns, você venceu!!!!!!!");
            System.out.println("Você finalmente derrotou a UFABC, depois de muitas noites em claro, momentos de desespero e loucura... você conseguiu se formar, por mais que tenha demorado uns 10 anos, finamente acabou...");
            System.out.println("Essa aventura chegou ao fim... ");
            System.out.println("\nObrigado por jogar!");
            System.out.println("\n\nJogo feito para a disciplina de Programação Orientada à Objetos na UFABC");
        }
    }
    
    
    @Override
    public void run(){ //thread que roda o jogo
        Heroi jogador = new Heroi();
        int i=0; //identifica a fase que o jogador se encontra
        for(i=0; i<6; i++){
            Fase f = new Fase(i); //cria a respectiva fase
            Inimigo inimigo = new Inimigo(i); //cria o respectivo inimigo da fase
            boolean vencedor = combate(jogador, inimigo); //retorna se jogador venceu (1) ou se perdeu (0)          
            if(vencedor){
                System.out.println("Parabéns, você passou a fase "+f.id+"!");
                if(i<5){
                    usarCredito(jogador); //apos combate, para perguntar se deseja curar
                }
                MetodosComuns.pressEnterToContinue();
            }
            else{
                System.out.println("Você perdeu, boa sorte na próxima vez...");
                MetodosComuns.pressEnterToContinue();
                break;
            }      
        }
        verificarVitoria(i);        
    }
}
