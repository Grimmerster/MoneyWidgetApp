package org.eltex.SLAMoneyWidget;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

public class Parser {

	final String LOG_TAG = "myLogs";
	ArrayList<String> returnString;
	XmlPullParser xpp;
	boolean flag = false;
	boolean flag2 = false;
	boolean flag3 = false;

	public Parser(XmlPullParser file) {
		xpp = file;
	}

	public ArrayList<String> getValues() throws XmlPullParserException,
			IOException {

		while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
			switch (xpp.getEventType()) {
			// начало документа
			case XmlPullParser.START_DOCUMENT:
				break;
			// начало тэга
			case XmlPullParser.START_TAG:
				break;
			// конец тэга
			case XmlPullParser.END_TAG:
				break;
			// содержимое тэга
			case XmlPullParser.TEXT:
				if (flag3) {
					returnString.add(xpp.getText() + "");
					flag3 = false;
				}
				if (flag2) {
					flag3 = true;
					flag2 = false;
				}
				try {
					int nameCode = Integer.parseInt(xpp.getText());

					if (flag) {
						flag2 = true;
						flag = false;

					} else {
						switch (nameCode) {
						case 826: {
							Log.d(LOG_TAG,
									"Фунт стерлингов Соединённого королевства");
							flag = true;
							break;
						}
						case 840: {
							Log.d(LOG_TAG, "Доллар США");
							flag = true;
							break;
						}
						case 978: {
							Log.d(LOG_TAG, "Евро");
							flag = true;
							break;
						}
						case 156: {
							Log.d(LOG_TAG, "Китайский юань");
							flag = true;
							break;
						}
						case 392: {
							Log.d(LOG_TAG, "Японский иен");
							flag = true;
							break;
						}
						}
					}
				} catch (Exception e) {
				}
				break;

			default:
				break;
			}
			// следующий элемент
			xpp.next();
		}

		return returnString;
	}

}