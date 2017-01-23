import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		System.out.print("Input a phrase: ");
		String input = stdin.nextLine();
		
		char ch;
		String aux = "";

		for (int i = 0; i < input.length() ; i++) {
			ch = input.charAt(i);

			if (Character.isLetter(ch)) {
				aux = aux.concat(Character.toString(ch));				
			}
			else {
				System.out.println(aux);
				aux = "";
			}
		}
		
		System.out.println(aux);

	stdin.close();
}

}
