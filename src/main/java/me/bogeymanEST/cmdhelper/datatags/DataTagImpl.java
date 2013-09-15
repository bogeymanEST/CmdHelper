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

package me.bogeymanEST.cmdhelper.datatags;

import me.bogeymanEST.cmdhelper.TagDefField;
import me.bogeymanEST.cmdhelper.output.Output;
import me.bogeymanEST.cmdhelper.tagdef.TagDef;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.lang.reflect.Field;

/**
 * User: Bogeyman
 * Date: 11.09.13
 * Time: 18:10
 */
public class DataTagImpl implements DataTag, Comparable {
    private TagDef def;

    public DataTagImpl(TagDef def) {
        this.def = def;
    }

    @Override
    public TreeNode getTreeNode() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(this);
        for (Field f : getTagDef().getClass().getFields()) {
            try {
                Object v = f.get(getTagDef());
                if (v == null) continue;
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(new TagDefField(getTagDef(), f));
                rootNode.add(node);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return rootNode;
    }

    @Override
    public String toString() {
        return getTagDef().getName();
    }

    @Override
    public String getDataString(boolean pretty) {
        Output o = new Output(pretty);
        return o.get(getTagDef());
    }

    @Override
    public TagDef getTagDef() {
        return def;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof DataTagImpl)) return 1;
        DataTagImpl tag = (DataTagImpl) o;
        return getTagDef().getName().compareTo(tag.getTagDef().getName());
    }
}
