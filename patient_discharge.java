package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {

    patient_discharge() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100, 20, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30, 80, 150, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT number FROM patient_info");
            while (rs.next()) {
                choice.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30, 130, 150, 30);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200, 130, 150, 30);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        RNo.setForeground(Color.white);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 150, 30);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 180, 250, 30);
        INTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        INTime.setForeground(Color.white);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 30);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();
        JLabel OUTTime = new JLabel("" + date);
        OUTTime.setBounds(200, 230, 300, 30);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);

        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = "DELETE FROM patient_info WHERE number='" + choice.getSelectedItem() + "'";
                    c.statement.executeUpdate(q);
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no='"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });


        JButton Check = new JButton("CHECK");
        Check.setBounds(170, 300, 120, 30);
        Check.setBackground(Color.black);
        Check.setForeground(Color.white);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = "SELECT * FROM patient_info WHERE number='" + choice.getSelectedItem() + "'";
                    ResultSet rs = c.statement.executeQuery(q);

                    while (rs.next()) {
                        RNo.setText(rs.getString("Room_Number"));
                        INTime.setText(rs.getString("Time"));
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("BACK");
        Back.setBounds(310, 300, 120, 30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        panel.add(Back);

        Back.addActionListener(e -> setVisible(false));


        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
