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
import me.bogeymanEST.cmdhelper.datatags.DataTag;
import me.bogeymanEST.cmdhelper.datatags.DataTagImpl;
import me.bogeymanEST.cmdhelper.datatags.DataTagManager;
import me.bogeymanEST.cmdhelper.tagdef.*;
import org.clapper.util.classutil.ClassFilter;
import org.clapper.util.classutil.ClassFinder;
import org.clapper.util.classutil.ClassInfo;
import org.clapper.util.classutil.SubclassClassFilter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Bogeyman
 * Date: 11.09.13
 * Time: 17:06
 */
@SuppressWarnings("UnusedDeclaration")
public class MainForm {
    private static MainForm instance;
    private JPanel mainPanel;
    private JComboBox<String> comboBase;
    public JTree spawnTree;
    private JTextArea txtOutput;
    private JCheckBox prettyCheckBox;
    private JSplitPane splitPane;
    private DataTag selectedDataTag;

    public MainForm() {
        instance = this;
        comboBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("comboBoxChanged")) {
                    reloadSpawnTree();
                }
            }
        });

        prettyCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadOutput();
            }
        });
        spawnTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!SwingUtilities.isRightMouseButton(e)) return;
                TreePath path = spawnTree.getPathForLocation(e.getX(), e.getY());
                if (path == null) return;
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                Object uObj = node.getUserObject();
                if (uObj instanceof DataTag) {
                    DataTag tag = (DataTag) uObj;
                    JPopupMenu menu = TagUtils.getPopupMenu(tag.getTagDef(), node);
                    menu.show(spawnTree, e.getX(), e.getY());
                }
            }
        });
    }

    /**
     * Makes a split pane invisible. Only contained components are shown.
     *
     * @param splitPane The pane
     */
    public static void flattenJSplitPane(JSplitPane splitPane) {
        splitPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BasicSplitPaneUI flatDividerSplitPaneUI = new BasicSplitPaneUI() {
            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    @Override
                    public void setBorder(Border b) {
                    }
                };
            }
        };
        splitPane.setUI(flatDividerSplitPaneUI);
        splitPane.setBorder(null);
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
        JFrame frame = new JFrame("CmdHelper");
        try {
            frame.setIconImage(ImageIO.read(Resource.getUrl("icon.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final MainForm form = new MainForm();
        frame.setContentPane(form.mainPanel);
        flattenJSplitPane(form.splitPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static MainForm getInstance() {
        return instance;
    }

    public void reloadOutput() {
        if (selectedDataTag != null) {
            txtOutput.setText(selectedDataTag.getDataString(prettyCheckBox.isSelected()));
        }
    }

    public void reloadSpawnTree() {
        DataTag selTag = DataTagManager.getTag(comboBase.getSelectedItem().toString());
        if (selTag != null) {
            selectedDataTag = selTag;
            spawnTree.setModel(new DefaultTreeModel(selectedDataTag.getTreeNode()));
            reloadOutput();
        }
    }

    private void createUIComponents() {
        txtOutput = new JTextArea();
        prettyCheckBox = new JCheckBox();
        selectedDataTag = null;
        spawnTree = new JTree(new DefaultMutableTreeNode());
        List<String> tags = new ArrayList<String>();
        for (DataTag tag : DataTagManager.getTags()) {
            tags.add(tag.toString());
        }
        comboBase = new JComboBox<String>(tags.toArray(new String[tags.size()]));
        reloadSpawnTree();
    }

    private static void initialize() {
        Class[] tags = new Class[]{
                EntityDef.class,
                ItemDef.class,
                TileEntityDef.class
        };
        ClassFinder finder = new ClassFinder();
        File f = null;
        try {
            f = new File(TagDef.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (f == null) {
            System.err.println("Failed to get class path");
            return;
        }
        finder.add(f);
        for (Class tag : tags) {
            ClassFilter filter = new SubclassClassFilter(tag);
            Collection<ClassInfo> types = new ArrayList<ClassInfo>();
            finder.findClasses(types, filter);
            for (ClassInfo type : types) {
                Class cls = null;
                try {
                    cls = (Class) Class.forName(type.getClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (cls == null) {
                    System.err.println("Failed to get class for " + type.getClassName());
                    continue;
                }
                if (Modifier.isAbstract(cls.getModifiers())) continue;
                try {
                    DataTagManager.addTag(new DataTagImpl((TagDef) cls.newInstance()));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        initialize();
    }
}
