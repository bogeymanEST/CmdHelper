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
import me.bogeymanEST.cmdhelper.spawnable.Entity;
import me.bogeymanEST.cmdhelper.spawnable.Item;
import me.bogeymanEST.cmdhelper.spawnable.Spawnable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * User: Bogeyman
 * Date: 11.09.13
 * Time: 17:06
 */
@SuppressWarnings("UnusedDeclaration")
public class MainForm {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JTextField targetTextField;
    private JTree spawnTree;
    private JTextArea textArea1;
    private Spawnable selectedSpawnable;


    public MainForm() {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("comboBoxChanged")) {
                    reloadSpawnTree();
                }
            }
        });
    }

    private void reloadSpawnTree() {
        if (comboBox1.getSelectedItem().equals("/summon")) {
            selectedSpawnable = new Entity();
            spawnTree.setModel(new DefaultTreeModel(selectedSpawnable.getRootNode()));
        } else if (comboBox1.getSelectedItem().equals("/give")) {
            selectedSpawnable = new Item();
            spawnTree.setModel(new DefaultTreeModel(selectedSpawnable.getRootNode()));
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("MainForm");
        try {
            frame.setIconImage(ImageIO.read(Resource.getUrl("icon.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        selectedSpawnable = new Entity();
        spawnTree = new JTree(selectedSpawnable.getRootNode());
    }
}
