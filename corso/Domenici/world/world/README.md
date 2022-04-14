# Build
mvn clean package && docker build -t it.tss/world .

# RUN

docker rm -f world || true && docker run -d -p 8080:8080 -p 4848:4848 --name world it.tss/world 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test