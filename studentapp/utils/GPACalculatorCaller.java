package studentapp.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GPACalculatorCaller {
    
    // Calls the Python GPA calculator with grades input as "4,3;3,3;2,2" format
    public static String calculateGPA(String gradesInput) {
        String gpa = "";
        try {
            // Modify the path to your Python interpreter if needed
            String pythonCommand = "python C:/Users/hp/Desktop/Myprojects/Component/src/gpa_calculator.py";
            ProcessBuilder processBuilder = new ProcessBuilder(pythonCommand, gradesInput);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            gpa = reader.readLine();

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gpa;
    }
}
