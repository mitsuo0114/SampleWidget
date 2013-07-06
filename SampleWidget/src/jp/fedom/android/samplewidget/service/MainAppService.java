package jp.fedom.android.samplewidget.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MainAppService extends Service {
	public static final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
	public static final String BUTTON_CLICK_ACTION2 = "BUTTON_CLICK_ACTION2";
	private static final String TAG = "MainAppService";

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
		super.onConfigurationChanged(newConfig);
		Log.v("MainAppService", "onConfigurationChanged");
	}

	/** Called by the system when the service is first created. */
	public void onCreate() {
		super.onCreate();
		Log.v("MainAppService", "onCreate");

	}

	/**
	 * Called by the system to notify a Service that it is no longer used and is
	 * being removed.
	 */
	public void onDestroy() {
		super.onDestroy();
		Log.v("MainAppService", "onDestroy");

	}

	/**
	 * This is called when the overall system is running low on memory, and
	 * would like actively running process to try to tighten their belt.
	 */
	public void onLowMemory() {
		super.onLowMemory();
		Log.v("MainAppService", "onLowMemory");

	}

	/**
	 * Called when new clients have connected to the service, after it had
	 * previously been notified that all had disconnected in its
	 * onUnbind(Intent).
	 */
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		Log.v("MainAppService", "onRebind");

	}

//	/**
//	 * This method was deprecated in API level 5. Implement
//	 * onStartCommand(Intent, int, int) instead.
//	 */
//	public void onStart(Intent intent, int startId) {
//		Log.v("MainAppService", "onStart");
//		super.onStart(intent, startId);
//	}

	protected ServiceActionEvents getServiceActionEvents(){
		return new ServiceActionEvents();
	}

	/**
	 * Called by the system every time a client explicitly starts the service by
	 * calling startService(Intent), providing the arguments it supplied and a
	 * unique integer token representing the start request.
	 */
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v(TAG,"called onStartService");

		ServiceActionEvents event = getServiceActionEvents();

		if (intent != null) {
			if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {
				event.showToast(this, "hello world!!", Toast.LENGTH_SHORT);
			}else if (BUTTON_CLICK_ACTION2.equals(intent.getAction())) {
				event.showToast(this, "Yes I'm fine!", Toast.LENGTH_SHORT);
			}
		}
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
