package temperaturebean;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendar with Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a Calendar component
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        JLabel calendarLabel = new JLabel(dateFormat.format(calendar.getTime()));

        // Create and add the TemperatureConverterBean
        TemperatureConvertorBean temperatureConverter = new TemperatureConvertorBean();
        frame.add(calendarLabel, BorderLayout.NORTH);
        frame.add(temperatureConverter, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

