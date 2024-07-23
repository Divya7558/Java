import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
class OnlineTest extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
JLabel label;
JRadioButton radioButton[] = new JRadioButton[5];
JButton btnNext, btnBookmark, btnBack, btnResult;
ButtonGroup bg;
int count = 0, current = 0, x = 1, y = 1, now = 0;
int m[] = new int[10];
// create jFrame with radioButton and JButton
OnlineTest(String s) {
super(s);
label = new JLabel();
add(label);
bg = new ButtonGroup();
for (int i = 0; i < 5; i++) {
radioButton[i] = new JRadioButton();
add(radioButton[i]);
bg.add(radioButton[i]);
}
btnNext = new JButton("Next");
btnBack = new JButton("Back");
btnBookmark = new JButton("Bookmark");
btnResult = new JButton("Result");
btnNext.addActionListener(this);
btnBack.addActionListener(this);
btnBookmark.addActionListener(this);
btnResult.addActionListener(this);
add(btnNext);
add(btnBookmark);
add(btnBack);
add(btnResult);
set();
label.setBounds(30, 40, 450, 20);
radioButton[0].setBounds(50, 80, 200, 20);
radioButton[0].setBounds(50, 80, 450, 20);
radioButton[1].setBounds(50, 110, 200, 20);
radioButton[2].setBounds(50, 140, 200, 20);
radioButton[3].setBounds(50, 170, 200, 20);
btnNext.setBounds(100, 240, 100, 30);
btnBack.setBounds(440, 240, 100, 30);
btnBookmark.setBounds(270, 240, 100, 30);
btnResult.setBounds(590, 240, 100, 30);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
setLocation(250, 100);
setVisible(true);
setSize(600, 350);
}
// handle all actions based on event
public void actionPerformed(ActionEvent e) {
if (e.getSource() == btnNext) {
if (check())
count = count + 1;
current++;
set();
if (current == 9) {
btnNext.setEnabled(false);
btnBookmark.setText("Submit");
}
}
if (e.getActionCommand().equals("Bookmark")) {
JButton bk = new JButton("Bookmark" + x);
bk.setBounds(480, 20 + 30 * x, 100, 30);
add(bk);
bk.addActionListener(this);
m[x] = current;
x++;
current++;
set();
if (current == 9)
btnBookmark.setText("Submit");
setVisible(false);
setVisible(true);
}
for (int i = 0, y = 1; i < x; i++, y++) {
if (e.getActionCommand().equals("Bookmark" + y)) {
if (check())
count = count + 1;
now = current;
current = m[y];
set();
((JButton) e.getSource()).setEnabled(false);
current = now;
}
}
if (e.getActionCommand().equals("Submit")) {
if (check())
count = count + 1;
current++;
JOptionPane.showMessageDialog(this, "Congratulations!!!! Your Exam 
Submitted SuccessFully!!!!!");
//JOptionPane.showMessageDialog(this, "correct answers= " + count);
//System.exit(0);
}
if (e.getActionCommand().equals("Result")) {
if (check())
count = count + 1;
current++;
//JOptionPane.showMessageDialog(this, "Congratulations!!!! Your Exam 
Submitted SuccessFully!!!!!");
JOptionPane.showMessageDialog(this, "correct answers= " + count);
System.exit(0);
}
}
// SET Questions with options
void set() {
radioButton[1].setSelected(true);
if (current == 0) {
label.setText("Que1: Total JDBC drivers available is _____________?");
radioButton[0].setText("3");
radioButton[1].setText("4");
radioButton[2].setText("2");
radioButton[3].setText("1");
}
if (current == 1) {
label.setText("Que2: Which driver is known as the thin driver in 
JDBC?");
radioButton[0].setText("Type 3");
radioButton[1].setText("Type 4");
radioButton[2].setText("Type 2");
radioButton[3].setText("Type 1");
}
if (current == 2) {
label.setText("Que3: TCP, FTP, SMTP, Telnet are examples of?");
radioButton[0].setText("Protocol");
radioButton[1].setText("IP Address");
radioButton[2].setText("Socket");
radioButton[3].setText("Port Number");
}
if (current == 3) {
label.setText("Que4: Identify the class used for connection-less socket 
programming.?");
radioButton[0].setText("Datagram socket");
radioButton[1].setText("Datagram packet");
radioButton[2].setText("Both A and B");
radioButton[3].setText("None of Above");
}
if (current == 4) {
label.setText("Que5: Total TCP/IP ports reserved for specific protocol 
is.______");
radioButton[0].setText("1024 ");
radioButton[1].setText("2048");
radioButton[2].setText("512");
radioButton[3].setText("32");
}
if (current == 5) {
label.setText("Que6:What is the total number of bits in a single IP 
address? ");
radioButton[0].setText("32");
radioButton[1].setText("4");
radioButton[2].setText("8");
radioButton[3].setText("16");
}
if (current == 6) {
label.setText("Que7: Which of the following option leads to the 
portability and security of Java?");
radioButton[0].setText("Dynamic binding between objects");
radioButton[1].setText("Bytecode is executed by JVM");
radioButton[2].setText("Use of exception handling");
radioButton[3].setText("The applet makes the java code secure and 
portable");
}
if (current == 7) {
label.setText("Que8:What are the major components of the JDBC? ");
radioButton[0].setText("DriverManager,Statement and ResultSet");
radioButton[1].setText("DriverManager,Statement and 
ResultSet,Connection");
radioButton[2].setText("DriverManger,Driver,Connection,Statement and 
ResultSet");
radioButton[3].setText("DriverManager,Statement,Connection and 
Statement");
}
if (current == 8) {
label.setText("Que9: Which is responsible for getting a connection to the 
database?");
radioButton[0].setText("Driver");
radioButton[1].setText("Connection");
radioButton[2].setText("Statement");
radioButton[3].setText("ResultSet");
}
if (current == 9) {
label.setText("Que10: How constructor can be used for a servlet?");
radioButton[0].setText("Initialization and constructor Function");
radioButton[1].setText("Setup() Method");
radioButton[2].setText("Initialization");
radioButton[3].setText("constructor Function");
}
label.setBounds(30, 40, 450, 20);
for (int i = 0, j = 0; i <= 90; i += 30, j++)
radioButton[j].setBounds(50, 80 + i, 500, 20);
}
// declare right answers.
boolean check() {
if (current == 0)
return (radioButton[1].isSelected());
if (current == 1)
return (radioButton[1].isSelected());
if (current == 2)
return (radioButton[0].isSelected());
if (current == 3)
return (radioButton[2].isSelected());
if (current == 4)
return (radioButton[0].isSelected());
if (current == 5)
return (radioButton[0].isSelected());
if (current == 6)
return (radioButton[1].isSelected());
if (current == 7)
return (radioButton[2].isSelected());
if (current == 8)
return (radioButton[0].isSelected());
if (current == 9)
return (radioButton[0].isSelected());
return false;
}
public static void main(String s[]) {
new OnlineTest("Online Test App");
}
}
