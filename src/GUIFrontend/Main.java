package GUIFrontend;

import MathematicalBackend.EquationSolver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by MoloHunt on 28/05/15.
 */
public class Main extends Frame implements ActionListener{

    public final String WINDOW_NAME = "Quadratic Equation";

    private TextArea labelAnswer;
    private TextField fieldA, fieldB, fieldC;

    //First function called
    public static void main(String[] args) {
        new Main(); //creates new main object and calls constructor
    }

    //Main constructor, creates the GUI window
    public Main() {
        setLayout(new FlowLayout());
        Label labelPromptA = new Label("AX^2 where A = ", Label.LEFT);
        labelPromptA.setSize(115, 20);
        add(labelPromptA);

        fieldA = new TextField(10);
        add(fieldA);

        Label labelPromptB = new Label("BX  where B = ", Label.LEFT);
        labelPromptB.setSize(115, 20);
        add(labelPromptB);

        fieldB = new TextField(10);
        add(fieldB);

        Label labelPromptC = new Label("C  where C = ", Label.LEFT);
        labelPromptC.setSize(115, 20);
        add(labelPromptC);

        fieldC = new TextField(10);
        add(fieldC);

        Button buttonCompute = new Button("Compute Answer");
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
        float[] parsedNumbers = new float[3];
        boolean[] parsedCorrectly = new boolean[parsedNumbers.length];
        TextField[] textFields = {fieldA, fieldB, fieldC};

        for (int i = 0; i < parsedNumbers.length; i++) {
            try {
                parsedNumbers[i] = Float.parseFloat(textFields[i].getText());
                parsedCorrectly[i] = true;
            } catch (NumberFormatException ex) {
                textFields[i].setText("(Error)");
                parsedCorrectly[i] = false;
            }
        }

        //If all values in the parsedCorrectly array are true (meaning all numbers were parsed correctly)
        if (Arrays.equals(parsedCorrectly, new boolean[] {true, true, true})) {
            EquationSolver solver = new EquationSolver(parsedNumbers[0], parsedNumbers[1], parsedNumbers[2]);
            labelAnswer.setText(solver.Solve());
        }
    }
}
