#include <iostream>
#include <string>
#include <tuple>

using namespace std;

string concat(string a, string b)
{
    return a + b;
}

tuple<int, int> position_of_substr(string a, string b)
{
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == b[0])
        {
            for (int j = 1; j < b.length(); j++)
            {
                if (a[i + j] != b[j])
                {
                    break;
                }

                if (j == b.length() - 1)
                {
                    return make_tuple(i + 1, i + j + 1);
                }
            }
        }
    }
    return make_tuple(-1, -1);
}

int number_of_characters(string a, char b)
{
    int count = 0;
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == b)
        {
            count++;
        }
    }
    return count;
}

int number_of_pattern(string a, string b)
{
    int count = 0;
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == b[0])
        {
            for (int j = 1; j < b.length(); j++)
            {
                if (a[i + j] != b[j])
                {
                    break;
                }

                if (j == b.length() - 1)
                {
                    count++;
                }
            }
        }
    }
    return count;
}

string reverse(string a)
{
    string b = "";
    for (int i = a.length() - 1; i >= 0; i--)
    {
        b += a[i];
    }
    return b;
}

int number_of_words(string a)
{
    int count = 0;
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == ' ')
        {
            count++;
        }
    }
    return count + 1;
}

int main()
{
    int choice;
    string str1, str2;

    while (true)
    {
        cout << "\n1. Concatenate";
        cout << "\n2. Position of a particular substring";
        cout << "\n3. Number of a particular character";
        cout << "\n4. Number of a particular pattern";
        cout << "\n5. Number of words";
        cout << "\n6. Reverse";
        cout << "\n7. Exit";
        cout << "\n\nEnter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            cout << "Enter first string: ";
            cin >> str1;
            cout << "Enter second string: ";
            cin >> str2;
            cout << "\nConcatenated string = " << concat(str1, str2);
            break;

        case 2:
            cout << "Enter the string: ";
            cin >> str1;
            cout << "Enter the substring: ";
            cin >> str2;
            int start, end;
            tie(start, end) = position_of_substr(str1, str2);
            cout << "\nPosition of substring = "
                 << "Start = " << start << " "
                 << "End = " << end;
            break;

        case 3:
            cout << "Enter the string: ";
            cin >> str1;
            char ch;
            cout << "Enter the character: ";
            cin >> ch;
            cout << "\nNumber of characters = " << number_of_characters(str1, ch);
            break;

        case 4:
            cout << "Enter the string: ";
            cin >> str1;
            cout << "Enter the pattern: ";
            cin >> str2;
            cout << "\nNumber of pattern = " << number_of_pattern(str1, str2);
            break;

        case 5:
            cout << "Enter the string: ";
            cin >> str1;
            cout << "\nNumber of words = " << number_of_words(str1);
            break;

        case 6:
            cout << "Enter the string: ";
            cin >> str1;
            cout << "\nReversed string = " << reverse(str1);
            break;

        case 7:
            exit(0);

        default:
            cout << "\nInvalid choice!";
            break;
        }

        cout << "\n";
    }
}
