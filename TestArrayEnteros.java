package busqueda;

import java.util.Scanner;

public class TestArrayEnteros {

public static void main(String[] args) {

arraenteros array1 = new arraenteros(5);
array1.IntroducirDatos();
array1.ordenacionBurbuja();
array1.visualizarArray();
array1.sumaParImpares();
array1.productoPrimo();

/*arraenteros array2 = new arraenteros(5);
array2.IntroducirDatos();
array2.ordenacionBurbuja();
array2.visualizarArray();

arraenteros array3 = array1.fusion(array2);
array3.visualizarArray();
*/
/*array1.VisualizarArray();

arrayenteros array2 = new arrayenteros(array1);
array2.VisualizarArray();

arrayenteros array3 = new arrayenteros();
array3.IntroducirDatos();
array3.VisualizarArray();
*/

//array1.insertar();
//array1.VisualizarArray();

//array1.eliminar();
//array1.VisualizarArray();
/*int buscado = pedirBuscado();
int posicion = array1.busquedaSecuencial3(buscado);

boolean encontrado = (posicion != -1);
if(encontrado)
System.out.println(buscado + " Ha sido encontrado en la posicion " + posicion);
else
System.out.println(buscado + " No ha sido encontrado");
*/

}
public static int pedirBuscado()
	{
	System.out.println("Introuzca el numero a buscar");
	Scanner entrada = new Scanner(System.in);
	return entrada.nextInt();
}


}