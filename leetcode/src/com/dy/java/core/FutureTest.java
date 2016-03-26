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
		//���Դ�Ŷ��Callable
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
	
	//���ļ��������ؼ���
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
		//���ö���߳��������ļ������ڽ������
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		
		for (File file : files) {
			if(file.isDirectory()){
				//��Ŀ¼������һ����������
				MatchCounter counter = new MatchCounter(file, keyWord);
				FutureTask<Integer> task = new FutureTask<Integer>(counter);
				//�µ������������ڽ������
				results.add(task);
				Thread t = new Thread(task);
				t.start();
			}else{
				//���ļ��������ؼ��֣�����
				if(search(file)){
					count++;
				}
				
			}
		}
		
		//���ڽ�����е����н�����������еĴ���
		for (Future<Integer> future : results) {
			//�����Щ�߳�û�н����������
			count += future.get();
		}
		
		return count;
	}
	
	
} 
