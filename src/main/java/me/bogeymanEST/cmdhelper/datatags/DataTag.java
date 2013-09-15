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

import me.bogeymanEST.cmdhelper.tagdef.TagDef;

import javax.swing.tree.TreeNode;

/**
 * User: Bogeyman
 * Date: 11.09.13
 * Time: 17:31
 */
public interface DataTag {
    /**
     * Gets a node to display in a {@link javax.swing.JTree} as the root.
     *
     * @return The root node
     */
    public TreeNode getTreeNode();

    /**
     * Gets this tags's data as a string to be passed into a Minecraft command (e.g. /summon).
     *
     * @param pretty True if the data should be printed in a pretty way.
     * @return The tag's data
     */
    public String getDataString(boolean pretty);

    /**
     * Gets the tag definition
     *
     * @return The tag definition
     */
    public TagDef getTagDef();
}
