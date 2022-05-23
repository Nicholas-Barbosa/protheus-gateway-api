FROM maven AS builder
WORKDIR /build
COPY . .
RUN mvn package

FROM payara/server-full:5.2022.2-jdk11
WORKDIR /app
COPY --from=builder /build/target/gateway.war $DEPLOY_DIR
