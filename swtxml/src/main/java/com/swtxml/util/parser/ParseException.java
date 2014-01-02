/*******************************************************************************
 * Copyright (c) 2008 Ralf Ebert
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ralf Ebert - initial API and implementation
 *******************************************************************************/
package com.swtxml.util.parser;

@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

  public ParseException() {}

  public ParseException(final String message) {
    super(message);
  }

  public ParseException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ParseException(final Throwable cause) {
    super(cause);
  }

}