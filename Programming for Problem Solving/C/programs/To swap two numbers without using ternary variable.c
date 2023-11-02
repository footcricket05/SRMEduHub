//Program to swap two numbers without using ternary variable

#include<stdio.h>
int main()
{
   int x,y;
   printf("enter x value:");
   scanf("%d",&x);
   printf("enter y value:");
   scanf("%d",&y);
   x=x*y;
   y=x/y;
   x=x/y;
   printf("After swap x=%d and y=%d",x,y);
   return 0;
}
