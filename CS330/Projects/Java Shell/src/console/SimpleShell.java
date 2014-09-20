package console;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleShell
{
	public static void main(String[] args) throws java.io.IOException
	{
		String commandLine;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		//Break with Control-C
		while (true)
		{
			//Read input
			System.out.print("jsh>");
			commandLine = console.readLine();
			ArrayList<String> command = parse(commandLine);
			
			try {
				ProcessBuilder builder = new ProcessBuilder(command);
				Process process = builder.start();
				System.out.print(readCommandOutput(process.getInputStream()));
			} catch (IOException ie) {
				System.out.println("Command '" + command.get(0) + "' not found");
			}
			//If return entered, loop again
			if (commandLine.equals(""))
				continue;
			
			/**
			 * TODO
			 * 2) Create ProcessBuilder
			 * 3) Start Process
			 * 4) Obtain output stream
			 * 5) Display the output
			 */
		}
	}
	
	private static ArrayList<String> parse(String command)
	{
		String[] commandArray = command.split(" ");
		for (String element : commandArray)
		{
			if (element.contains("-"))
				element.replaceAll("-", "");
		}
		return new ArrayList<String>(Arrays.asList(commandArray));
	}
	
	private static String readCommandOutput(InputStream processInputStream) throws IOException
	{
		String output = "";
		Reader reader = new InputStreamReader(processInputStream);
		int charVal;
		while ((charVal = reader.read()) != -1)
			output += (char) charVal;
		reader.close();
		return output;
	}
}