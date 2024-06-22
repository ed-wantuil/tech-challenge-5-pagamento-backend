./gradlew clean build -x test

docker build -t registry.gitlab.com/ed-wantuil/tech-challenge-clean-architecture .
docker push registry.gitlab.com/ed-wantuil/tech-challenge-clean-architecture
