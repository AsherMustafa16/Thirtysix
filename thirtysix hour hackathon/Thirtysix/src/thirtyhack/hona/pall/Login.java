package thirtyhack.hona.pall;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
        JTextField textField1;
        JPasswordField textField2;
        JButton b1,b2;
    Login(){
        
        
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
        setLayout(null);

        JLabel lable1= new JLabel("Username");
        lable1.setBounds(40, 20, 100,30);
        lable1.setFont(new Font("Tahoma",Font.BOLD,16));
        lable1.setForeground(Color.WHITE);
        getContentPane().setBackground(Color.black);
        add(lable1);

        JLabel lable2= new JLabel("Password");
        lable2.setBounds(40, 70, 100,30);
        lable2.setFont(new Font("Tahoma",Font.BOLD,16));

        lable2.setForeground(Color.WHITE);
        add(lable2);
        textField1= new JTextField();
        textField2= new JPasswordField();
        textField1.setBounds(150,20,150,30);
        textField2.setBounds(150,70,150,30);
        textField1.setForeground(Color.white);
        textField2.setForeground(Color.WHITE);
        textField1.setFont(new Font("Tahoma",Font.PLAIN,15));
        
        add(textField1);
        add(textField2);
        textField1.setBackground(new Color(3,45,48));
        textField2.setBackground(new Color(3,45,48));

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/nzxt-gif.gif"));
        Image i1= imageIcon.getImage().getScaledInstance(255,255,Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon = new ImageIcon(i1);
        JLabel lable = new JLabel(scaledImageIcon);
        lable.setBounds(315,-30,255,300);
        add(lable);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("Serif",Font.PLAIN,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Serif",Font.PLAIN,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1)
        {
            
            try{
                Von c =new Von();
                String user =textField1.getText();
                String pass = new String(textField2.getPassword());

                
                String q= "Select * from login where username ='"+user+"' AND password ='"+pass+"'";
               
                ResultSet resultSet= c.statement.executeQuery(q);
                if(resultSet.next()){
                  
                    new Dashboard();
                    setVisible(false);
                   
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch(Exception E)
            {
                E.printStackTrace();
            }

        }
            
        else{
            System.exit(102);
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }

}
