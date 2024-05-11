#include <iostream>
#include <string>
#include <sstream>

using namespace std;

string concatenate(const string &str1, const string &str2) {
    return str1 + str2;
}

string getSubstring(const string &str, int start, int length) {
    return str.substr(start, length);
}

int countWords(const string &str) {
    stringstream ss(str);
    string word;
    int count = 0;
    while (ss >> word) {
        count++;
    }
    return count;
}

int countCharacters(const string &str) {
    return str.length();
}

int countPatternOccurrences(const string &text, const string &pattern) {
    int count = 0;
    size_t pos = text.find(pattern);
    while (pos != string::npos) {
        count++;
        pos = text.find(pattern, pos + 1);
    }
    return count;
}

int main() {
    string str1, str2, pattern;
    int choice, start, length;

    do {
        cout << "\nString Operations Menu:\n";
        cout << "1. Concatenate Strings\n";
        cout << "2. Extract Substring\n";
        cout << "3. Count Number of Words\n";
        cout << "4. Count Number of Characters\n";
        cout << "5. Count Pattern Occurrence\n";
        cout << "6. Exit\n";
        cout << "Enter your choice (1-6): ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter first string: ";
                cin.ignore();
                getline(cin, str1);
                cout << "Enter second string: ";
                getline(cin, str2);
                cout << "Concatenated String: " << concatenate(str1, str2) << endl;
                break;
            case 2:
                cout << "Enter the string: ";
                cin.ignore();
                getline(cin, str1);
                cout << "Enter starting position (0-based index): ";
                cin >> start;
                cout << "Enter length of substring: ";
                cin >> length;
                cout << "Substring: " << getSubstring(str1, start, length) << endl;
                break;
            case 3:
                cout << "Enter the string: ";
                cin.ignore();
                getline(cin, str1);
                cout << "Number of words: " << countWords(str1) << endl;
                break;
            case 4:
                cout << "Enter the string: ";
                cin.ignore();
                getline(cin, str1);
                cout << "Number of characters: " << countCharacters(str1) << endl;
                break;
            case 5:
                cout << "Enter the text: ";
                cin.ignore();
                getline(cin, str1);
                cout << "Enter the pattern to find: ";
                getline(cin, pattern);
                cout << "Number of occurrences: " << countPatternOccurrences(str1, pattern) << endl;
                break;
            case 6:
                cout << "Exiting program." << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 6);

    return 0;
}
