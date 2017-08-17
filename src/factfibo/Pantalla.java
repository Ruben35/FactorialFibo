
package factfibo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.TEXT_CURSOR;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Alumno
 */
public class Pantalla extends JFrame implements ActionListener{
    
    private JLabel tit;
    private JLabel nom;
    private JTextField nomt;
    private JButton boton;
    private JTextField fibo;
    private JTextField fact;
    private JLabel nt;
    private JLabel ns;
    
    public Pantalla(){
        inicomp();
        confVen();
    }
    
    private void confVen() {
        setTitle("Factorial | Fibonacci");
        setSize(450,450);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(242, 239, 239));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicomp(){
        tit= new JLabel("FACT/FIBO");
        tit.setBounds(10,10,300,100);
        tit.setForeground(new Color (0,0,0));
        tit.setFont(new Font("Arial", Font.BOLD, 50));
        add(tit);
        tit.setVisible(true);
        
        nom= new JLabel("Numero: ");
        nom.setBounds(20,100,100,100);
        nom.setForeground(new Color (0,0,0));
        add(nom);
        nom.setVisible(true);
        
        nomt=new JTextField();
        nomt.setBounds(200,137,100,35);
        nomt.setBorder(null);
        nomt.setBackground(Color.white);
        nomt.setForeground(Color.black);
        nomt.setCursor(new Cursor(TEXT_CURSOR));
        add(nomt);
        nomt.setVisible(true);
        
        boton=new JButton();
        boton.setText("Calcular");
        boton.setBounds(50,230,100,100);
        boton.setForeground(Color.black);
        boton.setCursor(new Cursor(HAND_CURSOR));
        add(boton);
        boton.setVisible(true);
        boton.addActionListener(this);
        
        nt= new JLabel("Fibonnaci:");
        nt.setBounds(200,200,100,35);
        nt.setForeground(new Color (0,0,0));
        add(nt);
        nt.setVisible(true);
        
        fibo=new JTextField();
        fibo.setBounds(300,200,100,35);
        fibo.setBorder(null);
        fibo.setBackground(Color.white);
        fibo.setForeground(Color.black);
        fibo.setCursor(new Cursor(TEXT_CURSOR));
        fibo.setEditable(false);
        add(fibo);
        fibo.setVisible(true);
        
        ns= new JLabel("Factorial: ");
        ns.setBounds(200,250,100,35);
        ns.setForeground(new Color (0,0,0));
        add(ns);
        ns.setVisible(true);
        
        fact=new JTextField();
        fact.setBounds(300,250,100,35);
        fact.setBorder(null);
        fact.setBackground(Color.white);
        fact.setForeground(Color.black);
        fact.setCursor(new Cursor(TEXT_CURSOR));
        fact.setEditable(false);
        add(fact);
        fact.setVisible(true);
    }

    private void factorial(String numero){
        int num;
        num=Integer.parseInt(numero);
        double factorial=1;
        while(num!=0){
            factorial=factorial*num;
            num=num-1;
        }
        fact.setText(String.valueOf(factorial));
    }
    
    private void fibonacci (String numero){
        int num;
        num=Integer.parseInt(numero);
        int f1=0;
        int f2=1;
        int f3=1;
        int f4=2;
        int fiboul=0;
        int fibopen=0;
        int suma;
        String fibofinal=null;
        if(num==1){
            fibofinal=""+f1;
        }
        if(num==2){
            fibofinal=""+f1+","+f2;
        }
        if(num==3){
            fibofinal=""+f1+","+f2+","+f3;
        }
        if(num==4){
            fibofinal="0,1,1,2";
        }
        if(num>4){
            fibofinal="0,1,1,2";
            fiboul=f4;
            fibopen=f3;
            for(int i=4;i<=num;i++){
                suma=fiboul+fibopen;
                fibofinal=fibofinal+","+suma;
                fibopen=fiboul;
                fiboul=suma;
            }
        }
        fibo.setText(fibofinal);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton){
            fibonacci(nomt.getText());
            factorial(nomt.getText());
        }
    }
}
