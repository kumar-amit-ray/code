/**
 * @Leetcode - https://leetcode.com/problems/k-closest-points-to-origin/
 * @Youtube - https://www.youtube.com/watch?v=eaYX0Ee0Kcg
 */
@AllArgsConstructor
@Getter
class PqElement {
    private int index;
    private int value;

    public int compare(PqElement o2) {
        return this.value - o2.value;
    }
}
public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PqElement> pq = new PriorityQueue<>((PqElement::compare));
        for (int i=0; i<points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new PqElement(i, distance));
        }
        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            PqElement min = pq.poll();
            result[i] = points[min.getIndex()];
        }
        return result;
    }
}
