package Clases;

import javax.swing.*;
import java.io.*;


public class CifrarArchivo {
    public static void cifrado(JFileChooser file){
        try {
            FileReader lector = new FileReader(file.getSelectedFile().getAbsolutePath());
            BufferedReader entrada = new BufferedReader(lector);

            try {
                FileWriter escritor = new FileWriter(file.getSelectedFile().getAbsolutePath().replaceAll("\\.[^.]*$","")+"_CIFRADO.txt");
                BufferedWriter salida = new BufferedWriter(escritor);
                String cadena = entrada.readLine();
                while (cadena != null) {
                    String [] palabras=cadena.split(" ");
                    String aux;
                    for(int i=0;i<=palabras.length-1; i++){
                        String aux2="";
                        aux=palabras[i];
                        if (palabras[i].length()>4){
                            for (int j=aux.length()-1;j>=0;j--){
                                aux2 =aux2 + aux.charAt(j);
                            }
                            String aux3 = aux2.substring(aux2.length()-1)+aux2.substring(1,aux2.length()-1)+aux2.substring(0,1);
                            salida.write(aux3+" ");
                        }else {
                            salida.write(aux+" ");
                        }
                    }
                    salida.newLine();
                    cadena = entrada.readLine();
                }
                entrada.close();
                salida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
