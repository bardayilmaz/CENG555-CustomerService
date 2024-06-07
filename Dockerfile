FROM base:latest as builder

WORKDIR /usr/local/app

COPY ./ ./

RUN mvn \
    -Dmaven.test.skip=true \
    --batch-mode \
    package

FROM gcr.io/distroless/java21-debian12

EXPOSE 8080
WORKDIR /usr/local/app

COPY --from=builder \
    /usr/local/app/target/customerservice*.jar \
    ./server.jar

COPY ./src/main/resources ./

CMD [ "/usr/local/app/server.jar", "-Djava.security.edg=file:/dev/./urandom", "-Djava.security.egd=file:/dev/./urandom"]