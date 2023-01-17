package prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 스프링 부트, 스프링 빈 읽기와 생성 등을 자동으로 설정한다.
// '@SpringBootApplication'이 있는 위치부터 설정을 읽어가므로, 프로젝트의 최상단에 위치해야 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
