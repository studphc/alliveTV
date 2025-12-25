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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import p000.AbstractC1726qj;

/* loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: a */
    public final DateType f15742a;

    /* renamed from: b */
    public final ArrayList f15743b;

    public DefaultDateTypeAdapter(DateType dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.f15743b = arrayList;
        Objects.requireNonNull(dateType);
        this.f15742a = dateType;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f15743b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    /* loaded from: classes2.dex */
    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new DateType<>(Date.class);

        /* renamed from: a */
        public final Class f15744a;

        public DateType(Class<T> cls) {
            this.f15744a = cls;
        }

        public final TypeAdapterFactory createAdapterFactory(String str) {
            return TypeAdapters.newFactory(this.f15744a, new DefaultDateTypeAdapter(this, str));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return TypeAdapters.newFactory(this.f15744a, new DefaultDateTypeAdapter(this, 2, 2));
        }

        public abstract T deserialize(Date date);

        public final TypeAdapterFactory createAdapterFactory(int i) {
            return TypeAdapters.newFactory(this.f15744a, new DefaultDateTypeAdapter(this, i));
        }

        public final TypeAdapterFactory createAdapterFactory(int i, int i2) {
            return TypeAdapters.newFactory(this.f15744a, new DefaultDateTypeAdapter(this, i, i2));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) {
        Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this.f15743b) {
            try {
                Iterator it = this.f15743b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        try {
                            parse = ((DateFormat) it.next()).parse(nextString);
                        } catch (ParseException unused) {
                        }
                    } else {
                        try {
                            parse = ISO8601Utils.parse(nextString, new ParsePosition(0));
                            break;
                        } catch (ParseException e) {
                            StringBuilder m7065u = AbstractC1726qj.m7065u("Failed parsing '", nextString, "' as Date; at path ");
                            m7065u.append(jsonReader.getPreviousPath());
                            throw new JsonSyntaxException(m7065u.toString(), e);
                        }
                    }
                }
            } finally {
            }
        }
        return (T) this.f15742a.deserialize(parse);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f15743b.get(0);
        synchronized (this.f15743b) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    public DefaultDateTypeAdapter(DateType dateType, int i) {
        ArrayList arrayList = new ArrayList();
        this.f15743b = arrayList;
        Objects.requireNonNull(dateType);
        this.f15742a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    public DefaultDateTypeAdapter(DateType dateType, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.f15743b = arrayList;
        Objects.requireNonNull(dateType);
        this.f15742a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }
}
