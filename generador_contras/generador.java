package generador_contras;

import java.util.Random;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class generador extends JFrame {
    private boolean Mayus, Minus, Num, Simb;
    private JButton generar, ver_contras, num_rand;
    private JLabel contraseña, texto_contr;
    private JRadioButton Mayusculas, Minusculas, Numeros, Simbolos;
    SpinnerModel caracteres = new SpinnerNumberModel(8, 8, 15, 1);

    public generador() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2,-20,-20));
        JPanel p5 = new JPanel();
        p5.setLayout(new GridLayout(1, 2, 10, 10));
        texto_contr = new JLabel("La contraseña es:");
        p5.add(texto_contr);
        contraseña = new JLabel("");
        p5.add(contraseña);

        p2.add(p5);

        p2.add(new JLabel());
        JPanel p3 = new JPanel();
        JSpinner spin1 = new JSpinner(caracteres);
        ((JSpinner.DefaultEditor) spin1.getEditor()).getTextField().setEditable(false);
        p3.setLayout(new GridLayout(2, 2, -20, -20));
        p3.add(new JLabel("cantidad de caracteres"));
        p3.add(new JLabel(""));
        p3.add(spin1);
        p3.add(new JLabel(""));

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(4, 1, 10, 10));
        Mayusculas = new JRadioButton("Mayusculas");
        p4.add(Mayusculas);
        Mayusculas.addActionListener(new revisaMayus());
        Minusculas = new JRadioButton("Minusculas");
        p4.add(Minusculas);
        Minusculas.addActionListener(new revisadormin());
        Numeros = new JRadioButton("Numeros");
        p4.add(Numeros);
        Numeros.addActionListener(new revisaNUM());
        Simbolos = new JRadioButton("Simbolos");
        p4.add(Simbolos);
        Simbolos.addActionListener(new revisasimb());
        p2.add(p3);
        p2.add(p4);

        JPanel tamaño_b_generar= new JPanel();
        tamaño_b_generar.setLayout(new GridLayout(3,3));
        tamaño_b_generar.add(new JLabel(""));
        tamaño_b_generar.add(new JLabel(""));
        tamaño_b_generar.add(new JLabel(""));
        tamaño_b_generar.add(new JLabel(""));
        generar = new JButton("Generar");
        tamaño_b_generar.add(generar);
        generar.addActionListener(new generar_contraseña());
        tamaño_b_generar.add(new JLabel(""));
        tamaño_b_generar.add(new JLabel(""));
        tamaño_b_generar.add(new JLabel(""));
        tamaño_b_generar.add(new JLabel(""));
        p2.add(tamaño_b_generar);

        JPanel tamaño_b_contra=new JPanel();
        tamaño_b_contra.setLayout(new GridLayout(3,3));
        tamaño_b_contra.add(new JLabel(""));
        tamaño_b_contra.add(new JLabel(""));
        tamaño_b_contra.add(new JLabel(""));
        tamaño_b_contra.add(new JLabel(""));
        ver_contras = new JButton("ver contraseñas");
        ver_contras.addActionListener(new menu_contras());
        tamaño_b_contra.add(ver_contras);
        tamaño_b_contra.add(new JLabel(""));
        tamaño_b_contra.add(new JLabel(""));
        tamaño_b_contra.add(new JLabel(""));
        tamaño_b_contra.add(new JLabel(""));
        p2.add(tamaño_b_contra);
        add(p2, BorderLayout.CENTER);
        setSize(600, 600);
        setVisible(true);
    }


    public static void main(String[] args) {
        generador gn = new generador();
    }


    private class generar_contraseña implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            String letras="";
            String numeros = "0123456789";
            String simbolos = "!@#$%^&*_=+-/€.?<>)";
            String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
            if(Mayus==true){
                   letras+=letrasMayusculas;
            }
            if (Minus==true){
                letras+=letrasMinusculas;
            }
            if (Simb==true){
                letras+=simbolos;
            }
            if (Num==true){
                letras+=numeros;
            }
            String temporal = "";
            int cantidad = (int) caracteres.getValue();
            Random aleatorio = new Random();
            for (int i = 0; i < cantidad; i++) {
                temporal += letras.charAt(aleatorio.nextInt(letras.length()));

            }

            contraseña.setText(temporal);
        }
    }

    private class menu_contras implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            contraseñas.main();
        }
    }

    private class revisadormin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Minusculas.isSelected() == true) {
                Minus = true;
            } else {
                Minus = false;
            }
        }
    }

    private class revisaMayus implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Mayusculas.isSelected() == true) {
                Mayus = true;
            } else {
                Mayus = false;
            }
        }
    }

    private class revisaNUM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Numeros.isSelected() == true) {
                Num = true;
            } else {
                Num = false;
            }
        }
    }

    private class revisasimb implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Simbolos.isSelected() == true) {
                Simb = true;
            } else {
                Simb = false;
            }
        }
    }
}

