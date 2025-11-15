package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    JTable table;

    Employee_info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);


        table = new JTable();
        table.setBackground(new Color(109, 164, 170));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 970, 500);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(109, 164, 170));
        panel.add(scrollPane);


        JButton backButton = new JButton("BACK");
        backButton.setBounds(440, 530, 100, 30);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.addActionListener(e -> setVisible(false));
        panel.add(backButton);

        try {
            conn c = new conn();
            String q = "SELECT * FROM EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setSize(1000, 600);
        setLayout(null);
        setLocation(350, 230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
