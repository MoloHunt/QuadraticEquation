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
    private TextField[] inputFields = new TextField[3];

    //First function called
    public static void main(String[] args) {
        new Main(); //creates new main object and calls constructor
    }

    //Main constructor, creates the GUI window
    public Main() {
        setLayout(new FlowLayout());

        String[] labels = {"AX^2 where A = ", "BX where B = ", "C where C = "};

        for (int i = 0; i < inputFields.length; i++) {
            Label label = new Label(labels[i], Label.LEFT);

            label.setSize(115, 20);
            inputFields[i] = new TextField(10);
            add(label);
            add(inputFields[i]);
        }

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

        for (int i = 0; i < parsedNumbers.length; i++) {
            try {
                parsedNumbers[i] = Float.parseFloat(inputFields[i].getText());
                parsedCorrectly[i] = true;
            } catch (NumberFormatException ex) {
                inputFields[i].setText("(Error)");
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
