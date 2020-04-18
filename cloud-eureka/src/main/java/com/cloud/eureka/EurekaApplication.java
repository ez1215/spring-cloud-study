package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    @EnableWebSecurity
    static class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable(); //关闭csrf
            super.configure(http); //开启认证

            /*
            // 在/eureka/**端点忽略csrf验证
            http.csrf().ignoringAntMatchers("/eureka/**");

            // 配置使请求需要通过httpBasic或form验证
            http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
            super.configure(http);
            */
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
