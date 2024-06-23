#!/bin/bash

# stop.sh

# 애플리케이션이 위치한 디렉토리 경로
PROJECT_ROOT="/home/ec2-user/build/libs"

# 애플리케이션 JAR 파일 경로
JAR_FILE="$PROJECT_ROOT/outpick_backend-0.0.1-SNAPSHOT.jar"

# 배포 로그 파일 경로
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

# 현재 시간
TIME_NOW=$(date +%c)

# 현재 구동 중인 애플리케이션의 PID 확인
CURRENT_PID=$(pgrep -f $JAR_FILE)

# 프로세스가 실행 중인지 확인 후 종료
if [ -z $CURRENT_PID ]; then
  echo "$TIME_NOW > 현재 실행중인 애플리케이션이 없습니다"
else
  echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 "
  kill -15 $CURRENT_PID
fi

