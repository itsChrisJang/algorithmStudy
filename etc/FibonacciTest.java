package self.etc;

public class FibonacciTest {

    public static void main(String[] args) {

        FibonacciTest fibonacciTest = new FibonacciTest(); //객체생성 인스턴스생성.

        int result = fibonacciTest.fibo_v1(11);
        int result2 = fibonacciTest.fibo_v2(11);
        int result3 = fibonacciTest.fibo_v3(11);
        System.out.println(result2);
        System.out.println(result3);
        //System.out.println(fibonacciTest.fibo_v2(7));
    }

    // 1 2 3 4 5 6  7  8  9 10 11
    // 1 1 2 3 5 8 13 21 34 55 89
    int fibo_v1(int loc) {
        if(loc < 0) {
            System.out.println("파라미터는 1부터 큰 수부터 입력가능합니다.");
            return 0;
        }
        if(loc <= 2) {
            return 1;
        }
        return fibo_v1(loc - 1) + fibo_v1(loc -2);
    }

    // 1 2 3 4 5 6  7  8  9 10 11
    // 1 1 2 3 5 8 13 21 34 55 89
    int mem2[] = new int[50];


    //if idx = 3
    int fibo_v2(int idx) {
        if(idx <= 1) {
            return 1;
        }else if(mem2[idx] != 0) {
            return mem2[idx];
        }else {
            mem2[idx] = fibo_v2(idx-1) + fibo_v2(idx - 2);
            return mem2[idx];
        }
    }

    int fibo_v3(int idx) {
        int x = 0;      //x는 idx-2번째
        int y = 0;      //y는 idx-1번째
        int result =0;  //result는 idx번째

        for(int i=0; i<idx; i++) {
            if(i == 0) {
                y = 1;
            }
            result = x + y;
            x = y;
            y = result;
        }

        return result;
    }
}
