package com.poc.springretry.controllers;

import com.poc.springretry.domain.Command;
import com.poc.springretry.services.RecoverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recover-test")
@Slf4j
@AllArgsConstructor
public class RecoverController {

  private final RecoverService recoverService;

  @PostMapping
  public ResponseEntity<?> post(@RequestBody Command command) {
    log.info("Received post request");
    recoverService.commad(command);
    return ResponseEntity.ok().build();
  }

}