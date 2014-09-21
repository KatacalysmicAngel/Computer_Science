import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class SimpleShell {
	public static void main(String[] args) throws IOException
	{
		String commandLine;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		while (true)
		{
			System.out.print("jsh>");
			commandLine = console.readLine();
			ArrayList<String> parsedCommand = parse(commandLine);

			if (commandLine.equals(""))
				continue;

			try
			{

				ProcessBuilder builder = new ProcessBuilder(parsedCommand);
				Process process = builder.start();
				System.out.print(readCommandOutput(process.getInputStream()));
			}
			catch (IOException ioe)
			{
				System.out.println("Command '" + parsedCommand.get(0) + "' not found");
			}
		}
	}

	private static ArrayList<String> parse(String commandLine)
	{
		ArrayList<String> command = new ArrayList<String>(Arrays.asList(commandLine.split(" ")));
		for (String element : command)
		{
			if (element.startsWith("-"))
				element.replaceFirst("-", "");
		}
		return command;
	}

	private static String readCommandOutput(InputStream processInputStream) throws IOException
	{
		String output = "";
		Reader reader = new InputStreamReader(processInputStream);
		int charVal;
		while ((charVal = reader.read()) != -1)
			output += (char)charVal;
		reader.close();
		return output;
	}
}
