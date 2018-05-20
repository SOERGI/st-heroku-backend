package com.example.stherokubackend;

import com.example.stherokubackend.database.tables.records.ProfileRecord;
import io.swagger.api.external.model.Profile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@SpringBootApplication
//@EnableSwagger2
public class DemoApplication {

    @RequestMapping("/home")
    @ResponseBody
    String home() {
      return "Hello World2!";
    }

    public static void main(String[] args) {
        Profile p = null;
        ProfileRecord pr = null;
        SpringApplication.run(DemoApplication.class, args);
    }
}