#!/bin/bash 
 
# 项目路径
jar_path=/root/moehu-backend
#编译好的jar名称
jar_name=/target/back-0.0.1-SNAPSHOT.jar
 
# 进入指定项目路径
cd ${jar_path}

# 获取运行编译好的进程ID，便于我们在重新部署项目的时候先杀掉以前的进程
pid=$(cat /root/moehu-backend/moehu.pid)

# 拉取代码，编译打包
git pull && /root/maven/bin/mvn clean package -Dmaven.test.skip=true && kill -9 ${pid}

# nohup java -jar ${jar_path}${jar_name} --spring.profiles.active=prod &
cd target/ && nohup java -jar back-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod &

echo $! > /root/moehu-backend/moehu.pid