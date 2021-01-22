package m01;

/**
 * 
 * @author kelsiegarcia
 *
 */
public class Midterm1 {

	public static void main(String[] args) {
		
		System.out.println("Array bars: ");

		Bar[] bars = new Bar[7];
		bars[0] = new Bar(8,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[0].display());
		bars[1] = new Bar(16,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[0].display());
		bars[2] = new Bar(5,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[2].display());
		bars[3] = new Bar(10,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[3].display());
		bars[4] = new Bar(13,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[4].display());
		bars[5] = new Bar(18,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[5].display());
		bars[6] = new Bar(4,'*');
		if(Bar.getLength() < 15)
		System.out.println(bars[6].display());
		
		System.out.println();
		
		System.out.println("Stack stack:");
		Stack<String> stack = new Stack<>();
		String temp = new Bar(8,'*').display();
		stack.push(temp);
		if(Bar.getLength() < 15)
		System.out.println(temp);
		String temp1 = new Bar(16,'*').display();
		stack.push(temp1);
		if(Bar.getLength() < 15)
		System.out.println(temp1);
		String temp2 = new Bar(5,'*').display();
		stack.push(temp2);
		if(Bar.getLength() < 15)
		System.out.println(temp2);
		String temp3 = new Bar(10,'*').display();
		stack.push(temp3);
		if(Bar.getLength() < 15)
		System.out.println(temp3);
		String temp4 = new Bar(13,'*').display();
		stack.push(temp4);
		if(Bar.getLength() < 15)
		System.out.println(temp4);
		String temp5 = new Bar(18,'*').display();
		stack.push(temp5);
		if(Bar.getLength() < 15)
		System.out.println(temp5);
		String temp6 = new Bar(4,'*').display();
		stack.push(temp6);
		if(Bar.getLength() < 15)
		System.out.println(temp6);
		
		
		System.out.println();
		System.out.println("Array Bars:");
		bars[0] = new Bar(8,'*');
		System.out.print(bars[0].toString() + " ");
		bars[1] = new Bar(16,'*');
		System.out.print(bars[0].toString() + " ");
		bars[2] = new Bar(5,'*');
		System.out.print(bars[2].toString() + " ");
		bars[3] = new Bar(10,'*');
		System.out.print(bars[3].toString() + " ");
		bars[4] = new Bar(13,'*');
		System.out.print(bars[4].toString() + " ");
		bars[5] = new Bar(18,'*');
		System.out.print(bars[5].toString() + " ");
		bars[6] = new Bar(4,'*');
		System.out.print(bars[6].toString() + " ");
		
		System.out.println();
		System.out.println();
		System.out.println("Duplicates: ");
		stack.duplicate().toString();
		
		
		
		System.out.println();
		System.out.println("EveryOther:");
		stack.everyOther().toString();
		
		
		
		
		


	}

}
