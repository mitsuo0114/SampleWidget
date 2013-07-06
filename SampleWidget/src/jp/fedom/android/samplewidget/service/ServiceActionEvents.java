package jp.fedom.android.samplewidget.service;

import android.content.Context;
import android.widget.Toast;

public class ServiceActionEvents {

	public void showToast(Context context, String message, int duration){
		(Toast.makeText(context, message,duration)).show();
	}
	
}
