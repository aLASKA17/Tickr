package org.example.tickr;

import org.springframework.boot.SpringApplication;

public class TestTickrApplication {

    public static void main(String[] args) {
        SpringApplication.from(TickrApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
