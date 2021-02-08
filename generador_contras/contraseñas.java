package generador_contras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contraseñas extends JFrame {
    private JButton volver,borrar;
    private JLabel contraseñas;



    public contraseñas() {
        setLayout(new BorderLayout());

       JPanel sur= new JPanel(new GridLayout(1,2,10,10));
       volver=new JButton("VOLVER");
       sur.add(volver);
       volver.addActionListener(new cerrar());
       borrar=new JButton("BORRAR");
       sur.add(borrar);
        add(sur,BorderLayout.SOUTH);
        contraseñas=new JLabel("centro");
        add(contraseñas);
        setSize(400,400);
        setVisible(true);
    }

    public static void main() {
        contraseñas vg= new contraseñas();
    }


    private class cerrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
    }
}
