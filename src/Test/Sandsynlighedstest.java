package Test;

public class Sandsynlighedstest {

	public static void main(String[] args) {

		int n;
		int DiceSafe1, DiceSafe2;
	
		
		int add2 = 0;
		int add3 = 0;
		int add4 = 0;
		int add5 = 0;
		int add6 = 0;
		int add7 = 0;
		int add8 = 0;
		int add9 = 0;
		int add10 = 0;
		int add11 = 0;
		int add12 = 0;
		
		int SumCheck;
		int Ens2 = 0;
	


		
		


		for(n = 0; n<10000; n++){
			
			DiceSafe1 = (int)(Math.random()*6)+1;
			DiceSafe2 = (int)(Math.random()*6)+1;
			SumCheck = DiceSafe1+DiceSafe2;
			
			if(SumCheck == 2){
				
			add2 += 1;
			}

			else if(SumCheck == 3){
				
				add3 += 1;
				}
			
			else if(SumCheck == 4){
				
				add4 += 1;
				}
			
			else if(SumCheck == 5){
				
				add5 += 1;
				}
			
			else if(SumCheck == 6){
				
				add6 += 1;
				}
			
			else if(SumCheck == 7){
				
				add7 += 1;
				}
			
			else if(SumCheck == 8){
				
				add8 += 1;
				}
			
			else if(SumCheck == 9){
				
				add9 += 1;
				}
			
			else if(SumCheck == 10){
				
				add10 += 1;
				}
			
			else if(SumCheck == 11){
				
				add11 += 1;
				}
			
			else if(SumCheck == 12){
				
				add12 += 1;
				}
			if (DiceSafe1 == DiceSafe2){
				
				Ens2+=1;
			}

			
		}
		
		System.out.println(" sum 2: "+add2+"\n sum 3: "+add3+"\n sum 4: "+add4+"\n sum 5: "+add5+"\n sum 6: "+add6+"\n sum 7: "+add7+"\n sum 8: "+add8+"\n sum 9: "+add9);
		System.out.println(" sum 10: "+add10+"\n sum 11: "+add11+"\n sum 12: "+add12);
		System.out.println("Antal slag med 2 ens: "+Ens2);
		
// Dette stemmer nogenlunde overens med den forventede sandsynlighed for de forskellige udfald.
		
//Outcome	Probability
//2	 1/36 = 2.78%
//3	 2/36 = 5.56%
//4	 3/36 = 8.33%
//5	 4/36 = 11.11%
//6	 5/36 = 13.89%
//7	 6/36 = 16.67%
//8	 5/36 = 13.89%
//9	 4/36 = 11.11%
//10 3/36 = 8.33%
//11 2/36 = 5.56%
//12 1/36 = 2.78%
		
//2 ens 6/36 = 16.67%

	}
}