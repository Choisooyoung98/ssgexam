package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        int count = 0;

        outer:
        while(true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();

            switch ( cmd ) {
                case "종료":
                    break outer;
                case "등록":
                    ++count;
                    System.out.println("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.println("작가 : ");
                    String id = sc.nextLine().trim();
                    System.out.println(count + "번째 명언이 등록되었습니다.");
            }
        }

        sc.close();
    }
}