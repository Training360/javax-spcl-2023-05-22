# Spring Cloud tanfolyam

## Employee és Frontend service összekötése

```shell
docker run -d -e POSTGRES_DB=employees -e POSTGRES_USER=employees -e POSTGRES_PASSWORD=employees -p 5432:5432  --name employees-postgres postgres
```

## Course és Frontend service összekötése

```
docker run -d -e POSTGRES_DB=course -e POSTGRES_USER=course -e POSTGRES_PASSWORD=course -p 5434:5432  --name course-postgres postgres
```

## Kafka elindítása

```
cd kafka
docker compose up -d
```

## Career service

```shell
docker run -d -e POSTGRES_DB=career -e POSTGRES_USER=career -e POSTGRES_PASSWORD=career -p 5435:5432  --name career-postgres postgres
```

## CQRS

```shell
docker run -d -e "discovery.type=single-node" -e xpack.security.enabled=false -p 9200:9200 -p 9300:9300 --name elasticsearch elasticsearch:8.6.1
```

## Zipkin

```shell
docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin
```