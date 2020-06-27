import java.io.*;
public class Decipher {
	static String encrypt(String input, int key){
		//Make a stringBuilder with message 
		StringBuilder encrypted = new StringBuilder(input);
		//write down alphabet
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//compute shifted alphabet string
		String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
		//count from 0 to <length of message
		for(int i=0; i<encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			if(Character.isUpperCase(currChar)){
			int index  = alphabet.indexOf(currChar);
				if(index!=-1){
					char newChar = shiftedAlphabet.charAt(index);
					encrypted.setCharAt(i,newChar);
				}
			}
			else{
					char p = Character.toUpperCase(currChar);
					int index  = alphabet.indexOf(p);
					if(index!=-1){
					char newChar = shiftedAlphabet.charAt(index);
					char a = Character.toLowerCase(newChar);
					encrypted.setCharAt(i, a);
				    }
			}
		}
		return encrypted.toString();
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int key=Integer.parseInt(br.readLine());
		FileReader reader=new FileReader("F:\\file.txt");
		BufferedReader br1=new BufferedReader(reader);
		StringBuilder message = new StringBuilder();
		String line;
        while ((line = br1.readLine()) != null) {
            message.append(line).append("\n");
        }
        String encrypted  = encrypt(message.toString(),key);
        System.out.println(encrypted);
        br1.close();
	}
}
