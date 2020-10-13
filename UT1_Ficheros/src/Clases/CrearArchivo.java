package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CrearArchivo {
    public static void nuevoArch(){
        JFrame marco = new JFrame("Crear archivo");
        marco.setSize(500,400);
        marco.setLayout(new FlowLayout());

        JLabel nombrearch = new JLabel("Nombre del fichero");
        JTextField tfnom  = new JTextField("",15);

        JTextArea areatexto = new JTextArea(18,40);
        areatexto.setLineWrap(true);
        areatexto.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(areatexto);

        JButton btcrear = new JButton("Crear archivo");

        JFileChooser fileChooser = new JFileChooser();

        btcrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response;
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = fileChooser.showSaveDialog(null);
                if (response == fileChooser.APPROVE_OPTION) {
                    try {
                        FileWriter escritor = new FileWriter(fileChooser.getSelectedFile().getAbsolutePath() + "\\" + tfnom.getText() + " .txt");
                        BufferedWriter buffer = new BufferedWriter(escritor);
                        buffer.write(areatexto.getText());
                        buffer.newLine();
                        buffer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    int option = JOptionPane.showConfirmDialog(marco, "¿Guardar el archivo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });

        marco.add(nombrearch);
        marco.add(tfnom);
        marco.add(sp);
        marco.add(btcrear);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);
    }
}
