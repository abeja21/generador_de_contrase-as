package generador_contras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class generador extends JFrame {

   private JButton generar,ver_contras,num_rand;
   private JLabel contraseña,texto_contr;
    private JTextField caracteres;

    public generador(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,30,30));
        texto_contr=new JLabel("La contraseña es");
        p2.add(texto_contr);
        contraseña=new JLabel("");
        p2.add(contraseña);
            JPanel p3= new JPanel();

            p3.setLayout(new GridLayout(1,2,10,10));
            caracteres=new JTextField();
            p3.add(caracteres);
            num_rand=new JButton("numero aleatorio");
            p3.add(num_rand);
            num_rand.addActionListener(new numero_aleatorio());

            JPanel p4=new JPanel();
            p4.setLayout(new GridLayout(4,1,10,10));
            p4.add(new JRadioButton("Mayusculas"));
            p4.add(new JRadioButton("Minusculas"));
            p4.add(new JRadioButton("Numeros"));
            p4.add(new JRadioButton("Simbolos"));
        p2.add(p3,BorderLayout.CENTER);
        p2.add(p4,BorderLayout.CENTER);
        generar= new JButton("Generar");
            p2.add(generar);
            ver_contras=new JButton("ver contraseñas");
            p2.add(ver_contras);
        add(p2,BorderLayout.CENTER);
        setSize(300,300);
        setVisible(true);
    }


    public static void main(String[] args) {
        generador gn=new generador();
    }


    private class numero_aleatorio implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            caracteres.setText(String.valueOf((int) (Math.random()*20+1)));
        }
    }
}
