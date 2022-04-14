# Jakarta EE & MicroProfile Project Archetype

A starter archetype for a ThinWar project using Jakarta EE and MicroProfile, without any sketchy parent-pom's.

| Dependency           | Version |
| -------------------- | ------- |
| Java EE / Jakarta EE | 8       |
| MicroProfile         | 3.2     |

The archetype is built to be highly configurable, however we are somewhat opinionated:

- Maven Build tool is used with an included maven wrapper
- wad (Watch and Deploy) by Adam Bien is included for easier development, see www.wad.sh
- ThinWar deployment strategy is enforced
- A certain selection of Java EE / Servlet Containers have native support using s2i images. (see below for more info.)

# Table of Contents

1: [Metrics using Prometheus + Grafana](#metrics)  
-> 1.1: [Gathering and visualizing](#metrics11)  
2: [CI/CD](#cicd)  
-> 2.1: [Prerequisites](#cicdpr)  
-> 2.2: [Setup](#cicdsetup)  
3: [Usage with S2I images](#s2i)  
-> 3.1: [IBM OpenLiberty](#s2iol)  
----> 3.1.1: [Development](#s2ioldev)  
----> 3.1.1.1: [Purpose of .env-file](#s2ioldevenv)  
----> 3.1.2: [S2I Deployment](#s2iols2i)  
-> 3.2: [Payara Micro](#s2ipm)  
----> 3.2.1: [Development](#s2ipmdev)  
----> 3.1.1.1: [Purpose of .env-file](#s2ipmdevenv)  
----> 3.2.2: [S2I Deployment](#s2ipms2i)  

# Metrics using Prometheus + Grafana

<a id="metrics"> </a>

An folder with name `./metrics` is provided with the following files:

| File path                 | Description                                                                                                                                                             |
| ------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ./metrics/prometheus.yml  | YAML formatted type which is injected into the prometheus runtime for configuration. This file defines various scraping targets for prometheus and scrape interval etc. |
| ./metrics/metrics-init.sh | Shell-script for initiating a prometheus and grafana docker-containers.                                                                                                 |

## Gathering and visualizing

<a id="metrics11"> </a>

1. Start the application server with your application deployment
2. Start prometheus and grafana using `cd metrics && ./metrics-init.sh`
3. Navigate to `http://localhost:9090/targets` and inspect that the `status` for your particular application server is up
   and scraping metrics.
4. Navigate to `http://localhost:3000` and configure a `browser` based prometheus datasource which points to `http://localhost:9090`. Choose `save and test`.
5. You can now create your dashboards using the Prometheus/OpenMetrics-QL.

# CI/CD

<a id="cicd"> </a>
The archetype provides with preconfigured Jenkins pipelines to allow for a quicker CI/CD setup both locally and/or on OpenShift. The following files are provided:

|       File Name       |                                                                                                                                                                  Description                                                                                                                                                                  |
| :-------------------: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|    ci/Jenkinsfile     | Base Jenkinsfile for deployment to a DEV and TEST environment. The Jenkinsfile reads thepom.xml ArtifactID as the application name and versions the image using pom.xml version.The Pipeline builds, runs Unit tests, and deploys to a DEV/TEST environment in OpenShift, whilst updating Configuration-As-Code from `k8s/dev` and `k8s/test` |
|  ci/Jenkinsfile.prod  |                                                Base Jenkinsfile for Promotion to a PROD namespace. The Jenkinsfile reads thepom.xml ArtifactID as the application name and versions the image using pom.xml version. Expects an imagestream with the application name in the TEST-environment.                                                |
|   ci/pipeline.yaml    |                                                                                                       JenkinsPipeline type build, used to create a Openshift Pipeline which is connected to Jenkins. Used for DEV/TEST `ci/Jenkinsfile`                                                                                                       |
| ci/pipeline.prod.yaml |                                                                                                  JenkinsPipeline type build, used to create a Openshift Pipeline which is connected to Jenkins. Used for PROD and runs `ci/Jenkinsfile.prod`                                                                                                  |

## Prerequisites

<a id="cicdpr"> </a>
The pipeline build configures all OpenShift resources as a part of the Jenkins Pipeline for each environment (DEV / TEST / PROD). The pipeline expects kubernetes resources in a `./k8s` folder, `./k8s/dev` for the DEV environment, `./k8s/test` for the TEST environment, and `./k8s/prod` for the PROD environment.  

  
For this to work you first need to follow step 2 described in each docker image README (e.g. [this](https://hub.docker.com/r/hassenasse/s2i-openliberty) for OpenLiberty), and then follow the below steps:  
1. `oc login` to your openshift instance
2. Export resources
    - For DEV:  
    `oc get bc/<app-name> --export -o yaml > ./k8s/dev/buildconfig.yaml`  
    `oc get dc/<app-name> --export -o yaml > ./k8s/dev/depoyconfig.yaml`
    - For TEST:  
        `oc get dc/<app-name> --export -o yaml > ./k8s/test/depoyconfig.yaml`
    - For PROD:  
        `oc get dc/<app-name> --export -o yaml > ./k8s/prod/depoyconfig.yaml`
        
This merely sets you up with the basics for deployment in Openshift, you may want to export more resources such as Kubernetes
ConfigMaps, Routes, Replication Controllers etc in the future, and wire them up in each corresponding Jenkins Pipeline.
    
## Setup
<a id="cicdsetup"> </a>
With the prerequisites finished and all folders in place. We need to change all `#` commented parts in the provided CI/CD files:  

1. `./ci/pipeline.yaml`
2. `./ci/pipeline.prod.yaml`

After the values are updated to suit your application, we can provision our pipeline:  
`oc create -f ci/pipeline.yaml`

Because OpenShift has a very tight integration with Jenkins, it should provision a Jenkins Server with the pipeline
provided.


# Usage with S2I images

<a id="s2i"> </a>

A Thin-WAR packaged application often contains only the application source code and its internal dependencies, and is often deployed on a standalone Java EE / Servlet Container. The Archetype provides configuration files for a variety of different Java EE Containers, and can be used in cloud-native container runtime environment (e.g. OpenShift / Kubernetes) by using one of the accompanied s2i-images.

| Application Server | Config Folder Name | S2I Image                                                                                                 |   Availability   |
| ------------------ | ------------------ | --------------------------------------------------------------------------------------------------------- | :--------------: |
| IBM OpenLiberty    | ./liberty/         | [hassenasse/s2i-openliberty:[19.0.0.12-jdk1.8/jdk11]](https://hub.docker.com/r/hassenasse/s2i-openliberty) |    Available     |
| Payara Micro       | ./payara/          | [hassenasse/s2i-payara-micro:[5.194-jdk1.8/jdk11]](https://hub.docker.com/r/hassenasse/s2i-payara-micro)  |    Available     |

Choose the application server needed for your particular project, and discard the rest of the config-folders. Based on the selection of application server vendor, the MicroProfile dependency version in the `pom.xml` might require tweaking. Per default the archetype ships with `MicroProfile 3.0`. Read the corresponding server documentation and s2i doc for more information about the supporting MP version.

## IBM OpenLiberty

<a id="s2iol"> </a>

> IMPORTANT: The archetype merely pulls in a workable starting point. All configuration files in the respective server-folders should be reviewed and tuned before deploy.

### Development

<a id="s2ioldev"> </a>

A `dev-run.sh` script is provided under `./liberty` folder to allow running a local development environment on a docker container. The shell script provisions an openliberty container on a running engine, and starts `wad (Watch and Deploy)` with docker volume mounts to automatically traverse changes to the container when developing. In addition, volume mounts are added to the following files in `./liberty`

- server.xml
- server.env
- jvm.properties
- bootstrap.properties

1. Start the dev-environment using `./liberty/dev-run.sh`  
   Whilst developing, `wad` will watch for file changes in `src`, run a `mvn clean install` to a artifact directory which the docker image is mounted to.
2. Inspect the image using `docker container ls`
3. Inspect logs using `docker logs development-openliberty-jdk<11/1.8> -f`
4. If required, use IDE to connect a remote-debugger to the running docker container.
- Use port `5005` and dt_socket connection

#### Purpose of .env-file
<a id="s2ioldevenv"> </a>
When working with containers, you most probably have to provide credentials to your applications for different S2S (Service-to-Service) or DB connections. Although configuration as code is beneficial, 
  
it's an anti-pattern to store DB passwords in VSC. We therefore provide with an `.env-file` text file which is injected into the docker-container (see `dev-run.sh`). The file is also `.gitignore`'ed 
so as to not allow committing it into VSC.
 
This is generally only a local-dev environment issue, as docker-swarm / kubernetes / Openshift often solve this by providing injectable secrets for docker containers.   
  

### S2I Deployment

<a id="s2iols2i"> </a>

Below is en excerpt from https://hub.docker.com/r/hassenasse/s2i-openliberty, which details each file in `./liberty` and their purpose.

| File/Folder Name     |                                                                                                                                                        Description                                                                                                                                                        |
| -------------------- | :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| server.xml           |                                                                                                      The application server configuration is described in a series of elements in the server.xml configuration file.                                                                                                      |
| server.env           |                                                                                                 The Liberty specific environment variables can be configured in the server.env file to customize the Liberty environment.                                                                                                 |
| jvm.options          |                                                                          The jvm.options files are optional but, when present, are read by the bin/server shell script to determine what options to use when launching the JVM for Open Liberty.                                                                          |
| bootstrap.properties | The bootstrap.properties file is optional but, when present, it is read during Open Liberty bootstrap to provide config for the earliest stages of the server start-up. It is read by the server much earlier than server.xml so it can affect the start-up and behavior of the Open Liberty kernel right from the start. |
| resources/           |                                                                       Shared resource definitions: adapters, data sources, are injected into `wlp/usr/shared/resources/`. Can be referenced in server.xml using `${shared.resource.dir}` property.                                                                        |

## Payara Micro

<a id="s2ipm"> </a>

> IMPORTANT: The archetype merely pulls in a workable starting point. All configuration files in the respective server-folders should be reviewed and tuned before deploy.

### Development

<a id="s2ipmdev"> </a>

Development with auto-deploy for payara-micro is currently not supported, thus, we use a payara-full image for development purposes.  
A `dev-run.sh` script is provided under `./payara` folder to allow running a local development environment on a docker container. The shell script provisions an openliberty container on a running engine, and starts `wad (Watch and Deploy)` with docker volume mounts to automatically traverse changes to the container when developing. In addition, volume mounts are added to the following files in `./payara`

- asadmin-preboot
- asadmin-postboot
- lib/

1. Start the dev-environment using `./payara/dev-run.sh`  
   Whilst developing, `wad` will watch for file changes in `src`, run a `mvn clean install` to a artifact directory which the docker image is mounted to.
2. Inspect the image using `docker container ls`
3. Inspect logs using `docker logs development-payara-full-jdk<11/1.8> -f`
4. If required, use IDE to connect a remote-debugger to the running docker container.
- Use port `5005` and dt_socket connection

#### Purpose of .env-file
<a id="s2ipmdevenv"> </a>
When working with containers, you most probably have to provide credentials to your applications for different S2S (Service-to-Service) or DB connections. Although configuration as code is beneficial, 
  
it's an anti-pattern to store DB passwords in VSC. We therefore provide with an `.env-file` text file which is injected into the docker-container (see `dev-run.sh`). The file is also `.gitignore`'ed 
so as to not allow committing it into VSC.
 
This is generally only a local-dev environment issue, as docker-swarm / kubernetes / Openshift often solve this by providing injectable secrets for docker containers.   

### S2I Deployment

<a id="s2ipms2i"> </a>

Below is en excerpt from https://hub.docker.com/r/hassenasse/s2i-payara-micro, which details each file in ./payara and their purpose.

| File/Folder Name   |                                                                                    Description                                                                                     |
| ------------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| asadmin-preboot    |                                    Provides a file of asadmin commands to run before booting the server (only some commands work at this point)                                    |
| asadmin-postboot   |                                                        Provides a file of asadmin commands to run after booting the server                                                         |
| asadmin-postdeploy |                                                  Provides a file of asadmin commands to run after all deployments have completed                                                   |
| lib/               | Allows adding various third-party libraries to the class path of a Payara Micro instance. Use cases may include required JDBC drivers, or libraries used by multiple applications. |
