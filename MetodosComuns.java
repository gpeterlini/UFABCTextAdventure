

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Peter
 */
public class MetodosComuns {
    static Random rnd = new Random();
    
    public static int jogarD6(){
        return rnd.nextInt(6) + 1; //simula o resultado de um dado de 6 faces (1~6)
    }
    
    public static int jogar2d6(){
        return rnd.nextInt(6) + rnd.nextInt(6) + 1; //simula o resultado de dois dados de 6 faces (1~12)
    }
    
    public static void pressEnterToContinue(){ //metodo para gerar interrupcao ate usuario desejar continuar e pressionar enter
        System.out.print("Pressione Enter para continuar...");
        try{
            System.in.read(); //ate usuario apertar enter
        }  
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    
}

