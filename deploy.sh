#/bin/bash
if [ -d Springboot-Utils ]; then
    cd Springboot-Utils
    git pull
    if [ $? != 0 ]; then
        rm -rf Springboot-Utils
        git clone https://github.com/open-more/Springboot-Utils.git
    fi
else
    git clone https://github.com/open-more/Springboot-Utils.git
fi
mvn clean install
gradle build -x test
docker-compose down
docker-compose build
docker-compose up &
