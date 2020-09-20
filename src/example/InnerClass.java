package example;


public class InnerClass {
	
	private int data;
	private InnerClass subclass; 

	public InnerClass() {
		this(0, null);
	}
    public InnerClass(int data) {
        this(data, null);
    }

    public InnerClass(int data, InnerClass subclass) {
        this.data = data;
        this.subclass = subclass;
    }
}
