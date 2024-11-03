package temperaturebean;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConvertorBean extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField inputField;
    private JButton convertButton;
    private JLabel resultLabel;
    private JComboBox<String> unitSelector;

    public TemperatureConvertorBean() {
        inputField = new JTextField(10);
        convertButton = new JButton("Convert");
        resultLabel = new JLabel();
        unitSelector = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputValue = Double.parseDouble(inputField.getText());
                    String selectedUnit = unitSelector.getSelectedItem().toString();
                    double convertedValue = 0.0;

                    if (selectedUnit.equals("Celsius")) {
                        // Conversion logic from Celsius to other units
                        convertedValue = inputValue;
                    } else if (selectedUnit.equals("Fahrenheit")) {
                        // Conversion logic from Fahrenheit to other units
                        convertedValue = (inputValue - 32) * 5 / 9;
                    } else if (selectedUnit.equals("Kelvin")) {
                        // Conversion logic from Kelvin to other units
                        convertedValue = inputValue - 273.15;
                    }

                    resultLabel.setText(String.format("%.2f %s", convertedValue, selectedUnit));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        // Add components to the panel
        add(new JLabel("Enter Temperature:"));
        add(inputField);
        add(unitSelector);
        add(convertButton);
        add(resultLabel);
    }

    public double getTemperature() {
        return Double.parseDouble(inputField.getText());
    }

    public void setTemperature(double temperature) {
        inputField.setText(String.valueOf(temperature));
    }

    public String getSelectedUnit() {
        return unitSelector.getSelectedItem().toString();
    }

    public void setSelectedUnit(String unit) {
        unitSelector.setSelectedItem(unit);
    }

}
