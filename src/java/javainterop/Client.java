package javainterop;

import clojure.lang.RT;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import clojure.lang.Var;
import clojure.lang.Compiler;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

public class Client {

  private static IFn requireFn = RT.var("clojure.core", "require").fn();
  static {
    requireFn.invoke(Symbol.intern("javainterop.callme"));
  }

  private static IFn hello = RT.var("javainterop.callme", "hello").fn();

  public static void main(String args[]) throws Exception {

    String name = (args.length > 0) ? args[0] : "Anonymouse";

    // invokes local clojure 
    // System.out.println(hello.invoke(name));

    // invokes EJB
    Properties props = new Properties();
    props.put(Context.INITIAL_CONTEXT_FACTORY,
        "org.apache.openejb.client.RemoteInitialContextFactory");

    props.put(Context.PROVIDER_URL, 
        "ejbd://127.0.0.1:4201");

    Context ctx = new InitialContext(props);
    Object ref = ctx.lookup("CallerBeanRemote");
    Caller h = (Caller) PortableRemoteObject.narrow(ref, Caller.class);
    String result = h.hello(name);
    System.out.println(result);
  }
}
