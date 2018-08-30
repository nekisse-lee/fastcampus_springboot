package com.nekisse.myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(value = {"com.nekisse.myweb.**"})
public class MyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWebApplication.class, args);
    }


    //com.samskivert.mustache.MustacheException$Context: No method or field with name 'variable'.... 에러에 대한 처리..

    //Override MustacheAutoConfiguration to support defaultValue("")
    /*@Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader mustacheTemplateLoader,
                                              Environment environment) {

        MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
        collector.setEnvironment(environment);

        // default value
        Mustache.Compiler compiler = Mustache.compiler().defaultValue("")
                .withLoader(mustacheTemplateLoader)
                .withCollector(collector);
        return compiler;

    }*/
}

