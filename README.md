# Clojure--javainterop

The aim of this project is to demonstrate a way to write lightweight
EJBs using clojure and deploying without using [Ahead-of-Time (AOT) compilation][1].

# Installation

Download OpenEJB from and unpack it to home directory:

    curl http://www.apache.si/dyn/closer.cgi/openejb/openejb-4.0.0/openejb-standalone-4.0.0.tar.gz | tar xz -C ~
    mv -T ~/apache-openejb-4.0.0 ~/openejb

Download clojure 1.3 and put in to `~/openejb/lib`:

    curl http://repo1.maven.org/maven2/org/clojure/clojure/1.3.0/clojure-1.3.0.zip -o /tmp/clojure.zip
    unzip -j /tmp/clojure.zip clojure-1.3.0/clojure-1.3.0.jar -d ~/openejb/lib && rm /tmp/clojure.zip

Clone `clojure-javainterop` (if not already done) and go to project directory and ensure proper environment with:

    git clone git@github.com:alesk/clojure-javainterop.git   
    source ./envir

Build jar, start openejb and deploy application.

    ant jar
    openejb start&
    openejb deploy build/caller.jar

Use Client application to call CallerBeanRemote ejb:

    java -cp build/caller.jar:$CLASSPATH javainterop.Client "Your name"

EJB is also called every 30 seconds by OpenEJB's scheduler.

## References

  [1]: http://clojure.org/compilation

## License

Copyright (C) 2012 Aleš Kotnik, ales.kotnik@gmail.com

Distributed under the Eclipse Public License, the same as Clojure.
