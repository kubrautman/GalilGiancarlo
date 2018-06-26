package GGiancarlo;

public class Step {
 private int i,j,k;
 private int ri,rj,rk;
 private int eslesen;
 public Step(int k,int l,int m,int a,int b,int c,int f)
 {
	 this.i=a;
	 this.j=b;
	 this.k=c;
	 this.ri=k;
	 this.rj=l;
	 this.rk=m;
	 eslesen=f;
 }
 public int GetI(){
	 return i;
 }
 public int GetJ(){
	 return j;
 }
 public int GetK(){
	 return k;
 }
 public int GetRI(){
	 return ri;
 }
 public int GetRJ(){
	 return rj;
 }
 public int GetRK(){
	 return rk;
 }
 public int GetEslesen(){
	 return eslesen;
 }
}
