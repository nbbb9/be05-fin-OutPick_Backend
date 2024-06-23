#!/bin/bash

# start.sh

# 애플리케이션이 위치한 디렉토리 경로
PROJECT_ROOT="/home/ec2-user/build/libs"

# 애플리케이션 JAR 파일 경로
JAR_FILE="$PROJECT_ROOT/outpick_backend-0.0.1-SNAPSHOT.jar"

# 애플리케이션 로그 파일 경로
APP_LOG="$PROJECT_ROOT/application.log"

# 에러 로그 파일 경로
ERROR_LOG="$PROJECT_ROOT/error.log"

# 배포 로그 파일 경로
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

# 현재 시간
TIME_NOW=$(date +%c)

# 빌드 파일을 지정된 경로로 복사
echo "$TIME_NOW > $JAR_FILE 파일 복사" >> $DEPLOY_LOG
cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE

# JAR 파일 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
source ~/.bashrc
nohup java -jar $JAR_FILE > $APP_LOG 2> $ERROR_LOG &

# 실행된 애플리케이션의 PID 확인
CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG

