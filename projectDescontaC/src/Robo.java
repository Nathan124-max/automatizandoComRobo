import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import java.awt.AWTException;

public class Robo {
    public static void main (final String[] args) {

        final Robot robozin = new Robot();
        final ArrayList <Cheque> listaCheque = new ArrayList<>();
        final int _VALOR = 70;
        final String _DATA = "22/09/2020";
        final int _CONTA = 1;
        final int nx = Integer.parseInt(JOptionPane.showInputDialog("Quantos cheques quer descontar?"));
        final int digitos = Integer.parseInt(JOptionPane.showInputDialog("Desses cheques que irá inserir, tem quantos digitos no geral?"));
        
        for(int k = 0; k < nx; k++){
            final String chequeUnitario = JOptionPane.showInputDialog("Qual o numero do Cheque?");
            final Cheque c  = new Cheque (chequeUnitario);
            listaCheque.add(c);
        }


        for(final Cheque c : listaCheque){
            final ArrayList<Integer> pegandoNumArray = exibirNumero(digitos, c);
    
            robozin.mouseMove(412, 147);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            
            for(final int i : pegandoNumArray){
                final int pegandoNum = transformandoNumeroEmKey(i);
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.delay(4000);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.keyPress(pegandoNum);
                robozin.keyRelease(pegandoNum);
            }
            //219, 285
            robozin.mouseMove(219, 285);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            //mudando

            



        }   

                
                robozin.delay(5000);
                for(final Cheque e: listaCheque){
                    robozin.mouseMove(60, 218);
                    robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);

                    /*robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    robozin.mouseMove(5,59);
                    robozin.keyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_C);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_C); */
                    //robozin.keyPress(KeyEvent.VK_SHIFT);
    
                    /*robozin.keyRelease(KeyEvent.VK_SHIFT);
                    robozin.keyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_C);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_C);
                    for(int b = 0; b < digitos; b++){
                        robozin.keyPress(KeyEvent.VK_DOWN);
                        robozin.keyPress(KeyEvent.VK_DOWN);
                    }*/
    
    
                    /*robozin.mouseMove(726,60);
                    robozin.KeyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_V);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_V);*/

    }

    public static ArrayList<Integer> exibirNumero(final int digitos, final Cheque c) {
        final ArrayList<Integer> lista_Separada = new ArrayList <> ();
        if(digitos == 6){
            final String varNumInteiro = c.getNumero();
            final int var1 = Integer.parseInt(varNumInteiro.substring(0));
            final int var2 = Integer.parseInt(varNumInteiro.substring(1));
            final int var3 = Integer.parseInt(varNumInteiro.substring(2));
            final int var4 = Integer.parseInt(varNumInteiro.substring(3));
            final int var5 = Integer.parseInt(varNumInteiro.substring(4));
            final int var6 = Integer.parseInt(varNumInteiro.substring(5));

            lista_Separada.clear();
            lista_Separada.add(var1, var2);
            lista_Separada.add(var3, var4);
            lista_Separada.add(var5, var6);
            return lista_Separada;

        }else if(digitos == 4){
            final String varNumInteiro = c.getNumero();
            final int var1 = Integer.parseInt(varNumInteiro.substring(0));
            final int var2 = Integer.parseInt(varNumInteiro.substring(1));
            final int var3 = Integer.parseInt(varNumInteiro.substring(2));
            final int var4 = Integer.parseInt(varNumInteiro.substring(3));
            lista_Separada.clear();
            lista_Separada.add(var1, var2);
            lista_Separada.add(var3, var4);
            return lista_Separada;
        }
    public static int transformandoNumeroEmKey(final int varMomento) {

        /*final String keyNum0 = "VK_0";
        final String keyNum1 = "VK_1";
        final String keyNum2 = "VK_2";
        final String keyNum3 = "VK_3";
        final String keyNum4 = "VK_4";
        final String keyNum5 = "VK_5";
        final String keyNum6 = "VK_6";
        final String keyNum7 = "VK_7";
        final String keyNum8 = "VK_8";
        final String keyNum9 = "VK_9";*/

        if(varMomento == 0){
            return 48;
        }else if(varMomento == 1){
            return 49;
        }else if(varMomento == 2){
            return 50;
        }else if(varMomento == 3){
            return 51;
        }else if(varMomento == 4){
            return 52;
        }else if(varMomento == 5){
            return 53;
        }else if(varMomento == 6){
            return 54;
        }else if(varMomento == 7){
            return 55;
        }else if(varMomento == 8){
            return 56;
        }else if(varMomento == 9){
            return 57;
        }else{
            return 1;
        }


        /*ArrayList <String> listaKeys = (keyNum0, keyNum1,keyNum2, keyNum3, keyNum4,keyNum5, keyNum6, keyNum7, keyNum8, keyNum9);
        for(String i: listaKeys){
            if(i.equalsIgnoreCase(varMomento){
                return i;
            }else{
                return "Deu pau no EXCEL";
            }

        }*/
    }
}
