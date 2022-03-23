# Spring Cloud Gateway Megastore example

## Architecture

```
                               /super-prices => /prices             ┌───────────────────────────────┐
                              ┌────────────────────────────────────►│                               │
                              │                                     │   pricing-service             │
                              │                                     │                               │
                              │                                     │   Port: 9090                  │
                              │                                     │   Host: localhost             │
                       ┌──────┴────────────────────────┐            │                               │
                       │                               │            └───────────────────────────────┘
http requests          │  Megastore Gateway            │
─────────────────────► │                               │
                       │  Port: 8080                   │
                       │  Host: localhost              │            ┌───────────────────────────────┐
                       │                               │            │                               │
                       └───────┬───────────────────────┘            │   shopping-cart-service       │
                               │                                    │                               │
                               │                                    │   Port: 9080                  │
                               │                                    │   Host: localhost             │
                               └───────────────────────────────────►│                               │
                                /shoppingcard => /shoppingcard      └───────────────────────────────┘
```


## How to run?
Start each microservice by using `mvn spring-boot:run`.

## How to test it?
Using curl:
- Query prices through our gateway: `curl http://localhost:8080/super-prices | jq`
- Query shopping card through our gateway: `curl -H "x-customer-class: rich"  http://localhost:8080/shoppingcard | jq`

(jq is optional but recommended)