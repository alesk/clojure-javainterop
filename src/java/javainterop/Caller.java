package javainterop;

import javax.ejb.Remote;

@Remote
public interface Caller {
  public void timer();
  public String hello(String name);

}
