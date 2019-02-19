package busqueda;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class arraenteros {

//Atributos:

private int Array[];

private int tamMax;

private int numElem;

//Constructores:

public arraenteros(int tamMax)
{

this.tamMax = tamMax;

Array = new int [tamMax];

numElem = 0;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public arraenteros()
{

//Introducimos por teclado el tamaño

Scanner entrada = new Scanner(System.in);
System.out.println("Introduce el tamaño maximo de la array");

tamMax = entrada.nextInt();

Array = new int [tamMax];

numElem = 0;

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Contructor copia

public arraenteros(arraenteros copia)
{
tamMax = copia.tamMax;
numElem = copia.numElem;
Array = new int [tamMax];

for(int i = 0 ; i < numElem; i++)
{
Array [i] = copia.Array[i];
}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Introducir datos

public void IntroducirDatos()
{
Scanner entrada = new Scanner(System.in);

System.out.println("Introduzca los datos y teclee 999 para salir");

boolean salir;

do
{

int dato = entrada.nextInt();
salir = (dato == 999 || numElem == tamMax);

if(!salir)
{

Array [numElem] = dato;
numElem++;

}

}while(!salir);

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void visualizarArray()
{
System.out.println("\n\n");

for(int i = 0; i < numElem; i++)
{
System.out.print(Array[i] + " ");
}

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public boolean ArrayVacio()
{
return (numElem == 0);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public boolean ArrayLleno()
{
return (numElem == tamMax);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
* Este método pide por teclado la posicion donde vamos a intertar el elemento.
* Tiene que ser una poscion ocupada, de manera que no se pierda la infromacion que tenia la array.
*/

public void insertar()
{

if(ArrayLleno())
{
System.out.println("El array esta lleno");
}else
{

//Creamos un Scannere para introducir la posicion y el elemento

Scanner entrada = new Scanner(System.in);

//Introducir una posicion validad de la array

boolean posValidar;


int pos = entrada.nextInt();

System.out.println("Introduce la posición donde lo quieres insertar:");

do
{

posValidar = (pos >= 0 && pos <= numElem);

if(!posValidar)
{
System.out.println("Posición no valida");
}

}while(!posValidar);

//Introducimoss el elemento

System.out.println("Introduca el elemento que va ha insertar");

int elem = entrada.nextInt();

//Movemos los elementos a la siguiente posicion

for(int i = numElem; i > pos; i--)
{

Array[i] = Array[i-1];

}

//Guardamos el elemento en la posicion.

Array[pos] = elem;
numElem++;
}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void eliminar()
{
if(ArrayLleno())
{
System.out.println("El array esta lleno");
}else
{

//Creamos un Scannere para introducir la posicion y el elemento

Scanner entrada = new Scanner(System.in);

//Introducir una posicion validad de la array

boolean posValidar;


int pos = entrada.nextInt();

System.out.println("Introduce la posición donde lo quieres insertar:");

do
{

posValidar = (pos >= 0 && pos <= numElem);

if(!posValidar)
{
System.out.println("Posición no valida");
}

}while(!posValidar);

/*
* Eliminaoms el elemento que esta en la posicon moviendo los elementos a la posicion anterior
*/
for(int i = pos; i < numElem ;i--)
{
Array[i] = Array[i+1];
}

// Array[pos] = elem;
//numElem++;
}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
* Busqueda secuencial busca un elemento devolviendo la posicion donde esta la primera ocurriecia.
* Si el elemento no esta devuelve un "-1".
*/

public int busquedaSecunecial(int buscar)
{
for(int i = 0; i < numElem; i++)
{
if(Array[i] == buscar)
{
return i;
}
}
return -1;
}

///////////////////////////////////////////////////////////

public int busquedaSecuencial2(int buscado) {
	
	boolean buscar1 =false;
	int i=0;
	while (i < numElem && !buscar1)
	{
		if (Array[i] == buscado)
		{
			buscar1 = true;
		}	
		else 
		{
			i++;
		}
	}
	if (buscar1)
		return i;
	return -1;
}

public int busquedaSecuencial3(int buscado) {
	
	//No hay bucle for, tampoco boolean
	
	int i=0;
	while (i < numElem && buscado != Array[i]) {
		i++;
	}
	if (i < numElem)
		return i;
	else {
		return -1;
	}
}

	/**
	 *  Algoritmo de ordenación de la burbuja:
	 * Recorremos el array comparando elementos
	 * adyacentes. Si no estan bien ordenados,
	 * los intercambiamos. 
	 * El proceso anterior se repite siempre y cuando
	 * haya habido algun intercambio
	 */
	
	public void ordenacionBurbuja() {
		boolean hayIntercambio;
		do {
			hayIntercambio = false;
			for (int i = 0; i < numElem -1; i++)
			{	
				if (Array[i] > Array[i+1]) 
				{				
					//Intercambiamos los elementos
					int aux = Array[i+1];
					Array[i+1] = Array[i];
					Array[i] = aux;
					hayIntercambio = true;
				}	
			}
		} while(hayIntercambio);
	}
	
	//Algoritmo de busqueda binaria o dicoatomica
	//Partimos de que el array estar ordenado
	//Si no esto fallaria
	//Elegimos un elemento central y comparamos el elemento buscado 
	//con el elemento en la posicion central.
	//Esto se repite si primero es menor o igual al ultimo y además el elemento buscado sea 
	//distinto del de la posición central. Devuelve -1 si no encuentra y central si lo encuentra
	
	/*public int busquedaBinaria(int buscado) {
		int primero = 0;
		int ultimo = numElem -1;
		int central;	
		do {
			central = ( primero + ultimo)/2;
			if ( buscado > Array[central]) {
				primero = central + 1;
			} else if (buscado < Array[central])
				ultimo = central -1;
		} while (primero <= ultimo && buscado != Array[central]);
	} */
	
	/**
	 * Algoritmo de mezcla o fusión de 2 arrays.
	 * Los arrays tienen que estar ordenados 
	 * y el array resultante tiene que quedar ordenado
	 */

	///////////////////////////////////////////////////
	
	public arraenteros fusion ( arraenteros array2)
	{
		//Creamos espacio para array3 
		arraenteros array3 = new arraenteros(numElem + array2.numElem);
		
		//Nos situamos en la primera posicion de los 3 arrays
		
		//Array1 
		int i = 0;
		
		//Array2
		int j = 0;
		
		//Array3
		int k = 0;
		
		/*Recorremos ambos arrays mientras engan elementoes,
		*comparamos los elementos y el mas pequeño se almacena en el 3º array
		*/
		
		while (i < numElem && j < array2.numElem) 
		{
			if (Array[i] < array2.Array[j] )
			{
				//Almacenamos en array3 el elemento de array1
				array3.Array[k] = Array[i];
				i++;
				k++;
			} else 
			{
				//Almacenamos en array3 el elemento de array2
				array3.Array[k] = array2.Array[j];
				j++;
				k++;
			}
		}
		
		//Almacenamos en array3 los elementos que no se han guardado
		while (i < numElem)
		{
			array3.Array[k] = Array[i];
			i++;
			k++;
		}
		
		while (j < numElem)
		{
			array3.Array[k] = array2.Array[j];
			j++;
			k++;
		}
		array3.numElem = k;
		return array3;
	}
	
	//Envia la summa de los elementos pares e impares que tiene el array 
	
	public void sumaParImpares()
	{
		//Ponemos dos contadores uno para pares y otro para impares
		int sumaImpares = 0;
		int sumaPares = 0;
		
		//Recorremos el array viendo si un numero es par o impar
		for (int i = 0; i < numElem; i++) {
			if (Array[i] % 2 == 0) {
				sumaPares += Array[i];
			} else {
				sumaImpares += Array[i];
			}
		}

		System.out.println("\n \nLa suma de los pares es " + sumaPares);
		System.out.println("La suma de los impares es " + sumaImpares);
	}

	//Visualizar por panalla el producto de todos los numeros primos que hay en el array
	
	public void productoPrimo() {
		
		int producto = 1;
		
		for (int i = 0 ; i < numElem; i++) {
			if (esPrimo(Array[i])) {
				producto *= Array[i];
			}
		}
		System.out.println("El producto de los numeros primos es: " + producto);
	}

	private boolean esPrimo(int i) {
		for (int div = 2; div <= i/2; div++) {
			//Comprobamos si al dividir da 0
			if (i % div == 0 ) {
				return false;
			}
		}
		return true;
	}
























}
