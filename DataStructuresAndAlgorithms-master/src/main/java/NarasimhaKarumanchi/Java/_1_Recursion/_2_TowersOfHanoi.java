/**
 * 
 */
package NarasimhaKarumanchi.Java._1_Recursion;

/**
 * @author Tousif
 *
 * @ALGORITHM
 * • Move the top n–1 disks from Source to Auxiliary tower.
 * • Move the nth disk from Source to Destination tower.
 * • Move the n–1 disks	from Auxiliary tower to	Destination	tower
 * • Transferring the top n–1 disks	from Source to Auxiliary tower can again
 *   be	thought of as a	fresh problem and can be solved	in the same	manner. 
 *   
 *   Once we solve Towers of Hanoi with three disks, we can solve it	with any
 *   number	of disks with the above algorithm.
 *
 */
public class _2_TowersOfHanoi {
	
	// Java recursive function to solve tower of hanoi puzzle 
	static void towerOfHanoi(int n, String from_rod, String to_rod, String aux_rod) 
	{ 
		if (n == 1) 
		{ 
			System.out.println("Move Disk 1 from " +  from_rod + " to " + to_rod); 
			return; 
		} 
		towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
		
		System.out.println("Move disk " + n + " from " +  from_rod + " to " + to_rod); 
		
		towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
	} 

	//  Driver method 
	public static void main(String args[]) 
	{ 
		int n = 4; // Number of disks 
		towerOfHanoi(n, "A(From)", "C(To)", "B(Aux)");  // A, B and C are names of rods 
	} 
}
