package p000;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.C1060d;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class cg1 extends TypeAdapter {

    /* renamed from: a */
    public final C1060d f8357a;

    /* renamed from: b */
    public final C1060d f8358b;

    /* renamed from: c */
    public final ObjectConstructor f8359c;

    /* renamed from: d */
    public final /* synthetic */ MapTypeAdapterFactory f8360d;

    public cg1(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, ObjectConstructor objectConstructor) {
        this.f8360d = mapTypeAdapterFactory;
        this.f8357a = new C1060d(gson, typeAdapter, type);
        this.f8358b = new C1060d(gson, typeAdapter2, type2);
        this.f8359c = objectConstructor;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Map map = (Map) this.f8359c.construct();
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        C1060d c1060d = this.f8358b;
        C1060d c1060d2 = this.f8357a;
        if (peek == jsonToken) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                Object read = c1060d2.f15784b.read(jsonReader);
                if (map.put(read, c1060d.f15784b.read(jsonReader)) == null) {
                    jsonReader.endArray();
                } else {
                    throw new JsonSyntaxException("duplicate key: " + read);
                }
            }
            jsonReader.endArray();
        } else {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                Object read2 = c1060d2.f15784b.read(jsonReader);
                if (map.put(read2, c1060d.f15784b.read(jsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read2);
                }
            }
            jsonReader.endObject();
        }
        return map;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        String str;
        boolean z;
        Map map = (Map) obj;
        if (map == null) {
            jsonWriter.nullValue();
            return;
        }
        boolean z2 = this.f8360d.f15758b;
        C1060d c1060d = this.f8358b;
        if (!z2) {
            jsonWriter.beginObject();
            for (Map.Entry entry : map.entrySet()) {
                jsonWriter.name(String.valueOf(entry.getKey()));
                c1060d.write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
            return;
        }
        ArrayList arrayList = new ArrayList(map.size());
        ArrayList arrayList2 = new ArrayList(map.size());
        int i = 0;
        boolean z3 = false;
        for (Map.Entry entry2 : map.entrySet()) {
            JsonElement jsonTree = this.f8357a.toJsonTree(entry2.getKey());
            arrayList.add(jsonTree);
            arrayList2.add(entry2.getValue());
            if (!jsonTree.isJsonArray() && !jsonTree.isJsonObject()) {
                z = false;
            } else {
                z = true;
            }
            z3 |= z;
        }
        if (z3) {
            jsonWriter.beginArray();
            int size = arrayList.size();
            while (i < size) {
                jsonWriter.beginArray();
                Streams.write((JsonElement) arrayList.get(i), jsonWriter);
                c1060d.write(jsonWriter, arrayList2.get(i));
                jsonWriter.endArray();
                i++;
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginObject();
        int size2 = arrayList.size();
        while (i < size2) {
            JsonElement jsonElement = (JsonElement) arrayList.get(i);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    str = String.valueOf(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    str = Boolean.toString(asJsonPrimitive.getAsBoolean());
                } else if (asJsonPrimitive.isString()) {
                    str = asJsonPrimitive.getAsString();
                } else {
                    throw new AssertionError();
                }
            } else if (jsonElement.isJsonNull()) {
                str = "null";
            } else {
                throw new AssertionError();
            }
            jsonWriter.name(str);
            c1060d.write(jsonWriter, arrayList2.get(i));
            i++;
        }
        jsonWriter.endObject();
    }
}
