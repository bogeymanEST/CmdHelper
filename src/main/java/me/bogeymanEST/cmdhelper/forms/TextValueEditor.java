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
import me.bogeymanEST.cmdhelper.tagdef.Info;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.positioners.LeftBelowPositioner;
import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.ToolTipBalloonStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

public abstract class TextValueEditor extends ValueEditorImpl {
    private JPanel contentPane;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField txtField;
    private JTextArea descArea;
    private BalloonTip bt;

    public TextValueEditor(Field field, ValueEditorCallback callback) {
        super(field, callback);
        final BalloonTipStyle style = new ToolTipBalloonStyle(new Color(220, 0, 0, 141), new Color(0, 0, 0, 86));
        setMinimumSize(new Dimension(500, 200));
        descArea.setFont(UIManager.getFont("TextField.font"));
        descArea.setWrapStyleWord(true);

        txtField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = txtField.getText();
                String error = verifyInput(text);
                if (text.length() == 0) error = null;
                if (bt != null) bt.closeBalloon();
                if (error != null) {
                    bt = new BalloonTip(txtField, error, style, false);
                    bt.setPositioner(new LeftBelowPositioner(2, 2));
                }

            }
        });
        setContentPane(contentPane);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verifyInput(txtField.getText()) != null) return;
                try {
                    onSuccess(parseValue(txtField.getText()));
                    TextValueEditor.this.dispose();
                } catch (NumberFormatException ignored) {

                }

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onCancel();
                    TextValueEditor.this.dispose();
                } catch (NumberFormatException ignored) {

                }
            }
        });
        contentPane.setBorder(BorderFactory.createTitledBorder(field.getName()));
        Info info = field.getAnnotation(Info.class);
        if (info != null) {
            descArea.setText(info.value());
        }
        contentPane.setMaximumSize(new Dimension(-1, 150));
        pack();
        setLocationRelativeTo(MainForm.getInstance().spawnTree);
        txtField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSuccess(parseValue(txtField.getText()));
                TextValueEditor.this.dispose();
            }
        });
        setVisible(true);
        setModal(true);

    }

    protected abstract Object parseValue(String text);

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
    }

    /**
     * Verifies the given input.
     *
     * @param text The text that was entered
     * @return {@code null} if the input is correct. Any other string if there is an error. The given string will be shown as the error message.
     */
    public abstract String verifyInput(String text);

    private void createUIComponents() {
        saveButton = new JButton(new ImageIcon(Resource.getUrl("add.png")));
        cancelButton = new JButton(new ImageIcon(Resource.getUrl("cancel.png")));
    }
}
