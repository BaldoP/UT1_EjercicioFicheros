package Clases;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class ContarVocales {
    public static void cVocales(JFileChooser fich){
        JFrame marco = new JFrame("Contar Vocales");
        marco.setLocationRelativeTo(null);
        marco.setSize(400, 300);
        marco.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel1 = new JPanel();
        GridLayout gl = new GridLayout(5,2);
        gl.setHgap(15);
        gl.setVgap(15);
        panel1.setLayout(gl);
        panel1.setBorder(new EmptyBorder(15,0,0,0));

        JLabel titulo = new JLabel("Número totales de vocales del fichero");
        JTextField tf = new JTextField("",18);
        tf.setText(fich.getSelectedFile().getName().replaceAll("\\.[^.]*$",""));
        tf.setEditable(false);
        JLabel vocalA = new JLabel("Vocal A:");
        JTextField tfa = new JTextField("",10);
        tfa.setEditable(false);
        JLabel vocalE = new JLabel("Vocal E:");
        JTextField tfe = new JTextField("",10);
        tfe.setEditable(false);
        JLabel vocalI = new JLabel("Vocal I:");
        JTextField tfi = new JTextField("",10);
        tfi.setEditable(false);
        JLabel vocalO = new JLabel("Vocal O:");
        JTextField tfo = new JTextField("",10);
        tfo.setEditable(false);
        JLabel vocalU = new JLabel("Vocal U:");
        JTextField tfu = new JTextField("",10);
        tfu.setEditable(false);


        File lector = new File(fich.getSelectedFile().getAbsolutePath());
        String lectura = "";
        try {
            FileReader lee = new FileReader(lector);
            BufferedReader buffer = new BufferedReader(lee);
            String aux;
            while ((aux = buffer.readLine())!=null){
                lectura = lectura+aux;
            }
            lee.close();
            }catch (IOException e){
                JOptionPane.showMessageDialog(marco,"¡No has seleccionado un documento de texto!","Advertencia",JOptionPane.WARNING_MESSAGE);
            }

        int conA=0, conE=0, conI=0, conU=0, conO=0;
        for (int i =0; i<lectura.length();i++){
            switch (lectura.charAt(i)){
                case 'a' : case 'A' : case 'á': case 'Á':
                    conA++;
                    break;

                case 'e' : case 'E': case 'é': case 'É':
                    conE++;
                    break;

                case 'i' : case 'I' : case 'í': case 'Í':
                    conI++;
                    break;

                case 'u' : case 'U': case 'ú': case 'Ú': case 'ü': case 'Ü':
                    conU++;
                    break;

                case 'o' : case 'O': case 'ó': case  'Ó':
                    conO++;
                    break;
            }
        }

        tfa.setText(String.valueOf(conA));
        tfe.setText(String.valueOf(conE));
        tfi.setText(String.valueOf(conI));
        tfu.setText(String.valueOf(conU));
        tfo.setText(String.valueOf(conO));

        panel1.add(vocalA);
        panel1.add(tfa);
        panel1.add(vocalE);
        panel1.add(tfe);
        panel1.add(vocalI);
        panel1.add(tfi);
        panel1.add(vocalO);
        panel1.add(tfo);
        panel1.add(vocalU);
        panel1.add(tfu);

        marco.add(titulo);
        marco.add(tf);
        marco.add(panel1);
        marco.add(panel1);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);
    }
}
