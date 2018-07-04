//------------------------------------------------------- 
//Assignment 4
//Written by: (Mengyi Yang, 40048192) 
//For COMP 249 Section (U) ¨C Winter 2018
//by one student
//-------------------------------------------------------

public class Course implements DirectlyRelatable{
private String courseID;
private String courseName;
private double credit;
private String preReqID;
private String coReqID;
public Course() {
	
}
public Course(String a, String b,double e,String c,String d ) {
	courseID=a;
	courseName=b;
	preReqID=c;
	coReqID=d;
	credit=e;
}
public Course(Course A) {
	courseName=A.getCourseName();
	courseID=A.getCourseID();
	preReqID=A.getPreId();
	coReqID=A.getCoID();
	credit=A.getCredit();
}
public Course(Course A, String b) {
	courseName=A.getCourseName();
	courseID=b;
	preReqID=A.getPreId();
	coReqID=A.getCoID();
	credit=A.getCredit();
}
public void setCredit(double a) {
	credit=a;
}
public double getCredit() {
	// TODO Auto-generated method stub
	return credit;
}
public void setCoID(String a)
{
	coReqID=a;
}
public void setPreID(String a) {
	preReqID=a;
}
public void setCourseName(String a) {
	courseName=a;
}
public String getCoID() {
	// TODO Auto-generated method stub
	return coReqID;
}
public String getPreId() {
	// TODO Auto-generated method stub
	return preReqID;
}
public void setCourseID(String a) {
	courseID=a;
}
public String getCourseID() {
	return courseID;
}
public String getCourseName() {
	return courseName;
}
public Course clone() {
	return new Course(this);
}
public String toString() {
	return("courseID: "+courseID+"\tcourse name: " +courseName+"\tcredit: "+credit+"\tpre-requisite course: "+preReqID+"\tco-requisite course: "+coReqID);
}
@Override
public boolean isDirectlyRelated(Course C) {
if(C.getCourseID().equals(this.getPreId()) || C.getCourseID().equals(this.getCoID()))
	return true;
return false;
}

}
