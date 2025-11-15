package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame {

    JTable table;

    Department() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        table = new JTable();
        table.setBackground(new Color(90, 156, 163));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(90, 156, 163));
        scrollPane.setBackground(new Color(90, 156, 163));

        scrollPane.setBounds(0, 0, 690, 420);
        panel.add(scrollPane);

        JButton b1 = new JButton("BACK");
        b1.setBounds(290, 440, 100, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(e -> setVisible(false));
        panel.add(b1);

        try {
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
