/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2010, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.jca.adapters.jdbc.extensions.postgres;

import org.jboss.jca.adapters.jdbc.spi.ExceptionSorter;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * A PostgreSQLExceptionSorter.
 * 
 * @author <a href="wprice@redhat.com">Weston Price</a>
 * @version $Revision: 71554 $
 */
public class PostgreSQLExceptionSorter implements ExceptionSorter, Serializable
{
   /** The serialVersionUID */
   private static final long serialVersionUID = 8961250260772836448L;
   
   /**
    * Constructor
    */
   public PostgreSQLExceptionSorter()
   {
   }

   /**
    * {@inheritDoc}
    */
   public boolean isExceptionFatal(SQLException e)
   {
      final String sqlState = e.getSQLState();

      if ("08006".equals(sqlState))
      {
         return true;
      }

      return false;
   }
}
