package prac.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prac.web.dto.HelloResponseDto;

@RestController // JSON을 반환하는 컨트롤러로 만든다. ('@ResponseBody'를 각 메소드마다 선언하지 않아도 된다.)
public class HelloController {

    // HTTP 메소드인 Get 요청을 받을 수 있는 API를 만들어 준다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
