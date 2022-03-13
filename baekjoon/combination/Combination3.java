package self.baekjoon.combination;

public class Combination3 {
    static int[] arr = {1, 2 ,3 ,4};
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) {

        combination(0, 2);
    }

    static void combination(int start, int r) {
        if(r == 0) {
            print();
            return;
        }

        for(int i=start; i< arr.length; i++) {
            visited[i] = true;
            combination(i+1, r-1);
            visited[i] = false;
        }
    }

    static void print(){
        for(int i=0; i<arr.length; i++) {
            if(visited[i]){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

}