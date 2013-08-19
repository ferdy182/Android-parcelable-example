package com.example.parcelable;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Estudiante implements Parcelable {
	int fechaNacimiento;
	String nombreCompleto;
	boolean esHijoUnico;
	float[] notas;
	List<Estudiante> amigos;

	/**
	 * Constructor por defecto
	 */
	public Estudiante() {
		notas = new float[3];
		amigos = new ArrayList<Estudiante>();
	}

	/**
	 * Constructor para crear el objeto a partir de un parcelable
	 * @param in
	 */
	public Estudiante(Parcel in) {
		notas = new float[3];
		amigos = new ArrayList<Estudiante>();
		readFromParcel(in);
	}

	/**
	 * Obligatorio
	 */
	@Override
	public int describeContents() {
		return 0;
	}

	/**
	 * Escribir a un parcel, OJO el orden es importante, es como escribir en un archivo binario
	 * @param dest Parcel donde se va a escribir
	 * @param flags ver documentacion de Parcelable.writeToParcel
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(fechaNacimiento);
		dest.writeString(nombreCompleto);
		dest.writeBooleanArray(new boolean[] { esHijoUnico });
		dest.writeFloatArray(notas);
		dest.writeTypedList(amigos);
	}

	/**
	 * Clase para recuperar los datos de un parcel, IMPORTANTE leerlos en el mismo orden que se escribieron!
	 * @param in Parcel con los datos a leer
	 */
	private void readFromParcel(Parcel in) {
		fechaNacimiento = in.readInt();
		nombreCompleto = in.readString();

		boolean[] temp = new boolean[1];
		in.readBooleanArray(temp);
		esHijoUnico = temp[0];

		in.readFloatArray(notas);
		in.readTypedList(amigos, CREATOR);
	}

	/**
	 * Necesario para usarlo en arrays
	 */
	public static final Parcelable.Creator<Estudiante> CREATOR = new Parcelable.Creator<Estudiante>() {
		public Estudiante createFromParcel(Parcel in) {
			return new Estudiante(in);
		}

		public Estudiante[] newArray(int size) {
			return new Estudiante[size];
		}
	};

	/**
	 * Solo para mostrarlo formateado en un string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre:").append(nombreCompleto).append("\n").append("Fecha de nacimiento:").append(fechaNacimiento).append("\n").append("Hijo único:");

		if (esHijoUnico)
			sb.append("Si");
		else
			sb.append("No");

		sb.append("\n");
		sb.append("Notas: ");
		for (float f : notas)
			sb.append(f).append(" ");

		sb.append("\n");
		sb.append("Amigos: ");
		sb.append("\n");
		for (Estudiante e : amigos) {
			sb.append(e.toString());
		}
		return sb.toString();
	};

}
