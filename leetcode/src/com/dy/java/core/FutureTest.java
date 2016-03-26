package com.dy.java.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the directory...");
		String directory = in.nextLine();
		System.out.println("Enter the keyword...");
		String keyword = in.nextLine();
		
		MatchCounter counter = new MatchCounter(new File(directory), keyword);
		//可以存放多个Callable
		FutureTask<Integer> task = new FutureTask<Integer>(counter);
		Thread t = new Thread(task);
		t.start();
		
		try {
			System.out.println(task.get() + " matching files.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}

}

class MatchCounter implements Callable<Integer>{
	private File directory;
	private String keyWord;
	private int count;
	
	MatchCounter(File directory, String keyWord){
		this.directory = directory;
		this.keyWord = keyWord;
	}
	
	//在文件中搜索关键字
	public boolean search(File file){
		try {
			Scanner in = new Scanner(file);
			boolean found = false;
			while(!found && in.hasNextLine()){
				String line = in.nextLine();
				if(line.contains(keyWord)){
					found = true;
				}
			}
			return found;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public Integer call() throws Exception {
		count = 0;
		File[] files = directory.listFiles();
		//设置多个线程来访问文件，放在结果集中
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		
		for (File file : files) {
			if(file.isDirectory()){
				//是目录，开启一个计算任务
				MatchCounter counter = new MatchCounter(file, keyWord);
				FutureTask<Integer> task = new FutureTask<Integer>(counter);
				//新的任务开启并放在结果集中
				results.add(task);
				Thread t = new Thread(task);
				t.start();
			}else{
				//是文件，搜索关键字，计数
				if(search(file)){
					count++;
				}
				
			}
		}
		
		//对于结果集中的所有结果，计算所有的次数
		for (Future<Integer> future : results) {
			//如果有些线程没有结果，就阻塞
			count += future.get();
		}
		
		return count;
	}
	
	
} 
