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

package me.bogeymanEST.cmdhelper;

import java.io.InputStream;
import java.net.URL;

/**
 * User: Bogeyman
 * Date: 9.09.13
 * Time: 18:23
 */
public class Resource {

    public static final String RES_PATH = "/me/bogeymanEST/cmdhelper/res/";

    /**
     * Gets a resource as a stream
     *
     * @param path The resource path. Relative to the resources folder (/me/bogeymanEST/cmdhelper/res/)
     * @return The stream
     */
    public static InputStream getStream(String path) {
        return Resource.class.getResourceAsStream(RES_PATH + path);
    }

    /**
     * Gets a resource URL
     *
     * @param path The resource path. Relative to the resources folder (/me/bogeymanEST/cmdhelper/res/)
     * @return The URL of the resource
     */
    public static URL getUrl(String path) {
        return Resource.class.getResource(RES_PATH + path);
    }
}
