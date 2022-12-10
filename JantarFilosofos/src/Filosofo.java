
public class Filosofo implements Runnable {
	
	//Garfos a disposicao do filosofo
	private final Object garfoEsquerdo;
	private final Object garfoDireito;
	
	//Constructor
	public Filosofo(Object garfoEsquerdo, Object garfoDireito) {
		this.garfoEsquerdo = garfoEsquerdo;
		this.garfoDireito = garfoDireito;
	}
	
	//Executa a acao do filosofo
	private void executarAcao(String acao) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " " + acao);
		Thread.sleep(1000);//Intervalo
	}
	
	@Override
	public void run() { 
		// TODO Auto-generated method stub
		try {
			while(true) {
				//O Filosofo esta pensando
				executarAcao(": Pensando");
				synchronized (garfoEsquerdo) {
					executarAcao(": Pegando garfo � esquerda");
					synchronized (garfoDireito) {
						//Pega garfo a direita e come�a a comer
						executarAcao(": Pegando garfo � direita e comendo");
						executarAcao( ": Devolvendo garfo � direita");
					}
					
					//Voltando a pensar
					executarAcao(": Devolvendo garfo � esquerda e voltando a pensar");
				}
			}
		}
		catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
		
	}

}
