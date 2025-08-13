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

import static PolytLex_plus.Editor.SelectedFontSize;
import static PolytLex_plus.Editor.mySelectedFontSize;
import static PolytLex_plus.PolytLex_plus.Editor_or_VirtualKeyboard;
import static PolytLex_plus.PolytLex_plus.choose_Selected_File;
import static PolytLex_plus.PolytLex_plus.flag_Save;
import static PolytLex_plus.PolytLex_plus.flag_insertSaveFileDialog;
import static PolytLex_plus.PolytLex_plus.flag_newFile;
import static PolytLex_plus.PolytLex_plus.setCurrentFile;
import static PolytLex_plus.PolytLex_plus.myFileName;
import static PolytLex_plus.PolytLex_plus.mySelectedFile;
import static PolytLex_plus.PolytLex_plus.sendmeTheFileNametypeFile;
import static PolytLex_plus.PolytLex_plus.sendmeTheFileName;
import static PolytLex_plus.PolytLex_plus.temp;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;
import java.awt.event.KeyAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;

public class Editor extends javax.swing.JFrame{

    /**
     * Creates new form Editor
     */

    DefaultListModel defaultListModel =new DefaultListModel();
    
    String saveMyWord;
    
    String pathFakelos = ("./data/olatalexika/");
    String pathFakelos_myfiles = ("./mydocuments/"); 
    String pathPG = ("olatalexika_");
    String pathGramma=("ola_ta_grammata.dat");
    String path = (pathFakelos + pathPG + pathGramma); 
    String myΚeimeno;
    
    String sosMessageEn="Ἐνεργοποίηση τῆς λίστας", sosMessageDis="Ἀπενεργοποίηση τῆς λίστας", OriginalVersion="Πρωτότυπη ἔκδοση";
    
    boolean flagJList=true;
    
    int numR=127;
    int numG=127;
    int numB=127;
    Color mycolor =  new Color(numR, numG, numB); 
    
    int BG_Color_btnR;
    int BG_Color_btnG;
    int BG_Color_btnB;
    Color BG_Color_btn = new Color (BG_Color_btnR, BG_Color_btnG, BG_Color_btnB);
    
    int FG_Color_btnR;
    int FG_Color_btnG;
    int FG_Color_btnB;
    Color FG_Color_btn = new Color (FG_Color_btnR, FG_Color_btnG, FG_Color_btnB);    
    
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
    
    int myPastelYellow_NumR=255, myPastelYellow_NumG=255, myPastelYellow_NumB=235;
    Color myPastelYellow_Color =  new Color(myPastelYellow_NumR, myPastelYellow_NumG, myPastelYellow_NumB);    
    
    int b3numR=255, b3numG=255, b3numB=235;  //JList Color: 255,255,235
    Color mybgcolor= new Color (b3numR, b3numG, b3numB); 
    
    int origverbgnumR=255, origverbgnumG=255, origverbgnumB=215;
    Color origverbgcolor= new Color (origverbgnumR, origverbgnumG, origverbgnumB); 
    
    String setMyLang="Greek";
    String setMyLangChars="gr" ;
    String the_prog_lang_is;
    String pathMyLang="./languages/Greek/editor_gr.lang";
    String myForm="/editor_";       

    
    private JFileChooser myFileChooser;
    private File myCurrentFile=null;
    private UndoManager undoManager;
    
    long startTime;
    long TimeIndication1;
    long TimeIndication2;
  
    String backup_Letter=("Α~Ω");
    Boolean space_flag=true;
    

    static String specialchar="";
    static String getKeyChar_fromButton;
    String Title_ColorPalette;
    
    
    ButtonGroup myThemeGroup = new ButtonGroup();

    int sizeJList=0;
    int minusWords=2;
    int caretPosition;
    
    ImageIcon icon;    
    
    
    Font myFont;
    static String mySelectedFont, mySelectedFontSize;
    static int SelectedFontSize;
    
    int indexFont;
    int indexFontSize;
    String oper_system, os, osFont;
    Boolean flag_Bold=false;
   
    Color Color_for_myTextArea;
   
    String mySelectedText;
    String myTextToPaste;
    int myCurrnetPosition;
    
    int   lineNumber, columnNumber;
    boolean flag_Right_Orientation=false;
    boolean flag_Line_Warp=true;
    
    int stringSize;    
    
    public static int check_VK_or_ED=0;
   
    public static String EDglobal_myTextArea;
    
    Icon saveIcon = new ImageIcon("./src/diskette_save_icon.png");
    Icon noSaveIcon = new ImageIcon("./src/diskette_nosave_icon.png");  
    
    
    
