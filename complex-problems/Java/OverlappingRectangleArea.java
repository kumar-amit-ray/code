/**
    @Youtube - https://www.youtube.com/watch?v=zGv3hOORxh0
    @Leetcode - Probably https://leetcode.com/problems/rectangles-area/
 */
public class OverlappingAreaRectangle {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int R1Lx = A, R1Ly = B, R1Tx = C, R1Ty = D, R2Lx = E, R2Ly = F, R2Tx = G, R2Ty = H;
        int xWidth = findWidth(R1Lx, R1Tx, R2Lx, R2Tx);
        // rectangle never overlaps
        if (xWidth <= 0 ) {
            return 0;
        }
        int yWidth = findWidth(R1Ly, R1Ty, R2Ly, R2Ty);
        return xWidth * yWidth;
    }

    private int findWidth(int R1Lxy, int R1Txy, int R2Lxy, int R2Txy) {
        return (Math.min(R1Txy, R2Txy) - Math.max(R1Lxy, R2Lxy));
    }

    public static void main(String[] args) {
        System.out.println(new OverlappingAreaRectangle().computeArea(1, 1, 5,4, 3, 1,6, 5));
        System.out.println(new OverlappingAreaRectangle().computeArea(-3, 0, 3,4, 0, -1,9, 2));
    }
