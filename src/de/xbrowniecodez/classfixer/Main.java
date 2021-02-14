package de.xbrowniecodez.classfixer;

import de.xbrowniecodez.classfixer.processor.Processor;
import de.xbrowniecodez.classfixer.utils.Utils;

public class Main {
	public static void main(String args[]) throws Throwable {
		if(args.length == 0 || args[0] == null)  {
			System.out.println("Invalid input.");
			return;
		}
		if(!args[0].endsWith(".jar"))  {
			System.out.println("Input file must be .jar");
			return;
		}
		Utils.log("Starting ClassFixer v1.0 by xBrownieCodez");
		new Processor(args[0]);
		Utils.log("Done! Output: " + args[0].replace(".jar", "") + "-Output.jar");
	}
}
