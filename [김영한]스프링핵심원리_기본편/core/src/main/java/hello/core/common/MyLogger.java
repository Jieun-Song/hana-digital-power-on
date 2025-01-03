package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Setter
@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestUrl;

    public void log(String message) {
        System.out.println("["+ uuid + "] [" + requestUrl + "] " + message);
    }
    //만들어진 다음에 id 생성
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean created: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("["+uuid + "] request scope bean destroyed: " + this);
    }

}
