package com.poc.springretry.controllers;

import com.poc.springretry.domain.Command;
import com.poc.springretry.services.SimpleRetryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple-retry")
@Slf4j
@AllArgsConstructor
public class SimpleRetryController {

  private final SimpleRetryService simpleRetryService;

  @PostMapping
  public ResponseEntity<?> post(@RequestBody Command command) {
    log.info("Received post request");
    simpleRetryService.commad(command);
    return ResponseEntity.ok().build();
  }

}