
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		
	}
	
	public static long doFactorial(int input){
		long result=1;
		
		if(input==0){
			return result;
		}
		else{
		for(int i=1;i<=input;i++){
			result*=i;
			}
		}
		return result;
	}

}
