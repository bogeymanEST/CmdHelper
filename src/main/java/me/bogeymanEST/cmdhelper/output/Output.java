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

package me.bogeymanEST.cmdhelper.output;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Bogeyman
 * Date: 14.09.13
 * Time: 13:02
 */
public class Output {
    private String indent = null;
    private int stackLevel;
    private boolean pretty;

    public Output(boolean pretty) {
        this.pretty = pretty;
        this.stackLevel = 0;
    }

    /**
     * Gets the JSON-like representation of this object's fields for usage in Minecraft.
     * The only difference between JSON and the format Minecraft expects seems to be the lack of quotes around field names.
     * This is unfortunately difficult to achieve with JSON libraries (like GSON).
     * <p/>
     * If the given object is a primitive type (or the corresponding boxed type) or a string, the given value is returned instead of
     * looking through its fields.
     *
     * @param o The object
     * @return String representation of the object
     */
    public String get(Object o) {
        if (o == null)
            return "";
        StringBuilder sb = new StringBuilder();
        if (o instanceof String)
            return '"' + o.toString().replace("\"", "\\\"") + '"';
        if (o instanceof Long || o instanceof Byte || o instanceof Short || o instanceof Integer)
            return o.toString();
        if (o instanceof Boolean)
            return (Boolean) o ? "1" : "0";
        sb.append("{");
        stackLevel++;
        List<String> elements = new ArrayList<String>();
        for (Field field : o.getClass().getFields()) {
            Object val;
            StringBuilder sbElement = new StringBuilder();
            try {
                val = field.get(o);
                if (val != null) {
                    sbElement.append(newLine());
                    sbElement.append(field.getName()).append(":").append(get(val));
                    elements.add(sbElement.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append(StringUtils.join(elements, ","));
        stackLevel--;
        if (elements.size() > 0)
            sb.append(newLine());
        sb.append("}");

        return sb.toString();
    }

    private String newLine() {
        if (pretty)
            return "\n" + StringUtils.repeat("\t", stackLevel);
        return "";
    }
}
