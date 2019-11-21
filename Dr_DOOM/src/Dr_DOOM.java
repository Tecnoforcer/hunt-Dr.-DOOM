import java.util.Scanner;

public class Dr_DOOM {
	
	public static int escojeArma(String vArmas[], int vida, String orden[]) {//sin terminar
		int dmgI = 0;//inocentes  Comparar
		int dmgV = 0;//villanos  Comparar
		int pos=0;
		int dañoArmaI=0;
		int dañoArmaV=0;
		
		String parte="";
		
		String partes[]=vArmas[0].split(" ");
		dmgI= Integer.parseInt(partes[0]);
		dmgV= Integer.parseInt(partes[1]);
		
		for (int i = 0; i < vArmas.length; i++) {
			String dmgArma[]=vArmas[i].split(" ");
			dañoArmaI= Integer.parseInt(dmgArma[0]);
			dañoArmaV= Integer.parseInt(dmgArma[1]);
			
			if ((dañoArmaI<dmgI)&&(dañoArmaI!=0)) {
				dmgI=dañoArmaI;
				dmgV=dañoArmaV;
				pos=i;
			}else if ((dmgI==dañoArmaI)&&(dañoArmaI!=0)) {
				if (dmgV<dañoArmaV) {
					pos=i;
				}
			}
		}
		
		String dmgArma[]=vArmas[pos].split(" ");
		vida -= Integer.parseInt(dmgArma[1]);
		vArmas[pos]="0 0";
		orden[0]+= ((pos+1) +" ");
		return vida;
	}
	
	public static void buscarArmas(String vArmas[]) {
		Scanner leer=new Scanner(System.in);
		for (int i = 0; i < vArmas.length; i++) {
			vArmas[i]=leer.nextLine();
		}
	}
	
	public static void main(String[] args) {
		int vida = 0;
		int numArmas = 0;
		int contador=0;
		boolean bandera=false;
		String orden[]= new String[1];
		orden[0]="";
		
		Scanner leer = new Scanner(System.in);
		vida=leer.nextInt();
		numArmas=leer.nextInt();
		String vArmas[] = new String[numArmas];
		
		buscarArmas(vArmas);
		
		do {
			
			
			if ((vida>0) && (contador!=numArmas)) {
				vida=escojeArma(vArmas, vida, orden);
				contador+=1;
			}else if (vida<=0) {
				bandera=true;
				System.out.println(orden[0]);
			}else {
				System.out.println("DOOM escapa");
				bandera=true;
			}
			
		} while (!bandera);

	}

}
