package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JLabel title, b1, passLabel, footer;
    JTextField b2;
    JPasswordField passField;
    JButton loginBtn, cancelBtn;
    JPanel panel;

    login() {
        setTitle("🏥 Hospital Management System - Login");
        setSize(500, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(102, 0, 204);
                Color color2 = new Color(0, 153, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        add(panel);

        try {
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Axis1.jpg"));
            Image i1 = imageIcon.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
            ImageIcon imageIcon1 = new ImageIcon(i1);
            JLabel label = new JLabel(imageIcon1);
            label.setBounds(310, 60, 160, 160);
            panel.add(label);
        } catch (Exception e) {
            System.out.println("⚠️ Image not found in 'icon/Axis1.jpg'");
        }


        title = new JLabel("Hospital Management System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(60, 15, 380, 40);
        panel.add(title);

        b1 = new JLabel("Username:");
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b1.setBounds(70, 110, 100, 25);
        panel.add(b1);

        b2 = new JTextField();
        b2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        b2.setBounds(160, 110, 130, 30);
        b2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(b2);

        passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passLabel.setBounds(70, 160, 100, 25);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passField.setBounds(160, 160, 130, 30);
        passField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(passField);


        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passField.requestFocusInWindow(); // Move to password field
            }
        });

        passField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginBtn.doClick(); // Trigger login
            }
        });


        loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 220, 90, 35);
        loginBtn.setBackground(new Color(0, 204, 102));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginBtn.setFocusPainted(false);
        addHoverEffect(loginBtn, new Color(0, 153, 76));
        loginBtn.addActionListener(this);
        panel.add(loginBtn);


        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(180, 220, 90, 35);
        cancelBtn.setBackground(new Color(255, 77, 77));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelBtn.setFocusPainted(false);
        addHoverEffect(cancelBtn, new Color(204, 0, 0));
        cancelBtn.addActionListener(this);
        panel.add(cancelBtn);


        footer = new JLabel("© 2025 Axis Hospital", JLabel.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(230, 230, 230));
        footer.setBounds(0, 310, 500, 30);
        panel.add(footer);

        setVisible(true);
    }


    private void addHoverEffect(JButton button, Color hoverColor) {
        Color originalColor = button.getBackground();
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String username = b2.getText();
            String password = new String(passField.getPassword());

            try {
                conn c = new conn();
                String query = "select * from login where ID='" + username + "' and PW='" + password + "'";
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "✅ Login Successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    new reception();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "⚠️ Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == cancelBtn) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new login();
    }
}


class Dashboard extends JFrame {
    Dashboard() {
        setTitle("🏥 Hospital Dashboard");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

    }
}
