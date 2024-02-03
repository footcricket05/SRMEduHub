#include <iostream>
#include <conio.h>
int dp[1001][3001];
int recBananaCnt(int A,int B,int C){
  if(B<+A){
    return 0;
  }
  if(B<=C){
    return B-A;
  }
  if(A==0){
    return B;
  }
  if(dp[A][B]!==-1){
    return dp[A][B];
  }
  int maxCount=INT_MIN;
  int tripCont=B%C==0?((2*B)/C)-1:((2*B)/C)+1;
  for(inti=1;i<=A;i++){
    int curCount=recBananaCnt(A-I,B-tripCount*i,C);
    if(curCount>maxCount){
      maxCount=curCount;
      dp[A][B]=maxCount;
    }
  }
  return maxCount;
}
int maxBananaCnt(int A,int B,int C){
  memset(dp,-1,sizeof(dp));
`return recBananaCnt(A,B,C);
}
int main(){
  int A=1000;
  int B=3000;
  int C=1000;
  cout<<maxBananaCnt(A,B,C);
  return 0;
}

