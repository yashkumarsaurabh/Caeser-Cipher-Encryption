import java.io.*;
public class BreakCipher {
	public int[] countLetters(String encrypted){
		int[] a = new int[26];
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			char newChar = Character.toUpperCase(currChar);
			int index = alphabet.indexOf(newChar);
			if(index!=-1){
				a[index]++;
			}
		}
		return a;
	}
	public int maxIndex(int[] a){
		int maxI=0;
		for(int i=0; i<a.length;i++){
			if(a[maxI]<=a[i]){
			maxI=i;
			}
		}
		return maxI;
		
	}
	public String decrypt(String encrypted){
		CaesarCipher cc = new CaesarCipher();
		int[] freq = countLetters(encrypted); 
		int maxDex = maxIndex(freq);
		int dkey = maxDex-4;
		if(maxDex<4){
			dkey=26-(4-maxDex);
		}
		return cc.encrypt(encrypted,26-dkey);
	}
	public static void main(String[] args)throws IOException{
		FileReader reader=new FileReader("F:\\file.txt");
		BufferedReader br1=new BufferedReader(reader);
		StringBuilder message = new StringBuilder();
		String line;
        while ((line = br1.readLine()) != null) {
            message.append(line).append("\n");
        }
        BreakCipher b=new BreakCipher();
        String dcrypted  = b.decrypt(message.toString());
        System.out.println(dcrypted);
        br1.close();
	}
}
