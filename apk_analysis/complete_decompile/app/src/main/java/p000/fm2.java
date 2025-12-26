package p000;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public final class fm2 extends TypeAdapter {

    /* renamed from: c */
    public static final C1718qb f17332c = new C1718qb(2);

    /* renamed from: d */
    public static final C1718qb f17333d = new C1718qb(3);

    /* renamed from: a */
    public final /* synthetic */ int f17334a;

    /* renamed from: b */
    public final SimpleDateFormat f17335b;

    public fm2(int i) {
        this.f17334a = i;
        switch (i) {
            case 1:
                this.f17335b = new SimpleDateFormat("hh:mm:ss a");
                return;
            default:
                this.f17335b = new SimpleDateFormat("MMM d, yyyy");
                return;
        }
    }

    /* renamed from: a */
    private final Object m4816a(JsonReader jsonReader) {
        Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                parse = this.f17335b.parse(nextString);
            }
            return new java.sql.Date(parse.getTime());
        } catch (ParseException e) {
            StringBuilder m7065u = AbstractC1726qj.m7065u("Failed parsing '", nextString, "' as SQL Date; at path ");
            m7065u.append(jsonReader.getPreviousPath());
            throw new JsonSyntaxException(m7065u.toString(), e);
        }
    }

    /* renamed from: b */
    private final void m4817b(JsonWriter jsonWriter, Object obj) {
        String format;
        java.sql.Date date = (java.sql.Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f17335b.format((Date) date);
        }
        jsonWriter.value(format);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        Time time;
        switch (this.f17334a) {
            case 0:
                return m4816a(jsonReader);
            default:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String nextString = jsonReader.nextString();
                try {
                    synchronized (this) {
                        time = new Time(this.f17335b.parse(nextString).getTime());
                    }
                    return time;
                } catch (ParseException e) {
                    StringBuilder m7065u = AbstractC1726qj.m7065u("Failed parsing '", nextString, "' as SQL Time; at path ");
                    m7065u.append(jsonReader.getPreviousPath());
                    throw new JsonSyntaxException(m7065u.toString(), e);
                }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        String format;
        switch (this.f17334a) {
            case 0:
                m4817b(jsonWriter, obj);
                return;
            default:
                Time time = (Time) obj;
                if (time == null) {
                    jsonWriter.nullValue();
                    return;
                }
                synchronized (this) {
                    format = this.f17335b.format((Date) time);
                }
                jsonWriter.value(format);
                return;
        }
    }
}
