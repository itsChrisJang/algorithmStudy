package feb12;

import java.util.Arrays;

public class TrianglePerimeter {

    static int[][] d = new int[3][2];
    
    //2022-02-15
    //삼각형 둘레 구하기
    public static void main(String[] args) {

        d[0][0] = 0;
        d[0][1] = 1;
        d[1][0] = 5;
        d[1][1] = 1;
        d[2][0] = 3;
        d[2][1] = 7;

        int[] firstLocation = d[0];
        int[] secondLocation = d[1];
        int[] thirdLocation = d[2];

        TrianglePerimeter triangle = new TrianglePerimeter();

        double a = triangle.distanceBtwTwoPoints(firstLocation ,secondLocation);
        double b = triangle.distanceBtwTwoPoints(secondLocation ,thirdLocation);
        double c = triangle.distanceBtwTwoPoints(firstLocation ,thirdLocation);

        System.out.println("삼각형 둘레의 합은 : " + (a+b+c));
        //new triangle().arrayOut(firstLocation);
        //new triangle().arrayOut2(d);
    }

    double distanceBtwTwoPoints(int[] target1, int[] target2) {
        double result;

        double a = (target1[0] - target2[0]);
        double b = (target1[1] - target2[1]);

        result = (a*a + b*b);
        Math.sqrt(result);

        return Math.sqrt(result);
    }

    void arrayOut(int[] dddd) {
        for(int i = 0; i < dddd.length; i++) {
            System.out.println(dddd[i]);
        }
    }
    void arrayOut2(int[][] dddd) {
        for(int i = 0; i < dddd.length; i++) {
            System.out.println(Arrays.toString(dddd[i]));
        }
    }

}
