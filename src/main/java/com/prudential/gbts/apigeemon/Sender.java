package com.prudential.gbts.apigeemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import com.prudential.gbts.apigeemon.Apilog;

import java.math.BigDecimal;

@RestController
@RequestMapping("/logs")
public class Sender {

  @Autowired private JmsTemplate jmsTemplate;

  @PostMapping("/send")
  public void send(@RequestBody Apilog apilog) {
    System.out.println("Sending a apilog.");
    jmsTemplate.convertAndSend(
        "APILogQueue", apilog);
  }
}
