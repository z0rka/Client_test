package org.example.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Kostiantyn Kvartyrmeister on 25.12.2022
 */
public class ClientHandler {

  private static final int PORT = 8080;
  private static final String HOST = "localhost";
  private boolean exit = false;

  /**
   * Menu for client
   */
  private void printMenu() {

    System.out.println("-".repeat(20));
    System.out.println("Commands for server");
    System.out.println("-".repeat(20));
    System.out.println("0.exit");
    System.out.println("1.send file");

  }

  /**
   * Handler that sends commands to the server
   *
   * @param socket - socket of server
   */
  private void commandsHandler(Socket socket) {
    try (ObjectOutputStream objectStream = new ObjectOutputStream(
        socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
    ) {

      String inputLine;

      Scanner scanner = new Scanner(System.in);
      int option;

      while (!exit) {

        if (reader.ready()) {
          inputLine = reader.readLine();
          System.out.println(inputLine);
        }

        printMenu();

        System.out.println("Choose option");
        option = scanner.nextInt();

        switch (option) {
          case 0:

            objectStream.writeObject("exit");

            exit = true;
            break;

          case 1:
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Enter path to file");
            String pathToFile = scanner1.nextLine();

            File file = new File(pathToFile);

            objectStream.writeObject(file);

            break;

          default:
            System.out.println("Wrong option -_-");
            break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Start of client
   */
  public void start() {
    try (Socket socket = new Socket(HOST, PORT)
    ) {
      commandsHandler(socket);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

