@echo off
cd eureka
call mvn clean install -DskipTests
start javaw -jar ./target/eureka-1.0.0.jar
@ping -n 15 127.1 >nul 2>nul
cd ..
cd config
call mvn clean install -DskipTests
start javaw -jar ./target/config-1.0.0.jar
cd ..
cd gateway
call mvn clean install -DskipTests
start javaw -jar ./target/gateway-1.0.0.jar
cd ..
pause