package javainterop;

import javax.ejb.Schedule;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import clojure.lang.RT;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import clojure.lang.Var;
import clojure.lang.Compiler;

@Stateless
public class CallerBean implements Caller {


  private IFn requireFn = null;
  private IFn helloFn = null;

  public CallerBean() {
    super();
    requireFn = RT.var("clojure.core", "require").fn();

    // compile namespace javainteropt.callme
    requireFn.invoke(Symbol.intern("javainterop.callme"));
    helloFn = RT.var("javainterop.callme", "hello").fn();
  }

  @Schedule(dayOfWeek = "0-6", hour = "0-23", minute = "0-59", second="0,30")
  public void timer() {
    System.out.println(helloFn.invoke("Cron"));
  }

  public String hello(String name) {

    return (String) helloFn.invoke(name);
  }
}
