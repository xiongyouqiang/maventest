package com.xyq.maventest.visualvm;

/*****
 *模拟jvm虚拟机栈内存溢出
 * 无限循环递归调用call方法，导致虚拟机栈的长度, 报StackOverflowError
* @ClassName: StackErrorMock 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author youqiang.xiong
* @date 2018年2月28日 上午11:40:44 
*
 */
public class StackErrorMock {
    private static int index = 1;
 
    public void call(){
        index++;
        call();
    }
 
    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }
}