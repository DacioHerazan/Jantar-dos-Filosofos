
public class JantarFilosofos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filosofo[] filosofos = new Filosofo[5];
		Object[] garfos = new Object[filosofos.length];
 
		for (int i = 0; i < garfos.length; i++) {
			garfos[i] = new Object();
		}
		
		for (int i = 0; i < filosofos.length; i++) {
			Object garfoEsquerdo = garfos[i];
			Object garfoDireito = garfos[(i + 1) % garfos.length];
		
			if(i == filosofos.length - 1) {
				//O ultimo filosofo pega primeiro o garfo a direita
				filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo);	
			} else {
				//Os filosofos pegam primeiro o garfo a esquerda
				filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito);
			}
			
			Thread t = new Thread(filosofos[i], "Filosofo " + (i + 1));
			t.start();
		}
	}

}
