package vistas.fraccion;
class Fraccion {
    private int numerador;
    private int denominador;
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    public Fraccion(int entero) {
        this(entero, 1);
    }
    public Fraccion(){
        this(0,1);
    }
    public Fraccion(Fraccion fraccion){
        this(fraccion.numerador, fraccion.denominador);
    }
    public Fraccion clone(){
        return new Fraccion(this);
    }
    private void simplificar() {
        int mcd = this.calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }
    private int calcularMCD(int a, int b) {
        while (b != 0){
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }
    public Fraccion sumar(Fraccion fraccion){
        assert fraccion != null;
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }
    public void oponer(){
        numerador = -numerador;
    }
    public Fraccion opuesta(){
        Fraccion fraccion = this.clone();
        fraccion.oponer();
        return fraccion;
    }
    public void invertir(){
        assert numerador !=0: "no se puede invertir una fraccion con numerador cero";
        int temporal=numerador;
        numerador=denominador;
        denominador= temporal;
        this.simplificar();
    }
    public Fraccion inversa(){
        Fraccion fraccion = this.clone();
        fraccion.invertir();
        return fraccion;
    }
    public boolean equals(Fraccion fraccion){
        assert fraccion !=null;
        return numerador==fraccion.numerador && denominador == fraccion.denominador;
    }
    public double aDecimal(){
        return (double) numerador / denominador;
    }
    public void mostrar(){
        Console console = new Console();
        if (denominador == 1){ console.writeIn(String.valueOf(numerador));  }
    else { console.writeln(numerador + "/" + denominador); }
    }
    public void recoger(){
        Console console = new Console();
        boolean valido=false;
        do {
            numerador = console.readInt("Numerador?");
            denominador = console.readInt("Denominador?");
            valido = denominador != 0;
            if (!valido) console.writeln("Error: El denominador no puede ser cero.");
        } while (!valido);
        this.simplificar();
    }
}
