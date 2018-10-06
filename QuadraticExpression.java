/**
 * 
 * @author Xavier Madera
 * */
public class QuadraticExpression implements Cloneable {

  private double a;
  private double b;
  private double c;

  /**
   * creates a new QuadraticExpression and initializes a, b, and c to 0
   * 
   * */
  public QuadraticExpression() {
    this.a = 0;
    this.b = 0;
    this.c = 0;
  }
  
  /**
   * creates a new QuadraticExpression and initializes a, b, and c to user-provided doubles
   * 
   * @param newA the value a
   * @param newB the value b
   * @param newC the value c
   * 
   * */
  public QuadraticExpression (double newA, double newB, double newC) {
    this.a = newA;
    this.b = newB;
    this.c = newC;
  }
  
  /**
   * Visualizes the called object in the form of a String
   * 
   * no parameters
   * 
   * @return String
   * */
  public String toString() {
    String result = "";
    if(this.a == 0){}
    else { result += a + "x^2 + "; }
    if(this.b == 0) {}
    else { result += b + "x + "; }
    if (this.c == 0) {}
    else { result += c; }
    if (this.a == 0 && this.b == 0 && this.c == 0) { result = "0"; }
    return result;
  }
  
  /**
   * evaluates the called QuadraticExpression object with variable x
   * 
   * @param x The value which is plugged in the solve the quadratic expression
   * 
   * @return double
   * 
   * */
  public double evaluate(double x) {
    return ((this.a * (x * x)) + (this.b * x) + this.c);
  }
  
  /**
   * Methods with the soul purpose of changing instance variables in the called QuadraticExpression object
   * 
   * @param newA: the new value of a
   * 

   * */
  public void setA(double newA) { this.a = newA; }
  
  /**
   * Methods with the soul purpose of changing instance variables in the called QuadraticExpression object
   * 
   * @param newB the new value of b
   * 
   * */
  public void setB(double newB) { this.b = newB; }
  
  /**
   * Methods with the soul purpose of changing instance variables in the called QuadraticExpression object
   * 
   * @param newC the new value of c
   * 
   * */
  public void setC(double newC) { this.c = newC; }
  
  /**
   * Takes two QuadraticExpression references and adds the two objects together, returning a new QuadraticExpression
   * 
   * @param q1 The first QuadraticExpression object to be added
   * @param q2 The second QuadraticExpression object to be added
   * 
   * @return QuadraticExpression
   * */
  public static QuadraticExpression sum(QuadraticExpression q1, QuadraticExpression q2) {
    QuadraticExpression result = new QuadraticExpression((q1.a + q2.a), (q1.b + q2.b), (q1.c + q2.c));
    return result;
  }
  
  /**
   * multiplies the desired QuadraticExpression's instance variables by the designated double, r,
   * and returns a new QuadraticExpression
   * 
   * @param r: the number to multiply with
   * @param q: the QuadraticExpression object which its instance variables multiplied
   * 
   * @return QuadraticExpression
   * */
  public static QuadraticExpression scale(double r, QuadraticExpression q) {
    QuadraticExpression result = new QuadraticExpression((q.a * r), (q.b * r), (q.c * r));
    return result;
  }
  
  /**
   * Determines how many roots the called QuadraticExpression Object has
   * 
   * no parameters
   * 
   * @return int
   * */
  public int numberOfRoots() {
    int result = 0;
    if ((this.a == 0 && this.b == 0 && this.c != 0) || (this.a != 0 && (this.b * this.b) < 4 * this.a * this.c)) { result = 0; }
    else if ((this.a == 0 && this.b != 0) || (this.a != 0 && (this.b * this.b) == 4 * this.a * this.c)) { result = 1; }
    else if ((this.a != 0 && (this.b* this.b) > 4 * this.a * this.c)) { result = 2; }
    else if (this.a == 0 && this.b == 0 && this.c == 0) {result = 3; }
    return result;
  }
  
  /**
   * Adds the parameter QuadraticExpression's instance variables to the called
   * Quadratic Expression
   * 
   * @param q: the QuadraticExpression whose values are being added
   * */
  public void add(QuadraticExpression q) {
    this.a += q.a;
    this.b += q.b;
    this.c += q.c;
  }
  
  /**
   * finds the called QuadraticExpression Object's smallest root (if any), or throws an
   * Exception if there are no roots
   * 
   * no parameters
   * 
   * @throws Exception if there are no roots
   * @return double
   * */
  public double smallerRoot() throws Exception {
    double result = 0;
    double r1;
    double r2;
    if (this.numberOfRoots() == 0) {
      throw new Exception("no solution");
    }
    else if (this.numberOfRoots() == 1) {
      if (this.a != 0 && ((this.b * this.b) == 4 * this.a * this.c)) { result = (-this.b)/(2*this.a); }
      else {result = -this.c / this.b; }
    }
    else if (this.numberOfRoots() == 2) {
      r1 = (-this.b + Math.sqrt((this.b*this.b) - (4.0 * this.a) * this.c)) / (2.0 * this.a);
      r2 = (-this.b - Math.sqrt((this.b*this.b) - (4.0 * this.a) * this.c)) / 2.0 * this.a;
      if (r1 > r2) {result = r2;}
      else {result = r1;}
    }
    else if (this.numberOfRoots() == 3) {
      result = -Double.MAX_VALUE;
    }
    return result;
  }
  
  /**
   * Finds the called QuadraticExpression Object's largest root (if any), or throws an Exception
   * if there are no roots
   * 
   * no parameters
   * 
   * @throws Exception if there are no roots
   * @return double
   * */
  public double largerRoot() throws Exception {
    double result = 0;
    double r1;
    double r2;
    if (this.numberOfRoots() == 0) {
      throw new Exception();
    }
    else if (this.numberOfRoots() == 1) {
      if (this.a != 0 && ((this.b * this.b) == 4 * this.a * this.c)) { result = (-this.b)/(2*this.a); }
      else {result = -this.c / this.b; }
    }
    else if (this.numberOfRoots() == 2) {
      r1 = (-this.b + Math.sqrt((this.b*this.b) - (4.0 * this.a) * this.c)) / 2.0 * this.a;
      r2 = (-this.b - Math.sqrt((this.b*this.b) - (4 * this.a) * this.c)) / 2 * this.a;
      if (r1 > r2) {result = r1;}
      else {result = r2;}
    }
    else if (this.numberOfRoots() == 3) {
      result = Double.MAX_VALUE;
    }
    return result;
  }
  
  /**
   * Determines whether all the parameter QuadraticExpression object's and the calling object's
   * instance variables are equal
   * 
   * @param arg: the QuadraticExpression Object which is being tested for equity
   * 
   * @return boolean
   * */
  public boolean equals(QuadraticExpression arg){
    return (this.a == arg.a && this.b == arg.b && this.c == arg.c);
  }
  
  /**
   * Clones the calling QuadraticExpression object
   * 
   * no parameters
   * 
   * @return QuadraticExpression
   * */
  public QuadraticExpression clone(){
    QuadraticExpression result;
    try {
      result = (QuadraticExpression) super.clone();
    }
    catch (CloneNotSupportedException e) {
      throw new RuntimeException
        ("This class does not implement Cloneable.");
    }
    return result;
  }
  
  
}