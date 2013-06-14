package com.example.pruebasherlock;

import android.content.Intent;
import android.location.GpsStatus.NmeaListener;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;	

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;

/*
 * --SPLIT ACTION MODES 
 * --DIALOG
 * --ACTION MODES
 * 
 * 
 * 
 * */

public class MainActivity extends SherlockFragmentActivity {
	
	Button botonAction;
	private GoogleMap mMap; 
	Intent intent;
	ActionMode mMode;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//setTheme(@style/Theme.Sherlock);
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		botonAction = (Button) findViewById(R.id.button1);
		
		
		
		GoogleMap gmap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapa)).getMap();
		gmap.setMyLocationEnabled(true);
		botonAction.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(mMode==null){
					
					
					mMode = startActionMode( new ImpActionMode());
				}
					
				else{
					//Toast.makeText(getApplicationContext(), "MATANDO!!", Toast.LENGTH_SHORT).show();
					mMode.finish();
					mMode=null;
				}
					
			}
		});
	}
	
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		   MenuInflater inflater = getSupportMenuInflater();
		   inflater.inflate(R.menu.main, menu);
		   return true;
		}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		
		case R.id.lista:
			//Toast.makeText(getApplicationContext(), "presionaste add ITEM", Toast.LENGTH_SHORT).show();
			//getSupportActionBar().hide();
			intent = new Intent(getApplicationContext(), ListActivity.class);
			startActivity(intent);
			break;
		case R.id.busqueda:
			//Toast.makeText(getApplicationContext(), "presionaste actualiza lista", Toast.LENGTH_SHORT).show();
			break;
		case R.id.filtro:
			Toast.makeText(getApplicationContext(), "FILTRAMESTA!!", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private final class ImpActionMode implements ActionMode.Callback{

		@Override 
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			
			boolean isLight = R.style.Theme_Sherlock != R.style.Theme_Sherlock_Light;
			
			menu.add("Save")
            .setIcon(isLight ? R.drawable.ic_compose_inverse : R.drawable.ic_compose)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Search")
            .setIcon(isLight ? R.drawable.ic_search_inverse : R.drawable.ic_search)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Refresh")
            .setIcon(isLight ? R.drawable.ic_refresh_inverse : R.drawable.ic_refresh)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Save")
            .setIcon(isLight ? R.drawable.ic_compose_inverse : R.drawable.ic_compose)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Search")
            .setIcon(isLight ? R.drawable.ic_search_inverse : R.drawable.ic_search)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Refresh")
            .setIcon(isLight ? R.drawable.ic_refresh_inverse : R.drawable.ic_refresh)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
			
        //Toast.makeText(getApplicationContext(), "CREADISIMO?", Toast.LENGTH_SHORT).show();
			
			return true;
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	
	
	


}
