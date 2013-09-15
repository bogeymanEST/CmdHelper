/*
 * CmdHelper
 * Copyright (C) 2013 bogeymanEST
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package me.bogeymanEST.cmdhelper.forms;

import java.lang.reflect.Field;

/**
 * User: Bogeyman
 * Date: 14.09.13
 * Time: 12:17
 */
public class EditorUtils {
    /**
     * Gets a value editor for the given field
     *
     * @param field    The field
     * @param callback The callback
     * @return The editor or {@code null} if no editor exists for the given class.
     */
    public static ValueEditorImpl getValueEditor(Field field, ValueEditorCallback callback) {
        Class cls = field.getType();
        if (cls.equals(String.class)) {
            return new StringValueEditor(field, callback);
        }
        if (cls.equals(Integer.class)) {
            return new IntegerValueEditor(field, callback);
        }
        if (cls.equals(Short.class)) {
            return new ShortValueEditor(field, callback);
        }
        if (cls.equals(Byte.class)) {
            return new ByteValueEditor(field, callback);
        }
        if (cls.equals(Boolean.class)) {
            return new BooleanValueEditor(field, callback);
        }

        return null;
    }
}
