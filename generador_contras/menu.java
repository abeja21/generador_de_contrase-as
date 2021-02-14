package generador_contras;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class menu extends JFrame {
    SpinnerModel caracteres = new SpinnerNumberModel(8, 8, 15, 1);
    Color marron = new Color(178, 137, 74);
    private JRadioButton Mayusculas, Minusculas, Numeros, Simbolos;
    private JButton generar,ver_contra;
    public menu() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(4, 1, 10, 10));
        principal.add(new JLabel("Generador de Contraseñas",SwingConstants.CENTER));

        JPanel control_tamaño=new JPanel();
        control_tamaño.setLayout(new GridLayout(3,1,-10,-10));

        JLabel contraseña = new JLabel("hola", SwingConstants.CENTER);
        contraseña.setBackground(marron);
        contraseña.setOpaque(true);
        control_tamaño.add(contraseña);

        principal.add(control_tamaño);

        JPanel separador=new JPanel();
        separador.setLayout(new GridLayout(1,2,10,10));

        JPanel zona_cantidad = new JPanel();
        zona_cantidad.setLayout(new GridLayout(2, 1));

        zona_cantidad.add(new JLabel("Cantidad de caracteres"));

        JPanel tamaño_spin= new JPanel();
        tamaño_spin.setLayout(new GridLayout(1,3));
        tamaño_spin.add(new JLabel(""));
        JSpinner spin1 = new JSpinner(caracteres);
        ((JSpinner.DefaultEditor) spin1.getEditor()).getTextField().setEditable(false);
        tamaño_spin.add(spin1);
        tamaño_spin.add(new JLabel(""));
        zona_cantidad.add(tamaño_spin);
        separador.add(zona_cantidad);


        JPanel seleccion= new JPanel();
        seleccion.setLayout(new GridLayout(4,1));
        Mayusculas= new JRadioButton("Mayusculas");
        Minusculas=new JRadioButton("Minusculas");
        Numeros=new JRadioButton("Numeros");
        Simbolos=new JRadioButton("Simbolos");
        seleccion.add(Minusculas);
        seleccion.add(Mayusculas);
        seleccion.add(Numeros);
        seleccion.add(Simbolos);
        separador.add(seleccion);
        principal.add(separador);

        JPanel botones= new JPanel();
        botones.setLayout(new GridLayout(1,2,10,10));
        JPanel tamaño_generar= new JPanel();
        tamaño_generar.setLayout(new GridLayout(3,1));

        generar=new JButton("generar");
        tamaño_generar.add(generar);
        botones.add(tamaño_generar);
        JPanel tamaño_contaseña = new JPanel();
        tamaño_contaseña.setLayout(new GridLayout(3,1));

        tamaño_contaseña.add(ver_contra=new JButton("ver contraseñas"));
        botones.add(tamaño_contaseña);
        principal.add(botones);

        add(principal);
        setSize(600, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        menu mn = new menu();
    }
}
