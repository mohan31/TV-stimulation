
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

class closeAllFileException extends Exception
{
	
}
abstract class tv extends JFrame 
{
	 Thread t;
	 String name;
	 String s;
	 RandomAccessFile raf ,temp;
	 boolean recordcheck=false;
	 JLabel l2;
	 ImageIcon iconLogo;
	 
	tv()
	{
		setLocation(400, 200);
		setSize(600,400);
	}
	
	synchronized public  void record(String channel){
	
		record(5,channel);
		
	}
	synchronized public  void record(int time,String channel){
		String temp=s;
		RandomAccessFile raf1;
		PrintWriter recordfile;
		String recordpath=null;
		s="                RECORDING.....      ";
		try{
			recordfile=new PrintWriter(new FileWriter("D://javaProject//"+channel+"record.txt"));
			raf1= new RandomAccessFile("D://javaProject//"+channel+".txt", "r");
			raf1.seek(raf.getFilePointer());
			
		for(int i=0;i<time;i++){
		System.out.println("Recoding"+(i+1));
		
			 
			 recordpath=raf1.readLine();
			 if(recordpath==null)
			 {
				 raf1.seek(0);
				 i--;
				 continue;
			 }
			 recordfile.println(recordpath);
			 
		}
		raf1.close();
		 recordfile.close();
		 s=temp;
		}
			catch(Exception e){e.printStackTrace();}
	}
	
	
}
class natgeo extends tv implements Runnable
{
	 
	JLabel l;
	
