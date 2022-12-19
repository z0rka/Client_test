package org.example;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Kostiantyn Kvartyrmeister on 18.12.2022
 */
public class Main {

  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8080);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {
      for (int i = 0; i < 10; i++) {
      }
      writer.println("exit");
    } catch (IOException e) {
     e.printStackTrace();
    }
  }
}
