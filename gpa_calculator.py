# gpa_calculator.py
import sys

def calculate_gpa(grades):
    total_points = 0
    total_credits = 0

    for grade, credits in grades:
        total_points += grade * credits
        total_credits += credits

    gpa = total_points / total_credits
    return round(gpa, 2)

if __name__ == "__main__":
    # Example input format: "4,3;3,3;2,2" -> (grade, credits) pairs
    input_data = sys.argv[1]
    grades = [(float(g.split(',')[0]), float(g.split(',')[1])) for g in input_data.split(';')]
    
    gpa = calculate_gpa(grades)
    print(gpa)
