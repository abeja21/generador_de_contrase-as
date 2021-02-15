package generador_contras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class funciones {
    private static boolean Mayus;
    private static boolean Minus;
    private static boolean Num;
    private static boolean Simb;

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
            String temporal = "";
            int cantidad = (int) menu.spin1.getValue();
            Random aleatorio = new Random();
            for (int i = 0; i < cantidad; i++) {



                    temporal += letras.charAt(aleatorio.nextInt(letras.length()));

            }

            menu.contraseña.setText(temporal);
            }catch (IllegalArgumentException exception){
                menu.contraseña.setText("no has seleccionado ninguna casilla");
            }
        }
    }
}
