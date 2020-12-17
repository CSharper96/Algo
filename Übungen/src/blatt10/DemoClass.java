package blatt10;

import java.util.Iterator;

public class DemoClass {
    public static void main(String[] args) throws StackException {
        ExcB();
        ExcC();
    }
    private static void ExcB() throws StackException {

        System.out.println("\nIterate in the old fashioned way!");

        ArrayStack<String> stack = new ArrayStack<>(4);
        stack.push("Apfel");
        stack.push("Birne");
        stack.push("Clementine");
        stack.push("DATTEL");

        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());;
        }

        stack.pop();
        stack.push("Erdbeere");

        it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());;
        }
    }
    private static void ExcC() throws StackException {

        System.out.println("\nIterate with foreach!");

        ArrayStack<String> stack = new ArrayStack<>(4);
        stack.push("Apfel");
        stack.push("Birne");
        stack.push("Clementine");
        stack.push("DATTEL");

        for(String str : stack)
            System.out.println(str);

        stack.pop();
        stack.push("Erdbeere");

        for(String str : stack)
            System.out.println(str);
    }
}
/**
 * Iterator<Thingy> it = iterable.iterator();
 * while (it.hasNext()) {
 *     Thingy t = it.next();
 *     // Use `t`
 * }
 **/