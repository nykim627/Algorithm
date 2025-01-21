#2884

h, m = input().split()
h = int(h)
m = int(m)

if 0<=h<=23 and 0<=m<=59:
    if m>=45:
        print("{0} {1}".format(h, m-45))
    else:
        if h==0:
            print("{0} {1}".format(h+24-1, m+60-45))
        else:
            print("{0} {1}".format(h-1, m+60-45))
else:
    print("조건을 만족하지 않습니다.")