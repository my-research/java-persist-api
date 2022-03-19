> 해당 Repository 는 Spring Data JPA 와 JPA 에 대해서 학습하고 다양한 것들을 시도하는 공간입니다.

# JPA & Spring Data JPA

### 목차

- JPA
- Spring Data JPA

# Java Persist API

- [gradle 모듈 바로가기]()

# Docs href

- [Hibernate ORM](https://hibernate.org/orm/documentation/getting-started/)

# DB 설정하기

docker 를 이용하여 편리하게 실습에 필요한 db를 생성할 수 있습니다.

```bash
docker run --rm --name db-for-jpa -d \
-v ${PWD}/schema:/docker-entrypoint-initdb.d \
-p 5434:5432 \
-e POSTGRES_PASSWORD='jang' \
-e POSTGRES_USER="jang" \
-e POSTGRES_DB="db-for-jpa" \
postgres
```
