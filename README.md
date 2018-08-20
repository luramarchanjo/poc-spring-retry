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

Testing BackOffPolicy & RetryPolicy

### BackOffPolicy

* [ExponentialBackOffPolicy]
* [ExponentialRandomBackOffPolicy]
* [FixedBackOffPolicy]
* [NoBackOffPolicy]
* [UniformRandomBackOffPolicy]
* [StatelessBackOffPolicy]

### RetryPolicy

* [AlwaysRetryPolicy]
* [CircuitBreakerRetryPolicy]

[spring-retry]: https://docs.spring.io/spring-batch/trunk/reference/html/retry.html
[ExponentialBackOffPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/backoff/ExponentialBackOffPolicy.html
[ExponentialRandomBackOffPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/backoff/ExponentialRandomBackOffPolicy.html
[FixedBackOffPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/backoff/FixedBackOffPolicy.html
[NoBackOffPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/backoff/NoBackOffPolicy.html
[UniformRandomBackOffPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/backoff/UniformRandomBackOffPolicy.html
[StatelessBackOffPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/backoff/StatelessBackOffPolicy.html
[AlwaysRetryPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/policy/AlwaysRetryPolicy.html
[CircuitBreakerRetryPolicy]: https://docs.spring.io/spring-retry/docs/1.1.2.RELEASE/apidocs/org/springframework/retry/policy/CircuitBreakerRetryPolicy.html