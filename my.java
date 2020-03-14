//mail is wuqiangheng33@163.com


import java.time.*;
import java.time.format.*;
import java.util.List;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;


public class MyJava{
public static void main(String[] Args){
//System.out.println("Total :"+3+3+"good");

ViEditor me = new ViEditor();
me.area.setText("");

new Time_demo();

String fn,s;
String[] ss;
ArrayList<String> as;
fn="E:/ebook/java/pdf";
fn="E:/ebook/java/epub";
fn="E:/ebook/java/";
fn="D:/movie/zhujiao";
fn="D:/movie/aa";
fn="E:/1/c/a";

File tempf=new File(fn);
System.out.println(tempf.getName()+" ");


/*
File_Demo_Ls ls=new File_Demo_Ls(fn,1000);
as=File_Demo_Ls.as;
for(String s0:as)
me.area.append(s0+'\n');
*/
}
}



/* ___________________________________
* this is a demo for time and date
* time time->chrono,format...
* The 'Date' is depricate, 
* use the 'LocalDate' instead (since java 8)
*/
class Time_demo{
Time_demo() {
_print_time();
}

void _print_time(){ 
//below is a wrong code!! needn't the new
// LocalDate nd=new LocalDate().now();
//1. not new
//2. not LocalDate(), 
//  its LocalDate.now();!!!!!!!!!!!!!
LocalDate nd= LocalDate.now();
System.out.println(nd);
LocalTime nt= LocalTime.now();
System.out.println(nt);
LocalDateTime n= LocalDateTime.now();
System.out.println(n);
}
}






/*___________________________________
this is a class for demo of the java.io.File
boolean exists() True if something of that name exists
String getCanonicalPath();  Full name
String getName();  Relative filename
String getParent();  Parent directory
boolean canRead();  True if file is readable
boolean canWrite();  True if file is writable
long lastModified();  File modification time
long length();  File size
boolean isFile();  True if it’s a file;
true if it’s a directory
(note: it might be neither)
File f=new File('tmp');
//create new file
f.createNewFile();
;
//rename a file
f.renameTo(new File("junk.dat"));
;
//delete a file
f.delete();
;
//change file attribute
Use setReadOnly() or setLastModified().
;
//list directory
File dir=File("d");
String[] fns=dir.list();
File[] fs=dir.listFiles();
;
//create directory use mkdirs or mkdir
new File("/home/ian/bin").mkdir( );
new File("/home/ian/1/2/3/4/5/6").mkdirs( );
*/
class File_Demo_Ls{
public String EE="---------------";
//public static java.util.List as=new ArrayList<String>();
public static ArrayList<String> as=new ArrayList<String>();
public static File[] files;
public static int current_level=0;
public static int max_level=1;
String s;

File_Demo_Ls(){
this(".");
}
File_Demo_Ls(String fn){
this(fn,10000);
}
File_Demo_Ls(String fn,int i){
File f=new File(fn);
if(i>0)
max_level=i;
if(f.isDirectory())
set(f);
}

void set(File f){
if(current_level>max_level)
return;
if(f.isDirectory()){
current_level=current_level+1;
as.add("\n"+EE +f.getName()+EE);
s="###current_level "+current_level;
as.add(s);
for(String s4:f.list())
as.add(s4);
}
if(f.isDirectory()){
//as.addAll(ars);
for (File tf: f.listFiles())
set(tf);
current_level=current_level-1;
}
}
}


/*
* this my editor like vim
*/

class ViEditor{
public int k,j;
public String s,s1,s2;
//public JPanel pnl;
public JLabel lb;
public JScrollPane sp;
public JTextArea area;
public JFrame frame;
public JTextField cmdline ;
public final Font fnt=new Font("courier",Font.BOLD,19);

//___________________________________
//this is for the KeyListener inner class
//key event for sp
public class ViKeyEvent extends KeyAdapter{
public void keyTyped(KeyEvent e){
char c = e.getKeyChar();
String s=String.valueOf(c);
//"\uA1F5" is a white block
//"\uA1F6" is a black block
String w=	"\uA1F5";
String b=	"\uA1F6";
s=s+w;
System.out.println(s);
area.append(s);
}
}
//___________________________________


//constructor
public ViEditor() {
create();
setUp();
//	area.setEnabled(false);
sp.requestFocusInWindow();
sp.requestFocus();
}

public void create() {
frame = new JFrame();
//JPanel pnl;
lb = new JLabel("JLabel");
area = new JTextArea();
sp = new JScrollPane(area);
cmdline=new JTextField();
}


public void setUp() {
area.setRows(20);
//len=(area.getKeyListeners()).length;
area.addKeyListener(new ViKeyEvent()); 
sp.addKeyListener(new ViKeyEvent()); 
area.setColumns(40);
//area.setLineWrap(true);
//area.setWrapStyleWord(true);
area.setTabSize(2);
area.setFont(fnt);
area.setText("hollo swing!\n");
//Font font=new Font("courier",Font.BOLD,20);
cmdline.setFont(fnt);
cmdline.requestFocus();
cmdline.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
area.append(cmdline.getText()+"\n");
cmdline.setText("");
}
});
//BorderLayout layout = new BorderLayout();
frame.setSize(200,200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(sp,BorderLayout.CENTER);
frame.add(cmdline,BorderLayout.SOUTH);
frame.pack();
frame.setVisible(true);
}
}


/* this is TextDemo
*
void keyTyped(KeyEvent e){
//You should only rely on the key char if the event
//is a key typed event.
int id = e.getID();
String keyString;
if (id == KeyEvent.KEY_TYPED) {
char c = e.getKeyChar();
keyString = "key character = '" + c + "'";
} else {
int keyCode = e.getKeyCode();
keyString = "key code = " + keyCode
+ " ("
+ KeyEvent.getKeyText(keyCode)
+ ")";
}

int modifiersEx = e.getModifiersEx();
String modString = "extended modifiers = " + modifiersEx;
String tmpString = KeyEvent.getModifiersExText(modifiersEx);
if (tmpString.length() > 0) {
modString += " (" + tmpString + ")";
} else {
modString += " (no extended modifiers)";
}

String actionString = "action key? ";
if (e.isActionKey()) {
actionString += "YES";
} else {
actionString += "NO";
}

String locationString = "key location: ";
int location = e.getKeyLocation();
if (location == KeyEvent.KEY_LOCATION_STANDARD) {
locationString += "standard";
} else if (location == KeyEvent.KEY_LOCATION_LEFT) {
locationString += "left";
} else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
locationString += "right";
} else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
locationString += "numpad";
} else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
locationString += "unknown";
}

displayArea.append(keyStatus + newline
+ "    " + keyString + newline
+ "    " + modString + newline
+ "    " + actionString + newline
+ "    " + locationString + newline);
displayArea.setCaretPosition(displayArea.getDocument().getLength());
}
*/



