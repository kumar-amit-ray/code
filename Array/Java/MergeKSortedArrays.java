class PqElement {
    private int arrayIndex;
    private int valueIndex;
    private int value;


    public int getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public int getValueIndex() {
        return valueIndex;
    }

    public void setValueIndex(int valueIndex) {
        this.valueIndex = valueIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    PqElement(int arrayIndex, int valueIndex, int value) {
        this.arrayIndex = arrayIndex;
        this.valueIndex = valueIndex;
        this.value = value;
    }

    int compare(PqElement o2) {
        return this.value - o2.value;
    }
}
public class MergeKSortedArray {
    PriorityQueue<PqElement> pq = new PriorityQueue<PqElement>((o1, o2) -> o1.compare(o2));

    public List<Integer> merge(int[][] kSortedArrays) {
        for (int i=0; i<kSortedArrays.length; i++) {
            PqElement pqElement = new PqElement(i, 0, kSortedArrays[i][0]);
            pq.add(pqElement);
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            PqElement smallest = pq.poll();
            result.add(smallest.getValue());
            smallest.setValueIndex(smallest.getValueIndex()+1);
            if (smallest.getValueIndex()<kSortedArrays[smallest.getArrayIndex()].length) {
                smallest.setValue(kSortedArrays[smallest.getArrayIndex()][smallest.getValueIndex()]);
                pq.add(smallest);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] kSortedArrays = new int[][] {{1,3,6,8},{2,4,5,7},{9,11,13,15},{9,10,12,14}};
        System.out.println(new MergeKSortedArray().merge(kSortedArrays));
    }
}
