// PROGRAM TO FIND AREA OF CIRCLE
#include <stdio.h>

int main()
{
    int r;
    float area;
    printf("Enter the radius of circle in cm: ");
    scanf("%d",&r);
    printf("\n");

    area=3.14*r*r;
    printf("Area of the circle in cm^2 is: %.3f",area);
    printf("\n");

    return 0;
}


