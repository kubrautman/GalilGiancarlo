package GGiancarlo;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Searcher{

	private String arananKelime;
	private String metin;
	private int i,j,k;
	private ArrayList<Step> steps;
	private int m_uzunluk;
	private DefaultTableModel model;
	public static int ell=0;
	private int k_uzunluk;
	public Searcher(String kelime,String metin,DefaultTableModel model){
		this.arananKelime=kelime;
		this.metin=metin;
		m_uzunluk=metin.length();
		k_uzunluk=kelime.length();
		this.model=model;
		j=0;
		k=0;
		steps=new ArrayList<Step>();
		baslangicBul();
	}
	public void baslangicBul(){
		for (int c = 1; c<arananKelime.length(); c++) {
			if(arananKelime.charAt(c-1)!=arananKelime.charAt(c)){ell=c; break;}
			else ell++;
		}
		if(ell==k_uzunluk) ell=0;
		else i=ell;
	}
    public ArrayList indisBul(){
    	steps.clear();
    	ArrayList<MyObject> a=new ArrayList<MyObject>();
    	int temp_i=i;
    	int temp_j=j;
    	int temp_k=k;
    	int eslesen;
    	while(j<=m_uzunluk-k_uzunluk)
    	{
    		eslesen=0;
    		temp_i=i;
    		temp_j=j;
    		temp_k=k;
    		while(i<k_uzunluk&&arananKelime.charAt(i)==metin.charAt(i+j)){eslesen++;
    			i++;}
    		if(i>=k_uzunluk)
    		{
    			while(k<ell && arananKelime.charAt(k)==metin.charAt(j+k))
    			{k++;
    			eslesen++;}
    			if(k>=ell){
    				MyObject obj=new MyObject(j,k_uzunluk);
    				a.add(obj);
    			}
    		}
    		j+=(i-Integer.valueOf((String)model.getValueAt(0,i)));
    		if(i==ell){k=Math.max(0,k-1);        		
    					}
    		else
    		{        		

    			if(Integer.valueOf((String)model.getValueAt(0,i))<=ell)
    			{
    				k=Math.max(0,Integer.valueOf((String)model.getValueAt(0,i)));
    				i=ell;
    			}
    			else{
    				k=ell;
    				i=Integer.valueOf((String)model.getValueAt(0,i));
    			}
    		}
    		
    		Step e=new Step(temp_i,temp_j,temp_k,i, j, k,eslesen);
    		steps.add(e);
    		
    		
    	}
    	return a;
    }
     public ArrayList GetValues(){
    	 return steps;
     }
}
