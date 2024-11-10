package studentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import studentapp.utils.GPACalculatorCaller;

public class StudentAppGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student GPA Calculator");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Setting background color
        frame.getContentPane().setBackground(new Color(240, 248, 255));

        // Input Label
        JLabel inputLabel = new JLabel("Enter grades (e.g., 4,3;3,3;2,2):");
        inputLabel.setBounds(50, 30, 350, 25);
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(inputLabel);

        // Input Text Field
        JTextField inputField = new JTextField();
        inputField.setBounds(50, 70, 350, 30);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(inputField);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate GPA");
        calculateButton.setBounds(150, 120, 150, 40);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBackground(new Color(34, 139, 34)); // Green color
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2));
        calculateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(calculateButton);

        // Add hover effect for button animation
        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                calculateButton.setBackground(new Color(50, 205, 50)); // Lighter green
            }

            @Override
            public void mouseExited(MouseEvent e) {
                calculateButton.setBackground(new Color(34, 139, 34)); // Original green
            }
        });

        // Result Label
        JLabel resultLabel = new JLabel("GPA: ");
        resultLabel.setBounds(50, 180, 350, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(resultLabel);

        // Action Listener for Button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gradesInput = inputField.getText();
                String gpa = GPACalculatorCaller.calculateGPA(gradesInput);
                
                // Simple animation effect to display GPA
                new Thread(() -> {
                    try {
                        // Flashing effect for animation
                        for (int i = 0; i < 3; i++) {
                            resultLabel.setForeground(new Color(0, 128, 0)); // Green color
                            Thread.sleep(100);
                            resultLabel.setForeground(new Color(34, 139, 34)); // Darker green
                            Thread.sleep(100);
                        }
                        resultLabel.setText("GPA: " + gpa);
                    } catch (InterruptedException interruptedException) {
                        resultLabel.setText("GPA: " + gpa);
                    }
                }).start();
            }
        });

        frame.setVisible(true);
    }
}
