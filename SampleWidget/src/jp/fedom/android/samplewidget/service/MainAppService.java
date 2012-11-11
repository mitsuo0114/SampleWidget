package jp.fedom.android.samplewidget.service;

import jp.fedom.android.samplewidget.R;
import jp.fedom.android.samplewidget.widget.MainAppWidget;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainAppService extends Service {
	private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
	private final String BUTTON_CLICK_ACTION2 = "BUTTON_CLICK_ACTION2";

	/**
	 * Return the communication channel to the service.
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		Log.v("MainAppService", "onBind");
		return null;
	}

	/**
	 * Called by the system when the device configuration changes while your
	 * component is running.
	 */
	public void onConfigurationChanged(Configuration newConfig) {
		Log.v("MainAppService", "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}

	/** Called by the system when the service is first created. */
	public void onCreate() {
		Log.v("MainAppService", "onCreate");
		super.onCreate();

	}

	/**
	 * Called by the system to notify a Service that it is no longer used and is
	 * being removed.
	 */
	public void onDestroy() {
		Log.v("MainAppService", "onDestroy");
		super.onDestroy();

	}

	/**
	 * This is called when the overall system is running low on memory, and
	 * would like actively running process to try to tighten their belt.
	 */
	public void onLowMemory() {
		Log.v("MainAppService", "onLowMemory");
		super.onLowMemory();

	}

	/**
	 * Called when new clients have connected to the service, after it had
	 * previously been notified that all had disconnected in its
	 * onUnbind(Intent).
	 */
	public void onRebind(Intent intent) {
		Log.v("MainAppService", "onRebind");
		super.onRebind(intent);

	}

	/**
	 * This method was deprecated in API level 5. Implement
	 * onStartCommand(Intent, int, int) instead.
	 */
	public void onStart(Intent intent, int startId) {
		Log.v("MainAppService", "onStart");
		super.onStart(intent, startId);
		Intent buttonIntent = new Intent();
		buttonIntent.setAction(BUTTON_CLICK_ACTION);
		PendingIntent pendingIntent = PendingIntent.getService(this, 0, buttonIntent, 0);
		
		Intent buttonIntent2 = new Intent();
		buttonIntent2.setAction(BUTTON_CLICK_ACTION2);
		PendingIntent pendingIntent2 = PendingIntent.getService(this, 0, buttonIntent2, 0);

		
		RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.widget);		
		remoteViews.setOnClickPendingIntent(R.id.hello, pendingIntent);
		remoteViews.setOnClickPendingIntent(R.id.hello2, pendingIntent2);
		
		if(BUTTON_CLICK_ACTION.equals(intent.getAction())){
			(Toast.makeText(getApplicationContext(),"hello!", Toast.LENGTH_SHORT)).show();
		}
		if(BUTTON_CLICK_ACTION2.equals(intent.getAction())){
			(Toast.makeText(getApplicationContext(),"hello2!", Toast.LENGTH_SHORT)).show();
		}

		// update widget view
		ComponentName thisWidget = new ComponentName(this, MainAppWidget.class);
		AppWidgetManager manager = AppWidgetManager.getInstance(this);
		manager.updateAppWidget(thisWidget, remoteViews);
	}

	/**
	 * Called by the system every time a client explicitly starts the service by
	 * calling startService(Intent), providing the arguments it supplied and a
	 * unique integer token representing the start request.
	 */
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * This is called if the service is currently running and the user has
	 * removed a task that comes from the service's application. api from 14
	 */
	// public void onTaskRemoved(Intent rootIntent) {
	// super.onTaskRemoved(rootIntent);
	// }
	/**
	 * Called when the operating system has determined that it is a good time
	 * for a process to trim unneeded memory from its process. api from 14
	 */
	// public void onTrimMemory(int level) {
	//
	// }

	/**
	 * Called when all clients have disconnected from a particular interface
	 * published by the service.
	 */
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}
}
