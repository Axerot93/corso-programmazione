#!/usr/bin/env bash

promConfig="$(pwd)/prometheus.yml"
promContainerName="prometheus-server"
grafanaContainerName="grafana-server"
echo "Initializing Prometheus"
if test -f "$promConfig"; then
    echo "Found prometheus.yml file in working dir"

    # PROMETHEUS
    if [[ "$(docker container ls -a | grep $promContainerName 2> /dev/null)" == "" ]]; then
      echo "Attempting to start prometheus using docker on port 9090"
      docker container run -d \
          -p 9090:9090 \
          -v $promConfig:/etc/prometheus/prometheus.yml --name $promContainerName \
          prom/prometheus
    else
      docker container start $promContainerName
    fi

    # GRAFANA
    if [[ "$(docker container ls -a | grep $grafanaContainerName 2> /dev/null)" == "" ]]; then
      echo "Attempting to start prometheus using docker on port 9090"
      docker container run -d \
          -p 3000:3000 \
          --name $grafanaContainerName \
          grafana/grafana
    else
      docker container start $grafanaContainerName
    fi

    echo "Edit prometheus.yml for config-changes!"
    echo "Prometheus and Grafana server started, hit CTRL+C to exit"
    trap ctrl_c INT

    function ctrl_c() {
      echo "Stopping Prometheus"
      docker stop $promContainerName
      docker stop $grafanaContainerName
      exit 0
    }

    # Wait forever
    read -r -d '' _ </dev/tty
else
    echo "No prometheus.yml file found in working dir! Aborting..."
fi
