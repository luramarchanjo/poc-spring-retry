package com.poc.springretry.services;

import com.poc.springretry.domain.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecoverService {

  @Retryable(value = {NullPointerException.class})
  public void commad(Command command) {
    log.info("Executing {}", command);
    throw new NullPointerException("Testing @Recover annotation");
  }

  @Recover
  public void recover(NullPointerException nullPointerException, Command command) {
    log.info("Recovering {} because of {}", command, nullPointerException.getMessage());
  }

}
