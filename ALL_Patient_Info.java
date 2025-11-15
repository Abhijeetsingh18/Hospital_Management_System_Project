package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {

    JTable table;
    JButton back;

    ALL_Patient_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("All Patient Details");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setBounds(330, 10, 300, 30);
        panel.add(label);

        table = new JTable();
        table.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 860, 430);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "SELECT * FROM patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBounds(380, 500, 120, 35);
        back.setBackground(new Color(0, 102, 102));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(back);

        // ✅ Back button now only closes the current window
        back.addActionListener(e -> dispose());
        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ALL_Patient_Info();
    }
}
