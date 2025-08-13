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

import static PolytLex_plus.PolytLex_plus.Editor_or_VirtualKeyboard;
import static PolytLex_plus.PolytLex_plus.choose_Selected_File;
import static PolytLex_plus.PolytLex_plus.flag_insertOpenFileDialog;
import static PolytLex_plus.PolytLex_plus.flag_insertSaveFileDialog;
import static PolytLex_plus.PolytLex_plus.setCurrentFile;
import static PolytLex_plus.PolytLex_plus.flag_Save;
import static PolytLex_plus.PolytLex_plus.flag_newFile;
import static PolytLex_plus.PolytLex_plus.sendmeTheFileName;
import static PolytLex_plus.PolytLex_plus.sendmeTheFileNametypeFile;
import static PolytLex_plus.PolytLex_plus.flag_Question;
import static PolytLex_plus.PolytLex_plus.questionLabel;
import static PolytLex_plus.PolytLex_plus.myFileName;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class Save_File_Dialog extends javax.swing.JDialog {

    /**
     * Creates new form Open_File_Dialog
     */
    
    ImageIcon icon;
    
    int numR=127;
    int numG=127;
    int numB=127;
    Color mycolor =  new Color(numR, numG, numB); 
    
    int BG_Color_btnR;
    int BG_Color_btnG;
    int BG_Color_btnB;
    Color BG_Color_btn = new Color (BG_Color_btnR, BG_Color_btnG, BG_Color_btnB);
    
    int BG_Color_listR;
    int BG_Color_listG;
    int BG_Color_listB;
    Color BG_Color_list = new Color (BG_Color_listR, BG_Color_listG, BG_Color_listB);
    
    int FG_Color_btnR;
    int FG_Color_btnG;
    int FG_Color_btnB;
    Color FG_Color_btn = new Color (FG_Color_btnR, FG_Color_btnG, FG_Color_btnB);
    
    int numSCR;
    int numSCG;
    int numSCB;
    Color mySelColor =  new Color(numSCR, numSCG, numSCB); 
    Color selectedColor;    
    
    int myYellow_NumR=255, myYellow_NumG=225, myYellow_NumB=100;
    Color mySelected_Color =  new Color(myYellow_NumR, myYellow_NumG, myYellow_NumB);    

    String setMyLang="Greek";
    String setMyLangChars="gr" ;
    String pathMyLang="./languages/Greek/save file dialog_gr.lang";
    String myForm="/save file dialog_";
    
    
    int index, i;
    int otherindex;
    int sizeJList=0;
    int setIndexFile=0;
    int counter=-1;
    int selectedIndex=0;
    
    Object item;
    
    File myCurrentFile;
    File mySelectedFile;
    String forPathFolder=("\\mydocuments");
    
  
    File myFileMessageTransfer;
    
    boolean insert_SaveDialog=false;
    
    Icon saveIcon = new ImageIcon("./src/diskette_icon.png");
    
    DefaultListModel myfilelist_Name=new DefaultListModel();
    DefaultListModel myfilelist_Time=new DefaultListModel();
    DefaultListModel myfilelist_Size=new DefaultListModel();
    
    JScrollBar scrollIndexV;
    JScrollBar scrollIndexH;    
    
    private JFileChooser myFileChooser;
    
    public Save_File_Dialog(java.awt.Frame myDialog_SAFILES, boolean modal) {
        
        super(myDialog_SAFILES, modal);
        initComponents();
        
        JFrame.setDefaultLookAndFeelDecorated(true); //for Title and Icon for Linux
        
        Image small_logo = new ImageIcon(this.getClass().getResource("/PolytLexplus_logo_256x256.png")).getImage();
        this.setIconImage(small_logo);
        
        jPanel_Save_Files_.setBackground(Color.yellow);
        setDefaultCloseOperation(Save_File_Dialog.DISPOSE_ON_CLOSE);
        
    }
    
        public Save_File_Dialog(java.awt.Dialog parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        
        JFrame.setDefaultLookAndFeelDecorated(true); //for Title and Icon for Linux
        
        Image small_logo = new ImageIcon(this.getClass().getResource("/PolytLexplus_logo_256x256.png")).getImage();
        this.setIconImage(small_logo);
             
        jPanel_Save_Files_.setBackground(mycolor);
        setDefaultCloseOperation(Save_File_Dialog.DISPOSE_ON_CLOSE);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Save_Files_ = new javax.swing.JPanel();
        jLabel_Path_ = new javax.swing.JLabel();
        jTextField_Path_ = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_FileName_ = new javax.swing.JList<>();
        jButton_Save_ = new javax.swing.JButton();
        jButton_Cancel_ = new javax.swing.JButton();
        jLabel_FileName_ = new javax.swing.JLabel();
        jTextField_Selected_File_ = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_File_DateTime_ = new javax.swing.JList<>();
        jLabel_Name_ = new javax.swing.JLabel();
        jLabel_Date_Time_ = new javax.swing.JLabel();
        jLabel_Size_ = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_FileSize_ = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel_Path_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_Path_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Path_.setText("Διαδρομή:");
        jLabel_Path_.setFocusable(false);
        jLabel_Path_.setPreferredSize(new java.awt.Dimension(140, 35));

        jTextField_Path_.setEditable(false);
        jTextField_Path_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_Path_.setText("/mydocuments");
        jTextField_Path_.setFocusable(false);
        jTextField_Path_.setPreferredSize(new java.awt.Dimension(500, 35));

        jList_FileName_.setBackground(new java.awt.Color(242, 242, 242));
        jList_FileName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList_FileName_.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList_FileName_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_FileName_MouseClicked(evt);
            }
        });
        jList_FileName_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList_FileName_KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jList_FileName_);

        jButton_Save_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Save_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Save_.setText("Ἀποθήκευση");
        jButton_Save_.setFocusable(false);
        jButton_Save_.setPreferredSize(new java.awt.Dimension(140, 35));
        jButton_Save_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Save_ActionPerformed(evt);
            }
        });

        jButton_Cancel_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Cancel_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Cancel_.setText("Ἄκυρο");
        jButton_Cancel_.setFocusable(false);
        jButton_Cancel_.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton_Cancel_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cancel_ActionPerformed(evt);
            }
        });

        jLabel_FileName_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_FileName_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_FileName_.setText("Ὄνομα ἀρχεἰου:");
        jLabel_FileName_.setFocusable(false);
        jLabel_FileName_.setPreferredSize(new java.awt.Dimension(140, 35));

        jTextField_Selected_File_.setBackground(new java.awt.Color(242, 242, 242));
        jTextField_Selected_File_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_Selected_File_.setPreferredSize(new java.awt.Dimension(628, 35));

        jList_File_DateTime_.setBackground(new java.awt.Color(242, 242, 242));
        jList_File_DateTime_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList_File_DateTime_.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList_File_DateTime_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_File_DateTime_MouseClicked(evt);
            }
        });
        jList_File_DateTime_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList_File_DateTime_KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jList_File_DateTime_);

        jLabel_Name_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_Name_.setText("Ὄνομα");
        jLabel_Name_.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel_Date_Time_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_Date_Time_.setText("Ἠμερομηνία τροποποίησης");
        jLabel_Date_Time_.setPreferredSize(new java.awt.Dimension(210, 30));

        jLabel_Size_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_Size_.setText("Μέγεθος");

        jList_FileSize_.setBackground(new java.awt.Color(242, 242, 242));
        jList_FileSize_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList_FileSize_.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList_FileSize_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_FileSize_MouseClicked(evt);
            }
        });
        jList_FileSize_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList_FileSize_KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jList_FileSize_);

        javax.swing.GroupLayout jPanel_Save_Files_Layout = new javax.swing.GroupLayout(jPanel_Save_Files_);
        jPanel_Save_Files_.setLayout(jPanel_Save_Files_Layout);
        jPanel_Save_Files_Layout.setHorizontalGroup(
            jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Save_Files_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Save_Files_Layout.createSequentialGroup()
                        .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jLabel_Name_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel_Date_Time_, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel_Size_, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_Save_Files_Layout.createSequentialGroup()
                            .addComponent(jLabel_Path_, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField_Path_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Save_Files_Layout.createSequentialGroup()
                            .addComponent(jButton_Save_, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jButton_Cancel_, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_Save_Files_Layout.createSequentialGroup()
                            .addComponent(jLabel_FileName_, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField_Selected_File_, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel_Save_Files_Layout.setVerticalGroup(
            jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Save_Files_Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Path_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Path_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Name_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Date_Time_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Size_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_FileName_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Selected_File_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel_Save_Files_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cancel_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Save_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Save_Files_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel_Save_Files_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Save_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Save_ActionPerformed
      
        
        try {
        //System.out.println("??????/");
        mySelectedFile = new File(jTextField_Selected_File_.getText());
        //System.out.println("mySelectedFile: " + mySelectedFile);
        myFileName=(mySelectedFile.toString());
        
        
       
        //System.out.println("myFileName: " + myFileName);
        //System.out.println("");
                
        String baseString = myFileName;
        String subString = ".txt";
        boolean result = baseString.toLowerCase().contains(subString.toLowerCase());
        
        if (result) {
            //System.out.println("Ναί, ἔχει τὴν ἐπέκταση: .txt ");
            mySelectedFile = new File(mySelectedFile.toString());
             //System.out.println("mySelectedFile: " + mySelectedFile);
            ////System.out.println("Το μονοπάτι του mySelectedFile είναι: " + mySelectedFile);
            //System.out.println("");
            //System.out.println("");
            //System.out.println("myFileName: " + myFileName);
            setCurrentFile=myFileName;
            sendmeTheFileName=setCurrentFile;
        }
        else {
            //System.out.println("Ὄχι, δὲν ἔχει τὴν ἐπέκταση: .txt ");
            mySelectedFile = new File(mySelectedFile.toString() + ".txt");
             //System.out.println("mySelectedFile: " + mySelectedFile);
            ////System.out.println("Το μονοπάτι του mySelectedFile είναι: " + mySelectedFile);
            //System.out.println("");
            //System.out.println("");
            myFileName=myFileName + ".txt";
            //System.out.println("myFileName: " + myFileName);
            setCurrentFile=myFileName;         //////+ ".txt";
            sendmeTheFileName=setCurrentFile;
        }
        
        
         //System.out.println("mySelectedFile: " + mySelectedFile);
        
        
            try (FileWriter myFileDocWR = new FileWriter("./mydocuments/" + mySelectedFile);
                BufferedWriter myBufferedWriter = new BufferedWriter(myFileDocWR)) {
                
                // SOS - SOS
                if (Editor_or_VirtualKeyboard==true) {
                    myBufferedWriter.write(Virtual_Keyboard.VKglobal_myTextArea);
                }
                else {
                    myBufferedWriter.write(Editor.EDglobal_myTextArea);
                }
                
                myBufferedWriter.close();
                //System.out.println("Το μονοπάτι του mySelectedFile είναι: " + "./mydocuments/" + mySelectedFile);
                //System.out.println("");
                myCurrentFile=mySelectedFile;
                myFileMessageTransfer= myCurrentFile;
                sendmeTheFileNametypeFile=myFileMessageTransfer;
        
                flag_Save=true;
                flag_insertSaveFileDialog=true;
            }
        
            if (myFileMessageTransfer==null){
                //System.out.println("Δὲν ἐπιλέχτηκε ἀρχεῖο.");
                //System.out.println("");
                //System.out.println("");
            }
            else {
                //System.out.println("Ἐπιλέχτηκε τὸ ἀρχεῖο: " + myFileMessageTransfer);
                //System.out.println("");
                //System.out.println("");
            }
        
        } catch (IOException ex) {
        Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setVisible(false);
        dispose();
        
        
    }//GEN-LAST:event_jButton_Save_ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        File fileBG = new File("./settings/colorbg.set");
        File fileBG_btn = new File("./settings/colorbtn.set");
        File fileFG_btn = new File("./settings/colorlttr.set");
        File fileMyLang = new File ("./settings/mylang.set");
        File fileMySelColor = new File("./settings/myselcolor.set");
        
        setTitle("Ἀποθήκευση ὡς");
        
        long fileLastModifiedDate, sizeFile;
        File myFilePath;
        Path myPath;
        FileTime myFileTime;
        Date date;
 
        scrollIndexV=jScrollPane1.getVerticalScrollBar();
        scrollIndexH=jScrollPane1.getHorizontalScrollBar(); 
        jScrollPane2.setVerticalScrollBar(scrollIndexV);
        jScrollPane2.setHorizontalScrollBar(scrollIndexH);
        jScrollPane3.setVerticalScrollBar(scrollIndexV);
        jScrollPane3.setHorizontalScrollBar(scrollIndexH);        

        try {
            
            Scanner sML = new Scanner(fileMyLang);
            setMyLang=(sML.nextLine());
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
            jPanel_Save_Files_.setBackground(mycolor);
            
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
             
            Scanner sFG_btn = new Scanner(fileFG_btn);
            //System.out.println("Χρώμα γραμμάτων");
            FG_Color_btnR=(sFG_btn.nextInt());
            //System.out.println(FG_Color_btnR);
            FG_Color_btnG=(sFG_btn.nextInt());
            //System.out.println(FG_Color_btnG);
            FG_Color_btnB=(sFG_btn.nextInt());
            //System.out.println(FG_Color_btnB);
            //System.out.println("\n");
            
            BG_Color_btn =new Color(BG_Color_btnR, BG_Color_btnG, BG_Color_btnB);
            BG_Color_list =new Color(BG_Color_listR, BG_Color_listG, BG_Color_listB);
            FG_Color_btn = new Color (FG_Color_btnR, FG_Color_btnG, FG_Color_btnB);
        
            jLabel_Path_.setForeground(FG_Color_btn);
            jTextField_Path_.setForeground(FG_Color_btn);
            jLabel_Name_.setForeground(FG_Color_btn);
            jLabel_Date_Time_.setForeground(FG_Color_btn);
            jLabel_Size_.setForeground(FG_Color_btn);
            jList_FileName_.setForeground(FG_Color_btn);
            jList_File_DateTime_.setForeground(FG_Color_btn);
            jList_FileSize_.setForeground(FG_Color_btn);
            jLabel_FileName_.setForeground(FG_Color_btn);
            jTextField_Selected_File_.setForeground(FG_Color_btn);
            jButton_Save_.setForeground(FG_Color_btn);
            jButton_Cancel_.setForeground(FG_Color_btn);
            
            jLabel_Path_.setBackground(BG_Color_btn);
            jTextField_Path_.setBackground(BG_Color_list);
            jLabel_Name_.setBackground(BG_Color_btn);
            jLabel_Date_Time_.setBackground(BG_Color_btn);
            jLabel_Size_.setBackground(BG_Color_btn);
            jList_FileName_.setBackground(BG_Color_list);
            jList_File_DateTime_.setBackground(BG_Color_list);
            jList_FileSize_.setBackground(BG_Color_list);
            jLabel_FileName_.setBackground(BG_Color_btn);
            jTextField_Selected_File_.setBackground(BG_Color_list);
            jButton_Save_.setBackground(BG_Color_btn);
            jButton_Cancel_.setBackground(BG_Color_btn);
            
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
            
            jList_FileName_.setSelectionBackground(mySelColor);
            jList_File_DateTime_.setSelectionBackground(mySelColor);            
            jList_FileSize_.setSelectionBackground(mySelColor);  
            jTextField_Selected_File_.setSelectionColor(mySelColor);  
            
            
            Scanner spathML = new Scanner(fileSetMyLang);
            
            setMyLang=(spathML.nextLine());
            this.setTitle(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jLabel_Path_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jLabel_Name_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jLabel_Date_Time_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jLabel_Size_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jLabel_FileName_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Save_.setText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Cancel_.setText(setMyLang);

            }
        
        catch (FileNotFoundException ex) {
           
        }
        
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList_FileSize_.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
         
        File myfile = new File("./mydocuments");
     
        String[] files=myfile.list();
        Arrays.sort(files);
        
        for (String stringFile:files) {
        try {
            counter++;
            myfilelist_Name.addElement(stringFile);
            
            myFilePath= new File("./mydocuments/" + stringFile);
            myPath=Paths.get("./mydocuments/" + stringFile);
            fileLastModifiedDate = myFilePath.lastModified(); 
            myFileTime = Files.getLastModifiedTime(myPath);
            date = new Date(fileLastModifiedDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat (" yyyy/MM/dd    hh:mm:ss ");
            String myDate = simpleDateFormat.format(date); 
          
            myfilelist_Time.addElement(myDate);

            sizeFile=convertToKiloBytes(myFilePath);
            myfilelist_Size.addElement(sizeFile + " KB");

            } catch (IOException ex) {
                Logger.getLogger(Open_File_Dialog.class.getName()).log(Level.SEVERE, null, ex);
                
            }
          
            jList_FileName_.setModel(myfilelist_Name);
            jList_File_DateTime_.setModel(myfilelist_Time);
            jList_FileSize_.setModel(myfilelist_Size);
            
        }
        
        sizeJList=myfilelist_Name.getSize();
        
        //System.out.println("\n" + "Τὸ σύνολο τῶν ἀρχεῑων εἶναι: " + String.format("%,d",sizeJList));
        //System.out.println("\n"); 
  
        //System.out.println(FileSystems.getDefault().getPath(new String()).toAbsolutePath() + forPathFolder);
        jTextField_Path_.setText(FileSystems.getDefault().getPath(new String()).toAbsolutePath() + forPathFolder);
       
        if (flag_newFile==true) {
            setCurrentFile="";
            sendmeTheFileName=null;
            mySelectedFile=null;
            flag_newFile=false;
            flag_Save=true;
            flag_insertSaveFileDialog=true;
            myFileName="";
            jTextField_Selected_File_.setText(myFileName);
            return;
        }
        else {
            
        }
        
       if (flag_insertOpenFileDialog==true) {
        
        //System.out.println("");
        //System.out.println("================ From OpenFileDialog ================");
        //System.out.println("choose_Selected_File: " + choose_Selected_File);
        
        jTextField_Selected_File_.setText(choose_Selected_File);
        flag_insertOpenFileDialog=false;
        return;
        
       }
        
       else if (flag_insertOpenFileDialog==false) {
        
            if (insert_SaveDialog==false) {
                //System.out.println("");
                //System.out.println("======= Not from OpenFileDialog ================");
                //System.out.println("setCurrentFile: " + setCurrentFile);
                choose_Selected_File=setCurrentFile;
                //System.out.println("choose_Selected_File: " + choose_Selected_File);
                jTextField_Selected_File_.setText(choose_Selected_File);
                insert_SaveDialog=true;
                return;
            }
            
            else {

            }   
            
        }
           
        else {
               
        }   
      
       if (flag_Question==true){
           jTextField_Selected_File_.setText(questionLabel);
           flag_Question=false;
           return;
           
       }
       else {
           jTextField_Selected_File_.setText("");
       } 

       
        //System.out.println("");
        //System.out.println("");
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton_Cancel_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cancel_ActionPerformed

        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jButton_Cancel_ActionPerformed

    private void jList_FileName_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList_FileName_KeyReleased
        
        if ( evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP )  {
            JList target=(JList)evt.getSource();
            selectedIndex =jList_FileName_.getSelectedIndex();
            jList_File_DateTime_.setSelectedIndex(selectedIndex);
            jList_FileSize_.setSelectedIndex(selectedIndex);

            for (i = 0; i <= selectedIndex; i++) {
                item = target.getModel().getElementAt(selectedIndex);
                setCurrentFile=item.toString();
            }

            jTextField_Selected_File_.setText(setCurrentFile);
               
        }
        
    }//GEN-LAST:event_jList_FileName_KeyReleased

    private void jList_FileName_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_FileName_MouseClicked
        
        if (evt.getClickCount()==1){
            JList target=(JList)evt.getSource();
            index =target.locationToIndex(evt.getPoint());
            jList_File_DateTime_.setSelectedIndex(index);
            jList_FileSize_.setSelectedIndex(index);

            if (index>=0) {
                item = target.getModel().getElementAt(index);
                 setCurrentFile=item.toString();
            }

        jTextField_Selected_File_.setText(setCurrentFile);
     
        }
    }//GEN-LAST:event_jList_FileName_MouseClicked

    private void jList_File_DateTime_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList_File_DateTime_KeyReleased
        
        if ( evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP )  {
            JList target=(JList)evt.getSource();
            selectedIndex =jList_File_DateTime_.getSelectedIndex();
            jList_FileName_.setSelectedIndex(selectedIndex);
            jList_FileSize_.setSelectedIndex(selectedIndex);

            for (i = 0; i <= selectedIndex; i++) {
                item=myfilelist_Name.getElementAt(selectedIndex);    //SOS!!!
                setCurrentFile=item.toString();
            }

            jTextField_Selected_File_.setText(setCurrentFile);
                
        }
        
    }//GEN-LAST:event_jList_File_DateTime_KeyReleased

    private void jList_FileSize_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList_FileSize_KeyReleased
        
        if ( evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP )  {
            JList target=(JList)evt.getSource();
            selectedIndex =jList_FileSize_.getSelectedIndex();
            jList_FileName_.setSelectedIndex(selectedIndex);
            jList_File_DateTime_.setSelectedIndex(selectedIndex);

            for (i = 0; i <= selectedIndex; i++) {
                item=myfilelist_Name.getElementAt(selectedIndex);    //SOS!!!
                setCurrentFile=item.toString();
            }

            jTextField_Selected_File_.setText(setCurrentFile);
                
        } 
                
    }//GEN-LAST:event_jList_FileSize_KeyReleased

    private void jList_File_DateTime_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_File_DateTime_MouseClicked
        
        if (evt.getClickCount()==1){
            JList target=(JList)evt.getSource();
            index =target.locationToIndex(evt.getPoint());
            jList_FileName_.setSelectedIndex(index);
            jList_FileSize_.setSelectedIndex(index);

            if (index>=0) {
                item=myfilelist_Name.getElementAt(index);    //SOS!!!
                setCurrentFile=item.toString();
            }

            jTextField_Selected_File_.setText(setCurrentFile);  
               
        }
                
    }//GEN-LAST:event_jList_File_DateTime_MouseClicked

    private void jList_FileSize_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_FileSize_MouseClicked
        
        if (evt.getClickCount()==1){
            JList target=(JList)evt.getSource();
            index =target.locationToIndex(evt.getPoint());
            jList_FileName_.setSelectedIndex(index);
            jList_File_DateTime_.setSelectedIndex(index);            

            if (index>=0) {
                item=myfilelist_Name.getElementAt(index);    //SOS!!!
                setCurrentFile=item.toString();
            }
            
            jTextField_Selected_File_.setText(setCurrentFile);  
                
        }
        
    }//GEN-LAST:event_jList_FileSize_MouseClicked

    private static long convertToKiloBytes(File file) {
        return file.length() /1024 ;
    }      
    
    
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
            java.util.logging.Logger.getLogger(Save_File_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Save_File_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Save_File_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Save_File_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Save_File_Dialog dialog = new Save_File_Dialog (new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancel_;
    private javax.swing.JButton jButton_Save_;
    private javax.swing.JLabel jLabel_Date_Time_;
    private javax.swing.JLabel jLabel_FileName_;
    private javax.swing.JLabel jLabel_Name_;
    private javax.swing.JLabel jLabel_Path_;
    private javax.swing.JLabel jLabel_Size_;
    private javax.swing.JList<String> jList_FileName_;
    private javax.swing.JList<String> jList_FileSize_;
    private javax.swing.JList<String> jList_File_DateTime_;
    private javax.swing.JPanel jPanel_Save_Files_;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField_Path_;
    private javax.swing.JTextField jTextField_Selected_File_;
    // End of variables declaration//GEN-END:variables
}
