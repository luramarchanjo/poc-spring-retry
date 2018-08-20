package com.poc.springretry.services;

import com.poc.springretry.domain.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimpleRetryService {

  @Retryable
  public void commad(Command command) {
    log.info("Executing {}", command);
    throw new NullPointerException("Testing @Retryable annotation");
  }

}
