/*
 * The MIT License
 *
 * * Copyright 2025 Μαρέτσικος Χρῆστος.
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

import static PolytLex_plus.PolytLex_plus.temp;
import static PolytLex_plus.PolytLex_plus.Editor_or_VirtualKeyboard;
import static PolytLex_plus.PolytLex_plus.choose_Selected_File;
import static PolytLex_plus.PolytLex_plus.flag_Save;
import static PolytLex_plus.PolytLex_plus.flag_insertSaveFileDialog;
import static PolytLex_plus.PolytLex_plus.flag_newFile;
import static PolytLex_plus.PolytLex_plus.setCurrentFile;
import static PolytLex_plus.PolytLex_plus.myCurrentFile;
import static PolytLex_plus.PolytLex_plus.myFileName;
import static PolytLex_plus.PolytLex_plus.mySelectedFile;
import static PolytLex_plus.PolytLex_plus.sendmeTheFileNametypeFile;
import static PolytLex_plus.PolytLex_plus.sendmeTheFileName;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
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
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.text.BadLocationException;

public class Virtual_Keyboard extends javax.swing.JFrame implements DocumentListener {

    /**
     * Creates new form Virtual_Keyboard
     */
    
    DefaultListModel defaultListModel =new DefaultListModel();

    String pathFakelos = ("./data/olatalexika/");
    String pathFakelos_myfiles = ("./mydocuments/"); 
    String pathPG = ("olatalexika_");
    String pathGramma=("ola_ta_grammata.dat");
    String path = (pathFakelos + pathPG + pathGramma); 
  
    
    String sosMessageEn="Ἐνεργοποίηση τῆς λίστας", sosMessageDis="Ἀπενεργοποίηση τῆς λίστας", OriginalVersion="Πρωτότυπη ἔκδοση";
   
    JButton myColorBtn = new JButton(" ");
    
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
    
    String setMyLang="Greek";
    String setMyLangChars="gr" ;
    String the_prog_lang_is;    
    String pathMyLang="./languages/Greek/virtual keyboard_gr.lang";
    String myForm="/virtual keyboard_";     
    
    boolean flagJList=true;
    boolean flag_caps=false;
    boolean flag_shift=false;
    boolean flag_lang=true;
    boolean flag_altGR=false;
    
    ButtonGroup myThemeGroup = new ButtonGroup();
    
    int sizeJList=0;
    int caretPosition;
    
    ImageIcon icon;
    
    int myYellow_NumR=255, myYellow_NumG=225, myYellow_NumB=100;
    Color mySelected_Color =  new Color(myYellow_NumR, myYellow_NumG, myYellow_NumB);
    
    Color selectedColor;
    
    int myPastelYellow_NumR=255, myPastelYellow_NumG=255, myPastelYellow_NumB=235;
    Color myPastelmySelected_Color =  new Color(myPastelYellow_NumR, myPastelYellow_NumG, myPastelYellow_NumB);   
    
    int myPastelGreen_NumR=204, myPastelGreen_NumG=255, myPastelGreen_NumB=204;
    Color myPastelGreen_Color  =  new Color(myPastelGreen_NumR, myPastelGreen_NumG, myPastelGreen_NumB);   
    
    int myBlue_NumR=153, myBlue_NumG=204, myBlue_NumB=255;
    Color myBlue_Color =  new Color(myBlue_NumR, myBlue_NumG, myBlue_NumB);
    
    int myCyan_NumR=0, myCyan_NumG=225, myCyan_NumB=255;
    Color myCyan_Color =  new Color(myCyan_NumR, myCyan_NumG, myCyan_NumB);
    
    int myGreen_NumR=51, myGreen_NumG=255, myGreen_NumB=204;
    Color myGreen_Color =  new Color(myGreen_NumR, myGreen_NumG, myGreen_NumB);
    
    int myRed_NumR=255, myRed_NumG=102, myRed_NumB=102;
    Color myRed_Color =  new Color(myRed_NumR, myRed_NumG, myRed_NumB);
    
    int myPink_NumR=255, myPink_NumG=204, myPink_NumB=204;
    Color myPink_Color =  new Color(myPink_NumR, myPink_NumG, myPink_NumB);
    
    int myUK_NumR=210, myUK_NumG=210, myUK_NumB=210;
    Color myUK_Color =  new Color(myUK_NumR, myUK_NumG, myUK_NumB);
    
    
    int myTonos_NumR=255, myTonos_NumG=122, myTonos_NumB=122;
    Color myTonos_Color =  new Color(myTonos_NumR, myTonos_NumG, myTonos_NumB);
    
    int DefaultColor_NumR=51, DefaultColor_NumG=225, DefaultColor_NumB=204;
    Color Default_Color =  new Color(DefaultColor_NumR, DefaultColor_NumG, DefaultColor_NumB);
    
    int b3numR=255, b3numG=255, b3numB=235;  //JList Color: 255,255,235
    Color mybgcolor= new Color (b3numR, b3numG, b3numB); 
    
    int origverbgnumR=255, origverbgnumG=255, origverbgnumB=215;
    Color origverbgcolor= new Color (origverbgnumR, origverbgnumG, origverbgnumB); 
    
    long startTime;
    long TimeIndication1;
      
    String backup_Letter=("Α~Ω");
    Boolean flag_space=false;
    Boolean flag_tab=false;    
    Boolean flag_enter=false;
    
    static String getKeyChar_fromButton;
    
    int stringSize;
    
    private UndoManager undoManager;
        
    static Font myFont;
    static String mySelectedFont, mySelectedFontSize;
    static int SelectedFontSize;
    
    int indexFont;
    int indexFontSize;
    String oper_system, os, osFont;
    Boolean flag_Bold=false;
    
    Color Color_for_myTextArea;
    
    String Title_ColorPalette;
    
    String mySelectedText;
    String myTextToPaste;
    int myCurrnetPosition;
    
    Color myPurple_Color = new Color(178, 173, 255);

    int   lineNumber=1, columnNumber=0, lastColumnNumber=0, position, difference;
    boolean flag_Right_Orientation=false;
    boolean flag_Line_Warp=true;
    boolean flag_ctrl=false;
    boolean flag_Insert=false;
      
    int myIDHE_NumR=250, myIDHE_NumG=230, myIDHE_NumB=200;
    Color myIDHE_Color =  new Color(myIDHE_NumR, myIDHE_NumG, myIDHE_NumB);
    
    public static File sendmeTheFileNameVK_typeFile;
    
    boolean flag_tonos_pneyma=true;
    JButton which_button_tonos_pneyma = new JButton(" ");
    
    Color tonos_pneyma_Color = new Color(153,204,255);
   
    public static int check_VK_or_ED=0; 
   
    public static String VKglobal_myTextArea;
   
    Icon saveIcon = new ImageIcon("./src/diskette_save_icon.png");
    Icon noSaveIcon = new ImageIcon("./src/diskette_nosave_icon.png");    
    
    public Virtual_Keyboard() throws FileNotFoundException, IOException  {
        
        initComponents();
        JFrame.setDefaultLookAndFeelDecorated(true); //for Title and Icon for Linux
        
        Image small_logo = new ImageIcon(this.getClass().getResource("/PolytLexplus_logo_256x256.png")).getImage();
        this.setIconImage(small_logo);
        
        setDefaultCloseOperation(Virtual_Keyboard.DO_NOTHING_ON_CLOSE);
        
        undoManager = new UndoManager();
        
        this.pleaseBindMyWordsForList();
        
        Document doc =myTextArea.getDocument();
        doc.addDocumentListener(this);

        addWindowListener( new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            
            VKglobal_myTextArea=myTextArea.getText();
            
            JFrame myVirtual_Keyboard = (JFrame)e.getSource();
        
            if (flag_Save==true){

                setDefaultCloseOperation(Virtual_Keyboard.DISPOSE_ON_CLOSE);
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
                
                Editor_or_VirtualKeyboard=true;
                
                //System.out.println("\n");
                //System.out.println("Ἐπιλέχτηκε τὸ Εἰκονικὸ πληκτρολόγιο: " + "( " + Editor_or_VirtualKeyboard + " )" );
                //System.out.println("\n");

                setDefaultCloseOperation(Virtual_Keyboard.DISPOSE_ON_CLOSE);
                Question_for_Save_File myDialog_Save = new Question_for_Save_File(myVirtual_Keyboard, true);
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
                    setDefaultCloseOperation(Virtual_Keyboard.DO_NOTHING_ON_CLOSE);
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
    
    public Virtual_Keyboard(File myMessage) {
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Virtual_Keyboard_ = new javax.swing.JPanel();
        jButton_psili_ = new javax.swing.JButton();
        jButton_oxia_ = new javax.swing.JButton();
        jButton_psili_oxia_ = new javax.swing.JButton();
        jButton_psili_varia_ = new javax.swing.JButton();
        jButton_dasia_ = new javax.swing.JButton();
        jButton_varia_ = new javax.swing.JButton();
        jButton_dasia_varia_ = new javax.swing.JButton();
        jButton_dasia_oxia_ = new javax.swing.JButton();
        jButton_tonos_ = new javax.swing.JButton();
        jButton_perispomeni_ = new javax.swing.JButton();
        jButton_psili_perismpomeni_ = new javax.swing.JButton();
        jButton_dasia_perispomeni_ = new javax.swing.JButton();
        jButton_dialytika_oxia_ = new javax.swing.JButton();
        jButton_dialytika_varia_ = new javax.swing.JButton();
        jButton_makron_ = new javax.swing.JButton();
        jButton_psili_perispomeni_ypogegrammeni_ = new javax.swing.JButton();
        jButton_psili_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dasia_perispomeni_ypogegrammeni_ = new javax.swing.JButton();
        jButton_oxia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dialytika_ = new javax.swing.JButton();
        jButton_psili_oxia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dialytika_perispomeni_ = new javax.swing.JButton();
        jButton_psili_varia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_perispomeni_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dasia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_varia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dasia_varia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dasia_oxia_ypogegrammeni_ = new javax.swing.JButton();
        jButton_dialytika_tonos_ = new javax.swing.JButton();
        jButton_ypogegrammeni_ = new javax.swing.JButton();
        jButton_8_ = new javax.swing.JButton();
        jButton_En_Circumflex_ = new javax.swing.JButton();
        jButton_7_ = new javax.swing.JButton();
        jButton_subtraction_ = new javax.swing.JButton();
        jButton_Ita_ = new javax.swing.JButton();
        jButton_9_ = new javax.swing.JButton();
        jButton_Chi_ = new javax.swing.JButton();
        jButton_4_ = new javax.swing.JButton();
        jButton_6_ = new javax.swing.JButton();
        jButton_5_ = new javax.swing.JButton();
        jButton_Phi_ = new javax.swing.JButton();
        jButton_space_ = new javax.swing.JButton();
        jButton_backspace_ = new javax.swing.JButton();
        jButton_enter_ = new javax.swing.JButton();
        jButton_2_ = new javax.swing.JButton();
        jButton_1_ = new javax.swing.JButton();
        jButton_3_ = new javax.swing.JButton();
        jButton_Ypsilon_ = new javax.swing.JButton();
        jButton_Vita_ = new javax.swing.JButton();
        jButton_Omega_ = new javax.swing.JButton();
        jButton_Epsilon_ = new javax.swing.JButton();
        jButton_Lamda_ = new javax.swing.JButton();
        jButton_komma_ = new javax.swing.JButton();
        jButton_slash_ = new javax.swing.JButton();
        jButton_Iota_ = new javax.swing.JButton();
        jButton_Omikron_ = new javax.swing.JButton();
        jButton_Alpha_ = new javax.swing.JButton();
        jButton_left_square_bracket_ = new javax.swing.JButton();
        jButton_right_square_bracket_ = new javax.swing.JButton();
        jButton_Gamma_ = new javax.swing.JButton();
        jButton_0_ = new javax.swing.JButton();
        jButton_Psi_ = new javax.swing.JButton();
        jButton_Delta_ = new javax.swing.JButton();
        jButton_Thita_ = new javax.swing.JButton();
        jButton_Zita_ = new javax.swing.JButton();
        jButton_Kappa_ = new javax.swing.JButton();
        jButton_Mi_ = new javax.swing.JButton();
        jButton_Ni_ = new javax.swing.JButton();
        jButton_Taf_ = new javax.swing.JButton();
        jButton_final_Sigma_ = new javax.swing.JButton();
        jButton_Sigma_ = new javax.swing.JButton();
        jButton_Ro_ = new javax.swing.JButton();
        jButton_Ksi_ = new javax.swing.JButton();
        jButton_Pi_ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        myJList = new javax.swing.JList<>();
        jButton_equal_ = new javax.swing.JButton();
        jButton_symbol_1 = new javax.swing.JButton();
        jButton_caps_ = new javax.swing.JButton();
        jButton_symbol_2 = new javax.swing.JButton();
        jButton_telia_ = new javax.swing.JButton();
        jButton_NewFile_ = new javax.swing.JButton();
        jButton_OpenFile_VK_ = new javax.swing.JButton();
        jButton_Copy_ = new javax.swing.JButton();
        jButton_Save_ = new javax.swing.JButton();
        jButton_function_ = new javax.swing.JButton();
        jButton_flag_Win_ = new javax.swing.JButton();
        jButton_SaveAs_ = new javax.swing.JButton();
        jButton_ctrl_Right_ = new javax.swing.JButton();
        jButton_right_click_menu_ = new javax.swing.JButton();
        jButton_vrachy_ = new javax.swing.JButton();
        jButton_ano_telia_ = new javax.swing.JButton();
        jButton_right_shift_ = new javax.swing.JButton();
        jButton_backward_slash_ = new javax.swing.JButton();
        jButton_tab_ = new javax.swing.JButton();
        jButton_left_shift_ = new javax.swing.JButton();
        jButton_letter_Q_ = new javax.swing.JButton();
        jLabel_Flag_Lang = new javax.swing.JLabel();
        jButton_altGR_ = new javax.swing.JButton();
        jButton_alt_ = new javax.swing.JButton();
        jButton_ctrl_Left_ = new javax.swing.JButton();
        jButton_Paste_ = new javax.swing.JButton();
        jButton_Undo_ = new javax.swing.JButton();
        jButton_Redo_ = new javax.swing.JButton();
        jComboBox_SystemFonts_ = new javax.swing.JComboBox<>();
        jButton_Font_Increase_ = new javax.swing.JButton();
        jButton_Font_Decrease_ = new javax.swing.JButton();
        jComboBox_FontSize_ = new javax.swing.JComboBox<>();
        jButton_Enable_JList_ = new javax.swing.JButton();
        jButton_Original_Ver_ = new javax.swing.JButton();
        jRadioButton_Theme_ = new javax.swing.JRadioButton();
        jRadioButton_Color_ = new javax.swing.JRadioButton();
        jButton_myColorChooser_ = new javax.swing.JButton();
        jButton_Font_Bold_ = new javax.swing.JButton();
        jButton_LeftAlignment_ = new javax.swing.JButton();
        jButton_RightAlignment_ = new javax.swing.JButton();
        jButton_Zoom_Increase_ = new javax.swing.JButton();
        jButton_Zoom_Decrease_ = new javax.swing.JButton();
        jCheckBox_List_ = new javax.swing.JCheckBox();
        jButton_Zoom_Restore_ = new javax.swing.JButton();
        jButton_Cut_ = new javax.swing.JButton();
        jButton_ForegroundColor_ = new javax.swing.JButton();
        jButton_BackgroundColor_ = new javax.swing.JButton();
        jButton_Black_White_ = new javax.swing.JButton();
        jButton_Broom_ = new javax.swing.JButton();
        jTextField_LinePosition_ = new javax.swing.JTextField();
        jTextField_ColumnPosition_ = new javax.swing.JTextField();
        jLabel_LinePosition_ = new javax.swing.JLabel();
        jLabel_ColumnPosition_ = new javax.swing.JLabel();
        jLabel_CaretPosition_ = new javax.swing.JLabel();
        jTextField_CaretPosition_ = new javax.swing.JTextField();
        jButton_Text_Warp_ = new javax.swing.JButton();
        jButton_Delete_ = new javax.swing.JButton();
        jButton_Home_ = new javax.swing.JButton();
        jButton_End_ = new javax.swing.JButton();
        jButton_Insert_ = new javax.swing.JButton();
        jButton_PageDown_ = new javax.swing.JButton();
        jButton_PageUp_ = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        myTextArea = new javax.swing.JTextArea();
        jButton_Up_ = new javax.swing.JButton();
        jButton_Down_ = new javax.swing.JButton();
        jButton_Right_ = new javax.swing.JButton();
        jButton_Left_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Εἰκονικὸ πληκτρολόγιο");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_Virtual_Keyboard_.setPreferredSize(new java.awt.Dimension(1372, 836));

        jButton_psili_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili.png"))); // NOI18N
        jButton_psili_.setFocusable(false);
        jButton_psili_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_ActionPerformed(evt);
            }
        });

        jButton_oxia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_oxia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_oxia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/oxia.png"))); // NOI18N
        jButton_oxia_.setFocusable(false);
        jButton_oxia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_oxia_ActionPerformed(evt);
            }
        });

        jButton_psili_oxia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_oxia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_oxia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_oxia.png"))); // NOI18N
        jButton_psili_oxia_.setFocusable(false);
        jButton_psili_oxia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_oxia_ActionPerformed(evt);
            }
        });

        jButton_psili_varia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_varia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_varia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_varia.png"))); // NOI18N
        jButton_psili_varia_.setFocusable(false);
        jButton_psili_varia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_varia_ActionPerformed(evt);
            }
        });

        jButton_dasia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia.png"))); // NOI18N
        jButton_dasia_.setFocusable(false);
        jButton_dasia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_ActionPerformed(evt);
            }
        });

        jButton_varia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_varia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_varia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/varia.png"))); // NOI18N
        jButton_varia_.setFocusable(false);
        jButton_varia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_varia_ActionPerformed(evt);
            }
        });

        jButton_dasia_varia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_varia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_varia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia_varia.png"))); // NOI18N
        jButton_dasia_varia_.setFocusable(false);
        jButton_dasia_varia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_varia_ActionPerformed(evt);
            }
        });

        jButton_dasia_oxia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_oxia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_oxia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia_oxia.png"))); // NOI18N
        jButton_dasia_oxia_.setFocusable(false);
        jButton_dasia_oxia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_oxia_ActionPerformed(evt);
            }
        });

        jButton_tonos_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_tonos_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_tonos_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/tonos.png"))); // NOI18N
        jButton_tonos_.setFocusable(false);
        jButton_tonos_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tonos_ActionPerformed(evt);
            }
        });

        jButton_perispomeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_perispomeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_perispomeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/perispomeni.png"))); // NOI18N
        jButton_perispomeni_.setFocusable(false);
        jButton_perispomeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_perispomeni_ActionPerformed(evt);
            }
        });

        jButton_psili_perismpomeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_perismpomeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_perismpomeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_perispomeni.png"))); // NOI18N
        jButton_psili_perismpomeni_.setFocusable(false);
        jButton_psili_perismpomeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_perismpomeni_ActionPerformed(evt);
            }
        });

        jButton_dasia_perispomeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_perispomeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_perispomeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia_perispomeni.png"))); // NOI18N
        jButton_dasia_perispomeni_.setFocusable(false);
        jButton_dasia_perispomeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_perispomeni_ActionPerformed(evt);
            }
        });

        jButton_dialytika_oxia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dialytika_oxia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dialytika_oxia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dialytika_oxia.png"))); // NOI18N
        jButton_dialytika_oxia_.setFocusable(false);
        jButton_dialytika_oxia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dialytika_oxia_ActionPerformed(evt);
            }
        });

        jButton_dialytika_varia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dialytika_varia_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dialytika_varia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dialytika_varia.png"))); // NOI18N
        jButton_dialytika_varia_.setFocusable(false);
        jButton_dialytika_varia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dialytika_varia_ActionPerformed(evt);
            }
        });

        jButton_makron_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_makron_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_makron_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/makron.png"))); // NOI18N
        jButton_makron_.setFocusable(false);
        jButton_makron_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_makron_ActionPerformed(evt);
            }
        });

        jButton_psili_perispomeni_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_perispomeni_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_perispomeni_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_perispomeni_ypogegrammeni.png"))); // NOI18N
        jButton_psili_perispomeni_ypogegrammeni_.setFocusable(false);
        jButton_psili_perispomeni_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_perispomeni_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_psili_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_ypogegrammeni.png"))); // NOI18N
        jButton_psili_ypogegrammeni_.setFocusable(false);
        jButton_psili_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dasia_perispomeni_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_perispomeni_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_perispomeni_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/daisa_perispomeni_ypogegrammeni.png"))); // NOI18N
        jButton_dasia_perispomeni_ypogegrammeni_.setFocusable(false);
        jButton_dasia_perispomeni_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_perispomeni_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_oxia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_oxia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_oxia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/oxia_ypogegrammeni.png"))); // NOI18N
        jButton_oxia_ypogegrammeni_.setFocusable(false);
        jButton_oxia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_oxia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dialytika_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dialytika_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dialytika_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dialytika.png"))); // NOI18N
        jButton_dialytika_.setFocusable(false);
        jButton_dialytika_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dialytika_ActionPerformed(evt);
            }
        });

        jButton_psili_oxia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_oxia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_oxia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_oxia_ypogegrammeni.png"))); // NOI18N
        jButton_psili_oxia_ypogegrammeni_.setFocusable(false);
        jButton_psili_oxia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_oxia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dialytika_perispomeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dialytika_perispomeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dialytika_perispomeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dialytika_perispomeni.png"))); // NOI18N
        jButton_dialytika_perispomeni_.setFocusable(false);
        jButton_dialytika_perispomeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dialytika_perispomeni_ActionPerformed(evt);
            }
        });

        jButton_psili_varia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_psili_varia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_psili_varia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/psili_varia_ypogegrameni.png"))); // NOI18N
        jButton_psili_varia_ypogegrammeni_.setFocusable(false);
        jButton_psili_varia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_psili_varia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_perispomeni_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_perispomeni_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_perispomeni_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/perispomeni_ypogegrammeni.png"))); // NOI18N
        jButton_perispomeni_ypogegrammeni_.setFocusable(false);
        jButton_perispomeni_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_perispomeni_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dasia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia_ypogegrammeni.png"))); // NOI18N
        jButton_dasia_ypogegrammeni_.setFocusable(false);
        jButton_dasia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_varia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_varia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_varia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/varia_ypogegrammeni.png"))); // NOI18N
        jButton_varia_ypogegrammeni_.setFocusable(false);
        jButton_varia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_varia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dasia_varia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_varia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_varia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia_varia_ypogegrammeni.png"))); // NOI18N
        jButton_dasia_varia_ypogegrammeni_.setFocusable(false);
        jButton_dasia_varia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_varia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dasia_oxia_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dasia_oxia_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dasia_oxia_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dasia_oxia_ypogegrammeni.png"))); // NOI18N
        jButton_dasia_oxia_ypogegrammeni_.setFocusable(false);
        jButton_dasia_oxia_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dasia_oxia_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_dialytika_tonos_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_dialytika_tonos_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_dialytika_tonos_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/dialytika_tonos.png"))); // NOI18N
        jButton_dialytika_tonos_.setFocusable(false);
        jButton_dialytika_tonos_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dialytika_tonos_ActionPerformed(evt);
            }
        });

        jButton_ypogegrammeni_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_ypogegrammeni_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_ypogegrammeni_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/ypogegrammeni.png"))); // NOI18N
        jButton_ypogegrammeni_.setFocusable(false);
        jButton_ypogegrammeni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ypogegrammeni_ActionPerformed(evt);
            }
        });

        jButton_8_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_8_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_8_.setText("8");
        jButton_8_.setFocusable(false);
        jButton_8_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_8_ActionPerformed(evt);
            }
        });

        jButton_En_Circumflex_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_En_Circumflex_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_En_Circumflex_.setText("~");
        jButton_En_Circumflex_.setFocusable(false);
        jButton_En_Circumflex_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_En_Circumflex_ActionPerformed(evt);
            }
        });

        jButton_7_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_7_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_7_.setText("7");
        jButton_7_.setFocusable(false);
        jButton_7_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_7_ActionPerformed(evt);
            }
        });

        jButton_subtraction_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_subtraction_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_subtraction_.setText("-");
        jButton_subtraction_.setFocusable(false);
        jButton_subtraction_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_subtraction_ActionPerformed(evt);
            }
        });

        jButton_Ita_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Ita_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Ita_.setText("η");
        jButton_Ita_.setFocusable(false);
        jButton_Ita_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ita_ActionPerformed(evt);
            }
        });

        jButton_9_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_9_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_9_.setText("9");
        jButton_9_.setFocusable(false);
        jButton_9_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_9_ActionPerformed(evt);
            }
        });

        jButton_Chi_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Chi_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Chi_.setText("χ");
        jButton_Chi_.setFocusable(false);
        jButton_Chi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Chi_ActionPerformed(evt);
            }
        });

        jButton_4_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_4_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_4_.setText("4");
        jButton_4_.setFocusable(false);
        jButton_4_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_4_ActionPerformed(evt);
            }
        });

        jButton_6_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_6_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_6_.setText("6");
        jButton_6_.setFocusable(false);
        jButton_6_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_6_ActionPerformed(evt);
            }
        });

        jButton_5_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_5_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_5_.setText("5");
        jButton_5_.setFocusable(false);
        jButton_5_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_5_ActionPerformed(evt);
            }
        });

        jButton_Phi_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Phi_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Phi_.setText("φ");
        jButton_Phi_.setFocusable(false);
        jButton_Phi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Phi_ActionPerformed(evt);
            }
        });

        jButton_space_.setBackground(new java.awt.Color(255, 102, 102));
        jButton_space_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_space_.setText("space");
        jButton_space_.setFocusable(false);
        jButton_space_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_space_ActionPerformed(evt);
            }
        });

        jButton_backspace_.setBackground(new java.awt.Color(255, 102, 102));
        jButton_backspace_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_backspace_.setText("backspace");
        jButton_backspace_.setFocusable(false);
        jButton_backspace_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_backspace_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backspace_ActionPerformed(evt);
            }
        });

        jButton_enter_.setBackground(new java.awt.Color(255, 102, 102));
        jButton_enter_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_enter_.setText("enter");
        jButton_enter_.setFocusable(false);
        jButton_enter_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_enter_ActionPerformed(evt);
            }
        });

        jButton_2_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_2_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_2_.setText("2");
        jButton_2_.setFocusable(false);
        jButton_2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_2_ActionPerformed(evt);
            }
        });

        jButton_1_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_1_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_1_.setText("1");
        jButton_1_.setFocusable(false);
        jButton_1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1_ActionPerformed(evt);
            }
        });

        jButton_3_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_3_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_3_.setText("3");
        jButton_3_.setFocusable(false);
        jButton_3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_3_ActionPerformed(evt);
            }
        });

        jButton_Ypsilon_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Ypsilon_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Ypsilon_.setText("υ");
        jButton_Ypsilon_.setFocusable(false);
        jButton_Ypsilon_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ypsilon_ActionPerformed(evt);
            }
        });

        jButton_Vita_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Vita_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Vita_.setText("β");
        jButton_Vita_.setFocusable(false);
        jButton_Vita_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Vita_ActionPerformed(evt);
            }
        });

        jButton_Omega_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Omega_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Omega_.setText("ω");
        jButton_Omega_.setFocusable(false);
        jButton_Omega_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Omega_ActionPerformed(evt);
            }
        });

        jButton_Epsilon_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Epsilon_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Epsilon_.setText("ε");
        jButton_Epsilon_.setFocusable(false);
        jButton_Epsilon_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Epsilon_ActionPerformed(evt);
            }
        });

        jButton_Lamda_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Lamda_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Lamda_.setText("λ");
        jButton_Lamda_.setFocusable(false);
        jButton_Lamda_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Lamda_ActionPerformed(evt);
            }
        });

        jButton_komma_.setBackground(new java.awt.Color(255, 204, 204));
        jButton_komma_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_komma_.setText(",");
        jButton_komma_.setFocusable(false);
        jButton_komma_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_komma_ActionPerformed(evt);
            }
        });

        jButton_slash_.setBackground(new java.awt.Color(255, 204, 204));
        jButton_slash_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_slash_.setText("/");
        jButton_slash_.setFocusable(false);
        jButton_slash_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_slash_ActionPerformed(evt);
            }
        });

        jButton_Iota_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Iota_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Iota_.setText("ι");
        jButton_Iota_.setFocusable(false);
        jButton_Iota_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Iota_ActionPerformed(evt);
            }
        });

        jButton_Omikron_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Omikron_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Omikron_.setText("ο");
        jButton_Omikron_.setFocusable(false);
        jButton_Omikron_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Omikron_ActionPerformed(evt);
            }
        });

        jButton_Alpha_.setBackground(new java.awt.Color(0, 225, 255));
        jButton_Alpha_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Alpha_.setText("α");
        jButton_Alpha_.setFocusable(false);
        jButton_Alpha_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Alpha_ActionPerformed(evt);
            }
        });

        jButton_left_square_bracket_.setBackground(new java.awt.Color(255, 204, 204));
        jButton_left_square_bracket_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_left_square_bracket_.setText("[");
        jButton_left_square_bracket_.setFocusable(false);
        jButton_left_square_bracket_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_left_square_bracket_ActionPerformed(evt);
            }
        });

        jButton_right_square_bracket_.setBackground(new java.awt.Color(255, 204, 204));
        jButton_right_square_bracket_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_right_square_bracket_.setText("]");
        jButton_right_square_bracket_.setFocusable(false);
        jButton_right_square_bracket_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_right_square_bracket_ActionPerformed(evt);
            }
        });

        jButton_Gamma_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Gamma_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Gamma_.setText("γ");
        jButton_Gamma_.setFocusable(false);
        jButton_Gamma_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Gamma_ActionPerformed(evt);
            }
        });

        jButton_0_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_0_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_0_.setText("0");
        jButton_0_.setFocusable(false);
        jButton_0_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_0_ActionPerformed(evt);
            }
        });

        jButton_Psi_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Psi_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Psi_.setText("ψ");
        jButton_Psi_.setFocusable(false);
        jButton_Psi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Psi_ActionPerformed(evt);
            }
        });

        jButton_Delta_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Delta_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Delta_.setText("δ");
        jButton_Delta_.setFocusable(false);
        jButton_Delta_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Delta_ActionPerformed(evt);
            }
        });

        jButton_Thita_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Thita_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Thita_.setText("θ");
        jButton_Thita_.setFocusable(false);
        jButton_Thita_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Thita_ActionPerformed(evt);
            }
        });

        jButton_Zita_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Zita_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Zita_.setText("ζ");
        jButton_Zita_.setFocusable(false);
        jButton_Zita_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Zita_ActionPerformed(evt);
            }
        });

        jButton_Kappa_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Kappa_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Kappa_.setText("κ");
        jButton_Kappa_.setFocusable(false);
        jButton_Kappa_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Kappa_ActionPerformed(evt);
            }
        });

        jButton_Mi_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Mi_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Mi_.setText("μ");
        jButton_Mi_.setFocusable(false);
        jButton_Mi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Mi_ActionPerformed(evt);
            }
        });

        jButton_Ni_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Ni_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Ni_.setText("ν");
        jButton_Ni_.setFocusable(false);
        jButton_Ni_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ni_ActionPerformed(evt);
            }
        });

        jButton_Taf_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Taf_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Taf_.setText("τ");
        jButton_Taf_.setFocusable(false);
        jButton_Taf_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Taf_ActionPerformed(evt);
            }
        });

        jButton_final_Sigma_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_final_Sigma_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_final_Sigma_.setText("ς");
        jButton_final_Sigma_.setFocusable(false);
        jButton_final_Sigma_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_final_Sigma_ActionPerformed(evt);
            }
        });

        jButton_Sigma_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Sigma_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Sigma_.setText("σ");
        jButton_Sigma_.setFocusable(false);
        jButton_Sigma_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Sigma_ActionPerformed(evt);
            }
        });

        jButton_Ro_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Ro_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Ro_.setText("ρ");
        jButton_Ro_.setFocusable(false);
        jButton_Ro_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ro_ActionPerformed(evt);
            }
        });

        jButton_Ksi_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Ksi_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Ksi_.setText("ξ");
        jButton_Ksi_.setFocusable(false);
        jButton_Ksi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ksi_ActionPerformed(evt);
            }
        });

        jButton_Pi_.setBackground(new java.awt.Color(51, 255, 204));
        jButton_Pi_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_Pi_.setText("π");
        jButton_Pi_.setFocusable(false);
        jButton_Pi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Pi_ActionPerformed(evt);
            }
        });

        myJList.setBackground(new java.awt.Color(255, 255, 235));
        myJList.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        myJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myJList.setVisibleRowCount(4);
        jScrollPane1.setViewportView(myJList);

        jButton_equal_.setBackground(new java.awt.Color(204, 255, 204));
        jButton_equal_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_equal_.setText("=");
        jButton_equal_.setFocusable(false);
        jButton_equal_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_equal_ActionPerformed(evt);
            }
        });

        jButton_symbol_1.setBackground(new java.awt.Color(255, 204, 204));
        jButton_symbol_1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_symbol_1.setText("΄");
        jButton_symbol_1.setFocusable(false);
        jButton_symbol_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_symbol_1ActionPerformed(evt);
            }
        });

        jButton_caps_.setBackground(new java.awt.Color(255, 102, 102));
        jButton_caps_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_caps_.setText("caps");
        jButton_caps_.setFocusable(false);
        jButton_caps_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_caps_ActionPerformed(evt);
            }
        });

        jButton_symbol_2.setBackground(new java.awt.Color(255, 204, 204));
        jButton_symbol_2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_symbol_2.setText("'");
        jButton_symbol_2.setFocusable(false);
        jButton_symbol_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_symbol_2ActionPerformed(evt);
            }
        });

        jButton_telia_.setBackground(new java.awt.Color(255, 204, 204));
        jButton_telia_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_telia_.setText(".");
        jButton_telia_.setFocusable(false);
        jButton_telia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_telia_ActionPerformed(evt);
            }
        });

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

        jButton_OpenFile_VK_.setBackground(new java.awt.Color(242, 242, 242));
        jButton_OpenFile_VK_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open_icon.png"))); // NOI18N
        jButton_OpenFile_VK_.setToolTipText("Ἄνοιγμα");
        jButton_OpenFile_VK_.setFocusable(false);
        jButton_OpenFile_VK_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_OpenFile_VK_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpenFile_VK_ActionPerformed(evt);
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

        jButton_function_.setBackground(new java.awt.Color(0, 0, 0));
        jButton_function_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_function_.setText("fn");
        jButton_function_.setEnabled(false);
        jButton_function_.setFocusable(false);
        jButton_function_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_function_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_function_ActionPerformed(evt);
            }
        });

        jButton_flag_Win_.setBackground(new java.awt.Color(0, 0, 0));
        jButton_flag_Win_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_flag_Win_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_flag_Win_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flagwin_icon.png"))); // NOI18N
        jButton_flag_Win_.setEnabled(false);
        jButton_flag_Win_.setFocusable(false);
        jButton_flag_Win_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_flag_Win_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_flag_Win_ActionPerformed(evt);
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

        jButton_ctrl_Right_.setBackground(new java.awt.Color(255, 102, 102));
        jButton_ctrl_Right_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_ctrl_Right_.setText("ctrl");
        jButton_ctrl_Right_.setFocusable(false);
        jButton_ctrl_Right_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_ctrl_Right_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ctrl_Right_ActionPerformed(evt);
            }
        });

        jButton_right_click_menu_.setBackground(new java.awt.Color(0, 0, 0));
        jButton_right_click_menu_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_right_click_menu_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_right_click_menu_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_icon.png"))); // NOI18N
        jButton_right_click_menu_.setEnabled(false);
        jButton_right_click_menu_.setFocusable(false);
        jButton_right_click_menu_.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton_right_click_menu_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_right_click_menu_ActionPerformed(evt);
            }
        });

        jButton_vrachy_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_vrachy_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/vrachy.png"))); // NOI18N
        jButton_vrachy_.setFocusable(false);
        jButton_vrachy_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_vrachy_ActionPerformed(evt);
            }
        });

        jButton_ano_telia_.setBackground(new java.awt.Color(153, 204, 255));
        jButton_ano_telia_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonoi_pnevmata/ano_telia.png"))); // NOI18N
        jButton_ano_telia_.setFocusable(false);
        jButton_ano_telia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ano_telia_ActionPerformed(evt);
            }
        });

        jButton_right_shift_.setBackground(new java.awt.Color(255, 102, 102));
        jButton_right_shift_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_right_shift_.setText("shift");
        jButton_right_shift_.setFocusable(false);
        jButton_right_shift_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_right_shift_ActionPerformed(evt);
            }
        });

        jButton_backward_slash_.setBackground(new java.awt.Color(255, 204, 204));
        jButton_backward_slash_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton_backward_slash_.setText("\\");
            jButton_backward_slash_.setFocusable(false);
            jButton_backward_slash_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_backward_slash_ActionPerformed(evt);
                }
            });

            jButton_tab_.setBackground(new java.awt.Color(255, 102, 102));
            jButton_tab_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_tab_.setText("tab");
            jButton_tab_.setFocusable(false);
            jButton_tab_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_tab_ActionPerformed(evt);
                }
            });

            jButton_left_shift_.setBackground(new java.awt.Color(255, 102, 102));
            jButton_left_shift_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_left_shift_.setText("shift");
            jButton_left_shift_.setFocusable(false);
            jButton_left_shift_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_left_shift_ActionPerformed(evt);
                }
            });

            jButton_letter_Q_.setBackground(new java.awt.Color(255, 204, 204));
            jButton_letter_Q_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_letter_Q_.setText(";");
            jButton_letter_Q_.setFocusable(false);
            jButton_letter_Q_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_letter_Q_ActionPerformed(evt);
                }
            });

            jLabel_Flag_Lang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel_Flag_Lang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Greek.png"))); // NOI18N
            jLabel_Flag_Lang.setFocusable(false);
            jLabel_Flag_Lang.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel_Flag_LangMouseClicked(evt);
                }
            });

            jButton_altGR_.setBackground(new java.awt.Color(255, 102, 102));
            jButton_altGR_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_altGR_.setText("altGR");
            jButton_altGR_.setFocusable(false);
            jButton_altGR_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_altGR_ActionPerformed(evt);
                }
            });

            jButton_alt_.setBackground(new java.awt.Color(0, 0, 0));
            jButton_alt_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_alt_.setText("alt");
            jButton_alt_.setEnabled(false);
            jButton_alt_.setFocusable(false);

            jButton_ctrl_Left_.setBackground(new java.awt.Color(255, 102, 102));
            jButton_ctrl_Left_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_ctrl_Left_.setText("ctrl");
            jButton_ctrl_Left_.setFocusable(false);
            jButton_ctrl_Left_.setPreferredSize(new java.awt.Dimension(40, 40));
            jButton_ctrl_Left_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_ctrl_Left_ActionPerformed(evt);
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
            jComboBox_SystemFonts_.setPreferredSize(new java.awt.Dimension(206, 40));
            jComboBox_SystemFonts_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBox_SystemFonts_ActionPerformed(evt);
                }
            });

            jButton_Font_Increase_.setBackground(new java.awt.Color(242, 242, 242));
            jButton_Font_Increase_.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
            jComboBox_FontSize_.setPreferredSize(new java.awt.Dimension(86, 40));
            jComboBox_FontSize_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBox_FontSize_ActionPerformed(evt);
                }
            });

            jButton_Enable_JList_.setBackground(new java.awt.Color(0, 255, 0));
            jButton_Enable_JList_.setToolTipText("Ἀπενεργοποίηση τῆς λίστας");
            jButton_Enable_JList_.setFocusable(false);
            jButton_Enable_JList_.setPreferredSize(new java.awt.Dimension(20, 20));
            jButton_Enable_JList_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Enable_JList_ActionPerformed(evt);
                }
            });

            jButton_Original_Ver_.setBackground(new java.awt.Color(255, 255, 215));
            jButton_Original_Ver_.setToolTipText("Πρωτότυπη ἔκδοση");
            jButton_Original_Ver_.setFocusable(false);
            jButton_Original_Ver_.setPreferredSize(new java.awt.Dimension(20, 20));
            jButton_Original_Ver_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Original_Ver_ActionPerformed(evt);
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

            jRadioButton_Color_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jRadioButton_Color_.setText("Ἔγχρωμο");
            jRadioButton_Color_.setFocusable(false);
            jRadioButton_Color_.setPreferredSize(new java.awt.Dimension(100, 20));
            jRadioButton_Color_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton_Color_ActionPerformed(evt);
                }
            });

            jButton_myColorChooser_.setBackground(new java.awt.Color(255, 255, 100));
            jButton_myColorChooser_.setToolTipText("Χρῶμα ἐπιλογῆς");
            jButton_myColorChooser_.setFocusable(false);
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

            jCheckBox_List_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jCheckBox_List_.setText("Λίστα");
            jCheckBox_List_.setFocusable(false);
            jCheckBox_List_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox_List_ActionPerformed(evt);
                }
            });

            jButton_Zoom_Restore_.setBackground(new java.awt.Color(242, 242, 242));
            jButton_Zoom_Restore_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
            jButton_Cut_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jButton_Cut_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scissors_icon.png"))); // NOI18N
            jButton_Cut_.setToolTipText("Ἀποκοπὴ");
            jButton_Cut_.setFocusable(false);
            jButton_Cut_.setPreferredSize(new java.awt.Dimension(40, 40));
            jButton_Cut_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Cut_ActionPerformed(evt);
                }
            });

            jButton_ForegroundColor_.setBackground(new java.awt.Color(0, 0, 0));
            jButton_ForegroundColor_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jButton_ForegroundColor_.setToolTipText("Χρῶμα χαρακτήρων");
            jButton_ForegroundColor_.setFocusable(false);
            jButton_ForegroundColor_.setPreferredSize(new java.awt.Dimension(40, 40));
            jButton_ForegroundColor_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_ForegroundColor_ActionPerformed(evt);
                }
            });

            jButton_BackgroundColor_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jButton_BackgroundColor_.setToolTipText("Χρῶμα φόντου");
            jButton_BackgroundColor_.setFocusable(false);
            jButton_BackgroundColor_.setPreferredSize(new java.awt.Dimension(40, 40));
            jButton_BackgroundColor_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_BackgroundColor_ActionPerformed(evt);
                }
            });

            jButton_Black_White_.setBackground(new java.awt.Color(242, 242, 242));
            jButton_Black_White_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jButton_Black_White_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black_white_icon.png"))); // NOI18N
            jButton_Black_White_.setToolTipText("Ἄσπρο χρῶμα φόντου καὶ μαῦρο χρῶμα χαρακτήρων");
            jButton_Black_White_.setFocusable(false);
            jButton_Black_White_.setPreferredSize(new java.awt.Dimension(40, 40));
            jButton_Black_White_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Black_White_ActionPerformed(evt);
                }
            });

            jButton_Broom_.setBackground(new java.awt.Color(0, 153, 255));
            jButton_Broom_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/broom_icon.png"))); // NOI18N
            jButton_Broom_.setToolTipText("Καθαρισμὸς τόνων καὶ πνευμάτων");
            jButton_Broom_.setFocusable(false);
            jButton_Broom_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Broom_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Broom_ActionPerformed(evt);
                }
            });

            jTextField_LinePosition_.setEditable(false);
            jTextField_LinePosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jTextField_LinePosition_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            jTextField_LinePosition_.setFocusable(false);
            jTextField_LinePosition_.setPreferredSize(new java.awt.Dimension(60, 30));

            jTextField_ColumnPosition_.setEditable(false);
            jTextField_ColumnPosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jTextField_ColumnPosition_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            jTextField_ColumnPosition_.setFocusable(false);
            jTextField_ColumnPosition_.setPreferredSize(new java.awt.Dimension(60, 30));
            jTextField_ColumnPosition_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_ColumnPosition_ActionPerformed(evt);
                }
            });

            jLabel_LinePosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jLabel_LinePosition_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel_LinePosition_.setText("Γραμμή:");
            jLabel_LinePosition_.setFocusable(false);
            jLabel_LinePosition_.setPreferredSize(new java.awt.Dimension(64, 30));

            jLabel_ColumnPosition_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jLabel_ColumnPosition_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel_ColumnPosition_.setText("Στήλη:");
            jLabel_ColumnPosition_.setFocusable(false);
            jLabel_ColumnPosition_.setPreferredSize(new java.awt.Dimension(54, 30));

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

            jButton_Delete_.setBackground(new java.awt.Color(250, 230, 200));
            jButton_Delete_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_Delete_.setText("D");
            jButton_Delete_.setToolTipText("Delete");
            jButton_Delete_.setFocusable(false);
            jButton_Delete_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Delete_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Delete_ActionPerformed(evt);
                }
            });

            jButton_Home_.setBackground(new java.awt.Color(250, 230, 200));
            jButton_Home_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_Home_.setText("H");
            jButton_Home_.setToolTipText("Home");
            jButton_Home_.setFocusable(false);
            jButton_Home_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Home_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Home_ActionPerformed(evt);
                }
            });

            jButton_End_.setBackground(new java.awt.Color(250, 230, 200));
            jButton_End_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_End_.setText("E");
            jButton_End_.setToolTipText("End");
            jButton_End_.setFocusable(false);
            jButton_End_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_End_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_End_ActionPerformed(evt);
                }
            });

            jButton_Insert_.setBackground(new java.awt.Color(250, 230, 200));
            jButton_Insert_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_Insert_.setText("I");
            jButton_Insert_.setToolTipText("Insert");
            jButton_Insert_.setFocusable(false);
            jButton_Insert_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Insert_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Insert_ActionPerformed(evt);
                }
            });

            jButton_PageDown_.setBackground(new java.awt.Color(250, 230, 200));
            jButton_PageDown_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_PageDown_.setText("D");
            jButton_PageDown_.setToolTipText("Page Down");
            jButton_PageDown_.setEnabled(false);
            jButton_PageDown_.setFocusable(false);
            jButton_PageDown_.setPreferredSize(new java.awt.Dimension(50, 50));

            jButton_PageUp_.setBackground(new java.awt.Color(250, 230, 200));
            jButton_PageUp_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
            jButton_PageUp_.setText("U");
            jButton_PageUp_.setToolTipText("Page Up");
            jButton_PageUp_.setEnabled(false);
            jButton_PageUp_.setFocusable(false);
            jButton_PageUp_.setPreferredSize(new java.awt.Dimension(50, 50));

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
            jScrollPane3.setViewportView(myTextArea);

            jButton_Up_.setBackground(new java.awt.Color(178, 173, 255));
            jButton_Up_.setFont(new java.awt.Font("Wingdings 3", 0, 18)); // NOI18N
            jButton_Up_.setText("");
            jButton_Up_.setToolTipText("Up");
            jButton_Up_.setFocusable(false);
            jButton_Up_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Up_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Up_ActionPerformed(evt);
                }
            });

            jButton_Down_.setBackground(new java.awt.Color(178, 173, 255));
            jButton_Down_.setFont(new java.awt.Font("Wingdings 3", 0, 18)); // NOI18N
            jButton_Down_.setText("");
            jButton_Down_.setToolTipText("Down");
            jButton_Down_.setFocusable(false);
            jButton_Down_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Down_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Down_ActionPerformed(evt);
                }
            });

            jButton_Right_.setBackground(new java.awt.Color(178, 173, 255));
            jButton_Right_.setFont(new java.awt.Font("Wingdings 3", 0, 18)); // NOI18N
            jButton_Right_.setText("");
            jButton_Right_.setToolTipText("Right");
            jButton_Right_.setFocusable(false);
            jButton_Right_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Right_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Right_ActionPerformed(evt);
                }
            });

            jButton_Left_.setBackground(new java.awt.Color(178, 173, 255));
            jButton_Left_.setFont(new java.awt.Font("Wingdings 3", 0, 18)); // NOI18N
            jButton_Left_.setText("");
            jButton_Left_.setToolTipText("Left");
            jButton_Left_.setFocusable(false);
            jButton_Left_.setPreferredSize(new java.awt.Dimension(50, 50));
            jButton_Left_.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_Left_ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel_Virtual_Keyboard_Layout = new javax.swing.GroupLayout(jPanel_Virtual_Keyboard_);
            jPanel_Virtual_Keyboard_.setLayout(jPanel_Virtual_Keyboard_Layout);
            jPanel_Virtual_Keyboard_Layout.setHorizontalGroup(
                jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_NewFile_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_OpenFile_VK_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Save_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_SaveAs_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Copy_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Paste_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBox_SystemFonts_, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_Cut_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Undo_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBox_FontSize_, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_Font_Increase_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Font_Decrease_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Font_Bold_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_BackgroundColor_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_Redo_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_LeftAlignment_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_RightAlignment_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_Text_Warp_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_ForegroundColor_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Black_White_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_Zoom_Increase_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Zoom_Restore_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Zoom_Decrease_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton_Theme_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Color_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jTextField_CaretPosition_, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jCheckBox_List_, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(87, 87, 87)
                                    .addComponent(jButton_myColorChooser_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton_Original_Ver_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton_Enable_JList_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_psili_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_dasia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_psili_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_dasia_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_psili_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_dasia_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_ano_telia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_tonos_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_perispomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_psili_perismpomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_dasia_perispomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_dialytika_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(jButton_dialytika_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_makron_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(jButton_Broom_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addComponent(jButton_En_Circumflex_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_1_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_2_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_3_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_4_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_5_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_6_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_7_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_8_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_9_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_0_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_subtraction_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_equal_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_backspace_, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Insert_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_Home_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_PageUp_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                    .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                                    .addComponent(jButton_tab_, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_letter_Q_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_final_Sigma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Epsilon_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Ro_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Taf_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Ypsilon_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Thita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Iota_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Omikron_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Pi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_left_square_bracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_right_square_bracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_backward_slash_, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                                    .addComponent(jButton_psili_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dasia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_oxia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_psili_oxia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dasia_oxia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_varia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_psili_varia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dasia_varia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dialytika_tonos_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_perispomeni_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_psili_perispomeni_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dasia_perispomeni_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dialytika_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_dialytika_perispomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_vrachy_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                                    .addComponent(jButton_left_shift_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Zita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Chi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Psi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Omega_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Vita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Ni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_Mi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_komma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_telia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_slash_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton_right_shift_, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                            .addComponent(jButton_caps_, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Alpha_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Sigma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Delta_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Phi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Gamma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Ita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Ksi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Kappa_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Lamda_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_symbol_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_symbol_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_enter_, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                            .addComponent(jButton_ctrl_Left_, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_flag_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_alt_, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_space_, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_altGR_, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_function_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel_Flag_Lang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_right_click_menu_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_ctrl_Right_, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Left_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                            .addComponent(jButton_Down_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton_Right_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton_Up_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                                                .addComponent(jButton_End_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_PageDown_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGap(49, 49, 49))
            );
            jPanel_Virtual_Keyboard_Layout.setVerticalGroup(
                jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_NewFile_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_OpenFile_VK_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Copy_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Save_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_SaveAs_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Paste_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Undo_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Redo_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton_Color_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_LeftAlignment_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_RightAlignment_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Zoom_Increase_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Zoom_Decrease_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Zoom_Restore_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Cut_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Text_Warp_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox_SystemFonts_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Font_Increase_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Font_Decrease_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_FontSize_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton_Theme_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Font_Bold_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_ForegroundColor_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_BackgroundColor_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Black_White_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_LinePosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_ColumnPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_LinePosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_ColumnPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_CaretPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_CaretPosition_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_dasia_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_ano_telia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_tonos_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_perispomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_perismpomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_perispomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dialytika_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dialytika_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_makron_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_oxia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_varia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Broom_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_vrachy_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_perispomeni_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_perispomeni_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_oxia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dialytika_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_oxia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dialytika_perispomeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_psili_varia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_perispomeni_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_varia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_varia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dasia_oxia_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_dialytika_tonos_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_ypogegrammeni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_8_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_En_Circumflex_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_7_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_subtraction_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_9_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_Home_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_PageUp_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton_Insert_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_4_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_6_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_5_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_backspace_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_2_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_1_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_3_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_0_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_equal_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_End_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_PageDown_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton_Ypsilon_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Epsilon_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Iota_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Omikron_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_left_square_bracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_right_square_bracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Thita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Taf_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_final_Sigma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Ro_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Pi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_backward_slash_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_tab_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_letter_Q_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_Ita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Phi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_enter_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Lamda_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Alpha_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Gamma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Delta_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Kappa_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Sigma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Ksi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_symbol_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_caps_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_symbol_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_right_shift_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_Up_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton_Chi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Vita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Omega_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_komma_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_slash_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Psi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Zita_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Mi_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Ni_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_left_shift_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_telia_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_function_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_flag_Win_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_ctrl_Right_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_right_click_menu_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_space_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_Flag_Lang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_altGR_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_alt_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_ctrl_Left_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_Left_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_Right_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_Down_, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel_Virtual_Keyboard_Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_Virtual_Keyboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox_List_)
                                .addComponent(jButton_Enable_JList_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Original_Ver_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_myColorChooser_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(20, 20, 20))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_Virtual_Keyboard_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_Virtual_Keyboard_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
            );

            jPanel_Virtual_Keyboard_.getAccessibleContext().setAccessibleName("Εἰκονικὸ πληκτρολόγιο");

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    
    private void jButton_psili_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_ypogegrammeni_ActionPerformed

       jButton_psili_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_ypogegrammeni_;        
        
        if (backup_Letter==("psili_ypogegrammeni")) {
             jButton_psili_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾀ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾐ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾠ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾈ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾘ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾨ");
                jButton_Omega_.setBackground(mySelected_Color);
            }
        }
                
        else if (flag_caps==true){
            if (flag_shift==false){    
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾈ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾘ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾨ");
                jButton_Omega_.setBackground(mySelected_Color);                
                
            }
            else {
                small_letters ();  
                
                jButton_Alpha_.setText("ᾀ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾐ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾠ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_psili_ypogegrammeni_ActionPerformed

    private void jButton_perispomeni_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_perispomeni_ypogegrammeni_ActionPerformed

        jButton_perispomeni_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_perispomeni_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_perispomeni_ypogegrammeni_;        
        
        if (backup_Letter==("perispomeni_ypogegrammeni")) {
             jButton_perispomeni_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("perispomeni_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾷ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῇ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῷ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
         
            }
        }
           
               
        else if (flag_caps==true){
            if (flag_shift==false){   
                
                big_letters ();
                
            }
            else {
                
                small_letters ();  
                
                jButton_Alpha_.setText("ᾷ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῇ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῷ");
                jButton_Omega_.setBackground(mySelected_Color);                
 
            }
        }
        
    }//GEN-LAST:event_jButton_perispomeni_ypogegrammeni_ActionPerformed

    private void jButton_backspace_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backspace_ActionPerformed
        
        delete_selected_text();
        
        if (columnNumber==0 && lineNumber==1) {
            return;
        }
        int start = myTextArea.getCaretPosition()-1;
        int end = myTextArea.getCaretPosition();

        myTextArea.replaceRange(null, start, end);
        myTextArea.setCaretPosition(myTextArea.getCaretPosition());
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);

        display_positions();
        
    }//GEN-LAST:event_jButton_backspace_ActionPerformed

    private void jButton_Vita_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Vita_ActionPerformed

        if (flag_ctrl==true) {
            
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
            return;
            
        }
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Vita_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Vita_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
        
    }//GEN-LAST:event_jButton_Vita_ActionPerformed

    private void jButton_Alpha_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Alpha_ActionPerformed
        
        if (flag_ctrl==true) {
            myTextArea.selectAll();
            return; 
         }
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Alpha_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Alpha_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        if (jButton_Alpha_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false; 
            reload_greek_vowels();            
        }
        
        display_positions();
           
    }//GEN-LAST:event_jButton_Alpha_ActionPerformed

    private void jButton_space_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_space_ActionPerformed
        
        flag_space=true;
        temp="";
        getKeyChar_fromButton="";
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(" ", caretPosition);
        
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_space_ActionPerformed

    private void jButton_enter_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_enter_ActionPerformed
        
        flag_enter=true;
        temp="";
        getKeyChar_fromButton="";   
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert("\n", caretPosition);
        
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_enter_ActionPerformed

    private void jButton_Gamma_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Gamma_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Gamma_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Gamma_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();        
                
    }//GEN-LAST:event_jButton_Gamma_ActionPerformed

    private void jButton_caps_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_caps_ActionPerformed
        
        if (flag_caps==false){
        flag_caps=true;    
        jButton_caps_.setBackground(mySelected_Color);
         
            if (flag_lang==true){ // Αν είναι επιλεγμένη η ελληνική γλώσσα
                if (flag_shift==false) { //Αν δεν είναι πατημένο το πλήκτρο shift
                    big_letters();
                    if (flag_tonos_pneyma==true) {
                        which_button_tonos_pneyma.doClick();
                    }
                    else {}
                }    
                else {  //Eίναι πατημένο το πλήκτρο shift
                    small_letters();
                    if (flag_tonos_pneyma==true) {
                        which_button_tonos_pneyma.doClick();
                    }
                    else {}
                }
                
            }

            else {  // Αν δεν είναι επιλεγμένη η ελληνική γλώσσα
                if (flag_shift==false) {
                    UK_big_letters();
                    }
                else {
                    UK_small_letters();
                    }
                }
            }
        
        
        else {
            flag_caps=false;  
        
            if (jRadioButton_Theme_.isSelected()==true) {  
                jButton_caps_.setBackground(BG_Color_btn); 
            }
            else {
                jButton_caps_.setBackground(myRed_Color);   
            }
                
                   
            if (flag_lang==true){  // Αν είναι επιλεγμένη η ελληνική γλώσσα
                if (flag_shift==false) {
                    small_letters();
                    if (flag_tonos_pneyma==true) {
                        which_button_tonos_pneyma.doClick();
                    }
                    else {}
                }
                else {
                    big_letters();
                    if (flag_tonos_pneyma==true) {
                        which_button_tonos_pneyma.doClick();
                    }
                    else {}
                }
            }
            else { // Αν δεν είναι επιλεγμένη η ελληνική γλώσσα
                if (flag_shift==false) {
                    UK_small_letters();
                    }
                else {
                    UK_big_letters();
                    }
                }
            }
            
         
    }//GEN-LAST:event_jButton_caps_ActionPerformed

    private void jButton_Zita_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zita_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Zita_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Zita_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Zita_ActionPerformed

    private void jButton_Delta_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delta_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Delta_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Delta_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Delta_ActionPerformed

    private void jButton_dasia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_ActionPerformed

        jButton_dasia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_;
        
        if (backup_Letter==("dasia")) {
             jButton_dasia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
            
                jButton_Alpha_.setText("ἁ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἑ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἡ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἱ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὁ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὑ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὡ");
                jButton_Omega_.setBackground(mySelected_Color);
                jButton_Ro_.setText("ῥ");
                jButton_Ro_.setBackground(mySelected_Color);
         
            }
            else {
                big_letters ();

                jButton_Alpha_.setText("Ἁ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἑ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἡ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἱ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὁ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὑ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὡ");
                jButton_Omega_.setBackground(mySelected_Color);
                jButton_Ro_.setText("Ῥ");
                jButton_Ro_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    
                
                big_letters ();

                jButton_Alpha_.setText("Ἁ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἑ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἡ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἱ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὁ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὑ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὡ");
                jButton_Omega_.setBackground(mySelected_Color);
                jButton_Ro_.setText("Ῥ");
                jButton_Ro_.setBackground(mySelected_Color);
         
            }
            else {
                
                small_letters ();

                jButton_Alpha_.setText("ἁ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἑ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἡ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἱ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὁ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὑ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὡ");
                jButton_Omega_.setBackground(mySelected_Color);
                jButton_Ro_.setText("ῥ");
                jButton_Ro_.setBackground(mySelected_Color);
     
            }
        }
  
    }//GEN-LAST:event_jButton_dasia_ActionPerformed

    private void jButton_Lamda_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Lamda_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Lamda_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Lamda_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Lamda_ActionPerformed

    private void jButton_Epsilon_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Epsilon_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Epsilon_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Epsilon_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        if (jButton_Epsilon_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false; 
            reload_greek_vowels();            
        }
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Epsilon_ActionPerformed

    private void jButton_Ita_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ita_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Ita_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Ita_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        
        if (jButton_Ita_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false;             
            reload_greek_vowels();            
        }     
        
        display_positions();

    }//GEN-LAST:event_jButton_Ita_ActionPerformed

    private void jButton_Iota_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Iota_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Iota_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Iota_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        if (jButton_Iota_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false;             
            reload_greek_vowels();            
        }      
        
        display_positions();

    }//GEN-LAST:event_jButton_Iota_ActionPerformed

    private void jButton_Omikron_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Omikron_ActionPerformed
        
        if (flag_ctrl==true) {
            
            Open_File_Dialog myDialog_OpenFile = new Open_File_Dialog(this, true);
            myDialog_OpenFile.setVisible(true);
                   
            //System.out.println(sendmeTheFileNametypeFile);
            myCurrentFile=sendmeTheFileNametypeFile;
        
            try {
 
                setTitle("Εἰκονικὸ πληκτρολόγιο: " + myCurrentFile.getName());
        
                FileReader myFileReader = new FileReader(pathFakelos_myfiles + myCurrentFile);
                BufferedReader myBufferedReader = new BufferedReader(myFileReader);
        
                StringBuilder myFileText = new StringBuilder();
                String readMyText;
            
                while ((readMyText =  myBufferedReader.readLine()) !=  null){
                    myFileText.append(readMyText + "\n");
            
                }
        
            myTextArea.setText(myFileText.toString());
            myTextArea.setCaretPosition(0);
            
            display_positions();
            
            }
       
            catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
            }
            
            return;
        }
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Omikron_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Omikron_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        if (jButton_Omikron_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false;             
            reload_greek_vowels();            
        }    
        
        display_positions();
 
    }//GEN-LAST:event_jButton_Omikron_ActionPerformed

    private void jButton_Ypsilon_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ypsilon_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Ypsilon_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Ypsilon_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        if (jButton_Ypsilon_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false;             
            reload_greek_vowels();            
        }
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Ypsilon_ActionPerformed

    private void jButton_Omega_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Omega_ActionPerformed

        if (flag_ctrl==true) {
            
            myCurrnetPosition= myTextArea.getCaretPosition();
            myTextToPaste=mySelectedText;
            myTextArea.insert(myTextToPaste, myCurrnetPosition);
            return;    
        }
        
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Omega_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Omega_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);

        if (jButton_Omega_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false;             
            reload_greek_vowels();            
        }    
        
        display_positions();
   
    }//GEN-LAST:event_jButton_Omega_ActionPerformed

    private void jButton_Thita_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Thita_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Thita_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Thita_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Thita_ActionPerformed

    private void jButton_Kappa_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Kappa_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Kappa_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Kappa_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Kappa_ActionPerformed

    private void jButton_Mi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Mi_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Mi_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Mi_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Mi_ActionPerformed

    private void jButton_Ni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ni_ActionPerformed
        
        if (flag_ctrl==true) {
            setTitle("Εἰκονικὸ πληκτρολόγιο");
            myTextArea.setText("");
            myCurrentFile=null;
            return;
        }
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Ni_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Ni_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Ni_ActionPerformed

    private void jButton_Ksi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ksi_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Ksi_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Ksi_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Ksi_ActionPerformed

    private void jButton_Pi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Pi_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Pi_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Pi_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Pi_ActionPerformed

    private void jButton_Ro_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ro_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Ro_.getText();
        temp+=getKeyChar_fromButton;    
        myTextArea.insert(jButton_Ro_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        if (jButton_Ro_.getBackground()==mySelected_Color) {
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false; 
            reload_greek_vowels();            
        }
        
        display_positions();
        
        
    }//GEN-LAST:event_jButton_Ro_ActionPerformed

    private void jButton_Sigma_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Sigma_ActionPerformed

        if (flag_ctrl==true) {
            
            //System.out.println("<< Save >>");
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
            
            return;
        }
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Sigma_.getText();
        temp+=getKeyChar_fromButton;   
        myTextArea.insert(jButton_Sigma_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Sigma_ActionPerformed

    private void jButton_final_Sigma_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_final_Sigma_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();        
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_final_Sigma_.getText();
        temp+=getKeyChar_fromButton;     
        myTextArea.insert(jButton_final_Sigma_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_final_Sigma_ActionPerformed

    private void jButton_Taf_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Taf_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Taf_.getText();
        temp+=getKeyChar_fromButton;
        myTextArea.insert(jButton_Taf_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Taf_ActionPerformed

    private void jButton_Phi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Phi_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Phi_.getText();
        temp+=getKeyChar_fromButton;  
        myTextArea.insert(jButton_Phi_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);

        display_positions();
        
    }//GEN-LAST:event_jButton_Phi_ActionPerformed

    private void jButton_Chi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Chi_ActionPerformed

        if (flag_ctrl==true) {
            mySelectedText = myTextArea.getSelectedText();
            if (mySelectedText != null) {
                myTextArea.cut();
            }
            return;    
        }
                
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Chi_.getText();
        temp+=getKeyChar_fromButton; 
        myTextArea.insert(jButton_Chi_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);

        display_positions();
        
    }//GEN-LAST:event_jButton_Chi_ActionPerformed

    private void jButton_Psi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Psi_ActionPerformed
        
        if (flag_ctrl==true) {
            mySelectedText = myTextArea.getSelectedText();
            if (mySelectedText != null) {
                return;
            }
            return;    
        } 
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=jButton_Psi_.getText();
        temp+=getKeyChar_fromButton;    
        myTextArea.insert(jButton_Psi_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Psi_ActionPerformed

    private void jButton_0_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_0_ActionPerformed

        if (flag_ctrl==true) {
             jButton_Zoom_Restore_.doClick();
          return;  
        }
        
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
        
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_0_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_0_ActionPerformed

    private void jButton_1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
        
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_1_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
       
    }//GEN-LAST:event_jButton_1_ActionPerformed

    private void jButton_2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_2_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
        
        delete_selected_text();
                
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_2_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_2_ActionPerformed

    private void jButton_3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_3_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text(); 
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_3_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_3_ActionPerformed

    private void jButton_4_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_4_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text(); 
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_4_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_4_ActionPerformed

    private void jButton_5_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_5_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_5_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_5_ActionPerformed

    private void jButton_6_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_6_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_6_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_6_ActionPerformed

    private void jButton_7_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_7_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
       
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_7_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_7_ActionPerformed

    private void jButton_8_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_8_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_8_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_8_ActionPerformed

    private void jButton_9_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_9_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_9_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_9_ActionPerformed

    private void jButton_equal_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_equal_ActionPerformed

        if (flag_ctrl==true) {
             jButton_Zoom_Increase_.doClick();
          return;  
        }
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        

        
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_equal_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_equal_ActionPerformed

    private void jButton_backward_slash_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backward_slash_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_backward_slash_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_backward_slash_ActionPerformed

    private void jButton_subtraction_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_subtraction_ActionPerformed

        if (flag_ctrl==true) {
             jButton_Zoom_Decrease_.doClick();
          return;  
        }
                
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_subtraction_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_subtraction_ActionPerformed

    private void jButton_psili_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_ActionPerformed
        
        jButton_psili_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_;
        
        if (backup_Letter==("psili")) {
             jButton_psili_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili");
             
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
                
                small_letters ();    
            
                jButton_Alpha_.setText("ἀ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἐ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἠ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἰ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὀ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὐ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὠ");
                jButton_Omega_.setBackground(mySelected_Color);
                jButton_Ro_.setText("ῤ");
                jButton_Ro_.setBackground(mySelected_Color);
            
            }
            else {

                big_letters ();
            
                jButton_Alpha_.setText("Ἀ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἐ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἠ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἰ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὀ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὠ");
                jButton_Omega_.setBackground(mySelected_Color);
                
            }
        }
                
        else if (flag_caps==true){
            if (flag_shift==false){    
                
                big_letters ();
            
                jButton_Alpha_.setText("Ἀ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἐ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἠ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἰ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὀ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὠ");
                jButton_Omega_.setBackground(mySelected_Color);
            
            }
            else {
            
                small_letters ();    
            
                jButton_Alpha_.setText("ἀ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἐ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἠ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἰ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὀ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὐ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὠ");
                jButton_Omega_.setBackground(mySelected_Color);
                jButton_Ro_.setText("ῤ");
                jButton_Ro_.setBackground(mySelected_Color);
                
            }
        }
        
    }//GEN-LAST:event_jButton_psili_ActionPerformed

    private void jButton_oxia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_oxia_ActionPerformed
        
        jButton_oxia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_oxia_;

        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_oxia_;        
        
        if (backup_Letter==("oxia")) {
             jButton_oxia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("oxia");
        }
                
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
            
                jButton_Alpha_.setText("ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ί");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ώ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ί");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ώ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){   

                big_letters ();

                jButton_Alpha_.setText("Ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ή");
                 jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ί");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ώ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                small_letters ();  
            
                jButton_Alpha_.setText("ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ί");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ώ");
                jButton_Omega_.setBackground(mySelected_Color);
     
            }
        }

    }//GEN-LAST:event_jButton_oxia_ActionPerformed

    private void jButton_varia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_varia_ActionPerformed
        
        jButton_varia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_varia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_varia_;        
        
        if (backup_Letter==("varia")) {
             jButton_varia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("varia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ὰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ὲ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ὴ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ὶ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὸ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὺ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὼ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("Ὰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ὲ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ὴ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ὶ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὸ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὺ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὼ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){
                
                big_letters ();
                
                jButton_Alpha_.setText("Ὰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ὲ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ὴ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ὶ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὸ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὺ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὼ");
                jButton_Omega_.setBackground(mySelected_Color);
                
            }
            else {
                
                small_letters ();  
                
                jButton_Alpha_.setText("ὰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ὲ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ὴ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ὶ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὸ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὺ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὼ");
                jButton_Omega_.setBackground(mySelected_Color);                
   
            }
        }
        
    }//GEN-LAST:event_jButton_varia_ActionPerformed

    private void jButton_psili_oxia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_oxia_ActionPerformed
        
        jButton_psili_oxia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_oxia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_oxia_;        
        
        if (backup_Letter==("psili_oxia")) {
             jButton_psili_oxia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_oxia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();  
            
                jButton_Alpha_.setText("ἄ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἔ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἤ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἴ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὄ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὔ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὤ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

               big_letters ();

                jButton_Alpha_.setText("Ἄ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἔ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἤ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἴ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὄ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὤ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){   

                big_letters ();

                jButton_Alpha_.setText("Ἄ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἔ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἤ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἴ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὄ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὤ");
                jButton_Omega_.setBackground(mySelected_Color);
            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ἄ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἔ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἤ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἴ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὄ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὔ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὤ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
        }
        
    }//GEN-LAST:event_jButton_psili_oxia_ActionPerformed

    private void jButton_psili_varia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_varia_ActionPerformed
        
        jButton_psili_varia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_varia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_varia_;        
        
        if (backup_Letter==("psili_varia")) {
             jButton_psili_varia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_varia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ἂ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἒ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἢ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἲ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὂ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὒ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὢ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ἂ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἒ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἢ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἲ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὂ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὢ");
                jButton_Omega_.setBackground(mySelected_Color);
        
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("Ἂ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἒ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἢ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἲ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὂ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὢ");
                jButton_Omega_.setBackground(mySelected_Color);
            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ἂ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἒ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἢ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἲ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὂ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὒ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὢ");
                jButton_Omega_.setBackground(mySelected_Color);
            
            }
        }
        
    }//GEN-LAST:event_jButton_psili_varia_ActionPerformed

    private void jButton_dasia_varia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_varia_ActionPerformed
        
        jButton_dasia_varia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_varia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_varia_;        
        
        if (backup_Letter==("dasia_varia")) {
             jButton_dasia_varia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_varia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
            
                jButton_Alpha_.setText("ἃ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἓ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἣ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἳ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὃ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὓ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὣ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ἃ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἓ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἣ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἳ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὃ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὓ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὣ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("Ἃ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἓ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἣ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἳ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὃ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὓ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὣ");
                jButton_Omega_.setBackground(mySelected_Color);
            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ἃ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἓ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἣ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἳ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὃ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὓ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὣ");
                jButton_Omega_.setBackground(mySelected_Color);
  
            }
        }
        
    }//GEN-LAST:event_jButton_dasia_varia_ActionPerformed

    private void jButton_dasia_oxia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_oxia_ActionPerformed
        
        jButton_dasia_oxia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_oxia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_oxia_;
        
        if (backup_Letter==("dasia_oxia")) {
             jButton_dasia_oxia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_oxia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ἅ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἕ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἥ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἵ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὅ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὕ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὥ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ἅ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἕ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἥ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἵ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὅ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὕ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὥ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
           
               
        else if (flag_caps==true){
            if (flag_shift==false){  

                big_letters ();

                jButton_Alpha_.setText("Ἅ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Ἕ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἥ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἵ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ὅ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὕ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὥ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ἅ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("ἕ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἥ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἵ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ὅ");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὕ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὥ");
                jButton_Omega_.setBackground(mySelected_Color);

             }
        }
        
    }//GEN-LAST:event_jButton_dasia_oxia_ActionPerformed

    private void jButton_tonos_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tonos_ActionPerformed
         
        jButton_tonos_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_tonos_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_tonos_;        
        
        if (backup_Letter==("tonos")) {
             jButton_tonos_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("tonos");
        }
        
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ί");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ώ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ί");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ώ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
                
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("Ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("Έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ί");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("Ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ώ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ά");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Epsilon_.setText("έ");
                jButton_Epsilon_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ή");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ί");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omikron_.setText("ό");
                jButton_Omikron_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ύ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ώ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
        }
        
    }//GEN-LAST:event_jButton_tonos_ActionPerformed

    private void jButton_perispomeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_perispomeni_ActionPerformed
                   
        jButton_perispomeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_perispomeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_perispomeni_;        
        
        if (backup_Letter==("perispomeni")) {
             jButton_perispomeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("perispomeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ᾶ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῆ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ῖ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῦ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῶ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
            else {

                big_letters ();
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ᾶ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῆ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ῖ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῦ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῶ");
                jButton_Omega_.setBackground(mySelected_Color);            

            }
        }
        
    }//GEN-LAST:event_jButton_perispomeni_ActionPerformed

    private void jButton_psili_perismpomeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_perismpomeni_ActionPerformed
        
        jButton_psili_perismpomeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_perismpomeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_perismpomeni_;        
        
        if (backup_Letter==("psili_perismpomeni")) {
             jButton_psili_perismpomeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_perismpomeni");
        }        
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ἆ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἦ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἶ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὖ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὦ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ἆ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἦ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἶ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὦ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
                
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("Ἆ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἦ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἶ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὦ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ἆ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἦ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἶ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὖ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὦ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
        }
        
    }//GEN-LAST:event_jButton_psili_perismpomeni_ActionPerformed

    private void jButton_dasia_perispomeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_perispomeni_ActionPerformed
        
        jButton_dasia_perispomeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_perispomeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_perispomeni_;        
        
        if (backup_Letter==("dasia_perispomeni")) {
             jButton_dasia_perispomeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_perispomeni");
        }  
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
            
                jButton_Alpha_.setText("ἇ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἧ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἷ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὗ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὧ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ἇ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἧ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἷ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὗ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὧ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){   

                big_letters ();

                jButton_Alpha_.setText("Ἇ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("Ἧ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ἷ");    
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ὗ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("Ὧ");
                jButton_Omega_.setBackground(mySelected_Color);
            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ἇ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ἧ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ἷ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ὗ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ὧ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
        }
        
    }//GEN-LAST:event_jButton_dasia_perispomeni_ActionPerformed

    private void jButton_dialytika_oxia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dialytika_oxia_ActionPerformed

        jButton_dialytika_oxia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dialytika_oxia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dialytika_oxia_;        
        
        if (backup_Letter==("dialytika_oxia")) {
             jButton_dialytika_oxia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dialytika_oxia");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Iota_.setText("ΐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ΰ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();
            }
            else {

                small_letters ();  
                
                jButton_Iota_.setText("ΐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ΰ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_dialytika_oxia_ActionPerformed

    private void jButton_dialytika_varia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dialytika_varia_ActionPerformed
     
        jButton_dialytika_varia_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dialytika_varia_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dialytika_varia_;        
        
        if (backup_Letter==("dialytika_varia")) {
             jButton_dialytika_varia_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dialytika_varia");
        }
                
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Iota_.setText("ῒ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῢ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

            }
            else {

                small_letters ();  

                jButton_Iota_.setText("ῒ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῢ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                
         
            }
        }
        
    }//GEN-LAST:event_jButton_dialytika_varia_ActionPerformed

    private void jButton_makron_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_makron_ActionPerformed
        
        jButton_makron_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_makron_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_makron_;        
        
        if (backup_Letter==("makron")) {
             jButton_makron_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("makron");
        }  
        
        if (flag_caps==false) {
            if (flag_shift==false){
            
                small_letters ();   
         
                jButton_Alpha_.setText("ᾱ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ῑ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῡ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();    

                jButton_Alpha_.setText("Ᾱ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ῑ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ῡ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
                  
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("Ᾱ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ῑ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ῡ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ᾱ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ῑ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῡ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
 
            }
        }
        
    }//GEN-LAST:event_jButton_makron_ActionPerformed

    private void jButton_oxia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_oxia_ypogegrammeni_ActionPerformed

       jButton_oxia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_oxia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_oxia_ypogegrammeni_;        
        
        if (backup_Letter==("oxia_ypogegrammeni")) {
             jButton_oxia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("oxia_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾴ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῄ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῴ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();
            }
        }
                
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();
            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ᾴ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῄ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῴ");
                jButton_Omega_.setBackground(mySelected_Color);
            
            }
        }
        
    }//GEN-LAST:event_jButton_oxia_ypogegrammeni_ActionPerformed

    private void jButton_psili_oxia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_oxia_ypogegrammeni_ActionPerformed
 
        jButton_psili_oxia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_oxia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_oxia_ypogegrammeni_;        
        
        if (backup_Letter==("psili_oxia_ypogegrammeni")) {
             jButton_psili_oxia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_oxia_ypogegrammeni");
        }    
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾄ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾔ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾤ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();

                jButton_Alpha_.setText("ᾌ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾜ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾬ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("ᾌ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾜ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾬ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ᾄ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾔ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾤ");
                jButton_Omega_.setBackground(mySelected_Color);
            
            }
        }
        
    }//GEN-LAST:event_jButton_psili_oxia_ypogegrammeni_ActionPerformed

    private void jButton_psili_varia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_varia_ypogegrammeni_ActionPerformed
     
        jButton_psili_varia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_varia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_varia_ypogegrammeni_;        
        
        if (backup_Letter==("psili_varia_ypogegrammeni")) {
             jButton_psili_varia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_varia_ypogegrammeni");
        }   
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾂ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾒ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾢ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                big_letters ();

                jButton_Alpha_.setText("ᾊ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾚ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾪ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    

                big_letters ();

                jButton_Alpha_.setText("ᾊ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾚ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾪ");
                jButton_Omega_.setBackground(mySelected_Color);
            }
            else {

                small_letters ();  

                jButton_Alpha_.setText("ᾂ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾒ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾢ");
                jButton_Omega_.setBackground(mySelected_Color);
 
            }
        }
         
    }//GEN-LAST:event_jButton_psili_varia_ypogegrammeni_ActionPerformed

    private void jButton_dasia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_ypogegrammeni_ActionPerformed
        
        jButton_dasia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_ypogegrammeni_;        
        
        if (backup_Letter==("dasia_ypogegrammeni")) {
             jButton_dasia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾁ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾑ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾡ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾉ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾙ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾩ");
                jButton_Omega_.setBackground(mySelected_Color);                
         
            }
        }
              
        else if (flag_caps==true){
            if (flag_shift==false){    
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾉ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾙ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾩ");
                jButton_Omega_.setBackground(mySelected_Color);                  
            }
            else {
                
                small_letters ();  

                jButton_Alpha_.setText("ᾁ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾑ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾡ");
                jButton_Omega_.setBackground(mySelected_Color);                
    
            }
        }
        
    }//GEN-LAST:event_jButton_dasia_ypogegrammeni_ActionPerformed

    private void jButton_varia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_varia_ypogegrammeni_ActionPerformed

        jButton_varia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_varia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_varia_ypogegrammeni_;        
        
        if (backup_Letter==("varia_ypogegrammeni")) {
             jButton_varia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("varia_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾲ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῂ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῲ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                big_letters ();
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){  
                
                big_letters ();
            }
            else {
                
                small_letters ();  
                
                jButton_Alpha_.setText("ᾲ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῂ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῲ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
          
    }//GEN-LAST:event_jButton_varia_ypogegrammeni_ActionPerformed

    private void jButton_dasia_varia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_varia_ypogegrammeni_ActionPerformed

        jButton_dasia_varia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_varia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_varia_ypogegrammeni_;        
        
        if (backup_Letter==("dasia_varia_ypogegrammeni")) {
             jButton_dasia_varia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_varia_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾃ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾓ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾣ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾋ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾛ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾫ");
                jButton_Omega_.setBackground(mySelected_Color);                
         
            }
        }
             
        else if (flag_caps==true){
            if (flag_shift==false){  
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾋ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾛ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾫ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
            else {
                
                small_letters ();  
                
                jButton_Alpha_.setText("ᾃ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾓ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾣ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_dasia_varia_ypogegrammeni_ActionPerformed

    private void jButton_dasia_oxia_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_oxia_ypogegrammeni_ActionPerformed

        jButton_dasia_oxia_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_oxia_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_oxia_ypogegrammeni_;        
        
        if (backup_Letter==("dasia_oxia_ypogegrammeni")) {
             jButton_dasia_oxia_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_oxia_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾅ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾕ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾥ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();

                jButton_Alpha_.setText("ᾍ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾝ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾭ");
                jButton_Omega_.setBackground(mySelected_Color);                
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){   
                
                big_letters ();

                jButton_Alpha_.setText("ᾍ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾝ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾭ");
                jButton_Omega_.setBackground(mySelected_Color);                  
            }
            else {
                
                small_letters ();  

                jButton_Alpha_.setText("ᾅ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾕ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾥ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_dasia_oxia_ypogegrammeni_ActionPerformed

    private void jButton_dialytika_tonos_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dialytika_tonos_ActionPerformed

        jButton_dialytika_tonos_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dialytika_tonos_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dialytika_tonos_;        
        
        if (backup_Letter==("dialytika_tonos")) {
             jButton_dialytika_tonos_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dialytika_tonos");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Iota_.setText("ΐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ΰ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    
                
                big_letters ();
                
            }
            else {
                
                small_letters (); 
                
                jButton_Iota_.setText("ΐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ΰ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                
           
            }
        }
        
    }//GEN-LAST:event_jButton_dialytika_tonos_ActionPerformed

    private void jButton_psili_perispomeni_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_psili_perispomeni_ypogegrammeni_ActionPerformed

        jButton_psili_perispomeni_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_psili_perispomeni_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_psili_perispomeni_ypogegrammeni_;        
        
        if (backup_Letter==("psili_perispomeni_ypogegrammeni")) {
             jButton_psili_perispomeni_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("psili_perispomeni_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾆ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾖ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾦ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾎ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾞ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾮ");
                jButton_Omega_.setBackground(mySelected_Color);                
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){  
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾎ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾞ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾮ");
                jButton_Omega_.setBackground(mySelected_Color);                  
                
            }
            else {
                
                small_letters ();  
                
                jButton_Alpha_.setText("ᾆ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾖ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾦ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_psili_perispomeni_ypogegrammeni_ActionPerformed

    private void jButton_dasia_perispomeni_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dasia_perispomeni_ypogegrammeni_ActionPerformed

        jButton_dasia_perispomeni_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dasia_perispomeni_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dasia_perispomeni_ypogegrammeni_;        
        
        if (backup_Letter==("dasia_perispomeni_ypogegrammeni")) {
             jButton_dasia_perispomeni_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dasia_perispomeni_ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾇ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾗ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾧ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾏ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾟ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾯ");
                jButton_Omega_.setBackground(mySelected_Color);                
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){  
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾏ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾟ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾯ");
                jButton_Omega_.setBackground(mySelected_Color);                 
                
            }
            else {
                
                small_letters (); 
                
                jButton_Alpha_.setText("ᾇ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ᾗ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ᾧ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_dasia_perispomeni_ypogegrammeni_ActionPerformed

    private void jButton_ypogegrammeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ypogegrammeni_ActionPerformed

        jButton_ypogegrammeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_ypogegrammeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_ypogegrammeni_;        
        
        if (backup_Letter==("ypogegrammeni")) {
             jButton_ypogegrammeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("ypogegrammeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Alpha_.setText("ᾳ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῃ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῳ");
                jButton_Omega_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾼ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῌ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῼ");
                jButton_Omega_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){    
                
                big_letters ();
                
                jButton_Alpha_.setText("ᾼ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῌ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῼ");
                jButton_Omega_.setBackground(mySelected_Color);                
            }
            else {
                
                small_letters ();  

                jButton_Alpha_.setText("ᾳ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Ita_.setText("ῃ");
                jButton_Ita_.setBackground(mySelected_Color);
                jButton_Omega_.setText("ῳ");
                jButton_Omega_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_ypogegrammeni_ActionPerformed

    private void jButton_dialytika_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dialytika_ActionPerformed

        jButton_dialytika_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dialytika_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dialytika_;        
        
        if (backup_Letter==("dialytika")) {
             jButton_dialytika_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dialytika");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Iota_.setText("ϊ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ϋ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
                
                jButton_Iota_.setText("Ϊ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ϋ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){  
                
                big_letters ();
                
                jButton_Iota_.setText("Ϊ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ϋ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                  
                
            }
            else {
                
                small_letters ();  

                jButton_Iota_.setText("ϊ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ϋ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                

            }
        }
        
    }//GEN-LAST:event_jButton_dialytika_ActionPerformed

    private void jButton_dialytika_perispomeni_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dialytika_perispomeni_ActionPerformed

        jButton_dialytika_perispomeni_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_dialytika_perispomeni_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_dialytika_perispomeni_;        
        
        if (backup_Letter==("dialytika_perispomeni")) {
             jButton_dialytika_perispomeni_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("dialytika_perispomeni");
        }
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
           
                jButton_Iota_.setText("ῗ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῧ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {
                
                big_letters ();
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){ 
                
                big_letters ();
                
            }
            else {
                
                small_letters (); 
                
                jButton_Iota_.setText("ῗ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῧ");
                jButton_Ypsilon_.setBackground(mySelected_Color);                
         
            }
        }
        
    }//GEN-LAST:event_jButton_dialytika_perispomeni_ActionPerformed

    private void jButton_vrachy_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_vrachy_ActionPerformed

        jButton_vrachy_.setBackground(mySelected_Color);
        myColorBtn.setBackground(myBlue_Color);
        myColorBtn= jButton_vrachy_;
        
        flag_tonos_pneyma=true;
        which_button_tonos_pneyma=jButton_vrachy_;        
        
        if (backup_Letter==("vrachy")) {
             jButton_vrachy_.setBackground(mySelected_Color);
        }
        
        else {
            backup_Letter=("vrachy");
        }        
        
        if (flag_caps==false) {
            if (flag_shift==false){
          
                small_letters ();   
         
                jButton_Alpha_.setText("ᾰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ῐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῠ");
                jButton_Ypsilon_.setBackground(mySelected_Color);

            }
            else {

                big_letters ();

                jButton_Alpha_.setText("Ᾰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ῐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ῠ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
         
            }
        }
               
        else if (flag_caps==true){
            if (flag_shift==false){  

                big_letters ();

                jButton_Alpha_.setText("Ᾰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("Ῐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("Ῠ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
            }
            else {

                small_letters ();  
        
                jButton_Alpha_.setText("ᾰ");
                jButton_Alpha_.setBackground(mySelected_Color);
                jButton_Iota_.setText("ῐ");
                jButton_Iota_.setBackground(mySelected_Color);
                jButton_Ypsilon_.setText("ῠ");
                jButton_Ypsilon_.setBackground(mySelected_Color);
         
            }
        }
        
    }//GEN-LAST:event_jButton_vrachy_ActionPerformed

    private void jButton_ctrl_Right_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ctrl_Right_ActionPerformed
        
        if (flag_ctrl==false){
            flag_ctrl=true;    
            jButton_ctrl_Left_.setBackground(mySelected_Color);        
            jButton_ctrl_Right_.setBackground(mySelected_Color);
        }
        else {
            flag_ctrl=false; 
            if (jRadioButton_Theme_.isSelected()==true) {  
                jButton_ctrl_Left_.setBackground(BG_Color_btn);        
                jButton_ctrl_Right_.setBackground(BG_Color_btn);
            }
            else {
                jButton_ctrl_Left_.setBackground(myRed_Color);        
                jButton_ctrl_Right_.setBackground(myRed_Color);
            }
        }
        
    }//GEN-LAST:event_jButton_ctrl_Right_ActionPerformed

    private void jButton_function_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_function_ActionPerformed
   
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_function_.getText(), caretPosition);
        
    }//GEN-LAST:event_jButton_function_ActionPerformed

    private void jButton_right_click_menu_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_right_click_menu_ActionPerformed
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_right_click_menu_.getText(), caretPosition);
        
    }//GEN-LAST:event_jButton_right_click_menu_ActionPerformed

    private void jButton_flag_Win_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_flag_Win_ActionPerformed
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_flag_Win_.getText(), caretPosition);
        
    }//GEN-LAST:event_jButton_flag_Win_ActionPerformed

    private void jButton_symbol_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_symbol_1ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_symbol_1.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_symbol_1ActionPerformed

    private void jButton_symbol_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_symbol_2ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_symbol_2.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_symbol_2ActionPerformed

    private void jButton_slash_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_slash_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();

        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_slash_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_slash_ActionPerformed

    private void jButton_telia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_telia_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_telia_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_telia_ActionPerformed

    private void jButton_komma_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_komma_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_komma_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_komma_ActionPerformed

    private void jButton_right_square_bracket_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_right_square_bracket_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_right_square_bracket_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_right_square_bracket_ActionPerformed

    private void jButton_left_square_bracket_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_left_square_bracket_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_left_square_bracket_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_left_square_bracket_ActionPerformed

    private void jButton_En_Circumflex_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_En_Circumflex_ActionPerformed
    
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_En_Circumflex_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_En_Circumflex_ActionPerformed

    private void jButton_ano_telia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ano_telia_ActionPerformed
        
        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
       
        caretPosition = myTextArea.getCaretPosition();
        getKeyChar_fromButton=("·");
        myTextArea.insert(getKeyChar_fromButton, caretPosition);
        flag_Save=false;
        
        display_positions();
        
    }//GEN-LAST:event_jButton_ano_telia_ActionPerformed

    
    private void jButton_right_shift_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_right_shift_ActionPerformed
    
        if (flag_shift==false) {  //Αν είναι επιλεγμένο το πλήκτρο Shift
            flag_shift=true;    
            //System.out.println("R_Shift: " + jButton_right_shift_.isSelected()
             //            + ", " + "Flag_Shift: "  + flag_shift + ", " + "  altGR: " 
             //           + jButton_altGR_.isSelected() + ", " +  "Flag_altGR: " +  flag_altGR);
            //System.out.println("");
            
            if (flag_altGR==true) {  //Αν το altGR είναι επιλεγμένο
                
                if (jRadioButton_Theme_.isSelected()) { //Αν το θέμα είναι επιλεγμένο
                    buttons_color_theme();
                    jButton_right_shift_.setBackground(mySelected_Color);
                    jButton_left_shift_.setBackground(mySelected_Color);   
                    //jButton_altGR_.setBackground(mySelected_Color);
                    special_symbols_altGR_shift_for_theme();
                    special_symbols_altGR_shift();
                    //System.out.println("Είναι πατημένα τα κουμπιά altGR και Shift");
                    return;
                    
                }
                else {  // Αν το θέμα δεν είναι επιλεγμένο
                    buttons_color();
                    jButton_right_shift_.setBackground(mySelected_Color);  
                    jButton_left_shift_.setBackground(mySelected_Color); 
                    //jButton_altGR_.setBackground(myRed_Color);
                    special_symbols_altGR_shift_for_colors();
                    special_symbols_altGR_shift();
                    //System.out.println("Είναι πατημένα τα κουμπιά altGR και Shift");
                    return;
                } 
            }
        
            else {  //Αν το altGR δεν είναι επιλεγμένο
                //System.out.println("Είναι πατημένο μόνο το κουμπί Shift");
                numbers_disabled();
                
                jButton_right_shift_.setBackground(mySelected_Color);
                jButton_left_shift_.setBackground(mySelected_Color);       
                if (flag_lang==true){
                    symbols_GR_shift();
                    if (flag_caps==false) {
                        big_letters();
                        if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                    }
                    else {
                        small_letters();
                        if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                    }
                }
                else {
                    symbols_UK_shift();
                    if (flag_caps==false) {
                        UK_big_letters();
                        }
                    else {
                        UK_small_letters();
                    }
                }
            }
        }
        
        else { //Αν δεν είναι πατημένο το πλήκτρο Shift
            flag_shift=false;  
            
            if (flag_altGR==true) {  //Αν το altGR είναι επιλεγμένο
                if (jRadioButton_Theme_.isSelected()==true) {   //Αν το θέμα είναι επιλεγμένο
                    buttons_color_theme();
                    jButton_right_shift_.setBackground(BG_Color_btn);
                    jButton_left_shift_.setBackground(BG_Color_btn);   
                    jButton_altGR_.setBackground(mySelected_Color);
                    //call_gray();
                    special_symbols_altGR();
                    special_symbols_altGR_for_theme();
                    //System.out.println("Δεν είναι πατημένο το κουμπί Shift αλλά είναι πατημένο το κουμπί altGR");
                    return;                    
                }
                else {  //Αν το θέμα δεν είναι επιλεγμένο
                    buttons_color();
                    jButton_right_shift_.setBackground(myRed_Color);  
                    jButton_left_shift_.setBackground(myRed_Color); 
                    jButton_altGR_.setBackground(mySelected_Color);
                    //call_gray();
                    special_symbols_altGR();
                    special_symbols_altGR_for_colors();
                    //System.out.println("Δεν είναι πατημένο το κουμπί Shift αλλά είναι πατημένο το κουμπί altGR");
                    return;
                }
            }   
            
            else {  //Αν το altGR δεν είναι επιλεγμένο
                //System.out.println("Δεν είναι πατημένα τα κουμπιά Shift και altGR");
                numbers_enabled();
                if (jRadioButton_Theme_.isSelected()==true) {  //Αν το θέμα είναι επιλεγμένο
                    buttons_color_theme();
                    jButton_right_shift_.setBackground(BG_Color_btn);
                    jButton_left_shift_.setBackground(BG_Color_btn);   
                }
                else {
                    buttons_color();  //Αν το θέμα δεν είναι επιλεγμένο
                    jButton_right_shift_.setBackground(myRed_Color);  
                    jButton_left_shift_.setBackground(myRed_Color);   
                }
                
                if (flag_lang==true){
                symbols_GR();
                if (flag_caps==false) {
                    small_letters();
                    if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                }
                else {
                    big_letters();
                    if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                }
            }
            else {
                symbols_UK();
                if (flag_caps==false) {
                    UK_small_letters();
                    }
                else {
                    UK_big_letters();
                    }
                }
                
            }
            
        }

    }//GEN-LAST:event_jButton_right_shift_ActionPerformed

    private void jButton_left_shift_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_left_shift_ActionPerformed
 
        if (flag_shift==false) {  //Αν είναι επιλεγμένο το πλήκτρο Shift
            flag_shift=true;    
            //System.out.println("L_Shift: " + jButton_left_shift_.isSelected()
                //        + ", " + "Flag_Shift: "  + flag_shift + ", " + "  altGR: " 
                //        + jButton_altGR_.isSelected() + ", " +  "Flag_altGR: " +  flag_altGR);
            //System.out.println("");
            
            if (flag_altGR==true) {  //Αν το altGR είναι επιλεγμένο
                
                if (jRadioButton_Theme_.isSelected()) { //Αν το θέμα είναι επιλεγμένο
                    buttons_color_theme();
                    jButton_right_shift_.setBackground(mySelected_Color);
                    jButton_left_shift_.setBackground(mySelected_Color);   
                    //jButton_altGR_.setBackground(mySelected_Color);
                    special_symbols_altGR_shift_for_theme();
                    special_symbols_altGR_shift();
                    //System.out.println("Είναι πατημένα τα κουμπιά altGR και Shift");
                    return;
                    
                }
                else {  // Αν το θέμα δεν είναι επιλεγμένο
                    buttons_color();
                    jButton_right_shift_.setBackground(mySelected_Color);  
                    jButton_left_shift_.setBackground(mySelected_Color); 
                    //jButton_altGR_.setBackground(myRed_Color);
                    special_symbols_altGR_shift_for_colors();
                    special_symbols_altGR_shift();
                    //System.out.println("Είναι πατημένα τα κουμπιά altGR και Shift");
                    return;
                } 
            }
        
            else {  //Αν το altGR δεν είναι επιλεγμένο
                //System.out.println("Είναι πατημένο μόνο το κουμπί Shift");
                numbers_disabled();
                
                jButton_right_shift_.setBackground(mySelected_Color);
                jButton_left_shift_.setBackground(mySelected_Color);       
                if (flag_lang==true){
                    symbols_GR_shift();
                    if (flag_caps==false) {
                        big_letters();
                        if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                    }
                    else {
                        small_letters();
                        if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                    }
                }
                else {
                    symbols_UK_shift();
                    if (flag_caps==false) {
                        UK_big_letters();
                        }
                    else {
                        UK_small_letters();
                    }
                }
            }
        }
        
        else { //Αν δεν είναι πατημένο το πλήκτρο Shift
            flag_shift=false;  
            
            if (flag_altGR==true) {  //Αν το altGR είναι επιλεγμένο
                if (jRadioButton_Theme_.isSelected()==true) {   //Αν το θέμα είναι επιλεγμένο
                    buttons_color_theme();
                    jButton_right_shift_.setBackground(BG_Color_btn);
                    jButton_left_shift_.setBackground(BG_Color_btn);   
                    jButton_altGR_.setBackground(mySelected_Color);
                    //call_gray();
                    special_symbols_altGR();
                    special_symbols_altGR_for_theme();
                    //System.out.println("Δεν είναι πατημένο το κουμπί Shift αλλά είναι πατημένο το κουμπί altGR");
                    return;                    
                }
                else {  //Αν το θέμα δεν είναι επιλεγμένο
                    buttons_color();
                    jButton_right_shift_.setBackground(myRed_Color);  
                    jButton_left_shift_.setBackground(myRed_Color); 
                    jButton_altGR_.setBackground(mySelected_Color);
                    //call_gray();
                    special_symbols_altGR();
                    special_symbols_altGR_for_colors();
                    //System.out.println("Δεν είναι πατημένο το κουμπί Shift αλλά είναι πατημένο το κουμπί altGR");
                    return;
                }
            }   
            
            else {  //Αν το altGR δεν είναι επιλεγμένο
                //System.out.println("Δεν είναι πατημένα τα κουμπιά Shift και altGR");
                numbers_enabled();
                if (jRadioButton_Theme_.isSelected()==true) {  //Αν το θέμα είναι επιλεγμένο
                    buttons_color_theme();
                    jButton_right_shift_.setBackground(BG_Color_btn);
                    jButton_left_shift_.setBackground(BG_Color_btn);   
                }
                else {
                    buttons_color();  //Αν το θέμα δεν είναι επιλεγμένο
                    jButton_right_shift_.setBackground(myRed_Color);  
                    jButton_left_shift_.setBackground(myRed_Color);   
                }
                
                if (flag_lang==true){
                symbols_GR();
                if (flag_caps==false) {
                    small_letters();
                    if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                }
                else {
                    big_letters();
                    if (flag_tonos_pneyma==true){
                            which_button_tonos_pneyma.doClick();
                        }
                        else {}
                }
            }
            else {
                symbols_UK();
                if (flag_caps==false) {
                    UK_small_letters();
                    }
                else {
                    UK_big_letters();
                    }
                }
                
            }
            
        }
            
    }//GEN-LAST:event_jButton_left_shift_ActionPerformed

    private void jLabel_Flag_LangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Flag_LangMouseClicked
        
            if (flag_lang==true) {
            icon = new ImageIcon("./src/English.png");
            jLabel_Flag_Lang.setIcon(icon);
            flag_lang=false;
            flag_altGR=false;  
            jButton_altGR_.setEnabled(false);
            jButton_caps_.setEnabled(true);
            jButton_left_shift_.setEnabled(true);
            jButton_right_shift_.setEnabled(true);

          
            numbers_enabled();
            tonoi_pneymata_disabled();
            jButton_Broom_.setEnabled(false);
            
                if (flag_caps==false){
                    if (flag_shift==false) {
                        symbols_UK();
                        UK_small_letters();
                    }
                    else {
                        symbols_UK_shift();
                        UK_big_letters();
                    }
                }
                else {
                    if (flag_shift==false) {
                        symbols_UK();
                        UK_big_letters();
                    }
                    else {
                        symbols_UK_shift();
                        UK_small_letters();
                    }
                }
            }
            
            else {
            icon = new ImageIcon("./src/Greek.png");
            jLabel_Flag_Lang.setIcon(icon);
            flag_lang=true;
            jButton_altGR_.setEnabled(true);
             if (jRadioButton_Theme_.isSelected()==true) {  
                jButton_altGR_.setBackground(BG_Color_btn); 
            }
            else {
                jButton_altGR_.setBackground(myRed_Color);   
            }

            numbers_enabled();
            tonoi_pneymata(); 
            tonoi_pneymata_enabled();

            jButton_Broom_.setEnabled(true);
            
            if (flag_caps==false){
                    if (flag_shift==false) {
                        symbols_GR();
                        small_letters();
                    }
                    else {
                        symbols_GR_shift();
                        big_letters();
                    }
                }
                else {
                    if (flag_shift==false) {
                        symbols_GR();
                        big_letters();
                    }
                    else {
                        symbols_GR_shift();
                        small_letters();
                    }
                }
            }
      
    }//GEN-LAST:event_jLabel_Flag_LangMouseClicked

    private void jButton_tab_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tab_ActionPerformed
        
        flag_tab=true;
        temp="";
        getKeyChar_fromButton="";
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert("   ", caretPosition);

        flag_Save=false;
        
        display_positions();
        
    }//GEN-LAST:event_jButton_tab_ActionPerformed

    private void jButton_ctrl_Left_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ctrl_Left_ActionPerformed
        
        if (flag_ctrl==false){
            flag_ctrl=true;    
            jButton_ctrl_Left_.setBackground(mySelected_Color);        
            jButton_ctrl_Right_.setBackground(mySelected_Color);
        }
        else {
            flag_ctrl=false; 
            if (jRadioButton_Theme_.isSelected()==true) {  
                jButton_ctrl_Left_.setBackground(BG_Color_btn);        
                jButton_ctrl_Right_.setBackground(BG_Color_btn);
            }
            else {
                jButton_ctrl_Left_.setBackground(myRed_Color);        
                jButton_ctrl_Right_.setBackground(myRed_Color);
            }
        }
            
        
    }//GEN-LAST:event_jButton_ctrl_Left_ActionPerformed

    private void jButton_altGR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_altGR_ActionPerformed
    
        if (flag_lang==true){
            
            if (flag_altGR==false) {  //Αν το κουμπί altGR είναι επιλεγμένο
                flag_altGR=true; 
                tonoi_pneymata_disabled();
                jButton_caps_.setEnabled(false);
                flag_caps=false;
                if (jRadioButton_Theme_.isSelected()){ // Αν το θέμα είναι επιλεγμένο
                    jButton_caps_.setBackground(BG_Color_btn);
                }
                else {
                jButton_caps_.setBackground(myRed_Color);
                }
        
                //System.out.println("R_Shift: " + jButton_right_shift_.isSelected()
                //        + ", " + "Flag_Shift: "  + flag_shift + ", " + "  altGR: " 
                //        + jButton_altGR_.isSelected() + ", " +  "Flag_altGR: " +  flag_altGR);
                //System.out.println("");
            
                without_chars();
                
                if (flag_shift==true){ //Αν το κουμπί Shift είναι επιλεγμένο
                    if (jRadioButton_Theme_.isSelected()){ // Αν το θέμα είναι επιλεγμένο
                        buttons_color_theme();
                        jButton_altGR_.setBackground(mySelected_Color);
                        special_symbols_altGR_shift();
                        special_symbols_altGR_shift_for_theme();
                    }
                    else {  // Αν το θέμα δεν είναι επιλεγμένο
                        buttons_color(); 
                        jButton_altGR_.setBackground(mySelected_Color);
                        special_symbols_altGR_shift();
                        special_symbols_altGR_shift_for_colors();
                    }
                }
            
                else { //Αν το κουμπί Shift δεν είναι επιλεγμένο
                    if (jRadioButton_Theme_.isSelected()){ // Αν το θέμα είναι επιλεγμένο
                        buttons_color_theme();
                        jButton_altGR_.setBackground(mySelected_Color);
                        special_symbols_altGR();
                        special_symbols_altGR_for_theme();
                    }
                    else {  // Αν το θέμα δεν είναι επιλεγμένο
                        buttons_color(); 
                        jButton_altGR_.setBackground(mySelected_Color);
                        special_symbols_altGR();
                        special_symbols_altGR_for_colors();
                    }
                }
            }
        else {   //Αν το κουμπί altGR δεν είναι επιλεγμένο
            flag_altGR=false;
            which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
            flag_tonos_pneyma=false;            
            
            if (jRadioButton_Theme_.isSelected()){ // Αν το θέμα είναι επιλεγμένο
                buttons_color_theme();
                jButton_altGR_.setBackground(BG_Color_btn);
            }
            else {
                buttons_color();
                jButton_altGR_.setBackground(myRed_Color);
            }
                
            
            if (flag_shift==true){ //Αν το κουμπί Shift είναι επιλεγμένο    
                
                //System.out.println("Είναι πατημένο μόνο το κουμπί Shift");
                numbers_disabled();
                jButton_caps_.setEnabled(true);
                
                if (flag_lang==true){
                    symbols_GR_shift();
                    tonoi_pneymata_enabled();
                    if (flag_caps==false) {
                        big_letters();
                    }
                    else {
                        small_letters();
                    }
                }
                else {
                    symbols_UK_shift();
                    if (flag_caps==false) {
                        UK_big_letters();
                        }
                    else {
                        UK_small_letters();
                    }
                }
            }
            else { //Αν το κουμπί Shift δεν είναι επιλεγμένο 
                without_chars();
                small_letters();
                tonoi_pneymata(); 
                numbers_enabled();
                tonoi_pneymata_enabled();
                jButton_caps_.setEnabled(true);
                jButton_En_Circumflex_.setText("~");
                jButton_equal_.setText("=");
                jButton_letter_Q_.setText(";");
                jButton_left_square_bracket_.setText("[");
                jButton_right_square_bracket_.setText("]");
                jButton_backward_slash_.setText("\\");
                jButton_symbol_1.setText("΄");
                jButton_symbol_2.setText("'");
                jButton_komma_.setText(",");
                jButton_telia_.setText(".");
                jButton_slash_.setText("/");
            }
                
            }
        }
    
    }//GEN-LAST:event_jButton_altGR_ActionPerformed

    private void jButton_SaveAs_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveAs_ActionPerformed

        Editor_or_VirtualKeyboard=true;
        
        VKglobal_myTextArea=myTextArea.getText();
        
        //System.out.println("");
        //System.out.println("<< Save as >>");
        //System.out.println("\n");
        //System.out.println("Ἐπιλέχτηκε τὸ Εἰκονικὸ πληκτρολόγιο: " + "( " + Editor_or_VirtualKeyboard + " )" );
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
        setTitle(the_prog_lang_is + ": "  + myCurrentFile.getName());
        
    }//GEN-LAST:event_jButton_SaveAs_ActionPerformed

    private void jButton_OpenFile_VK_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpenFile_VK_ActionPerformed
      
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
         
    }//GEN-LAST:event_jButton_OpenFile_VK_ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
           
            Editor_or_VirtualKeyboard=true;
            
            //System.out.println("\n");
            //System.out.println("Ἐπιλέχτηκε τὸ Εἰκονικὸ πληκτρολόγιο: " + "( " + Editor_or_VirtualKeyboard + " )" );
            //System.out.println("\n");            
        
            myTextArea.setLineWrap(true);
            myTextArea.setWrapStyleWord(true);
            
            temp="";
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
            jPanel_Virtual_Keyboard_.setBackground(mycolor);
            
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
            jButton_OpenFile_VK_.setBackground(BG_Color_btn);
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
            jButton_ForegroundColor_.setBackground(FG_Color_btn);   
            jButton_BackgroundColor_.setBackground(BG_Color_list);
            jButton_Black_White_.setBackground(BG_Color_btn);
            jLabel_LinePosition_.setBackground(BG_Color_btn);
            jTextField_LinePosition_.setBackground(BG_Color_btn);
            jLabel_ColumnPosition_.setBackground(BG_Color_btn);
            jTextField_ColumnPosition_.setBackground(BG_Color_btn);
            jLabel_CaretPosition_.setBackground(BG_Color_btn);
            jTextField_CaretPosition_.setBackground(BG_Color_btn);
            jButton_Up_.setBackground(myPurple_Color);
            jButton_Down_.setBackground(myPurple_Color);
            jButton_Left_.setBackground(myPurple_Color);
            jButton_Right_.setBackground(myPurple_Color);
            jButton_ctrl_Left_.setBackground(myRed_Color);        
            jButton_ctrl_Right_.setBackground(myRed_Color);
            jButton_Home_.setBackground(myIDHE_Color);
            jButton_End_.setBackground(myIDHE_Color);
            
            jButton_Up_.setForeground(Color.black);
            jButton_Down_.setForeground(Color.black);
            jButton_Left_.setForeground(Color.black);
            jButton_Right_.setForeground(Color.black);
            jButton_ctrl_Left_.setForeground(Color.black);    
            jButton_ctrl_Right_.setForeground(Color.black);
            jButton_Home_.setForeground(Color.black);
            jButton_End_.setForeground(Color.black);
            jCheckBox_List_.setBackground(BG_Color_btn);
            jButton_NewFile_.setForeground(FG_Color_btn);
            jButton_OpenFile_VK_.setForeground(FG_Color_btn);
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
            jButton_Zoom_Restore_.setForeground(FG_Color_btn);
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
            jComboBox_SystemFonts_.setRenderer(new Virtual_Keyboard.CustomComboBoxRenderer());
            
            jComboBox_FontSize_.setBackground(BG_Color_btn);
            jComboBox_FontSize_.setForeground(FG_Color_btn);     
            jComboBox_FontSize_.setRenderer(new Virtual_Keyboard.CustomComboBoxRenderer());
           
            jButton_Enable_JList_.setToolTipText(sosMessageDis);
            jButton_Original_Ver_.setToolTipText(OriginalVersion);

            Scanner spathML = new Scanner(fileSetMyLang);
            
            setMyLang=(spathML.nextLine());
            this.setTitle(setMyLang);
            the_prog_lang_is=setMyLang;
            
            setMyLang=(spathML.nextLine());
            jButton_NewFile_.setToolTipText(setMyLang);
            
            setMyLang=(spathML.nextLine());
            jButton_OpenFile_VK_.setToolTipText(setMyLang);
            
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
            jRadioButton_Color_.setText(setMyLang);
            
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
            jButton_Broom_.setToolTipText(setMyLang);

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
            backupMySelColor=mySelColor;
            jButton_myColorChooser_.setBackground(mySelColor);
            myJList.setSelectionBackground(mySelColor);
            jButton_LeftAlignment_.setBackground(mySelColor);
            jButton_Text_Warp_.setBackground(mySelColor);
            myTextArea.setSelectionColor(mySelected_Color);
            
        }
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        myThemeGroup.add(jRadioButton_Color_);
        myThemeGroup.add(jRadioButton_Theme_);
        jRadioButton_Color_.setSelected(true);
        jRadioButton_Color_.setForeground(FG_Color_btn);
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

    private void jRadioButton_Theme_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Theme_ActionPerformed

        if (flag_lang==true) {
            reload_greek_vowels();
            numbers_enabled();
        }
        
        buttons_color_theme();
        
        myJList.setBackground(BG_Color_list);
        myJList.setForeground(FG_Color_btn);
        
        jButton_ForegroundColor_.setBackground(FG_Color_btn);   
        jButton_BackgroundColor_.setBackground(BG_Color_list);
        
        myTextArea.setBackground(BG_Color_list);
        myTextArea.setForeground(FG_Color_btn);
        myTextArea.setCaretColor(FG_Color_btn);
        
        jButton_caps_.setBackground(BG_Color_btn);
        jButton_caps_.setForeground(FG_Color_btn);
        jButton_caps_.setEnabled(true);
        jButton_caps_.setSelected(false);
        flag_caps=false;
        
        jButton_left_shift_.setBackground(BG_Color_btn);
        jButton_left_shift_.setForeground(FG_Color_btn);
        jButton_left_shift_.setSelected(false);
        jButton_right_shift_.setBackground(BG_Color_btn);
        jButton_right_shift_.setForeground(FG_Color_btn);
        jButton_right_shift_.setSelected(false);
        flag_shift=false;
        
        jButton_altGR_.setBackground(BG_Color_btn);
        jButton_altGR_.setForeground(FG_Color_btn);
        jButton_altGR_.setEnabled(true);
        jButton_altGR_.setSelected(false);
        flag_altGR=false;
        
        jButton_ctrl_Left_.setBackground(BG_Color_btn);
        jButton_ctrl_Left_.setSelected(false);
        jButton_ctrl_Right_.setBackground(BG_Color_btn);
        jButton_ctrl_Right_.setSelected(false);
        
        jButton_Insert_.setBackground(BG_Color_btn);
        jButton_Insert_.setSelected(false);
        jButton_Delete_.setBackground(BG_Color_btn);
        jButton_Delete_.setSelected(false);
        
        which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
        flag_tonos_pneyma=false;   
            
    }//GEN-LAST:event_jRadioButton_Theme_ActionPerformed

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
        
        if (flag_caps==true) {
            jButton_caps_.setBackground(mySelected_Color);
        }
        else {
            
        }
        
        if (flag_shift==true) {
            jButton_left_shift_.setBackground(mySelected_Color);
            jButton_right_shift_.setBackground(mySelected_Color);
        }
        else {
            
        }
        
        if (flag_altGR==true) {
            jButton_altGR_.setBackground(mySelected_Color);
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
            
        }
        
        if (flag_ctrl==true){
            jButton_ctrl_Left_.setBackground(mySelected_Color);
            jButton_ctrl_Right_.setBackground(mySelected_Color);
        }
        else {
            
        }
        
        if (flag_Insert==true) {
            jButton_Insert_.setBackground(mySelected_Color);
        }
        else {
            
        }
        
        
    }//GEN-LAST:event_jButton_myColorChooser_ActionPerformed

    private void jRadioButton_Color_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Color_ActionPerformed
        
        if (flag_lang==true) {
            reload_greek_vowels();
            numbers_enabled();
           
        }
        
        buttons_color ();
         
        jButton_caps_.setBackground(myRed_Color);
        jButton_caps_.setForeground(Color.black);
        jButton_caps_.setEnabled(true);
        jButton_caps_.setSelected(false);
        flag_caps=false;
        
        jButton_left_shift_.setBackground(myRed_Color);
        jButton_left_shift_.setForeground(Color.black);
        jButton_left_shift_.setSelected(false);
        jButton_right_shift_.setBackground(myRed_Color);
        jButton_right_shift_.setForeground(Color.black);
        jButton_right_shift_.setSelected(false);
        flag_shift=false;
        
        jButton_altGR_.setBackground(myRed_Color);
        jButton_altGR_.setForeground(Color.black);
        jButton_altGR_.setEnabled(true);
        jButton_altGR_.setSelected(false);
        flag_altGR=false;
        
        jButton_ctrl_Left_.setBackground(myRed_Color);
        jButton_ctrl_Left_.setSelected(false);
        jButton_ctrl_Right_.setBackground(myRed_Color);
        jButton_ctrl_Right_.setSelected(false);

        jButton_Insert_.setBackground(myIDHE_Color);
        jButton_Insert_.setSelected(false);
        jButton_Delete_.setBackground(myIDHE_Color);
        jButton_Delete_.setSelected(false);

        which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
        flag_tonos_pneyma=false;          
        
    }//GEN-LAST:event_jRadioButton_Color_ActionPerformed

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

    private void jButton_Save_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Save_ActionPerformed

        Editor_or_VirtualKeyboard=true;
        
        //System.out.println("");
        //System.out.println("<< Save >>");
        //System.out.println("\n");
        //System.out.println("Ἐπιλέχτηκε τὸ Εἰκονικὸ πληκτρολόγιο: " + "( " + Editor_or_VirtualKeyboard + " )" );
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

    private void jButton_letter_Q_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_letter_Q_ActionPerformed

        if (flag_Insert==true) {
            delete_char_and_Insert();
        }
        else {}
       
        delete_selected_text();
        
        caretPosition = myTextArea.getCaretPosition();
        myTextArea.insert(jButton_letter_Q_.getText(), caretPosition);
        flag_Save=false;
        jButton_Save_.setIcon(noSaveIcon);
        
        display_positions();
        
    }//GEN-LAST:event_jButton_letter_Q_ActionPerformed

    private void jButton_LeftAlignment_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LeftAlignment_ActionPerformed
        
        myTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jButton_LeftAlignment_.setBackground(mySelected_Color);
        jButton_RightAlignment_.setBackground(BG_Color_btn);
        flag_Right_Orientation=false;
        
    }//GEN-LAST:event_jButton_LeftAlignment_ActionPerformed

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

    private void jButton_RightAlignment_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RightAlignment_ActionPerformed
        
        myTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jButton_RightAlignment_.setBackground(mySelected_Color);
        jButton_LeftAlignment_.setBackground(BG_Color_btn);
        flag_Right_Orientation=true;
        
    }//GEN-LAST:event_jButton_RightAlignment_ActionPerformed

    private void jButton_Zoom_Increase_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zoom_Increase_ActionPerformed

        Font currentFont=myTextArea.getFont();
        myTextArea.setFont(new Font(
        currentFont.getName(), 
        currentFont.getStyle(), 
        currentFont.getSize()+1));
        
    }//GEN-LAST:event_jButton_Zoom_Increase_ActionPerformed

    private void jButton_Zoom_Decrease_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zoom_Decrease_ActionPerformed

        Font currentFont=myTextArea.getFont();
        myTextArea.setFont(new Font(
        currentFont.getName(), 
        currentFont.getStyle(), 
        currentFont.getSize()-1));   
        
    }//GEN-LAST:event_jButton_Zoom_Decrease_ActionPerformed

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

    private void jCheckBox_List_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_List_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_List_ActionPerformed

    private void jButton_Zoom_Restore_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Zoom_Restore_ActionPerformed
        
        Font currentFont=myTextArea.getFont();
        myTextArea.setFont(new Font(
        currentFont.getName(), 
        currentFont.getStyle(), 
        SelectedFontSize));		
        
    }//GEN-LAST:event_jButton_Zoom_Restore_ActionPerformed

    private void jButton_Cut_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cut_ActionPerformed
       
        mySelectedText = myTextArea.getSelectedText();
            if (mySelectedText != null) {
            myTextArea.cut();
            }
            
        
    }//GEN-LAST:event_jButton_Cut_ActionPerformed

    private void jButton_ForegroundColor_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ForegroundColor_ActionPerformed
        
        Color_for_myTextArea=JColorChooser.showDialog(null, "Παλέτα χρωμάτων", mySelected_Color);
        
        if (Color_for_myTextArea==null){
            Color_for_myTextArea=(Color.black);
        }
        jButton_ForegroundColor_.setBackground(Color_for_myTextArea);
        myTextArea.setForeground(Color_for_myTextArea);
        myTextArea.setCaretColor(Color_for_myTextArea);
        
    }//GEN-LAST:event_jButton_ForegroundColor_ActionPerformed

    private void jButton_BackgroundColor_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackgroundColor_ActionPerformed
        
        Color_for_myTextArea=JColorChooser.showDialog(null, "Παλέτα χρωμάτων", mySelected_Color);
        if (Color_for_myTextArea==null){
            Color_for_myTextArea=(Color.white);
        }
        jButton_BackgroundColor_.setBackground(Color_for_myTextArea);
        myTextArea.setBackground(Color_for_myTextArea);
        
    }//GEN-LAST:event_jButton_BackgroundColor_ActionPerformed

    private void jButton_Black_White_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Black_White_ActionPerformed
         
        myTextArea.setForeground(Color.black);
        myTextArea.setBackground(Color.white);
        jButton_ForegroundColor_.setBackground(Color.black);
        myTextArea.setCaretColor(Color.black);
        jButton_BackgroundColor_.setBackground(Color.white);
        
    }//GEN-LAST:event_jButton_Black_White_ActionPerformed

    private void jButton_Broom_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Broom_ActionPerformed
        
        reload_greek_vowels();
        
        which_button_tonos_pneyma.setBackground(tonos_pneyma_Color);
        flag_tonos_pneyma=false;
        
    }//GEN-LAST:event_jButton_Broom_ActionPerformed

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

    private void jButton_Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete_ActionPerformed
        
        mySelectedText = myTextArea.getSelectedText();
      
        if (mySelectedText != null) {
            myTextArea.replaceSelection("");

        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }            
            
            display_positions();
            return;
        }
        
        if (myTextArea.getCaretPosition() < myTextArea.getText().length()){
            int start = myTextArea.getCaretPosition();
            int end = myTextArea.getCaretPosition()+1;

            myTextArea.replaceRange(null, start, end);
            myTextArea.setCaretPosition(myTextArea.getCaretPosition());
            
        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }            

            display_positions();
        }
        else {
            return;
        }
            
            
    }//GEN-LAST:event_jButton_Delete_ActionPerformed

    private void jButton_Home_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Home_ActionPerformed
        
        if (flag_ctrl==false) {
            try {
                lineNumber = myTextArea.getLineOfOffset(caretPosition);
            } 
            catch (BadLocationException ex) {
                Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            position = myTextArea.getDocument().getDefaultRootElement().getElement(lineNumber).getStartOffset();
            myTextArea.setCaretPosition(position);
            caretPosition=position;
        }
        
        else {
                myTextArea.setCaretPosition(0);
        }

        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }        
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Home_ActionPerformed

    private void jButton_End_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_End_ActionPerformed

        caretPosition = myTextArea.getCaretPosition();
         
        if (flag_ctrl==false) {
            try {
                lineNumber = myTextArea.getLineOfOffset(caretPosition);
                difference=myTextArea.getLineEndOffset(lineNumber) - myTextArea.getLineStartOffset(lineNumber) - 1;
                //System.out.println(difference);
                position = myTextArea.getDocument().getDefaultRootElement().getElement(lineNumber).getStartOffset();
            }
            catch (BadLocationException ex) {
                Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            myTextArea.setCaretPosition(position + difference);
        }
        
        else {
            position=myTextArea.getText().length();
            myTextArea.setCaretPosition(position-1);
        }

        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }
        
        display_positions();
        
    }//GEN-LAST:event_jButton_End_ActionPerformed

    private void jButton_Insert_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Insert_ActionPerformed
                
        if (flag_Insert==false){
            flag_Insert=true;    
            jButton_Insert_.setBackground(mySelected_Color);
            myTextArea.putClientProperty("caretWidth", 8);
              
                    }
        else {
            flag_Insert=false;
            myTextArea.putClientProperty("caretWidth", 1);
             
            if (jRadioButton_Theme_.isSelected()==true) {  
                jButton_Insert_.setBackground(BG_Color_btn); 
            }
            else {
                jButton_Insert_.setBackground(myIDHE_Color);   
            }
            
        }
        
    }//GEN-LAST:event_jButton_Insert_ActionPerformed

    private void jTextField_ColumnPosition_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ColumnPosition_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ColumnPosition_ActionPerformed

    private void myTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTextAreaMouseClicked

        temp="";
        display_positions();
        
    }//GEN-LAST:event_myTextAreaMouseClicked

    private void myTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myTextAreaKeyReleased

        temp="";
        display_positions();
        
    }//GEN-LAST:event_myTextAreaKeyReleased

    private void jButton_Up_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Up_ActionPerformed

        if (lineNumber==1) {
            return;
        }
        try {
            lineNumber = myTextArea.getLineOfOffset(caretPosition);
            lineNumber=lineNumber - 1;
                        
        } 
        catch (BadLocationException ex) {
            Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        position = myTextArea.getDocument().getDefaultRootElement().getElement(lineNumber).getStartOffset(); // Σὲ πηγαίνει στὴν ἀρχὴ τῆς γραμμῆς
        myTextArea.setCaretPosition(position);
        caretPosition=position;
        
        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {
           
       }        
        
        display_positions();
            
    }//GEN-LAST:event_jButton_Up_ActionPerformed

    private void jButton_Down_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Down_ActionPerformed

        if (lineNumber==myTextArea.getLineCount()-1) {
            return;
        }
        try {
            lineNumber = myTextArea.getLineOfOffset(caretPosition);
            lineNumber=lineNumber + 1;
          
        } 
        catch (BadLocationException ex) {
            Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           
        position = myTextArea.getDocument().getDefaultRootElement().getElement(lineNumber).getStartOffset(); // Σὲ πηγαίνει στὴν ἀρχὴ τῆς γραμμῆς
        //System.out.println(position);
        myTextArea.setCaretPosition(position);
        caretPosition=position;
        
        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }        
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Down_ActionPerformed

    private void jButton_Left_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Left_ActionPerformed

        if (columnNumber==0 && lineNumber==1) {
            return;
        }
        
        myTextArea.setCaretPosition(myTextArea.getCaretPosition() - 1);

        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }
        
        display_positions();
         
    }//GEN-LAST:event_jButton_Left_ActionPerformed

    private void jButton_Right_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Right_ActionPerformed

       try {
        lastColumnNumber=myTextArea.getLineEndOffset(lineNumber);
        lastColumnNumber=lastColumnNumber-1;
        }
        catch (BadLocationException ex) {
            Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        if (lastColumnNumber==myTextArea.getCaretPosition()){
            return;
        }
               
        myTextArea.setCaretPosition(myTextArea.getCaretPosition() + 1);
        

        try {
        
            temp="";
            searchFilter(temp);
        
        }
       
       catch(Exception ex)   {   // Μὴν χρησιμοποιήσεις το IOException (red letters)
           
       }
        
        display_positions();
        
    }//GEN-LAST:event_jButton_Right_ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, InterruptedException, InvocationTargetException{
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
            java.util.logging.Logger.getLogger(Virtual_Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Virtual_Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Virtual_Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Virtual_Keyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {

                    new Virtual_Keyboard().setVisible(true);
                    
                  
                    
                } catch (IOException ex) {
                    Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void small_letters (){
        
        if (jRadioButton_Theme_.isSelected()==true) {    
        
            jButton_Alpha_.setText("α");
            jButton_Alpha_.setBackground(BG_Color_btn);
            jButton_Alpha_.setForeground(FG_Color_btn);
            jButton_Vita_.setText("β");
            jButton_Vita_.setBackground(BG_Color_btn);
            jButton_Vita_.setForeground(FG_Color_btn);
            jButton_Gamma_.setText("γ");
            jButton_Gamma_.setBackground(BG_Color_btn);
            jButton_Gamma_.setForeground(FG_Color_btn);
            jButton_Delta_.setText("δ");
            jButton_Delta_.setBackground(BG_Color_btn);
            jButton_Delta_.setForeground(FG_Color_btn);
            jButton_Epsilon_.setText("ε");
            jButton_Epsilon_.setBackground(BG_Color_btn);
            jButton_Epsilon_.setForeground(FG_Color_btn);
            jButton_Zita_.setText("ζ");
            jButton_Zita_.setBackground(BG_Color_btn);
            jButton_Zita_.setForeground(FG_Color_btn);
            jButton_Ita_.setText("η");
            jButton_Ita_.setBackground(BG_Color_btn);
            jButton_Ita_.setForeground(FG_Color_btn);
            jButton_Thita_.setText("θ");
            jButton_Thita_.setBackground(BG_Color_btn);
            jButton_Thita_.setForeground(FG_Color_btn);
            jButton_Iota_.setText("ι");
            jButton_Iota_.setBackground(BG_Color_btn);
            jButton_Iota_.setForeground(FG_Color_btn);
            jButton_Kappa_.setText("κ");
            jButton_Kappa_.setBackground(BG_Color_btn);
            jButton_Kappa_.setForeground(FG_Color_btn);
            jButton_Lamda_.setText("λ");
            jButton_Lamda_.setBackground(BG_Color_btn);
            jButton_Lamda_.setForeground(FG_Color_btn);
            jButton_Mi_.setText("μ");
            jButton_Mi_.setBackground(BG_Color_btn);
            jButton_Mi_.setForeground(FG_Color_btn);
            jButton_Ni_.setText("ν");
            jButton_Ni_.setBackground(BG_Color_btn);
            jButton_Ni_.setForeground(FG_Color_btn);
            jButton_Ksi_.setText("ξ");
            jButton_Ksi_.setBackground(BG_Color_btn);
            jButton_Ksi_.setForeground(FG_Color_btn);
            jButton_Omikron_.setText("ο");
            jButton_Omikron_.setBackground(BG_Color_btn);
            jButton_Omikron_.setForeground(FG_Color_btn);
            jButton_Pi_.setText("π");
            jButton_Pi_.setBackground(BG_Color_btn);
            jButton_Pi_.setForeground(FG_Color_btn);
            jButton_Ro_.setText("ρ");
            jButton_Ro_.setBackground(BG_Color_btn);
            jButton_Ro_.setForeground(FG_Color_btn);
            jButton_Sigma_.setText("σ");
            jButton_Sigma_.setBackground(BG_Color_btn);
            jButton_Sigma_.setForeground(FG_Color_btn);
            jButton_final_Sigma_.setText("ς");
            jButton_final_Sigma_.setBackground(BG_Color_btn);
            jButton_final_Sigma_.setForeground(FG_Color_btn);
            jButton_Taf_.setText("τ");
            jButton_Taf_.setBackground(BG_Color_btn);
            jButton_Taf_.setForeground(FG_Color_btn);
            jButton_Ypsilon_.setText("υ");
            jButton_Ypsilon_.setBackground(BG_Color_btn);
            jButton_Ypsilon_.setForeground(FG_Color_btn);
            jButton_Phi_.setText("φ");
            jButton_Phi_.setBackground(BG_Color_btn);
            jButton_Phi_.setForeground(FG_Color_btn);
            jButton_Chi_.setText("χ");
            jButton_Chi_.setBackground(BG_Color_btn);
            jButton_Chi_.setForeground(FG_Color_btn);
            jButton_Psi_.setText("ψ");
            jButton_Psi_.setBackground(BG_Color_btn);
            jButton_Psi_.setForeground(FG_Color_btn);
            jButton_Omega_.setText("ω");
            jButton_Omega_.setBackground(BG_Color_btn);
            jButton_Omega_.setForeground(FG_Color_btn);
    
            //jButton_letter_Q_.setText(";");
            jButton_letter_Q_.setBackground(BG_Color_btn);
            jButton_letter_Q_.setForeground(FG_Color_btn);
        }
    
        else {
        
            jButton_Alpha_.setText("α");
            jButton_Alpha_.setBackground(myCyan_Color);
            jButton_Alpha_.setForeground(Color.black);
            jButton_Vita_.setText("β");
            jButton_Vita_.setBackground(myGreen_Color);
            jButton_Vita_.setForeground(Color.black);
            jButton_Gamma_.setText("γ");
            jButton_Gamma_.setBackground(myGreen_Color);
            jButton_Gamma_.setForeground(Color.black);
            jButton_Delta_.setText("δ");
            jButton_Delta_.setBackground(myGreen_Color);
            jButton_Delta_.setForeground(Color.black);
            jButton_Epsilon_.setText("ε");
            jButton_Epsilon_.setBackground(myCyan_Color);
            jButton_Epsilon_.setForeground(Color.black);
            jButton_Zita_.setText("ζ");
            jButton_Zita_.setBackground(myGreen_Color);
            jButton_Zita_.setForeground(Color.black);
            jButton_Ita_.setText("η");
            jButton_Ita_.setBackground(myCyan_Color);
            jButton_Ita_.setForeground(Color.black);
            jButton_Thita_.setText("θ");
            jButton_Thita_.setBackground(myGreen_Color);
            jButton_Thita_.setForeground(Color.black);
            jButton_Iota_.setText("ι");
            jButton_Iota_.setBackground(myCyan_Color);
            jButton_Iota_.setForeground(Color.black);
            jButton_Kappa_.setText("κ");
            jButton_Kappa_.setBackground(myGreen_Color);
            jButton_Kappa_.setForeground(Color.black);
            jButton_Lamda_.setText("λ");
            jButton_Lamda_.setBackground(myGreen_Color);
            jButton_Lamda_.setForeground(Color.black);
            jButton_Mi_.setText("μ");
            jButton_Mi_.setBackground(myGreen_Color);
            jButton_Mi_.setForeground(Color.black);
            jButton_Ni_.setText("ν");
            jButton_Ni_.setBackground(myGreen_Color);
            jButton_Ni_.setForeground(Color.black);
            jButton_Ksi_.setText("ξ");
            jButton_Ksi_.setBackground(myGreen_Color);
            jButton_Ksi_.setForeground(Color.black);
            jButton_Omikron_.setText("ο");
            jButton_Omikron_.setBackground(myCyan_Color);
            jButton_Omikron_.setForeground(Color.black);
            jButton_Pi_.setText("π");
            jButton_Pi_.setBackground(myGreen_Color);
            jButton_Pi_.setForeground(Color.black);
            jButton_Ro_.setText("ρ");
            jButton_Ro_.setBackground(myGreen_Color);
            jButton_Ro_.setForeground(Color.black);
            jButton_Sigma_.setText("σ");
            jButton_Sigma_.setBackground(myGreen_Color);
            jButton_Sigma_.setForeground(Color.black);
            jButton_final_Sigma_.setText("ς");
            jButton_final_Sigma_.setBackground(myGreen_Color);
            jButton_final_Sigma_.setForeground(Color.black);
            jButton_Taf_.setText("τ");
            jButton_Taf_.setBackground(myGreen_Color);
            jButton_Taf_.setForeground(Color.black);
            jButton_Ypsilon_.setText("υ");
            jButton_Ypsilon_.setForeground(Color.black);
            jButton_Ypsilon_.setBackground(myCyan_Color);
            jButton_Phi_.setText("φ");
            jButton_Phi_.setBackground(myGreen_Color);
            jButton_Phi_.setForeground(Color.black);
            jButton_Chi_.setText("χ");
            jButton_Chi_.setBackground(myGreen_Color);
            jButton_Chi_.setForeground(Color.black);
            jButton_Psi_.setText("ψ");
            jButton_Psi_.setBackground(myGreen_Color);
            jButton_Psi_.setForeground(Color.black);
            jButton_Omega_.setText("ω");
            jButton_Omega_.setBackground(myCyan_Color);
            jButton_Omega_.setForeground(Color.black);
    
            //jButton_letter_Q_.setText(";");
            jButton_letter_Q_.setBackground(myPink_Color); 
            jButton_letter_Q_.setForeground(Color.black); 
    
        }
    
    }
    
    private void big_letters (){
 
        if (jRadioButton_Theme_.isSelected()==true) {   
        
            jButton_Alpha_.setText("Α");
            jButton_Alpha_.setBackground(BG_Color_btn);
            jButton_Alpha_.setForeground(FG_Color_btn);
            jButton_Vita_.setText("Β");
            jButton_Vita_.setBackground(BG_Color_btn);
            jButton_Vita_.setForeground(FG_Color_btn);
            jButton_Gamma_.setText("Γ");
            jButton_Gamma_.setBackground(BG_Color_btn);
            jButton_Gamma_.setForeground(FG_Color_btn);
            jButton_Delta_.setText("Δ");
            jButton_Delta_.setBackground(BG_Color_btn);
            jButton_Delta_.setForeground(FG_Color_btn);
            jButton_Epsilon_.setText("Ε");
            jButton_Epsilon_.setBackground(BG_Color_btn);
            jButton_Epsilon_.setForeground(FG_Color_btn);
            jButton_Zita_.setText("Ζ");
            jButton_Zita_.setBackground(BG_Color_btn);
            jButton_Zita_.setForeground(FG_Color_btn);
            jButton_Ita_.setText("Η");
            jButton_Ita_.setBackground(BG_Color_btn);
            jButton_Ita_.setForeground(FG_Color_btn);
            jButton_Thita_.setText("Θ");
            jButton_Thita_.setBackground(BG_Color_btn);
            jButton_Thita_.setForeground(FG_Color_btn);
            jButton_Iota_.setText("Ι");
            jButton_Iota_.setBackground(BG_Color_btn);
            jButton_Iota_.setForeground(FG_Color_btn);
            jButton_Kappa_.setText("Κ");
            jButton_Kappa_.setBackground(BG_Color_btn);
            jButton_Kappa_.setForeground(FG_Color_btn);
            jButton_Lamda_.setText("Λ");
            jButton_Lamda_.setBackground(BG_Color_btn);
            jButton_Lamda_.setForeground(FG_Color_btn);
            jButton_Mi_.setText("Μ");
            jButton_Mi_.setBackground(BG_Color_btn);
            jButton_Mi_.setForeground(FG_Color_btn);
            jButton_Ni_.setText("Ν");
            jButton_Ni_.setBackground(BG_Color_btn);
            jButton_Ni_.setForeground(FG_Color_btn);
            jButton_Ksi_.setText("Ξ");
            jButton_Ksi_.setBackground(BG_Color_btn);
            jButton_Ksi_.setForeground(FG_Color_btn);
            jButton_Omikron_.setText("Ο");
            jButton_Omikron_.setBackground(BG_Color_btn);
            jButton_Omikron_.setForeground(FG_Color_btn);
            jButton_Pi_.setText("Π");
            jButton_Pi_.setBackground(BG_Color_btn);
            jButton_Pi_.setForeground(FG_Color_btn);
            jButton_Ro_.setText("Ρ");
            jButton_Ro_.setBackground(BG_Color_btn);
            jButton_Ro_.setForeground(FG_Color_btn);
            jButton_Sigma_.setText("Σ");
            jButton_Sigma_.setBackground(BG_Color_btn);
            jButton_Sigma_.setForeground(FG_Color_btn);
            jButton_final_Sigma_.setText("ς");
            jButton_final_Sigma_.setBackground(BG_Color_btn);
            jButton_final_Sigma_.setForeground(FG_Color_btn);
            jButton_Taf_.setText("Τ");
            jButton_Taf_.setBackground(BG_Color_btn);
            jButton_Taf_.setForeground(FG_Color_btn);
            jButton_Ypsilon_.setText("Υ");
            jButton_Ypsilon_.setBackground(BG_Color_btn);
            jButton_Ypsilon_.setForeground(FG_Color_btn);
            jButton_Phi_.setText("Φ");
            jButton_Phi_.setBackground(BG_Color_btn);
            jButton_Phi_.setForeground(FG_Color_btn);
            jButton_Chi_.setText("Χ");
            jButton_Chi_.setBackground(BG_Color_btn);
            jButton_Chi_.setForeground(FG_Color_btn);
            jButton_Psi_.setText("Ψ");
            jButton_Psi_.setBackground(BG_Color_btn);
            jButton_Psi_.setForeground(FG_Color_btn);
            jButton_Omega_.setText("Ω");
            jButton_Omega_.setBackground(BG_Color_btn);
            jButton_Omega_.setForeground(FG_Color_btn);
    
           // jButton_letter_Q_.setText(";");
            jButton_letter_Q_.setBackground(BG_Color_btn);
            jButton_letter_Q_.setForeground(FG_Color_btn);
    
        }
    
        else {
    
            jButton_Alpha_.setText("Α");
            jButton_Alpha_.setBackground(myCyan_Color);
            jButton_Alpha_.setForeground(Color.black);
            jButton_Vita_.setText("Β");
            jButton_Vita_.setBackground(myGreen_Color);
            jButton_Vita_.setForeground(Color.black);
            jButton_Gamma_.setText("Γ");
            jButton_Gamma_.setBackground(myGreen_Color);
            jButton_Gamma_.setForeground(Color.black);
            jButton_Delta_.setText("Δ");
            jButton_Delta_.setBackground(myGreen_Color);
            jButton_Delta_.setForeground(Color.black);
            jButton_Epsilon_.setText("Ε");
            jButton_Epsilon_.setBackground(myCyan_Color);
            jButton_Epsilon_.setForeground(Color.black);
            jButton_Zita_.setText("Ζ");
            jButton_Zita_.setBackground(myGreen_Color);
            jButton_Zita_.setForeground(Color.black);
            jButton_Ita_.setText("Η");
            jButton_Ita_.setBackground(myCyan_Color);
            jButton_Ita_.setForeground(Color.black);
            jButton_Thita_.setText("Θ");
            jButton_Thita_.setBackground(myGreen_Color);
            jButton_Thita_.setForeground(Color.black);
            jButton_Iota_.setText("Ι");
            jButton_Iota_.setBackground(myCyan_Color);
            jButton_Iota_.setForeground(Color.black);
            jButton_Kappa_.setText("Κ");
            jButton_Kappa_.setBackground(myGreen_Color);
            jButton_Kappa_.setForeground(Color.black);
            jButton_Lamda_.setText("Λ");
            jButton_Lamda_.setBackground(myGreen_Color);
            jButton_Lamda_.setForeground(Color.black);
            jButton_Mi_.setText("Μ");
            jButton_Mi_.setBackground(myGreen_Color);
            jButton_Mi_.setForeground(Color.black);
            jButton_Ni_.setText("Ν");
            jButton_Ni_.setBackground(myGreen_Color);
            jButton_Ni_.setForeground(Color.black);
            jButton_Ksi_.setText("Ξ");
            jButton_Ksi_.setBackground(myGreen_Color);
            jButton_Ksi_.setForeground(Color.black);
            jButton_Omikron_.setText("Ο");
            jButton_Omikron_.setBackground(myCyan_Color);
            jButton_Omikron_.setForeground(Color.black);
            jButton_Pi_.setText("Π");
            jButton_Pi_.setBackground(myGreen_Color);
            jButton_Pi_.setForeground(Color.black);
            jButton_Ro_.setText("Ρ");
            jButton_Ro_.setBackground(myGreen_Color);
            jButton_Ro_.setForeground(Color.black);
            jButton_Sigma_.setText("Σ");
            jButton_Sigma_.setBackground(myGreen_Color);
            jButton_Sigma_.setForeground(Color.black);
            jButton_final_Sigma_.setText("ς");
            jButton_final_Sigma_.setBackground(myGreen_Color);
            jButton_final_Sigma_.setForeground(Color.black);
            jButton_Taf_.setText("Τ");
            jButton_Taf_.setBackground(myGreen_Color);
            jButton_Taf_.setForeground(Color.black);
            jButton_Ypsilon_.setText("Υ");
            jButton_Ypsilon_.setForeground(Color.black);
            jButton_Ypsilon_.setBackground(myCyan_Color);
            jButton_Phi_.setText("Φ");
            jButton_Phi_.setBackground(myGreen_Color);
            jButton_Phi_.setForeground(Color.black);
            jButton_Chi_.setText("Χ");
            jButton_Chi_.setBackground(myGreen_Color);
            jButton_Chi_.setForeground(Color.black);
            jButton_Psi_.setText("Ψ");
            jButton_Psi_.setBackground(myGreen_Color);
            jButton_Psi_.setForeground(Color.black);
            jButton_Omega_.setText("Ω");
            jButton_Omega_.setBackground(myCyan_Color);
            jButton_Omega_.setForeground(Color.black);
    
            //jButton_letter_Q_.setText(";");
            jButton_letter_Q_.setBackground(myPink_Color); 
            jButton_letter_Q_.setForeground(Color.black); 
    
        }
    }
    
    private void tonoi_pneymata(){
        
        jButton_psili_.setBackground(myBlue_Color);
        jButton_oxia_.setBackground(myBlue_Color);
        jButton_psili_oxia_.setBackground(myBlue_Color);
        jButton_psili_varia_.setBackground(myBlue_Color);
        jButton_dasia_.setBackground(myBlue_Color);
        jButton_varia_.setBackground(myBlue_Color);
        jButton_dasia_varia_.setBackground(myBlue_Color);
        jButton_dasia_oxia_.setBackground(myBlue_Color);
        jButton_tonos_.setBackground(myBlue_Color);
        jButton_perispomeni_.setBackground(myBlue_Color);
        jButton_psili_perismpomeni_.setBackground(myBlue_Color);
        jButton_dasia_perispomeni_.setBackground(myBlue_Color);
        jButton_dialytika_oxia_.setBackground(myBlue_Color);
        jButton_dialytika_varia_.setBackground(myBlue_Color);
        jButton_makron_.setBackground(myBlue_Color);
        jButton_psili_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_oxia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_psili_oxia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_psili_varia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_dasia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_varia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_dasia_varia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_dasia_oxia_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_dialytika_tonos_.setBackground(myBlue_Color);
        jButton_perispomeni_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_psili_perispomeni_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_dasia_perispomeni_ypogegrammeni_.setBackground(myBlue_Color);
        jButton_dialytika_.setBackground(myBlue_Color);
        jButton_dialytika_perispomeni_.setBackground(myBlue_Color);
        jButton_vrachy_.setBackground(myBlue_Color);
        
    }
 
    private void reload_greek_vowels (){

        if (flag_caps==false){
            if (flag_shift==false) {
                small_letters ();
                tonoi_pneymata();
                }

                else {
                big_letters ();
                tonoi_pneymata();        
                }
        }
        
        else {
            if (flag_shift==false) {
                big_letters ();
                tonoi_pneymata();
                }

                else {
                small_letters ();
                tonoi_pneymata();        
                } 
        }
      
    }
    
    private void UK_small_letters (){
   
        if (jRadioButton_Theme_.isSelected()==true) {   
       
            jButton_Alpha_.setText("a");
            jButton_Alpha_.setBackground(BG_Color_btn);
            jButton_Alpha_.setForeground(FG_Color_btn);
            jButton_Vita_.setText("b");
            jButton_Vita_.setBackground(BG_Color_btn);
            jButton_Vita_.setForeground(FG_Color_btn);
            jButton_Gamma_.setText("g");
            jButton_Gamma_.setBackground(BG_Color_btn);
            jButton_Gamma_.setForeground(FG_Color_btn);
            jButton_Delta_.setText("d");
            jButton_Delta_.setBackground(BG_Color_btn);
            jButton_Delta_.setForeground(FG_Color_btn);
            jButton_Epsilon_.setText("e");
            jButton_Epsilon_.setBackground(BG_Color_btn);
            jButton_Epsilon_.setForeground(FG_Color_btn);
            jButton_Zita_.setText("z");
            jButton_Zita_.setBackground(BG_Color_btn);
            jButton_Zita_.setForeground(FG_Color_btn);
            jButton_Ita_.setText("h");
            jButton_Ita_.setBackground(BG_Color_btn);
            jButton_Ita_.setForeground(FG_Color_btn);
            jButton_Thita_.setText("u");
            jButton_Thita_.setBackground(BG_Color_btn);
            jButton_Thita_.setForeground(FG_Color_btn);
            jButton_Iota_.setText("i");
            jButton_Iota_.setBackground(BG_Color_btn);
            jButton_Iota_.setForeground(FG_Color_btn);
            jButton_Kappa_.setText("k");
            jButton_Kappa_.setBackground(BG_Color_btn);
            jButton_Kappa_.setForeground(FG_Color_btn);
            jButton_Lamda_.setText("l");
            jButton_Lamda_.setBackground(BG_Color_btn);
            jButton_Lamda_.setForeground(FG_Color_btn);
            jButton_Mi_.setText("m");
            jButton_Mi_.setBackground(BG_Color_btn);
            jButton_Mi_.setForeground(FG_Color_btn);
            jButton_Ni_.setText("n");
            jButton_Ni_.setBackground(BG_Color_btn);
            jButton_Ni_.setForeground(FG_Color_btn);
            jButton_Ksi_.setText("j");
            jButton_Ksi_.setBackground(BG_Color_btn);
            jButton_Ksi_.setForeground(FG_Color_btn);
            jButton_Omikron_.setText("o");
            jButton_Omikron_.setBackground(BG_Color_btn);
            jButton_Omikron_.setForeground(FG_Color_btn);
            jButton_Pi_.setText("p");
            jButton_Pi_.setBackground(BG_Color_btn);
            jButton_Pi_.setForeground(FG_Color_btn);
            jButton_Ro_.setText("r");
            jButton_Ro_.setBackground(BG_Color_btn);
            jButton_Ro_.setForeground(FG_Color_btn);
            jButton_Sigma_.setText("s");
            jButton_Sigma_.setBackground(BG_Color_btn);
            jButton_Alpha_.setForeground(FG_Color_btn);
            jButton_final_Sigma_.setText("w");
            jButton_final_Sigma_.setBackground(BG_Color_btn);
            jButton_final_Sigma_.setForeground(FG_Color_btn);
            jButton_Taf_.setText("t");
            jButton_Taf_.setBackground(BG_Color_btn);
            jButton_Taf_.setForeground(FG_Color_btn);
            jButton_Ypsilon_.setText("y");
            jButton_Ypsilon_.setBackground(BG_Color_btn);
            jButton_Ypsilon_.setForeground(FG_Color_btn);
            jButton_Phi_.setText("f");
            jButton_Phi_.setBackground(BG_Color_btn);
            jButton_Phi_.setForeground(FG_Color_btn);
            jButton_Chi_.setText("x");
            jButton_Chi_.setBackground(BG_Color_btn);
            jButton_Chi_.setForeground(FG_Color_btn);
            jButton_Psi_.setText("c");
            jButton_Psi_.setBackground(BG_Color_btn);
            jButton_Psi_.setForeground(FG_Color_btn);
            jButton_Omega_.setText("v");
            jButton_Omega_.setBackground(BG_Color_btn);
            jButton_Omega_.setForeground(FG_Color_btn);
    
            jButton_letter_Q_.setText("q");
            jButton_letter_Q_.setBackground(BG_Color_btn);
            jButton_letter_Q_.setForeground(FG_Color_btn);
    
        }
   
        else {
    
            jButton_Alpha_.setText("a");
            jButton_Alpha_.setBackground(myGreen_Color);
            jButton_Alpha_.setForeground(Color.black);
            jButton_Vita_.setText("b");
            jButton_Vita_.setBackground(myGreen_Color);
            jButton_Vita_.setForeground(Color.black);
            jButton_Gamma_.setText("g");
            jButton_Gamma_.setBackground(myGreen_Color);
            jButton_Gamma_.setForeground(Color.black);
            jButton_Delta_.setText("d");
            jButton_Delta_.setBackground(myGreen_Color);
            jButton_Delta_.setForeground(Color.black);
            jButton_Epsilon_.setText("e");
            jButton_Epsilon_.setBackground(myGreen_Color);
            jButton_Epsilon_.setForeground(Color.black);
            jButton_Zita_.setText("z");
            jButton_Zita_.setBackground(myGreen_Color);
            jButton_Zita_.setForeground(Color.black);
            jButton_Ita_.setText("h");
            jButton_Ita_.setBackground(myGreen_Color);
            jButton_Ita_.setForeground(Color.black);
            jButton_Thita_.setText("u");
            jButton_Thita_.setBackground(myGreen_Color);
            jButton_Thita_.setForeground(Color.black);
            jButton_Iota_.setText("i");
            jButton_Iota_.setBackground(myGreen_Color);
            jButton_Iota_.setForeground(Color.black);
            jButton_Kappa_.setText("k");
            jButton_Kappa_.setBackground(myGreen_Color);
            jButton_Kappa_.setForeground(Color.black);
            jButton_Lamda_.setText("l");
            jButton_Lamda_.setBackground(myGreen_Color);
            jButton_Lamda_.setForeground(Color.black);
            jButton_Mi_.setText("m");
            jButton_Mi_.setBackground(myGreen_Color);
            jButton_Mi_.setForeground(Color.black);
            jButton_Ni_.setText("n");
            jButton_Ni_.setBackground(myGreen_Color);
            jButton_Ni_.setForeground(Color.black);
            jButton_Ksi_.setText("j");
            jButton_Ksi_.setBackground(myGreen_Color);
            jButton_Ksi_.setForeground(Color.black);
            jButton_Omikron_.setText("o");
            jButton_Omikron_.setBackground(myGreen_Color);
            jButton_Omikron_.setForeground(Color.black);
            jButton_Pi_.setText("p");
            jButton_Pi_.setBackground(myGreen_Color);
            jButton_Pi_.setForeground(Color.black);
            jButton_Ro_.setText("r");
            jButton_Ro_.setBackground(myGreen_Color);
            jButton_Ro_.setForeground(Color.black);
            jButton_Sigma_.setText("s");
            jButton_Sigma_.setBackground(myGreen_Color);
            jButton_Sigma_.setForeground(Color.black);
            jButton_final_Sigma_.setText("w");
            jButton_final_Sigma_.setBackground(myGreen_Color);
            jButton_final_Sigma_.setForeground(Color.black);
            jButton_Taf_.setText("t");
            jButton_Taf_.setBackground(myGreen_Color);
            jButton_Taf_.setForeground(Color.black);
            jButton_Ypsilon_.setText("y");
            jButton_Ypsilon_.setBackground(myGreen_Color);
            jButton_Ypsilon_.setForeground(Color.black);
            jButton_Phi_.setText("f");
            jButton_Phi_.setBackground(myGreen_Color);
            jButton_Phi_.setForeground(Color.black);
            jButton_Chi_.setText("x");
            jButton_Chi_.setBackground(myGreen_Color);
            jButton_Chi_.setForeground(Color.black);
            jButton_Psi_.setText("c");
            jButton_Psi_.setBackground(myGreen_Color);
            jButton_Psi_.setForeground(Color.black);
            jButton_Omega_.setText("v");
            jButton_Omega_.setBackground(myGreen_Color);
            jButton_Omega_.setForeground(Color.black);
    
            jButton_letter_Q_.setText("q");
            jButton_letter_Q_.setBackground(myGreen_Color); 
            jButton_letter_Q_.setForeground(Color.black); 
        
        }

    }
    
    private void UK_big_letters (){

        if (jRadioButton_Theme_.isSelected()==true) {   
       
            jButton_Alpha_.setText("A");
            jButton_Alpha_.setBackground(BG_Color_btn);
            jButton_Alpha_.setForeground(FG_Color_btn);
            jButton_Vita_.setText("B");
            jButton_Vita_.setBackground(BG_Color_btn);
            jButton_Vita_.setForeground(FG_Color_btn);
            jButton_Gamma_.setText("G");
            jButton_Gamma_.setBackground(BG_Color_btn);
            jButton_Gamma_.setForeground(FG_Color_btn);
            jButton_Delta_.setText("D");
            jButton_Delta_.setBackground(BG_Color_btn);
            jButton_Delta_.setForeground(FG_Color_btn);
            jButton_Epsilon_.setText("E");
            jButton_Epsilon_.setBackground(BG_Color_btn);
            jButton_Epsilon_.setForeground(FG_Color_btn);
            jButton_Zita_.setText("Z");
            jButton_Zita_.setBackground(BG_Color_btn);
            jButton_Zita_.setForeground(FG_Color_btn);
            jButton_Ita_.setText("H");
            jButton_Ita_.setBackground(BG_Color_btn);
            jButton_Ita_.setForeground(FG_Color_btn);
            jButton_Thita_.setText("U");
            jButton_Thita_.setBackground(BG_Color_btn);
            jButton_Thita_.setForeground(FG_Color_btn);
            jButton_Iota_.setText("I");
            jButton_Iota_.setBackground(BG_Color_btn);
            jButton_Iota_.setForeground(FG_Color_btn);
            jButton_Kappa_.setText("K");
            jButton_Kappa_.setBackground(BG_Color_btn);
            jButton_Kappa_.setForeground(FG_Color_btn);
            jButton_Lamda_.setText("L");
            jButton_Lamda_.setBackground(BG_Color_btn);
            jButton_Lamda_.setForeground(FG_Color_btn);
            jButton_Mi_.setText("M");
            jButton_Mi_.setBackground(BG_Color_btn);
            jButton_Mi_.setForeground(FG_Color_btn);
            jButton_Ni_.setText("N");
            jButton_Ni_.setBackground(BG_Color_btn);
            jButton_Ni_.setForeground(FG_Color_btn);
            jButton_Ksi_.setText("J");
            jButton_Ksi_.setBackground(BG_Color_btn);
            jButton_Ksi_.setForeground(FG_Color_btn);
            jButton_Omikron_.setText("O");
            jButton_Omikron_.setBackground(BG_Color_btn);
            jButton_Omikron_.setForeground(FG_Color_btn);
            jButton_Pi_.setText("P");
            jButton_Pi_.setBackground(BG_Color_btn);
            jButton_Pi_.setForeground(FG_Color_btn);
            jButton_Ro_.setText("R");
            jButton_Ro_.setBackground(BG_Color_btn);
            jButton_Ro_.setForeground(FG_Color_btn);
            jButton_Sigma_.setText("S");
            jButton_Sigma_.setBackground(BG_Color_btn);
            jButton_Alpha_.setForeground(FG_Color_btn);
            jButton_final_Sigma_.setText("W");
            jButton_final_Sigma_.setBackground(BG_Color_btn);
            jButton_final_Sigma_.setForeground(FG_Color_btn);
            jButton_Taf_.setText("T");
            jButton_Taf_.setBackground(BG_Color_btn);
            jButton_Taf_.setForeground(FG_Color_btn);
            jButton_Ypsilon_.setText("Y");
            jButton_Ypsilon_.setBackground(BG_Color_btn);
            jButton_Ypsilon_.setForeground(FG_Color_btn);
            jButton_Phi_.setText("F");
            jButton_Phi_.setBackground(BG_Color_btn);
            jButton_Phi_.setForeground(FG_Color_btn);
            jButton_Chi_.setText("X");
            jButton_Chi_.setBackground(BG_Color_btn);
            jButton_Chi_.setForeground(FG_Color_btn);
            jButton_Psi_.setText("C");
            jButton_Psi_.setBackground(BG_Color_btn);
            jButton_Psi_.setForeground(FG_Color_btn);
            jButton_Omega_.setText("V");
            jButton_Omega_.setBackground(BG_Color_btn);
            jButton_Omega_.setForeground(FG_Color_btn);
    
            jButton_letter_Q_.setText("Q");
            jButton_letter_Q_.setBackground(BG_Color_btn);
            jButton_letter_Q_.setForeground(FG_Color_btn);
        }

        else {
    
            jButton_Alpha_.setText("A");
            jButton_Alpha_.setBackground(myGreen_Color);
            jButton_Alpha_.setForeground(Color.black);
            jButton_Vita_.setText("B");
            jButton_Vita_.setBackground(myGreen_Color);
            jButton_Vita_.setForeground(Color.black);
            jButton_Gamma_.setText("G");
            jButton_Gamma_.setBackground(myGreen_Color);
            jButton_Gamma_.setForeground(Color.black);
            jButton_Delta_.setText("D");
            jButton_Delta_.setBackground(myGreen_Color);
            jButton_Delta_.setForeground(Color.black);
            jButton_Epsilon_.setText("E");
            jButton_Epsilon_.setBackground(myGreen_Color);
            jButton_Epsilon_.setForeground(Color.black);
            jButton_Zita_.setText("Z");
            jButton_Zita_.setBackground(myGreen_Color);
            jButton_Zita_.setForeground(Color.black);
            jButton_Ita_.setText("H");
            jButton_Ita_.setBackground(myGreen_Color);
            jButton_Ita_.setForeground(Color.black);
            jButton_Thita_.setText("U");
            jButton_Thita_.setBackground(myGreen_Color);
            jButton_Thita_.setForeground(Color.black);
            jButton_Iota_.setText("I");
            jButton_Iota_.setBackground(myGreen_Color);
            jButton_Iota_.setForeground(Color.black);
            jButton_Kappa_.setText("K");
            jButton_Kappa_.setBackground(myGreen_Color);
            jButton_Kappa_.setForeground(Color.black);
            jButton_Lamda_.setText("L");
            jButton_Lamda_.setBackground(myGreen_Color);
            jButton_Lamda_.setForeground(Color.black);
            jButton_Mi_.setText("M");
            jButton_Mi_.setBackground(myGreen_Color);
            jButton_Mi_.setForeground(Color.black);
            jButton_Ni_.setText("N");
            jButton_Ni_.setBackground(myGreen_Color);
            jButton_Ni_.setForeground(Color.black);
            jButton_Ksi_.setText("J");
            jButton_Ksi_.setBackground(myGreen_Color);
            jButton_Ksi_.setForeground(Color.black);
            jButton_Omikron_.setText("O");
            jButton_Omikron_.setBackground(myCyan_Color);
            jButton_Omikron_.setForeground(Color.black);
            jButton_Pi_.setText("P");
            jButton_Pi_.setBackground(myGreen_Color);
            jButton_Pi_.setForeground(Color.black);
            jButton_Ro_.setText("R");
            jButton_Ro_.setBackground(myGreen_Color);
            jButton_Ro_.setForeground(Color.black);
            jButton_Sigma_.setText("S");
            jButton_Sigma_.setBackground(myGreen_Color);
            jButton_Sigma_.setForeground(Color.black);
            jButton_final_Sigma_.setText("W");
            jButton_final_Sigma_.setBackground(myGreen_Color);
            jButton_final_Sigma_.setForeground(Color.black);
            jButton_Taf_.setText("T");
            jButton_Taf_.setBackground(myGreen_Color);
            jButton_Taf_.setForeground(Color.black);
            jButton_Ypsilon_.setText("Y");
            jButton_Ypsilon_.setBackground(myGreen_Color);
            jButton_Ypsilon_.setForeground(Color.black);
            jButton_Phi_.setText("F");
            jButton_Phi_.setBackground(myGreen_Color);
            jButton_Phi_.setForeground(Color.black);
            jButton_Chi_.setText("X");
            jButton_Chi_.setBackground(myGreen_Color);
            jButton_Chi_.setForeground(Color.black);
            jButton_Psi_.setText("C");
            jButton_Psi_.setBackground(myGreen_Color);
            jButton_Psi_.setForeground(Color.black);
            jButton_Omega_.setText("V");
            jButton_Omega_.setBackground(myGreen_Color);
            jButton_Omega_.setForeground(Color.black);
    
            jButton_letter_Q_.setText("Q");
            jButton_letter_Q_.setBackground(myGreen_Color); 
            jButton_letter_Q_.setForeground(Color.black); 
    
        }
    
    }
    
    private void tonoi_pneymata_enabled(){
        
        jButton_psili_.setEnabled(true);
        jButton_oxia_.setEnabled(true);
        jButton_psili_oxia_.setEnabled(true);
        jButton_psili_varia_.setEnabled(true);
        jButton_dasia_.setEnabled(true);
        jButton_varia_.setEnabled(true);
        jButton_dasia_varia_.setEnabled(true);
        jButton_dasia_oxia_.setEnabled(true);
        jButton_tonos_.setEnabled(true);
        jButton_perispomeni_.setEnabled(true);
        jButton_psili_perismpomeni_.setEnabled(true);
        jButton_dasia_perispomeni_.setEnabled(true);
        jButton_dialytika_oxia_.setEnabled(true);
        jButton_dialytika_varia_.setEnabled(true);
        jButton_makron_.setEnabled(true);
        jButton_psili_ypogegrammeni_.setEnabled(true);
        jButton_oxia_ypogegrammeni_.setEnabled(true);
        jButton_psili_oxia_ypogegrammeni_.setEnabled(true);
        jButton_psili_varia_ypogegrammeni_.setEnabled(true);
        jButton_dasia_ypogegrammeni_.setEnabled(true);
        jButton_varia_ypogegrammeni_.setEnabled(true);
        jButton_dasia_varia_ypogegrammeni_.setEnabled(true);
        jButton_dasia_oxia_ypogegrammeni_.setEnabled(true);
        jButton_ypogegrammeni_.setEnabled(true);
        jButton_dialytika_tonos_.setEnabled(true);
        jButton_perispomeni_ypogegrammeni_.setEnabled(true);
        jButton_psili_perispomeni_ypogegrammeni_.setEnabled(true);
        jButton_dasia_perispomeni_ypogegrammeni_.setEnabled(true);
        jButton_dialytika_.setEnabled(true);
        jButton_dialytika_perispomeni_.setEnabled(true);
        jButton_vrachy_.setEnabled(true);
        
        jButton_ano_telia_.setEnabled(true);
        
    }
    
    private void tonoi_pneymata_disabled(){
        
        jButton_psili_.setEnabled(false);
        jButton_oxia_.setEnabled(false);
        jButton_psili_oxia_.setEnabled(false);
        jButton_psili_varia_.setEnabled(false);
        jButton_dasia_.setEnabled(false);
        jButton_varia_.setEnabled(false);
        jButton_dasia_varia_.setEnabled(false);
        jButton_dasia_oxia_.setEnabled(false);
        jButton_tonos_.setEnabled(false);
        jButton_perispomeni_.setEnabled(false);
        jButton_psili_perismpomeni_.setEnabled(false);
        jButton_dasia_perispomeni_.setEnabled(false);
        jButton_dialytika_oxia_.setEnabled(false);
        jButton_dialytika_varia_.setEnabled(false);
        jButton_makron_.setEnabled(false);
        jButton_psili_ypogegrammeni_.setEnabled(false);
        jButton_oxia_ypogegrammeni_.setEnabled(false);
        jButton_psili_oxia_ypogegrammeni_.setEnabled(false);
        jButton_psili_varia_ypogegrammeni_.setEnabled(false);
        jButton_dasia_ypogegrammeni_.setEnabled(false);
        jButton_varia_ypogegrammeni_.setEnabled(false);
        jButton_dasia_varia_ypogegrammeni_.setEnabled(false);
        jButton_dasia_oxia_ypogegrammeni_.setEnabled(false);
        jButton_ypogegrammeni_.setEnabled(false);
        jButton_dialytika_tonos_.setEnabled(false);
        jButton_perispomeni_ypogegrammeni_.setEnabled(false);
        jButton_psili_perispomeni_ypogegrammeni_.setEnabled(false);
        jButton_dasia_perispomeni_ypogegrammeni_.setEnabled(false);
        jButton_dialytika_.setEnabled(false);
        jButton_dialytika_perispomeni_.setEnabled(false);
        jButton_vrachy_.setEnabled(false);
        
        jButton_ano_telia_.setEnabled(false);
        
    }
    
    private void numbers_enabled(){ 
        
        jButton_En_Circumflex_.setText("~");
        jButton_1_.setText("1");
        jButton_2_.setText("2");
        jButton_3_.setText("3");
        jButton_4_.setText("4");
        jButton_5_.setText("5");
        jButton_6_.setText("6");
        jButton_7_.setText("7");
        jButton_8_.setText("8");
        jButton_9_.setText("9");
        jButton_0_.setText("0");
        jButton_subtraction_.setText("-");
        jButton_equal_.setText("=");
       
    }
    
    private void numbers_disabled(){
        
        jButton_En_Circumflex_.setText("~");
        jButton_1_.setText("!");
        jButton_2_.setText("@");
        jButton_3_.setText("#");
        jButton_4_.setText("$");
        jButton_5_.setText("%");
        jButton_6_.setText("^");
        jButton_7_.setText("&");
        jButton_8_.setText("*");
        jButton_9_.setText("(");
        jButton_0_.setText(")");
        jButton_subtraction_.setText("_");
        jButton_equal_.setText("+");
        
     }
    
    private void buttons_color_theme () {
        
        jButton_Alpha_.setBackground(BG_Color_btn); ///////////////
        jButton_Vita_.setBackground(BG_Color_btn);
        jButton_Gamma_.setBackground(BG_Color_btn);
        jButton_Delta_.setBackground(BG_Color_btn);
        jButton_Epsilon_.setBackground(BG_Color_btn);
        jButton_Zita_.setBackground(BG_Color_btn);
        jButton_Ita_.setBackground(BG_Color_btn);
        jButton_Thita_.setBackground(BG_Color_btn);
        jButton_Iota_.setBackground(BG_Color_btn);
        jButton_Kappa_.setBackground(BG_Color_btn);
        jButton_Lamda_.setBackground(BG_Color_btn);
        jButton_Mi_.setBackground(BG_Color_btn);
        jButton_Ni_.setBackground(BG_Color_btn);
        jButton_Ksi_.setBackground(BG_Color_btn);
        jButton_Omikron_.setBackground(BG_Color_btn);
        jButton_Pi_.setBackground(BG_Color_btn);
        jButton_Ro_.setBackground(BG_Color_btn);
        jButton_Sigma_.setBackground(BG_Color_btn);
        jButton_final_Sigma_.setBackground(BG_Color_btn);
        jButton_Taf_.setBackground(BG_Color_btn);
        jButton_Ypsilon_.setBackground(BG_Color_btn);
        jButton_Phi_.setBackground(BG_Color_btn);
        jButton_Chi_.setBackground(BG_Color_btn);
        jButton_Psi_.setBackground(BG_Color_btn);
        jButton_Omega_.setBackground(BG_Color_btn);
        jButton_letter_Q_.setBackground(BG_Color_btn); 
        jButton_Alpha_.setForeground(FG_Color_btn);
        jButton_Vita_.setForeground(FG_Color_btn);
        jButton_Gamma_.setForeground(FG_Color_btn);
        jButton_Delta_.setForeground(FG_Color_btn);
        jButton_Epsilon_.setForeground(FG_Color_btn);
        jButton_Zita_.setForeground(FG_Color_btn);
        jButton_Ita_.setForeground(FG_Color_btn);
        jButton_Thita_.setForeground(FG_Color_btn);
        jButton_Iota_.setForeground(FG_Color_btn);
        jButton_Kappa_.setForeground(FG_Color_btn);
        jButton_Lamda_.setForeground(FG_Color_btn);
        jButton_Mi_.setForeground(FG_Color_btn);
        jButton_Ni_.setForeground(FG_Color_btn);
        jButton_Ksi_.setForeground(FG_Color_btn);
        jButton_Omikron_.setForeground(FG_Color_btn);
        jButton_Pi_.setForeground(FG_Color_btn);
        jButton_Ro_.setForeground(FG_Color_btn);
        jButton_Sigma_.setForeground(FG_Color_btn);
        jButton_final_Sigma_.setForeground(FG_Color_btn);
        jButton_Taf_.setForeground(FG_Color_btn);
        jButton_Ypsilon_.setForeground(FG_Color_btn);
        jButton_Phi_.setForeground(FG_Color_btn);
        jButton_Chi_.setForeground(FG_Color_btn);
        jButton_Psi_.setForeground(FG_Color_btn);
        jButton_Omega_.setForeground(FG_Color_btn);
        jButton_letter_Q_.setForeground(FG_Color_btn);
    
        jButton_En_Circumflex_.setBackground(BG_Color_btn); ///////////
        jButton_1_.setBackground(BG_Color_btn);
        jButton_2_.setBackground(BG_Color_btn);
        jButton_3_.setBackground(BG_Color_btn);
        jButton_4_.setBackground(BG_Color_btn);
        jButton_5_.setBackground(BG_Color_btn);
        jButton_6_.setBackground(BG_Color_btn);
        jButton_7_.setBackground(BG_Color_btn);
        jButton_8_.setBackground(BG_Color_btn);
        jButton_9_.setBackground(BG_Color_btn);
        jButton_0_.setBackground(BG_Color_btn);
        jButton_subtraction_.setBackground(BG_Color_btn);
        jButton_equal_.setBackground(BG_Color_btn);
        jButton_En_Circumflex_.setForeground(FG_Color_btn);     
        jButton_1_.setForeground(FG_Color_btn);
        jButton_2_.setForeground(FG_Color_btn);
        jButton_3_.setForeground(FG_Color_btn);
        jButton_4_.setForeground(FG_Color_btn);
        jButton_5_.setForeground(FG_Color_btn);
        jButton_6_.setForeground(FG_Color_btn);
        jButton_7_.setForeground(FG_Color_btn);
        jButton_8_.setForeground(FG_Color_btn);
        jButton_9_.setForeground(FG_Color_btn);
        jButton_0_.setForeground(FG_Color_btn);
        jButton_subtraction_.setForeground(FG_Color_btn);
        jButton_equal_.setForeground(FG_Color_btn);
 
        jButton_En_Circumflex_.setBackground(BG_Color_btn);   
        jButton_left_square_bracket_.setBackground(BG_Color_btn);      
        jButton_right_square_bracket_.setBackground(BG_Color_btn);      
        jButton_backward_slash_.setBackground(BG_Color_btn);      
        jButton_symbol_1.setBackground(BG_Color_btn);      
        jButton_symbol_2.setBackground(BG_Color_btn);      
        jButton_komma_.setBackground(BG_Color_btn);      
        jButton_telia_.setBackground(BG_Color_btn);      
        jButton_slash_.setBackground(BG_Color_btn);      
        jButton_En_Circumflex_.setForeground(FG_Color_btn);
        jButton_left_square_bracket_.setForeground(FG_Color_btn);      
        jButton_right_square_bracket_.setForeground(FG_Color_btn);      
        jButton_backward_slash_.setForeground(FG_Color_btn);      
        jButton_symbol_1.setForeground(FG_Color_btn);      
        jButton_symbol_2.setForeground(FG_Color_btn);      
        jButton_komma_.setForeground(FG_Color_btn);      
        jButton_telia_.setForeground(FG_Color_btn);      
        jButton_slash_.setForeground(FG_Color_btn);     
       
        jButton_backspace_.setBackground(BG_Color_btn); ///////////
        jButton_tab_.setBackground(BG_Color_btn);
        //jButton_caps_.setBackground(BG_Color_btn);
        jButton_enter_.setBackground(BG_Color_btn);
        //jButton_left_shift_.setBackground(BG_Color_btn);
        //jButton_right_shift_.setBackground(BG_Color_btn);
        jButton_space_.setBackground(BG_Color_btn);
        //jButton_altGR_.setBackground(BG_Color_btn);     
        jButton_backspace_.setForeground(FG_Color_btn);
        jButton_tab_.setForeground(FG_Color_btn);
        //jButton_caps_.setForeground(FG_Color_btn);
        jButton_enter_.setForeground(FG_Color_btn);
        //jButton_left_shift_.setForeground(FG_Color_btn);
        //jButton_right_shift_.setForeground(FG_Color_btn);
        jButton_space_.setForeground(FG_Color_btn);
        //jButton_altGR_.setForeground(FG_Color_btn);    
        
        jButton_Up_.setBackground(BG_Color_btn); /////////
        jButton_Down_.setBackground(BG_Color_btn);
        jButton_Left_.setBackground(BG_Color_btn);
        jButton_Right_.setBackground(BG_Color_btn);
        jButton_ctrl_Left_.setBackground(BG_Color_btn);        
        jButton_ctrl_Right_.setBackground(BG_Color_btn);
        jButton_Insert_.setBackground(BG_Color_btn);
        jButton_Delete_.setBackground(BG_Color_btn);
        jButton_Home_.setBackground(BG_Color_btn);
        jButton_End_.setBackground(BG_Color_btn);
        jButton_Up_.setForeground(FG_Color_btn);
        jButton_Down_.setForeground(FG_Color_btn);
        jButton_Left_.setForeground(FG_Color_btn);
        jButton_Right_.setForeground(FG_Color_btn);
        jButton_ctrl_Left_.setForeground(FG_Color_btn); 
        jButton_ctrl_Right_.setForeground(FG_Color_btn);
        jButton_Insert_.setForeground(FG_Color_btn);
        jButton_Delete_.setForeground(FG_Color_btn);
        jButton_Home_.setForeground(FG_Color_btn);
        jButton_End_.setForeground(FG_Color_btn); 
  
    }
    
    private void buttons_color () {
        
        jButton_Alpha_.setBackground(myCyan_Color);
        jButton_Vita_.setBackground(myGreen_Color);
        jButton_Gamma_.setBackground(myGreen_Color);
        jButton_Delta_.setBackground(myGreen_Color);
        jButton_Epsilon_.setBackground(myCyan_Color);
        jButton_Zita_.setBackground(myGreen_Color);
        jButton_Ita_.setBackground(myCyan_Color);
        jButton_Thita_.setBackground(myGreen_Color);
        jButton_Iota_.setBackground(myCyan_Color);
        jButton_Kappa_.setBackground(myGreen_Color);
        jButton_Lamda_.setBackground(myGreen_Color);
        jButton_Mi_.setBackground(myGreen_Color);
        jButton_Ni_.setBackground(myGreen_Color);
        jButton_Ksi_.setBackground(myGreen_Color);
        jButton_Omikron_.setBackground(myCyan_Color);
        jButton_Pi_.setBackground(myGreen_Color);
        jButton_Ro_.setBackground(myGreen_Color);
        jButton_Sigma_.setBackground(myGreen_Color);
        jButton_final_Sigma_.setBackground(myGreen_Color);
        jButton_Taf_.setBackground(myGreen_Color);
        jButton_Ypsilon_.setBackground(myCyan_Color);
        jButton_Phi_.setBackground(myGreen_Color);
        jButton_Chi_.setBackground(myGreen_Color);
        jButton_Psi_.setBackground(myGreen_Color);
        jButton_Omega_.setBackground(myCyan_Color);
    
        jButton_letter_Q_.setBackground(myPink_Color); 
    
        jButton_Alpha_.setForeground(Color.black);
        jButton_Vita_.setForeground(Color.black);
        jButton_Gamma_.setForeground(Color.black);
        jButton_Delta_.setForeground(Color.black);
        jButton_Epsilon_.setForeground(Color.black);
        jButton_Zita_.setForeground(Color.black);
        jButton_Ita_.setForeground(Color.black);
        jButton_Thita_.setForeground(Color.black);
        jButton_Iota_.setForeground(Color.black);
        jButton_Kappa_.setForeground(Color.black);
        jButton_Lamda_.setForeground(Color.black);
        jButton_Mi_.setForeground(Color.black);
        jButton_Ni_.setForeground(Color.black);
        jButton_Ksi_.setForeground(Color.black);
        jButton_Omikron_.setForeground(Color.black);
        jButton_Pi_.setForeground(Color.black);
        jButton_Ro_.setForeground(Color.black);
        jButton_Sigma_.setForeground(Color.black);
        jButton_final_Sigma_.setForeground(Color.black);
        jButton_Taf_.setForeground(Color.black);
        jButton_Ypsilon_.setForeground(Color.black);
        jButton_Phi_.setForeground(Color.black);
        jButton_Chi_.setForeground(Color.black);
        jButton_Psi_.setForeground(Color.black);
        jButton_Omega_.setForeground(Color.black);
    
        jButton_letter_Q_.setForeground(Color.black);
     
        jButton_En_Circumflex_.setBackground(myPastelGreen_Color);
        jButton_1_.setBackground(myPastelGreen_Color);
        jButton_2_.setBackground(myPastelGreen_Color);
        jButton_3_.setBackground(myPastelGreen_Color);
        jButton_4_.setBackground(myPastelGreen_Color);
        jButton_5_.setBackground(myPastelGreen_Color);
        jButton_6_.setBackground(myPastelGreen_Color);
        jButton_7_.setBackground(myPastelGreen_Color);
        jButton_8_.setBackground(myPastelGreen_Color);
        jButton_9_.setBackground(myPastelGreen_Color);
        jButton_0_.setBackground(myPastelGreen_Color);
        jButton_subtraction_.setBackground(myPastelGreen_Color);
        jButton_equal_.setBackground(myPastelGreen_Color);
        
        jButton_En_Circumflex_.setForeground(Color.black);
        jButton_1_.setForeground(Color.black);
        jButton_2_.setForeground(Color.black);
        jButton_3_.setForeground(Color.black);
        jButton_4_.setForeground(Color.black);
        jButton_5_.setForeground(Color.black);
        jButton_6_.setForeground(Color.black);
        jButton_7_.setForeground(Color.black);
        jButton_8_.setForeground(Color.black);
        jButton_9_.setForeground(Color.black);
        jButton_0_.setForeground(Color.black);
        jButton_subtraction_.setForeground(Color.black);
        jButton_equal_.setForeground(Color.black);
        
        jButton_backspace_.setBackground(myRed_Color);
        jButton_tab_.setBackground(myRed_Color);
        //jButton_caps_.setBackground(myRed_Color);
        jButton_enter_.setBackground(myRed_Color);
        //jButton_left_shift_.setBackground(myRed_Color);
        //jButton_right_shift_.setBackground(myRed_Color);
        jButton_space_.setBackground(myRed_Color);
        //jButton_altGR_.setBackground(myRed_Color);

        jButton_backspace_.setForeground(Color.black);
        jButton_tab_.setForeground(Color.black);
        //jButton_caps_.setForeground(Color.black);
        jButton_enter_.setForeground(Color.black);
        //jButton_left_shift_.setForeground(Color.black);
        //jButton_right_shift_.setForeground(Color.black);
        jButton_space_.setForeground(Color.black);
        //jButton_altGR_.setForeground(Color.black);        
        
        //jButton_En_Circumflex_.setBackground(myPink_Color);   
        //jButton_En_Circumflex_.setForeground(Color.black);
        jButton_left_square_bracket_.setBackground(myPink_Color);      
        jButton_left_square_bracket_.setForeground(Color.black);      
        jButton_right_square_bracket_.setBackground(myPink_Color);      
        jButton_right_square_bracket_.setForeground(Color.black);      
        jButton_backward_slash_.setBackground(myPink_Color);      
        jButton_backward_slash_.setForeground(Color.black);      
        jButton_symbol_1.setBackground(myPink_Color);      
        jButton_symbol_1.setForeground(Color.black);      
        jButton_symbol_2.setBackground(myPink_Color);      
        jButton_symbol_2.setForeground(Color.black);      
        jButton_komma_.setBackground(myPink_Color);      
        jButton_komma_.setForeground(Color.black);      
        jButton_telia_.setBackground(myPink_Color);      
        jButton_telia_.setForeground(Color.black);      
        jButton_slash_.setBackground(myPink_Color);      
        jButton_slash_.setForeground(Color.black);     
      
        jButton_Up_.setBackground(myPurple_Color);
        jButton_Down_.setBackground(myPurple_Color);
        jButton_Left_.setBackground(myPurple_Color);
        jButton_Right_.setBackground(myPurple_Color);
        jButton_ctrl_Left_.setBackground(myRed_Color);        
        jButton_ctrl_Right_.setBackground(myRed_Color);
        jButton_Insert_.setBackground(myIDHE_Color);
        jButton_Delete_.setBackground(myIDHE_Color);
        jButton_Home_.setBackground(myIDHE_Color);
        jButton_End_.setBackground(myIDHE_Color);
            
        jButton_Up_.setForeground(Color.black);
        jButton_Down_.setForeground(Color.black);
        jButton_Left_.setForeground(Color.black);
        jButton_Right_.setForeground(Color.black);
        jButton_ctrl_Left_.setForeground(Color.black);    
        jButton_ctrl_Right_.setForeground(Color.black);
        jButton_Insert_.setForeground(Color.black);
        jButton_Delete_.setForeground(Color.black);
        jButton_Home_.setForeground(Color.black);
        jButton_End_.setForeground(Color.black);
        
    }
    private void symbols_GR (){
        
        jButton_En_Circumflex_.setText("~");
        jButton_letter_Q_.setText(";");
        jButton_left_square_bracket_.setText("[");
        jButton_right_square_bracket_.setText("]");
        jButton_backward_slash_.setText("\\");
        jButton_symbol_1.setText("΄");
        jButton_symbol_2.setText("'");
        jButton_komma_.setText(",");
        jButton_telia_.setText(".");
        jButton_slash_.setText("/");
    }
    
    private void symbols_GR_shift (){
        
        jButton_En_Circumflex_.setText("`");
        jButton_letter_Q_.setText(":");
        jButton_left_square_bracket_.setText("{");
        jButton_right_square_bracket_.setText("}");
        jButton_backward_slash_.setText("|");
        jButton_symbol_1.setText("¨");
        jButton_symbol_2.setText("\"");
        jButton_komma_.setText("<");
        jButton_telia_.setText(">");
        jButton_slash_.setText("?");
    }

    private void symbols_UK (){
        
        jButton_En_Circumflex_.setText("`");
        jButton_letter_Q_.setText("q");
        jButton_left_square_bracket_.setText("[");
        jButton_right_square_bracket_.setText("]");
        jButton_backward_slash_.setText("\\");
        jButton_symbol_1.setText(";");
        jButton_symbol_2.setText("'");
        jButton_komma_.setText(",");
        jButton_telia_.setText(".");
        jButton_slash_.setText("/");
    }
    
    private void symbols_UK_shift (){
        
        jButton_En_Circumflex_.setText("~");
        jButton_letter_Q_.setText("Q");
        jButton_left_square_bracket_.setText("{");
        jButton_right_square_bracket_.setText("}");
        jButton_backward_slash_.setText("|");
        jButton_symbol_1.setText(":");
        jButton_symbol_2.setText("\"");
        jButton_komma_.setText("<");
        jButton_telia_.setText(">");
        jButton_slash_.setText("?");
    }
    
    private void special_symbols_altGR (){
        
        jButton_En_Circumflex_.setText("῁");
        jButton_1_.setText("Ϛ");
        jButton_2_.setText("Ϟ");
        jButton_3_.setText("Ϡ");
        jButton_4_.setText("£");
        jButton_5_.setText("§");
        jButton_6_.setText("¶");
        jButton_7_.setText("");
        jButton_8_.setText("¤");
        jButton_9_.setText("¦");
        jButton_0_.setText("°");
        jButton_subtraction_.setText("±");
        jButton_Epsilon_.setText("€");
        jButton_Ro_.setText("®");
        jButton_Taf_.setText("™");
        jButton_Ypsilon_.setText("¥");
        jButton_Psi_.setText("©");
        
        jButton_equal_.setText("½");
        jButton_left_square_bracket_.setText("«");
        jButton_right_square_bracket_.setText("»");
        jButton_backward_slash_.setText("¬");
        jButton_symbol_1.setText("΅");
        jButton_symbol_2.setText("᾿");
        jButton_komma_.setText("");
        jButton_telia_.setText("…");
        jButton_slash_.setText("ι");
    
    }
    
    private void special_symbols_altGR_for_colors (){
        
        jButton_En_Circumflex_.setBackground(myPastelGreen_Color);
        jButton_1_.setBackground(myPastelGreen_Color);
        jButton_2_.setBackground(myPastelGreen_Color);
        jButton_3_.setBackground(myPastelGreen_Color);
        jButton_4_.setBackground(myPastelGreen_Color);
        jButton_5_.setBackground(myPastelGreen_Color);
        jButton_6_.setBackground(myPastelGreen_Color);
        jButton_8_.setBackground(myPastelGreen_Color);
        jButton_9_.setBackground(myPastelGreen_Color);
        jButton_0_.setBackground(myPastelGreen_Color);
        jButton_subtraction_.setBackground(myPastelGreen_Color);
        jButton_Epsilon_.setBackground(myPastelGreen_Color);
        jButton_Ro_.setBackground(myPastelGreen_Color);
        jButton_Taf_.setBackground(myPastelGreen_Color);
        jButton_Ypsilon_.setBackground(myPastelGreen_Color);
        jButton_Psi_.setBackground(myPastelGreen_Color);
        
        jButton_equal_.setBackground(myPastelGreen_Color);
        jButton_left_square_bracket_.setBackground(myPastelGreen_Color);
        jButton_right_square_bracket_.setBackground(myPastelGreen_Color);
        jButton_backward_slash_.setBackground(myPastelGreen_Color);
        jButton_symbol_1.setBackground(myPastelGreen_Color);
        jButton_symbol_2.setBackground(myPastelGreen_Color);
        jButton_telia_.setBackground(myPastelGreen_Color);
        jButton_slash_.setBackground(myPastelGreen_Color);
        
    }
    
    private void special_symbols_altGR_for_theme (){
        
        jButton_En_Circumflex_.setBackground(BG_Color_btn);
        jButton_1_.setBackground(BG_Color_btn);
        jButton_2_.setBackground(BG_Color_btn);
        jButton_3_.setBackground(BG_Color_btn);
        jButton_4_.setBackground(BG_Color_btn);
        jButton_5_.setBackground(BG_Color_btn);
        jButton_6_.setBackground(BG_Color_btn);
        jButton_8_.setBackground(BG_Color_btn);
        jButton_9_.setBackground(BG_Color_btn);
        jButton_0_.setBackground(BG_Color_btn);
        jButton_subtraction_.setBackground(BG_Color_btn);
        jButton_Epsilon_.setBackground(BG_Color_btn);
        jButton_Ro_.setBackground(BG_Color_btn);
        jButton_Taf_.setBackground(BG_Color_btn);
        jButton_Ypsilon_.setBackground(BG_Color_btn);
        jButton_Psi_.setBackground(BG_Color_btn);
        
        jButton_equal_.setBackground(BG_Color_btn);
        jButton_left_square_bracket_.setBackground(BG_Color_btn);
        jButton_right_square_bracket_.setBackground(BG_Color_btn);
        jButton_backward_slash_.setBackground(BG_Color_btn);
        jButton_symbol_1.setBackground(BG_Color_btn);
        jButton_symbol_2.setBackground(BG_Color_btn);
        jButton_telia_.setBackground(BG_Color_btn);
        jButton_slash_.setBackground(BG_Color_btn);
        
    }
    
    private void special_symbols_altGR_shift (){
        jButton_En_Circumflex_.setText("");
        jButton_1_.setText("");
        jButton_2_.setText("²");
        jButton_3_.setText("³");
        jButton_4_.setText("");
        jButton_5_.setText("");
        jButton_6_.setText("");
        jButton_7_.setText("");
        jButton_8_.setText("");
        jButton_9_.setText("");
        jButton_0_.setText("");
        jButton_subtraction_.setText("");
        jButton_equal_.setText("῟");
        jButton_Epsilon_.setText("");
        jButton_Ro_.setText("");
        jButton_Taf_.setText("");
        jButton_Ypsilon_.setText("");
        jButton_left_square_bracket_.setText("");
        jButton_right_square_bracket_.setText("·");
        jButton_backward_slash_.setText("");
        jButton_symbol_1.setText("῾");
        jButton_symbol_2.setText("῝");
        jButton_Psi_.setText("");
        jButton_komma_.setText("");
        jButton_telia_.setText("");
        jButton_slash_.setText("῞");
        
    }
    
     private void special_symbols_altGR_shift_for_colors (){
        
        jButton_2_.setBackground(myPastelGreen_Color);
        jButton_3_.setBackground(myPastelGreen_Color);
        jButton_equal_.setBackground(myPastelGreen_Color);
        jButton_right_square_bracket_.setBackground(myPastelGreen_Color);
        jButton_symbol_1.setBackground(myPastelGreen_Color);
        jButton_symbol_2.setBackground(myPastelGreen_Color);
        jButton_slash_.setBackground(myPastelGreen_Color);
         
     }
     
     private void special_symbols_altGR_shift_for_theme (){
 
        jButton_2_.setBackground(BG_Color_btn);
        jButton_3_.setBackground(BG_Color_btn);
        jButton_equal_.setBackground(BG_Color_btn);
        jButton_right_square_bracket_.setBackground(BG_Color_btn);
        jButton_symbol_1.setBackground(BG_Color_btn);
        jButton_symbol_2.setBackground(BG_Color_btn);
        jButton_slash_.setBackground(BG_Color_btn);
         
     }
     private void call_gray (){
        
        
        jButton_Alpha_.setBackground(Color.gray);
        jButton_Vita_.setBackground(Color.gray);
        jButton_Gamma_.setBackground(Color.gray);
        jButton_Delta_.setBackground(Color.gray);
        jButton_Epsilon_.setBackground(Color.gray);
        jButton_Zita_.setBackground(Color.gray);
        jButton_Ita_.setBackground(Color.gray);
        jButton_Thita_.setBackground(Color.gray);
        jButton_Iota_.setBackground(Color.gray);
        jButton_Kappa_.setBackground(Color.gray);
        jButton_Lamda_.setBackground(Color.gray);
        jButton_Mi_.setBackground(Color.gray);
        jButton_Ni_.setBackground(Color.gray);
        jButton_Ksi_.setBackground(Color.gray);
        jButton_Omikron_.setBackground(Color.gray);
        jButton_Pi_.setBackground(Color.gray);
        jButton_Ro_.setBackground(Color.gray);
        jButton_Sigma_.setBackground(Color.gray);
        jButton_final_Sigma_.setBackground(Color.gray);
        jButton_Taf_.setBackground(Color.gray);
        jButton_Ypsilon_.setBackground(Color.gray);
        jButton_Phi_.setBackground(Color.gray);
        jButton_Chi_.setBackground(Color.gray);
        jButton_Psi_.setBackground(Color.gray);
        jButton_Omega_.setBackground(Color.gray);
    
        jButton_letter_Q_.setBackground(Color.gray); 

        jButton_En_Circumflex_.setBackground(Color.gray); 
        jButton_1_.setBackground(Color.gray); 
        jButton_4_.setBackground(Color.gray); 
        jButton_5_.setBackground(Color.gray); 
        jButton_6_.setBackground(Color.gray); 
        jButton_7_.setBackground(Color.gray); 
        jButton_8_.setBackground(Color.gray); 
        jButton_9_.setBackground(Color.gray); 
        jButton_0_.setBackground(Color.gray); 
        jButton_subtraction_.setBackground(Color.gray); 
        

        jButton_left_square_bracket_.setBackground(Color.gray); 
        jButton_backward_slash_.setBackground(Color.gray); 
        jButton_komma_.setBackground(Color.gray); 
        jButton_telia_.setBackground(Color.gray); 
                
     }
     
     
    
    private void without_chars () {
        
        if (jRadioButton_Theme_.isSelected()==true) {  
            
            jButton_En_Circumflex_.setText("");
            jButton_En_Circumflex_.setBackground(BG_Color_btn);
    
            jButton_Alpha_.setText("");
            jButton_Alpha_.setBackground(BG_Color_btn);
            jButton_Vita_.setText("");
            jButton_Vita_.setBackground(BG_Color_btn);
            jButton_Gamma_.setText("");
            jButton_Gamma_.setBackground(BG_Color_btn);
            jButton_Delta_.setText("");
            jButton_Delta_.setBackground(BG_Color_btn);
            jButton_Epsilon_.setText("");
            jButton_Epsilon_.setBackground(BG_Color_btn);
            jButton_Zita_.setText("");
            jButton_Zita_.setBackground(BG_Color_btn);
            jButton_Ita_.setText("");
            jButton_Ita_.setBackground(BG_Color_btn);
            jButton_Thita_.setText("");
            jButton_Thita_.setBackground(BG_Color_btn);
            jButton_Iota_.setText("");
            jButton_Iota_.setBackground(BG_Color_btn);
            jButton_Kappa_.setText("");
            jButton_Kappa_.setBackground(BG_Color_btn);
            jButton_Lamda_.setText("");
            jButton_Lamda_.setBackground(BG_Color_btn);
            jButton_Mi_.setText("");
            jButton_Mi_.setBackground(BG_Color_btn);
            jButton_Ni_.setText("");
            jButton_Ni_.setBackground(BG_Color_btn);
            jButton_Ksi_.setText("");
            jButton_Ksi_.setBackground(BG_Color_btn);
            jButton_Omikron_.setText("");
            jButton_Omikron_.setBackground(BG_Color_btn);
            jButton_Pi_.setText("");
            jButton_Pi_.setBackground(BG_Color_btn);
            jButton_Ro_.setText("");
            jButton_Ro_.setBackground(BG_Color_btn);
            jButton_Sigma_.setText("");
            jButton_Sigma_.setBackground(BG_Color_btn);
            jButton_final_Sigma_.setText("");
            jButton_final_Sigma_.setBackground(BG_Color_btn);
            jButton_Taf_.setText("");
            jButton_Taf_.setBackground(BG_Color_btn);
            jButton_Ypsilon_.setText("");
            jButton_Ypsilon_.setBackground(BG_Color_btn);
            jButton_Phi_.setText("");
            jButton_Phi_.setBackground(BG_Color_btn);
            jButton_Chi_.setText("");
            jButton_Chi_.setBackground(BG_Color_btn);
            jButton_Psi_.setText("");
            jButton_Psi_.setBackground(BG_Color_btn);
            jButton_Omega_.setText("");
            jButton_Omega_.setBackground(BG_Color_btn);
    
            jButton_letter_Q_.setText("");
            jButton_letter_Q_.setBackground(BG_Color_btn);    
    
            
            
        }
    
        else {
        
            jButton_En_Circumflex_.setText("");   
            jButton_En_Circumflex_.setBackground(myPastelGreen_Color);
        
            jButton_Alpha_.setText("");
            jButton_Alpha_.setBackground(myGreen_Color);
            jButton_Vita_.setText("");
            jButton_Vita_.setBackground(myGreen_Color);
            jButton_Gamma_.setText("");
            jButton_Gamma_.setBackground(myGreen_Color);
            jButton_Delta_.setText("");
            jButton_Delta_.setBackground(myGreen_Color);
            jButton_Epsilon_.setText("");
            jButton_Epsilon_.setBackground(myPastelGreen_Color);
            jButton_Zita_.setText("");
            jButton_Zita_.setBackground(myGreen_Color);
            jButton_Ita_.setText("");
            jButton_Ita_.setBackground(myGreen_Color);
            jButton_Thita_.setText("");
            jButton_Thita_.setBackground(myGreen_Color);
            jButton_Iota_.setText("");
            jButton_Iota_.setBackground(myGreen_Color);
            jButton_Kappa_.setText("");
            jButton_Kappa_.setBackground(myGreen_Color);
            jButton_Lamda_.setText("");
            jButton_Lamda_.setBackground(myGreen_Color);
            jButton_Mi_.setText("");
            jButton_Mi_.setBackground(myGreen_Color);
            jButton_Ni_.setText("");
            jButton_Ni_.setBackground(myGreen_Color);
            jButton_Ksi_.setText("");
            jButton_Ksi_.setBackground(myGreen_Color);
            jButton_Omikron_.setText("");
            jButton_Omikron_.setBackground(myGreen_Color);
            jButton_Pi_.setText("");
            jButton_Pi_.setBackground(myGreen_Color);
            jButton_Ro_.setText("");
            jButton_Ro_.setBackground(myPastelGreen_Color);
            jButton_Sigma_.setText("");
            jButton_Sigma_.setBackground(myGreen_Color);
            jButton_final_Sigma_.setText("");
            jButton_final_Sigma_.setBackground(myGreen_Color);
            jButton_Taf_.setText("");
            jButton_Taf_.setBackground(myPastelGreen_Color);
            jButton_Ypsilon_.setText("");
            jButton_Ypsilon_.setBackground(myPastelGreen_Color);
            jButton_Phi_.setText("");
            jButton_Phi_.setBackground(myGreen_Color);
            jButton_Chi_.setText("");
            jButton_Chi_.setBackground(myGreen_Color);
            jButton_Psi_.setText("");
            jButton_Psi_.setBackground(myGreen_Color);
            jButton_Omega_.setText("");
            jButton_Omega_.setBackground(myGreen_Color);
    
            jButton_letter_Q_.setText("");
            jButton_letter_Q_.setBackground(myGreen_Color); 
            
            jButton_left_square_bracket_.setBackground(myPink_Color);
            jButton_right_square_bracket_.setBackground(myPink_Color);
            jButton_backward_slash_.setBackground(myPink_Color);
            jButton_symbol_1.setBackground(myPink_Color);
            jButton_symbol_2.setBackground(myPink_Color);
            jButton_komma_.setBackground(myPink_Color); 
            jButton_telia_.setBackground(myPink_Color);
            jButton_slash_.setBackground(myPink_Color);
        }
     
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
    
    private void delete_char_and_Insert(){
        
        mySelectedText = myTextArea.getSelectedText();
      
        if (mySelectedText != null) {
            myTextArea.replaceSelection("");
            flag_Save=false;
            
            display_positions();
            return;
        }
        
        
        
        try {
                lineNumber = myTextArea.getLineOfOffset(caretPosition);
                difference=myTextArea.getLineEndOffset(lineNumber) - myTextArea.getLineStartOffset(lineNumber) - 1;
                //System.out.println(difference);
                position = myTextArea.getDocument().getDefaultRootElement().getElement(lineNumber).getStartOffset();
            }
            catch (BadLocationException ex) {
                Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        if (myTextArea.getCaretPosition() < position + difference){
            int start = myTextArea.getCaretPosition();
            int end = myTextArea.getCaretPosition()+1;
            myTextArea.replaceRange(null, start, end);
            myTextArea.setCaretPosition(myTextArea.getCaretPosition());
        }
        else {
            return;
        }
    }
    
    private void delete_selected_text (){
        
        mySelectedText = myTextArea.getSelectedText();
      
        if (mySelectedText != null) {
            myTextArea.replaceSelection("");
            flag_Save=false;
            
            display_positions();
            return;
        }
        
    }
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_0_;
    private javax.swing.JButton jButton_1_;
    private javax.swing.JButton jButton_2_;
    private javax.swing.JButton jButton_3_;
    private javax.swing.JButton jButton_4_;
    private javax.swing.JButton jButton_5_;
    private javax.swing.JButton jButton_6_;
    private javax.swing.JButton jButton_7_;
    private javax.swing.JButton jButton_8_;
    private javax.swing.JButton jButton_9_;
    private javax.swing.JButton jButton_Alpha_;
    private javax.swing.JButton jButton_BackgroundColor_;
    private javax.swing.JButton jButton_Black_White_;
    private javax.swing.JButton jButton_Broom_;
    private javax.swing.JButton jButton_Chi_;
    private javax.swing.JButton jButton_Copy_;
    private javax.swing.JButton jButton_Cut_;
    private javax.swing.JButton jButton_Delete_;
    private javax.swing.JButton jButton_Delta_;
    private javax.swing.JButton jButton_Down_;
    private javax.swing.JButton jButton_En_Circumflex_;
    private javax.swing.JButton jButton_Enable_JList_;
    private javax.swing.JButton jButton_End_;
    private javax.swing.JButton jButton_Epsilon_;
    private javax.swing.JButton jButton_Font_Bold_;
    private javax.swing.JButton jButton_Font_Decrease_;
    private javax.swing.JButton jButton_Font_Increase_;
    private javax.swing.JButton jButton_ForegroundColor_;
    private javax.swing.JButton jButton_Gamma_;
    private javax.swing.JButton jButton_Home_;
    private javax.swing.JButton jButton_Insert_;
    private javax.swing.JButton jButton_Iota_;
    private javax.swing.JButton jButton_Ita_;
    private javax.swing.JButton jButton_Kappa_;
    private javax.swing.JButton jButton_Ksi_;
    private javax.swing.JButton jButton_Lamda_;
    private javax.swing.JButton jButton_LeftAlignment_;
    private javax.swing.JButton jButton_Left_;
    private javax.swing.JButton jButton_Mi_;
    private javax.swing.JButton jButton_NewFile_;
    private javax.swing.JButton jButton_Ni_;
    private javax.swing.JButton jButton_Omega_;
    private javax.swing.JButton jButton_Omikron_;
    private javax.swing.JButton jButton_OpenFile_VK_;
    private javax.swing.JButton jButton_Original_Ver_;
    private javax.swing.JButton jButton_PageDown_;
    private javax.swing.JButton jButton_PageUp_;
    private javax.swing.JButton jButton_Paste_;
    private javax.swing.JButton jButton_Phi_;
    private javax.swing.JButton jButton_Pi_;
    private javax.swing.JButton jButton_Psi_;
    private javax.swing.JButton jButton_Redo_;
    private javax.swing.JButton jButton_RightAlignment_;
    private javax.swing.JButton jButton_Right_;
    private javax.swing.JButton jButton_Ro_;
    private javax.swing.JButton jButton_SaveAs_;
    private javax.swing.JButton jButton_Save_;
    private javax.swing.JButton jButton_Sigma_;
    private javax.swing.JButton jButton_Taf_;
    private javax.swing.JButton jButton_Text_Warp_;
    private javax.swing.JButton jButton_Thita_;
    private javax.swing.JButton jButton_Undo_;
    private javax.swing.JButton jButton_Up_;
    private javax.swing.JButton jButton_Vita_;
    private javax.swing.JButton jButton_Ypsilon_;
    private javax.swing.JButton jButton_Zita_;
    private javax.swing.JButton jButton_Zoom_Decrease_;
    private javax.swing.JButton jButton_Zoom_Increase_;
    private javax.swing.JButton jButton_Zoom_Restore_;
    private javax.swing.JButton jButton_altGR_;
    private javax.swing.JButton jButton_alt_;
    private javax.swing.JButton jButton_ano_telia_;
    private javax.swing.JButton jButton_backspace_;
    private javax.swing.JButton jButton_backward_slash_;
    private javax.swing.JButton jButton_caps_;
    private javax.swing.JButton jButton_ctrl_Left_;
    private javax.swing.JButton jButton_ctrl_Right_;
    private javax.swing.JButton jButton_dasia_;
    private javax.swing.JButton jButton_dasia_oxia_;
    private javax.swing.JButton jButton_dasia_oxia_ypogegrammeni_;
    private javax.swing.JButton jButton_dasia_perispomeni_;
    private javax.swing.JButton jButton_dasia_perispomeni_ypogegrammeni_;
    private javax.swing.JButton jButton_dasia_varia_;
    private javax.swing.JButton jButton_dasia_varia_ypogegrammeni_;
    private javax.swing.JButton jButton_dasia_ypogegrammeni_;
    private javax.swing.JButton jButton_dialytika_;
    private javax.swing.JButton jButton_dialytika_oxia_;
    private javax.swing.JButton jButton_dialytika_perispomeni_;
    private javax.swing.JButton jButton_dialytika_tonos_;
    private javax.swing.JButton jButton_dialytika_varia_;
    private javax.swing.JButton jButton_enter_;
    private javax.swing.JButton jButton_equal_;
    private javax.swing.JButton jButton_final_Sigma_;
    private javax.swing.JButton jButton_flag_Win_;
    private javax.swing.JButton jButton_function_;
    private javax.swing.JButton jButton_komma_;
    private javax.swing.JButton jButton_left_shift_;
    private javax.swing.JButton jButton_left_square_bracket_;
    private javax.swing.JButton jButton_letter_Q_;
    private javax.swing.JButton jButton_makron_;
    private javax.swing.JButton jButton_myColorChooser_;
    private javax.swing.JButton jButton_oxia_;
    private javax.swing.JButton jButton_oxia_ypogegrammeni_;
    private javax.swing.JButton jButton_perispomeni_;
    private javax.swing.JButton jButton_perispomeni_ypogegrammeni_;
    private javax.swing.JButton jButton_psili_;
    private javax.swing.JButton jButton_psili_oxia_;
    private javax.swing.JButton jButton_psili_oxia_ypogegrammeni_;
    private javax.swing.JButton jButton_psili_perismpomeni_;
    private javax.swing.JButton jButton_psili_perispomeni_ypogegrammeni_;
    private javax.swing.JButton jButton_psili_varia_;
    private javax.swing.JButton jButton_psili_varia_ypogegrammeni_;
    private javax.swing.JButton jButton_psili_ypogegrammeni_;
    private javax.swing.JButton jButton_right_click_menu_;
    private javax.swing.JButton jButton_right_shift_;
    private javax.swing.JButton jButton_right_square_bracket_;
    private javax.swing.JButton jButton_slash_;
    private javax.swing.JButton jButton_space_;
    private javax.swing.JButton jButton_subtraction_;
    private javax.swing.JButton jButton_symbol_1;
    private javax.swing.JButton jButton_symbol_2;
    private javax.swing.JButton jButton_tab_;
    private javax.swing.JButton jButton_telia_;
    private javax.swing.JButton jButton_tonos_;
    private javax.swing.JButton jButton_varia_;
    private javax.swing.JButton jButton_varia_ypogegrammeni_;
    private javax.swing.JButton jButton_vrachy_;
    private javax.swing.JButton jButton_ypogegrammeni_;
    private javax.swing.JCheckBox jCheckBox_List_;
    private javax.swing.JComboBox<String> jComboBox_FontSize_;
    private javax.swing.JComboBox<String> jComboBox_SystemFonts_;
    private javax.swing.JLabel jLabel_CaretPosition_;
    private javax.swing.JLabel jLabel_ColumnPosition_;
    private javax.swing.JLabel jLabel_Flag_Lang;
    private javax.swing.JLabel jLabel_LinePosition_;
    private javax.swing.JPanel jPanel_Virtual_Keyboard_;
    private javax.swing.JRadioButton jRadioButton_Color_;
    private javax.swing.JRadioButton jRadioButton_Theme_;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField_CaretPosition_;
    private javax.swing.JTextField jTextField_ColumnPosition_;
    private javax.swing.JTextField jTextField_LinePosition_;
    private javax.swing.JList<String> myJList;
    private javax.swing.JTextArea myTextArea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        
        //System.out.println("");
        //System.out.println("=== insertUpdate ===");
        //System.out.println("");
        
        if (flag_space==true) {
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Space.");
            flag_space=false;
            //System.out.println("");
        }
        
        else if (flag_tab==true) {
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Tab.");
            flag_tab=false;
            //System.out.println("");            
        }        
        
        else if (flag_enter==true) {
            //System.out.println("Πατήθηκε τὸ πλῆκτρο Enter.");
            flag_enter=false;
            //System.out.println("");  
        }    
            
        else {
           
        }
           
        try {
            //System.out.println("Λέξη πρὸς ἀναζήτηση: " + "[" + temp + "].");            
            searchFilter(temp);
        }
        
        catch (IOException ex) {
            Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        
        //System.out.println("");
        //System.out.println("=== removeUpdate ===");
        //System.out.println("");
        
        //System.out.println("Πατήθηκε τὸ πλῆκτρο Backspace.");
        stringSize=temp.length()-1;
   
        //System.out.println("temp= " + temp + "[" + stringSize  + "].");
        //System.out.println("");
        
        if (stringSize>=0) {
            temp = temp.substring(0, temp.length() - 1);
        
            try {
                //System.out.println("Λέξη πρὸς ἀναζήτηση: " + "[" + temp + "].");                 
                searchFilter(temp);
                //System.out.println("temp= " + temp);
            }
        
            catch (IOException ex) {
                Logger.getLogger(Virtual_Keyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        else {
            
        }
        
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
   
    // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
         
    // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     
    }
}
