package p000;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes2.dex */
public final class gm2 extends TypeAdapter {

    /* renamed from: c */
    public static final C1718qb f17763c = new C1718qb(4);

    /* renamed from: a */
    public final /* synthetic */ int f17764a;

    /* renamed from: b */
    public final TypeAdapter f17765b;

    public /* synthetic */ gm2(TypeAdapter typeAdapter, int i) {
        this.f17764a = i;
        this.f17765b = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        switch (this.f17764a) {
            case 0:
                Date date = (Date) this.f17765b.read(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            case 1:
                return new AtomicLong(((Number) this.f17765b.read(jsonReader)).longValue());
            case 2:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) this.f17765b.read(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            default:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return this.f17765b.read(jsonReader);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        switch (this.f17764a) {
            case 0:
                this.f17765b.write(jsonWriter, (Timestamp) obj);
                return;
            case 1:
                this.f17765b.write(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
                return;
            case 2:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    this.f17765b.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.endArray();
                return;
            default:
                if (obj == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    this.f17765b.write(jsonWriter, obj);
                    return;
                }
        }
    }

    public gm2(TypeAdapter typeAdapter) {
        this.f17764a = 0;
        this.f17765b = typeAdapter;
    }
}
