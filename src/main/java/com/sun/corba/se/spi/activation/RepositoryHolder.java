package com.sun.corba.se.spi.activation;

/**
* com/sun/corba/se/spi/activation/RepositoryHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Friday, April 10, 2015 12:30:27 PM PDT
*/

public final class RepositoryHolder implements org.omg.CORBA.portable.Streamable
{
  public Repository value = null;

  public RepositoryHolder ()
  {
  }

  public RepositoryHolder (Repository initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RepositoryHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RepositoryHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RepositoryHelper.type ();
  }

}
