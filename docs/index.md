Java SPI Tests
==============

# Intro

This project should show how Java SPI is used to create applications that can be configured by combining different jar
files. It was inspired by https://www.baeldung.com/java-spi.

# SPI

Here some words taken from https://en.wikipedia.org/wiki/Service_provider_interface about SPI:

> Service provider interface (SPI) is an API intended to be implemented or extended by a third party. It can be used to enable framework extension and replaceable components.
>
> A service is a well-known set of interfaces and (usually abstract) classes. A service provider is a specific implementation of a service. The classes in a provider typically implement the interfaces and subclass the classes defined in the service itself. Service providers can be installed in an implementation of the Java platform in the form of extensions, that is, jar files placed into any of the usual extension directories. Providers can also be made available by adding them to the application's class path or by some other platform-specific means.

# Modules

The project consists of 3 main parts:

- [Core](#Core)
- [Features](#Features)
- [Samples](#Samples)

## Core

This is the main application and defines a main method which then can be used to run the application. It brings together
the feature implementations. In this sample it is assumed that we should only have one instance of ExchangeRateProvider
but in theory this can be used to load multiple instances as well.

The core is not a java application but just a java-library because it isn't run standalone. It should be used in
combination with features and therefor the samples are defined as applications.

## Features

Features are also simple java-library projects that define their dependencies that are need if the feature is added.

### feature-api

This is the API for feature implementations. It provides a Provider interface ExchangeRateProvider in which an instance
of QuoteManager can be retrieved. The ExchangeRate class is a simple helper to retrieve all registered
ExchangeRateProvider instance. The logic inside that class could also be implemented in the core.

### feature-implementations

These modules feature1 and feature2 provide implementations for the ExchangeRateProvider interface in which they create
instances of subtypes of QuoteManager. To make them available to SPI a classpath file needs to be placed under
/META-INF/services with the full qualified name of the ExchangeRateProvider as filename and the full qualified name of
the implementation of the ExchangeRateProvider inside the file. If this file is missing or named incorrectly the service
can't be found by the ServiceLoader. If the content of the file is wrong a ServiceConfigurationError is thrown and the
application won't start. Intellij even marks the content of the file as an error if the class can't be found.

## Samples

The sample are simple applications without code. They only combine other java-library projects and use the core to have
a main class.

### sample1

Uses feature1.

### sample2

Uses feature2.

### sample3

Has feature1 and feature2 on the classpath which isn't allowed by the core. So this is intended to fail on startup.

### sample4

Has no features on the classpath which isn't allowed by the core. So this is intended to fail on startup.