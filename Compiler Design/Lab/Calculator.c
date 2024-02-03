#include <stdio.h>
void main()
{
  int num1,num2,opt;
  printf("Enter the first inetger:");
  scanf("%d",&num1);
  printf("Enter the second inetger:");
  scanf("%d",&num2);
  while(opt!=5)
  {
    printf("\nInput your operation:\n");
    printf("1-Addition.\n 2-Subtraction.\n 3-Multiplication.\n 4-Division.\n 5-Exit.\n");
    scanf("%d",&opt);
    switch(opt)
    {
      case 1:
      printf("The Additon of %d and %d is: %d\n",num1,num2,num1+num2);
      break;
      case 2:
      printf("The Subtraction of %d and %d is: %d\n",num1,num2,num1-num2);
      break;
      case 3:
      printf("The Multiplication of %d and %d is: %d\n",num1,num2,num1*num2);
      break;
      case 4:
      if(num2==0)
      {
        printf("The second integer is zero.Divide by zero\n");
      }
      else
      {
        printf("The Division of %d and %d is: %d\n",num1,num2,num1/num2);
      }
      break;
      case 5:
      break;
      default:
      printf("Input Option incorrect. Please enter the correct option!\n");
      break;
    }
  }
}
