#!/bin/bash

# start.sh

# 애플리케이션이 위치한 디렉토리 경로
PROJECT_ROOT="/home/ec2-user/build/libs"

# 애플리케이션 JAR 파일 경로
JAR_FILE="$PROJECT_ROOT/outpick_backend-0.0.1-SNAPSHOT.jar"

# 현재 시간
TIME_NOW=$(date +%c)

# 빌드 파일을 지정된 경로로 복사
echo "$TIME_NOW > $JAR_FILE 파일 복사"
cp $PROJECT_ROOT/outpick_backend-0.0.1-SNAPSHOT.jar $JAR_FILE

# JAR 파일 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" 
source ~/.bashrc

PID=$(lsof -t -i:8080)

# 기존 서버 종료
if [ -n "$PID" ]; then
    echo "Stopping server on port $PORT with PID $PID"
    kill $PID
    # 종료 확인을 위해 몇 초 대기
    sleep 2
fi

chmod +x /home/ec2-user/build/libs/outpick_backend-0.0.1-SNAPSHOT.jar
nohup java -jar $JAR_FILE > /dev/null 2>&1 &

# 실행된 애플리케이션의 PID 확인
CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다."

exec 1>&-
exec 2>&-

exit 0