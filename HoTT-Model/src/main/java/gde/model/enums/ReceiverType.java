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
package gde.model.enums;

import java.util.ResourceBundle;

/**
 * @author oli
 * 
 */
public enum ReceiverType {
  E06(1), E08(0), E12(5), E16(7);

  public static ReceiverType forId(final int id) {
    for (final ReceiverType receiverType : ReceiverType.values()) {
      if (receiverType.id == id) {
        return receiverType;
      }
    }

    return null;
  }

  private final int id;

  private ReceiverType(final int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  /** @return the locale-dependent message */
  @Override
  public String toString() {
    return ResourceBundle.getBundle(getClass().getName()).getString(name());
  }
}
