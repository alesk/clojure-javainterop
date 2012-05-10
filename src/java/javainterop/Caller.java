import clojure.lang.RT;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import clojure.lang.Var;
import clojure.lang.Compiler;

public class Caller {

  private static IFn requireFn = RT.var("clojure.core", "require").fn();
  static {
    requireFn.invoke(Symbol.intern("javainterop.callme"));
  }

  private static IFn hello = RT.var("javainterop.callme", "hello").fn();

  public static void main(String args[]) throws Exception {

    hello.invoke("Aleš");
  }
}
