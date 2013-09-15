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

import me.bogeymanEST.cmdhelper.tagdef.Max;
import me.bogeymanEST.cmdhelper.tagdef.Min;

import java.lang.reflect.Field;

/**
 * User: Bogeyman
 * Date: 14.09.13
 * Time: 13:46
 */
public class IntegerValueEditor extends TextValueEditor {
    Integer min = null;
    Integer max = null;

    public IntegerValueEditor(Field field, ValueEditorCallback callback) {
        this(field, callback, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    IntegerValueEditor(Field field, ValueEditorCallback callback, Object min, Object max) {
        super(field, callback);
        this.min = (Integer) min;
        this.max = (Integer) max;
        Min aMin = field.getAnnotation(Min.class);
        if (aMin != null)
            this.min = aMin.value();
        Max aMax = field.getAnnotation(Max.class);
        if (aMax != null)
            this.max = aMax.value();
    }

    @Override
    public String verifyInput(String text) {
        try {
            Integer val = Integer.parseInt(text);
            if (val < min || val > max) throw new NumberFormatException();
            return null;
        } catch (NumberFormatException ex) {
            return "Value must be an integer from " + min + " to " + max;
        }
    }

    @Override
    protected Object parseValue(String text) {
        return Integer.parseInt(text);
    }

}
