package com.restempdep.withoutsecurity;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
    @GetMapping("/home")
    public String home() {
        String msg = "Welcome to Bank ";
        return msg;
    }

    @GetMapping("/balance")
    public String getBalance() {
        String msg = "Your current balance is 5000 ";
        return msg;
    }
    @GetMapping("/statement")
    public String getStmt() {
        String msg = "Your Statement is sent to your email id ";
        return msg;
    }
    @GetMapping("/myloan")
    public String getMyLoan() {
        String msg = "Ypur loan amount due is 500000";
        return msg;
    }
    @GetMapping("/contact")
    public String contact() {
        String msg = "Thank you for contacting customer support we will get back to you ";
        return msg;
    }

}
