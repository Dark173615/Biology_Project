package genefinder;

public class mutationFinder {
	
	public static int findMutations(String originalString, String newString){
		int numMutations = 0;
		boolean flag = true;
		int countOriginal = 0, countNew = 0, count = 0;
		
		while(flag){
			count++;
			if(countOriginal == originalString.length()){
				flag = false;
				
				numMutations += Math.abs(newString.length() - countNew);
			}
			else if(countNew == newString.length()){
				flag = false;
				numMutations += Math.abs(originalString.length() - countOriginal);
			}

			else if(originalString.charAt(countOriginal) == newString.charAt(countNew)){
					countOriginal++;
					countNew++;
			}
			else{
				numMutations++;
				
				try{
					//deletion
					if(originalString.charAt(countOriginal + 1) == newString.charAt(countNew)){
						countOriginal++;
					}
					
					//insertion
					else if(originalString.charAt(countOriginal) == newString.charAt(countNew + 1)){
						countNew++;
					}
				}
				catch(Exception e){
					flag = false;
				}
				
			}
		}
		
		
		
		return numMutations;
	}

	public static void main(String[] args){
		String originalString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String newString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.println(findMutations(originalString, newString));
	}
	
}

