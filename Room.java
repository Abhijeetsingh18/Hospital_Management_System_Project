package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;

    Room() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 200, 200, 200);
        panel.add(label);

        table = new JTable();
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 550, 400);
        scrollPane.getViewport().setBackground(Color.white);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(230, 470, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back.addActionListener(e -> {
            setVisible(false);   // close current window
        });

        panel.add(back);

        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(30, 230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
