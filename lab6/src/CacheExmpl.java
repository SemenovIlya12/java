

public class CacheExmpl {

    @Cache
    private Object defaultEmpty;

    @Cache({"YO", "HEY", "HI"})
    private Object notDefaultNotEmpty;

    public void Test() {
        try {
            System.out.println("CacheExmpl class`s field 'defaultEmpty' have annotation"
                    + CacheExmpl.class.getDeclaredField("defaultEmpty").getAnnotation(Cache.class)
            );


            System.out.println("CacheExmpl class`s field 'notDefaultNotEmpty' have annotation"
                    + CacheExmpl.class.getDeclaredField("notDefaultNotEmpty").getAnnotation(Cache.class)
            );


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
