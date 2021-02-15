package generador_contras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class login extends JFrame {
    private static int contador = 1;
private JTextField usuario;
private JPasswordField contraseña;
private JButton volver,continuar;
    public login(){
        super("login");
        this.setResizable(false);
        setLayout(new FlowLayout());
        JPanel menu= new JPanel();
        menu.setLayout(new GridLayout(3,2,10,10));
        menu.add(new JLabel("usuario:"));
        usuario= new JTextField();
        menu.add(usuario);
        menu.add(new JLabel("contraseña:"));
        contraseña= new JPasswordField();
        menu.add(contraseña);
         volver=new JButton("volver");
         volver.addActionListener(new retroceder());
        menu.add(volver);
        continuar= new JButton("continuar");
        continuar.addActionListener(new conectar());
        menu.add(continuar);

        add(menu);
        setSize(250, 150);
        setVisible(true);
    }

    public static void main() {
        login lg=new login();
    }

    private class conectar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (usuario.getText().equals("admin") && contraseña.getText().equals("admin")){
        try {
            File txt= new File("C:\\Users\\morok\\IdeaProjects\\untitled\\src\\generador_contras\\contraseñas.txt");// la ruta es absoluta porque la relativa no le gusta :C
            Desktop.getDesktop().open(txt);
}catch (Exception MENU){

}
            }else{
                if(contador==5){
                    JOptionPane.showMessageDialog(null, "pista maestra:\n usuario: admin\ncontraseña: admin");
                }else {
                    JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta \n tip: admin");
                    contador++;
                }
            }
        }
    }

    private class retroceder implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
