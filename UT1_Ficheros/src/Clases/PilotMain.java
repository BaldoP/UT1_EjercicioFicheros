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


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel2.setBorder(new EmptyBorder(5,0,0,0));
        GridLayout gl = new GridLayout(3,2);
        gl.setHgap(10);
        gl.setVgap(10);
        panel2.setLayout(gl);


        JLabel titulo = new JLabel("EJERCICIO MANEJO DE FICHEROS");
        titulo.setBorder(new EmptyBorder(0,0,5,0));

        JButton bcrear = new JButton("Crear archivo");
        JButton beditor = new JButton("Editar | Ver Fichero");
        JButton bcontpalabras = new JButton("Contar Palabras");
        JButton bcontarvocales = new JButton("Contar Vocales");
        JButton bcopiar = new JButton("Copiar Archivo");
        JButton bcifrar = new JButton("Cifrar Archivo");


        panel1.add(titulo);

        panel2.add(bcrear);
        panel2.add(beditor);
        panel2.add(bcontpalabras);
        panel2.add(bcontarvocales);
        panel2.add(bcopiar);
        panel2.add(bcifrar);

        marco.add(panel1);
        marco.add(panel2);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);


        // FUNCIONALIDADES DE LOS BOTONES
        JFileChooser file = new JFileChooser();


        // ---- CREAR ARCHIVO NUEVO  ----  //

        bcrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearArchivo na = new CrearArchivo();
                na.nuevoArch();
            }
        });

        // ---- EDITAR | VER ARCHIVO ---- //

        beditor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response;
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = file.showSaveDialog(null);
                if(response == file.APPROVE_OPTION) {
                    EditArchivo ea = new EditArchivo();
                    ea.prueba(file);
                }
            }
        });


        // ---- CONTAR PALABRAS---- //

        bcontpalabras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response;
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = file.showSaveDialog(null);
                if(response == file.APPROVE_OPTION) {
                    ContarPalabras cp = new ContarPalabras();
                    cp.contarPalabras(file);
                }
            }
        });


        // ---- CONTAR VOCALES ---- //

        bcontarvocales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response;
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = file.showSaveDialog(null);
                if(response == file.APPROVE_OPTION) {
                    ContarVocales cv = new ContarVocales();
                    cv.cVocales(file);
                }
            }
        });


        // ---- COPIAR ARCHIVO ---- //

        bcopiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                file.showSaveDialog(null);
                CopiarArchivo cp = new CopiarArchivo();
                cp.copiar(file);
            }
        });


        // ---- CIFRAR ARCHIVO ---- //

        bcifrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response;
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = file.showSaveDialog(null);
                if(response == file.APPROVE_OPTION) {
                    CifrarArchivo cfa = new CifrarArchivo();
                    cfa.cifrado(file);
                }
                JOptionPane.showMessageDialog(marco,"El archivo se ha cifrado correctamente");
            }
        });
    }
}
