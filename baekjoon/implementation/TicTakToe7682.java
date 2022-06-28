package self.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
platform | Baekjoon
number   | 7682
title    | 틱택토
level    | Gold 5
how      |
etc      |
 */
public class TicTakToe7682 {
    static char[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();
            if(input.equals("end"))
                break;

            int one = 0;
            int two = 0;
            int empty = 0;
            map = new char[3][3];
            for(int i=0; i<9; i++) {
                map[i/3][i%3] = input.charAt(i);
                if(map[i/3][i%3]=='X') one++;

                else if(map[i/3][i%3]=='O') two++;

                else empty++;
            }

            if(two>one || two>=one&&empty==0 || Math.abs(one-two)>1 || one==0&&two==0) {
                System.out.println("invalid");
                continue;
            }

            else
                sol(empty, one-two);
        }
    }

    public static void sol(int empty, int minus) {
        int xBingo = 0;
        int oBingo = 0;
        int center = 0;
        int[] db = new int[4];

        if(map[0][0] == map[0][1] && map[0][1] == map[0][2]) {
            if(map[0][0]=='X') {
                xBingo++;
                db[0]++;
            }

            else if(map[0][0]=='O') oBingo++;
        }

        if(map[1][0] == map[1][1] && map[1][1] == map[1][2]) {
            if(map[1][0]=='X') {
                xBingo++;
                center++;
            }

            else if(map[1][0]=='O') oBingo++;
        }

        if(map[2][0] == map[2][1] && map[2][1] == map[2][2]) {
            if(map[2][0]=='X') {
                xBingo++;
                db[1]++;
            }

            else if(map[2][0]=='O') oBingo++;
        }

        if(map[0][0] == map[1][0] && map[1][0] == map[2][0]) {
            if(map[0][0]=='X') {
                xBingo++;
                db[2]++;
            }

            else if(map[0][0]=='O') oBingo++;
        }

        if(map[0][1] == map[1][1] && map[1][1] == map[2][1]) {
            if(map[0][1]=='X') {
                xBingo++;
                center++;
            }

            else if(map[0][1]=='O') oBingo++;
        }

        if(map[0][2] == map[1][2] && map[1][2] == map[2][2]) {
            if(map[0][2]=='X') {
                xBingo++;
                db[3]++;
            }

            else if(map[0][2]=='O') oBingo++;
        }

        if(map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            if(map[0][0]=='X') {
                xBingo++;
                center++;
            }

            else if(map[0][0]=='O') oBingo++;
        }

        if(map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            if(map[0][2]=='X') xBingo++;

            else if(map[0][2]=='O') oBingo++;

            center++;
        }

        if(xBingo==1 && oBingo==0 && minus==1 || xBingo==0 && oBingo==1 && minus==0 || xBingo==0 && oBingo==0 && empty==0 && minus==1 || xBingo==2 && oBingo==0 && center>=1 && empty==0 || xBingo==2&&oBingo==0&&empty==0&&(db[0]==1&&db[2]==1||db[0]==1&&db[3]==1||db[1]==1&&db[2]==1||db[1]==1&&db[3]==1))
            System.out.println("valid");
        else
            System.out.println("invalid");
    }
}