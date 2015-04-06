/* 
The NIST RCS (Real-time Control Systems) 
 library is public domain software, however it is preferred
 that the following disclaimers be attached.

Software Copywrite/Warranty Disclaimer

   This software was developed at the National Institute of Standards and
Technology by employees of the Federal Government in the course of their
official duties. Pursuant to title 17 Section 105 of the United States
Code this software is not subject to copyright protection and is in the
public domain. NIST Real-Time Control System software is an experimental
system. NIST assumes no responsibility whatsoever for its use by other
parties, and makes no guarantees, expressed or implied, about its
quality, reliability, or any other characteristic. We would appreciate
acknowledgement if the software is used. This software can be
redistributed and/or modified freely provided that any derivative works
bear some notice that they are derived from it, and any modified
versions bear some notice that they have been modified.



*/ 

/*
*       New Java File starts here.
*       This file should be named PmQuaternion.java
*/


// Set Package Name
package rcs.posemath;

// Import all NML, CMS, and RCS classes and interfaces
import rcs.nml.NMLFormatConverter;

/*
*       Class definition for PmQuaternion
*       Automatically generated by RCS Java Diagnostics Tool.
*       on Wed Jan 07 10:53:47 EST 1998
*/
public class PmQuaternion implements Cloneable
{
  public double s = 1;
  public double x = 0;
  public double y = 0;
  public double z = 0;

  public void update(NMLFormatConverter nml_fc)
  {
      nml_fc.beginClass("PmQuaternion",null);
      s = nml_fc.update_with_name("s",s);
      x = nml_fc.update_with_name("x",x);
      y = nml_fc.update_with_name("y",y);
      z = nml_fc.update_with_name("z",z);
      nml_fc.endClass("PmQuaternion",null);
  }

  public PmQuaternion()
  {
  }

  public PmQuaternion(PmRpy rpy) throws PmException {
     Posemath.pmRpyQuatConvert(rpy, this);
  }
  
  public PmQuaternion(PmRotationVector rotv) throws PmException {
     Posemath.pmRotQuatConvert(rotv, this);
  }
  
  public PmQuaternion(PmRotationMatrix mat) throws PmException {
     Posemath.pmMatQuatConvert(mat, this);
  }
  
  public PmQuaternion(double starts, double startx, double startz, double starty) throws PmException
  {
    s = starts;
    x = startx;
    y = starty;
    z = startz;
    Posemath.pmQuatNorm(this,this);
  }

  public PmQuaternion multipy(PmQuaternion other) throws PmException {
      PmQuaternion out = new PmQuaternion();
      Posemath.pmQuatQuatMult(this, other, out);
      return out;
  }
  
  public String toString()
  {
    return " { s = "+s+", x ="+x+", y = "+y+", z = "+z+" } ";
  }

  public boolean equals(PmQuaternion pq) throws PmException
  {
    if(null == pq)
      {
        return false;
      }
    return Posemath.pmQuatQuatCompare(this,pq);
  }

  public boolean equals(PmRotationMatrix prm) throws PmException
  {
    if(null == prm)
      {
        return false;
      }
    PmQuaternion pq = new PmQuaternion();
    Posemath.pmMatQuatConvert(prm,pq);
    return Posemath.pmQuatQuatCompare(this,pq);
  }

  public boolean equals(PmRotationVector prv) throws PmException
  {
    if(null == prv)
      {
        return false;
      }
    PmQuaternion pq = new PmQuaternion();
    Posemath.pmRotQuatConvert(prv,pq);
    return Posemath.pmQuatQuatCompare(this,pq);
  }
  
  public PmQuaternion clone()
  {
      PmQuaternion cloned_object=null;
      try {
          cloned_object = (PmQuaternion) super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
      }
      return cloned_object;
  }

    /**
     * @return the s
     */
    public double getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(double s) {
        this.s = s;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double z) {
        this.z = z;
    }
}
