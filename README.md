# Overview

This is a poc using [spring-retry]

# Testing

* Simple retry with @Retryable

## Simple retry

* POST - http://localhost:8888/api/simple-retry
* Log 3x Executing Command(command=123456)
* Log NullPointerException: Testing @Retryable annotation
* Response:
  {
      "timestamp": "2018-08-20T01:30:13.043+0000",
      "status": 500,
      "error": "Internal Server Error",
      "message": "Testing @Retryable annotation",
      "path": "/api/simple-retry"
  }

[spring-retry]: https://docs.spring.io/spring-batch/trunk/reference/html/retry.html