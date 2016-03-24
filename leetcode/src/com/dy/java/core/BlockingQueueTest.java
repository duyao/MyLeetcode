package com.dy.java.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the file directory...");
		String directory = in.nextLine();
		System.out.println("Enter the keyword...");
		String keyword = in.nextLine();
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(10);
		FileEnumrationTask task = new FileEnumrationTask(queue, new File(directory));
		new Thread(task).start();
		for (int i = 0; i < 100; i++) {
			new Thread(new SearchTask(queue, keyword)).start();
			
		}
	}

}

class FileEnumrationTask implements Runnable{

	public static File DUMMY = new File("");
	private BlockingQueue<File> queue;
	private File startingDirectory;
	
	public FileEnumrationTask(BlockingQueue<File> queue, File startingDirectory) {
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}
	
	public void enumerate(File directory) throws InterruptedException{
		File[] files = directory.listFiles();
		for (File file : files) {
			if(file.isDirectory()){
				enumerate(file);
			}else{
				queue.put(file);
			}
			
		}
	}
	
	@Override
	public void run() {
		try {
			enumerate(startingDirectory);
			queue.put(DUMMY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

class SearchTask implements Runnable{
	private BlockingQueue<File> queue;
	private String keyword;

	public SearchTask(BlockingQueue<File> queue, String keyword) {
		this.queue = queue;
		this.keyword = keyword;
	}
	
	public void search(File file){
		try {
			Scanner in = new Scanner(file);
			int lineNum = 0;
			while(in.hasNextLine()){
				lineNum++;
				String line = in.nextLine();
				if(line.contains(keyword)){
//					System.out.println(file.getPath());
					System.out.printf("%s : %d : %s%n",file.getPath(), lineNum, line);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		boolean done = false;
		try {
			while(!done){
				File file = queue.take();
				if(file == FileEnumrationTask.DUMMY){
					queue.put(file);
					done = true;
				}else{
					search(file);
				}
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
