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

package me.bogeymanEST.cmdhelper.tagdef;

import me.bogeymanEST.cmdhelper.forms.EditorUtils;
import me.bogeymanEST.cmdhelper.forms.ValueEditorCallback;
import me.bogeymanEST.cmdhelper.forms.ValueEditorImpl;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * User: Bogeyman
 * Date: 13.09.13
 * Time: 11:58
 */
public class TagUtils {
    public static JPopupMenu getPopupMenu(final TagDef tag, final DefaultMutableTreeNode node) {
        final JPopupMenu menu = new JPopupMenu("Add property");
        final Class cls = tag.getClass();
        for (Field f : cls.getFields()) {
            String name = f.getName();
            try {
                Object v = f.get(tag);
                if (v == null) {
                    final JMenuItem item = new JMenuItem(name);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                final Field f = cls.getField(((JMenuItem) e.getSource()).getText());
                                ValueEditorImpl editor = EditorUtils.getValueEditor(f, new ValueEditorCallback() {
                                    @Override
                                    public void onSuccess(Object value) {
                                        try {
                                            f.set(tag, value);
                                        } catch (IllegalAccessException e1) {
                                            e1.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onCancel() {
                                        menu.remove(item);
                                    }
                                });

                            } catch (NoSuchFieldException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    menu.add(item);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return menu;
    }
}
