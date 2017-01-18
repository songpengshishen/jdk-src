package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/ServerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /HUDSON3/workspace/8-2-build-linux-amd64/jdk8u112/7884/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Thursday, September 22, 2016 9:11:51 PM PDT
*/


/** Server callback API, passed to Activator in active method.
    */
public interface ServerOperations 
{

  /** Shutdown this server.  Returns after orb.shutdown() completes.
  	*/
  void shutdown();

  /** Install the server.  Returns after the install hook completes
  	* execution in the server.
  	*/
  void install();

  /** Uninstall the server.  Returns after the uninstall hook
  	* completes execution.
  	*/
  void uninstall();
} // interface ServerOperations
