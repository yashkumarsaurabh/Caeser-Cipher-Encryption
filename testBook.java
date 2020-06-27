import java.util.*;

public class testBook{
	public static void main(String arg[]){
		Scanner s=new Scanner(System.in);
		Book obj = new Book();
		System.out.println("Enter the book name: ");
		obj.setBookName(s.nextLine());
		System.out.println("Enter the price: ");
		obj.setBookPrice(s.nextInt());
		System.out.println("Enter the author Name: ");
		obj.setAuthorName(s.nextLine());
		s.close();
	}
}
