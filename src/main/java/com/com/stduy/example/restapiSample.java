package com.com.stduy.example;


import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@RestController
@RequestMapping("/example")
public class restapiSample {

    @GetMapping("/get1")
    public void getParams1(@RequestParam(name = "params1") String params, @RequestParam(name = "params2") String params2)
    {
        System.out.println(params);
        System.out.println(params2);
    }

    @GetMapping("/get2/{param}")
    public void getParams2(@PathVariable(name = "param") String params)
    {
        System.out.println(params);
    }

    /**
     * ajax JSON.stringify({"userId":"vvvdf", "name":"tes2t"})
     * @param vo
     */
    @PostMapping("/post1")
    public void postParams1(@RequestBody exampleVo vo )
    {
        System.out.println(vo.getUserId());
        System.out.println(vo.getName());
    }

    @PostMapping("/post2")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postParams2(@RequestBody Map<String, String> param)
    {
        System.out.println(param.get("userId"));
        System.out.println(param.get("name"));
    }

}
