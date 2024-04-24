import cn.localhost01.seal.SealUtil;
import cn.localhost01.seal.configuration.SealCircle;
import cn.localhost01.seal.configuration.SealConfiguration;
import cn.localhost01.seal.configuration.SealFont;
import cn.localhost01.seal.configuration.Private;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.Base64;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Main extends JFrame {
    private JTextField sealSizeTextField;
    private JTextField sealSquareLineSizeTextField;
    private JTextField sealCircleBorderHeightTextField, sealCircleBorderWidthTextField, sealCircleBorderLineSizeTextField;
    private JTextField sealCircleBorderInnerHeightTextField, sealCircleBorderInnerWidthTextField, sealCircleBorderInnerLineSizeTextField;
    private JTextField sealCircleInnerHeightTextField, sealCircleInnerWidthTextField, sealCircleInnerLineSizeTextField;
    private JTextField mainTextField, mainMarginTextField, mainSizeTextField, mainSpaceTextField;
    private JTextField viceTextField, viceMarginTextField, viceSizeTextField, viceSpaceTextField;
    private JTextField centerTextField, centerMarginTextField, centerSizeTextField, centerSpaceTextField;
    private JTextField titleTextField, titleMarginTextField, titleSizeTextField, titleSpaceTextField;
    private JTextField filePathTextField, fileNameTextField;
    private JButton colorButton;
    private JComboBox<String> sealTypeComboBox;
    private JComboBox<String> mainFontComboBox, viceFontComboBox, centerFontComboBox, titleFontComboBox;
    private JCheckBox mainBoldCheckBox, viceBoldCheckBox, centerBoldCheckBox, titleBoldCheckBox;
    private JButton generateButton;
    private String[] fontNames = SealFont.getSupportFontNames();

    public Main() {
        setTitle("淫蕩產印機");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(48, 2));

        mainPanel.add(new JLabel("Seal Type:"));
        sealTypeComboBox = new JComboBox<>(new String[]{"Circle", "Square"});
        mainPanel.add(sealTypeComboBox);
        sealTypeComboBox.setSelectedIndex(0); //default seal type, circle - 0, square - 1

        mainPanel.add(new JLabel("Seal Background Color:"));
        colorButton = new JButton("Choose Color");
        mainPanel.add(colorButton);
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose Color", Color.RED);
                if (color != null) {
                    colorButton.setBackground(color);
                }
            }
        });

        mainPanel.add(new JLabel("Seal Size:"));
        sealSizeTextField = new JTextField();
        mainPanel.add(sealSizeTextField);
        sealSizeTextField.setText("300"); //default seal size

        JLabel sealSquareLineLabel = new JLabel("Seal (Square) Line Size:");
        sealSquareLineLabel.setOpaque(true);
        sealSquareLineLabel.setBackground(new Color(0x03DAC6));
        mainPanel.add(sealSquareLineLabel);
        sealSquareLineSizeTextField = new JTextField();
        mainPanel.add(sealSquareLineSizeTextField);
        sealSquareLineSizeTextField.setText("16"); //default seal square line size

        JLabel sealCircleBorderHeightLabel = new JLabel("Seal (Circle) Border Height:");
        sealCircleBorderHeightLabel.setOpaque(true);
        sealCircleBorderHeightLabel.setBackground(new Color(0xC1D8E3));
        mainPanel.add(sealCircleBorderHeightLabel);
        sealCircleBorderHeightTextField = new JTextField();
        mainPanel.add(sealCircleBorderHeightTextField);
        sealCircleBorderHeightTextField.setText("100"); //default seal circle border height

        JLabel sealCircleBorderWidthLabel = new JLabel("Seal (Circle) Border Width:");
        sealCircleBorderWidthLabel.setOpaque(true);
        sealCircleBorderWidthLabel.setBackground(new Color(0xC1D8E3));
        mainPanel.add(sealCircleBorderWidthLabel);
        sealCircleBorderWidthTextField = new JTextField();
        mainPanel.add(sealCircleBorderWidthTextField);
        sealCircleBorderWidthTextField.setText("140"); //default seal circle border width

        JLabel sealCircleBorderLineSizeLabel = new JLabel("Seal (Circle) Border Line Size:");
        sealCircleBorderLineSizeLabel.setOpaque(true);
        sealCircleBorderLineSizeLabel.setBackground(new Color(0xC1D8E3));
        mainPanel.add(sealCircleBorderLineSizeLabel);
        sealCircleBorderLineSizeTextField = new JTextField();
        mainPanel.add(sealCircleBorderLineSizeTextField);
        sealCircleBorderLineSizeTextField.setText("3"); //default seal circle border line size

        JLabel sealCircleBorderInnerHeightLabel = new JLabel("Seal (Circle) Border Inner Height:");
        sealCircleBorderInnerHeightLabel.setOpaque(true);
        sealCircleBorderInnerHeightLabel.setBackground(new Color(0xC1CCE3));
        mainPanel.add(sealCircleBorderInnerHeightLabel);
        sealCircleBorderInnerHeightTextField = new JTextField();
        mainPanel.add(sealCircleBorderInnerHeightTextField);
        sealCircleBorderInnerHeightTextField.setText("95"); //default seal circle border inner height

        JLabel sealCircleBorderInnerWidthLabel = new JLabel("Seal (Circle) Border Inner Width:");
        sealCircleBorderInnerWidthLabel.setOpaque(true);
        sealCircleBorderInnerWidthLabel.setBackground(new Color(0xC1CCE3));
        mainPanel.add(sealCircleBorderInnerWidthLabel);
        sealCircleBorderInnerWidthTextField = new JTextField();
        mainPanel.add(sealCircleBorderInnerWidthTextField);
        sealCircleBorderInnerWidthTextField.setText("135"); //default seal circle border inner width

        JLabel sealCircleBorderInnerLineSizeLabel = new JLabel("Seal (Circle) Border Inner Line Size:");
        sealCircleBorderInnerLineSizeLabel.setOpaque(true);
        sealCircleBorderInnerLineSizeLabel.setBackground(new Color(0xC1CCE3));
        mainPanel.add(sealCircleBorderInnerLineSizeLabel);
        sealCircleBorderInnerLineSizeTextField = new JTextField();
        mainPanel.add(sealCircleBorderInnerLineSizeTextField);
        sealCircleBorderInnerLineSizeTextField.setText("1"); //default seal circle border inner line size

        JLabel sealCircleInnerHeightLabel = new JLabel("Seal (Circle) Inner Height:");
        sealCircleInnerHeightLabel.setOpaque(true);
        sealCircleInnerHeightLabel.setBackground(new Color(0xC1C1E3));
        mainPanel.add(sealCircleInnerHeightLabel);
        sealCircleInnerHeightTextField = new JTextField();
        mainPanel.add(sealCircleInnerHeightTextField);
        sealCircleInnerHeightTextField.setText("45"); //default seal circle inner height

        JLabel sealCircleInnerWidthLabel = new JLabel("Seal (Circle) Inner Width:");
        sealCircleInnerWidthLabel.setOpaque(true);
        sealCircleInnerWidthLabel.setBackground(new Color(0xC1C1E3));
        mainPanel.add(sealCircleInnerWidthLabel);
        sealCircleInnerWidthTextField = new JTextField();
        mainPanel.add(sealCircleInnerWidthTextField);
        sealCircleInnerWidthTextField.setText("85"); //default seal circle inner width

        JLabel sealCircleInnerLineSizeLabel = new JLabel("Seal (Circle) Inner Line Size:");
        sealCircleInnerLineSizeLabel.setOpaque(true);
        sealCircleInnerLineSizeLabel.setBackground(new Color(0xC1C1E3));
        mainPanel.add(sealCircleInnerLineSizeLabel);
        sealCircleInnerLineSizeTextField = new JTextField();
        mainPanel.add(sealCircleInnerLineSizeTextField);
        sealCircleInnerLineSizeTextField.setText("2"); //default seal circle inner line size

        JLabel sealSeperateLabel_1 = new JLabel();
        mainPanel.add(sealSeperateLabel_1);
        JLabel sealSeperateLabel_2 = new JLabel();
        mainPanel.add(sealSeperateLabel_2);

        mainPanel.add(new JLabel("Main Text:"));
        mainTextField = new JTextField();
        mainPanel.add(mainTextField);

        mainPanel.add(new JLabel("Main Text Font:"));
        int defaultMainFontIndex = 0;
        for (int i = 0; i < fontNames.length; i++) {
            if (fontNames[i].equals("SimSun")) {
                defaultMainFontIndex = i;
                break;
            }
        }
        mainFontComboBox = new JComboBox<>(SealFont.getSupportFontNames());
        mainPanel.add(mainFontComboBox);
        mainFontComboBox.setSelectedIndex(defaultMainFontIndex);

        mainPanel.add(new JLabel("Main Text Bold:"));
        mainBoldCheckBox = new JCheckBox();
        mainPanel.add(mainBoldCheckBox);
        mainBoldCheckBox.setSelected(true);

        mainPanel.add(new JLabel("Main Text Margin:"));
        mainMarginTextField = new JTextField();
        mainPanel.add(mainMarginTextField);
        mainMarginTextField.setText("10");

        mainPanel.add(new JLabel("Main Text Size:"));
        mainSizeTextField = new JTextField();
        mainPanel.add(mainSizeTextField);
        mainSizeTextField.setText("25");

        mainPanel.add(new JLabel("Main Text Space:"));
        mainSpaceTextField = new JTextField();
        mainPanel.add(mainSpaceTextField);
        mainSpaceTextField.setText("12");

        JLabel MainSeperateLabel_1 = new JLabel();
        mainPanel.add(MainSeperateLabel_1);
        JLabel MainSeperateLabel_2 = new JLabel();
        mainPanel.add(MainSeperateLabel_2);

        mainPanel.add(new JLabel("Vice Text:"));
        viceTextField = new JTextField();
        mainPanel.add(viceTextField);

        mainPanel.add(new JLabel("Vice Text Font:"));
        int defaultViceFontIndex = 0;
        for (int i = 0; i < fontNames.length; i++) {
            if (fontNames[i].equals("SimSun")) {
                defaultViceFontIndex = i;
                break;
            }
        }
        viceFontComboBox = new JComboBox<>(SealFont.getSupportFontNames());
        mainPanel.add(viceFontComboBox);
        viceFontComboBox.setSelectedIndex(defaultViceFontIndex);

        mainPanel.add(new JLabel("Vice Text Bold:"));
        viceBoldCheckBox = new JCheckBox();
        mainPanel.add(viceBoldCheckBox);
        viceBoldCheckBox.setSelected(true);

        mainPanel.add(new JLabel("Vice Text Margin:"));
        viceMarginTextField = new JTextField();
        mainPanel.add(viceMarginTextField);
        viceMarginTextField.setText("5");

        mainPanel.add(new JLabel("Vice Text Size:"));
        viceSizeTextField = new JTextField();
        mainPanel.add(viceSizeTextField);
        viceSizeTextField.setText("22");

        mainPanel.add(new JLabel("Vice Text Space:"));
        viceSpaceTextField = new JTextField();
        mainPanel.add(viceSpaceTextField);
        viceSpaceTextField.setText("12");

        JLabel viceSeperateLabel_1 = new JLabel();
        mainPanel.add(viceSeperateLabel_1);
        JLabel viceSeperateLabel_2 = new JLabel();
        mainPanel.add(viceSeperateLabel_2);

        mainPanel.add(new JLabel("Center Text:"));
        centerTextField = new JTextField();
        mainPanel.add(centerTextField);

        mainPanel.add(new JLabel("Center Text Font:"));
        int defaultCenterTextIndex = 0;
        for (int i = 0; i < fontNames.length; i++) {
            if (fontNames[i].equals("SimSun")) {
                defaultCenterTextIndex = i;
                break;
            }
        }
        centerFontComboBox = new JComboBox<>(SealFont.getSupportFontNames());
        mainPanel.add(centerFontComboBox);
        centerFontComboBox.setSelectedIndex(defaultCenterTextIndex);

        mainPanel.add(new JLabel("Center Text Bold:"));
        centerBoldCheckBox = new JCheckBox();
        mainPanel.add(centerBoldCheckBox);
        centerBoldCheckBox.setSelected(true);

        mainPanel.add(new JLabel("Center Text Margin:"));
        centerMarginTextField = new JTextField();
        mainPanel.add(centerMarginTextField);
        centerMarginTextField.setText("5");

        mainPanel.add(new JLabel("Center Text Size:"));
        centerSizeTextField = new JTextField();
        mainPanel.add(centerSizeTextField);
        centerSizeTextField.setText("25");

        mainPanel.add(new JLabel("Center Text Space:"));
        centerSpaceTextField = new JTextField();
        mainPanel.add(centerSpaceTextField);
        centerSpaceTextField.setText("12");

        JLabel centerSeperateLabel_1 = new JLabel();
        mainPanel.add(centerSeperateLabel_1);
        JLabel centerSeperateLabel_2 = new JLabel();
        mainPanel.add(centerSeperateLabel_2);

        mainPanel.add(new JLabel("Title Text:"));
        titleTextField = new JTextField();
        mainPanel.add(titleTextField);

        mainPanel.add(new JLabel("Title Text Font:"));
        int defaultTitleFontIndex = 0;
        for (int i = 0; i < fontNames.length; i++) {
            if (fontNames[i].equals("SimSun")) {
                defaultTitleFontIndex = i;
                break;
            }
        }
        titleFontComboBox = new JComboBox<>(SealFont.getSupportFontNames());
        mainPanel.add(titleFontComboBox);
        titleFontComboBox.setSelectedIndex(defaultTitleFontIndex);

        mainPanel.add(new JLabel("Title Text Bold:"));
        titleBoldCheckBox = new JCheckBox();
        mainPanel.add(titleBoldCheckBox);
        titleBoldCheckBox.setSelected(true);

        mainPanel.add(new JLabel("Title Text Margin:"));
        titleMarginTextField = new JTextField();
        mainPanel.add(titleMarginTextField);
        titleMarginTextField.setText("27");

        mainPanel.add(new JLabel("Title Text Size:"));
        titleSizeTextField = new JTextField();
        mainPanel.add(titleSizeTextField);
        titleSizeTextField.setText("22");

        mainPanel.add(new JLabel("Title Text Space:"));
        titleSpaceTextField = new JTextField();
        mainPanel.add(titleSpaceTextField);
        titleSpaceTextField.setText("12");

        JLabel titleSeperateLabel_1 = new JLabel();
        mainPanel.add(titleSeperateLabel_1);
        JLabel titleSeperateLabel_2 = new JLabel();
        mainPanel.add(titleSeperateLabel_2);

        sealTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlRows();
            }
        });

        mainPanel.add(new JLabel("File Path:"));
        filePathTextField = new JTextField();
        mainPanel.add(filePathTextField);
        filePathTextField.setText("C:\\Users\\kcm_michaelchan\\Desktop\\"); //default file path

        mainPanel.add(new JLabel("File Name:"));
        fileNameTextField = new JTextField();
        mainPanel.add(fileNameTextField);

        mainPanel.add(new JLabel()); 
        mainPanel.add(new JLabel()); 
        
        JButton privateButton = new JButton("勿按");
        privateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String base64String = new Private().getBase64();
        
                    byte[] imageBytes = Base64.getDecoder().decode(base64String);
        
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
        
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JLabel label = new JLabel(new ImageIcon(image));
                    frame.add(label, BorderLayout.CENTER);
                    frame.pack();
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        mainPanel.add(privateButton);

        generateButton = new JButton("Generate Seal");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sealTypeComboBox.getSelectedIndex() == 1) {
                    generateSquareSeal();
                } else {
                    generateCircleSeal();
                }
            }
        });
        mainPanel.add(generateButton);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setVisible(true);

        controlRows();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    public void generateCircleSeal() {
        try {
            SealConfiguration configuration = new SealConfiguration();

            SealFont mainFont = new SealFont();
            mainFont.setBold(mainBoldCheckBox.isSelected());
            mainFont.setFontFamily(mainFontComboBox.getSelectedItem().toString());
            mainFont.setMarginSize(Integer.parseInt(mainMarginTextField.getText()));
            mainFont.setFontText(mainTextField.getText());
            mainFont.setFontSize(Integer.parseInt(mainSizeTextField.getText()));
            mainFont.setFontSpace(Double.parseDouble(mainSpaceTextField.getText()));
            configuration.setMainFont(mainFont);

            SealFont viceFont = new SealFont();
            viceFont.setBold(viceBoldCheckBox.isSelected());
            viceFont.setFontFamily(viceFontComboBox.getSelectedItem().toString());
            viceFont.setMarginSize(Integer.parseInt(viceMarginTextField.getText()));
            viceFont.setFontText(viceTextField.getText());
            viceFont.setFontSize(Integer.parseInt(viceSizeTextField.getText()));
            viceFont.setFontSpace(Double.parseDouble(viceSpaceTextField.getText()));
            configuration.setViceFont(viceFont);

            SealFont centerFont = new SealFont();
            centerFont.setBold(centerBoldCheckBox.isSelected());
            centerFont.setFontFamily(centerFontComboBox.getSelectedItem().toString());
            centerFont.setMarginSize(Integer.parseInt(centerMarginTextField.getText()));
            centerFont.setFontText(centerTextField.getText());
            centerFont.setFontSize(Integer.parseInt(centerSizeTextField.getText()));
            centerFont.setFontSpace(Double.parseDouble(centerSpaceTextField.getText()));
            configuration.setCenterFont(centerFont);

            SealFont titleFont = new SealFont();
            titleFont.setBold(titleBoldCheckBox.isSelected());
            titleFont.setFontFamily(titleFontComboBox.getSelectedItem().toString());
            titleFont.setMarginSize(Integer.parseInt(titleMarginTextField.getText()));
            titleFont.setFontText(titleTextField.getText());
            titleFont.setFontSize(Integer.parseInt(titleSizeTextField.getText()));
            titleFont.setFontSpace(Double.parseDouble(titleSpaceTextField.getText()));
            configuration.setTitleFont(titleFont);

            configuration.setImageSize(Integer.parseInt(sealSizeTextField.getText()));
            configuration.setBackgroudColor(colorButton.getBackground());
            configuration.setBorderCircle(new SealCircle(Integer.parseInt(sealCircleBorderLineSizeTextField.getText()), Integer.parseInt(sealCircleBorderWidthTextField.getText()), Integer.parseInt(sealCircleBorderHeightTextField.getText())));
            configuration.setBorderInnerCircle(new SealCircle(Integer.parseInt(sealCircleBorderInnerLineSizeTextField.getText()), Integer.parseInt(sealCircleBorderInnerWidthTextField.getText()), Integer.parseInt(sealCircleBorderInnerHeightTextField.getText())));
            configuration.setInnerCircle(new SealCircle(Integer.parseInt(sealCircleInnerLineSizeTextField.getText()), Integer.parseInt(sealCircleInnerWidthTextField.getText()), Integer.parseInt(sealCircleInnerHeightTextField.getText())));

            String fullPath = filePathTextField.getText() + fileNameTextField.getText() + ".png";
            SealUtil.buildAndStoreSeal(configuration, fullPath);

            JOptionPane.showMessageDialog(this, "Seal generated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating seal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generateSquareSeal() {
        try {
            SealFont font = new SealFont();
            font.setFontSize(Integer.parseInt(mainSizeTextField.getText()));
            font.setBold(mainBoldCheckBox.isSelected());
            font.setFontText(mainTextField.getText());
            SealUtil.buildAndStorePersonSeal(Integer.parseInt(sealSizeTextField.getText()), Integer.parseInt(sealSquareLineSizeTextField.getText()), font, "", filePathTextField.getText() + fileNameTextField.getText() + ".png");

            JOptionPane.showMessageDialog(this, "Seal generated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating seal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void controlRows() {
        if (sealTypeComboBox.getSelectedIndex() == 1) {
            mainSizeTextField.setText("120"); //default seal square size
            colorButton.setBackground(Color.RED); //default seal square color
            viceTextField.setEnabled(false);
            viceFontComboBox.setEnabled(false);
            viceBoldCheckBox.setEnabled(false);
            viceMarginTextField.setEnabled(false);
            viceSizeTextField.setEnabled(false);
            viceSpaceTextField.setEnabled(false);
            centerTextField.setEnabled(false);
            centerFontComboBox.setEnabled(false);
            centerBoldCheckBox.setEnabled(false);
            centerMarginTextField.setEnabled(false);
            centerSizeTextField.setEnabled(false);
            centerSpaceTextField.setEnabled(false);
            titleTextField.setEnabled(false);
            titleFontComboBox.setEnabled(false);
            titleBoldCheckBox.setEnabled(false);
            titleMarginTextField.setEnabled(false);
            titleSizeTextField.setEnabled(false);
            titleSpaceTextField.setEnabled(false);
            sealCircleBorderHeightTextField.setEnabled(false);
            sealCircleBorderWidthTextField.setEnabled(false);
            sealCircleBorderLineSizeTextField.setEnabled(false);
            sealCircleBorderInnerHeightTextField.setEnabled(false);
            sealCircleBorderInnerWidthTextField.setEnabled(false);
            sealCircleBorderInnerLineSizeTextField.setEnabled(false);
            sealCircleInnerHeightTextField.setEnabled(false);
            sealCircleInnerWidthTextField.setEnabled(false);
            sealCircleInnerLineSizeTextField.setEnabled(false);
            sealSquareLineSizeTextField.setEnabled(true);
        } else {
            mainSizeTextField.setText("25"); //default seal circle size
            colorButton.setBackground(new Color(0x800080)); //default seal circle color
            viceTextField.setEnabled(true);
            viceFontComboBox.setEnabled(true);
            viceBoldCheckBox.setEnabled(true);
            viceMarginTextField.setEnabled(true);
            viceSizeTextField.setEnabled(true);
            viceSpaceTextField.setEnabled(true);
            centerTextField.setEnabled(true);
            centerFontComboBox.setEnabled(true);
            centerBoldCheckBox.setEnabled(true);
            centerMarginTextField.setEnabled(true);
            centerSizeTextField.setEnabled(true);
            centerSpaceTextField.setEnabled(true);
            titleTextField.setEnabled(true);
            titleFontComboBox.setEnabled(true);
            titleBoldCheckBox.setEnabled(true);
            titleMarginTextField.setEnabled(true);
            titleSizeTextField.setEnabled(true);
            titleSpaceTextField.setEnabled(true);
            sealCircleBorderHeightTextField.setEnabled(true);
            sealCircleBorderWidthTextField.setEnabled(true);
            sealCircleBorderLineSizeTextField.setEnabled(true);
            sealCircleBorderInnerHeightTextField.setEnabled(true);
            sealCircleBorderInnerWidthTextField.setEnabled(true);
            sealCircleBorderInnerLineSizeTextField.setEnabled(true);
            sealCircleInnerHeightTextField.setEnabled(true);
            sealCircleInnerWidthTextField.setEnabled(true);
            sealCircleInnerLineSizeTextField.setEnabled(true);
            sealSquareLineSizeTextField.setEnabled(false);
        }
    }
}