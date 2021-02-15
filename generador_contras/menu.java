package generador_contras;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class menu extends JFrame {
    static JSpinner spin1;
    SpinnerModel caracteres = new SpinnerNumberModel(8, 8, 15, 1);
    Color marron = new Color(38,190,152);
    Color verde= new Color(38,190,110);
    static JRadioButton Mayusculas, Minusculas, Numeros, Simbolos;
    static JLabel contraseña;
    private JButton generar, copiar, ver_contra;
    private  JLabel titulo;
    Font fuente = new Font("Calibri", 3, 20);
    public menu() {
        super("contraseña");
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel principal = new JPanel();
        principal.setBackground(verde);
        principal.setLayout(new GridLayout(4, 1, 10, 10));
        titulo=new JLabel("Generador de Contraseñas", SwingConstants.CENTER);
        titulo.setFont(fuente);
        principal.add(titulo);

        JPanel zona_contraseña = new JPanel();
        zona_contraseña.setLayout(new GridLayout(2, 1, 10, 10));
zona_contraseña.setBackground(verde);

        JPanel control_tamaño = new JPanel();
        control_tamaño.setLayout(new GridLayout(1, 1, 10, 10));

        contraseña = new JLabel("", SwingConstants.CENTER);
        contraseña.setBackground(marron);
        contraseña.setOpaque(true);
        contraseña.setBorder((BorderFactory.createLineBorder(Color.black)));
        control_tamaño.add(contraseña);
        zona_contraseña.add(control_tamaño);

        JPanel tamaño_bcopy = new JPanel();
        tamaño_bcopy.setBackground(verde);
        tamaño_bcopy.setLayout(new GridLayout(1, 3, 10, 10));
        tamaño_bcopy.add(new JLabel(""));
        copiar = new JButton("copiar");
        tamaño_bcopy.add(copiar);
        copiar.addActionListener(new funciones.copy());
        tamaño_bcopy.add(new JLabel(""));
        zona_contraseña.add(tamaño_bcopy);
        principal.add(zona_contraseña);

        JPanel separador = new JPanel();
        separador.setBackground(verde);
        separador.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel zona_cantidad = new JPanel();
        zona_cantidad.setLayout(new GridLayout(2, 1));
        zona_cantidad.setBackground(verde);
        zona_cantidad.add(new JLabel("Cantidad de caracteres"));

        JPanel tamaño_spin = new JPanel();
        tamaño_spin.setBackground(verde);
        tamaño_spin.setLayout(new GridLayout(1, 3));
        tamaño_spin.add(new JLabel(""));
        spin1 = new JSpinner(caracteres);
        ((JSpinner.DefaultEditor) spin1.getEditor()).getTextField().setEditable(false);
        tamaño_spin.add(spin1);
        tamaño_spin.add(new JLabel(""));
        zona_cantidad.add(tamaño_spin);
        separador.add(zona_cantidad);


        JPanel seleccion = new JPanel();
        seleccion.setBackground(verde);
        seleccion.setLayout(new GridLayout(4, 1));
        Mayusculas = new JRadioButton("Mayusculas");
        Mayusculas.setBackground(verde);
        Mayusculas.addActionListener(new funciones.revision_may());
        Minusculas = new JRadioButton("Minusculas");
        Minusculas.setBackground(verde);
        Minusculas.addActionListener(new funciones.revision_min());
        Numeros = new JRadioButton("Numeros");
        Numeros.setBackground(verde);
        Numeros.addActionListener(new funciones.revision_num());
        Simbolos = new JRadioButton("Simbolos");
        Simbolos.setBackground(verde);
        Simbolos.addActionListener(new funciones.revision_simb());
        seleccion.add(Minusculas);
        seleccion.add(Mayusculas);
        seleccion.add(Numeros);
        seleccion.add(Simbolos);
        separador.add(seleccion);
        principal.add(separador);

        JPanel botones = new JPanel();
        botones.setBackground(verde);
        botones.setLayout(new GridLayout(1, 2, 10, 10));
        JPanel tamaño_generar = new JPanel();
        tamaño_generar.setBackground(verde);
        tamaño_generar.setLayout(new GridLayout(3, 1));

        generar = new JButton("generar");
        tamaño_generar.add(generar);
        generar.addActionListener(new funciones.generarcontra());
        botones.add(tamaño_generar);
        JPanel tamaño_contaseña = new JPanel();
        tamaño_contaseña.setBackground(verde);
        tamaño_contaseña.setLayout(new GridLayout(3, 1));

        tamaño_contaseña.add(ver_contra = new JButton("ver contraseñas"));
        ver_contra.addActionListener(new funciones.registro());
        botones.add(tamaño_contaseña);
        principal.add(botones);

        add(principal);
        setSize(292, 400);
        setVisible(true);
    }

}
