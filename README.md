# Clojure-javainterop

The aim of this project is to demonstrate a way to write lightweight
EJB's using clojure and deploying without using AST.

# Installation

Download OpenEJB from and unpack it to home directory:

    http://www.apache.org/dyn/closer.cgi/openejb/openejb-4.0.0/openejb-standalone-4.0.0.tar.gz

Download clojure 1.3 from:

    http://repo1.maven.org/maven2/org/clojure/clojure/1.3.0/clojure-1.3.0.zip

and put it to `~/openejb/lib`.    

Go to project directory and ensure proper environment with:

    source ./envir

Build jar, start openejb and deploy application.

    ant jar
    openejb start&
    openejb deploy build/caller.jar

Use Client application to call CallerBeanRemote ejb:

    java -cp build/caller.jar:$CLASSPATH javainterop.Client "Your name"

EJB is also called every 30 seconds by OpenEJB's scheduler.

## License

Copyright (C) 2012 Aleš Kotnik, ales.kotnik@gmail.com

Distributed under the Eclipse Public License, the same as Clojure.
