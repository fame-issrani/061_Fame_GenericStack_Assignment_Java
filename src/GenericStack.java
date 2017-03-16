import java.lang.reflect.Array;

public class GenericStack<T> {

	private int size;
	private T[] stackArray;
	private int top;


	public GenericStack(int size) {
		this.size = size;
//		this.stackArray=(T[]) Array.newInstance(GenericStack<T> c,size);
		this.stackArray = (T[]) new Object[size];
		this.top = -1;
	}

	public void push(T entry){
		if(this.isStackFull()){
			System.out.println(("Stack is full."));

		}
		System.out.println("Adding: "+entry);
		this.stackArray[++top] = entry;
	}

	public T pop() throws Exception {
		if(this.isStackEmpty()){
			throw new Exception("Stack is empty. Can not remove element.");
		}
		T entry = this.stackArray[top--];
		System.out.println("Removed entry: "+entry);
		return entry;
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}


	public boolean isStackFull() {
		return (top == size - 1);
	}

	public static void main(String a[]) throws Exception {
		GenericStack<String> stringStack = new GenericStack<>(2);
		stringStack.push("java2novice");
		GenericStack<Integer> integerStack = new GenericStack<>(2);
		integerStack.push(23);
		integerStack.pop();
	}
}