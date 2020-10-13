package Clases;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ContarPalabras {
    public static void contarPalabras(JFileChooser fich){
        JFrame marco = new JFrame("Contar Palabras");
        marco.setLocationRelativeTo(null);
        marco.setSize(350, 150);
        marco.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(5,0,0,0));
        JPanel panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(5,0,0,0));

        JLabel tit = new JLabel("Número total de palabras: ");
        JTextField tfcontpal = new JTextField("",10);
        tfcontpal.setEditable(false);
        JButton salir = new JButton("Salir");


        try {
            File lector = new File(fich.getSelectedFile().getAbsolutePath());
            Scanner sc = new Scanner(new FileInputStream(lector));
            int contador=0;
            while (sc.hasNext())  {
                sc.next();
                contador ++;
            }
            tfcontpal.setText(String.valueOf(contador));
            sc.close();

        } catch (IOException e) {
            System.out.println("Ha ocurrido un problema");
        }

        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });

        panel1.add(tit);
        panel1.add(tfcontpal);
        panel2.add(salir);
        marco.add(panel1);
        marco.add(panel2);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);
    }
}
