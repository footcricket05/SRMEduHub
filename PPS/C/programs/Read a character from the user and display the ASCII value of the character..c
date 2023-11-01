//Read a character from the user and display the ASCII value of the character.

#include <stdio.h>
int main()
{
char c;
printf("Enter the character: ");
scanf("%c", &c);
printf("The character is %c\n", c);
printf("The ASCII value of the character is %d", c);
return 0;
}
