import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class calculatorpanel extends JPanel{    
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, clear, mul, add, minus, equals, div;
    JTextField displayfield;
    GridBagLayout gridbag=new GridBagLayout();
     //public boolean startnumber=true;
     public boolean startnumber=true;
     public String previousOp="=";     
     public CalcLogic logic=new CalcLogic();     
    calculatorpanel(){
        super();
        //GridLayout family=new GridLayout(3, 5, 1, 1);
        
        setLayout(gridbag);//
        OpListener opListener=new OpListener();
        NumListener num=new NumListener();
        ClearListener clearlistener=new ClearListener();
        b0=new JButton("0");
        b0.addActionListener(num);
        b1=new JButton("1");
        b1.addActionListener(num);
        b2=new JButton("2");
        b2.addActionListener(num);
        b3=new JButton("3");
        b3.addActionListener(num);
        b4=new JButton("4");
        b4.addActionListener(num);
        b5=new JButton("5");
        b5.addActionListener(num);
        b6=new JButton("6");
        b6.addActionListener(num);
        b7=new JButton("7");
        b7.addActionListener(num);
        b8=new JButton("8");
        b8.addActionListener(num);
        b9=new JButton("9");
        b9.addActionListener(num);
        add=new JButton("+");
        add.addActionListener(opListener);
        minus=new JButton("-");
        minus.addActionListener(opListener);
        mul=new JButton("*");
        mul.addActionListener(opListener);
        div=new JButton("/");
        div.addActionListener(opListener);
        equals=new JButton("=");
        equals.addActionListener(opListener);
        clear=new JButton("Clear"); 
        clear.addActionListener(clearlistener);
        displayfield=new JTextField("0");
        displayfield.setEditable(false);
        addComponent(displayfield, 0, 0, 9, 1, 150, 10, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
        addComponent(b7, 0, 2, 1, 1, 10, 10 ,GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b8, 2, 2, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b9 , 4, 2, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(add,6,2,1,1, 10, 20, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER);
        addComponent(minus,8, 2, 1, 2, 10, 20, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER);
        addComponent(b4, 0, 4, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b5, 2, 4, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b6, 4, 4, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b1, 0, 6, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b2, 2, 6, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(b3, 4, 6, 1, 1, 10, 10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(mul, 6, 5, 1, 2, 10, 20, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER);
        addComponent(div, 8, 5, 1, 2, 10, 20, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER);
        addComponent(b0, 0, 8, 1,1,20,10, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(clear, 3, 8, 2, 1, 40, 10, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
        addComponent(equals, 5, 8, 2,1,10,10,GridBagConstraints.NONE,GridBagConstraints.CENTER);
        
    }
    private void addComponent(Component component, int gridx, int gridy, int gridwidth,
        int gridheight, int weightx,int weighty, int fill, int anchor)
        {
            
            GridBagConstraints constraints=new GridBagConstraints();
            constraints.gridx=gridx;
            constraints.gridy=gridy;
            constraints.gridwidth=gridwidth;
            constraints.gridheight=gridheight;
            constraints.weightx=weightx;
            constraints.weighty=weighty;
            constraints.fill=fill;
            constraints.anchor=anchor;
            gridbag.setConstraints(component, constraints);
            add(component);
        }
    
    private void actionClear(){
        startnumber=true;
        displayfield.setText("0");
        previousOp="=";
        logic.setTotal("0");
    }
    
    class OpListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //System.out.println(startnumber);
            if(startnumber!=false){
                actionClear();
                displayfield.setText("Error no operator");
            }else{
                startnumber=true;
                try{
                    String displaytext=displayfield.getText();
                    if(previousOp.equals("=")) logic.setTotal(displaytext);
                    else if(previousOp.equals("+")) logic.add(displaytext);
                    else if(previousOp.equals("-")) logic.substract(displaytext);
                    else if(previousOp.equals("*")) logic.multiply(displaytext);
                    else if(previousOp.equals("/")) logic.divide(displaytext);
                    displayfield.setText(""+logic.getTotalString());
                
                }catch(NumberFormatException yo){
                    actionClear();
                    displayfield.setText("Error");
                }
                previousOp=e.getActionCommand();
            }
        }
     }
     class ClearListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
             actionClear();
            }
     }
     class NumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String digit = e.getActionCommand(); 
            if (startnumber) {              
                displayfield.setText(digit);
                startnumber = false;
            } else {
                displayfield.setText(displayfield.getText() + digit);
            }
        }
    }
}

    
       
        
 