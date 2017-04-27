import java.io.*;
class LineNumbers
{
	public static void main(String args[])throws IOException
	{

		FileReader fr = new FileReader("IP_C.java");
		BufferedReader br = new BufferedReader(new FileReader("IP_C.java"));
		FileWriter fw = new FileWriter("lines.txt");

		int line=1;

		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null)
		{

			fw.write(line + " " + sCurrentLine );
			fw.write("\r\n");

			line++;
		}

		fw.flush();
		fw.close();

	}
}