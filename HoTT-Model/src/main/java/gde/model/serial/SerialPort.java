/**
 *  HoTT Transmitter Config
 *  Copyright (C) 2013  Oliver Treichel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gde.model.serial;

import gde.model.HoTTException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author oli@treichels.de
 * 
 */
public interface SerialPort {
  public void open() throws HoTTException;

  public boolean isOpen();

  public void close() throws IOException;

  public OutputStream getOutputStream() throws HoTTException;

  public InputStream getInputStream() throws HoTTException;
}
