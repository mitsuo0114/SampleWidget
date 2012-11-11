package jp.fedom.android.samplewidget.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainAppWidget extends AppWidgetProvider {

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
		Log.v("HelloAndroidWidget", "onDeleted");
		super.onDeleted(context, appWidgetIds);
	}

	/*
	 * Called in response to the ACTION_APPWIDGET_DISABLED broadcast, which is
	 * sent when the last AppWidget instance for this provider is deleted.
	 * Override this method to implement your own AppWidget functionality.
	 */
	public void onDisabled(Context context) {
		Log.v("HelloAndroidWidget", "onDisabled");
		super.onDisabled(context);
	}

	/*
	 * Called in response to the ACTION_APPWIDGET_ENABLED broadcast when the a
	 * 
	 * 
	 * AppWidget for this provider is instantiated. Override this method to
	 * implement your own AppWidget functionality.
	 */
	public void onEnabled(Context context) {
		Log.v("HelloAndroidWidget", "onEnabled");
		super.onEnabled(context);
	}

	/**
	 * Implements onReceive(Context, Intent) to dispatch calls to the various
	 * other methods on AppWidgetProvider.
	 */
	public void onReceive(Context context, Intent intent) {
		Log.v("HelloAndroidWidget", "onReceive");
		super.onReceive(context, intent);
	}

	/**
	 * Called in response to the ACTION_APPWIDGET_UPDATE broadcast when this
	 * AppWidget provider is being asked to provide RemoteViews for a set of
	 * AppWidgets. Override this method to implement your own AppWidget
	 * functionality.
	 */
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.v("HelloAndroidWidget", "onUpdate");
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

}
