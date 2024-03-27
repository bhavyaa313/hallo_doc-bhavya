package hallodoc.helper;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
	
	public String GenerateToken( ) {
		
	
	String token = UUID.randomUUID().toString();
	return token;
	}
	

}
