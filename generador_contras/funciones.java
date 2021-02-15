package generador_contras;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class funciones {
    private static boolean Mayus, Minus, Num, Simb;

    private static String contraseña;

    public static class revision_may implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (menu.Mayusculas.isSelected() == true) {
                Mayus = true;
            } else {
                Mayus = false;
            }
        }
    }

    public static class revision_min implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (menu.Minusculas.isSelected() == true) {
                Minus = true;
            } else {
                Minus = false;
            }
        }
    }

    public static class revision_num implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (menu.Numeros.isSelected() == true) {
                Num = true;
            } else {
                Num = false;
            }
        }
    }

    public static class revision_simb implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (menu.Simbolos.isSelected() == true) {
                Simb = true;
            } else {
                Simb = false;
            }
        }
    }

    public static class generarcontra implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String letras = "";
            String numeros = "0123456789";
            String simbolos = "!@#$%^&*_=+-/€.?<>)";
            String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";

            try {
                if (Mayus == true) {
                    letras += letrasMayusculas;
                }
                if (Minus == true) {
                    letras += letrasMinusculas;
                }
                if (Simb == true) {
                    letras += simbolos;
                }
                if (Num == true) {
                    letras += numeros;
                }
                contraseña = "";
                int cantidad = (int) menu.spin1.getValue();
                Random aleatorio = new Random();
                for (int i = 0; i < cantidad; i++) {


                    contraseña += letras.charAt(aleatorio.nextInt(letras.length()));

                }

                menu.contraseña.setText(contraseña);
            } catch (IllegalArgumentException exception) {
                menu.contraseña.setText("no has seleccionado ninguna casilla");
            }
        }
    }

    public static class copy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (contraseña == null) {
                JOptionPane.showMessageDialog(null, "lo siento pero no hay ninguna contraseña para copiar");
            } else {
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection ss = new StringSelection(menu.contraseña.getText());
                cb.setContents(ss, ss);
                JOptionPane.showMessageDialog(null, "su contraseña se ha copiado correctamente");
                try {
                    FileWriter fichero = new FileWriter("C:\\Users\\morok\\IdeaProjects\\untitled\\src\\generador_contras\\contraseñas.txt",true);//la ruta es absoluta porque la relativa no le gusta :C
                    PrintWriter pw = new PrintWriter(fichero);
                    pw.println(menu.contraseña.getText());
                    pw.close();
                } catch (Exception ex) {

                }
            }
        }
    }

    public static class registro implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            login.main();
        }
    }
}
