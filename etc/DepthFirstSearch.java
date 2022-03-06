package self.etc;
/**
 * 깊이우선탐색
 *
 * <pre>
 *                                                      B
 *   １━━━５━━━１５━━３５━━━７０━━126 4,5 -  5,4
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   １━━━４━━━１０━━２０━━３５━━━５６
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   １━━━３━━━６━━━１０━━１５━━━２１
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   １━━━２━━━３━━━━４━━━５━━━６
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   ┃      ┃      ┃      ┃      ┃      ┃
 *   １━━━１━━━１━━━━１━━━１━━━１
 *   0,0
 *
 *   9C4   9C5  i+j C i
 *   n!/(n-k)!*k!
 *
 *   수열의합.
 *
 *   시그마    1 2 3 4 5 6 ... n
 *
 *   n*(n+1)/2
 *
 *   S = 1+2+3+4 ...1+(n-2)  1 +(n-1)  n
 *   S = n + 1 +(n-1) + 1+(n-2) ....
 *   S = n(n+1)/2
 *
 *
 *   １━━━３━━━６
 *   ┃         ┃        ┃
 *   ┃         ┃        ┃
 *   １━━━２━━━３
 *   ┃         ┃        ┃
 *   ┃         ┃        ┃
 *   １━━━１━━━１
 *
 * </pre>
 *
 * A->B 가는경우의수 구하기.
 *
 * @author syh
 *
 */
public class DepthFirstSearch {

    static int[][] dfsArr = new int[6][5];
    static int[][] dfsExptArr = new int[6][5];

    final static int maxHt = 5;
    final static int maxWt = 4;

    public static void main(String[] args) {

        // 제외하고싶은좌표
        dfsExptArr[5][1] = 1;
        dfsExptArr[1][4] = 1;

        System.out.println("dfsRecrsion = [" + dfsRecrsion(0, 0) + "]");

        // 전역변수 초기화.
        dfsArr = new int[6][5];

        System.out.println("dynamicPlan = [" + dynamicPlan() + "]");
    }

    /**
     * 깊이우선탐색 재귀. A-> B
     *
     * A부터 가는 방법으로 계산.
     *
     * @param h
     * @param w
     * @return
     */
    private static int dfsRecrsion(int curHt, int curWt) {

        if (curHt > maxHt || curWt > maxWt || dfsExptArr[curHt][curWt] == 1)
            return 0;

        if (curHt == maxHt && curWt == maxWt)
            return 1;

        if (dfsArr[curHt][curWt] != 0)
            return dfsArr[curHt][curWt];

        dfsArr[curHt][curWt] = dfsRecrsion(curHt + 1, curWt) + dfsRecrsion(curHt, curWt + 1);

        return dfsArr[curHt][curWt];
    }

    /**
     * 동적 계획법 계산으로 문제해결. A-> B
     *
     * B까지 오는 방법으로 계산.
     *
     * @param h
     * @param w
     * @return
     */
    private static int dynamicPlan() {

        dfsArr[0][0] = 1;

        for (int i = 0; i <= maxHt; i++) {

            for (int j = 0; j <= maxWt; j++) {

                if (dfsExptArr[i][j] == 1)
                    continue;

                if (i > 0)
                    dfsArr[i][j] += dfsArr[i - 1][j];
                if (j > 0)
                    dfsArr[i][j] += dfsArr[i][j - 1];
            }
        }

        return dfsArr[maxHt][maxWt];
    }
}
