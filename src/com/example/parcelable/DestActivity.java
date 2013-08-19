package com.example.parcelable;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DestActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
		TextView tv = (TextView) findViewById(R.id.estudiante);
		//ocultamos el boton
		findViewById(R.id.siguiente).setVisibility(View.GONE);
		setTitle("Actividad 2");

		//obtenemos el estudiante de la actividad anterior como un parcelable
		Estudiante estudiante = getIntent().getParcelableExtra("estudiante");

		//lo escribimos en el textview
		tv.setText(estudiante.toString());

		//lo imprimimos también por el logcat
		Log.i("estudiante", estudiante.nombreCompleto);
		Log.i("estudiante", String.valueOf(estudiante.esHijoUnico));
		Log.i("estudiante", String.valueOf(estudiante.fechaNacimiento));
		Log.i("estudiante", Arrays.toString(estudiante.notas));
		Estudiante amigo = estudiante.amigos.get(0);
		Log.i("amigo", amigo.nombreCompleto);
		Log.i("amigo", String.valueOf(amigo.esHijoUnico));
		Log.i("amigo", String.valueOf(amigo.fechaNacimiento));
		Log.i("amigo", Arrays.toString(amigo.notas));

	}
}
