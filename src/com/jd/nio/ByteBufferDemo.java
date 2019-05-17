package com.jd.nio;
import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer  buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//1024
        System.out.println(buffer.capacity());//1024
        //put()方法
        String str="asdf";
        buffer.put(str.getBytes());
        System.out.println(buffer.position());//4
        System.out.println(buffer.limit());//1024
        System.out.println(buffer.capacity());//1024
        //flip()方法 ,由写进入读的模式
        buffer.flip();
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//4
        System.out.println(buffer.capacity());//1024
        //get()
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(buffer.position());//4
        System.out.println(buffer.limit());//4
        System.out.println(buffer.capacity());//1024
        //rewind(),重新进入读的模式
        buffer.rewind();
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//4
        System.out.println(buffer.capacity());//1024
        //clear() 又回到allocat()状态,清空缓冲区,又回到allocate()
        // 但是缓冲区中的数据依然存在,只不过是处于"被遗忘的状态"
        buffer.clear();
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//1024
        System.out.println(buffer.capacity());//1024

    }
     @Test
     public void test2(){
       ByteBuffer buffer = ByteBuffer.allocate(1024);
       String str="asdfg";
       buffer.put(str.getBytes());
       byte[] bytes = new byte[buffer.limit()];
       buffer.flip();
       buffer.get(bytes,0,2);
       System.out.println(new String(bytes,0,2));
       System.out.println(buffer.position());
       buffer.mark();
         buffer.get(bytes,2,2);
         System.out.println(new String(bytes,2,2));
         System.out.println(buffer.position());
       buffer.reset();
         System.out.println(buffer.position());

     }
}
