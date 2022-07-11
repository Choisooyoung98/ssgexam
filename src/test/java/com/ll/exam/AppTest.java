package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void 테스트App() {
        int rs = 5 + 10;
        assertEquals(15, rs);
    }
    @Test
    public void 문자열을_스캐너의_입력으로_설정() {
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd1 = sc.nextLine().trim();
        String cmd2 = sc.nextLine().trim();
        String cmd3 = sc.nextLine().trim();

        assertEquals("등록",cmd1);
        assertEquals("명언1",cmd2);
        assertEquals("작가1",cmd3);
    }
    @Test
    public void 표준출력을_리다이렉트하여_결과를_문자열로_받기() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.println("안녕");

        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);

    }
    @Test
    public void Rq__getIntParam() {
        Rq rq = new Rq("삭제?id=10");

        int id = rq.getIntParam("id",0);
        assertEquals(10, id);
    }
    @Test
    public void Rq__getIntParam__2() {
        Rq rq = new Rq("검색?id=10&no=1");

        int id = rq.getIntParam("id",0);
        int no = rq.getIntParam("no",0);

        assertEquals(10, id);
        assertEquals(1, no);
    }
    @Test
    public void Rq__getPath() {
        Rq rq = new Rq("삭제?id=1");
        String path = rq.getPath();
        assertEquals("삭제", path);
    }
}