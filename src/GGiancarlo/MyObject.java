package GGiancarlo;

public class MyObject {
  private int baslangic;
  private int bitis;
  public MyObject(int indis,int uzunluk){
	  baslangic=indis;
	  bitis=baslangic+uzunluk;
  }
  public int GetBaslangic(){
	  return baslangic;
  }
  public int GetBitis(){
	  return bitis;
  }
}
