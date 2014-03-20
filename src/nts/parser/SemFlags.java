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
package nts.parser;

public class SemFlags {

	// track syntactic elements that imply some semantical restrictions
	
	// root expression context
	public static enum RootExContext {
		GENERAL, PRECONDITION, ACT_PARAM, RET_PARAM, ARRAY_SIZE_SPEC, INSTANCES, HAVOC_VAR;
		// general -- label expression, annotation formula
		
		public boolean noPrimed() { return this == ACT_PARAM || this == PRECONDITION || 
			this == ARRAY_SIZE_SPEC || this == INSTANCES || this == HAVOC_VAR; }
		public boolean onlyPrimed() { return this == RET_PARAM; }
		public boolean noIndexing() { return this == ARRAY_SIZE_SPEC || this == HAVOC_VAR; }
		public boolean onlyParameters() { return this == INSTANCES; }
		public boolean noArrSizeOp() { return this == INSTANCES || this == HAVOC_VAR; }
		public boolean paramsOrInputSize() { return this == ARRAY_SIZE_SPEC; }
	}
	
	private RootExContext rootContext;
	
	private int extraFlags;
	
	private static int noFlags = 0x0;
	private static int noPrimed = 0x1;
	private static int onlyPrimed = 0x2;
	
	private boolean flagged(int aFlag) { return (extraFlags & aFlag) != 0; }
	
	public boolean noPrimed() { return rootContext.noPrimed() || flagged(noPrimed); }
	public boolean onlyPrimed() { return rootContext.onlyPrimed() || flagged(onlyPrimed); }
	public boolean noIndexing() { return rootContext.noIndexing(); }
	public boolean onlyParameters() { return rootContext.onlyParameters(); }
	public boolean noArrSizeOp() { return rootContext.noArrSizeOp(); }
	public boolean paramsOrInputSize() { return rootContext.paramsOrInputSize(); }
	
	public static void error(Expr aE, String aS) {
		System.err.println("Semantic error at "+Common.at(aE.first)+": unexpected "+aS+".");
		System.exit(1);
	}
	
	private SemFlags(RootExContext aC, int aF) {
		rootContext = aC;
		extraFlags = aF;
	}
	
	public static SemFlags createGeneral() { return new SemFlags(RootExContext.GENERAL, noFlags); }
	public static SemFlags createPrecondition() { return new SemFlags(RootExContext.PRECONDITION, noFlags); }
	public static SemFlags createHavoc() { return new SemFlags(RootExContext.HAVOC_VAR, noFlags); }
	public static SemFlags createActParam() { return new SemFlags(RootExContext.ACT_PARAM, noFlags); }
	public static SemFlags createRetParam() { return new SemFlags(RootExContext.RET_PARAM, noFlags); }
	public static SemFlags createArraySizeSpec() { return new SemFlags(RootExContext.ARRAY_SIZE_SPEC, noFlags); }
	public static SemFlags createInstancesSpec() { return new SemFlags(RootExContext.INSTANCES, noFlags); }
	
	public static SemFlags addNoPrimed(SemFlags aS) { return new SemFlags(aS.rootContext, aS.extraFlags | noPrimed); }
	
}
