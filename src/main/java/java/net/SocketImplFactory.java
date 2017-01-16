/*
 * Copyright (c) 1995, 1999, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.net;

/**
 * This interface defines a factory for socket implementations. It
 * is used by the classes <code>Socket</code> and
 * <code>ServerSocket</code> to create actual socket
 * implementations.
 *
 * @author  Arthur van Hoff
 * @see     Socket
 * @see     ServerSocket
 * @since   JDK1.0
 */
public
interface SocketImplFactory {
    /**
     * Creates a new <code>SocketImpl</code> instance.
     *
     * @return  a new instance of <code>SocketImpl</code>.
     * @see     SocketImpl
     */
    SocketImpl createSocketImpl();
}
