package files_sniff;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class FileSniff {
	static String tar;
	public static boolean isJpg(File f) {
		try {
			Image img=ImageIO.read(f);
			return img!=null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}
	public static void fileMove(File f) {
		f.renameTo(new File(tar+f.getName()));
	}
	public static void getFile(File f) {
//		File f=new File(path);
		File[] fs=f.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (!fs[i].isDirectory()) {
				if (isJpg(fs[i])) fileMove(fs[i]);
			}
			else getFile(fs[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		tar=input.next()+File.separatorChar;
		getFile(new File(input.next()));
		File nef=new File(tar);
		if (nef.exists()) nef.mkdirs();
	}

}
