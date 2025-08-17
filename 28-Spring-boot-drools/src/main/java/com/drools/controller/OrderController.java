package com.drools.controller;

import com.drools.model.Order;
import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/controller/v2")
@RestController
public class OrderController {
    @Autowired
    private KieSession kieSession;

    @PostMapping("/order")
    public Order orderNow(@RequestBody Order requestPayload) {
       List<String> firesRules = new ArrayList();
        kieSession.addEventListener(
                new DefaultAgendaEventListener(){
                    @Override
                    public void afterMatchFired(AfterMatchFiredEvent event){
                       StringBuffer prefixRule = new StringBuffer("Rule:");
                       prefixRule.append(event.getMatch().getRule().getName());
                       firesRules.add(prefixRule.toString());
                    }
                }
        );
        kieSession.insert(requestPayload);
        kieSession.fireAllRules();
        requestPayload.setRulesDecision(String.join(",",firesRules));
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Timestamp",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern(
                                "yyy-mm-dd HH:mm:ss"
                        )
                ));
        headers.add("X-Primary-Key", UUID.randomUUID().toString()+"_ORDER");
        System.out.println(headers);
        return new ResponseEntity<Order>(requestPayload,headers, HttpStatus.OK).getBody();
//        return requestPayload;
    }
}
