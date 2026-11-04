import java.util.Random;
public class RandomExample{
	public static void main(String[] args){
		double [] x= new double [5];
		Random r= new Random();
		for(int i=0; i<=5; i++){
			x[i]= r.nextInt(100);
		}
	}
}