package com.example.ebridge.Model;

public interface MessageMediator {
   public void send(String message , User user);

   public void receive(String message , User user);
}
