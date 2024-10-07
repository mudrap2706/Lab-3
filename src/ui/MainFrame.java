/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author mudra
 */
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JPanel cardPanel;
    CardLayout cardLayout;

    public MainFrame() {
        setTitle("Patient Registration");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Setup card layout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Initialize UI panels
        FormPage formPage = new FormPage();
        ViewPage viewPage = new ViewPage();

        cardPanel.add(formPage, "form");
        cardPanel.add(viewPage, "view");

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton formButton = new JButton("Patient Form");
        JButton viewButton = new JButton("View Patient");

        // Style the buttons
        formButton.setBackground(new Color(70, 130, 180)); // Steel blue
        formButton.setForeground(Color.BLACK);
        viewButton.setBackground(new Color(70, 130, 180)); // Steel blue
        viewButton.setForeground(Color.BLACK);

        formButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "form");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "view");
            }
        });

        buttonPanel.add(formButton);
        buttonPanel.add(viewButton);

        // Set layout and add components
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        // Show default panel
        cardLayout.show(cardPanel, "form");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
