#include <bits/stdc++.h>
#include <time.h>
using namespace std;
#define f(i,n) for(i=0;i<n;i++)
#define pb push_back
#define sd(n) scanf("%d",&n)
#define sc(n) scanf("%c",&n)
#define slld(n) scanf("%lld",&n)
#define mod 1000000007
#define mp make_pair
#define ff first
#define ss second
#define ll long long
#define gc getchar
#define pc putchar
int main()
{
    FILE * input;
    input = fopen("tips.txt","r");
    FILE * output;
    output = fopen("tipoftheday.txt","w");
    char s[1000];
    long long count=0,maxcount=time(0)-1515274212;
    cout<<maxcount<<endl;
    maxcount/=60;
    maxcount/=60;
    maxcount/=24;
    while(fscanf(input,"%[^\n]%*c",s)==1){
        if(count==maxcount)break;
        count++;
    }
    fprintf(output,"%s",s);
    fclose(output);
    fclose(input);
	return 0;
}