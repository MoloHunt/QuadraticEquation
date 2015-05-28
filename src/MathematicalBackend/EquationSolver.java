package MathematicalBackend;

/**
 * Created by MoloHunt on 28/05/15.
 */

//The class which handles solving the equation
public class EquationSolver {

    private float a, b, c; //Holds the variables of the quadratic equation
    private float determinant; //Key part of the equation

    public EquationSolver(float _a, float _b, float _c){
        a = _a;
        b = _b;
        c = _c;
        determinant = (b * b) - (4 * a * c); //b squared minus 4 a c
    }

    //Returns the two possible values of x, needs to be a string for obvious reasons
    public String Solve(){
        if(determinant >= 0){
            return RealAnswer(); //Real as in no complex components
        }else{
            return ComplexAnswer(); //Determinant is negative therefore the answer is complex
        }
    }

    private String RealAnswer(){
        float topLinePlus = (-b) + (float)Math.sqrt(determinant);
        float topLineMinus = (-b) - (float)Math.sqrt(determinant);
        float divisor = 2 * a;

        return "X = " + Float.toString(topLinePlus / divisor) + " or " + Float.toString(topLineMinus / divisor);
    }

    private String ComplexAnswer(){
        ComplexNumber topLinePlus  = new ComplexNumber(-b,  +(float)Math.sqrt(-determinant));
        ComplexNumber topLineMinus = new ComplexNumber(-b,  -(float)Math.sqrt(-determinant));
        float divisor = 2 * a;

        return "X = " + ComplexNumber.ToString(topLinePlus.DivideByReal(divisor)) + " or " + ComplexNumber.ToString(topLineMinus.DivideByReal(divisor));
    }
}
