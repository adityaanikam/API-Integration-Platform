package com.apiplatform.controller;

//import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.error.ErrorController;
/*@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error"; // Render a custom error page from `templates/error.html`
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
*/




@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error"; // Render a custom error page from `templates/error.html`
    }

   // @Override
    public String getErrorPath() {
        return "/error";
   }
}