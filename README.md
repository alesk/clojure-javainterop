# javainterop

This project serves as an example to call clojure functions from java.
The motivation is to produce a tiny java wrapper which helps when including
clojure code in application server or similar environments.

If we use `clojure.lang.*` mechanism to create oneway interop with java,
there is no need to employ AOT thus avoid coupling all libraries in to one huge jar.

Leightweight deployment is possible.


## Usage

Download and compile dependencies with:

    lein deps

Create jar file with clojure namspace:

    lein jar

Compile java wrapper with:

    ant jar

Run `javainterop.Caller` from command line, which subsequently loads and calls 
clojure function:

    java -cp javainterop-1.0.0-SNAPSHOT.jar:lib/clojure-1.3.0.jar:build/caller.jar Caller

## License

Copyright (C) 2012 Aleš Kotnik, ales.kotnik@gmail.com

Distributed under the Eclipse Public License, the same as Clojure.
