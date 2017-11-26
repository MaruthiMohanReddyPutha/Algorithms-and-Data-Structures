package Algorithms;

public class CollatzConjecture {
	public int numSteps;
	
	public CollatzConjecture() {
		this.numSteps = 0;
	}
	
	public static void main(String[] args) {
		CollatzConjecture collatz = new CollatzConjecture();
		int n = 50;
		System.out.println("The number entered is : "+n);
		System.out.println("No of steps taken to reach 1 : "+collatz.collatz(n));
	}
	
	public int collatz(int n) {
		return collatzRecursive(n, 0);
	}
	
	public int collatzRecursive(int step, int count) {
		if(step == 1) {
			return count;
		}else {
			if(step%2 == 0) {	//n is Even Number
				return collatzRecursive(step/2, count+1);
			}else {	//n is Odd Number
				return collatzRecursive(3*step+1, count+1);
			}
		}
	}
}
