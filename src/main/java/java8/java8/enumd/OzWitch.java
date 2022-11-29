package java8.java8.enumd;
//一般来说，我们希望每个枚举实例能够返回对自身的描述，而不仅仅只是默认的 toString() 实现，这只能返回枚举实例的名字。为此，
// 你可以提供一个构造器，专门负责处理这个额外的信息，然后添加一个方法，返回这个描述信息。看一看下面的示例：
public enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");
    private String description;
    // Constructor must be package or private access:
    private OzWitch(String description) {
        this.description = description;
    }
    public String getDescription() { return description; }
    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values())
            System.out.println(
                    witch + ": " + witch.getDescription());
    }
}
