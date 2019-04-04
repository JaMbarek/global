@echo off
cd eureka
call mvn clean package -DskipTests docker:build
@ping -n 15 127.1 >nul 2>nul
cd ..
cd config
call mvn clean package -DskipTests docker:build
cd ..
cd gateway
call mvn clean package -DskipTests docker:build
cd ..
cd monitor/AdminServer
call mvn clean package -DskipTests docker:build
cd ..
cd monitor/ZipkinServer
call mvn clean package -DskipTests docker:build
cd ../..
pause