#2480

a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)

if 1<=a<=6 and 1<=b<=6 and 1<=c<=6:
    if a==b and b==c:
        print(10000+a*1000)
    elif (a==b and b!=c) or (a==c and c!=b):
        print(1000+a*100)
    elif (b==c and b!=a):
        print(1000+b*100)
    elif a!=b and a!=c and b!=c:
        print(max([a,b,c])*100)
else:
    print("조건을 만족하지 않습니다.")