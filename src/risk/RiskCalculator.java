package risk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RiskCalculator {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        JFrame frame = new JFrame("🌐 IoT Kalkulator rizika");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createTitledBorder("🔧 Parametri mreže"));

        JLabel lblDevices = new JLabel("Broj IoT uređaja:");
        JTextField tfDevices = new JTextField();

        JLabel lblPasswords = new JLabel("Default lozinke (da/ne):");
        JComboBox<String> cbPasswords = new JComboBox<>(new String[]{"ne", "da"});

        JLabel lblAge = new JLabel("Starost uređaja (godine):");
        JTextField tfAge = new JTextField();

        JLabel lblEncryption = new JLabel("Enkripcija Wi-Fi (da/ne):");
        JComboBox<String> cbEncryption = new JComboBox<>(new String[]{"da", "ne"});

        panelInput.add(lblDevices); panelInput.add(tfDevices);
        panelInput.add(lblPasswords); panelInput.add(cbPasswords);
        panelInput.add(lblAge); panelInput.add(tfAge);
        panelInput.add(lblEncryption); panelInput.add(cbEncryption);

        JButton btnCalculate = new JButton("🔍 Izračunaj rizik");
        JLabel lblResult = new JLabel(" ", SwingConstants.CENTER);
        lblResult.setFont(new Font("Arial", Font.BOLD, 16));
        lblResult.setForeground(new Color(0, 102, 204));

        JPanel panelResult = new JPanel(new BorderLayout());
        panelResult.setBorder(BorderFactory.createTitledBorder("📊 Rezultat"));
        panelResult.add(lblResult, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();
        panelBottom.add(btnCalculate);

        frame.add(panelInput, BorderLayout.NORTH);
        frame.add(panelResult, BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);

        btnCalculate.addActionListener(e -> {
            try {
                int devices = Integer.parseInt(tfDevices.getText().trim());
                boolean defaultPass = cbPasswords.getSelectedItem().equals("da");
                int age = Integer.parseInt(tfAge.getText().trim());
                boolean noEncryption = cbEncryption.getSelectedItem().equals("ne");

                int riskScore = RiskScoring.calculateRisk(devices, defaultPass, age, noEncryption);

                lblResult.setText("Vaš bezbednosni rizik: " + riskScore + "/10");
                lblResult.setForeground(riskScore >= 7 ? Color.RED : new Color(0, 153, 0));

            } catch (NumberFormatException ex) {
                lblResult.setText("⚠️ Proverite unos!");
                lblResult.setForeground(Color.ORANGE);
            }
        });

        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
