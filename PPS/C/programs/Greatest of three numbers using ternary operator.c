//Greatest of three numbers using ternary operator

#include <stdio.h>
int main()
{
    int a, b, c;

    printf("Enter three numbers: ");
    scanf("%d %d %d", &a, &b, &c);

    int result=(a>b)?(a>c?a:c):(b>c?b:c);

    printf("Largest of three numbers is %d ", result);

    return 0;
}
