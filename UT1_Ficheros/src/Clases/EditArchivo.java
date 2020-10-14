package Clases;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditArchivo {
<<<<<<< HEAD
    public static void prueba(JFileChooser fich){
        JFrame marco = new JFrame("Editar | Ver archivo");
        marco.setSize(620,450);
        marco.setLayout(new FlowLayout());


        JPanel panel1 = new JPanel(new GridLayout(5,1));
        JPanel panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(5,0,0,0));
        JPanel panel3 = new JPanel();


        JLabel nombre = new JLabel("Nombre:");
        JTextField tnombre = new JTextField("",25);
        tnombre.setEditable(false);
        JLabel formato = new JLabel("Formato:");
        JTextField tformato = new JTextField("",25);
        tformato.setEditable(false);
        JLabel ruta = new JLabel("Ruta absoluta:");
        JTextField truta = new JTextField("",25);
        truta.setEditable(false);
        JLabel tam = new JLabel("Tamaño:");
        JTextField ttam = new JTextField("",25);
        ttam.setEditable(false);
        JLabel ultm = new JLabel("Ultima modificación:");
        JTextField tultm = new JTextField("",25);
        tultm.setEditable(false);

        JTextArea texta = new JTextArea(15,50);
        texta.setLineWrap(true);
        texta.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(texta);

        JButton modificar = new JButton("Guardar cambios");
        JButton borrar = new JButton("Borrar archivo");


        // --- INFORMACIÓN --- //
        File r = fich.getSelectedFile();
        tnombre.setText(r.getName().replaceAll("\\.[^.]*$",""));                             // Nombre
        String aux = fich.getTypeDescription(r);
        tformato.setText(aux);                                   // Formato
        truta.setText(r.getAbsolutePath());                      // Ruta absoluta
        ttam.setText(String.valueOf(r.getTotalSpace()));         // Tamaño
        long lastModified = r.lastModified();
        String pattern = "dd-MM-yyyy hh:mm aa";
        SimpleDateFormat sD = new SimpleDateFormat(pattern);
        Date lastM = new Date(lastModified);
        tultm.setText(sD.format(lastM));                         // Ultima Modificacion


        // --- EDITAR --- //

        try(FileReader fr=new FileReader(r)){
            String cadena="";
            int valor=fr.read();
            while(valor!=-1){
                cadena=cadena+(char)valor;
                valor=fr.read();
            }
            texta.setText(cadena);
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String source = texta.getText();
                try {
                    FileWriter escribir = new FileWriter(r,false);
                    escribir.write(source);
                    escribir.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }

                int option = JOptionPane.showConfirmDialog(marco,"¿Deseas guardar los cambios?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        // --- BORRAR --- //
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                r.delete();
                int option = JOptionPane.showConfirmDialog(marco,"¿Deseas borrar por completo el archivo seleccionado?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });


        // Elementos panel1
        panel1.add(nombre);
        panel1.add(tnombre);
        panel1.add(formato);
        panel1.add(tformato);
        panel1.add(ruta);
        panel1.add(truta);
        panel1.add(tam);
        panel1.add(ttam);
        panel1.add(ultm);
        panel1.add(tultm);

        //Elemento panel2
        panel2.add(sp);

        //Elemento panel3
        panel3.add(modificar);
        panel3.add(borrar);

        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);
    }
=======
>>>>>>> parent of 9458d53... Prueba Git
}
