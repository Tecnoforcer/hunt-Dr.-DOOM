import java.util.Scanner;

public class Dr_DOOM {
	
	public static int escojeArma(String vArmas[], int vida, String orden[]) {//sin terminar
		int dmgI = 0;//inocentes  Comparar
		int dmgV = 0;//villanos  Comparar
		int pos=0;
		int da�oArmaI=0;
		int da�oArmaV=0;
		
		String parte="";
		
		String partes[]=vArmas[0].split(" ");
		dmgI= Integer.parseInt(partes[0]);
		dmgV= Integer.parseInt(partes[1]);
		
		for (int i = 0; i < vArmas.length; i++) {
			String dmgArma[]=vArmas[i].split(" ");
			da�oArmaI= Integer.parseInt(dmgArma[0]);
			da�oArmaV= Integer.parseInt(dmgArma[1]);
			
			if ((da�oArmaI<dmgI)&&(da�oArmaI!=0)) {
				dmgI=da�oArmaI;
				dmgV=da�oArmaV;
				pos=i;
			}else if ((dmgI==da�oArmaI)&&(da�oArmaI!=0)) {
				if (dmgV<da�oArmaV) {
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
