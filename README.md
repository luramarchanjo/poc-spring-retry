# Overview

This is a simple poc using [spring-retry]

# Testing

* Simple retry with @Retryable
* Simple retry with @Recover
* Simple retry withe RetryTemplate, RetryPolicy and BackOffPolicy

## Retryable

* POST - http://localhost:8888/api/retry-test
* Log 3x Executing Command(command=123456)
* Log NullPointerException: Testing @Retryable annotation
  
## Recover

* POST - http://localhost:8888/api/recover-test
* Log 3x Executing Command(command=123456)
* Log Recovering Command(command=123456) because of Testing @Recover annotation

## RetryTemplate

* ExponentialBackOffPolicy
* ExponentialRandomBackOffPolicy
* FixedBackOffPolicy
* NoBackOffPolicy

[spring-retry]: https://docs.spring.io/spring-batch/trunk/reference/html/retry.html