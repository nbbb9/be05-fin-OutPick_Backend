#!/bin/bash

# build/libs 디렉토리와 그 안의 파일들의 소유자를 ec2-user로 변경하고, 권한을 설정합니다.
echo "Setting permissions for build/libs and its contents..."
chmod -R 755 /home/ec2-user/build/libs
echo "Permissions set."
