@echo off
setlocal enabledelayedexpansion
for /f "tokens=1-5" %%a in ('netstat -ano ^| findstr "10000"') do (
    if "%%e%" == "" (
        set pid=%%d
    ) else (
        set pid=%%e
    )
    echo !pid!
    taskkill /f /pid !pid!
    goto :node1
)
:node1
for /f "tokens=1-5" %%a in ('netstat -ano ^| findstr "10001"') do (
    if "%%e%" == "" (
        set pid=%%d
    ) else (
        set pid=%%e
    )
    echo !pid!
    taskkill /f /pid !pid!
    goto :node2
)
:node2
for /f "tokens=1-5" %%a in ('netstat -ano ^| findstr "10002"') do (
    if "%%e%" == "" (
        set pid=%%d
    ) else (
        set pid=%%e
    )
    echo !pid!
    taskkill /f /pid !pid!
    goto :node3
)
:node3
for /f "tokens=1-5" %%a in ('netstat -ano ^| findstr "10003"') do (
    if "%%e%" == "" (
        set pid=%%d
    ) else (
        set pid=%%e
    )
    echo !pid!
    taskkill /f /pid !pid!
    goto :end
)
pause