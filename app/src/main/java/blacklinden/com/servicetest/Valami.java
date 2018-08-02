package blacklinden.com.servicetest;



public class Valami extends TesztTárgy {
    public int a;
    public String név;
    public int sug;
    public Valami(String s){
        this.a=0;
        this.név=s;
        this.sug=10;
    }

    @Override
    public void doit() {
        a++;
        sug+=10;
    }
}
