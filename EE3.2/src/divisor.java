
public class divisor {

	public static void main(String[] args) {
		int integer_result = 0;
		int temp = 0;
		int nbDivisors = 0;
		int i = 1;
		int j = 1;
		
		for(i = 1; i<=10000; i++){
			temp = 0;
			for(j = 1; j <= i; j++ ){
				if((i % j) == 0){
					temp ++;
				}
			}
			if(temp >= nbDivisors){
				nbDivisors = temp;
				integer_result = i;
			}
		}
		System.out.println("Entier avec les plus grand nombre de diviseurs : " + integer_result + " Nombre de diviseurs : " + nbDivisors);

	}

}
