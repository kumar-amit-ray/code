/*
Calculate a moving average that considers the last N values.

E.g. Take an moving array of [1,2,3,…] and lets say N=3. That means we have to calculate moving average of 3 
elements in the array. So, first it will be average of [1,2,3]. Now say element 4 is added to the array [1,2,3,4, …]. 
So now average of last 3 elements will be average of [2,3,4]. Similarly when 5 is added to the array [1,2,3,4,5, …], 
average of last 3 element will be average of [3,4,5].

Note that, this is a classical sliding window problem where we need to find sum of sliding window of size N And 
then average would be simple sliding_sum/N.
How we can implement sliding sum? We can use a circular buffer of size N to contains the sliding window. Each 
time we see an element we keep appending to the sliding window until window is full. At this point we need to 
slide the window head one position to right i.e. increment by one.
*/

type MovingAvg struct {
  queue   []int
  length  int
  sum     int
  head    int
  tail    int
}

func (m *MovingAvg) Initialize (N int) {
  m.queue = make ([]int, N)
  m.length = 0
  m.tail = 0
  m.head = 0
  m.sum = 0
}

func (m *MovingAvg) GetAverage (num int) float32 {
  m.sum += num
  if len(m.queue) == m.size {
    m.sum -= m.queue[m.head]
    m.head = (m.head + 1) % len(m.queue)
  } else {
    m.size++
  }
  
  m.queue[tail] = num
  m.tail = (m.tail + 1) % len(m.queue)
  return (m.sum/m.size)
}
