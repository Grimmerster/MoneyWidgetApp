package org.eltex.SLAMoneyWidget;

import java.io.File;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.text.TextUtils;

public class Parser {

	String tmp = "";
	
	public Parser(File file) {

		try {
			XmlPullParser xpp = (XmlPullParser) file;

			while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
				switch (xpp.getEventType()) {
				// начало документа
				case XmlPullParser.START_DOCUMENT:
					break;
				// начало тэга
				case XmlPullParser.START_TAG:
					tmp = "";
					for (int i = 0; i < xpp.getAttributeCount(); i++) {
						tmp = tmp + xpp.getAttributeName(i) + " = "
								+ xpp.getAttributeValue(i) + ", ";
					}
					if (!TextUtils.isEmpty(tmp))
					break;
				// конец тэга
				case XmlPullParser.END_TAG:
					break;
				// содержимое тэга
				case XmlPullParser.TEXT:
					break;

				default:
					break;
				}
				// следующий элемент
				xpp.next();
			}
		} catch (Exception e) {

		}

	}
	
	public ArrayList<String> h2m14x6() {
		
		return null;
	}

}