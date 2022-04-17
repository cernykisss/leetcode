public class Singleton2 {
//懒汉式
    private static Singleton2 singleton2;
    private Singleton2() {}
    public Singleton2 getSingleton2() {
        return singleton2 == null? new Singleton2(): singleton2;
    }
}
