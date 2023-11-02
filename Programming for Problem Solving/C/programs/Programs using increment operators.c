//Programs using increment operators

#include <stdio.h>
int main()
{
    int n;
    printf("Enter a Number: ");
    scanf("%d", &n);
    printf("The number is %d", n);
    printf("\nThe number after pre-increment is %d", ++n);
    printf("\nThe number after 1st post-increment is %d", n++);
    printf("\nThe number anfter 2nd post-increment is %d", n++);
    return 0;
}
