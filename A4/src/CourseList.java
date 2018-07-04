import java.util.NoSuchElementException;
//------------------------------------------------------- 
//Assignment 4
//Written by: (Mengyi Yang, 40048192) 
//For COMP 249 Section (U) ¨C Winter 2018
//by one student
//-------------------------------------------------------
class CourseList {
  
 class CourseNode{
	private Course obj;
	private CourseNode next;
	public CourseNode() {
		obj=null;
		next=null;
	}
	//privacy leak because this pass the reference of the object
	public CourseNode(Course obj1, CourseNode ob) {
		obj=obj1;  
		next=ob;
	}
	public CourseNode (CourseNode a) {//copy constructor create a new Course deep copy
		obj=a.obj.clone();
		next=a.next;		
	}
	public CourseNode clone() {
		return new CourseNode(obj,next);
	}
	public void setNext(CourseNode d) {
		next=d;
	}
	//privacy leak because it returns the reference
	public CourseNode getNext() {
		return next;
	}
	//privacy leak because it returns the reference of object
	
	public Course getCourse() {
		// TODO Auto-generated method stub
		return obj;
	}
	
	}
	private CourseNode head;
	private int size;
	public CourseList() {
		head=null;
	}
	public CourseList(CourseList list) {
		if(list.head==null)
			head=null;
		else {
			CourseNode t1=list.head, t2=null, t3=null;
			while(t1!=null) {
				if(head==null) {
					t2=new CourseNode(t1);
					head=t2;
				}
				else {
					t3=new CourseNode(t1);
					t2.next=t3;
					t2=t3;
				}
				t1=t1.next;						
			}
			t2=t3=null;
		}
	}
public void sethead(CourseNode h) {
		head=h;
	}

public void setSize(int a) {
	size=a;
}
public int getSize() {
	return size;
}
public void addToStart(Course a) {
	CourseNode add=new CourseNode(a.clone(),head);
	head=add;
	add=null;
	size++;
}
public int size() {
	int count=0;
	CourseNode temp=head;
	while(temp!=null) {
		count++;
		temp=temp.next;
	}
	return count;
	
}
public void insertAtindex(Course a,int num) {
	if(num<0||num>this.size()-1)
	{
		throw new NoSuchElementException();//end?
	}
	else
	{
		CourseNode n=new CourseNode(a,null);
		int count=0;
		CourseNode temp=head;
		if(num==0) {
			CourseNode t1=new CourseNode(a,head);
			head=t1;
			t1=null;
		}
		else {			
		while(count!=num-1) {
			temp=temp.next;
			count++;
		}
		CourseNode t=temp.next;
		temp.next=n;
		temp.next.next=t;
		temp=t=n=null;
	}
	}
	size++;
}
public void deleteFromindex(int num) {
	if(num<0||num>this.size()-1)
	{
		throw new NoSuchElementException();//end?
	}
	else {
		CourseNode t=head;
		int count=0;
		if(head==null) {
			return;
		}
		if(num==0) {
			t=t.next;
			head=t;
			t=null;
		}
		else {
		while(count!=num-1) {
			t=t.next;
			count++;
		}
		if(num!=this.size()-1)
		t.next=t.next.next;
		else
			t.next=null;
		t=null;
	}
	}
	size--;
}
public void deleteFromStart() {
	if(head==null)
		return;
	head=head.next;
	size--;
}
public void replaceAtIndex(Course a, int num) {
	if(num<0 || num>this.size()-1)
		return;
	else {
		CourseNode t=head;
		int count=0;
		CourseNode temp=head;
		while(count!=num-1) {
			temp=temp.next;
			count++;
		}
		if(num==this.size()-1)			
		temp.next=new CourseNode(a,null);
		else
		{
			CourseNode temp2=temp.next.next;
			temp.next=new CourseNode(a,null);
			temp.next.next=temp2;
			temp=temp2=null;
		}		
			}
		}

//This method may result in a privacy leak
public CourseNode find(String ID) {
	CourseNode t=head;
	while(t!=null) {
		if(t.obj.getCourseID().equals(ID))
			return t;
		t=t.next;
	}
	return null;
}
public boolean contains(String ID) {
	if(find(ID)==null)
		return false;
	return true;
}
 public boolean equals(CourseList a) {
	if(this.size()!=a.size())
		return false;
	CourseNode t1=head;
	CourseNode t2=a.head;
	if(t1==null && t2==null)
		return true;
	while(t1!=null) {
		if((t1.obj.getCoID().equals(t2.obj.getCoID()))&&t1.obj.getCourseName().equals(t2.obj.getCourseName())&&t1.obj.getCredit()==t2.obj.getCredit()&&
				t1.obj.getPreId().equals(t2.obj.getPreId()))			
		return true;
		t1=t1.next;
		t2=t2.next;
	}
	return false;
 }
 public void showListContents()
	{
		CourseNode temp = head;
		if (temp == null)
			System.out.println("\nThere is nothing to display; list is empty." );
		else
			System.out.println("\nHere are the contents of the list." );
		while(temp != null)
		{
			System.out.println(temp.obj );
			temp = temp.next;		
		}
		System.out.println("\n");			}
public CourseNode gethead() {
	// TODO Auto-generated method stub
	return head;
}

}
