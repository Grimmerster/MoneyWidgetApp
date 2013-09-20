package org.eltex.SLAMoneyWidget;
import java.util.ArrayList;
import java.util.Arrays;

import android.R;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;


public class MyWidget extends AppWidgetProvider {
	final String LOG_TAG = "myLogs";
	
	ArrayList<String> data;
	TextView tvName,tvMoney;

	  @Override
	  public void onEnabled(Context context) {
	    super.onEnabled(context);
	    Log.d(LOG_TAG, "onEnabled");
	  }

	  @Override
	  public void onUpdate(Context context, AppWidgetManager appWidgetManager,
	      int[] appWidgetIds) {
	    super.onUpdate(context, appWidgetManager, appWidgetIds);
	    Log.d(LOG_TAG, "onUpdate " + Arrays.toString(appWidgetIds));
	   // AndreyzUpDater aud= new AndreyzUpDater("http://www.cbr.ru/scripts/XML_daily.asp");
	   // data = aud.getSlavaDate();	    
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
