package com.chatify.springboot.websocket.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.chatify.springboot.websocket.api.model.ChatMessage;

@Controller
public class ChatController {
	// supposed to show when someone joins/leaves
	@MessageMapping("/chat.register")
	// the channel will be /topic/public
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	// supposed to show the message
	@MessageMapping("/chat.send")
	// the channel will be /topic/public
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}
