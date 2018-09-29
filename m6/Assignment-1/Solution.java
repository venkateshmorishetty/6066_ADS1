import java.util.*;
class LinkedList {
	int digit;
	LinkedList next;
	public LinkedList(int d) {
	digit = d;
	}
}
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
    	LinkedList head;
		LinkedList tail;
		String[] digits = number.split("",number.length());
		LinkedList newnode = new LinkedList(Integer.parseInt(digits[0]));
		head = newnode;
		tail = newnode;
		for (int i = 1; i < number.length(); i++) {
			LinkedList temp = new LinkedList(Integer.parseInt(digits[i]));
			tail.next = temp;
			tail = temp;
		}
		return head;
    }

    public static String digitsToNumber(LinkedList list) {
    	String result = "";
    	LinkedList temp = list;
    	while(temp.next != null) {
    		result += temp.digit;
    		temp = temp.next;
    	}
    	result += temp.digit;
    	return result;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	LinkedList head = null,tail = null;
    	int[] stack1 = new int[100];
    	int[] stack2 = new int[100];
        int top1 = 0,top2 = 0,value,rem = 0,carry = 0;
        LinkedList temp = list1;

        while(temp.next!=null) {
            stack1[top1++] = temp.digit;
            temp = temp.next;
        }stack1[top1++] = temp.digit;

        LinkedList temp1 = list2;
        while(temp1.next!=null) {
            stack2[top2++] = temp1.digit;
            temp1 = temp1.next;
        }stack2[top2++] = temp1.digit;

        for(int i = top1-1; i >= 0; i--) {
            value = stack1[i]+stack2[i];
            if(value>=10) {
                LinkedList node = new LinkedList(value%10 + carry);
                carry = value / 10;
                if(head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
            else {
                LinkedList node = new LinkedList(value+carry);
                if(head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
        }
        LinkedList prev = null,next = null;
        LinkedList t1 = head;
        while(t1!=null) {
            next = t1.next;
            t1.next = prev;
            prev = t1;
            t1 = next;
        }
        t1 = prev;

    return t1;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
