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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.SpinnerDateModel;

public class FormPage extends JPanel {
    private JTextField firstNameField, lastNameField, ageField, emailField;
    private JTextArea messageField;
    private JComboBox<String> patientTypeCombo;
    private JRadioButton maleButton, femaleButton;
    private JLabel imageLabel;
    private JButton uploadButton, submitButton;
    private JSpinner dateSpinner;  // JSpinner for date picking
    private User user;

    public FormPage() {
        user = new User();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Color scheme - Blue and light gray
        setBackground(new Color(230, 240, 255));

        // Form fields
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        ageField = new JTextField(15);
        emailField = new JTextField(15);
        messageField = new JTextArea(5, 15);
        messageField.setLineWrap(true);
        messageField.setWrapStyleWord(true);
        JScrollPane messageScrollPane = new JScrollPane(messageField);
        patientTypeCombo = new JComboBox<>(new String[]{"General", "Special", "Emergency"});

        // Radio buttons for gender
        ButtonGroup genderGroup = new ButtonGroup();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        maleButton.setBackground(new Color(230, 240, 255));
        femaleButton.setBackground(new Color(230, 240, 255));
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Date picker using JSpinner
        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateSpinner.setEditor(dateEditor);  // Set date format

        // Upload image button
        uploadButton = new JButton("Upload Image");
        imageLabel = new JLabel("No Image");
        uploadButton.setBackground(new Color(100, 149, 237));  // Cornflower blue button
        uploadButton.setForeground(Color.BLACK);
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
                    Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Fix image size
                    user.setPhoto(img);
                    imageLabel.setIcon(new ImageIcon(img));  // Display resized image in JLabel
                }
            }
        });

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(0, 128, 128));  // Teal
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    // Save user info
                    user.setFirstName(firstNameField.getText());
                    user.setLastName(lastNameField.getText());
                    user.setAge(Integer.parseInt(ageField.getText()));
                    user.setEmail(emailField.getText());
                    user.setMessage(messageField.getText());
                    user.setPatientType((String) patientTypeCombo.getSelectedItem());
                    user.setGender(maleButton.isSelected() ? "Male" : "Female");
                    user.setAppointmentDate((Date) dateSpinner.getValue());  // Get selected date from JSpinner

                    // Show view page after form submission
                    MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(FormPage.this);
                    ViewPage viewPage = (ViewPage) mainFrame.cardPanel.getComponent(1);
                    viewPage.displayUserInfo(user);

                    mainFrame.cardLayout.show(mainFrame.cardPanel, "view");
                }
            }
        });

        // Add components to form with GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Message:"), gbc);
        gbc.gridx = 1;
        add(messageScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Patient Type:"), gbc);
        gbc.gridx = 1;
        add(patientTypeCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        add(maleButton, gbc);
        gbc.gridx = 2;
        add(femaleButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Appointment Date:"), gbc);  // Add date picker label
        gbc.gridx = 1;
        add(dateSpinner, gbc);  // Add date spinner

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(uploadButton, gbc);
        gbc.gridx = 1;
        add(imageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        add(submitButton, gbc);
    }

    private boolean validateInput() {
        // Validation logic (simplified)
        if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                ageField.getText().isEmpty() || emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}