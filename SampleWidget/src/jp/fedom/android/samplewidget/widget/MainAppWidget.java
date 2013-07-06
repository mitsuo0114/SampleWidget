package jp.fedom.android.samplewidget.widget;

import jp.fedom.android.samplewidget.R;
import jp.fedom.android.samplewidget.service.MainAppService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

public class MainAppWidget extends AppWidgetProvider {
	private static final String TAG = "MainAppWidget";

	/**
	 * Called in response to the ACTION_APPWIDGET_OPTIONS_CHANGED broadcast when
	 * this widget has been layed out at a new size.
	 */
	public void onAppWidgetOptionsChanged(Context context,
			AppWidgetManager appWidgetManager, int appWidgetId,
			Bundle newOptions) {

	}

	/**
	 * Called in response to the ACTION_APPWIDGET_DELETED broadcast when one or
	 * more AppWidget instances have been deleted. Override this method to
	 * implement your own AppWidget functionality.
	 * 
	 */
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		Log.v("HelloAndroidWidget", "onDeleted");
	}

	/*
	 * Called in response to the ACTION_APPWIDGET_DISABLED broadcast, which is
	 * sent when the last AppWidget instance for this provider is deleted.
	 * Override this method to implement your own AppWidget functionality.
	 */
	public void onDisabled(Context context) {
		super.onDisabled(context);
		Log.v("HelloAndroidWidget", "onDisabled");
	}

	/*
	 * Called in response to the ACTION_APPWIDGET_ENABLED broadcast when the a
	 * 
	 * 
	 * AppWidget for this provider is instantiated. Override this method to
	 * implement your own AppWidget functionality.
	 */
	public void onEnabled(Context context) {
		super.onEnabled(context);
		Log.v("HelloAndroidWidget", "onEnabled");
	}

	/**
	 * Implements onReceive(Context, Intent) to dispatch calls to the various
	 * other methods on AppWidgetProvider.
	 */
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		Log.v("HelloAndroidWidget", "onReceive");
	}

	public static PendingIntent getPendingIntentwithAction(String action,Context context){
		Intent buttonIntent = new Intent();
		buttonIntent.setAction(action);
		return PendingIntent.getService(context, 0, buttonIntent, 0);
	}
	
	public static void setOnClickIDIntentMapping(RemoteViews des, int[] ids, PendingIntent[] intents){
		if(ids.length != intents.length){
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < ids.length; i++){
			des.setOnClickPendingIntent(ids[i], intents[i]);
		}
	}
	
	/**
	 * Called in response to the ACTION_APPWIDGET_UPDATE broadcast when this
	 * AppWidget provider is being asked to provide RemoteViews for a set of
	 * AppWidgets. Override this method to implement your own AppWidget
	 * functionality.
	 */
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Log.v("HelloAndroidWidget", "onUpdate");
		
		PendingIntent pendingIntent = getPendingIntentwithAction(MainAppService.BUTTON_CLICK_ACTION,context);
		PendingIntent pendingIntent2 = getPendingIntentwithAction(MainAppService.BUTTON_CLICK_ACTION2,context);
		
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);		
		setOnClickIDIntentMapping(remoteViews,new int[]{R.id.hello, R.id.hello2},new PendingIntent[]{pendingIntent, pendingIntent2});
		
		// update widget view
		ComponentName thisWidget = new ComponentName(context, MainAppWidget.class);
		appWidgetManager.updateAppWidget(thisWidget, remoteViews);
	}

}
