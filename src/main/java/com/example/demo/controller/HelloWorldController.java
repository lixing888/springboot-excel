package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.util.HttpServletUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.example.demo.util.ExcelUtils;
import com.example.demo.domain.BusClick;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/hello")
public class HelloWorldController {
    private static final Logger log = LogManager.getLogger(HelloWorldController.class);

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel()  throws IOException {
        List<BusClick> resultList = new ArrayList<BusClick>();
        BusClick busClick = new BusClick();
        busClick.setCityCode("a1");
        busClick.setClientVer("a2");
        busClick.setDate("a3");
        busClick.setMarkId("a4");
        busClick.setToaluv("a5");
        resultList.add(busClick);

        busClick = new BusClick();
        busClick.setCityCode("b1");
        busClick.setClientVer("b2");
        busClick.setDate("b3");
        busClick.setMarkId("b4");
        busClick.setToaluv("b5");
        resultList.add(busClick);
        HttpServletResponse response = HttpServletUtils.getResponse();        long t1 = System.currentTimeMillis();
        ExcelUtils.writeExcel(response, resultList, BusClick.class);
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("write over! cost:%sms", (t2 - t1)));
    }

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcel(@RequestParam(value="uploadFile", required = false) MultipartFile file){
        long t1 = System.currentTimeMillis();
        List<BusClick> list = ExcelUtils.readExcel("", BusClick.class, file);
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("read over! cost:%sms", (t2 - t1)));
        list.forEach(
                b -> System.out.println(JSON.toJSONString(b))
        );
    }
}
