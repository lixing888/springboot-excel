package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.cnblogs.com/linjiqin/p/10975761.html
 * 导出访问地址
 * http://localhost:8888/api/hello/exportExcel
 * <p>
 * 导入访问地址
 * http://localhost:8888/api/hello/readExcel
 * swagger地址
 * http://localhost:8888/swagger-ui.html#/
 *
 * @author lixing
 */
@SpringBootApplication
public class SpringbootExeclApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExeclApplication.class, args);
    }

}
