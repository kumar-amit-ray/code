/*  Given two binary string, return sum */

char *addBinary(char *a, char *b)
{
	char *c, *save;
	int l1=0, l2=0, len=0, sum=0, carry=0, b1=0, b2=0;
	
	l1 = strlen(a);
	l2 = strlen(b);
	
	len = (l1 > l2)?l1:l2;
	len++;
	
	c = calloc(0, len * sizeof(char));
	save = c;
	a = a+l1-1;
	b = b+l2-1;
	
	*(c+len) = '\0';
	c = c+len-1;
	l1--;
	l2--;

	while (len > 0) {
		if (l1 >= 0) {
			b1 = (a[l1] =='0')?0:1;
			l1--;
		} else {
			b1 = 0;
		}
		if (l2 >= 0) {
			b2 = (a[l2] =='0')?0:1;
			l2--;
		} else {
			b2 = 0;
		}
		sum = b1+b2+carry;
		if (sum > 1) { carry = 1; *c='0';}
		else if (sum == 0) {carry =0; *c='0';}
		else {carry=0; *c='1';}
		c--;len--;			
	}
	if (carry == 1) {
		*c = '1';
	}
	return save;
}

In Python
==========
def sum_two_binary(bin1, bin2):
    bin1 = list(bin1)
    bin2 = list(bin2)
    carry = 0
    l1 = len(bin1)-1
    l2 = len(bin2)-1

    result = list()

    while l1 >=0 or l2 >=0:
        if l1 >=0: d1 = int(bin1[l1])
        else: d1 = 0

        if l2 >=0: d2 = int(bin2[l2])
        else: d2 = 0

        bsum = d1+d2+carry
        if bsum > 1:
            result = ['1'] + result
            carry = 1
        else:
            result = [str(bsum)] + result
            carry = 0

        l1 = l1-1
        l2 = l2-1

    #if carry is set add to the list
    if carry: result = [str(carry)] + result
    
    return ''.join(result)
