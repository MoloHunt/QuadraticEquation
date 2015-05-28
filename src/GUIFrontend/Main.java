package GUIFrontend;

import MathematicalBackend.EquationSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MoloHunt on 28/05/15.
 */
public class Main extends Frame implements ActionListener{

    public final String WINDOW_NAME = "Quadratic Equation";

    private Label labelPromptA, labelPromptB, labelPromptC;
    private TextArea labelAnswer;
    private TextField fieldA, fieldB, fieldC;
    private Button buttonCompute;

    private EquationSolver solver;

    //First function called
    public static void main(String[] args) {
        new Main(); //creates new main object and calls constructor
    }

    //Main constructor, creates the GUI window
    public Main(){
        setLayout(new FlowLayout());
        labelPromptA = new Label("AX^2 where A = ", Label.LEFT);
        labelPromptA.setSize(115, 20);
        add(labelPromptA);

        fieldA = new TextField(10);
        add(fieldA);

        labelPromptB = new Label("BX  where B = ", Label.LEFT);
        labelPromptB.setSize(115, 20);
        add(labelPromptB);

        fieldB = new TextField(10);
        add(fieldB);

        labelPromptC = new Label("C  where C = ", Label.LEFT);
        labelPromptC.setSize(115, 20);
        add(labelPromptC);

        fieldC = new TextField(10);
        add(fieldC);

        buttonCompute = new Button("Compute Answer");
        buttonCompute.addActionListener(this);
        add(buttonCompute);

        labelAnswer = new TextArea("Hello World", 3, 20, TextArea.SCROLLBARS_NONE);
        labelAnswer.setSize(220, 60);
        add(labelAnswer);

        pack();
        setSize(240, 200);
        setResizable(false);
        setTitle(WINDOW_NAME);
        setVisible(true);
    }


    //When the compute button is pressed this function fires off
    //it check to see if all of the inputs are fine and then updates the label
    @Override
    public void actionPerformed(ActionEvent e) {
        float a = 0, b = 0, c = 0;
        boolean aCorrect, bCorrect, cCorrect;
        try{
            a = Float.parseFloat(fieldA.getText());
            aCorrect = true;
        }catch(Exception ex){
            fieldA.setText("");
            aCorrect = false;
        }

        try{
            b = Float.parseFloat(fieldB.getText());
            bCorrect = true;
        }catch(Exception ex){
            fieldB.setText("");
            bCorrect = false;
        }

        try{
            c = Float.parseFloat(fieldC.getText());
            cCorrect = true;
        }catch(Exception ex){
            fieldC.setText("");
            cCorrect = false;
        }

        if(aCorrect && bCorrect && cCorrect){
            solver = new EquationSolver(a, b, c);
            labelAnswer.setText(solver.Solve());
        }
    }
}
