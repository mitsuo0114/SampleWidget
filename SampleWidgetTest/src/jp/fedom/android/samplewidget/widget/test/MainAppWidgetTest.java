package jp.fedom.android.samplewidget.widget.test;

import static org.mockito.Mockito.*;


import android.app.PendingIntent;
import android.content.Intent;
import android.test.AndroidTestCase;
import android.widget.RemoteViews;
import jp.fedom.android.samplewidget.widget.MainAppWidget;


public class MainAppWidgetTest extends AndroidTestCase{
	
	public void test_setOnClickIDIntentMapping() throws Exception{
		RemoteViews remote = mock(RemoteViews.class);
		int[] ids = new int[]{1,2};
		PendingIntent[] intents = new PendingIntent[] {
				 PendingIntent.getService(getContext(),0, new Intent(), 0)
				,PendingIntent.getService(getContext(),0, new Intent(), 0)
				};
		
		MainAppWidget.setOnClickIDIntentMapping(remote, ids, intents);
		
		verify(remote,times(2)).setOnClickPendingIntent(anyInt(), (PendingIntent)any());
		verify(remote,times(1)).setOnClickPendingIntent(ids[0], intents[0]);
		verify(remote,times(1)).setOnClickPendingIntent(ids[1], intents[1]);
	}
	
	public void test_setOnClickIDIntentMapping_diff() throws Exception{
		RemoteViews remote = mock(RemoteViews.class);
		int[] ids = new int[]{1};
		PendingIntent[] intents = new PendingIntent[] {
				 PendingIntent.getService(getContext(),0, new Intent(), 0)
				,PendingIntent.getService(getContext(),0, new Intent(), 0)
				};
		
		try{
			MainAppWidget.setOnClickIDIntentMapping(remote, ids, intents);
			fail();
		}catch(IllegalArgumentException e){
			// OK
		}catch(Exception e1){
			fail();
		}
	}


}
