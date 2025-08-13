/*
 * The MIT License
 *
 * Copyright 2024-2025 Μαρέτσικος Χρῆστος.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author Μαρέτσικος Χρῆστος
 */

package PolytLex_plus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class Keyboard extends javax.swing.JFrame {
   
    /**
     * Creates new form Keyboard
     */
    
    ImageIcon icon;
    ImageIcon mygif;
    
    JButton myColorBtn = new JButton(" ");
    
    int numR=127;
    int numG=127;
    int numB=127;
    Color mycolor =  new Color(numR, numG, numB); 
    
    Color mycolorpanel2 =  new Color(85, 221, 255); 
    Color mycolorpanel3 =  new Color(95, 211, 141); 
    Color mycolorpanel4 =  new Color(255, 125, 125); 
    
    int BG_Color_btnR;
    int BG_Color_btnG;
    int BG_Color_btnB;
    Color BG_Color_btn = new Color (BG_Color_btnR, BG_Color_btnG, BG_Color_btnB);
    
    int FG_Color_btnR;
    int FG_Color_btnG;
    int FG_Color_btnB;
    Color FG_Color = new Color (FG_Color_btnR, FG_Color_btnG, FG_Color_btnB);
    
    int BG_Color_listR;
    int BG_Color_listG;
    int BG_Color_listB;
    Color BG_Color_list=new Color(BG_Color_listR, BG_Color_listG, BG_Color_listB);
    
    int numSCR;
    int numSCG;
    int numSCB;
    Color mySelColor =  new Color(numSCR, numSCG, numSCB); 
    Color backupMySelColor;
    
    int Yellow_NumR=255, Yellow_NumG=225, Yellow_NumB=100;
    Color mySelected_Color =  new Color(Yellow_NumR, Yellow_NumG, Yellow_NumB);
    
    Color selectedColor;
    
    int setMyTextSize=20;
    String setMyFont="Arial";
    
    String Title_ColorPalette;
    
    ButtonGroup myThemeGroup = new ButtonGroup();
    ButtonGroup myWhiteBlackGroup = new ButtonGroup();
    
    String myLang;
    String setMyLang="Greek";
    String setMyLangChars="gr" ;
    String pathMyLang="./languages/Greek/keyboard_gr.lang";
    String myForm="/keyboard_";    
    
    String path_keyb_theme="keyboards_black_tonespirit";
    String path_color_letter="_BL";
    
    String win_Normal_icon_path=("./images/win_GR_Polytonic_Normal.png");  
    String win_Shift_icon_path=("./images/win_GR_Polytonic_Shift.png");   
    String win_AltGR_icon_path=("./images/win_GR_Polytonic_AltGR.png");   
    String win_AltGR_Shift_icon_path=("./images/win_GR_Polytonic_AltGR_Shift.png");   
    
    String linux_Normal_icon_path=("./images/linux_GR_Normal.png");  
    String linux_Shift_icon_path=("./images/linux_GR_Shift.png");   
    String linux_Level3_Shift_icon_path=("./images/linux_GR_Level3_Shift.png");   
    String linux_Level3_Shift_Shift_icon_path=("./images/linux_GR_Level3_Shift_Shift.png");   
 
    String macos_Normal_icon_path=("./images/macos_GR_Polytonic_Normal.png");  
    String macos_Shift_icon_path=("./images/macos_GR_Polytonic_Shift.png");   
    String macos_Option_icon_path=("./images/macos_GR_Polytonic_Option.png");   
    String macos_Option_Shift_icon_path=("./images/macos_GR_Polytonic_Option_Shift.png");   
        
    String backup_Button=("");
   
    JButton which_Button = new JButton(" "); 
    
    public Keyboard() {
        initComponents();
        JFrame.setDefaultLookAndFeelDecorated(true); //for Title and Icon for Linux
        
        Image small_logo = new ImageIcon(this.getClass().getResource("/PolytLexplus_logo_256x256.png")).getImage();
        this.setIconImage(small_logo);
        
        setDefaultCloseOperation(Keyboard.DISPOSE_ON_CLOSE);
        
        which_Button = jButton_Normal_Win_; 
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Keyboard_ = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_Help_ = new javax.swing.JTextPane();
        jLabel_gif_ = new javax.swing.JLabel();
        jLabel_Linux_ = new javax.swing.JLabel();
        jLabel_macOS_ = new javax.swing.JLabel();
        jLabel_MS_Windows_ = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jButton_Big_Letter_ = new javax.swing.JButton();
        jButton_Small_Letter_ = new javax.swing.JButton();
        jTextField_FontName_ = new javax.swing.JTextField();
        jTextField_FontSize_ = new javax.swing.JTextField();
        jTextField_Test_ = new javax.swing.JTextField();
        jLabel_Test_ = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_Normal_Win_ = new javax.swing.JButton();
        jButton_Shift_Win_ = new javax.swing.JButton();
        jButton_AltGR_Win_ = new javax.swing.JButton();
        jButton_AltGR_Shift_Win_ = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton_Normal_macOS_ = new javax.swing.JButton();
        jButton_Shift_macOS_ = new javax.swing.JButton();
        jButton_Option_macOS_ = new javax.swing.JButton();
        jButton_Option_Shift_macOS_ = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton_Normal_Linux_ = new javax.swing.JButton();
        jButton_Shift_Linux_ = new javax.swing.JButton();
        jButton_Level3_Shift_Linux_ = new javax.swing.JButton();
        jButton_Level3_Shift_Shift_Linux_ = new javax.swing.JButton();
        jRadioButton_Bright_ = new javax.swing.JRadioButton();
        jRadioButton_Gray1_ = new javax.swing.JRadioButton();
        jRadioButton_Dark_ = new javax.swing.JRadioButton();
        jRadioButton_Color_ = new javax.swing.JRadioButton();
        jRadioButton_White_ = new javax.swing.JRadioButton();
        jRadioButton_Black_ = new javax.swing.JRadioButton();
        jLabel_Theme_ = new javax.swing.JLabel();
        jLabel_AccentSpirit_ = new javax.swing.JLabel();
        jRadioButton_Gray2_ = new javax.swing.JRadioButton();
        jButton_myColorChooser_ = new javax.swing.JButton();
        jButton_HowDoWeWrite_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Πληκτρολόγιο");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_Keyboard_.setBackground(new java.awt.Color(242, 242, 242));
        jPanel_Keyboard_.setPreferredSize(new java.awt.Dimension(1138, 976));

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 255));

        jText_Help_.setEditable(false);
        jText_Help_.setBackground(new java.awt.Color(242, 242, 242));
        jText_Help_.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jText_Help_.setPreferredSize(new java.awt.Dimension(1088, 241));
        jScrollPane1.setViewportView(jText_Help_);

        jLabel_Linux_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_Linux_.setText("Linux");
        jLabel_Linux_.setPreferredSize(new java.awt.Dimension(100, 42));

        jLabel_macOS_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_macOS_.setText("macOS");
        jLabel_macOS_.setPreferredSize(new java.awt.Dimension(100, 42));

        jLabel_MS_Windows_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_MS_Windows_.setText("MS Windows");
        jLabel_MS_Windows_.setPreferredSize(new java.awt.Dimension(100, 42));

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton_Big_Letter_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Big_Letter_.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton_Big_Letter_.setText("A");
        jButton_Big_Letter_.setToolTipText("Αὔξηση μεγέθους γραμματοσειρᾶς");
        jButton_Big_Letter_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Big_Letter_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Big_Letter_ActionPerformed(evt);
            }
        });

        jButton_Small_Letter_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Small_Letter_.setText("A");
        jButton_Small_Letter_.setToolTipText("Μείωση μεγέθους γραμματοσειρᾶς");
        jButton_Small_Letter_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Small_Letter_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Small_Letter_ActionPerformed(evt);
            }
        });

        jTextField_FontName_.setEditable(false);
        jTextField_FontName_.setBackground(new java.awt.Color(242, 242, 242));
        jTextField_FontName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_FontName_.setPreferredSize(new java.awt.Dimension(270, 40));

        jTextField_FontSize_.setEditable(false);
        jTextField_FontSize_.setBackground(new java.awt.Color(242, 242, 242));
        jTextField_FontSize_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_FontSize_.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_FontSize_.setPreferredSize(new java.awt.Dimension(40, 40));

        jTextField_Test_.setBackground(new java.awt.Color(242, 242, 242));
        jTextField_Test_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_Test_.setToolTipText("Δοκιμάστε νὰ γράψετε μερικὰ γράμματα μὲ τόνο καὶ πνεῦμα");
        jTextField_Test_.setPreferredSize(new java.awt.Dimension(514, 50));

        jLabel_Test_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_Test_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Test_.setText("Δοκιμή: ");
        jLabel_Test_.setPreferredSize(new java.awt.Dimension(70, 50));

        jPanel2.setBackground(new java.awt.Color(85, 221, 255));

        jButton_Normal_Win_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Normal_Win_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Normal_Win_.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton_Normal_Win_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Normal_Win_ActionPerformed(evt);
            }
        });

        jButton_Shift_Win_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Shift_Win_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Shift_Win_.setText("Shift");
        jButton_Shift_Win_.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton_Shift_Win_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Shift_Win_ActionPerformed(evt);
            }
        });

        jButton_AltGR_Win_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_AltGR_Win_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_AltGR_Win_.setText("AltGR");
        jButton_AltGR_Win_.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton_AltGR_Win_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AltGR_Win_ActionPerformed(evt);
            }
        });

        jButton_AltGR_Shift_Win_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_AltGR_Shift_Win_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_AltGR_Shift_Win_.setText("AltGR + Shift");
        jButton_AltGR_Shift_Win_.setPreferredSize(new java.awt.Dimension(180, 30));
        jButton_AltGR_Shift_Win_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AltGR_Shift_Win_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Normal_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Shift_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_AltGR_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_AltGR_Shift_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Shift_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_AltGR_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_AltGR_Shift_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_Normal_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(95, 211, 141));
        jPanel3.setPreferredSize(new java.awt.Dimension(550, 42));

        jButton_Normal_macOS_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Normal_macOS_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Normal_macOS_.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton_Normal_macOS_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Normal_macOS_ActionPerformed(evt);
            }
        });

        jButton_Shift_macOS_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Shift_macOS_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Shift_macOS_.setText("Shift");
        jButton_Shift_macOS_.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton_Shift_macOS_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Shift_macOS_ActionPerformed(evt);
            }
        });

        jButton_Option_macOS_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Option_macOS_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Option_macOS_.setText("Option");
        jButton_Option_macOS_.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton_Option_macOS_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Option_macOS_ActionPerformed(evt);
            }
        });

        jButton_Option_Shift_macOS_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Option_Shift_macOS_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Option_Shift_macOS_.setText("Option + Shift");
        jButton_Option_Shift_macOS_.setPreferredSize(new java.awt.Dimension(180, 30));
        jButton_Option_Shift_macOS_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Option_Shift_macOS_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Normal_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Shift_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Option_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Option_Shift_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Shift_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Option_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Option_Shift_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_Normal_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel4.setBackground(new java.awt.Color(255, 125, 125));
        jPanel4.setPreferredSize(new java.awt.Dimension(550, 42));

        jButton_Normal_Linux_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Normal_Linux_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Normal_Linux_.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton_Normal_Linux_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Normal_Linux_ActionPerformed(evt);
            }
        });

        jButton_Shift_Linux_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Shift_Linux_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Shift_Linux_.setText("Shift");
        jButton_Shift_Linux_.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton_Shift_Linux_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Shift_Linux_ActionPerformed(evt);
            }
        });

        jButton_Level3_Shift_Linux_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Level3_Shift_Linux_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Level3_Shift_Linux_.setText("Level3 Shift");
        jButton_Level3_Shift_Linux_.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton_Level3_Shift_Linux_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Level3_Shift_Linux_ActionPerformed(evt);
            }
        });

        jButton_Level3_Shift_Shift_Linux_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Level3_Shift_Shift_Linux_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Level3_Shift_Shift_Linux_.setText("Level3 Shift + Shift");
        jButton_Level3_Shift_Shift_Linux_.setPreferredSize(new java.awt.Dimension(180, 30));
        jButton_Level3_Shift_Shift_Linux_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Level3_Shift_Shift_Linux_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Normal_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Shift_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Level3_Shift_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Level3_Shift_Shift_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Normal_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Level3_Shift_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Level3_Shift_Shift_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Shift_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButton_Bright_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_Bright_.setText("Φωτεινὸ");
        jRadioButton_Bright_.setPreferredSize(new java.awt.Dimension(133, 25));
        jRadioButton_Bright_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Bright_ActionPerformed(evt);
            }
        });

        jRadioButton_Gray1_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_Gray1_.setText("Γκρὶ");
        jRadioButton_Gray1_.setPreferredSize(new java.awt.Dimension(133, 25));
        jRadioButton_Gray1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Gray1_ActionPerformed(evt);
            }
        });

        jRadioButton_Dark_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_Dark_.setText("Σκοτεινὸ");
        jRadioButton_Dark_.setPreferredSize(new java.awt.Dimension(133, 25));
        jRadioButton_Dark_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Dark_ActionPerformed(evt);
            }
        });

        jRadioButton_Color_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_Color_.setText("Ἔγχρωμο");
        jRadioButton_Color_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Color_ActionPerformed(evt);
            }
        });

        jRadioButton_White_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_White_.setText("Ἄσπρο");
        jRadioButton_White_.setPreferredSize(new java.awt.Dimension(133, 25));
        jRadioButton_White_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_White_ActionPerformed(evt);
            }
        });

        jRadioButton_Black_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_Black_.setText("Μαῦρο");
        jRadioButton_Black_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Black_ActionPerformed(evt);
            }
        });

        jLabel_Theme_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Theme_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Theme_.setText("Θέμα");
        jLabel_Theme_.setPreferredSize(new java.awt.Dimension(133, 25));

        jLabel_AccentSpirit_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_AccentSpirit_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_AccentSpirit_.setText("Τόνος/Πνεῦμα");
        jLabel_AccentSpirit_.setPreferredSize(new java.awt.Dimension(133, 25));

        jRadioButton_Gray2_.setText("Γκρὶ");
        jRadioButton_Gray2_.setPreferredSize(new java.awt.Dimension(133, 25));
        jRadioButton_Gray2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Gray2_ActionPerformed(evt);
            }
        });

        jButton_myColorChooser_.setBackground(new java.awt.Color(255, 255, 100));
        jButton_myColorChooser_.setToolTipText("Ἐπιλεγμένο χρῶμα");
        jButton_myColorChooser_.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton_myColorChooser_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_myColorChooser_ActionPerformed(evt);
            }
        });

        jButton_HowDoWeWrite_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_HowDoWeWrite_.setText("i");
        jButton_HowDoWeWrite_.setToolTipText("Πῶς γράφουμε");
        jButton_HowDoWeWrite_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_HowDoWeWrite_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HowDoWeWrite_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Keyboard_Layout = new javax.swing.GroupLayout(jPanel_Keyboard_);
        jPanel_Keyboard_.setLayout(jPanel_Keyboard_Layout);
        jPanel_Keyboard_Layout.setHorizontalGroup(
            jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Keyboard_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_Keyboard_Layout.createSequentialGroup()
                        .addComponent(jTextField_FontName_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_FontSize_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Big_Letter_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Small_Letter_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel_Test_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Test_, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel_Keyboard_Layout.createSequentialGroup()
                            .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel_Keyboard_Layout.createSequentialGroup()
                                    .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_MS_Windows_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel_gif_, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton_Bright_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Gray1_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Dark_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Color_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_White_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Black_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_AccentSpirit_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Gray2_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_myColorChooser_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_Theme_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_HowDoWeWrite_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44))))))
                .addGap(20, 20, 20))
        );
        jPanel_Keyboard_Layout.setVerticalGroup(
            jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Keyboard_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_Keyboard_Layout.createSequentialGroup()
                        .addComponent(jLabel_Theme_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Bright_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Gray1_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Dark_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Color_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_AccentSpirit_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_White_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Gray2_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Black_, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_myColorChooser_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Keyboard_Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Linux_, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_macOS_, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_MS_Windows_, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_Keyboard_Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel_gif_, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Keyboard_Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_HowDoWeWrite_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Small_Letter_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FontName_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FontSize_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Test_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Test_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Big_Letter_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Keyboard_, javax.swing.GroupLayout.PREFERRED_SIZE, 1128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Keyboard_, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        File fileBG = new File("./settings/colorbg.set");
        File fileBG_btn = new File("./settings/colorbtn.set");
        File fileFG_btn = new File("./settings/colorlttr.set");
        File fileMyFont = new File("./settings/myfont.set");
        File fileMyLang = new File ("./settings/mylang.set");
        File fileMySelColor = new File("./settings/myselcolor.set");
        
        try {
            
        Scanner sML = new Scanner(fileMyLang);
        setMyLang=(sML.nextLine());
        myLang=setMyLang;
        setMyLangChars=(sML.nextLine());
        pathMyLang="./languages/" + setMyLang + myForm + setMyLangChars +".lang";    
        //System.out.println("Γλώσσα: " + setMyLang + " [" + setMyLangChars + "] " + "\n");
        File fileSetMyLang= new File (pathMyLang);            
            
            //System.out.println("\n");
            Scanner sBG = new Scanner( fileBG);
            //System.out.println("Χρώμα φόντου");
            numR=(sBG.nextInt());
            //System.out.println(numR);
            numG=(sBG.nextInt());
            //System.out.println(numG);
            numB=(sBG.nextInt());
            //System.out.println(numB);
            //System.out.println("\n");
            mycolor =new Color(numR, numG, numB);
            jPanel_Keyboard_.setBackground(mycolor);
                       
            Scanner sBG_btn = new Scanner(fileBG_btn);
            //System.out.println("Χρώμα κουμπιών");
            BG_Color_btnR=(sBG_btn.nextInt());
            //System.out.println(BG_Color_btnR);
            BG_Color_btnG=(sBG_btn.nextInt());
            //System.out.println(BG_Color_btnG);
            BG_Color_btnB=(sBG_btn.nextInt());
            //System.out.println(BG_Color_btnB);
            //System.out.println("Χρώμα Λίστας/Πεδίου");
            BG_Color_listR=(sBG_btn.nextInt());
            //System.out.println(BG_Color_listR);
            BG_Color_listG=(sBG_btn.nextInt());
            //System.out.println(BG_Color_listG);
            BG_Color_listB=(sBG_btn.nextInt());
            //System.out.println(BG_Color_listB);
            //System.out.println("");
            //System.out.println("\n");
            BG_Color_btn =new Color(BG_Color_btnR, BG_Color_btnG, BG_Color_btnB);
            BG_Color_list=new Color(BG_Color_listR, BG_Color_listG, BG_Color_listB);
                      
            Scanner sFG_btn = new Scanner(fileFG_btn);
            //System.out.println("Χρώμα γραμμάτων");
            FG_Color_btnR=(sFG_btn.nextInt());
            //System.out.println(FG_Color_btnR);
            FG_Color_btnG=(sFG_btn.nextInt());
            //System.out.println(FG_Color_btnG);
            FG_Color_btnB=(sFG_btn.nextInt());
            //System.out.println(FG_Color_btnB);
            //System.out.println("\n");
            FG_Color = new Color (FG_Color_btnR, FG_Color_btnG, FG_Color_btnB);
            
            Scanner spathML = new Scanner(fileSetMyLang);
 
            setMyLang=(spathML.nextLine());
            this.setTitle(setMyLang);
                    
            setMyLang=(spathML.nextLine());
            jLabel_Theme_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jRadioButton_Bright_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jRadioButton_Gray1_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jRadioButton_Dark_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jRadioButton_Color_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jLabel_AccentSpirit_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jRadioButton_White_.setText(setMyLang);
          
            setMyLang=(spathML.nextLine());
            jRadioButton_Gray2_.setText(setMyLang);           
                    
            setMyLang=(spathML.nextLine());
            jRadioButton_Black_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_myColorChooser_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            Title_ColorPalette=setMyLang;            
      
            setMyLang=(spathML.nextLine());
            jButton_HowDoWeWrite_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jTextField_FontName_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jTextField_FontSize_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jButton_Big_Letter_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jButton_Small_Letter_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jLabel_Test_.setText(setMyLang);

            setMyLang=(spathML.nextLine());
            jTextField_Test_.setToolTipText(setMyLang);    
            
            Scanner sMSC = new Scanner( fileMySelColor);
            //System.out.println("Ἐπιλεγμένο χρῶμα");
            numSCR=(sMSC.nextInt());
            //System.out.println(numSCR);
            numSCG=(sMSC.nextInt());
            //System.out.println(numSCG);
            numSCB=(sMSC.nextInt());
            //System.out.println(numSCB);
            //System.out.println("\n");
            mySelColor =new Color(numSCR, numSCG, numSCB);
            selectedColor=mySelColor;
            mySelected_Color=mySelColor;
            jButton_myColorChooser_.setBackground(mySelColor);            
            
            Scanner sMF = new Scanner(fileMyFont);
            setMyFont=(sMF.nextLine());
            Font myFont = new Font(setMyFont, Font.PLAIN, 20);
            jText_Help_.setFont(myFont);
            jTextField_Test_.setFont(myFont);
            //System.out.println("Γραμματοσειρά: " + setMyFont + "\n"  + "Μέγεθος: " + setMyTextSize);
            
            jButton_Normal_Win_.setBackground(mySelected_Color);
            myColorBtn=jButton_Normal_Win_;
            jButton_Normal_Win_.setForeground(FG_Color);
          
            jLabel_Linux_.setForeground(FG_Color);
            jLabel_macOS_.setForeground(FG_Color);
            jLabel_MS_Windows_.setForeground(FG_Color);
            
            jButton_Shift_Win_.setBackground(BG_Color_btn);
            jButton_AltGR_Win_.setBackground(BG_Color_btn);
            jButton_AltGR_Shift_Win_.setBackground(BG_Color_btn);  
            jButton_Normal_Linux_.setBackground(BG_Color_btn);
            jButton_Shift_Linux_.setBackground(BG_Color_btn);
            jButton_Level3_Shift_Linux_.setBackground(BG_Color_btn);
            jButton_Level3_Shift_Shift_Linux_.setBackground(BG_Color_btn);
            jButton_Normal_macOS_.setBackground(BG_Color_btn);
            jButton_Shift_macOS_.setBackground(BG_Color_btn);
            jButton_Option_macOS_.setBackground(BG_Color_btn);
            jButton_Option_Shift_macOS_.setBackground(BG_Color_btn);  
            jButton_Big_Letter_.setBackground(BG_Color_btn);
            jButton_Small_Letter_.setBackground(BG_Color_btn);
            
            jButton_HowDoWeWrite_.setForeground(FG_Color);
            jButton_HowDoWeWrite_.setBackground(BG_Color_btn);
            
            
            myThemeGroup.add(jRadioButton_Bright_);
            myThemeGroup.add(jRadioButton_Gray1_);
            myThemeGroup.add(jRadioButton_Dark_);
            myThemeGroup.add(jRadioButton_Color_);
            jRadioButton_Color_.setSelected(true);
          
            myWhiteBlackGroup.add(jRadioButton_White_);
            myWhiteBlackGroup.add(jRadioButton_Gray2_);
            myWhiteBlackGroup.add(jRadioButton_Black_);
            jRadioButton_Black_.setSelected(true);
          
            jLabel_Theme_.setForeground(FG_Color);
            jLabel_AccentSpirit_.setForeground(FG_Color);
            jRadioButton_Bright_.setForeground(FG_Color);
            jRadioButton_Gray1_.setForeground(FG_Color);
            jRadioButton_Dark_.setForeground(FG_Color);
            jRadioButton_Color_.setForeground(FG_Color);
            
            jRadioButton_White_.setForeground(FG_Color);
            jRadioButton_Gray2_.setForeground(FG_Color);
            jRadioButton_Black_.setForeground(FG_Color);
            
            jText_Help_.setSelectionColor(selectedColor);
            jTextField_FontName_.setSelectionColor(selectedColor);
            jTextField_FontSize_.setSelectionColor(selectedColor);
            jTextField_Test_.setSelectionColor(selectedColor);
            
                
        if ("Greek".equals(myLang)) {
       
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Χωρὶς πλῆκτρο τροποποίησης</H3>\n" +
            "<p>Πατᾶμε τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὸ πλῆκτρο καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Ἔχουμε τοὺς παρακάτω δέκα (10) συνδυασμούς:</p> \n" +
            "<p>1. διαλυτικὰ ὀξεῖα { ΐ, ΰ }</p> \n" +
            "<p>2. μακρὸν { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }</p>  \n" +
            "<p>3. ψιλὴ περισπωμένη { ἆ, ἦ, ἶ, ὖ, ὦ, Ἆ, Ἦ, Ἶ, Ὦ }</p>  \n" +
            "<p>4. ὀξεῖα { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ }</p>  \n" +
            "<p>5. περισπωμένη { ᾶ, ῆ, ῖ, ῦ, ῶ }</p>  \n" +
            "<p>6. βαρεῖα { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ἐ, Ἠ, Ἰ, Ὸ, Ὺ, Ὼ }</p>  \n" +
            "<p>7. ψιλὴ βαρεῖα { ἂ, ἒ, ἢ, ἲ, ὂ, ὒ, ὢ, Ἂ, Ἒ, Ἢ, Ἲ, Ὂ, Ὢ }</p>  \n" +
            "<p>8. τόνος { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } σημείωση: δὲν εἶναι ὀξεῖα </p>  \n" +
            "<p>9. ψιλὴ { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ καὶ τὸ ῤ }</p>  \n" +
            "<p>10. ψιλὴ ὀξεῖα { ἄ, ἔ, ἤ, ἴ, ὄ, ὔ, ὤ, Ἄ, Ἔ, Ἤ, Ἴ, Ὄ, Ὤ }</p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        
        }
            
        else if (!"Greek".equals(myLang)) {
                
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Keyboard: Greek polytonic </H3> <H3>Without modification key</H3>\n" +
            "<p>We press the dead key we want, then release the key, then select the vowel.</p>\n" +
            "<p>We have the following ten (10) combinations:</p> \n" +
            "<p>1. diaeresis acute { ΐ, ΰ }</p> \n" +
            "<p>2. makron { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }</p>  \n" +
            "<p>3. smooth circumflex { ἆ, ἦ, ἶ, ὖ, ὦ, Ἆ, Ἦ, Ἶ, Ὦ }</p>  \n" +
            "<p>4. acute { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ }</p>  \n" +
            "<p>5. circumflex { ᾶ, ῆ, ῖ, ῦ, ῶ }</p>  \n" +
            "<p>6. grave { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ἐ, Ἠ, Ἰ, Ὸ, Ὺ, Ὼ }</p>  \n" +
            "<p>7. smooth grave { ἂ, ἒ, ἢ, ἲ, ὂ, ὒ, ὢ, Ἂ, Ἒ, Ἢ, Ἲ, Ὂ, Ὢ }</p>  \n" +
            "<p>8. accent { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } note: is not accute</p>  \n" +
            "<p>9. smooth { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ and the ῤ }</p>  \n" +
            "<p>10. smooth acute { ἄ, ἔ, ἤ, ἴ, ὄ, ὔ, ὤ, Ἄ, Ἔ, Ἤ, Ἴ, Ὄ, Ὤ }</p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);  
            
       }
        
        else {
                
            }
            
            jText_Help_.moveCaretPosition(0);
            
            jButton_Shift_Win_.setForeground(FG_Color);
            jButton_AltGR_Win_.setForeground(FG_Color);
            jButton_AltGR_Shift_Win_.setForeground(FG_Color);  
            jButton_Normal_Linux_.setForeground(FG_Color);
            jButton_Shift_Linux_.setForeground(FG_Color);
            jButton_Level3_Shift_Linux_.setForeground(FG_Color);
            jButton_Level3_Shift_Shift_Linux_.setForeground(FG_Color);
            jButton_Normal_macOS_.setForeground(FG_Color);
            jButton_Shift_macOS_.setForeground(FG_Color);
            jButton_Option_macOS_.setForeground(FG_Color);
            jButton_Option_Shift_macOS_.setForeground(FG_Color); 
            jButton_Big_Letter_.setForeground(FG_Color);
            jButton_Small_Letter_.setForeground(FG_Color);
        

            }
        
        catch (FileNotFoundException ex) {
            }
        
            icon = new ImageIcon("./images/win_GR_Polytonic_Normal.png");
            img.setIcon(icon);
                 
            mygif=new ImageIcon("./images/flag-of-greece.gif");
            jLabel_gif_.setIcon(mygif);
                
            jTextField_FontName_.setText(setMyFont);
            jTextField_FontName_.setBackground(BG_Color_list);
            jTextField_FontName_.setForeground(FG_Color);
            jTextField_FontSize_.setText("20");
            jTextField_FontSize_.setBackground(BG_Color_list);
            jTextField_FontSize_.setForeground(FG_Color);
            
            jLabel_Test_.setForeground(FG_Color);
            jTextField_Test_.setText("");
            jTextField_Test_.setBackground(BG_Color_list);
            jTextField_Test_.setForeground(FG_Color);
            
            jRadioButton_White_.setEnabled(false);
            jRadioButton_Gray2_.setEnabled(false);
            jRadioButton_Black_.setEnabled(false);
            
    }//GEN-LAST:event_formWindowOpened

    private void jButton_Level3_Shift_Shift_Linux_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Level3_Shift_Shift_Linux_ActionPerformed

        icon = new ImageIcon(linux_Level3_Shift_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(linux_Level3_Shift_Shift_icon_path); 

        jButton_Level3_Shift_Shift_Linux_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Level3_Shift_Shift_Linux_;
        
        if (backup_Button==("Level3 Shift + Shift")) {
             jButton_Level3_Shift_Shift_Linux_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Level3 Shift + Shift");
        }

        if ("Greek".equals(myLang)) { 
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[Level3 Shift]</font> καὶ <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὰ πλῆκτρα Level3 Shift καὶ Shift, καὶ χωρὶς νὰ τὰ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὰ πλῆκτρα Level3 Shift καὶ Shift ἔχουμε τοὺς παρακάτω τέσσερις (4) συνδυασμούς:</p> \n" +
            "<p>1. μακρὸν { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }</p>  \n" +
            "<p>2. βραχὺ { ᾰ, ῐ, ῠ, Ᾰ, Ῐ, Ῠ }</p> \n" +
            "<p>3. ψιλὴ { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ καὶ τὸ ῤ }</p>  \n" +
            "<p>4. δασεία { ἁ, ἑ, ἡ, ἱ, ὁ, ὑ, ὡ, Ἁ, Ἑ, Ἡ, Ἱ, Ὁ, Ὑ, Ὡ καὶ τὰ ῥ, Ῥ}</p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.moveCaretPosition(0);
        
        }
  
        else if (!"Greek".equals(myLang)) { 
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Keyboard: Greek </H3> <H3>Modify keys <font color=\"red\">[Level3 Shift]</font> and <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>We first press the Level3 Shift and Shift keys, and without releasing them we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the Level3 Shift and Shift keys we have the following four (4) combinations:</p> \n" +
            "<p>1. macron { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }</p>  \n" +
            "<p>2. breve { ᾰ, ῐ, ῠ, Ᾰ, Ῐ, Ῠ }</p> \n" +
            "<p>3. smooth { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ and the ῤ }</p>  \n" +
            "<p>4. rough { ἁ, ἑ, ἡ, ἱ, ὁ, ὑ, ὡ, Ἁ, Ἑ, Ἡ, Ἱ, Ὁ, Ὑ, Ὡ and the ῥ, Ῥ}</p> \n" +  
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.moveCaretPosition(0);
        
        }
            
        else {
            
        }

        which_Button=jButton_Level3_Shift_Shift_Linux_;
                
    }//GEN-LAST:event_jButton_Level3_Shift_Shift_Linux_ActionPerformed

    private void jButton_Level3_Shift_Linux_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Level3_Shift_Linux_ActionPerformed

        icon = new ImageIcon(linux_Level3_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(linux_Level3_Shift_icon_path);   
       
        jButton_Level3_Shift_Linux_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Level3_Shift_Linux_;
        
        if (backup_Button==("Level3 Shift")) {
             jButton_Level3_Shift_Linux_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Level3 Shift");
        }

        if ("Greek".equals(myLang)) { 
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[Level3 Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὸ πλῆκτρο Level3 Shift, καὶ χωρὶς νὰ τὸ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὸ πλῆκτρο Level3 Shift ἔχουμε τοὺς παρακάτω τέσσερις (4) συνδυασμούς:</p> \n" +
            "<p>1. περισπωμένη { ᾶ, ῆ, ῖ, ῦ, ῶ }</p>  \n" +
            "<p>2. ὑπογεγραμμένη  { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ }</p>\n" +
            "<p>3. τόνος { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } σημείωση: δὲν εἶναι ὀξεῖα </p>  \n" +
            "<p>4. βαρεῖα { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ  }</p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
        
            jText_Help_.setCaretPosition(0);
        }

        else if (!"Greek".equals(myLang)) { 
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Keyboard: Greek </H3> <H3>Modify key <font color=\"red\">[Level3 Shift]</font></H3>\n" +
            "<p>First we press the Level3 Shift key, and without releasing it we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the Level3 Shift key we have the following four (4) combinations:</p> \n" +
            "<p>1. circumflex { ᾶ, ῆ, ῖ, ῦ, ῶ }</p>  \n" +
            "<p>2. subscript  { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ }</p>\n" +
            "<p>3. accent { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } note: is not accute </p>  \n" +
            "<p>4. grave { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ  }</p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
        
            jText_Help_.setCaretPosition(0);
        }
        
        else {
            
        }
        
        which_Button=jButton_Level3_Shift_Linux_;

    }//GEN-LAST:event_jButton_Level3_Shift_Linux_ActionPerformed

    private void jButton_Shift_Linux_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Shift_Linux_ActionPerformed

        icon = new ImageIcon(linux_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(linux_Shift_icon_path);        

        jButton_Shift_Linux_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Shift_Linux_;
        
        if (backup_Button==("Shift")) {
             jButton_Shift_Linux_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Shift");
        }
        
        if ("Greek".equals(myLang)) {  
                
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὸ πλῆκτρο Shift, καὶ χωρὶς νὰ τὸ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὸ πλῆκτρο Shift ἔχουμε τὸν παρακάτω ἕνα (1) συνδυασμό:</p> \n" +
            "<p>1. διαλυτικὰ { ϊ, ϋ, Ϊ, Ϋ }</p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.moveCaretPosition(0);
        
        }

        else if (!"Greek".equals(myLang)) {  
                
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Keyboard: Greek </H3> <H3>Modify key <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>First we press the Shift key, and without releasing it we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>We have the following one (1) combination:</p> \n" +
            "<p>1. diaeresis { ϊ, ϋ, Ϊ, Ϋ }</p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.moveCaretPosition(0);
        
        }
        
        else {
            
        }
        
        which_Button=jButton_Shift_Linux_;

    }//GEN-LAST:event_jButton_Shift_Linux_ActionPerformed

    private void jButton_Normal_Linux_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Normal_Linux_ActionPerformed
        
        icon = new ImageIcon(linux_Normal_icon_path);
        img.setIcon(icon);
        //System.out.println(linux_Normal_icon_path);

        jButton_Normal_Linux_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Normal_Linux_;
        
        if (backup_Button==("")) {
             jButton_Normal_Linux_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("");
        }

        if ("Greek".equals(myLang)) {  
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ </H3> <H3>Χωρὶς πλῆκτρο τροποποίησης</H3>\n" +
            "<p>Πατᾶμε τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὸ πλῆκτρο καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Ἔχουμε τὸν παρακάτω ἕνα (1) συνδυασμό:</p> \n" +
            "<p>1. τόνος { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ   } σημείωση: δὲν εἶναι ὀξεῖα </p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        }
        
        else if (!"Greek".equals(myLang)) {  
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>Linux</H3> <H3> Keyboard: Greek </H3> <H3>Without modification key</H3>\n" +
            "<p>We press the dead key we want, then release the key, then select the vowel.</p>\n" +
            "<p>We have the following one (1) combination:</p> \n" +
            "<p>1. accent { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ   } note: is not accute </p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        }

        else {
            
        }
        
        which_Button=jButton_Normal_Linux_;
                
    }//GEN-LAST:event_jButton_Normal_Linux_ActionPerformed

    private void jButton_Option_Shift_macOS_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Option_Shift_macOS_ActionPerformed

        icon = new ImageIcon(macos_Option_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(macos_Option_Shift_icon_path);

        jButton_Option_Shift_macOS_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Option_Shift_macOS_;
        
        if (backup_Button==("Option+Shift")) {
             jButton_Option_Shift_macOS_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Option+Shift");
        }

        if ("Greek".equals(myLang)) {  
               
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Πλῆκτρα τροποποίησης <font color=\"red\">[Option] </font> καὶ <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὰ πλῆκτρα Option καὶ Shift, καὶ χωρὶς νὰ τὰ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὰ πλῆκτρα Option καὶ Shift ἔχουμε τὸν παρακάτω ἕνα (1) συνδυασμό:</p> \n" +
            "<p>1. μακρὸν { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }  </p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            jText_Help_.setCaretPosition(0);
        }    

        else if (!"Greek".equals(myLang)) {  
               
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Keyboard: Greek polytonic </H3> <H3>Modify keys <font color=\"red\">[Option] </font> and <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>We first press the Option and Shift keys, and without releasing them we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the Option and Shift keys we have the following one (1) combination:</p> \n" +
            "<p>1. macron { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }  </p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            jText_Help_.setCaretPosition(0);
        }  

        else {
                    
        }
                
        which_Button=jButton_Option_Shift_macOS_;
                
    }//GEN-LAST:event_jButton_Option_Shift_macOS_ActionPerformed

    private void jButton_Option_macOS_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Option_macOS_ActionPerformed

        icon = new ImageIcon(macos_Option_icon_path);
        img.setIcon(icon);
        //System.out.println(macos_Option_icon_path);

        jButton_Option_macOS_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Option_macOS_;
        
        if (backup_Button==("Option")) {
             jButton_Option_macOS_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Option");
        }

        if ("Greek".equals(myLang)) {    
            
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[Option]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὸ πλῆκτρο Option, καὶ χωρὶς νὰ τὸ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὸ πλῆκτρο Option ἔχουμε τοὺς παρακάτω δύο (2) συνδυασμούς:</p> \n" +
            "<p>1. ὑπογεγραμμένη { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ } </p>\n" +
            "<p>2. βραχὺ { ᾰ, ῐ, ῠ, Ᾰ, Ῐ, Ῠ }</p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
            
        }    

        else if (!"Greek".equals(myLang)) {    
            
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Keyboard: Greek polytonic </H3> <H3>Modify key <font color=\"red\">[Option]</font></H3>\n" +
            "<p>First we press the Option key, and without releasing it we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the Option key we have the following two (2) combinations:</p> \n" +
            "<p>1. subscript { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ } </p>\n" +
            "<p>2. breve { ᾰ, ῐ, ῠ, Ᾰ, Ῐ, Ῠ }</p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
            
        }
        
        else {
                
        }
                
        which_Button=jButton_Option_macOS_;
                
    }//GEN-LAST:event_jButton_Option_macOS_ActionPerformed

    private void jButton_Shift_macOS_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Shift_macOS_ActionPerformed

        icon = new ImageIcon(macos_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(macos_Shift_icon_path);

        jButton_Shift_macOS_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Shift_macOS_;
        
        if (backup_Button==("Shift")) {
             jButton_Shift_macOS_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Shift");
        }
        
        if ("Greek".equals(myLang)) {         
         
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὸ πλῆκτρο Shift, καὶ χωρὶς νὰ τὸ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὸ πλῆκτρο Shift ἔχουμε τοὺς παρακάτω ὀκτὼ (8) συνδυασμούς:</p> \n" +
            "<p>1. δασεία περισπωμένη { ἇ, ἧ, ἷ, ὗ, ὧ, Ἇ, Ἧ, Ἷ, Ὗ, Ὧ } </p>\n" +
            "<p>2. δασεία βαρεῖα { ἃ, ἓ, ἣ, ἳ, ὃ, ὓ, ὣ, Ἃ, Ἓ, Ἣ, Ἳ, Ὃ, Ὓ, Ὣ } </p>\n" +
            "<p>3. διαλυτικὰ ὀξεῖα { ΐ, ΰ } </p>\n" +
            "<p>4. ὑπογεγραμμένη { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ } </p>\n" +
            "<p>5. βαρεῖα { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ } </p>\n" +
            "<p>6. διαλυτικὰ { ϊ, ϋ, Ϊ, Ϋ } </p>\n" +
            "<p>7. δασεία { ἁ, ἑ, ἡ, ἱ, ὁ, ὑ, ὡ, Ἁ, Ἑ, Ἡ, Ἱ, Ὁ, Ὑ, Ὡ καὶ τὰ ῥ, Ῥ } </p>\n" +
            "<p>8. δασεία ὀξεῖα { ἅ, ἕ, ἥ, ἵ, ὅ, ὕ, ὥ, Ἅ, Ἕ, Ἥ, Ἵ, Ὅ, Ὕ, Ὥ } </p>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        }
        
        else if (!"Greek".equals(myLang)) {         
         
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Keyboard: Greek polytonic </H3> <H3>Modify key <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>First we press the Shift key, and without releasing it we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the Shift key we have the following eight (8) combinations:</p> \n" +
            "<p>1. rough subscript { ἇ, ἧ, ἷ, ὗ, ὧ, Ἇ, Ἧ, Ἷ, Ὗ, Ὧ } </p>\n" +
            "<p>2. rough grave { ἃ, ἓ, ἣ, ἳ, ὃ, ὓ, ὣ, Ἃ, Ἓ, Ἣ, Ἳ, Ὃ, Ὓ, Ὣ } </p>\n" +
            "<p>3. diaeresis accent { ΐ, ΰ } </p>\n" +
            "<p>4. subscript { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ } </p>\n" +
            "<p>5. grave { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ } </p>\n" +
            "<p>6. diaeresis { ϊ, ϋ, Ϊ, Ϋ } </p>\n" +
            "<p>7. rough { ἁ, ἑ, ἡ, ἱ, ὁ, ὑ, ὡ, Ἁ, Ἑ, Ἡ, Ἱ, Ὁ, Ὑ, Ὡ and the ῥ, Ῥ } </p>\n" +
            "<p>8. rough acute { ἅ, ἕ, ἥ, ἵ, ὅ, ὕ, ὥ, Ἅ, Ἕ, Ἥ, Ἵ, Ὅ, Ὕ, Ὥ } </p>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        }
        
        else {
                
        }
        
        which_Button=jButton_Shift_macOS_;
                
    }//GEN-LAST:event_jButton_Shift_macOS_ActionPerformed

    private void jButton_Normal_macOS_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Normal_macOS_ActionPerformed

        icon = new ImageIcon(macos_Normal_icon_path);
        img.setIcon(icon);
        //System.out.println(macos_Normal_icon_path);

        jButton_Normal_macOS_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Normal_macOS_;
        
        if (backup_Button==("")) {
             jButton_Normal_macOS_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("");
        }
 
        if ("Greek".equals(myLang)) { 

            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Χωρὶς πλῆκτρο τροποποίησης</H3>\n" +
            "<p>Πατᾶμε τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὸ πλῆκτρο καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Ἔχουμε τοὺς παρακάτω ἑπτά (7) συνδυασμούς:</p> \n" +
            "<p>1. ψιλὴ περισπωμένη { ἆ, ἦ, ἶ, ὖ, ὦ, Ἆ, Ἦ, Ἶ, Ὦ } </p>  \n" +
            "<p>2. ψιλὴ βαρεῖα { ἂ, ἒ, ἢ, ἲ, ὂ, ὒ, ὢ, Ἂ, Ἒ, Ἢ, Ἲ, Ὂ, Ὢ } </p>  \n" +
            "<p>3. περισπωμένη { ᾶ, ῆ, ῖ, ῦ, ῶ } </p>  \n" +
            "<p>4. βαρεῖα { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ } </p>  \n" +
            "<p>5. τόνος { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } σημείωση: δὲν εἶναι ὀξεῖα </p>  \n" +
            "<p>6. ψιλὴ { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ καὶ τὸ ῤ } </p>  \n" +
            "<p>7. ψιλὴ ὀξεῖα { ἄ, ἔ, ἤ, ἴ, ὄ, ὔ, ὤ, Ἄ, Ἔ, Ἤ, Ἴ, Ὄ, Ὤ } </p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
        
            jText_Help_.setCaretPosition(0);
            
        } 
        
        else if (!"Greek".equals(myLang)) { 
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>macOS</H3> <H3> Keyboard: Greek polytonic </H3> <H3>Without modification key</H3>\n" +
            "<p>We press the dead key we want, then release the key, then select the vowel.</p>\n" +
            "<p>We have the following seven (7) combinations:</p> \n" +
            "<p>1. smooth circumflex { ἆ, ἦ, ἶ, ὖ, ὦ, Ἆ, Ἦ, Ἶ, Ὦ } </p>  \n" +
            "<p>2. smooth grave { ἂ, ἒ, ἢ, ἲ, ὂ, ὒ, ὢ, Ἂ, Ἒ, Ἢ, Ἲ, Ὂ, Ὢ } </p>  \n" +
            "<p>3. circumflex { ᾶ, ῆ, ῖ, ῦ, ῶ } </p>  \n" +
            "<p>4. grave { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ } </p>  \n" +
            "<p>5. accent { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } note: is not accute </p>  \n" +
            "<p>6. smooth { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ and the ῤ } </p>  \n" +
            "<p>7. smooth acute { ἄ, ἔ, ἤ, ἴ, ὄ, ὔ, ὤ, Ἄ, Ἔ, Ἤ, Ἴ, Ὄ, Ὤ } </p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
        
            jText_Help_.setCaretPosition(0);
            
        }    
        
        else {
                
        }            

        which_Button=jButton_Normal_macOS_;
                
    }//GEN-LAST:event_jButton_Normal_macOS_ActionPerformed

    private void jButton_AltGR_Shift_Win_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltGR_Shift_Win_ActionPerformed

        icon = new ImageIcon(win_AltGR_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(win_AltGR_Shift_icon_path);

        jButton_AltGR_Shift_Win_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_AltGR_Shift_Win_;
        
        if (backup_Button==("AltGR+Shift")) {
             jButton_AltGR_Shift_Win_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("AltGR+Shift");
        }

        if ("Greek".equals(myLang)) {    
            
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Πλῆκτρα τροποποίησης <font color=\"red\">[AltGR] </font> καὶ <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὰ πλῆκτρα AltGR καὶ Shift, καὶ χωρὶς νὰ τὰ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὰ πλῆκτρα AltGR καὶ Shift ἔχουμε τοὺς παρακάτω τέσσερις (4) συνδυασμούς:</p> \n" +
            "<p>1. δασεῖα περισπωμένη ὑπογεγραμμένη { ᾇ, ᾗ, ᾧ, ᾏ, ᾟ, ᾯ } </p>  \n" +
            "<p>2. δασεῖα βαρεῖα ὑπογεγραμμένη { ᾃ, ᾓ, ᾣ, ᾋ, ᾛ, ᾫ } </p>  \n" +
            "<p>3. δασεῖα ὑπογεγραμμένη { ᾁ, ᾑ, ᾡ, ᾉ, ᾙ, ᾩ } </p>  \n" +
            "<p>4. δασεῖα ὀξεῖα ὑπογεγραμμένη { ᾅ, ᾕ, ᾥ, ᾍ, ᾝ, ᾭ } </p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        }
        
        else if (!"Greek".equals(myLang)) {    
            
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Keyboard: Greek polytonic </H3> <H3> Modify keys <font color=\"red\">[AltGR] </font> and <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>We first press the AltGR and Shift keys, and without releasing them we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the AltGR and Shift keys we have the following four (4) combinations:</p> \n" +
            "<p>1. rough circumflex subscript { ᾇ, ᾗ, ᾧ, ᾏ, ᾟ, ᾯ } </p>  \n" +
            "<p>2. rough grave subscript { ᾃ, ᾓ, ᾣ, ᾋ, ᾛ, ᾫ } </p>  \n" +
            "<p>3. rough subscript { ᾁ, ᾑ, ᾡ, ᾉ, ᾙ, ᾩ } </p>  \n" +
            "<p>4. rough acute subscript { ᾅ, ᾕ, ᾥ, ᾍ, ᾝ, ᾭ } </p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
            
        }
        
        else {
                
        }        
        
        which_Button=jButton_AltGR_Shift_Win_;
        
    }//GEN-LAST:event_jButton_AltGR_Shift_Win_ActionPerformed

    private void jButton_AltGR_Win_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltGR_Win_ActionPerformed

        icon = new ImageIcon(win_AltGR_icon_path);
        img.setIcon(icon);
        //System.out.println(win_AltGR_icon_path);
        
        jButton_AltGR_Win_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_AltGR_Win_;
        
        if (backup_Button==("AltGR")) {
             jButton_AltGR_Win_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("AltGR");
        }
        
        if ("Greek".equals(myLang)) {    
  
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[AltGR]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὸ πλῆκτρο AltGR, καὶ χωρὶς νὰ τὸ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὸ πλῆκτρο AltGR ἔχουμε τοὺς παρακάτω ἐννιὰ (9) συνδυασμούς:</p> \n" +
            "<p>1. διαλυτικὰ περισπωμένη { ῗ, ῧ }</p> \n" +
            "<p>2. ψιλὴ περισπωμένη ὑπογεγραμμένη { ᾆ, ᾖ, ᾦ, ᾎ, ᾞ, ᾮ } </p> \n" +
            "<p>3. ὀξεῖα ὑπογεγραμμένη { ᾴ, ῄ, ῴ } </p> \n" +
            "<p>4. περισπωμένη ὑπογεγραμμένη { ᾷ, ῇ, ῷ } </p> \n" +
            "<p>5. βαρεῖα ὑπογεγραμμένη { ᾲ, ῂ, ῲ } </p> \n" +
            "<p>6. ψιλὴ βαρεῖα ὑπογεγραμμένη { ᾂ, ᾒ, ᾢ, ᾊ, ᾚ, ᾪ } </p> \n" +
            "<p>7. διαλυτικὰ τόνος { ΐ, ΰ } σημείωση: δὲν εἶναι διαλυτικὰ ὀξεῖα </p>  \n" +
            "<p>8. ψιλὴ ὑπογεγραμμένη { ᾀ, ᾐ, ᾠ, ᾈ, ᾘ, ᾨ } </p> \n" +
            "<p>9. ψιλὴ ὀξεῖα ὑπογεγραμμένη { ᾄ, ᾔ, ᾤ, ᾌ, ᾜ, ᾬ } </p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
            
        }
        
        else if (!"Greek".equals(myLang)) {  
  
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Keyboard: Greek polytonic </H3> <H3> Modify key  <font color=\"red\">[AltGR]</font></H3>\n" +
            "<p>First we press the AltGR key, and without releasing it we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the AltGR key we have the following nine (9) combinations:</p> \n" +
            "<p>1. diaeresis circumflex { ῗ, ῧ }</p> \n" +
            "<p>2. smooth circumflex subscript { ᾆ, ᾖ, ᾦ, ᾎ, ᾞ, ᾮ } </p> \n" +
            "<p>3. acute subscript { ᾴ, ῄ, ῴ } </p> \n" +
            "<p>4. circumflex subscript { ᾷ, ῇ, ῷ } </p> \n" +
            "<p>5. grave subscript { ᾲ, ῂ, ῲ } </p> \n" +
            "<p>6. smooth grave subscript { ᾂ, ᾒ, ᾢ, ᾊ, ᾚ, ᾪ } </p> \n" +
            "<p>7. diaeresis accent { ΐ, ΰ } note: is not diaeresis accute </p>  \n" +
            "<p>8. smooth subscript { ᾀ, ᾐ, ᾠ, ᾈ, ᾘ, ᾨ } </p> \n" +
            "<p>9. smooth acute subscript { ᾄ, ᾔ, ᾤ, ᾌ, ᾜ, ᾬ } </p> \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
            
        }        
        
        else {
                
        }        
        
        which_Button=jButton_AltGR_Win_;
        
    }//GEN-LAST:event_jButton_AltGR_Win_ActionPerformed

    private void jButton_Shift_Win_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Shift_Win_ActionPerformed

        icon = new ImageIcon(win_Shift_icon_path);
        img.setIcon(icon);
        //System.out.println(win_Shift_icon_path);

        jButton_Shift_Win_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Shift_Win_;
      
        if (backup_Button==("Shift")) {
             jButton_Shift_Win_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("Shift");
        }
        
        if ("Greek".equals(myLang)) {
    
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Πλῆκτρο τροποποίησης <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>Πατᾶμε πρῶτα τὸ πλῆκτρο Shift, καὶ χωρὶς νὰ τὸ ἀφήσουμε πατᾶμε καὶ τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὰ πλῆκτρα καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Μὲ τὸ πλῆκτρο Shift ἔχουμε τοὺς παρακάτω ὀκτὼ (8) συνδυασμούς:</p> \n" +
            "<p>1. διαλυτικὰ βαρεῖα { ῒ, ῢ }</p> \n" +
            "<p>2. βραχὺ { ᾰ, ῐ, ῠ, Ᾰ, Ῐ, Ῠ }</p> \n" +
            "<p>3. δασεία περισπωμένη { ἇ, ἧ, ἷ, ὗ, ὧ, Ἇ, Ἧ, Ἷ, Ὗ, Ὧ }</p>\n" +
            "<p>4. ὑπογεγραμμένη  { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ }</p>\n" +
            "<p>5. δασεία βαρεῖα { ἃ, ἓ, ἣ, ἳ, ὃ, ὓ, ὣ, Ἃ, Ἓ, Ἣ, Ἳ, Ὃ, Ὓ, Ὣ }</p> \n" +
            "<p>6. διαλυτικὰ { ϊ, ϋ, Ϊ, Ϋ }</p> \n" +
            "<p>7. δασεία { ἁ, ἑ, ἡ, ἱ, ὁ, ὑ, ὡ, Ἁ, Ἑ, Ἡ, Ἱ, Ὁ, Ὑ, Ὡ καὶ τὰ ῥ, Ῥ }</p> \n" +
            "<p>8. δασεία ὀξεῖα { ἅ, ἕ, ἥ, ἵ, ὅ, ὕ, ὥ, Ἅ, Ἕ, Ἥ, Ἵ, Ὅ, Ὕ, Ὥ }</p>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        }
        
        else if (!"Greek".equals(myLang)) {
            
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Keyboard: Greek polytonic </H3> <H3> Modify key <font color=\"red\">[Shift]</font></H3>\n" +
            "<p>First we press the Shift key, and without releasing it we press the dead key we want, then we release the keys and then we select the vowel.</p>\n" +
            "<p>With the Shift key we have the following eight (8) combinations:</p> \n" +
            "<p>1. diaeresis grave { ῒ, ῢ }</p> \n" +
            "<p>2. breve { ᾰ, ῐ, ῠ, Ᾰ, Ῐ, Ῠ }</p> \n" +
            "<p>3. rough circumflex { ἇ, ἧ, ἷ, ὗ, ὧ, Ἇ, Ἧ, Ἷ, Ὗ, Ὧ }</p>\n" +
            "<p>4. subscript  { ᾳ, ῃ, ῳ, ᾼ, ῌ, ῼ }</p>\n" +
            "<p>5. rough grave { ἃ, ἓ, ἣ, ἳ, ὃ, ὓ, ὣ, Ἃ, Ἓ, Ἣ, Ἳ, Ὃ, Ὓ, Ὣ }</p> \n" +
            "<p>6. diaeresis { ϊ, ϋ, Ϊ, Ϋ }</p> \n" +
            "<p>7. rough { ἁ, ἑ, ἡ, ἱ, ὁ, ὑ, ὡ, Ἁ, Ἑ, Ἡ, Ἱ, Ὁ, Ὑ, Ὡ and the ῥ, Ῥ }</p> \n" +
            "<p>8. rough acute { ἅ, ἕ, ἥ, ἵ, ὅ, ὕ, ὥ, Ἅ, Ἕ, Ἥ, Ἵ, Ὅ, Ὕ, Ὥ }</p>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
            
        }        
        
        else {
                
        }
        
        which_Button=jButton_Shift_Win_;
        
    }//GEN-LAST:event_jButton_Shift_Win_ActionPerformed

    private void jButton_Normal_Win_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Normal_Win_ActionPerformed

        icon = new ImageIcon(win_Normal_icon_path);
        img.setIcon(icon);
        //System.out.println(win_Normal_icon_path);
        
        Color c = Color.yellow;
        
        jButton_Normal_Win_.setBackground(mySelected_Color);
        myColorBtn.setBackground(BG_Color_btn);
        myColorBtn=jButton_Normal_Win_;
        
        
        if (backup_Button==("")) {
            jButton_Normal_Win_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Button=("");
        }
   
        if ("Greek".equals(myLang)) {
        
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Πληκτρολόγιο: Ἑλληνικὰ πολυτονικὰ </H3> <H3>Χωρὶς πλῆκτρο τροποποίησης</H3>\n" +
            "<p>Πατᾶμε τὸ νεκρὸ πλῆκτρο ποὺ θέλουμε, μετὰ ἀφήνουμε τὸ πλῆκτρο καὶ μετὰ ἐπιλέγουμε τὸ φωνῆεν.</p>\n" +
            "<p>Ἔχουμε τοὺς παρακάτω δέκα (10) συνδυασμούς:</p> \n" +
            "<p>1. διαλυτικὰ ὀξεῖα { ΐ, ΰ }</p> \n" +
            "<p>2. μακρὸν { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }</p>  \n" +
            "<p>3. ψιλὴ περισπωμένη { ἆ, ἦ, ἶ, ὖ, ὦ, Ἆ, Ἦ, Ἶ, Ὦ }</p>  \n" +
            "<p>4. ὀξεῖα { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ }</p>  \n" +
            "<p>5. περισπωμένη { ᾶ, ῆ, ῖ, ῦ, ῶ }</p>  \n" +
            "<p>6. βαρεῖα { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ }</p>  \n" +
            "<p>7. ψιλὴ βαρεῖα { ἂ, ἒ, ἢ, ἲ, ὂ, ὒ, ὢ, Ἂ, Ἒ, Ἢ, Ἲ, Ὂ, Ὢ }</p>  \n" +
            "<p>8. τόνος { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } σημείωση: δὲν εἶναι ὀξεῖα </p>  \n" +
            "<p>9. ψιλὴ { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ καὶ τὸ ῤ }</p>  \n" +
            "<p>10. ψιλὴ ὀξεῖα { ἄ, ἔ, ἤ, ἴ, ὄ, ὔ, ὤ, Ἄ, Ἔ, Ἤ, Ἴ, Ὄ, Ὤ }</p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);
        
        }
            
        else if (!"Greek".equals(myLang)) {
                
            jText_Help_.setContentType("text/html");
            jText_Help_.setText("<html><body style=\"background-color:rgb(255,255,235);\"> <H3>MS Windows</H3> <H3> Keyboard: Greek polytonic </H3> <H3>Without modification key</H3>\n" +
            "<p>We press the dead key we want, then release the key, then select the vowel.</p>\n" +
            "<p>We have the following ten (10) combinations:</p> \n" +
            "<p>1. diaeresis acute { ΐ, ΰ }</p> \n" +
            "<p>2. makron { ᾱ, ῑ, ῡ, Ᾱ, Ῑ, Ῡ }</p>  \n" +
            "<p>3. smooth circumflex { ἆ, ἦ, ἶ, ὖ, ὦ, Ἆ, Ἦ, Ἶ, Ὦ }</p>  \n" +
            "<p>4. acute { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ }</p>  \n" +
            "<p>5. circumflex { ᾶ, ῆ, ῖ, ῦ, ῶ }</p>  \n" +
            "<p>6. grave { ὰ, ὲ, ὴ, ὶ, ὸ , ὺ, ὼ, Ὰ, Ὲ, Ὴ, Ὶ, Ὸ, Ὺ, Ὼ }</p>  \n" +
            "<p>7. smooth grave { ἂ, ἒ, ἢ, ἲ, ὂ, ὒ, ὢ, Ἂ, Ἒ, Ἢ, Ἲ, Ὂ, Ὢ }</p>  \n" +
            "<p>8. accent { ά, έ, ή, ί, ό, ύ, ώ, Ά, Έ, Ή, Ί, Ό, Ύ, Ώ } note: is not accute</p>  \n" +
            "<p>9. smooth { ἀ, ἐ, ἠ, ἰ, ὀ, ὐ, ὠ, Ἀ, Ἐ, Ἠ, Ἰ, Ὀ, Ὠ and the ῤ }</p>  \n" +
            "<p>10. smooth acute { ἄ, ἔ, ἤ, ἴ, ὄ, ὔ, ὤ, Ἄ, Ἔ, Ἤ, Ἴ, Ὄ, Ὤ }</p>  \n" +
            "\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>" );
            
            jText_Help_.setCaretPosition(0);                  
        
        }
        
        else {
                
        }
        
        which_Button=jButton_Normal_Win_;
        
    }//GEN-LAST:event_jButton_Normal_Win_ActionPerformed

    private void jButton_Small_Letter_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Small_Letter_ActionPerformed

        if (setMyTextSize>10) {
            setMyTextSize=setMyTextSize-1;

            Font myFontNow = new Font(setMyFont, Font.PLAIN, setMyTextSize);
            jText_Help_.setFont(myFontNow);
            jTextField_Test_.setFont(myFontNow);

            //System.out.println("\n");
            //System.out.println("Γραμματοσειρά: " + setMyFont + "\n"  + "Μέγεθος: " + setMyTextSize);

            jTextField_FontName_.setText(setMyFont);
            jTextField_FontSize_.setText(Integer.toString(setMyTextSize));

        }
        else {

        }

    }//GEN-LAST:event_jButton_Small_Letter_ActionPerformed

    private void jButton_Big_Letter_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Big_Letter_ActionPerformed

        if (setMyTextSize<40) {
            setMyTextSize=setMyTextSize+1;

            Font myFontNow = new Font(setMyFont, Font.PLAIN, setMyTextSize);
            jText_Help_.setFont(myFontNow);
            jTextField_Test_.setFont(myFontNow);

            //System.out.println("\n");
            //System.out.println("Γραμματοσειρά: " + setMyFont + "\n"  + "Μέγεθος: " + setMyTextSize);

            jTextField_FontName_.setText(setMyFont);
            jTextField_FontSize_.setText(Integer.toString(setMyTextSize));

        }
        else {

        }
    }//GEN-LAST:event_jButton_Big_Letter_ActionPerformed

    private void jRadioButton_Gray1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Gray1_ActionPerformed
        
        jPanel2.setBackground(mycolor);
        jPanel3.setBackground(mycolor);
        jPanel4.setBackground(mycolor);
        jRadioButton_White_.setEnabled(true);
        jRadioButton_Gray2_.setEnabled(true);
        jRadioButton_Black_.setEnabled(true);
        
        win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
        win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
        win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_GRAY" + path_color_letter + ".png");   
        win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_GRAY" + path_color_letter + ".png");  
        
        linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_GRAY" + path_color_letter + ".png");  
        linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_GRAY" + path_color_letter + ".png");   
        linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_GRAY" + path_color_letter + ".png");   
        linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_GRAY" + path_color_letter + ".png");  
    
        macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
        macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
        macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_GRAY" + path_color_letter + ".png");   
        macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_GRAY" + path_color_letter + ".png");  
    
        
    }//GEN-LAST:event_jRadioButton_Gray1_ActionPerformed

    private void jRadioButton_Dark_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Dark_ActionPerformed
        
        jPanel2.setBackground(mycolor);
        jPanel3.setBackground(mycolor);
        jPanel4.setBackground(mycolor);
        
        jRadioButton_White_.setEnabled(true);
        jRadioButton_Gray2_.setEnabled(true);
        jRadioButton_Black_.setEnabled(true);   
        
        win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
        win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
        win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_DARK" + path_color_letter + ".png");   
        win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_DARK" + path_color_letter + ".png");  
        
        linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_DARK" + path_color_letter + ".png");  
        linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_DARK" + path_color_letter + ".png");   
        linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_DARK" + path_color_letter + ".png");   
        linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_DARK" + path_color_letter + ".png");  
    
        macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
        macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
        macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_DARK" + path_color_letter + ".png");   
        macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_DARK" + path_color_letter + ".png");  
        
        
        
         
    }//GEN-LAST:event_jRadioButton_Dark_ActionPerformed

    private void jRadioButton_Color_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Color_ActionPerformed
        
        jPanel2.setBackground(mycolorpanel2);
        jPanel3.setBackground(mycolorpanel3);
        jPanel4.setBackground(mycolorpanel4);
        
        jRadioButton_White_.setEnabled(false);
        jRadioButton_Gray2_.setEnabled(false);
        jRadioButton_Black_.setEnabled(false);
            
        win_Normal_icon_path=("./images/win_GR_Polytonic_Normal.png");  
        win_Shift_icon_path=("./images/win_GR_Polytonic_Shift.png");   
        win_AltGR_icon_path=("./images/win_GR_Polytonic_AltGR.png");   
        win_AltGR_Shift_icon_path=("./images/win_GR_Polytonic_AltGR_Shift.png");  
        
        linux_Normal_icon_path=("./images/linux_GR_Normal.png");  
        linux_Shift_icon_path=("./images/linux_GR_Shift.png");   
        linux_Level3_Shift_icon_path=("./images/linux_GR_Level3_Shift.png");   
        linux_Level3_Shift_Shift_icon_path=("./images/linux_GR_Level3_Shift_Shift.png");          
        
        macos_Normal_icon_path=("./images/macos_GR_Polytonic_Normal.png");  
        macos_Shift_icon_path=("./images/macos_GR_Polytonic_Shift.png");   
        macos_Option_icon_path=("./images/macos_GR_Polytonic_Option.png");   
        macos_Option_Shift_icon_path=("./images/macos_GR_Polytonic_Option_Shift.png");          
     
    }//GEN-LAST:event_jRadioButton_Color_ActionPerformed

    private void jRadioButton_Bright_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Bright_ActionPerformed
        
        jPanel2.setBackground(mycolor);
        jPanel3.setBackground(mycolor);
        jPanel4.setBackground(mycolor);
        
        jRadioButton_White_.setEnabled(true);
        jRadioButton_Gray2_.setEnabled(true);
        jRadioButton_Black_.setEnabled(true);
        
        win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
        win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
        win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_BRIGHT" + path_color_letter + ".png");   
        win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_BRIGHT" + path_color_letter + ".png");  
        
        linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_BRIGHT" + path_color_letter + ".png");  
        linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_BRIGHT" + path_color_letter + ".png");   
        linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_BRIGHT" + path_color_letter + ".png");   
        linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_BRIGHT" + path_color_letter + ".png");  
    
        macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
        macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
        macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_BRIGHT" + path_color_letter + ".png");   
        macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_BRIGHT" + path_color_letter + ".png");  
        

    }//GEN-LAST:event_jRadioButton_Bright_ActionPerformed

    private void jRadioButton_White_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_White_ActionPerformed
        
        path_keyb_theme="keyboards_white_tonespirit";
        path_color_letter="_WH";
        
      if (jRadioButton_Bright_.isSelected()){
          //System.out.println("BRIGHT");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_BRIGHT" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_BRIGHT" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_BRIGHT" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_BRIGHT" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_BRIGHT" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_BRIGHT" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_BRIGHT" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_BRIGHT" + path_color_letter + ".png");            
        
         }
      
      if (jRadioButton_Gray1_.isSelected()){
          //System.out.println("GRAY");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_GRAY" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_GRAY" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_GRAY" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_GRAY" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_GRAY" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_GRAY" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_GRAY" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_GRAY" + path_color_letter + ".png");  
         }
         
      if (jRadioButton_Dark_.isSelected()){
          //System.out.println("DARK");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_DARK" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_DARK" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_DARK" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_DARK" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_DARK" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_DARK" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_DARK" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_DARK" + path_color_letter + ".png");  
         } 
        
    }//GEN-LAST:event_jRadioButton_White_ActionPerformed

    private void jRadioButton_Black_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Black_ActionPerformed
        
        path_keyb_theme="keyboards_black_tonespirit";
        path_color_letter="_BL";
        
      if (jRadioButton_Bright_.isSelected()){
          //System.out.println("BRIGHT");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_BRIGHT" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_BRIGHT" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_BRIGHT" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_BRIGHT" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_BRIGHT" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_BRIGHT" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_BRIGHT" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_BRIGHT" + path_color_letter + ".png");  
          
        }
      
      if (jRadioButton_Gray1_.isSelected()){
          //System.out.println("GRAY");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_GRAY" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_GRAY" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_GRAY" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_GRAY" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_GRAY" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_GRAY" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_GRAY" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_GRAY" + path_color_letter + ".png");  
        }
         
      if (jRadioButton_Dark_.isSelected()){
          //System.out.println("DARK");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_DARK" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_DARK" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_DARK" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_DARK" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_DARK" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_DARK" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_DARK" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_DARK" + path_color_letter + ".png");  
        } 
        
    }//GEN-LAST:event_jRadioButton_Black_ActionPerformed

    private void jRadioButton_Gray2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Gray2_ActionPerformed
        
        
        path_keyb_theme="keyboards_gray_tonespirit";
        path_color_letter="_GR";
        
      if (jRadioButton_Bright_.isSelected()){
          //System.out.println("BRIGHT");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_BRIGHT" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_BRIGHT" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_BRIGHT" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_BRIGHT" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_BRIGHT" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_BRIGHT" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_BRIGHT" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_BRIGHT" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_BRIGHT" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_BRIGHT" + path_color_letter + ".png");  
          
        }
      
      if (jRadioButton_Gray1_.isSelected()){
          //System.out.println("GRAY");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_GRAY" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_GRAY" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_GRAY" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_GRAY" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_GRAY" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_GRAY" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_GRAY" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_GRAY" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_GRAY" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_GRAY" + path_color_letter + ".png");  
        }
         
      if (jRadioButton_Dark_.isSelected()){
          //System.out.println("DARK");
          win_Normal_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
          win_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
          win_AltGR_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_DARK" + path_color_letter + ".png");   
          win_AltGR_Shift_icon_path=("./images/" + path_keyb_theme + "/win_GR_Polytonic_AltGR_Shift_DARK" + path_color_letter + ".png");  
          
          linux_Normal_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Normal_DARK" + path_color_letter + ".png");  
          linux_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Shift_DARK" + path_color_letter + ".png");   
          linux_Level3_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_DARK" + path_color_letter + ".png");   
          linux_Level3_Shift_Shift_icon_path=("./images/" + path_keyb_theme + "/linux_GR_Level3_Shift_Shift_DARK" + path_color_letter + ".png");  
          
          macos_Normal_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Normal_DARK" + path_color_letter + ".png");  
          macos_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Shift_DARK" + path_color_letter + ".png");   
          macos_Option_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_DARK" + path_color_letter + ".png");   
          macos_Option_Shift_icon_path=("./images/" + path_keyb_theme + "/macos_GR_Polytonic_Option_Shift_DARK" + path_color_letter + ".png");  
        } 
      
    }//GEN-LAST:event_jRadioButton_Gray2_ActionPerformed

    private void jButton_myColorChooser_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_myColorChooser_ActionPerformed
        
        selectedColor=JColorChooser.showDialog(null, Title_ColorPalette, mySelected_Color);
        
        if (selectedColor==null){
            selectedColor=backupMySelColor;
        }
                
        mySelected_Color=selectedColor;
        backupMySelColor=selectedColor;        
        jButton_myColorChooser_.setBackground(selectedColor);
        jText_Help_.setSelectionColor(selectedColor);
        jTextField_FontName_.setSelectionColor(selectedColor);
        jTextField_FontSize_.setSelectionColor(selectedColor);
        jTextField_Test_.setSelectionColor(selectedColor);        

        which_Button.setBackground(mySelected_Color);
        
        numSCR = selectedColor.getRed();
        numSCG = selectedColor.getGreen();
        numSCB = selectedColor.getBlue();
                
        try {
            FileWriter fwMySelColor = new FileWriter("./settings/myselcolor.set");
            fwMySelColor.write(numSCR + "\n");
            fwMySelColor.write(numSCG + "\n");
            fwMySelColor.write(numSCB + "\n");
            fwMySelColor.close();

            }    
            
        catch (IOException e) {
                    e.printStackTrace();
            }
        
    }//GEN-LAST:event_jButton_myColorChooser_ActionPerformed

    private void jButton_HowDoWeWrite_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HowDoWeWrite_ActionPerformed
        
        How_do_we_write JFrameHow_Write = new How_do_we_write();
        JFrameHow_Write.show();
        
    }//GEN-LAST:event_jButton_HowDoWeWrite_ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keyboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton_AltGR_Shift_Win_;
    private javax.swing.JButton jButton_AltGR_Win_;
    private javax.swing.JButton jButton_Big_Letter_;
    private javax.swing.JButton jButton_HowDoWeWrite_;
    private javax.swing.JButton jButton_Level3_Shift_Linux_;
    private javax.swing.JButton jButton_Level3_Shift_Shift_Linux_;
    private javax.swing.JButton jButton_Normal_Linux_;
    private javax.swing.JButton jButton_Normal_Win_;
    private javax.swing.JButton jButton_Normal_macOS_;
    private javax.swing.JButton jButton_Option_Shift_macOS_;
    private javax.swing.JButton jButton_Option_macOS_;
    private javax.swing.JButton jButton_Shift_Linux_;
    private javax.swing.JButton jButton_Shift_Win_;
    private javax.swing.JButton jButton_Shift_macOS_;
    private javax.swing.JButton jButton_Small_Letter_;
    private javax.swing.JButton jButton_myColorChooser_;
    private javax.swing.JLabel jLabel_AccentSpirit_;
    private javax.swing.JLabel jLabel_Linux_;
    private javax.swing.JLabel jLabel_MS_Windows_;
    private javax.swing.JLabel jLabel_Test_;
    private javax.swing.JLabel jLabel_Theme_;
    private javax.swing.JLabel jLabel_gif_;
    private javax.swing.JLabel jLabel_macOS_;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_Keyboard_;
    private javax.swing.JRadioButton jRadioButton_Black_;
    private javax.swing.JRadioButton jRadioButton_Bright_;
    private javax.swing.JRadioButton jRadioButton_Color_;
    private javax.swing.JRadioButton jRadioButton_Dark_;
    private javax.swing.JRadioButton jRadioButton_Gray1_;
    private javax.swing.JRadioButton jRadioButton_Gray2_;
    private javax.swing.JRadioButton jRadioButton_White_;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_FontName_;
    private javax.swing.JTextField jTextField_FontSize_;
    private javax.swing.JTextField jTextField_Test_;
    private javax.swing.JTextPane jText_Help_;
    // End of variables declaration//GEN-END:variables
}
