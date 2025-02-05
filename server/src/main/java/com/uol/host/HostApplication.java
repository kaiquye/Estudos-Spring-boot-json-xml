package com.uol.host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SpringBootApplication
public class HostApplication extends AuditingEntityListener {
  public static void main(String[] args) {
    SpringApplication.run(HostApplication.class, args);
  }
}
