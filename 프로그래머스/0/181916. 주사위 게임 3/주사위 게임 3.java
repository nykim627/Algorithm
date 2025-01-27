class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        if (a==b&&b==c&&c==d){
            answer = 1111*a;
        }else if(a==b&&b==c&&a!=d){
            answer = (10*a+d)*(10*a+d);
        }else if(a==b&&b==d&&a!=c){
            answer = (10*a+c)*(10*a+c);
        }else if(a==c&&a==d&&a!=b){
            answer = (10*a+b)*(10*a+b);
        }else if(a!=b&&b==c&&c==d){
            answer = (10*b+a)*(10*b+a);
        }else if(a==b&&c==d&&a!=c){
            answer = (a+c)*Math.abs(a-c);
        }else if(a==c&&b==d&&a!=b){
            answer = (a+b)*Math.abs(a-b);
        }else if(a==d&&b==c&&a!=b){
            answer = (a+b)*Math.abs(a-b);
        }else if(a==b&&a!=c&&a!=d&&c!=d){
            answer = c*d;
        }else if(a==c&&a!=b&&a!=d&&b!=d){
            answer = b*d;
        }else if(a==d&&a!=c&&a!=b&&c!=b){
            answer = c*b;
        }else if(b==c&&b!=a&&b!=d&&a!=d){
            answer = a*d;
        }else if(b==d&&b!=a&&b!=c&&a!=c){
            answer = a*c;
        }else if(d==c&&d!=a&&d!=b&&a!=b){
            answer = a*b;
        }else if(a!=b&&a!=c&&a!=d&&b!=c&&b!=d&&c!=d){
            int min1 = Math.min(a,b);
            int min2 = Math.min(c,d);
            answer = Math.min(min1, min2);
        }
        return answer;
    }
}