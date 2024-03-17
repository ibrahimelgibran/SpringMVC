package iegcode.wevmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String cratePerson(
            @RequestParam( name = "name")String name,
            @RequestParam( name = "birthDate") Date birthDate,
            @RequestParam( name = "address")String address
    ){
        return "Success create Person with name : " + name +
                ", birthDate : " + dateFormat.format(birthDate) +
                ", address : " + address;
    }

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
