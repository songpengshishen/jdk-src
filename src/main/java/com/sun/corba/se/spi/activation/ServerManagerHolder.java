package com.sun.corba.se.spi.activation;

/**
* com/sun/corba/se/spi/activation/ServerManagerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Friday, April 10, 2015 12:30:27 PM PDT
*/

public final class ServerManagerHolder implements org.omg.CORBA.portable.Streamable
{
  public ServerManager value = null;

  public ServerManagerHolder ()
  {
  }

  public ServerManagerHolder (ServerManager initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServerManagerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServerManagerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServerManagerHelper.type ();
  }

}
