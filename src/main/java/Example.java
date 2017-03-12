
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class Example {

    Logger logger = LoggerFactory.getLogger(Example.class);

    @Value(value="${woniu.secret}")
    private String uuid;
    @Value(value="${woniu.number}")
    private int randomID;
    @Value(value="${woniu.limitnumber}")
    private int limitnumber;
    @Value(value = "${woniu.name}")
    private String name;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    String index(@RequestParam String param) {
        return "Hello "+param;
    }

    @RequestMapping(value="/index")
    public Map<String, Object> Index(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        map.put("randomID", randomID);
        map.put("limitnumber", limitnumber);
        map.put("name",name);
        map.put("date",new Date());

        return map;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}

