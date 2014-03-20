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
package nts.interf.base;

/**
 * Interface for a type. Besides the basic (scalar) types <tt>INT,REAL,BOOL,</tt> there are also composite array types. Different
 * kinds of arrays are distinguished:
 * <ul>
 * <li> array of basic-type elements -- declared as e.g. <tt>a1[N], a2[10,2*M]</tt>
 * <li> pure reference to an array -- declared as e.g. <tt>b1[], b2[][][]</tt>
 * <li> array of references to arrays -- declared as e.g. <tt>c1[5][], c2[K][][]</tt>
 * </ul>
 * 
 * <p>
 * These kinds are represented by
 * <ul> 
 * <li> the basic type 
 * <li> the dimension <tt>dRef</tt> of arrays they can reference -- e.g. 0 for <tt>a1</tt> and <tt>a2</tt>, 
 *      1 for <tt>b1</tt> and <tt>c1</tt>, 2 for <tt>c2</tt>, 3 for <tt>b2</tt>
 * <li> its own dimension <tt>dOwn</tt> -- e.g. 0 for <tt>b1</tt> and <tt>b2</tt>, 1 for 
 *      <tt>a1</tt>, <tt>c1</tt>, and <tt>c2</tt>, 2 for <tt>a2</tt>
 * <li> the total dimension <tt>dTotal = dRef + dOwn</tt>
 * </ul>
 * <p>
 * 
 * Note that for scalar types, <tt>dTotal = dRef = dOwn = 0</tt>.
 * 
 */
public interface IType extends IVisitable {
	
	/**
	 * @return the basic type -- e.g. <tt>INT</tt> for variables in declaration <tt>x,a1[5],a2[K][],a3[] : int</tt>
	 */
	public EBasicType basicType();
	
	/**
	 * @return true iff <tt>dTot == 0</tt>
	 */
	public boolean isScalar();
	/**
	 * @return true iff <tt>dTot != 0</tt>
	 */
	public boolean isArray();
	
	/**
	 * @return the dimension <tt>dRef</tt> described above
	 */
	public int dimRef();
	/**
	 * @return the dimension <tt>dOwn</tt> described above
	 */
	public int dimOwn();
	/**
	 * @return the dimension <tt>dTot</tt> described above
	 */
	public int dimTotal();
	
	/**
	 * @return true iff <tt>dOwn != 0</tt> and <tt>dRef == 0</tt>
	 */
	public boolean isArrayOfBasic();
	/**
	 * @return true iff <tt>dOwn == 0</tt> and <tt>dRef != 0</tt>
	 */
	public boolean isRefToArray();
	/**
	 * @return true iff <tt>dOwn != 0</tt> and <tt>dRef != 0</tt>
	 */
	public boolean isArrayOfRef();
	
//	/**
//	 * @return the declared array size. E.g. given a declaration <tt>a[N][5] : int;</tt> it returns a list <tt>&lt;N,5&gt;<tt>
//	 */
//	public List<IExpr> size();
}
