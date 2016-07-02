import javax.swing.*;
public class calculatorframe extends JFrame{
    public calculatorframe(){
        super("Calculator");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        calculatorpanel panel= new calculatorpanel();
        add(panel);
        //pack();
        setVisible(true);
    }
    private void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Couldn't use the system "
                + "look and feel: " + exc);
        }
    }
    public static void main(String[] args){
        calculatorframe f=new calculatorframe();
    }
}