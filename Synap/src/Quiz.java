import java.util.Scanner;
import java.util.Stack;

class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		String word[] = input.split("");
		
		String operator = null;
		
//		I,V,X
		for(int i = 0 ; i < input.length();i++) {
			
			if(word[i].equals("+") || word[i].equals("-")|| word[i].equals("*")|| word[i].equals("/")) {
				
				operator = word[i];
				
			}
			
			
		}// for end
		
	
		int result = 0;
		String a[] = input.split("\\"+operator);
	
		
		if(operator.equals("+")) {
			result = numbering(a[0]) + numbering(a[1]);
			if(result > 39) {
				System.out.println("범위를 벗어났습니다.");	
			}else {
				System.out.println(roma(result));
			}
			
		}else if(operator.equals("-")) {
			result = numbering(a[0]) - numbering(a[1]);
			if(result <1) {
				System.out.println("작은 수에서 큰 수를 뺄 수 없습니다.");
			}else {
				System.out.println(roma(result));
			}
		}else if (operator.equals("*")) {
			result = numbering(a[0]) * numbering(a[1]);
			if(result > 39) {
				System.out.println("범위를 벗어났습니다.");	
			}else {
				System.out.println(roma(result));
			}
		}else {
			result = numbering(a[0]) / numbering(a[1]);
			int remainder = numbering(a[0]) % numbering(a[1]);
			
			if(result <= 0) {
				System.out.println("작은 수를 큰 수로 나눌 수 없습니다");	
			}else {
				System.out.println("몫 "+roma(result));
				System.out.println("나머지 "+roma(remainder));
			}
		}
		
		
		


		
		
		
		
	}
	
	public static int numbering(String a) {
		String num[] = a.split("");
		Stack<String> st = new Stack<String>();
		
		int tmp = 0;
		
		for(int i = 0 ; i < num.length;i++) {
			st.push(num[i]);
		}
		
		while(!st.isEmpty()) {
			if(st.peek().equals("I")) {
				if(tmp == 5 || tmp == 10) {
					st.pop();
					tmp -= 1;
				}else {
					st.pop();
					tmp +=1;
				}
				
			}else if (st.peek().equals("V")) {
				st.pop();
				tmp +=5;
				
			}else if (st.peek().equals("X")) {
				st.pop();
				tmp +=10;
			}
			
			
		}
		return tmp;

		
	}//numbering end
	
	
	public static String roma(int result) {
		String roma = "";
		if(result >= 10) {
			int mok = result / 10;
			result = result%10;
			for(int i = 0 ; i < mok;i++) {
				roma = roma+"X";				
			}
			
		} 
			
		if(result >= 5){
			if(result == 9) {
				roma = roma +"IX";
				result -=4;
			}else {
				roma = roma+"V";
			}
			result -= 5;
		}
		
		
		if(result == 4) {
			roma = roma +"IV";
		}else {
			for(int i = 0 ; i < result;i++) {
				roma = roma +"I";
			}
		}
		
		
		
		
		
		return roma;
		
		
	}//roma end
	
	
	
	

}