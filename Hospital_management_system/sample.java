package Hospital_management_system;

public class sample {
    public static void Printnumb(int n){
        System.out.println("Dadaso ");
        if(n >= 0){
        Printnumb(n-1);
        }

    }
    public static void main(String []args){
        int n = 100;
        Printnumb(n);
    }
}
