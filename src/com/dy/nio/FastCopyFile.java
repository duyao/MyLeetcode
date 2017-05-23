package com.dy.nio;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class FastCopyFile {
    static public void main(String args[]) throws Exception {
        String infile = "d:/1.txt";
        String outfile = "d:/pi.txt";

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);


        System.out.println(fin.getFD().toString());
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        int i = 0;
        while (true) {
            buffer.clear();

            int r = fcin.read(buffer);

            if (r == -1) {
                break;
            }

            buffer.flip();

            fcout.write(buffer);
            System.out.println("ing .."+i++);

        }
        System.out.println("jieshu");
    }
}
