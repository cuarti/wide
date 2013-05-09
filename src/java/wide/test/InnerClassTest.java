
package wide.test;

import com.google.gson.Gson;

public class InnerClassTest {
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        
        System.out.println("InnerClass: " + gson.toJson(new InnerClass()));
        
        class LocalInnerClass {
            private String message = "I'm a LocalInnerClass";
            public LocalInnerClass() {}
        }
        
        System.out.println("LocalInnerClass: " + gson.toJson(new LocalInnerClass()));
        
        System.out.println("AnonymousInnerClass: " + gson.toJson(new Object() {
            private String message = "I'm a AnonymousInnerClass";
            {}
        }));
    }
    
    public static class InnerClass {
        private String message = "I'm a InnerClass";
        public InnerClass() {}
    }
}
