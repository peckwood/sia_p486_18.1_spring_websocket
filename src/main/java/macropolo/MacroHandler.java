package macropolo;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MacroHandler extends AbstractWebSocketHandler{

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connection established");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Connection closed, status: "+status);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Received message: " + message.getPayload());
		Thread.sleep(1000);
		session.sendMessage(new TextMessage("Polo!"));
	}
}
