package com.jd.io;

import com.sinoufc.savingsbonds.util.SystemUtil;

import java.io.File;
import java.io.FileOutputStream;

public class OutPutStream {
    public static void main(String[] args) throws Exception{
        Student student =new Student(1000,25,"张三");
        StringBuffer buffer =new StringBuffer();
        buffer.append(student.getId()).append(student.getAge()).append(student.getUsername());
        String localDir="${RealtimeMessage.root}/files";
        String batchsendPathBJ="baojia/respon";
        String path=localDir + SystemUtil.getFileSeparator() + batchsendPathBJ;
        String fileName="";//就是文件名
         File file = new File(path+SystemUtil.getFileSeparator()+fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        String string = buffer.toString();
        outputStream.write(string.getBytes());
        outputStream.close();

    }
}
