package MathematicalBackend;

/**
 * Created by MoloHunt on 28/05/15.
 */

//This is an object to represent complex numbers, normally made up of a real and unreal part
//Written in normal maths as a + bi

public class ComplexNumber {

    private float real; //represents real component
    private float unreal; //The unreal component not the game engine

    //Constructor, uses a + bi form for parameters
    public ComplexNumber(float a, float b){
        real = a;
        unreal = b;
    }

    //Allows you to add two complex numbers, and by that you can also subtract
    public ComplexNumber Add(ComplexNumber c){
        return new ComplexNumber(real + c.getReal(), unreal + c.getUnreal());
    }

    //For use when dividing by 2A
    public ComplexNumber DivideByReal(float divisor){
        return new ComplexNumber(real / divisor, unreal / divisor);
    }

    //allows you to get any complex number as a sting in the form a + bi
    public static String ToString(ComplexNumber compNum){
        return compNum.getReal() + ((compNum.getUnreal() >= 0)? " + " : " ") + compNum.getUnreal() + "i";
    }

    public float getReal(){
        return real;
    }

    public float getUnreal(){
        return unreal;
    }

}
