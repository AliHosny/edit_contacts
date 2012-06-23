package com.ALi.edit_my_contacts;

import android.R.string;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.RawContacts;
import android.view.View;
import android.widget.Button;
import java.lang.Runnable;
public class edit extends Activity implements Runnable{
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
      
       
          
    }
    public void run(){
    	ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0)
        {
        	
	    while (cur.moveToNext()) 
	    {
	        String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
	       
		String name = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
		
	
 		if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) 
 		{
 		    //Query phone here.  Covered next
 			 if (Integer.parseInt(cur.getString(
 	                   cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
 	                Cursor pCur = cr.query(
 	 		    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
 	 		    null, 
 	 		    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", 
 	 		    new String[]{id}, null);
 	               //pCur.moveToNext();
 	             
 	 	       while (pCur.moveToNext()) 
 	 	       {
 	 	    	   
 	 	        	String num=pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
 	 	        	ContentValues values = new ContentValues();
 	 	        	String dd= pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
 	 	    Uri workUri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, dd);
 	 		
 	 	       values.clear(); 	
 	 	values.put(ContactsContract.CommonDataKinds.Phone.NUMBER,edit(num));
 	 		
 	 		int s =this.getContentResolver().update(workUri, values, null, null);
 	 		
 	 		
 	 	        	// Do something with phones
 	 	
 	 		
 	 	       } 
 	 	        pCur.close();
 	 	    } 
 		}
 		
            }
	   
	    
 	}
    	
    }
    String vod1="010",vod11="0100";
    String vod2="016", vod22="0106";
    String vod3="019",vod33="0109";
    String vod4="0151",vod44="0101";
    String mob1="012", mob11="0122";
    String mob2="018", mob22="0128";
    String mob3="017", mob33="0127";
    String mob4="0150", mob44="0120";
    String eti1="011",eti11="0111";
    String eti2="014",eti22="0114";
    String eti3="0152",eti33="0112";
    String eti4="0155",eti44="0115";
    public void change(View view){
    	
    	Button start=(Button) findViewById(R.id.start);
    	start.setText("Modifying Contacts...Please wait");
    	(new Thread(this)).start();
         
        start.setText("Your Contacts have been modified , Thank you for using Edit my Contacts");
    	
    }
    public String edit (String num){
    	
    	if(num.length()>9)
    	{
    	num=num.replace("-", "");
    	String temp1="";
    	String temp2="";
    	String temp3="";
    	String temp4="";
    	
    	int i=3;
    	int j=4;
    	temp1=num.substring(0,3);
    	temp3=num.substring(0, 4);
    	temp4=num.substring(0,2);
    	if(temp4.equals("+2"))
    	{
    		temp1=num.substring(2, 5);
    		temp3=num.substring(2, 6);
    		i=5;
    		j=6;
    		temp2="+2";
    	}
    	else if(temp4.equals("00"))
    	{
    		temp1=num.substring(3, 6);
    		temp3=num.substring(3, 7);
    		i=6;
    		j=7;
    		temp2="002";
    	}
    	
    	int temp5=num.substring(i).length();
    	if((temp1.equals(vod1)||temp1.equals(vod2)||temp1.equals(vod3)||temp3.equals(vod4)||temp1.equals(mob1)||temp1.equals(mob2)||temp1.equals(mob3)||temp3.equals(mob4)||temp1.equals(eti1)||temp1.equals(eti2)||temp3.equals(eti3)||temp3.equals(eti4))&&( (num.substring(i).length()<=8)||(num.substring(j).length()<=8)))
    	{
    		if(temp1.equals(vod1)&&temp5<8)
    		{
    			temp2+=vod11+num.substring(i);
    			return temp2;
    		}
    		else if(temp1.equals(vod2)&&temp5<8)
    		{
    			temp2+=vod22+num.substring(i);
    			return temp2;
    		}
    		else if(temp1.equals(vod3)&&temp5<8)
    		{
    			temp2+=vod33+num.substring(i);
    			return temp2;
    		}
    		else if(temp3.equals(vod4)&&!temp3.equals(vod44))
    		{
    			temp2+=vod44+num.substring(j);
    			return temp2;
    		}
    		else if(temp1.equals(mob1)&&temp5<8)
    		{
    			temp2+=mob11+num.substring(i);
    			return temp2;
    		}
    		else if(temp1.equals(mob2)&&temp5<8)
    		{
    			temp2+=mob22+num.substring(i);
    			return temp2;
    		}
    		else if(temp1.equals(mob3)&&temp5<8)
    		{
    			temp2+=mob33+num.substring(i);
    			return temp2;
    		}
    		else if(temp3.equals(mob4)&&!temp3.equals(mob44))
    		{
    			temp2+=mob44+num.substring(j);
    			return temp2;
    		}
    		else if(temp1.equals(eti1)&&temp5<8)
    		{
    			temp2+=eti11+num.substring(i);
    			return temp2;
    		}
    		else if(temp1.equals(eti2)&&temp5<8)
    		{
    			temp2+=eti22+num.substring(i);
    			return temp2;
    		}
    		else if(temp3.equals(eti3)&&!temp3.equals(eti33))
    		{
    			temp2+=eti33+num.substring(j);
    			return temp2;
    		}
    		else if(temp3.equals(eti4)&&!temp3.equals(eti44))
    		{
    			temp2+=eti44+num.substring(j);
    			return temp2;
    		}
    	}
    	
    }
    	return num;
    	
    	
    	
    }
   
}