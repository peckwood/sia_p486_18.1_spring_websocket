package macropolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//map MacroHandler to "/macro"
		//registry.addHandler(macroHandler(), "/macro").withSockJS();
		registry.addHandler(macroHandler(), "/macro");
	}
	
	//declare MacroHandler bean
	@Bean
	public MacroHandler macroHandler(){
		return new MacroHandler();
	}
	
}
