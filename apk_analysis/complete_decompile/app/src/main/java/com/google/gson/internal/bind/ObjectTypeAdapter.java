package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000.dt1;
import p000.it1;

/* loaded from: classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: c */
    public static final dt1 f15761c = new dt1(1, ToNumberPolicy.DOUBLE);

    /* renamed from: a */
    public final Gson f15762a;

    /* renamed from: b */
    public final ToNumberStrategy f15763b;

    public ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.f15762a = gson;
        this.f15763b = toNumberStrategy;
    }

    /* renamed from: b */
    public static Serializable m4436b(JsonReader jsonReader, JsonToken jsonToken) {
        int i = it1.f20256a[jsonToken.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            jsonReader.beginObject();
            return new LinkedTreeMap();
        }
        jsonReader.beginArray();
        return new ArrayList();
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == ToNumberPolicy.DOUBLE) {
            return f15761c;
        }
        return new dt1(1, toNumberStrategy);
    }

    /* renamed from: a */
    public final Serializable m4437a(JsonReader jsonReader, JsonToken jsonToken) {
        int i = it1.f20256a[jsonToken.ordinal()];
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    if (i == 6) {
                        jsonReader.nextNull();
                        return null;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            return this.f15763b.readNumber(jsonReader);
        }
        return jsonReader.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        String str;
        boolean z;
        JsonToken peek = jsonReader.peek();
        Object m4436b = m4436b(jsonReader, peek);
        if (m4436b == null) {
            return m4437a(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (m4436b instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                JsonToken peek2 = jsonReader.peek();
                Serializable m4436b2 = m4436b(jsonReader, peek2);
                if (m4436b2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (m4436b2 == null) {
                    m4436b2 = m4437a(jsonReader, peek2);
                }
                if (m4436b instanceof List) {
                    ((List) m4436b).add(m4436b2);
                } else {
                    ((Map) m4436b).put(str, m4436b2);
                }
                if (z) {
                    arrayDeque.addLast(m4436b);
                    m4436b = m4436b2;
                }
            } else {
                if (m4436b instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return m4436b;
                }
                m4436b = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter adapter = this.f15762a.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        } else {
            adapter.write(jsonWriter, obj);
        }
    }
}
