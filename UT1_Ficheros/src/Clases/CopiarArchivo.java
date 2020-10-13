package Clases;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CopiarArchivo {
    public static void copiar(JFileChooser fich){
        JFrame marco = new JFrame("Copiar archivo");
        marco.setSize(650,150);
        marco.setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(10,0,0,0));
        GridLayout gl = new GridLayout(2,1);
        gl.setHgap(10);
        gl.setVgap(10);
        panel1.setLayout(gl);

        JLabel rdestino = new JLabel("Ruta de destino: ");
        JTextField tfdestino = new JTextField("",25);
        tfdestino.setEditable(false);
        JLabel nomfich = new JLabel("Nombre de la copia del fichero: ");
        JTextField tfnomfich = new JTextField("",20);


        JButton rutadestino = new JButton("Nuevo destino");
        JButton copiar = new JButton("Copiar fichero");

        JFileChooser nfich = new JFileChooser();

        // ---- ACCIONES DE BOTONES ---- //

        rutadestino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response;
                nfich.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = nfich.showSaveDialog(null);
                if (response == nfich.APPROVE_OPTION) {
                    tfdestino.setText(nfich.getSelectedFile().getAbsolutePath());
                }
            }
        });


        copiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader lector = new FileReader(fich.getSelectedFile().getAbsolutePath());
                    BufferedReader entrada = new BufferedReader(lector);
                    try {
                        FileWriter escritor = new FileWriter(nfich.getSelectedFile().getAbsolutePath()+"\\"+tfnomfich.getText()+" .txt");
                        BufferedWriter salida = new BufferedWriter(escritor);

                        String cadena = entrada.readLine();

                        while (cadena != null) {
                            salida.write(cadena);
                            salida.newLine();
                            cadena = entrada.readLine();
                        }
                        entrada.close();
                        salida.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                int option = JOptionPane.showConfirmDialog(marco,"¿Deseas copiar el archivo en la ruta seleccionada?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        panel1.add(rdestino);
        panel1.add(tfdestino);
        panel1.add(nomfich);
        panel1.add(tfnomfich);
        panel2.add(rutadestino);
        panel2.add(copiar);

        marco.add(panel1);
        marco.add(panel2);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);
    }
}
