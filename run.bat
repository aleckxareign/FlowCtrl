@echo off
javac -d out -sourcepath src src\main\FlowCtrl.java
if %errorlevel% neq 0 (
    echo Compile error!
    pause
    exit /b
)
java -cp out main.FlowCtrl
