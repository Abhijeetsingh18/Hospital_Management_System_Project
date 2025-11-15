package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class reception extends JFrame {

    reception() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setOpaque(true);
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300, 0, 250, 250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(1000, 50, 300, 100);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30, 15, 200, 30);
        btn1.setBackground(new Color(246, 215, 118));
        panel1.add(btn1);
        btn1.addActionListener(e -> new NEW_PATIENT());

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 200, 30);
        btn2.setBackground(new Color(246, 215, 118));
        panel1.add(btn2);
        btn2.addActionListener(e -> new Room());

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 200, 30);
        btn3.setBackground(new Color(246, 215, 118));
        panel1.add(btn3);
        btn3.addActionListener(e -> new Department());

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270, 15, 200, 30);
        btn4.setBackground(new Color(246, 215, 118));
        panel1.add(btn4);
        btn4.addActionListener(e -> new Employee_info());

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270, 58, 200, 30);
        btn5.setBackground(new Color(246, 215, 118));
        panel1.add(btn5);
        btn5.addActionListener(e -> new ALL_Patient_Info());

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270, 100, 200, 30);
        btn6.setBackground(new Color(246, 215, 118));
        panel1.add(btn6);
        btn6.addActionListener(e -> new patient_discharge());

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510, 15, 200, 30);
        btn7.setBackground(new Color(246, 215, 118));
        panel1.add(btn7);
        btn7.addActionListener(e -> new update_patient_details());

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(510, 58, 200, 30);
        btn8.setBackground(new Color(246, 215, 118));
        panel1.add(btn8);
        btn8.addActionListener(e -> new Ambulance());

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510, 100, 200, 30);
        btn9.setBackground(new Color(246, 215, 118));
        panel1.add(btn9);
        btn9.addActionListener(e -> new SearchRoom());

        JButton btn10 = new JButton("LogIn");
        btn10.setBounds(750, 15, 200, 30);
        btn10.setBackground(new Color(246, 215, 118));
        panel1.add(btn10);
        btn10.addActionListener(e -> {
            setVisible(false);
            new login();
        });

        JButton btn11 = new JButton("LogOut");
        btn11.setBounds(750, 58, 200, 30);
        btn11.setBackground(new Color(246, 215, 118));
        panel1.add(btn11);
        btn11.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to logout?",
                    "Logout Confirmation",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                setVisible(false);
                new login();
            }
        });

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/Axis2.jpg"));
        Image image2 = i111.getImage().getScaledInstance(1525, 670, Image.SCALE_SMOOTH);
        JLabel label2 = new JLabel(new ImageIcon(image2));
        label2.setBounds(0, 0, 1525, 670);

        panel.add(label2);

        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new reception();
    }
}
