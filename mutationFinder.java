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
					else{
						countOriginal++;
						countNew++;
					}
				}
				catch(Exception e){
				
					flag = false;
					if(newString.length() <= countNew + 1)
						numMutations += Math.abs(originalString.length() - countOriginal);
					else if(originalString.length() <= countOriginal + 1)
						numMutations += Math.abs(newString.length() - countNew);
				}
				
			}
		}	
		return numMutations;
	}

	public static void main(String[] args){
		String originalString = "agcaaaagca ggggaaaata aaaacaacca aaatgaaagc aaaactacta gttctgttgt"+
       " gtgcatttac agctacatat gcagacacaa tatgtatagg ctaccatgcg aacaactcaa"+
      " ctgacactgt tgacacagta cttgagaaga acgtgacagt gacacactct gtcaacctac"+
      " ttgaggacag tcacaacgga aaactatgcc gactaaaagg aacagcccca ctacaattgg"+
      " gtaattgcag cattgccgga tggatcttag gaaatccaga atgcgaatca ctgttttcta"+
      " aggaatcatg gtcttacatt gcagaaacac caaaccctaa aaatggaaca tgttacccag"+
      " ggtatttcgc cgactatgag gaactgaggg agcaattgag ctcagtatca tcattcgaga"+
      " gatttgaaat attccccaag gatagctcat ggcccaacca cactgtaacc aaaggagtga"+
      " cggcatcatg ctcccataat gggaaaagca gcttttacaa aaatttgcta tggctgacgg"+
      " agaagaatgg cttgtaccca aatctgagca agtcctatgt aaacaaaaag ggaaaagaag"+
      " tccttgtgct atggggtgtt catcacccgt ctaacatggg ggaccaacgg gccatctatc"+
      " ataaagaaaa tgcttatgtt tctgtgttgt cttcacatta tagcagaaga ttcaccccag"+
      " aaatagcaaa aagaccaaaa gtaagagatc aagaagggag aattaactac tactggactc"+
      " tgctggaacc cggggacaca ataatatttg aggcaaatgg aaatctaata gcgccgtggt"+
      " acgctttcgc actgagtaga ggctttgggt caggaatcat catctcaaac gcatcaatgg"+
      " gtgaatgtga cgctaagtgt caaacacccc aaggagctat aaacagtagt ctccccttcc"+
      " agaatgtaca cccagtcaca ataggagagt gtccaaagta tgtcaggagt acaaaattaa"+
     " ggatggttac aggactaagg aacgtcccat ccattcaatc cagaggtttg tttggagcca"+
     " ttgccggttt cattgaagga gggtggactg gaatgataga tggatggtat ggttatcatc"+
     " atcaaaatga acaaggatct ggctatgctg cggaccaaaa aagcacacaa aatgccatta"+
     " atgggattac aaacaaggtg aattctataa tcgagaaaat gaacactcaa ttcacagctg"+
     " taggcaaaga attcaacaaa ttagaaaaaa ggatggaaaa cttaaataag aaagttgatg"+
     " atggatttct ggacatttgg acatataatg cagaattgtt agttctcctg gaaaatgaaa"+
     " ggactttgga ttttcatgac ttaaatgtga agaacctgta tgagaaagtg aaaaaccaat"+
     " tgaagaataa tgccaaagaa atagggaacg ggtgttttga attctatcac aagtgtaaca"+
     " atgaatgcat ggaaagtgtg aaaaatggaa cttatgacta tccaaaatat tccaaagaat"+
     " caaagttaaa cagggaaaaa attgatggag tgaaattgga atcaatggga gtctatcaga"+
     " ttctggcgat ctactcaact gtcgccagtt cgctggtgct tttggtctcc ctgggggcaa"+
     " tcagcttctg gatgtgttct aatgggtctt tgcagtgtag aatatgcatc tgagaccaga"+
     " atttcagaaa tataagaaaa aacacccttg tttctact";
		String newString = "gggaaaataa aaacaaccaa aatgaaagca aaactactgg tcctgttatg tacatttaca"+
       " gctacatacg cagacacaat atgtataggc taccatgcca acaactcaac cgacactgtt"+
      " gacacagtac ttgagaagaa tgtgacagtg acacactctg tcaacctact tgaggacagt"+
      " cacaatggaa aactatgtct actaaaagga atagccccac tacaattggg taattgcagc"+
      " gttgccggat ggatcttagg aaacccagaa tgcgaattac tgatttccaa ggaatcatgg"+
      " tcctacattg tagaaacacc aaatcccgag aatggaacat gttacccagg gtatttcgcc"+
      " gattatgagg aactgaggga gcaattgagt tcagtatctt catttgagag attcgaaata"+
      " ttccccaaag gaagctcatg gcccaaccac accgtaaccg gagtatcagc atcatgctcc"+
      " cataatggga aaagcagttt ttacagaaat ttgctatggc tgacggggaa gaatggtttg"+
      " tacccaaacc tgagcatgtc ctatgtaaac aacaaagaga aagaagtcct tgtgctatgg"+
      " ggtgttcacc acccacctaa cataggggac caaagggccc tctaccatac agaaaatgct"+
      " tatgtctctg tagtgtcttc acattatagt agaagattca ccccagaaat agccaaaaga"+
      " cccaaagtaa gagatcagga aggaagaatc aactactact ggactctgct ggaacccggg"+
      " gacacaataa tatttgaggc aaatggaaat ctaatagcgc catggtatgc tttcgcactg"+
      " agtagaggct ttggatcagg aatcatcacc tcaaatgcac caatggatga atgtgatgcg"+
      " aagtgtcaaa cacctcaggg agctataaac agtagtcttc ctttccagaa tgtacaccca"+
      " gttacaatag gagagtgtcc aaagtatgtc aggagtgcaa aattaaggat ggttacagga"+
     " ctaaggaaca tcccatccat tcaatccaga ggtttgtttg gagccattgc cggtttcatt"+
     " gaaggggggt ggactggaat ggtagatggg tggtatggtt atcatcatca gaatgagcaa"+
     " ggatctggtt atgctgcaga tcaaaaaagc acacaaaatg ccattaacgg gattacaaac"+
     " aaggtgaatt ctgtaattga gaaaatgaac actcaattca cagctgtggg caaagaattc"+
     " aacaaattag aaagaaggat ggaaaactta aataaaaaag ttgatgatgg gtttctagac"+
     " atttggacat ataatgcaga attgttggtt ctactggaaa atgaaaggac tttggatttc"+
     " catgactcca atgtgaagaa tctgtatgag aaagtaaaaa gccaattaaa gaataatgcc"+
     " aaagaaatag gaaacgggtg ttttgaattc tatcacaagt gtaacaatga atgcatggaa"+
     " agtgtgaaaa atggaactta tgactatcca aaatattccg aagaatcaaa gttaaacagg"+
     " gagaaaattg atggagtaaa attggaatca atgggagtct atcagattct ggcgatctac"+
     " tcaactgtcg ccagttccct ggttcttttg gtctccctgg gggcaatcag cttctggatg"+
     " tgttccaatg ggtctttgca gtgtagaata tgcatctgag accagaattt cagaaatata"+
     " agaaaaaa";
		
		System.out.println(findMutations(originalString, newString));
	}
	
}

