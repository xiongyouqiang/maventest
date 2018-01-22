package com.xyq.maventest.visualvm;

public class JavaHeapTest {
public final static double OUTOFMEMORY = 200000000000d;
    
    private String oom;

    private double length;
    
    StringBuffer tempOOM = new StringBuffer();

    public JavaHeapTest(double leng) {
        this.length = leng;
       
        int i = 0;
        while (i < leng) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
               e.printStackTrace();
               break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public double getLength() {
        return length;
    }

    public static void main(String[] args) {
        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }

}
