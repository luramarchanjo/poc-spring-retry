package com.poc.springretry.controllers;

import com.poc.springretry.domain.Command;
import com.poc.springretry.services.RetryTemplateService;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy;
import org.springframework.retry.backoff.NoBackOffPolicy;
import org.springframework.retry.backoff.UniformRandomBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry-template")
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

  @PostMapping("/exponential-test")
  public ResponseEntity<?> testExponential(@RequestBody Command command) {
    log.info("Received post request");

    ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
    exponentialBackOffPolicy.setInitialInterval(1000);

    SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
    simpleRetryPolicy.setMaxAttempts(5);

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
    retryTemplate.setRetryPolicy(simpleRetryPolicy);

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/exponential-random-test")
  public ResponseEntity<?> testExponentialRandom(@RequestBody Command command) {
    log.info("Received post request");

    ExponentialRandomBackOffPolicy exponentialRandomBackOffPolicy = new ExponentialRandomBackOffPolicy();
    exponentialRandomBackOffPolicy.setInitialInterval(1000);

    SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
    simpleRetryPolicy.setMaxAttempts(5);

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(exponentialRandomBackOffPolicy);
    retryTemplate.setRetryPolicy(simpleRetryPolicy);

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/no-back-off-test")
  public ResponseEntity<?> testNoBackOffPolicy(@RequestBody Command command) {
    log.info("Received post request");

    NoBackOffPolicy noBackOffPolicy = new NoBackOffPolicy();

    SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
    simpleRetryPolicy.setMaxAttempts(5);

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(noBackOffPolicy);
    retryTemplate.setRetryPolicy(simpleRetryPolicy);

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/uniform-back-off-test")
  public ResponseEntity<?> testUniformRandomBackOffPolicy(@RequestBody Command command) {
    log.info("Received post request");

    UniformRandomBackOffPolicy uniformRandomBackOffPolicy = new UniformRandomBackOffPolicy();

    SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
    simpleRetryPolicy.setMaxAttempts(5);

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(uniformRandomBackOffPolicy);
    retryTemplate.setRetryPolicy(simpleRetryPolicy);

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }



}