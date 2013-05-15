
package wide.test;

public class BidirectionalAssociation {
    public static void main(String[] args) {
        
        A a = new A(1);
        B b = new B(a.getId());
        a.setB(b);
        
        System.out.println(a);
    }
}

class A {
    
    private int id;
    private B b;

    public A(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" + "id=" + id + ", b=" + b + '}';
    }
}

class B {
    
    private int idA;

    public B(int idA) {
        this.idA = idA;
    }

    @Override
    public String toString() {
        return "B{" + "idA=" + idA + '}';
    }
}