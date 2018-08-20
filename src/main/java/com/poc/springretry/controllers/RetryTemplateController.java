package com.poc.springretry.controllers;

import com.poc.springretry.domain.Command;
import com.poc.springretry.services.RetryTemplateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.backoff.NoBackOffPolicy;
import org.springframework.retry.backoff.UniformRandomBackOffPolicy;
import org.springframework.retry.policy.AlwaysRetryPolicy;
import org.springframework.retry.policy.CircuitBreakerRetryPolicy;
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

  @PostMapping("/exponential-test")
  public ResponseEntity<?> testExponential(@RequestBody Command command) {
    log.info("Received post request");

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(new ExponentialBackOffPolicy());
    retryTemplate.setRetryPolicy(new SimpleRetryPolicy());

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/exponential-random-test")
  public ResponseEntity<?> testExponentialRandom(@RequestBody Command command) {
    log.info("Received post request");

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(new ExponentialRandomBackOffPolicy());
    retryTemplate.setRetryPolicy(new SimpleRetryPolicy());

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/no-back-off-test")
  public ResponseEntity<?> testNoBackOffPolicy(@RequestBody Command command) {
    log.info("Received post request");

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(new NoBackOffPolicy());
    retryTemplate.setRetryPolicy(new SimpleRetryPolicy());

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/uniform-back-off-test")
  public ResponseEntity<?> testUniformRandomBackOffPolicy(@RequestBody Command command) {
    log.info("Received post request");

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(new UniformRandomBackOffPolicy());
    retryTemplate.setRetryPolicy(new SimpleRetryPolicy());

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/always-retry-test")
  public ResponseEntity<?> testAlwaysRetryPolicy(@RequestBody Command command) {
    log.info("Received post request");

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(new FixedBackOffPolicy());
    retryTemplate.setRetryPolicy(new AlwaysRetryPolicy());

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }

  @PostMapping("/circuit-brake-test")
  public ResponseEntity<?> testCircuitBreakerRetryPolicy(@RequestBody Command command) {
    log.info("Received post request");

    RetryTemplate retryTemplate = new RetryTemplate();
    retryTemplate.setBackOffPolicy(new FixedBackOffPolicy());
    retryTemplate.setRetryPolicy(new CircuitBreakerRetryPolicy());

    retryTemplate.execute(retryContext -> {
      retryTemplateService.commad(command);
      return null;
    });

    return ResponseEntity.ok().build();
  }


}