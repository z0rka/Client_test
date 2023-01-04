package org.example;


import org.example.handlers.ClientHandler;

/**
 * @author Kostiantyn Kvartyrmeister on 18.12.2022
 */
public class Main {

  public static void main(String[] args) {
    ClientHandler handler = new ClientHandler();
    handler.start();
  }
}

