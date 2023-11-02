// PROGRAM TO FIND AREA OF SQUARE
#include <stdio.h>

int main()
{
    int side,area;
    printf("Enter the length of side in cm: ");
    scanf("%d",&side);
    printf("\n");

    area=side*side;
    printf("Area of the square in cm^2 is: %d",area);
    printf("\n");

    return 0;
}

