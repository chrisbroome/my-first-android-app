package com.example.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
  public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_activity_actions, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // handle presses on the action bar items
    switch(item.getItemId()) {
      case R.id.action_search:
        openSearch();
        return true;
      case R.id.action_settings:
        openSettings();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  public void openSearch() {
    new AlertDialog.Builder(this)
      .setTitle("Search")
      .setMessage("Search not implemented")
      .setNeutralButton("OK", new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int which) {
          dialog.dismiss();
        }
      })
      .show();
  }

  public void openSettings() {
    new AlertDialog.Builder(this)
      .setTitle("Settings")
      .setMessage("Settings not implemented")
      .setNeutralButton("OK", new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int which) {
          dialog.dismiss();
        }
      })
      .show();
  }

  /** Called when the user clicks the Send button. */
  public void sendMessage(View view) {
    Intent intent = new Intent(this, DisplayMessageActivity.class);
    EditText editText = (EditText)findViewById(R.id.edit_message);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
  }
}
