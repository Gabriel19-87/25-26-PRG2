import java.util.Scanner;

class ExamenMina {

    public static void main(String[] args) {
        String[][] mapaMostrar = obtenerMapaMostrar();
        String[][] mapaActivas = obtenerMapaActivas();
    }

    static String[][] obtenerMapaMostrar() {
        return new String[][] {
            {" ", "1", "2", "3", "4", "5", "6", "7"},
            {"1", "-", "-", "-", "-", "-", "-", "-"},
            {"2", "-", "-", "-", "-", "-", "-", "-"},
            {"3", "-", "-", "-", "-", "-", "-", "-"},
            {"4", "-", "-", "-", "-", "-", "-", "-"},
            {"5", "-", "-", "-", "-", "-", "-", "-"}
        };
    }

    static String[][] obtenerMapaActivas() {
        return new String[][] {
            {" ", "1", "2", "3", "4", "5", "6", "7"},
            {"1", "0", "0", "0", "0", "0", "0", "0"},
            {"2", "0", "0", "0", "0", "0", "0", "0"},
            {"3", "0", "0", "0", "0", "0", "0", "0"},
            {"4", "0", "0", "0", "0", "0", "0", "0"},
            {"5", "0", "0", "0", "0", "0", "0", "0"}
        };
    }
}
    static void colocarMinas(String[][] mapaActivas) {
        int i = 0;
        final int TOTAL_MINAS = 5;
        while (i < TOTAL_MINAS) {
            int posYMina = (int) (Math.random() * 2 + 1);
            int posXMina = (int) (Math.random() * 4 + 1);
            if (mapaActivas[posXMina + 1][posYMina + 1].equals("1")) {
                i--;
            } else {
                mapaActivas[posXMina + 1][posYMina + 1] = "1";
            }
            i++;
        }
    }
    static void imprimir(String[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println(" ");
        }
    }

    static int[] elegirPosicion() {
        Scanner scan = new Scanner(System.in);
        int x, y;
        boolean valoresCorrectos = false;
        do {
            System.out.println(" ");
            System.out.println("Ingrese X");
            y = scan.nextInt();
            System.out.println("Ingrese Y");
            x = scan.nextInt();
            if (x <= 5 && y <= 7) {
                valoresCorrectos = true;
            }
        } while (!valoresCorrectos);
        return new int[] { x, y };
    }
	//Posiciones Random de la mina
	public static void main(String[] args){	
	Scanner scan = new Scanner(System.in);
		///////////////////////////
		int i=0;	
		while ( i < 5){
			int PosYMina = (int)(Math.random()*2+1);
			int PosXMina = (int)(Math.random()*4+1);
			if (mapaMinasActivas[PosXMina][PosYMina]=="1"){
			i=i-1;
			}
			else {
				mapaMinasActivas[PosXMina+1][PosYMina+1]="1";
			}
			i++;
		}
	
		int posX=0, posY=0, juegoEncendido=1, valoresCorrectos, contadorMapa=0, contadorMinas=0;
		/////////////Comienza el juego
		while(juegoEncendido==1){
			for( i = 0; i<mapaMinasMostrar.length; i++){            
				for (int j = 0; j<=mapaMinasMostrar.length+1; j++) {                                     
					System.out.print(mapaMinasMostrar[i][j]);
				}
				System.out.println(" ");
			}
			valoresCorrectos=0;//reseteo de la variable
			while(valoresCorrectos==0){
				System.out.println(" ");
				System.out.println("Ingrese X");
				posY = scan.nextInt();
				System.out.println("Ingrese Y");
				posX = scan.nextInt();
				if(posX>5){
					valoresCorrectos=0;
				}
				else if(posY>7){
					valoresCorrectos=0;
				}
				else{
					valoresCorrectos=1;
				}
			}

			if(mapaMinasActivas[posX][posY]=="1"){
			mapaMinasMostrar[posX][posY]="x";
			contadorMinas++;
			}
			else if(mapaMinasActivas[posX][posY]=="0"){
			mapaMinasMostrar[posX][posY]=".";
			}
			else{
			System.out.println("No es correcta esa opcion.");
			}
			
			contadorMapa++;
			if(contadorMinas>2){
				juegoEncendido=0;
				System.out.println("Has perdido");
			}
			else if(contadorMapa>=31){
				System.out.println("Felicidades Ganador!");
				juegoEncendido=0;
			}
			else{
				
			}
		}
	}	
		
		
}