import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class treedatastructure {
	public HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public void insert(int customerid,int expense){
		if(map.containsKey(customerid)){
			map.put(customerid, map.get(customerid)+expense);
		}else{
			map.put(customerid, expense);
		}	
	}
	class customers {
		public int customerid;
		public Integer expense;
		customers(int key,int value){
			this.customerid=key;
			this.expense=value;
		}
	}
	Comparator<customers> comp=new Comparator<customers>(){
		@Override
		public int compare(customers o1, customers o2) {
			// TODO Auto-generated method stub
			if(o1.expense>o2.expense)
			return 1;
			else
				return -1;
		}
	};
	public TreeSet<customers> sortedset=new TreeSet<customers>(comp);
	public void sort(){
		for(Integer key:map.keySet()){
			customers objt=new customers(key,map.get(key));
			sortedset.add(objt);
		}
		System.out.println("The top 5 customers are: ");
		Iterator j=sortedset.descendingIterator();
		for(int i=0;i<5 && j.hasNext();i++)
		{
		customers c=(customers) j.next();
		System.out.println(c.customerid+" "+c.expense);
		}
	}
	public static void main(String[] args){
		treedatastructure t= new treedatastructure();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter customerid and expense in pairs: ");
		while(s.hasNextInt()){
			t.insert(s.nextInt(),s.nextInt());
		}
		t.sort();
	}
	
}
