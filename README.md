# Hospis

Asynchronous messaging integration layer for systems and applications used in hospice [Cesta domů](http://cestadomu.cz).

# Links

* [Blog](http://hospisdev.tumblr.com/)
* [Documentation](http://www.googledrive.com/host/0B1pxZj5GslL_fjlKZS1icHk4YzQxMXFIRExpazAxNlFvWmFNRklIT01nV0U3RXNMSzlXOXc/index.html)
* [OpenHub (project metainfo)](https://www.openhub.net/p/hospis)

# Prerequisites

* Java 8
* Maven 3

# Build and run with mock backend

    mvn -P mock clean install
    mvn -P mock -f bundle/pom.xml spring-boot:run

# Build documentation from source

    mvn clean site site:stage -DstagingDirectory=<output directory>

# Modules (and architecture overview)

Top level modules are completely independent in the sense that they:

* don't have common parent (the root POM is just a convenience construct that allows building the project at once)
* have separated versioning and release cycle
* have separated dependency setup
* can be deployed separately

However there may be dependency from one top level module to another and since there is no common parent reactor module, the complete build requires deployment to an artifact repository, either local (via mvn install) or shared (via mvn deploy).

Some of the following modules has two standard submodules:
* lib: This module contains the module logic in the environment-agnostic form. It is not deployable on it's own but can be bundled later in several deployment scenarios - microservice, monolith, web application, standalone jar etc. See Bundle module for example.
* web: This module provides the basic web application wrapper around coresponding lib module allowing it to be deployed as standard war.

## Core module
This module contains the core of this project which is the integration of several external systems/applications with asynchronous messaging. It is implemented as Apache Camel routes.

## MQ module
This module is just an embeded MQ broker (ActiveMQ) used by the core module to pass messages between the external systems. 

## REST module
This module provides the REST interface to core module services that can be used in browser based client. It handles all the nasty realities of external interface like security, backward compatability, client state, request/response model etc. so that core module may be completely stateless and horizontaly scalable. It is based on family of Spring libraries.

## Client module
This module contains the browser based client of the REST module.

## Bundle module
This module bundles implementations of all the previous modules and their runtime contexts into a single deployable application. This packaging is convenient for development and also in production if it doesn't have to be highly available.

## Utils module
This module is not part of the final deployment, it contains just development-time helper utilities.
