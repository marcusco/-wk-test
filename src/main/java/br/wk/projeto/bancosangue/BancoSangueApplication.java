package br.wk.projeto.bancosangue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BancoSangueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancoSangueApplication.class, args);
    }

}
