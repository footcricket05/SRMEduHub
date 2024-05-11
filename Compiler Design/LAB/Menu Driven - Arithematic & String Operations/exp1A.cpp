#include <iostream>

using namespace std;

float add(float num1, float num2) {
    return num1 + num2;
}

float subtract(float num1, float num2) {
    return num1 - num2;
}

float multiply(float num1, float num2) {
    return num1 * num2;
}

float divide(float num1, float num2) {
    if (num2 != 0.0)
        return num1 / num2;
    else {
        cout << "Division by zero error!" << endl;
        return 0;
    }
}

int main() {
    float num1, num2;
    int choice;
    bool exit = false;

    while (!exit) {
        cout << "\n*** Calculator Menu ***\n";
        cout << "1. Add\n";
        cout << "2. Subtract\n";
        cout << "3. Multiply\n";
        cout << "4. Divide\n";
        cout << "5. Exit\n";
        cout << "Enter your choice (1-5): ";
        cin >> choice;

        if (choice == 5) {
            exit = true;
            continue;
        }

        cout << "Enter two numbers: ";
        cin >> num1 >> num2;

        switch(choice) {
            case 1:
                cout << "Result: " << add(num1, num2) << endl;
                break;
            case 2:
                cout << "Result: " << subtract(num1, num2) << endl;
                break;
            case 3:
                cout << "Result: " << multiply(num1, num2) << endl;
                break;
            case 4:
                cout << "Result: " << divide(num1, num2) << endl;
                break;
            default:
                cout << "Invalid choice!" << endl;
                break;
        }
    }

    cout << "Calculator exited." << endl;
    return 0;
}
