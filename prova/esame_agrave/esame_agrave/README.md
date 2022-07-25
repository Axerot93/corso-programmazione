# Build
mvn clean package && docker build -t tss/esamedelima .

# RUN

docker rm -f esamedelima || true && docker run -d -p 8080:8080 -p 4848:4848 --name esamedelima tss/esamedelima 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test