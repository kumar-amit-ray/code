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
