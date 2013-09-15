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

import me.bogeymanEST.cmdhelper.Resource;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * User: Bogeyman
 * Date: 14.09.13
 * Time: 12:10
 */
public class ValueEditorImpl extends JDialog {
    public volatile Field field;
    public volatile ValueEditorCallback callback;

    public ValueEditorImpl(Field field, ValueEditorCallback callback) {
        this.field = field;
        this.callback = callback;
        try {
            setIconImage(ImageIO.read(Resource.getUrl("icon.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Set value of " + field.getName());
        //setUndecorated(true);
    }

    public void onSuccess(Object value) {
        callback.onSuccess(value);
        MainForm.getInstance().reloadSpawnTree();
    }

    public void onCancel() {
        callback.onCancel();
        MainForm.getInstance().reloadSpawnTree();
    }
}
