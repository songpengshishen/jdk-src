package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/POANameHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /HUDSON3/workspace/8-2-build-linux-amd64/jdk8u112/7884/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Thursday, September 22, 2016 9:11:51 PM PDT
*/

public final class POANameHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public POANameHolder ()
  {
  }

  public POANameHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = POANameHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    POANameHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return POANameHelper.type ();
  }

}
