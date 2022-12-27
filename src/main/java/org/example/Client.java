package org.example;

import java.io.Serializable;
import java.net.Socket;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Kostiantyn Kvartyrmeister on 26.12.2022
 */

@AllArgsConstructor
@Getter
public class Client implements Serializable {

  private String name;
  private Socket socket;

}
