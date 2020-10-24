package hello.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //get, post의 GET method를 의미한다.
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello"; //tmplates의 hello.html에 가서 랜더링 하라는 의미
        //return 한 값은 viewResolver가 화면을 찾아서 처리해준다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //return 데이터를 응답 body에 직접 넣어 주겠다는 뜻.
    public String helloString(@RequestParam("name") String name){
        //view 없이 return 문자가 그대로 내려간다(기존의 jsp와의 차이점이다)
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        //responseBody를 사용할 경우 viewResolver대신 HttpMessageConverter가 동작한다.
        //HTTP의 Body에 문자 내용을 직접 반환한다.
        //단순 문자열일경우 StringConverter동작한다.
        //객체 일 경우 JsonConverter동작한다.
        return hello;
    }

    //property 접근 방식
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
