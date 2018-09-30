/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/
type stack struct {
	val []int
	top int
}

func (s *stack) stackinit() {
	s.val = make([]int, 10000)
	s.top = -1
}

func (s *stack) push(data int) {
	s.top++
	s.val[s.top] = data
}

func (s *stack) pop() int {
	if s.top == -1 {return -1}
	val := s.val[s.top]
	s.top--
	return val
}

func (s *stack) peek() int {
	val := s.val[s.top]
	return val
}

func (s *stack) size() int {
	return s.top+1
}

func evalRPN(tokens []string) int {
    var s stack
	s.stackinit()
	for _, str := range tokens {
		switch (str) {
		case "+" :
			a := s.pop()
			b := s.pop()
			s.push(a+b)
		case "*" :
			a := s.pop()
			b := s.pop()
			s.push(a*b)
		case "/" :
			a := s.pop()
			b := s.pop()
			s.push(b/a)
		case "-" :
			a := s.pop()
			b := s.pop()
			s.push(b-a)
		default:
			digit, _ := strconv.Atoi(str)
			s.push(digit)
		}
	}
	return s.pop()
}
