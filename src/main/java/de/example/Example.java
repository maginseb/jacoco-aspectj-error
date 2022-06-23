package de.example;


public class Example {

    public String sayHello(String name) {
        CharArrayContainer charArray = new CharArrayContainer();
        charArray.setCharArray(name.toCharArray());
        return "Hello " + new String(charArray.getCharArray());
    }

}
