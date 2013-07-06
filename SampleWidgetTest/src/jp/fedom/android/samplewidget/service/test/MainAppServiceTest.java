package jp.fedom.android.samplewidget.service.test;

import static org.mockito.Mockito.*;


import android.content.Context;
import android.content.Intent;
import android.test.AndroidTestCase;
import android.widget.Toast;
import jp.fedom.android.samplewidget.service.MainAppService;
import jp.fedom.android.samplewidget.service.ServiceActionEvents;

public class MainAppServiceTest extends AndroidTestCase{
	
	public void test_service_BUTTON_CLICK_ACTION() throws Exception{
		final ServiceActionEvents event = mock(ServiceActionEvents.class);
		MainAppService target = new MainAppService(){
			@Override
			protected ServiceActionEvents getServiceActionEvents(){
				return event;
			}
		};
		Intent intent = new Intent();
		intent.setAction(MainAppService.BUTTON_CLICK_ACTION);
		
		target.onStartCommand(intent, 0, 0);
		
		verify(event,times(1)).showToast((Context) any(),anyString(), anyInt());
		verify(event,times(1)).showToast((Context) any(), eq("hello world!!"), eq(Toast.LENGTH_SHORT));
	}
	
	public void test_service_BUTTON_CLICK_ACTION2() throws Exception{
		final ServiceActionEvents event = mock(ServiceActionEvents.class);
		MainAppService target = new MainAppService(){
			@Override
			protected ServiceActionEvents getServiceActionEvents(){
				return event;
			}
		};
		Intent intent = new Intent();
		intent.setAction(MainAppService.BUTTON_CLICK_ACTION2);
		
		target.onStartCommand(intent, 0, 0);
		
		verify(event,times(1)).showToast((Context) any(),anyString(), anyInt());
		verify(event,times(1)).showToast((Context) any(), eq("Yes I'm fine!"), eq(Toast.LENGTH_SHORT));
	}

	

}
