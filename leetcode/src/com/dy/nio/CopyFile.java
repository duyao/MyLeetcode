package com.dy.nio;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile
{
  static public void main( String args[] ) throws Exception {
   /* if (args.length<2) {
      System.err.println( "Usage: java CopyFile infile outfile" );
      System.exit( 1 );
    }*/

    String infile = "d:/1.txt";
    String outfile = "d:/pi.txt";

    FileInputStream fin = new FileInputStream( infile );
    FileOutputStream fout = new FileOutputStream( outfile );

    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate( 1024 );

    while (true) {
      buffer.clear();

      int r = fcin.read( buffer );

      if (r==-1) {
        break;
      }

      buffer.flip();

      fcout.write( buffer );
    }
  }
}
