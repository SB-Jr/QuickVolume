package my.sbjr.basicapp3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	
	
	class Media_Receiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			update();
		}
		
	}
	
	
	public SeekBar s1,s2,s3;
	AudioManager am;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		Media_Receiver mr = new Media_Receiver();
		
		IntentFilter ifilter = new IntentFilter();
		//ifilter.
		
		registerReceiver(mr,ifilter );
		
		
		s1 = (SeekBar) findViewById(R.id.seekBar1);
		s2 = (SeekBar) findViewById(R.id.seekBar2);
		s3 = (SeekBar) findViewById(R.id.seekBar3);
		
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		
		s1.setMax(am.getStreamMaxVolume(AudioManager.STREAM_RING));
		s2.setMax(am.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		s3.setMax(am.getStreamMaxVolume(AudioManager.STREAM_ALARM));
		
		s1.setProgress(am.getStreamVolume(AudioManager.STREAM_RING));
		s2.setProgress(am.getStreamVolume(AudioManager.STREAM_MUSIC));
		s3.setProgress(am.getStreamVolume(AudioManager.STREAM_ALARM));
		
		s1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				am.setStreamVolume(AudioManager.STREAM_RING, progress, 0);
				
			}
		});
		
		
		s2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
				
			}
		});
		
		s3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				am.setStreamVolume(AudioManager.STREAM_ALARM, progress, 0);
				
			}
		});
	}
	
	
	public void update(){
		s1.setProgress(am.getStreamVolume(AudioManager.STREAM_RING));
		s2.setProgress(am.getStreamVolume(AudioManager.STREAM_MUSIC));
		s3.setProgress(am.getStreamVolume(AudioManager.STREAM_ALARM));
	}
	
	
	
	public void ringer(View v){
		setVolumeControlStream(AudioManager.STREAM_RING);
	}
	
	
	
	public void music(View v){
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
	}
	
	public void alarm(View v){
		setVolumeControlStream(AudioManager.STREAM_ALARM);
	}
	
	
	@Override
	protected void onPause(){
		super.onPause();
		setVolumeControlStream(AudioManager.STREAM_RING);
	}
}
