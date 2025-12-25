package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import p000.AbstractC1726qj;
import p000.C1718qb;

/* loaded from: classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new C1718qb(1);

    /* renamed from: a */
    public final ArrayList f15741a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f15741a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this.f15741a) {
            try {
                Iterator it = this.f15741a.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(nextString);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return ISO8601Utils.parse(nextString, new ParsePosition(0));
                } catch (ParseException e) {
                    StringBuilder m7065u = AbstractC1726qj.m7065u("Failed parsing '", nextString, "' as Date; at path ");
                    m7065u.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m7065u.toString(), e);
                }
            } finally {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f15741a.get(0);
        synchronized (this.f15741a) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }
}
