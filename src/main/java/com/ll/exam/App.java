package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        //가장 마지막 명언 글의 번호
        int wiseSayingLastId = 0;

        outer:
        while(true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();

            switch ( cmd ) {
                case "종료":
                    break outer;
                case "등록":
                    int id = ++wiseSayingLastId;
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    System.out.println(id + "번째 명언이 등록되었습니다.");
                    continue;
            }
        }

        sc.close();
    }
}