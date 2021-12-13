package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first") //префикс first
public class FiirstController {

    @GetMapping("/")
    public String home() {
        return "first/start";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {// spring возьмет значения из url
        //http://localhost:8081/first/hello?name=Tom&surname=Jones

//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action, Model model) {
        double result;
        switch (action) {
            case "multi":
                result = a * b;
                break;
            case "addition":
                result = a / (double)b;
                break;
            case "subtract":
                result = a + b;
                break;
            case "division":
                result = a - b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("answer", "Answer = " + result);
        return "first/calculator";
    }
}
