/*******************************************************************************
 * Copyright (C) 2011 Filip Konecny
 * 
 * This file is part of NTS-lib-java.
 * 
 * NTS-lib-java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * NTS-lib-java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with NTS-lib-java.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package client;

import java.io.IOException;
import java.io.Writer;


/**
 * Class that helps to generate indented streams. The type of the stream used must
 * be a subclass of Writer class.
 */
public class IndentedWriter {
	private static String indentStep_def = "   ";
	private String indentStep = indentStep_def;
	private StringBuffer indent;
	private int indentCnt;
	{
		indent = new StringBuffer();
		indentCnt = 0;
	}
	public String indent() { 
		return new String(indent); 
	}
	public int indentCnt() { return indentCnt; }
	public void indentInc() { 
		indent.append(indentStep);
		indentCnt++;
	}
	public void indentDec() {
		int n = indent.length();
		indent.delete(n-indentStep.length(), n);
		indentCnt--;
	}
	public String indentStep() { return new String(indentStep); }

	private boolean do_indent;
	private Writer writer;
	
	public IndentedWriter(Writer aWriter, String userIndentStep) {
		this(aWriter);
		indentStep = userIndentStep;
	}
	public IndentedWriter(Writer aWriter) {
		writer = aWriter;
	}
	public IndentedWriter(Writer aWriter, int aInitialIndent) {
		writer = aWriter;
		for (int i=0; i<aInitialIndent; ++i) {
			indentInc();
		}
	}
	
	public void flush() {
		try {
			writer.flush();
		} catch (IOException e) {
			System.err.println("Output problems with flush.");
			System.err.println(e.getMessage());
		}
	}
	public void close() throws IOException {
		writer.close();
	}
	
	public void write(String aString) {
		write(new StringBuffer(aString));
	}
	public void write(StringBuffer aString) {
		try {
			if (do_indent) {
				writer.append(indent);
				//write(new StringBuffer(indent));
				do_indent = false;
			}
			writer.append(aString);
		} catch (IOException e) {
			System.err.println("Output problems with write.");
			System.err.println(e.getMessage());
		}
	}
	
	public void writeln() {
		writeln("");
	}
	public void writeln(String aString) {
		writeln(new StringBuffer(aString));
	}
	public void writeln(StringBuffer aSb) {
		//write(new StringBuffer(indent));
		write(aSb); write("\n");
		do_indent = true;
	}
}