    public Editor() throws FileNotFoundException, IOException  {
        
        initComponents();
        JFrame.setDefaultLookAndFeelDecorated(true); //for Title and Icon for Linux
        
        Image small_logo = new ImageIcon(this.getClass().getResource("/PolytLexplus_logo_256x256.png")).getImage();
        this.setIconImage(small_logo);
        
        setDefaultCloseOperation(Editor.DISPOSE_ON_CLOSE);
        
        myFileChooser = new JFileChooser();
        myFileChooser.setCurrentDirectory(new File("./mydocuments"));
        myFileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        
        undoManager = new UndoManager();
        
        this.pleaseBindMyWordsForList();
        
        myTextArea.addKeyListener(new KeyAdapter(){
        
   
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar() == KeyEvent.VK_SPACE ){
            
            ////System.out.println("Πατήθηκε τὸ πλῆκτρο Space.");
            ////System.out.println(temp);
            temp="";
            flag_Save=false;
            jButton_Save_.setIcon(noSaveIcon);             
  
        }
        
        else if (e.getKeyChar() == KeyEvent.VK_TAB ){
            
            ////System.out.println("Πατήθηκε τὸ πλῆκτρο Tab.");
            //System.out.println(temp);
            temp="";
            flag_Save=false;
            jButton_Save_.setIcon(noSaveIcon);             
        
        }
     
        else if (e.getKeyChar()==KeyEvent.VK_ENTER) {
            
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Enter.");
            //System.out.println(temp);
            temp="";
            flag_Save=false;
            jButton_Save_.setIcon(noSaveIcon);              

        }
        
        else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {

        //System.out.println("Πατήθηκε τὸ πλῆκτρο Backspace.");
        stringSize=temp.length()-1;
        //System.out.println("temp=" + temp + "[" + stringSize  + "] χαρακτῆρες.");
        

        
        if (stringSize>=0) {
            temp = temp.substring(0, temp.length() - 1);
        
            try {
                searchFilter(temp);
                //System.out.println("temp=" + temp);
            }
        
            catch (IOException ex) {
                Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else {
            
        }

            flag_Save=false;
            jButton_Save_.setIcon(noSaveIcon);            

       }
        

        else {
            
            if (e.getKeyChar()=='') {    // Is for Ctrl + N)
                //System.out.println("Πατήθηκε τὸ πλῆκτρο: " + "[" + e.getKeyChar() + "]" + " ποῦ ἔχει κωδικό " + (int) e.getKeyChar());
                return;
            }            
            
            if (e.getKeyChar()=='') {    // Is for Ctrl + O)
                //System.out.println("Πατήθηκε τὸ πλῆκτρο: " + "[" + e.getKeyChar() + "]" + " ποῦ ἔχει κωδικό " + (int) e.getKeyChar());
                return;
            }            
            
            if (e.getKeyChar()=='') {    // Is for Ctrl + S)
                //System.out.println("Πατήθηκε τὸ πλῆκτρο: " + "[" + e.getKeyChar() + "]" + " ποῦ ἔχει κωδικό " + (int) e.getKeyChar());
                return;
                
            }
            
            if (e.getKeyChar()=='') {    // Is for Ctrl + B)
                //System.out.println("Πατήθηκε τὸ πλῆκτρο: " + "[" + e.getKeyChar() + "]" + " ποῦ ἔχει κωδικό " + (int) e.getKeyChar());
                return;
                
            }
           
            //System.out.println("Πατήθηκε τὸ πλῆκτρο: " + "[" + e.getKeyChar() + "].");
            
            temp=temp + e.getKeyChar();
            //System.out.println("temp=" + temp);
            flag_Save=false;
            jButton_Save_.setIcon(noSaveIcon);  
            
        }
       
        //System.out.println(temp);
        try {
            searchFilter(temp);
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("temp=" + temp);
        sizeJList=defaultListModel.getSize();

        if (sizeJList==0){
             //System.out.println("Δὲν ὑπάρχουν λέξεις στὸ λεξικό, ποὺ νὰ ταιριάζουν μὲ τὰ γράμματα τῆς λέξης " + "[" + temp + "]" + ".") ;    
        }
        
        else if (sizeJList==1){
             //System.out.println("Ὑπάρχει μία λέξη στὸ λεξικό ποὺ ταιριάζει μὲ τὰ γράμματα τῆς λέξης " + "[" + temp + "]" + ".") ;   
        }
        
        else if (sizeJList>1){
             //System.out.println("Ὑπάρχουν " + sizeJList + " λέξεις στὸ λεξικό ποὺ ταιριάζουν μὲ τὰ γράμματα τῆς λέξης " + "[" + temp + "]" + ".") ;   
        }
        
        else {
        }        
       
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void keyPressed(KeyEvent e) {
        
        int KeyCode=e.getKeyCode();
        
        if ( KeyCode == KeyEvent.VK_UP ){
            
            //System.out.println("");
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Up.");
            temp="";
            try {
                searchFilter(temp);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }            

        } 
        
        else if (KeyCode == KeyEvent.VK_DOWN ){
            
            //System.out.println("");
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Down.");
            temp="";
            try {
                searchFilter(temp);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }            

        } 

        else if (KeyCode == KeyEvent.VK_LEFT ){
            
            //System.out.println("");
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Left.");
            temp="";
            try {
                searchFilter(temp);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } 

        else if (KeyCode == KeyEvent.VK_RIGHT){
            
            //System.out.println("");
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Right.");
            temp="";
            try {
                searchFilter(temp);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }            

        } 

        else if (KeyCode == KeyEvent.VK_HOME){
            
            //System.out.println("");
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Home.");
            temp="";
            try {
                searchFilter(temp);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }            

        }

        else if (KeyCode == KeyEvent.VK_END){
            
            //System.out.println("");
            //System.out.println("Πατήθηκε τὸ πλῆκτρο End.");
            temp="";
            try {
                searchFilter(temp);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }            

        }
   
        else if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ N γιἀ δημιουργία νέου κειμένου.");
            jButton_NewFile_.doClick();
            //System.out.println("");
             
        }           
        
        else if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ O γιὰ ἄνοιγμα ἄρχείου.");
            jButton_OpenFile_ED_.doClick();
            //System.out.println("");
             
        } 
        
        else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ S γιὰ ἀποθήκευση.");
            jButton_Save_.doClick();
            //System.out.println("");
              
        }   
        
        else if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ B γιὰ ἔντονη γραμματοσειρά.");
            jButton_Font_Bold_.doClick();
            //System.out.println("");
              
        }  
        
        else if ((e.getKeyCode() == KeyEvent.VK_EQUALS) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ = γιὰ τὴ μεγένθυση τοῦ κειμένου.");
            jButton_Zoom_Increase_.doClick();
            //System.out.println("");
              
        }  
        
        else if ((e.getKeyCode() == KeyEvent.VK_ADD) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ + γιὰ τὴ μεγένθυση τοῦ κειμένου.");
            jButton_Zoom_Increase_.doClick();
            //System.out.println("");
              
        }        

        else if ((e.getKeyCode() == KeyEvent.VK_MINUS) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ - γιὰ τὴ σμίκρυνση τοῦ κειμένου.");
            jButton_Zoom_Decrease_.doClick();
            //System.out.println("");
              
        }  

        else if ((e.getKeyCode() == KeyEvent.VK_SUBTRACT) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ - γιὰ τὴ σμίκρυνση τοῦ κειμένου.");
            jButton_Zoom_Decrease_.doClick();
            //System.out.println("");        
        
        }
        
        else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ 0 γιὰ ἐπαναφορὰ τοῦ ζούμ.");
            jButton_Zoom_Restore_.doClick();
            //System.out.println("");
              
        }          

        else if ((e.getKeyCode() == KeyEvent.VK_NUMPAD0) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            //System.out.println("");
            //System.out.println("Πατήθηκαν τὰ πλῆκτρα Control καὶ 0 γιὰ ἐπαναφορὰ τοῦ ζούμ.");
            jButton_Zoom_Restore_.doClick();
            //System.out.println("");
              
        }         
        
        else {
        
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

   
    public void keyReleased(KeyEvent e) {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }        
            
            
    });
        
        addWindowListener( new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            
            EDglobal_myTextArea=myTextArea.getText();
            
            JFrame myEditor = (JFrame)e.getSource();
            
            if (flag_Save==true){

                setDefaultCloseOperation(Editor.DISPOSE_ON_CLOSE);
                setVisible(false);
                dispose();
                
                setCurrentFile="";
                choose_Selected_File="";
                myCurrentFile=null;
                    
                //System.out.println("");
                //System.out.println (" === Was flag_Save -> true === ");
                //System.out.println("");
                
                return;
            
            }
            
            else if (flag_Save==false){
                
                Editor_or_VirtualKeyboard=false;
                
                //System.out.println("\n");
                //System.out.println("Ἐπιλέχτηκε ὁ Συντάκτης κειμένου: " + "( " + Editor_or_VirtualKeyboard + " )" );
                //System.out.println("\n");
                
                setDefaultCloseOperation(Editor.DISPOSE_ON_CLOSE);
                Question_for_Save_File myDialog_Save = new Question_for_Save_File(myEditor, true);
                myDialog_Save.setVisible(true);
            
                if (check_VK_or_ED==1){
                    setVisible(false);
                    dispose();
                    
                    check_VK_or_ED=0;
                    setCurrentFile="";
                    choose_Selected_File="";
                    myCurrentFile=null;
                    myFileName="";
                    
                    //System.out.println("");
                    //System.out.println (" === Was flag_Save -> false === ");
                    //System.out.println("");
                    
                    return;
                }
                else {
                    setDefaultCloseOperation(Editor.DO_NOTHING_ON_CLOSE);
                    setCurrentFile="";
                    choose_Selected_File="";
                    myFileName="";
                    myCurrentFile=null;
                    
                    //System.out.println("");
                    //System.out.println (" === else === ");
                    //System.out.println("");
                    
                }
                
            }
            
            }
        });
       
    }
    
    public Editor (File myMessage) {
        
        initComponents();
        mySelectedFile=(myMessage);
     
    }
    
    class CustomComboBoxRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
         JLabel lbl = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected,  cellHasFocus);
         lbl.setBackground(BG_Color_btn);
         lbl.setForeground(FG_Color_btn);
         return lbl;
         
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Editor_ = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myJList = new javax.swing.JList<>();
        jButton_NewFile_ = new javax.swing.JButton();
        jButton_OpenFile_ED_ = new javax.swing.JButton();
        jButton_Save_ = new javax.swing.JButton();
        jButton_SaveAs_ = new javax.swing.JButton();
        jButton_Copy_ = new javax.swing.JButton();
        jButton_Paste_ = new javax.swing.JButton();
        jButton_Undo_ = new javax.swing.JButton();
        jButton_Redo_ = new javax.swing.JButton();
        jComboBox_SystemFonts_ = new javax.swing.JComboBox<>();
        jButton_Font_Increase_ = new javax.swing.JButton();
        jButton_Font_Decrease_ = new javax.swing.JButton();
        jComboBox_FontSize_ = new javax.swing.JComboBox<>();
        jButton_Enable_JList_ = new javax.swing.JButton();
        jButton_Original_Ver_ = new javax.swing.JButton();
        jButton_myColorChooser_ = new javax.swing.JButton();
        jButton_Font_Bold_ = new javax.swing.JButton();
        jButton_RightAlignment_ = new javax.swing.JButton();
        jButton_Zoom_Increase_ = new javax.swing.JButton();
        jButton_Zoom_Decrease_ = new javax.swing.JButton();
        jButton_LeftAlignment_ = new javax.swing.JButton();
        jCheckBox_List_ = new javax.swing.JCheckBox();
        jButton_Zoom_Restore_ = new javax.swing.JButton();
        jButton_Cut_ = new javax.swing.JButton();
        jButton_BackgroundColor_ = new javax.swing.JButton();
        jButton_ForegroundColor_ = new javax.swing.JButton();
        jButton_Black_White_ = new javax.swing.JButton();
        jRadioButton_Theme_ = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myTextArea = new javax.swing.JTextArea();
        jButton_Text_Warp_ = new javax.swing.JButton();
        jLabel_LinePosition_ = new javax.swing.JLabel();
        jTextField_LinePosition_ = new javax.swing.JTextField();
        jLabel_ColumnPosition_ = new javax.swing.JLabel();
        jTextField_ColumnPosition_ = new javax.swing.JTextField();
        jLabel_CaretPosition_ = new javax.swing.JLabel();
        jTextField_CaretPosition_ = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Συντάκτης κειμένου");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_Editor_.setPreferredSize(new java.awt.Dimension(1372, 878));

        jScrollPane1.setBackground(new java.awt.Color(242, 242, 242));

        myJList.setBackground(new java.awt.Color(255, 255, 235));
        myJList.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        myJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myJList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(myJList);

        jButton_NewFile_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_NewFile_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon.png"))); // NOI18N
        jButton_NewFile_.setToolTipText("Νέο");
        jButton_NewFile_.setFocusable(false);
        jButton_NewFile_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_NewFile_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NewFile_ActionPerformed(evt);
            }
        });

        jButton_OpenFile_ED_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_OpenFile_ED_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open_icon.png"))); // NOI18N
        jButton_OpenFile_ED_.setToolTipText("Ἄνοιγμα");
        jButton_OpenFile_ED_.setFocusable(false);
        jButton_OpenFile_ED_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_OpenFile_ED_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpenFile_ED_ActionPerformed(evt);
            }
        });

        jButton_Save_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Save_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diskette_save_icon.png"))); // NOI18N
        jButton_Save_.setToolTipText("Ἀποθήκευση");
        jButton_Save_.setFocusable(false);
        jButton_Save_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Save_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Save_ActionPerformed(evt);
            }
        });

        jButton_SaveAs_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_SaveAs_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diskette_saveas_icon.png"))); // NOI18N
        jButton_SaveAs_.setToolTipText("Ἀποθήκευση ὡς");
        jButton_SaveAs_.setFocusable(false);
        jButton_SaveAs_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_SaveAs_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveAs_ActionPerformed(evt);
            }
        });

        jButton_Copy_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Copy_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copy_icon.png"))); // NOI18N
        jButton_Copy_.setToolTipText("Ἀντιγραφὴ");
        jButton_Copy_.setFocusable(false);
        jButton_Copy_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Copy_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Copy_ActionPerformed(evt);
            }
        });

        jButton_Paste_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Paste_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paste_icon.png"))); // NOI18N
        jButton_Paste_.setToolTipText("Ἐπικόλληση");
        jButton_Paste_.setFocusable(false);
        jButton_Paste_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Paste_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Paste_ActionPerformed(evt);
            }
        });

        jButton_Undo_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Undo_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undo_icon.png"))); // NOI18N
        jButton_Undo_.setToolTipText("Ἀναίρεση");
        jButton_Undo_.setFocusable(false);
        jButton_Undo_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Undo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Undo_ActionPerformed(evt);
            }
        });

        jButton_Redo_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Redo_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redo_icon.png"))); // NOI18N
        jButton_Redo_.setToolTipText("Ἐπαναφορὰ");
        jButton_Redo_.setFocusable(false);
        jButton_Redo_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Redo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Redo_ActionPerformed(evt);
            }
        });

        jComboBox_SystemFonts_.setBackground(new java.awt.Color(242, 242, 242));
        jComboBox_SystemFonts_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_SystemFonts_.setMaximumRowCount(25);
        jComboBox_SystemFonts_.setToolTipText("Γραμματοσειρὰ");
        jComboBox_SystemFonts_.setPreferredSize(new java.awt.Dimension(230, 40));
        jComboBox_SystemFonts_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SystemFonts_ActionPerformed(evt);
            }
        });

        jButton_Font_Increase_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Font_Increase_.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton_Font_Increase_.setText("A");
        jButton_Font_Increase_.setToolTipText("Αὔξηση μεγέθους γραμματοσειρᾶς");
        jButton_Font_Increase_.setFocusable(false);
        jButton_Font_Increase_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Font_Increase_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Font_Increase_ActionPerformed(evt);
            }
        });

        jButton_Font_Decrease_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Font_Decrease_.setText("A");
        jButton_Font_Decrease_.setToolTipText("Μείωση μεγέθους γραμματοσειρᾶς");
        jButton_Font_Decrease_.setFocusable(false);
        jButton_Font_Decrease_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Font_Decrease_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Font_Decrease_ActionPerformed(evt);
            }
        });

        jComboBox_FontSize_.setBackground(new java.awt.Color(242, 242, 242));
        jComboBox_FontSize_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_FontSize_.setMaximumRowCount(25);
        jComboBox_FontSize_.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "32", "40", "48", "56", "72", "80" }));
        jComboBox_FontSize_.setToolTipText("Μέγεθος γραμματοσειρᾶς");
        jComboBox_FontSize_.setPreferredSize(new java.awt.Dimension(70, 40));
        jComboBox_FontSize_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FontSize_ActionPerformed(evt);
            }
        });

        jButton_Enable_JList_.setBackground(new java.awt.Color(0, 255, 0));
        jButton_Enable_JList_.setToolTipText("Ἀπενεργοποίηση τῆς λίστας");
        jButton_Enable_JList_.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton_Enable_JList_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Enable_JList_ActionPerformed(evt);
            }
        });

        jButton_Original_Ver_.setBackground(new java.awt.Color(255, 255, 215));
        jButton_Original_Ver_.setToolTipText("Πρωτότυπη ἔκδοση");
        jButton_Original_Ver_.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton_Original_Ver_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Original_Ver_ActionPerformed(evt);
            }
        });

        jButton_myColorChooser_.setBackground(new java.awt.Color(255, 255, 100));
        jButton_myColorChooser_.setToolTipText("Χρῶμα ἐπιλογῆς");
        jButton_myColorChooser_.setPreferredSize(new java.awt.Dimension(20, 20));
        jButton_myColorChooser_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_myColorChooser_ActionPerformed(evt);
            }
        });

        jButton_Font_Bold_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Font_Bold_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Font_Bold_.setText("B");
        jButton_Font_Bold_.setToolTipText("Ἔντονη γραμματοσειρὰ");
        jButton_Font_Bold_.setFocusable(false);
        jButton_Font_Bold_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Font_Bold_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Font_Bold_ActionPerformed(evt);
            }
        });

        jButton_RightAlignment_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_RightAlignment_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_RightAlignment_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/right_alignment_icon.png"))); // NOI18N
        jButton_RightAlignment_.setToolTipText("Δεξιὰ στοίχηση");
        jButton_RightAlignment_.setFocusable(false);
        jButton_RightAlignment_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_RightAlignment_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RightAlignment_ActionPerformed(evt);
            }
        });

        jButton_Zoom_Increase_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Zoom_Increase_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Zoom_Increase_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zoom_in_icon.png"))); // NOI18N
        jButton_Zoom_Increase_.setToolTipText("Μεγένθυση");
        jButton_Zoom_Increase_.setFocusable(false);
        jButton_Zoom_Increase_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Zoom_Increase_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Zoom_Increase_ActionPerformed(evt);
            }
        });

        jButton_Zoom_Decrease_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Zoom_Decrease_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Zoom_Decrease_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zoom_out_icon.png"))); // NOI18N
        jButton_Zoom_Decrease_.setToolTipText("Σμίκρυνση");
        jButton_Zoom_Decrease_.setFocusable(false);
        jButton_Zoom_Decrease_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Zoom_Decrease_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Zoom_Decrease_ActionPerformed(evt);
            }
        });

        jButton_LeftAlignment_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_LeftAlignment_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_LeftAlignment_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left_alignment_icon.png"))); // NOI18N
        jButton_LeftAlignment_.setToolTipText("Ἀριστερὴ στοίχηση");
        jButton_LeftAlignment_.setFocusable(false);
        jButton_LeftAlignment_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_LeftAlignment_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LeftAlignment_ActionPerformed(evt);
            }
        });

        jCheckBox_List_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox_List_.setText("Λίστα");
        jCheckBox_List_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_List_ActionPerformed(evt);
            }
        });

        jButton_Zoom_Restore_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Zoom_Restore_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zoom_icon.png"))); // NOI18N
        jButton_Zoom_Restore_.setToolTipText("Χωρὶς μεγένθυση ἢ σμίκρυνση");
        jButton_Zoom_Restore_.setFocusable(false);
        jButton_Zoom_Restore_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Zoom_Restore_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Zoom_Restore_ActionPerformed(evt);
            }
        });

        jButton_Cut_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Cut_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scissors_icon.png"))); // NOI18N
        jButton_Cut_.setToolTipText("Ἀποκοπὴ");
        jButton_Cut_.setFocusable(false);
        jButton_Cut_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Cut_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cut_ActionPerformed(evt);
            }
        });

        jButton_BackgroundColor_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_BackgroundColor_.setToolTipText("Χρῶμα φόντου.");
        jButton_BackgroundColor_.setFocusable(false);
        jButton_BackgroundColor_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_BackgroundColor_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackgroundColor_ActionPerformed(evt);
            }
        });

        jButton_ForegroundColor_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_ForegroundColor_.setToolTipText("Χρῶμα χαρακτήρων");
        jButton_ForegroundColor_.setFocusable(false);
        jButton_ForegroundColor_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_ForegroundColor_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ForegroundColor_ActionPerformed(evt);
            }
        });

        jButton_Black_White_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Black_White_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black_white_icon.png"))); // NOI18N
        jButton_Black_White_.setToolTipText("Ἀσπρόμαυρο");
        jButton_Black_White_.setFocusable(false);
        jButton_Black_White_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Black_White_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Black_White_ActionPerformed(evt);
            }
        });

        jRadioButton_Theme_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton_Theme_.setText("Θέμα");
        jRadioButton_Theme_.setFocusable(false);
        jRadioButton_Theme_.setPreferredSize(new java.awt.Dimension(100, 20));
        jRadioButton_Theme_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Theme_ActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(242, 242, 242));

        myTextArea.setBackground(new java.awt.Color(255, 255, 235));
        myTextArea.setColumns(20);
        myTextArea.setRows(5);
        myTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTextAreaMouseClicked(evt);
            }
        });
        myTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                myTextAreaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(myTextArea);

        jButton_Text_Warp_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_Text_Warp_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/text-wrap_icon.png"))); // NOI18N
        jButton_Text_Warp_.setToolTipText("Ἀναδίπλωση κειμένου");
        jButton_Text_Warp_.setFocusable(false);
        jButton_Text_Warp_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_Text_Warp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Text_Warp_ActionPerformed(evt);
            }
        });

        jLabel_LinePosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_LinePosition_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_LinePosition_.setText("Γραμμή:");
        jLabel_LinePosition_.setFocusable(false);
        jLabel_LinePosition_.setPreferredSize(new java.awt.Dimension(64, 30));

        jTextField_LinePosition_.setEditable(false);
        jTextField_LinePosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_LinePosition_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_LinePosition_.setFocusable(false);
        jTextField_LinePosition_.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel_ColumnPosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_ColumnPosition_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_ColumnPosition_.setText("Στήλη:");
        jLabel_ColumnPosition_.setFocusable(false);
        jLabel_ColumnPosition_.setPreferredSize(new java.awt.Dimension(54, 30));

        jTextField_ColumnPosition_.setEditable(false);
        jTextField_ColumnPosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_ColumnPosition_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_ColumnPosition_.setFocusable(false);
        jTextField_ColumnPosition_.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel_CaretPosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_CaretPosition_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_CaretPosition_.setText("Θέση:");
        jLabel_CaretPosition_.setFocusable(false);
        jLabel_CaretPosition_.setPreferredSize(new java.awt.Dimension(52, 30));

        jTextField_CaretPosition_.setEditable(false);
        jTextField_CaretPosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_CaretPosition_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_CaretPosition_.setFocusable(false);
        jTextField_CaretPosition_.setPreferredSize(new java.awt.Dimension(60, 30));

        javax.swing.GroupLayout jPanel_Editor_Layout = new javax.swing.GroupLayout(jPanel_Editor_);
        jPanel_Editor_.setLayout(jPanel_Editor_Layout);
        jPanel_Editor_Layout.setHorizontalGroup(
            jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                        .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_SystemFonts_, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jButton_NewFile_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_OpenFile_ED_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Save_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_SaveAs_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Copy_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Paste_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox_FontSize_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jButton_Cut_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Undo_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jButton_Redo_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_LeftAlignment_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_RightAlignment_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Text_Warp_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jButton_Font_Increase_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Font_Decrease_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Font_Bold_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_BackgroundColor_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jButton_Zoom_Increase_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Zoom_Restore_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Zoom_Decrease_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jButton_ForegroundColor_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Black_White_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jRadioButton_Theme_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_LinePosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_LinePosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_ColumnPosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_ColumnPosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel_CaretPosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_CaretPosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                        .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                                .addComponent(jCheckBox_List_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_myColorChooser_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Original_Ver_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Enable_JList_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel_Editor_Layout.setVerticalGroup(
            jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Editor_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_RightAlignment_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Zoom_Increase_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Zoom_Decrease_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_LeftAlignment_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Zoom_Restore_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NewFile_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cut_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_OpenFile_ED_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Save_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_SaveAs_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Copy_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Paste_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Undo_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Redo_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Text_Warp_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Font_Decrease_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ColumnPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_FontSize_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ColumnPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_CaretPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_CaretPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Font_Bold_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_BackgroundColor_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ForegroundColor_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Black_White_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_Theme_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_SystemFonts_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_LinePosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Font_Increase_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_LinePosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Editor_Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel_Editor_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Enable_JList_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Original_Ver_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_myColorChooser_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox_List_)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Editor_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Editor_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<String> pleaseGetMyWords() throws FileNotFoundException, IOException{
    
        ArrayList <String> words = new ArrayList<>();
        
        startTime = System.currentTimeMillis();   
       
        try ( //Ἀνάγνωση ὁλόκληρης τῆς γραμμῆς ὡς συμβολοσειρά.
        //Φόρτωση δεδομένων ἀπὸ τὸ ἀρχεῖο.
         BufferedReader myBufferedReader = new BufferedReader(new FileReader(path)) //default is 8K = 8192
            ) {
        
        String line = myBufferedReader.readLine();
            //Ἔλεγχος γιὰ τὸ τέλος τοῦ ἀρχείου.
            while (line != null) {
                words.add(line);
                line = myBufferedReader.readLine();
            }
           
        //Κλείσιμο τοῦ ἀντικειμένου bufferreader.
        myBufferedReader.close();
        
        }
        
        //System.out.println(" ");
        TimeIndication1=System.currentTimeMillis() - startTime;
        //System.out.println("Χρόνος φόρτωσης τοῦ λεξικοῦ  = " + (TimeIndication1) + " ms"); 
        
        return words;
        
    }
    
    private void pleaseBindMyWordsForList() throws FileNotFoundException{
        try {
            pleaseGetMyWords().stream().forEach((myword)->{
            defaultListModel.addElement(myword);
            });
        }
        catch (IOException ex) {
            Logger.getLogger(PolytLex_plus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        myJList.setModel(defaultListModel);
        myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
              
    }
 
      
    private void searchFilter (String searchWord) throws FileNotFoundException, IOException{
      
        //System.out.println(pathFakelos);
        //System.out.println(pathGramma);
        //System.out.println(pathFakelos + pathPG + pathGramma);
        
        DefaultListModel filteredItems=new DefaultListModel();
        List<String> lexwords=pleaseGetMyWords();
        lexwords.stream().forEach((myword)->{
            String wordName=myword.toLowerCase();
            
            if  (wordName.contains(searchWord.toLowerCase())) {
                
                filteredItems.addElement(myword);
            }
        }
        );
        
        defaultListModel=filteredItems;  
        myJList.setModel(defaultListModel);
                
    }  
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
            Editor_or_VirtualKeyboard=false;
            
            //System.out.println("\n");
            //System.out.println("Ἐπιλέχτηκε ὁ Συντάκτης κειμένου: " + "( " + Editor_or_VirtualKeyboard + " )" );
            //System.out.println("\n");
            
            myTextArea.setLineWrap(true);
            myTextArea.setWrapStyleWord(true);
 
            sendmeTheFileName="";
            sendmeTheFileNametypeFile=null;
            myCurrentFile=null;
            setCurrentFile="";
            myFileName="";
            choose_Selected_File="";
            mySelectedFile=null;
            flag_newFile=false;
            flag_Save=true;
            flag_insertSaveFileDialog=true;
            
            jButton_LeftAlignment_.setBackground(mySelected_Color);
            
            mySelectedFontSize="14";
            SelectedFontSize=14;

        
            File fileBG = new File("./settings/colorbg.set");
            File fileBG_btn = new File("./settings/colorbtn.set");
            File fileFG_btn = new File("./settings/colorlttr.set");
            File fileMyLang = new File ("./settings/mylang.set");            
            File fileMySelColor = new File("./settings/myselcolor.set");
            
            myTextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
                @Override
                public void undoableEditHappened(UndoableEditEvent e) {
                    undoManager.addEdit(e.getEdit());
                    
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            });            
            
            
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
            jPanel_Editor_.setBackground(mycolor);
            
            Scanner sBG_btn = new Scanner(fileBG_btn);
            //System.out.println("Χρώμα κουμπιών");
            BG_Color_btnR=(sBG_btn.nextInt());
            //System.out.println(BG_Color_btnR);
            BG_Color_btnG=(sBG_btn.nextInt());
            //System.out.println(BG_Color_btnG);
            BG_Color_btnB=(sBG_btn.nextInt());
            //System.out.println(BG_Color_btnB);
            //System.out.println("");
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
            FG_Color_btn = new Color (FG_Color_btnR, FG_Color_btnG, FG_Color_btnB);
            
            myJList.setBackground(BG_Color_list);
            myJList.setForeground(FG_Color_btn);
            myJList.setSelectionBackground(mySelected_Color);
            
            myTextArea.setBackground(BG_Color_list);
            myTextArea.setForeground(FG_Color_btn);
           
            jButton_NewFile_.setBackground(BG_Color_btn);
            jButton_OpenFile_ED_.setBackground(BG_Color_btn);
            jButton_Save_.setBackground(BG_Color_btn);
            jButton_SaveAs_.setBackground(BG_Color_btn);
            jButton_Copy_.setBackground(BG_Color_btn);
            jButton_Paste_.setBackground(BG_Color_btn);
            jButton_Cut_.setBackground(BG_Color_btn);            
            jButton_Undo_.setBackground(BG_Color_btn);
            jButton_Redo_.setBackground(BG_Color_btn);
            jComboBox_SystemFonts_.setBackground(BG_Color_btn);
            jComboBox_FontSize_.setBackground(BG_Color_btn);
            jButton_Font_Increase_.setBackground(BG_Color_btn);
            jButton_Font_Decrease_.setBackground(BG_Color_btn);
            jButton_Font_Bold_.setBackground(BG_Color_btn);
            jButton_RightAlignment_.setBackground(BG_Color_btn);
            jButton_Zoom_Increase_.setBackground(BG_Color_btn);
            jButton_Zoom_Restore_.setBackground(BG_Color_btn);
            jButton_Zoom_Decrease_.setBackground(BG_Color_btn);
            jCheckBox_List_.setBackground(BG_Color_btn);
            jButton_ForegroundColor_.setBackground(FG_Color_btn);   
            jButton_BackgroundColor_.setBackground(BG_Color_btn);
            jButton_Black_White_.setBackground(BG_Color_btn);
            jLabel_LinePosition_.setBackground(BG_Color_btn);
            jTextField_LinePosition_.setBackground(BG_Color_btn);
            jLabel_ColumnPosition_.setBackground(BG_Color_btn);
            jTextField_ColumnPosition_.setBackground(BG_Color_btn);
            jLabel_CaretPosition_.setBackground(BG_Color_btn);
            jTextField_CaretPosition_.setBackground(BG_Color_btn);
            
            jButton_NewFile_.setForeground(FG_Color_btn);
            jButton_OpenFile_ED_.setForeground(FG_Color_btn);
            jButton_Save_.setForeground(FG_Color_btn);
            jButton_SaveAs_.setForeground(FG_Color_btn);
            jButton_Copy_.setForeground(FG_Color_btn);
            jButton_Paste_.setForeground(FG_Color_btn);
            jButton_Undo_.setForeground(FG_Color_btn);
            jButton_Redo_.setForeground(FG_Color_btn);      
            jComboBox_SystemFonts_.setForeground(FG_Color_btn);      
            jComboBox_FontSize_.setForeground(FG_Color_btn);      
            jButton_Font_Increase_.setForeground(FG_Color_btn);      
            jButton_Font_Decrease_.setForeground(FG_Color_btn); 
            jButton_Font_Bold_.setForeground(FG_Color_btn);
            jButton_Zoom_Increase_.setForeground(FG_Color_btn);
            jButton_Zoom_Decrease_.setForeground(FG_Color_btn);
            jCheckBox_List_.setForeground(FG_Color_btn);      
            jLabel_LinePosition_.setForeground(FG_Color_btn);
            jTextField_LinePosition_.setForeground(FG_Color_btn);
            jLabel_ColumnPosition_.setForeground(FG_Color_btn);
            jTextField_ColumnPosition_.setForeground(FG_Color_btn);
            jLabel_CaretPosition_.setForeground(FG_Color_btn);
            jTextField_CaretPosition_.setForeground(FG_Color_btn);
            
            jComboBox_SystemFonts_.setBackground(BG_Color_btn);
            jComboBox_SystemFonts_.setForeground(FG_Color_btn);     
            jComboBox_SystemFonts_.setRenderer(new Editor.CustomComboBoxRenderer());
            
            jComboBox_FontSize_.setBackground(BG_Color_btn);
            jComboBox_FontSize_.setForeground(FG_Color_btn);     
            jComboBox_FontSize_.setRenderer(new Editor.CustomComboBoxRenderer());            
            
            jButton_Enable_JList_.setToolTipText(sosMessageDis);
            jButton_Original_Ver_.setToolTipText(OriginalVersion);
            
            Scanner spathML = new Scanner(fileSetMyLang);
            
            setMyLang=(spathML.nextLine());
            this.setTitle(setMyLang);
            the_prog_lang_is=setMyLang;
            
            setMyLang=(spathML.nextLine());
            jButton_NewFile_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_OpenFile_ED_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Save_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());            
            jButton_SaveAs_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Copy_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Paste_.setToolTipText(setMyLang);   
            
            setMyLang=(spathML.nextLine());
            jButton_Cut_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Undo_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Redo_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_LeftAlignment_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_RightAlignment_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Text_Warp_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Zoom_Increase_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Zoom_Restore_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Zoom_Decrease_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jComboBox_SystemFonts_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jComboBox_FontSize_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Font_Increase_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Font_Decrease_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_Font_Bold_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jButton_BackgroundColor_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jButton_ForegroundColor_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jButton_Black_White_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            jRadioButton_Theme_.setText(setMyLang);

            setMyLang=(spathML.nextLine());
            jLabel_LinePosition_.setText(setMyLang);

            setMyLang=(spathML.nextLine());
            jLabel_ColumnPosition_.setText(setMyLang);

            setMyLang=(spathML.nextLine());
            jLabel_CaretPosition_.setText(setMyLang);

            setMyLang=(spathML.nextLine());
            jCheckBox_List_.setText(setMyLang);

            setMyLang=(spathML.nextLine());
            jButton_myColorChooser_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            Title_ColorPalette=setMyLang;            

            setMyLang=(spathML.nextLine());
            jButton_Original_Ver_.setToolTipText(setMyLang);

            setMyLang=(spathML.nextLine());
            sosMessageEn=setMyLang;
            jButton_Enable_JList_.setToolTipText(sosMessageEn);
            
            setMyLang=(spathML.nextLine());
            sosMessageDis=setMyLang;
            jButton_Enable_JList_.setToolTipText(sosMessageDis);
        
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
            myJList.setSelectionBackground(mySelColor);
            jButton_LeftAlignment_.setBackground(mySelColor);
            jButton_Text_Warp_.setBackground(mySelColor);
            myTextArea.setSelectionColor(mySelected_Color);
            
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        myThemeGroup.add(jRadioButton_Theme_);
        jRadioButton_Theme_.setSelected(true);
        jRadioButton_Theme_.setForeground(FG_Color_btn);
        
        //System.out.println("");
        //System.out.println("Your OS name -> " + System.getProperty("os.name"));
        oper_system=System.getProperty("os.name");
        //Operating system version
        //System.out.println("Your OS version -> " + System.getProperty("os.version"));

        //Operating system architecture
        //System.out.println("Your OS Architecture -> " + System.getProperty("os.arch"));
        
        os = oper_system.toLowerCase();
	if((os.indexOf("win") >= 0)){
            //System.out.println("Τὸ Λειτουργικὸ Σύστημα εἶναι Windows!");
            osFont="Times New Roman";
        }
        else if ((os.indexOf("lin") >= 0)){
            //System.out.println("Τὸ Λειτουργικὸ Σύστημα εἶναι Linux!");
            osFont="Noto Sans";
        }
        
        else if ((os.indexOf("mac") >= 0)){
            //System.out.println("Τὸ Λειτουργικὸ Σύστημα εἶναι MacOS!");
            osFont="Times New Roman";
        }
        
        //System.out.println("");
        
        DefaultListModel myfonts=new DefaultListModel();
        //System.out.println("Γιὰ νὰ γνωρίζετε τὰ διαθέσιμα ὀνόματα οἰκογενειῶν γραμματοσειρῶν"); 
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
  
        //System.out.println("Ἐμφάνιση τῶν ὀνομάτων οἰκογενειῶν γραμματοσειρῶν \n"); 
  
        // Array of all the fonts available in AWT 
        String fonts[] = ge.getAvailableFontFamilyNames(); 
        
        int j=0;
        for (String i : fonts) {
            
            myfonts.addElement(i);
            //System.out.println(j + ": " + i); 
            jComboBox_SystemFonts_.addItem(i);
            if (osFont.equals(i)) {
                indexFont=jComboBox_SystemFonts_.getItemCount();
                //System.out.println("Ἡ γραμματοσειρὰ " + osFont + " εἶναι ἐδώ στὴ θἐση: " + (indexFont-1));
                mySelectedFont=jComboBox_SystemFonts_.getSelectedItem().toString(); 
            }
            j++;
        }
        
        mySelectedFont=osFont;
        Font myFont = new Font(mySelectedFont, Font.PLAIN, SelectedFontSize);
        //System.out.println(mySelectedFont + " " + SelectedFontSize);
        jComboBox_SystemFonts_.setSelectedIndex(indexFont-1);
        myTextArea.setFont(myFont);
        
        for (j=0; j < jComboBox_FontSize_.getItemCount(); j++) {
            //System.out.println(j + " " + jComboBox_FontSize_.getItemAt(j));
            if ("14".equals(jComboBox_FontSize_.getItemAt(j))) {
                indexFontSize=j;
                //System.out.println("Τὸ μέγεθος 14 τῆς γραμματοσειράς εἶναι ἐδώ στὴ θέση: " + indexFontSize);
            }
        }
        
        jComboBox_FontSize_.setSelectedIndex(indexFontSize);
            
    }//GEN-LAST:event_formWindowOpened

    private void jButton_SaveAs_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveAs_ActionPerformed

        Editor_or_VirtualKeyboard=false;
        
        EDglobal_myTextArea=myTextArea.getText();        

        //System.out.println("");
        //System.out.println("<< Save as >>");
        //System.out.println("\n");
        //System.out.println("Ἐπιλέχτηκε ὁ Συντάκτης κειμένου: " + "( " + Editor_or_VirtualKeyboard + " )" );
        //System.out.println("\n"); 
        
        Save_File_Dialog myDialog_Save = new Save_File_Dialog(this, true);
        myDialog_Save.setVisible(true);
        
        if (flag_Save==true) {
            jButton_Save_.setIcon(saveIcon);
        }          
        
        //System.out.println("sendmeTheFileName_typeFile: " + sendmeTheFileNametypeFile);
        //System.out.println("myCurrentFile: " + myCurrentFile);
        //System.out.println("");
        //System.out.println("");
        
        myCurrentFile=sendmeTheFileNametypeFile;
        //System.out.println("myCurrentFile: " + myCurrentFile);
        setCurrentFile=myCurrentFile.toString();
        //System.out.println("setCurrentFile: " + setCurrentFile);
        //System.out.println("");
        //System.out.println("");
        setTitle(the_prog_lang_is + ": " + myCurrentFile.getName());
          
    }//GEN-LAST:event_jButton_SaveAs_ActionPerformed

    private void jButton_OpenFile_ED_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpenFile_ED_ActionPerformed
       
        Open_File_Dialog myDialog_OpenFile = new Open_File_Dialog(this, true);
        myDialog_OpenFile.setVisible(true);
                   
        //System.out.println("sendmeTheFileNametypeFile: " + sendmeTheFileNametypeFile);
        
        if (sendmeTheFileNametypeFile==null) {
            //System.out.println("Δὲν ἐπιλέχτηκε ἀρχεῖο.");
            return;
        }        
         
        myCurrentFile=sendmeTheFileNametypeFile;
        setCurrentFile=myCurrentFile.toString();
        sendmeTheFileNametypeFile=null;        
        
        try {
 
            setTitle( the_prog_lang_is + ": " + myCurrentFile.getName());
        
            FileReader myFileReader = new FileReader(pathFakelos_myfiles + myCurrentFile);
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);
        
            StringBuilder myFileText = new StringBuilder();
            String readMyText;
            
            while ((readMyText =  myBufferedReader.readLine()) !=  null){
                myFileText.append(readMyText + "\n");
            
            }
        
            myTextArea.setText(myFileText.toString());
            myTextArea.setCaretPosition(0);
            
            flag_Save=true;
            jButton_Save_.setIcon(saveIcon);
            flag_insertSaveFileDialog=true;

            temp="";
            searchFilter(temp);            
            
            display_positions();
       }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }
       
    }//GEN-LAST:event_jButton_OpenFile_ED_ActionPerformed

    private void jButton_Enable_JList_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Enable_JList_ActionPerformed
        
               
        if (flagJList==true){
        myJList.setEnabled(false);
        flagJList=false;
        jButton_Enable_JList_.setBackground(Color.RED);
        jButton_Enable_JList_.setToolTipText(sosMessageEn);
        }
        
        else {
        myJList.setEnabled(true);
        flagJList=true;
        jButton_Enable_JList_.setBackground(Color.GREEN);
        jButton_Enable_JList_.setToolTipText(sosMessageDis);
        }
        
    }//GEN-LAST:event_jButton_Enable_JList_ActionPerformed

    private void jButton_Original_Ver_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Original_Ver_ActionPerformed
        
        myJList.setEnabled(false);
        jButton_Enable_JList_.setBackground(Color.RED);
        flagJList=false;
        jButton_Enable_JList_.setToolTipText(sosMessageEn );
        jButton_Original_Ver_.setToolTipText(OriginalVersion);
        jButton_Original_Ver_.setBackground(origverbgcolor);
        
        myJList.setBackground(mybgcolor);
        myJList.setForeground(Color.BLACK);
        
    }//GEN-LAST:event_jButton_Original_Ver_ActionPerformed

    private void jButton_Save_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Save_ActionPerformed
        
        Editor_or_VirtualKeyboard=false;

        //System.out.println("");
        //System.out.println("<< Save >>");
        //System.out.println("\n");
        //System.out.println("Ἐπιλέχτηκε ὁ Συντάκτης κειμένου: " + "( " + Editor_or_VirtualKeyboard + " )" );
        //System.out.println("\n");
        
        //System.out.println("myCurrentFile: " + myCurrentFile);
        //System.out.println("sendmeTheFileName: " + sendmeTheFileName);
        //System.out.println("setCurrentFile: " + setCurrentFile);
        //System.out.println("");
        //System.out.println("");
        
        if (myCurrentFile==null) {
            jButton_SaveAs_.doClick();

            if (flag_Save==true) {
                jButton_Save_.setIcon(saveIcon);
            }
            
        return;            
        }
        
        if (myCurrentFile==null) {
            flag_Save=false;
            
        return;
        }
        
        try {
                
                FileWriter myFileDocWR = new FileWriter("./mydocuments/" + myCurrentFile); 
               
                BufferedWriter myBufferedWriter = new BufferedWriter(myFileDocWR);
                myBufferedWriter.write(myTextArea.getText());
                myBufferedWriter.close();
                //System.out.println("Το μονοπάτι του myCurrentFile είναι: " + "./mydocuments/" + myCurrentFile);
                //System.out.println("");
                flag_Save=true;
                jButton_Save_.setIcon(saveIcon);
                
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        
    }//GEN-LAST:event_jButton_Save_ActionPerformed

    private void jButton_NewFile_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NewFile_ActionPerformed

        setTitle(the_prog_lang_is);
        myTextArea.setText("");
        myCurrentFile=null;
        flag_Save=true;
        jButton_Save_.setIcon(saveIcon);        
        sendmeTheFileName=null;
        flag_newFile=true;
        myFileName="";

        try {
            
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }        
        
    }//GEN-LAST:event_jButton_NewFile_ActionPerformed

    private void jButton_myColorChooser_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_myColorChooser_ActionPerformed
        
        selectedColor=JColorChooser.showDialog(null, Title_ColorPalette, mySelected_Color);
        
        if (selectedColor==null){
            selectedColor=backupMySelColor;
        }
        
        mySelected_Color=selectedColor;
        backupMySelColor=selectedColor;
        jButton_myColorChooser_.setBackground(selectedColor);
        myJList.setSelectionBackground(mySelected_Color);
        myTextArea.setSelectionColor(mySelected_Color);
        
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
        
        
        if (flag_Bold==true){ 
           jButton_Font_Bold_.setBackground(mySelected_Color); 
        }
        else {
            
        }
        
        if (flag_Right_Orientation==false){
            jButton_LeftAlignment_.setBackground(mySelected_Color);
        }
        else {
            jButton_RightAlignment_.setBackground(mySelected_Color);
        }
        
        if (flag_Line_Warp==true) {
            jButton_Text_Warp_.setBackground(mySelected_Color);
        }
        else {
            return;
        }
        
    }//GEN-LAST:event_jButton_myColorChooser_ActionPerformed

    private void jButton_Undo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Undo_ActionPerformed
        
        if (undoManager.canUndo()){
            undoManager.undo();
        }
        
    }//GEN-LAST:event_jButton_Undo_ActionPerformed

    private void jButton_Redo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Redo_ActionPerformed
        
        if (undoManager.canRedo()){
            undoManager.redo();
        }
    }//GEN-LAST:event_jButton_Redo_ActionPerformed

    private void jComboBox_SystemFonts_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SystemFonts_ActionPerformed
       
       mySelectedFont=jComboBox_SystemFonts_.getSelectedItem().toString();
       //System.out.println(mySelectedFont + " " + SelectedFontSize);
       
        if (flag_Bold==false){
                myFont = new Font(mySelectedFont, Font.PLAIN, SelectedFontSize);
        }
        else {
                myFont = new Font(mySelectedFont, Font.BOLD, SelectedFontSize);
        }
       
        myTextArea.setFont(myFont);
       
        if (jCheckBox_List_.isSelected()){
           myJList.setFont(myFont);
        }
        else {
           return;
        }
       
    }//GEN-LAST:event_jComboBox_SystemFonts_ActionPerformed

    private void jComboBox_FontSize_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FontSize_ActionPerformed
            
       mySelectedFontSize=jComboBox_FontSize_.getSelectedItem().toString();
       SelectedFontSize=Integer.parseInt(mySelectedFontSize);
       //System.out.println(mySelectedFont + " " + SelectedFontSize);
       
        if (flag_Bold==false){
                myFont = new Font(mySelectedFont, Font.PLAIN, SelectedFontSize);
        }
        else {
                myFont = new Font(mySelectedFont, Font.BOLD, SelectedFontSize);
        }
       
       myTextArea.setFont(myFont);
       
        if (jCheckBox_List_.isSelected()){
           myJList.setFont(myFont);
        }
        else {
           return;
        }
        
    }//GEN-LAST:event_jComboBox_FontSize_ActionPerformed

    private void jButton_Font_Increase_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Font_Increase_ActionPerformed
       
       if (SelectedFontSize<80) {
            SelectedFontSize=SelectedFontSize+1;
            jComboBox_FontSize_.setEditable(true);
            jComboBox_FontSize_.setSelectedItem(String.valueOf(SelectedFontSize));
            //System.out.println(mySelectedFont + " " + SelectedFontSize);
            
            if (flag_Bold==false){
                myFont = new Font(mySelectedFont, Font.PLAIN, SelectedFontSize);
            }
            else {
                myFont = new Font(mySelectedFont, Font.BOLD, SelectedFontSize);
            }
            
            jComboBox_FontSize_.setEditable(false);
            myTextArea.setFont(myFont);
       }
       
       else {
           return;
       }
       
    }//GEN-LAST:event_jButton_Font_Increase_ActionPerformed

    private void jButton_Font_Decrease_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Font_Decrease_ActionPerformed
        
       if (SelectedFontSize>1) {
            SelectedFontSize=SelectedFontSize-1;
            jComboBox_FontSize_.setEditable(true);
            jComboBox_FontSize_.setSelectedItem(String.valueOf(SelectedFontSize));
            //System.out.println(mySelectedFont + " " + SelectedFontSize);
            
            if (flag_Bold==false){
                myFont = new Font(mySelectedFont, Font.PLAIN, SelectedFontSize);
            }
            else {
                myFont = new Font(mySelectedFont, Font.BOLD, SelectedFontSize);
            }
            
            jComboBox_FontSize_.setEditable(false);
            myTextArea.setFont(myFont);
       }
       
       else {
           return;
       } 
       
    }//GEN-LAST:event_jButton_Font_Decrease_ActionPerformed

    private void jButton_Zoom_Decrease_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zoom_Decrease_ActionPerformed

        Font currentFont=myTextArea.getFont();
        myTextArea.setFont(new Font(
        currentFont.getName(), 
        currentFont.getStyle(), 
        currentFont.getSize()-1));  
        
    }//GEN-LAST:event_jButton_Zoom_Decrease_ActionPerformed

    private void jButton_Zoom_Increase_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zoom_Increase_ActionPerformed

        Font currentFont=myTextArea.getFont();
        myTextArea.setFont(new Font(
        currentFont.getName(), 
        currentFont.getStyle(), 
        currentFont.getSize()+1));
        
    }//GEN-LAST:event_jButton_Zoom_Increase_ActionPerformed

    private void jCheckBox_List_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_List_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_List_ActionPerformed

    private void jButton_Font_Bold_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Font_Bold_ActionPerformed
        
        if (flag_Bold==false){
        myFont = new Font(mySelectedFont, Font.BOLD, SelectedFontSize);
        jButton_Font_Bold_.setBackground(mySelected_Color);
        flag_Bold=true;
        }
        
        else {
        myFont = new Font(mySelectedFont, Font.PLAIN, SelectedFontSize);
        jButton_Font_Bold_.setBackground(BG_Color_btn);
        flag_Bold=false;   
        }
       
        myTextArea.setFont(myFont);
        
        if (jCheckBox_List_.isSelected()){
           myJList.setFont(myFont);
        }
        else {
           return;
        }
        
    }//GEN-LAST:event_jButton_Font_Bold_ActionPerformed

    private void jButton_LeftAlignment_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LeftAlignment_ActionPerformed
        
        myTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jButton_LeftAlignment_.setBackground(mySelected_Color);
        jButton_RightAlignment_.setBackground(BG_Color_btn);
        flag_Right_Orientation=false;
        
    }//GEN-LAST:event_jButton_LeftAlignment_ActionPerformed

    private void jButton_RightAlignment_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RightAlignment_ActionPerformed
       
        myTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jButton_RightAlignment_.setBackground(mySelected_Color);
        jButton_LeftAlignment_.setBackground(BG_Color_btn);
        flag_Right_Orientation=true;
        
    }//GEN-LAST:event_jButton_RightAlignment_ActionPerformed

    private void jButton_Black_White_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Black_White_ActionPerformed
        
        myTextArea.setForeground(Color.black);
        myTextArea.setBackground(Color.white);
        jButton_ForegroundColor_.setBackground(Color.black);   
        jButton_BackgroundColor_.setBackground(Color.white);
        
    }//GEN-LAST:event_jButton_Black_White_ActionPerformed

    private void jButton_BackgroundColor_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackgroundColor_ActionPerformed
        
        Color_for_myTextArea=JColorChooser.showDialog(null, "Παλέτα χρωμάτων", mySelected_Color);
        if (Color_for_myTextArea==null){
            Color_for_myTextArea=(Color.white);
        }
        jButton_BackgroundColor_.setBackground(Color_for_myTextArea);
        myTextArea.setBackground(Color_for_myTextArea);
        
    }//GEN-LAST:event_jButton_BackgroundColor_ActionPerformed

    private void jButton_ForegroundColor_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ForegroundColor_ActionPerformed
        
        Color_for_myTextArea=JColorChooser.showDialog(null, "Παλέτα χρωμάτων", mySelected_Color);
        
        if (Color_for_myTextArea==null){
            Color_for_myTextArea=(Color.black);
        }
        jButton_ForegroundColor_.setBackground(Color_for_myTextArea);
        myTextArea.setForeground(Color_for_myTextArea);
        myTextArea.setCaretColor(Color_for_myTextArea);
        
    }//GEN-LAST:event_jButton_ForegroundColor_ActionPerformed

    private void jRadioButton_Theme_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Theme_ActionPerformed
        
        myJList.setBackground(BG_Color_list);
        myJList.setForeground(FG_Color_btn);
        
        jButton_ForegroundColor_.setBackground(FG_Color_btn);   
        jButton_BackgroundColor_.setBackground(BG_Color_btn);
        
        myTextArea.setBackground(BG_Color_list);
        myTextArea.setForeground(FG_Color_btn);
        
    }//GEN-LAST:event_jRadioButton_Theme_ActionPerformed

    private void jButton_Copy_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Copy_ActionPerformed
        
        mySelectedText = myTextArea.getSelectedText();
            if (mySelectedText != null) {
            return;
            }
                
    }//GEN-LAST:event_jButton_Copy_ActionPerformed

    private void jButton_Paste_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Paste_ActionPerformed
       
        myCurrnetPosition= myTextArea.getCaretPosition();
        myTextToPaste=mySelectedText;
        myTextArea.insert(myTextToPaste, myCurrnetPosition);
        
    }//GEN-LAST:event_jButton_Paste_ActionPerformed

    private void jButton_Cut_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cut_ActionPerformed
        
        mySelectedText = myTextArea.getSelectedText();
            if (mySelectedText != null) {
            myTextArea.cut();
            }
    }//GEN-LAST:event_jButton_Cut_ActionPerformed

    private void jButton_Zoom_Restore_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zoom_Restore_ActionPerformed

        Font currentFont=myTextArea.getFont();
        myTextArea.setFont(new Font(
        currentFont.getName(), 
        currentFont.getStyle(), 
        SelectedFontSize));
        
    }//GEN-LAST:event_jButton_Zoom_Restore_ActionPerformed

    private void myTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTextAreaMouseClicked
        
        temp="";
        display_positions ();
        
    }//GEN-LAST:event_myTextAreaMouseClicked

    private void jButton_Text_Warp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Text_Warp_ActionPerformed
        
        
        if (flag_Line_Warp==true) {
            myTextArea.setLineWrap(false);
            flag_Line_Warp=false;
            jButton_Text_Warp_.setBackground(BG_Color_btn);
        
        }
        else {
            myTextArea.setLineWrap(true);
            flag_Line_Warp=true;
            jButton_Text_Warp_.setBackground(mySelected_Color);
        }
        
    }//GEN-LAST:event_jButton_Text_Warp_ActionPerformed

    private void myTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myTextAreaKeyReleased
        
        display_positions ();
        
    }//GEN-LAST:event_myTextAreaKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, InterruptedException, InvocationTargetException {
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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Editor().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

        
        private void display_positions () {
        
        caretPosition = myTextArea.getCaretPosition();
        jTextField_CaretPosition_.setText(Integer.toString(myTextArea.getCaretPosition()));
        
        try {
        lineNumber = myTextArea.getLineOfOffset(caretPosition);
       
        columnNumber = caretPosition - myTextArea.getLineStartOffset(lineNumber);
        lineNumber += 1;
        
        //System.out.println("Γραμμή: " + lineNumber + "  " + "Στήλη: " + columnNumber);
        }
        catch (BadLocationException ex) {
            Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTextField_LinePosition_.setText(Integer.toString(lineNumber));
        jTextField_ColumnPosition_.setText(Integer.toString(columnNumber));
        
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BackgroundColor_;
    private javax.swing.JButton jButton_Black_White_;
    private javax.swing.JButton jButton_Copy_;
    private javax.swing.JButton jButton_Cut_;
    private javax.swing.JButton jButton_Enable_JList_;
    private javax.swing.JButton jButton_Font_Bold_;
    private javax.swing.JButton jButton_Font_Decrease_;
    private javax.swing.JButton jButton_Font_Increase_;
    private javax.swing.JButton jButton_ForegroundColor_;
    private javax.swing.JButton jButton_LeftAlignment_;
    private javax.swing.JButton jButton_NewFile_;
    private javax.swing.JButton jButton_OpenFile_ED_;
    private javax.swing.JButton jButton_Original_Ver_;
    private javax.swing.JButton jButton_Paste_;
    private javax.swing.JButton jButton_Redo_;
    private javax.swing.JButton jButton_RightAlignment_;
    private javax.swing.JButton jButton_SaveAs_;
    private javax.swing.JButton jButton_Save_;
    private javax.swing.JButton jButton_Text_Warp_;
    private javax.swing.JButton jButton_Undo_;
    private javax.swing.JButton jButton_Zoom_Decrease_;
    private javax.swing.JButton jButton_Zoom_Increase_;
    private javax.swing.JButton jButton_Zoom_Restore_;
    private javax.swing.JButton jButton_myColorChooser_;
    private javax.swing.JCheckBox jCheckBox_List_;
    private javax.swing.JComboBox<String> jComboBox_FontSize_;
    private javax.swing.JComboBox<String> jComboBox_SystemFonts_;
    private javax.swing.JLabel jLabel_CaretPosition_;
    private javax.swing.JLabel jLabel_ColumnPosition_;
    private javax.swing.JLabel jLabel_LinePosition_;
    private javax.swing.JPanel jPanel_Editor_;
    private javax.swing.JRadioButton jRadioButton_Theme_;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_CaretPosition_;
    private javax.swing.JTextField jTextField_ColumnPosition_;
    private javax.swing.JTextField jTextField_LinePosition_;
    private javax.swing.JList<String> myJList;
    private javax.swing.JTextArea myTextArea;
    // End of variables declaration//GEN-END:variables

 
}
