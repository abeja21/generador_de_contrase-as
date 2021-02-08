package generador_contras;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class generador extends JFrame {

    private JButton generar, ver_contras, num_rand;
    private JLabel contraseña, texto_contr;
    private JTextField caracteres;
    private ImageIcon logo;
    public generador() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2, 20, 20));
        JPanel p5= new JPanel();
        p5.setLayout(new GridLayout(1,2,10,10));
        texto_contr = new JLabel("La contraseña es:");
        p5.add(texto_contr);
        contraseña = new JLabel("");
        p5.add(contraseña);

        p2.add(p5);

        p2.add(new JLabel());
        JPanel p3 = new JPanel();

        p3.setLayout(new GridLayout(1, 2, 10, 10));
        caracteres = new JTextField();
        p3.add(caracteres);
        num_rand = new JButton("numero aleatorio");
        p3.add(num_rand);
        num_rand.addActionListener(new numero_aleatorio());

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(4, 1, 10, 10));
        p4.add(new JRadioButton("Mayusculas"));
        p4.add(new JRadioButton("Minusculas"));
        p4.add(new JRadioButton("Numeros"));
        p4.add(new JRadioButton("Simbolos"));
        p2.add(p3);
        p2.add(p4);
        generar = new JButton("Generar");
        generar.setSize(new Dimension(10,10));
        p2.add(generar);
        generar.addActionListener(new generar_contraseña());
        ver_contras = new JButton("ver contraseñas");
        ver_contras.addActionListener(new menu_contras());
        p2.add(ver_contras);
        add(p2, BorderLayout.CENTER);
        setSize(600, 600);
        setVisible(true);
    }


    public static void main(String[] args) {
        generador gn = new generador();
    }


    private class numero_aleatorio implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            caracteres.setText(String.valueOf((int) (Math.random() * 20 + 1)));
        }
    }


    private class generar_contraseña implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            contraseña.setText("hola");
        }
    }

    private class menu_contras implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            contraseñas.main();
        }
    }
}
