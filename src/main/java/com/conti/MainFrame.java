package com.conti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainFrame {

    private ResourceBundle rb;
    private Locale selectedLocale;
    private JRadioButtonMenuItem englishLangButton;
    private JRadioButtonMenuItem deutschLangButton;
    private JLabel label;

    public MainFrame() {
        // init components
        Locale locale = Locale.US;
        ResourceBundle rb = ResourceBundle.getBundle("main", locale);
        // init frame
        JFrame frame = new JFrame("I18N Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JMenuBar menuBar = createMenuBar();
        JButton button = createChangeLanguageButton();
        label = new JLabel(rb.getString("hello_world"));
        label.setFont(new Font("Serif", Font.PLAIN, 18));

        panel.add(label);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        // init
        JMenuBar menuBar = new JMenuBar();
        ButtonGroup buttonGroup = new ButtonGroup();
        JMenu menu = new JMenu("Settings");
        JMenu subMenu = new JMenu("Language");

        englishLangButton = new JRadioButtonMenuItem("English");
        deutschLangButton = new JRadioButtonMenuItem("Deutsch");
        englishLangButton.setSelected(true);

        // binding
        menuBar.add(menu);
        menu.add(subMenu);
        buttonGroup.add(englishLangButton);
        buttonGroup.add(deutschLangButton);
        subMenu.add(englishLangButton);
        subMenu.add(deutschLangButton);
        return menuBar;
    }

    private JButton createChangeLanguageButton() {
        JButton button = new JButton("change lang");
        button.addActionListener((e) -> {
            if (englishLangButton.isSelected()) {
                selectedLocale = Locale.US;
                ResourceBundle rb = ResourceBundle.getBundle("main", selectedLocale);
                label.setText(rb.getString("hello_world"));
            } else if (deutschLangButton.isSelected()) {
                selectedLocale = Locale.GERMANY;
                ResourceBundle rb = ResourceBundle.getBundle("main", selectedLocale);
                label.setText(rb.getString("hello_world"));
            } else {
                // do nothing
            }
        });
        return button;
    }
}
