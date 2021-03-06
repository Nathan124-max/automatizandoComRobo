import java.awt.Robot;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class Robo {
    

    public static void main (final String[] args) throws Exception {

        final Robot robozin = new Robot();
        final ArrayList <Cheque> listaCheque = new ArrayList<>();

        
        //RECEBE A DATA E MIGRA NUM ARRAY
        String data = JOptionPane.showInputDialog("Digite a data a descontar.. ( COM BARRAS )");
        //verificando
        
        if(data.length() < 9 || data == null){ 
            JOptionPane.showMessageDialog(null, "Erro na data, o sistema fechará automaticamente!!");
            System.exit(1);
        } 
        String [] arrayData = new String[data.length()];
        for(int d = 0; d < data.length(); d++){
            Object object =  data.charAt(d);
            arrayData[d] = object.toString();
        }
        String chequeEmLote = JOptionPane.showInputDialog("Digite o cheque, dê ( + ) e digite o próximo cheque..");     
        String [] arrayCheques =  chequeEmLote.split("+");
        for(String i : arrayCheques){
            Cheque c = new Cheque (i);
            listaCheque.add(c);
        }

        JOptionPane.showMessageDialog(null, "Você tem 30 segundos para Abrir a tela do PublicSoft e o Robô iniciar!");
        robozin.delay(30000);
        //FAZ A OPERAÇÃO COMPLETA DE UM DESCONTO DE CHEQUE
        for(final Cheque c : listaCheque){
            robozin.delay(600);
            //CLICA NA CAIXA DO CHEQUE
            robozin.mouseMove(412, 147);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            //DANDO UM CLEAR NA CAIXA DO CHEQUE
            int w = 0;
            while(w < 6){
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.delay(400);
                w++;
            }
            //PEGA O CHEQUE E SEPARA NUMERO A NUMERO DENTRO DO ARRAY.
            int[] arrayNC = new int[c.getNumero().length()];
            int k = 0;
            while(k < c.getNumero().length()){
                arrayNC[k] = Character.getNumericValue(c.getNumero().charAt(k));
                k++;
            }
            //DIGITANDO AS KEYS DO CHEQUE
            for(int i : arrayNC){
                if(i == 0){
                    robozin.keyPress(KeyEvent.VK_0);
                    robozin.keyRelease(KeyEvent.VK_0);
                }else if(i == 1){
                    robozin.keyPress(KeyEvent.VK_1);
                    robozin.keyRelease(KeyEvent.VK_1);
                }else if(i == 2){
                    robozin.keyPress(KeyEvent.VK_2);
                    robozin.keyRelease(KeyEvent.VK_2);
                }else if(i == 3){
                    robozin.keyPress(KeyEvent.VK_3);
                    robozin.keyRelease(KeyEvent.VK_3);
                }else if(i == 4){
                    robozin.keyPress(KeyEvent.VK_4);
                    robozin.keyRelease(KeyEvent.VK_4);
                }else if(i == 5){
                    robozin.keyPress(KeyEvent.VK_5);
                    robozin.keyRelease(KeyEvent.VK_5);
                }else if(i == 6){
                    robozin.keyPress(KeyEvent.VK_6);
                    robozin.keyRelease(KeyEvent.VK_6);
                }else if(i == 7){
                    robozin.keyPress(KeyEvent.VK_7);
                    robozin.keyRelease(KeyEvent.VK_7);
                }else if(i == 8){
                    robozin.keyPress(KeyEvent.VK_8);
                    robozin.keyRelease(KeyEvent.VK_8);
                }else if(i == 9){
                    robozin.keyPress(KeyEvent.VK_9);
                    robozin.keyRelease(KeyEvent.VK_9);
                }
                robozin.delay(500);
            }
            //OK NA CAIXA DO CHEQUE
            robozin.delay(1000);
            robozin.keyPress(KeyEvent.VK_ENTER);
            robozin.keyRelease(KeyEvent.VK_ENTER);
            robozin.delay(2000);
            //699, 421
            //CLICA EM "NÃO" CASO APARECA A TELA DE CONCLUIR
            robozin.mouseMove(699, 421);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.delay(1500);
            
            // CLICANDO NA CAIXA (DESCONTAR "SIM")
            robozin.mouseMove(219, 285);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.delay(1000);

            // CLICANDO NA DATA 
            //290,345
            robozin.mouseMove(290, 345);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.delay(1000);

            
            for(int i = 0; i < arrayData.length ; i++){
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.delay(500);
            
            }
            robozin.delay(500);

            //Escrevendo a data
            for(String s: arrayData){
                if(s.equalsIgnoreCase("0")){
                    robozin.keyPress(KeyEvent.VK_0);
                    robozin.keyRelease(KeyEvent.VK_0);
                }else if(s.equalsIgnoreCase("1")){
                    robozin.keyPress(KeyEvent.VK_1);
                    robozin.keyRelease(KeyEvent.VK_1);
                }else if(s.equalsIgnoreCase("2")){
                    robozin.keyPress(KeyEvent.VK_2);
                    robozin.keyRelease(KeyEvent.VK_2);
                }else if(s.equalsIgnoreCase("3")){
                    robozin.keyPress(KeyEvent.VK_3);
                    robozin.keyRelease(KeyEvent.VK_3);
                }else if(s.equalsIgnoreCase("4")){
                    robozin.keyPress(KeyEvent.VK_4);
                    robozin.keyRelease(KeyEvent.VK_4);
                }else if(s.equalsIgnoreCase("5")){
                    robozin.keyPress(KeyEvent.VK_5);
                    robozin.keyRelease(KeyEvent.VK_5);
                }else if(s.equalsIgnoreCase("6")){
                    robozin.keyPress(KeyEvent.VK_6);
                    robozin.keyRelease(KeyEvent.VK_6);
                }else if(s.equalsIgnoreCase("7")){
                    robozin.keyPress(KeyEvent.VK_7);
                    robozin.keyRelease(KeyEvent.VK_7);
                }else if(s.equalsIgnoreCase("8")){
                    robozin.keyPress(KeyEvent.VK_8);
                    robozin.keyRelease(KeyEvent.VK_8);
                }else if(s.equalsIgnoreCase("9")){
                    robozin.keyPress(KeyEvent.VK_9);
                    robozin.keyRelease(KeyEvent.VK_9);
                }else if(s.equalsIgnoreCase("/")){
                    //robozin.keyPress(KeyEvent.VK_SLASH);
                    //robozin.keyRelease(KeyEvent.VK_SLASH);
                    robozin.keyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_V);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_V);
                }
                robozin.delay(500);
            }
            //GRAVANDO
            robozin.delay(1000);
            robozin.keyPress(KeyEvent.VK_F12);
            robozin.keyRelease(KeyEvent.VK_F12);
            robozin.delay(700);
            robozin.keyPress(KeyEvent.VK_ENTER);
            robozin.keyRelease(KeyEvent.VK_ENTER);
            robozin.delay(1000);
               
        }JOptionPane.showMessageDialog(null,"FIM..");     
    }
}