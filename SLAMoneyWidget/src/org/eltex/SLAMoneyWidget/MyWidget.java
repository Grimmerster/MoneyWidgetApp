package org.eltex.SLAMoneyWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.xmlpull.v1.XmlPullParserException;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class MyWidget extends AppWidgetProvider {
	final String LOG_TAG = "myLogs";
	
	ArrayList<String> data;
	TextView tvName,tvMoney;
	String str="";

	  @Override
	  public void onEnabled(Context context) {
	    super.onEnabled(context);
	    Log.v(LOG_TAG, "onEnabled");
	  }

	  @Override
	  public void onUpdate(Context context, AppWidgetManager appWidgetManager,
	      int[] appWidgetIds) {
	    super.onUpdate(context, appWidgetManager, appWidgetIds);
	    Log.d(LOG_TAG, "onUpdate " + Arrays.toString(appWidgetIds));
	    //tvName = (TextView) findViewById(R.id.text1);
	    AndreyzUpDater aud= new AndreyzUpDater("http://www.cbr.ru/scripts/XML_daily.asp");
	    try {
			data = aud.getSlavaDate();
			for(int i=0;i<data.size();i++){
				str+=data.get(i);
			}
			Log.v(LOG_TAG, str);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	  }

	  @Override
	  public void onDeleted(Context context, int[] appWidgetIds) {
	    super.onDeleted(context, appWidgetIds);
	    Log.d(LOG_TAG, "onDeleted " + Arrays.toString(appWidgetIds));
	  }

	  @Override
	  public void onDisabled(Context context) {
	    super.onDisabled(context);
	    Log.d(LOG_TAG, "onDisabled");
	  }

}
