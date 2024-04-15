/* ###
 * IP: Apache License 2.0 with LLVM Exceptions
 */
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package SWIG;

public final class DynamicValueType {
  public final static DynamicValueType eNoDynamicValues = new DynamicValueType("eNoDynamicValues", lldbJNI.eNoDynamicValues_get());
  public final static DynamicValueType eDynamicCanRunTarget = new DynamicValueType("eDynamicCanRunTarget", lldbJNI.eDynamicCanRunTarget_get());
  public final static DynamicValueType eDynamicDontRunTarget = new DynamicValueType("eDynamicDontRunTarget", lldbJNI.eDynamicDontRunTarget_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static DynamicValueType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + DynamicValueType.class + " with value " + swigValue);
  }

  private DynamicValueType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private DynamicValueType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private DynamicValueType(String swigName, DynamicValueType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static DynamicValueType[] swigValues = { eNoDynamicValues, eDynamicCanRunTarget, eDynamicDontRunTarget };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

