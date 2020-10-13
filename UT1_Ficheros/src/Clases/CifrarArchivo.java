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
                String palabras[] = cadena.split("\\s");

                String aux1;
                String aux2;

                for (String w : palabras){
                    StringBuilder sb = new StringBuilder(w);
                    aux1 = sb.substring(0,1);
                    aux2 = sb.substring(1);
                    String ultletra = aux2.substring(aux2.length()-1);
                    String primultletra = aux2.substring(0,aux2.length()-1);
                    StringBuilder sb1 = new StringBuilder(primultletra);
                    StringBuilder sb2 = new StringBuilder(ultletra);
                    sb1.reverse();
                    salida.write(aux1 + sb1 + sb2 + " ");
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
