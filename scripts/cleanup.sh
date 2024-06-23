#!/bin/bash

# 기존 스크립트 파일을 삭제합니다.
if [ -d /home/ec2-user/build/scripts ]; then
    echo "Removing old scripts directory..."
    rm -rf /home/ec2-user/build/scripts
    echo "Old scripts directory removed."
else
    echo "No old scripts directory found."
fi
