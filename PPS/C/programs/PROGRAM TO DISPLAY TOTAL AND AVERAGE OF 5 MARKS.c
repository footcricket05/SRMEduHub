//PROGRAM TO DISPLAY TOTAL AND AVERAGE OF 5 MARKS
#include <stdio.h>

int main()
{
    int a,b,c,d,e,total;
    float avg;

    printf("Enter marks of subject 1: ");
    scanf("%d",&a);
    printf("\n");
    printf("Enter marks of subject 2: ");
    scanf("%d",&b);
    printf("\n");
    printf("Enter marks of subject 3: ");
    scanf("%d",&c);
    printf("\n");
    printf("Enter marks of subject 4: ");
    scanf("%d",&d);
    printf("\n");
    printf("Enter marks of subject 5: ");
    scanf("%d",&e);
    printf("\n");

    total=a+b+c+d+e;
    printf("Total marks are: %d",total);
    printf("\n");

    avg=(a+b+c+d+e)/5;
    printf("Average of 5 marks are: %.2f",avg);
    printf("\n");

    return 0;
}


