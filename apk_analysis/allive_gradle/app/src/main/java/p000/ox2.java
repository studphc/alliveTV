package p000;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class ox2 extends TypeAdapter {

    /* renamed from: a */
    public final HashMap f24948a = new HashMap();

    /* renamed from: b */
    public final HashMap f24949b = new HashMap();

    /* renamed from: c */
    public final HashMap f24950c = new HashMap();

    public ox2(Class cls) {
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new o11(cls, 1))) {
                Enum r4 = (Enum) field.get(null);
                String name = r4.name();
                String str = r4.toString();
                SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                if (serializedName != null) {
                    name = serializedName.value();
                    for (String str2 : serializedName.alternate()) {
                        this.f24948a.put(str2, r4);
                    }
                }
                this.f24948a.put(name, r4);
                this.f24949b.put(str, r4);
                this.f24950c.put(r4, name);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        Enum r0 = (Enum) this.f24948a.get(nextString);
        if (r0 == null) {
            return (Enum) this.f24949b.get(nextString);
        }
        return r0;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        String str;
        Enum r3 = (Enum) obj;
        if (r3 == null) {
            str = null;
        } else {
            str = (String) this.f24950c.get(r3);
        }
        jsonWriter.value(str);
    }
}
