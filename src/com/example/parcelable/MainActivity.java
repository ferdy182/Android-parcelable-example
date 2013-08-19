package com.example.parcelable;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	Estudiante estudiante;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
		TextView tv = (TextView) findViewById(R.id.estudiante);
		setTitle("Actividad 1");

		//creamos primero el estudiante amigo
		Estudiante otroEstudiante = new Estudiante();
		otroEstudiante.nombreCompleto = "Perico Palotes";
		otroEstudiante.esHijoUnico = false;
		otroEstudiante.fechaNacimiento = 1990;
		otroEstudiante.notas = new float[] { 7.8f, 4.9f, 10.0f };
		otroEstudiante.amigos = new ArrayList<Estudiante>();

		//ahora creamos el estudiante
		estudiante = new Estudiante();
		estudiante.nombreCompleto = "Dolores Fuertes";
		estudiante.esHijoUnico = true;
		estudiante.fechaNacimiento = 1983;
		estudiante.notas = new float[] { 9.5f, 8.6f, 4.6f };
		estudiante.amigos = new ArrayList<Estudiante>();

		//añadimos el amigo a la lista de amigos
		estudiante.amigos.add(otroEstudiante);

		//lo escribimos en el textview
		tv.setText(estudiante.toString());

	}

	public void onClickSiguiente(View v) {
		Intent intent = new Intent(this, DestActivity.class);
		//pasamos el estudiante como un parcelable como extra del intent
		intent.putExtra("estudiante", estudiante);
		startActivity(intent);
	}
}
