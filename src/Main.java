import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame implements ActionListener {
    private JTextField identity, password;
    public JButton login, exit, deposit, withdraw;
    private JLabel info;
    private int money = 78000;

    public Main() {

        setLocation(600,200);
        setTitle("Bank Management System");
        setSize(340, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon logo = new ImageIcon("bank.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.LIGHT_GRAY);

        identity =new JTextField();
        identity.setBounds(20, 20, 100, 30);
        add(identity);

        password = new JTextField();
        password.setBounds(20, 60, 100, 30);
        add(password);

        login = new JButton();
        login.setBounds(20, 100, 100, 50);
        add(login);
        login.setFocusable(false);
        login.setBackground(Color.DARK_GRAY);
        login.setText("Login");
        login.setForeground(Color.WHITE);

        exit = new JButton();
        exit.setBounds(130, 100, 100, 50);
        add(exit);
        exit.setFocusable(false);
        exit.setBackground(Color.DARK_GRAY);
        exit.setText("Exit");
        exit.setForeground(Color.WHITE);

        deposit = new JButton();
        deposit.setBounds(20, 100, 100, 50);
        add(deposit);
        deposit.setFocusable(false);
        deposit.setBackground(Color.DARK_GRAY);
        deposit.setText("Deposit");
        deposit.setForeground(Color.WHITE);

        withdraw = new JButton();
        withdraw.setBounds(130, 100, 100, 50);
        add(withdraw);
        withdraw.setFocusable(false);
        withdraw.setBackground(Color.DARK_GRAY);
        withdraw.setText("Withdraw");
        withdraw.setForeground(Color.WHITE);

        login.addActionListener(this);
        exit.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        KeyAdapter enterListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick();
                }
            }
        };
        identity.addKeyListener(enterListener);
        password.addKeyListener(enterListener);



        info = new JLabel("Account 1 : " + money + " $");
        info.setBounds(10, 10, 200, 50);
        add(info);
        info.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == login) {
                String id = identity.getText();
                String pass = password.getText();
                if (id.equals("mustafa") && pass.equals("12345")) {
                    JOptionPane.showMessageDialog(this, "Login Successful!" + "\nWelcome Mustafa!");
                    identity.setVisible(false);
                    password.setVisible(false);
                    login.setVisible(false);
                    exit.setVisible(false);
                    info.setVisible(true);
                    setSize(300,300);
                } else {
                    JOptionPane.showMessageDialog(this, "Login Failed");
                }
            } else if (e.getSource() == exit) {
                System.exit(0);
            }

            if (e.getSource() == deposit) {
                String deposit = JOptionPane.showInputDialog(this, "Enter the amount you want to deposit: ");
                int depositAmount = Integer.parseInt(deposit);
                int currentAmount = 78000;
                int newAmount = currentAmount + depositAmount;
                info.setText("Account 1 : " + newAmount + " $");
                JOptionPane.showMessageDialog(this, "Deposit Successful!");
            }
            if (e.getSource() == withdraw) {
                String withdraw = JOptionPane.showInputDialog(this, "Enter the amount you want to withdraw: ");
                int withdrawAmount = Integer.parseInt(withdraw);
                int currentAmount = 78000;
                int newAmount = currentAmount - withdrawAmount;
                info.setText("Account 1 : " + newAmount + " $");
                JOptionPane.showMessageDialog(this, "Withdraw Successful!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}