	natgeo()
	{
		s="              NatGeo LIVE!  ";
		name="natgeo";
		l=new JLabel("",JLabel.CENTER);
		l2=new JLabel("",JLabel.CENTER);
		
		add(l,BorderLayout.CENTER);
		add(l2,BorderLayout.SOUTH);
		
		setVisible(true);
		
		try{
			raf= new RandomAccessFile("D://javaProject//natgeo.txt", "rw");
			 
			
			}catch(Exception e){e.printStackTrace();}
		 t=new Thread(this);
		 t.setPriority(9);
		t.start();
		addWindowListener(new WindowAdapter()
		{
	public void windowClosing(WindowEvent e)
	{
		t.stop();
		try {
			raf.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	System.exit(0);
	}
		});
	}
	public void run()
	{
		while(true)
		{
			String path=null;
			try {
				path=raf.readLine();
				if(path==null&&recordcheck==true)
				{
					raf.close();
					raf=temp;
					recordcheck=false;
					System.out.println("record end");
					l2.setForeground(Color.BLACK);
					s="                 NatGeo LIVE!  ";
					continue;
				}
				if(path==null)
				{
					
					raf.seek(0);
					continue;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			iconLogo = new ImageIcon(path);
			s=s.substring(1)+s.substring(0, 1);
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("natgeo thread");
		}
		
	}
	public void paint(Graphics g)
	{
		l.setIcon(iconLogo);
		l2.setText(s);
		
	}
	
}
class colors extends tv implements Runnable
{
	
	JLabel l;
	
	colors()
	{
		s="                     colors LIVE! ";
		name="colors";
		l=new JLabel("",JLabel.CENTER);
		l2=new JLabel("",JLabel.CENTER);
		add(l,BorderLayout.CENTER);
		add(l2,BorderLayout.SOUTH);
		
		setVisible(true);
		try{
			raf= new RandomAccessFile("D://javaProject//colors.txt", "rw");
			 
			
			}catch(Exception e){e.printStackTrace();}
		 t=new Thread(this);
		 t.setPriority(2);
		t.start();
		addWindowListener(new WindowAdapter()
		{
	public void windowClosing(WindowEvent e)
	{
		t.stop();
		try {
			raf.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	setVisible(false);
	System.exit(0);
	}
		});
	}
	public void run()
	{
		while(true)
		{
			String path=null;
			try {
				path=raf.readLine();
				if(path==null&&recordcheck==true)
				{
					raf.close();
					raf=temp;
					recordcheck=false;
					System.out.println("record end");
					l2.setForeground(Color.BLACK);
					s="                     colors LIVE!   ";
					continue;
				}
				if(path==null)
				{
					
					raf.seek(0);
					continue;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 iconLogo = new ImageIcon(path);
			s=s.substring(1)+s.substring(0, 1);
			repaint();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("colors thread");
		}
		
	}
	public void paint(Graphics g)
	{
		l.setIcon(iconLogo);
		l2.setText(s);
		
	}
	
}
class starsports extends tv implements Runnable
{
	JLabel l;
	starsports()
	{
		s="                        Star Sports LIVE!  ";
		name="starsports";
		l=new JLabel("",JLabel.CENTER);
		l2=new JLabel("",JLabel.CENTER);
		
		add(l,BorderLayout.CENTER);
		add(l2,BorderLayout.SOUTH);
		setVisible(true);
		try{
			raf= new RandomAccessFile("D://javaProject//starsports.txt", "rw");
			 
			
			}catch(Exception e){e.printStackTrace();}
		t=new Thread(this);
		t.setPriority(2);
		t.start();
		
		addWindowListener(new WindowAdapter()
		{
	public void windowClosing(WindowEvent e)
	{
		t.stop();
		try {
			raf.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.exit(0);
	setVisible(false);
	}
		});
	}
	public void run()
	{
		while(true)
		{

			String path=null;
			try {
				path=raf.readLine();
				if(path==null&&recordcheck==true)
				{
					raf.close();
					raf=temp;
					recordcheck=false;
					System.out.println("record end");
					l2.setForeground(Color.BLACK);
					s="                                 Star Sports LIVE!  ";
					continue;
				}
				if(path==null)
				{
					
					raf.seek(0);
					continue;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 iconLogo = new ImageIcon(path);
			s=s.substring(1)+s.substring(0, 1);
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("star sports");
		}
	}
	public void paint(Graphics g)
	{
		l.setIcon(iconLogo);
		l2.setText(s);
		
	}
	
	
}
public class remote extends Frame implements ActionListener {

	natgeo n;
	starsports s;
	colors c;
	tv run,wt1,wt2;
	
	Button b[]=new Button[4];
	Button playrecordbtn;
	remote()
	{
		
		b[0]=new Button("next");
		b[1]=new Button("Back");
		b[2]=new Button("record");
		b[3]=new Button("Turn ON");
		playrecordbtn=new Button("Play Recorded");
		setLayout(new GridLayout(5,1));
		add(b[3]);
		add(b[0]);
		add(b[1]);
		add(b[2]);
		add(playrecordbtn);
		
		for(int i=0;i<4;i++)
		{
			b[i].addActionListener(this);
			b[i].setEnabled(false);
		}
		playrecordbtn.addActionListener(this);
		playrecordbtn.setEnabled(false);
		b[3].setEnabled(true);
		setVisible(true);
		addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e)
			{
				try {
					n.raf.close();
					s.raf.close();
					c.raf.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			System.exit(0);	
			}
				});
		setSize(200,300);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b[3])
		{
			if(b[3].getLabel().equals("Turn ON")){
			b[3].setLabel("Turn OFF");
			try{
			n=new natgeo();
			Thread.sleep(100);
			s=new starsports();
			Thread.sleep(100);
			c=new colors();
			Thread.sleep(100);
			}catch(Exception err){}
			c.setVisible(false);
			s.setVisible(false);
			s.t.suspend();
			c.t.suspend();
			run=n;
			wt1=s;
			wt2=c;
			
			
			}
			else{
				System.exit(0);
			}
			for(int i=0;i<4;i++)
				b[i].setEnabled(true);
			playrecordbtn.setEnabled(true);
			
		}
		else if(e.getSource()==b[0])
		{
			tv temp;
			run.t.suspend();
			wt1.t.resume();
			run.setVisible(false);
			wt1.setVisible(true);
			temp=run;
			run=wt1;
			wt1=wt2;
			wt2=temp;
			
		}
		else if(e.getSource()==b[1])
		{
			tv temp;
			run.t.suspend();
			wt2.t.resume();
			run.setVisible(false);
			wt2.setVisible(true);
			temp=run;
			run=wt2;
			wt2=wt1;
			wt1=temp;
		}
		else if(e.getSource()==b[2])
		{
			int choice=JOptionPane.showConfirmDialog(
		            null,
		            "Would you like set the timer?",
		            "Recording option",
		            JOptionPane.YES_NO_OPTION);
			if(choice==JOptionPane.YES_OPTION)
			{
				String s=JOptionPane.showInputDialog(null, "Set the timer");
				int time=Integer.parseInt(s);
				run.record(time,run.name);
			}
			else
			{
				run.record(run.name);
			}
		}
		else
		{
			File f=new File("D://javaProject");
			String fnames[]=f.list();
			boolean filecheck=false;
			for(int i=0;i<fnames.length;i++)
			{
				
				if(fnames[i].equals(run.name+"record.txt"))
				{
					System.out.println(fnames[i]);
					filecheck=true;
					break;
				}
			}
			System.out.println(filecheck);
			if(filecheck)
			{
				RandomAccessFile recordfile;
				try {
					 recordfile=new RandomAccessFile("D://javaProject//"+run.name+"record.txt","r");
					 run.l2.setForeground(Color.red);
						run.s="                  --------RECORDED SHOW-----------  ";
					 run.temp=run.raf;
					 run.recordcheck=true;
					 run.raf=recordfile;
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NO recording found");
			}
			
		}
		
	}
	public static void main(String arg[])
	{
		new remote();
	}
	
	
}
