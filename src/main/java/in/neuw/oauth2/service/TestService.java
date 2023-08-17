package in.neuw.oauth2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TestService {

    private final WebClient webClientTest;

    private final String messagePath;

    public TestService(final WebClient webClientTest,
                       final @Value("${resource.path}") String messagePath) {
        this.webClientTest = webClientTest;
        this.messagePath = messagePath;
    }

    public String getMessage() {
        return webClientTest.get().uri(messagePath).retrieve().bodyToMono(String.class).block();
    }

}
