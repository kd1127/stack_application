package statck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * スタック アレンジver
 */
public class Stack {
	static int stack_count = 0;
	static int[] stack = new int[10];
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		System.setProperty("file encoding", "UTF-8");
		try {
			while(true) {
				System.out.println("★Stack Operation★");
				System.out.println("1:push");
				System.out.println("2:pop");
				System.out.println("3:operation end");
				System.out.println("please number input...");
				int choice = Integer.parseInt(br.readLine());
				
				if(choice == 1) {
					push(stack);
				}
				if(choice == 2){
					pop(stack);
				}
				if(choice == 3) {
					for(int num : stack) {
						System.out.println("データ: " + num);
					}
					break;
				}
			}
		} catch(NumberFormatException nfe) {
			String[] str = new String[10];
			main(str);
		}
	}
	public static void push(int[] stack) throws IOException, NumberFormatException{
		System.out.println("stack size: " + stack_count);
		if(stack_count >= 10) {
			System.out.println("これ以上入力できません。");
			return;
		}
		
		try {
			System.out.println("Please Input Number");
			int num = Integer.parseInt(br.readLine());
			
			if(stack_count != stack.length) {
				stack[stack_count++] = num;
			}
		} catch (NumberFormatException e) {
			push(stack);
		} catch (IOException e) {
			push(stack);
		}
	}
	
	public static  int pop(int[] stack) throws IOException, NumberFormatException, ArrayIndexOutOfBoundsException{
		try {
			System.out.println("Please Delete Number Input");
			int pop = Integer.parseInt(br.readLine());
			
			int i, j, tmp = 0;
			
			for(i=0; i<stack.length; i++) {
				if(pop == stack[i]) {
					stack[i] = 0;
					tmp = stack[i];
					break;
				}
			}
			for(j=i; j<stack.length-1; j++) {
				stack[j] = stack[j+1];
			}
			stack[j] = tmp;
			return pop;
		} catch (NumberFormatException e) {
			pop(stack);
		} catch (IOException e) {
			pop(stack);
		} catch(ArrayIndexOutOfBoundsException e) {
			pop(stack);
		}
		return 0;
	}
}
