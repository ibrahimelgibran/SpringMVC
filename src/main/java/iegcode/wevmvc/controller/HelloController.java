package iegcode.wevmvc.controller;

import iegcode.wevmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(path = "/hello")
    public void HelloWorld(@RequestParam(name = "name", required = false) String name,
                           HttpServletResponse response) throws IOException {
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/web/hello")
    public ModelAndView hello (@RequestParam(name = "name", required = false) String name){
        return new ModelAndView("hello", Map.of(
                "title", "Learn View",
                "name", name
        ));
    }
}
