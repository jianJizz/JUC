package com.usc.jvm.chapter02;

/**
 * @author jianjianDuan
 * @date 2021/11/30 2:19 PM
 *
 *  结论:
 *  1. 我们尝试获取引导类加载器，获取到的值为 null ，这并不代表引导类加载器不存在，因为引导类加载器右 C/C++ 语言，我们获取不到
 *  2. 两次获取系统类加载器的值都相同：sun.misc.Launcher$AppClassLoader@18b4aac2 ，这说明系统类加载器是全局唯一的
 */
public class ClassInitTest5 {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); // sun.misc.Launcher$AppClassLoader@7f31245a
        System.out.println(systemClassLoader);

        // 获取其上层：系统类加载器
        ClassLoader ExtClassLoader = systemClassLoader.getParent(); // sun.misc.Launcher$ExtClassLoader@45ee12a7
        System.out.println(ExtClassLoader);

        // 获取其上层：bootstrap类加载器获取不到
        ClassLoader bootstrapClassLoader = ExtClassLoader.getParent();
        System.out.println(bootstrapClassLoader); // null

        //对于用户自定义类来说：默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassInitTest5.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@7f31245a

        //String类使用引导类加载器进行加载的。---> Java的核心类库都是使用引导类加载器进行加载的。
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1); // null
    }
}
