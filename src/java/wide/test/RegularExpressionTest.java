
package wide.test;

public class RegularExpressionTest {
    public static void main(String[] args) {
        
        String cadena = "0000";
        String RE = "^[a-zA-Z0-9]*";
        //Hay que acabar de afinar la RE
        String emailsRE = "^[_a-zA-Z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        
        System.out.println(cadena.matches(RE));
        
    }
}
