package com.poc.springretry.controllers;

import com.poc.springretry.domain.Command;
import com.poc.springretry.services.RetryTemplateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry-template-test")
@Slf4j
@AllArgsConstructor
public class RetryTemplateController {

  private final RetryTemplateService retryTemplateService;
  private final RetryTemplate retryTemplate;

  @PostMapping
  public ResponseEntity<?> post(@RequestBody Command command) {
    log.info("Received post request");

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

}