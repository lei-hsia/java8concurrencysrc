package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*  1. 创建一个serverSocket
*   2. server进行accept得到client
*   3. client就可以进行之前那些IO操作了
* */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8090);
        System.out.println("step1: new ServerSocket(80) ");
        while (true) {
            Socket client = server.accept();
            System.out.println("step2: client\t" + client.getPort());

            new Thread(() -> {
                try {
                    InputStream in = client.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                    while (true){
                        System.out.println(bufferedReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
