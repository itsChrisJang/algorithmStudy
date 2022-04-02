package self.presentation;

class Coffee{
    Coffee(){
        System.out.println("Coffee is created");
    }

    protected void finalize() {
        System.out.println("Coffee is destroyed");
    }
}

public class CoffeeDemo{
    public static void main(String[] args) {
        Coffee cf = new Coffee();
        cf = null;

        Coffee cf1 = new Coffee();
        Coffee cf2 = new Coffee();
        cf1 = cf2;

        new Coffee();


        System.gc();
    }
}