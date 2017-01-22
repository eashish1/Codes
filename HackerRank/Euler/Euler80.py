from decimal import Decimal,getcontext
from math import sqrt
n = int(input())
p = int(input())
getcontext().prec = p+5

res = 0
for i in range(n+1):
    if not sqrt(i)%1 == 0:
        st = str(Decimal(i).sqrt()).replace('.','')[:p]
        digits = map(int,st)
        #print (i,sum(digits),'-------',sep='\n')
        res += sum(digits)
print (res)         