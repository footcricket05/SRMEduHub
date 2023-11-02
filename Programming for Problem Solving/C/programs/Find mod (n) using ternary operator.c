//Find |n| using ternary operator

#include <stdio.h>
int main()
{
int n, abs;
printf("Enter a Number: ");
scanf("%d", &n);
abs = (n > 0) ? n : (-n);
printf("The absolute value of %d is %d", n, abs);
return 0;
}
