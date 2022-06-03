package com.example.chatapp.controllers;

import com.example.chatapp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    //Metodo que controla o envio de mensagens
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")

    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        return chatMessage;

    }

    // método que controla o acesso/inserção de usuário na aplicação
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){

        // possibilitar a inserção /adição de um username e, consequentemente um novo
        //usuário na web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
