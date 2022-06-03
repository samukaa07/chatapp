package com.example.chatapp.model;

public class ChatMessage {

    // estabelecendo os atributos
    private MessageType type;
    private String content;
    private String sender;

    // criar uma Enum para definir o tipo construido MessageType
    public enum MessageType{
        CHAT, JOIN, LEAVE;

    }

    public MessageType getType() { return type; }

    public void setType(MessageType type) {this.type = type; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
