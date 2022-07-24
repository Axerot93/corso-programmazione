# Build
mvn clean package && docker build -t com.tss/esamebrignani .

# RUN

docker rm -f esamebrignani || true && docker run -d -p 8080:8080 -p 4848:4848 --name esamebrignani com.tss/esamebrignani 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test