/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author mudra
 */
import models.User;
import javax.swing.*;
import java.awt.*;

public class ViewPage extends JPanel {
    private JLabel nameLabel, ageLabel, emailLabel, messageLabel, patientTypeLabel, genderLabel, imageLabel;

    public ViewPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Set background color
        setBackground(new Color(240, 248, 255)); // Light blue

        // Labels for displaying user information
        nameLabel = new JLabel();
        ageLabel = new JLabel();
        emailLabel = new JLabel();
        messageLabel = new JLabel();
        patientTypeLabel = new JLabel();
        genderLabel = new JLabel();
        imageLabel = new JLabel();

        // Add components to form with GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        add(ageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        add(emailLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Message:"), gbc);
        gbc.gridx = 1;
        add(messageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Patient Type:"), gbc);
        gbc.gridx = 1;
        add(patientTypeLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        add(genderLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Photo:"), gbc);
        gbc.gridx = 1;
        add(imageLabel, gbc);
    }

    // Method to display user information
    public void displayUserInfo(User user) {
        nameLabel.setText(user.getFirstName() + " " + user.getLastName());
        ageLabel.setText(String.valueOf(user.getAge()));
        emailLabel.setText(user.getEmail());
        messageLabel.setText(user.getMessage());
        patientTypeLabel.setText(user.getPatientType());
        genderLabel.setText(user.getGender());

        // Display user's uploaded photo
        if (user.getPhoto() != null) {
            ImageIcon icon = new ImageIcon(user.getPhoto().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            imageLabel.setIcon(icon);
        } else {
            imageLabel.setText("No Image");
        }
    }
}
