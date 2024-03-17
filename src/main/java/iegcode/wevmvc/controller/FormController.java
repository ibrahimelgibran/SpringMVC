package iegcode.wevmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @PostMapping(
            path = "form/hello",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, // consumes menerima data jenis apa..
            produces = MediaType.TEXT_HTML_VALUE // produces membuat data bentuk apa..
    )

    @ResponseBody
    private String hello(@RequestParam(name = "name") String name){
        return """
                <html>
                <body>
                <h1>Hello $name</h1>
                </body>
                </html>
                """.replace("$name", name);
    }
}
