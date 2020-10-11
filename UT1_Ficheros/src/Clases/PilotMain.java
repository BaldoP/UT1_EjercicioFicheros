package Clases;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilotMain {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Manejo de Ficheros");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400,200);
        marco.setLayout(new FlowLayout());

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel2.setBorder(new EmptyBorder(15,0,0,0));
        panel1.setLayout(new GridLayout(2,1));
        GridLayout gl = new GridLayout(2,2);
        gl.setHgap(10);
        gl.setVgap(10);
        panel2.setLayout(gl);



        JLabel titulo = new JLabel("EJERCICIO MANEJO DE FICHEROS");
        titulo.setBorder(new EmptyBorder(0,0,5,0));
        JButton beditor = new JButton("Editar | Ver Fichero");


        JButton bcontpalabras = new JButton("Contar Palabras");
        JButton bcontarvocales = new JButton("Contar Vocales");
        JButton bcopiar = new JButton("Copiar Archivo");
        JButton bcifrar = new JButton("Cifrar Archivo");


        panel1.add(titulo);
        panel1.add(beditor);

        panel2.add(bcontpalabras);
        panel2.add(bcontarvocales);
        panel2.add(bcopiar);
        panel2.add(bcifrar);

        marco.add(panel1);
        marco.add(panel2);
        marco.setResizable(false);
        marco.setVisible(true);




        // FUNCIONALIDADES DE LOS BOTONES

        // ---- EDITAR | VER ARCHIVO ---- //

        beditor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });



        // ---- CONTAR PALABRAS---- //

        bcontpalabras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });



        // ---- CONTAR VOCALES ---- //

        bcontarvocales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });



        // ---- COPIAR ARCHIVO ---- //

        bcopiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });



        // ---- CIFRAR ARCHIVO ---- //

        bcifrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
