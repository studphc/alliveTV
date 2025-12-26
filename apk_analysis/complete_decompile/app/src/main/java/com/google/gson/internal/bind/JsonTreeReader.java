package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import p000.a71;
import p000.b71;

/* loaded from: classes2.dex */
public final class JsonTreeReader extends JsonReader {

    /* renamed from: e */
    public static final a71 f15746e = new a71();

    /* renamed from: f */
    public static final Object f15747f = new Object();

    /* renamed from: a */
    public Object[] f15748a;

    /* renamed from: b */
    public int f15749b;

    /* renamed from: c */
    public String[] f15750c;

    /* renamed from: d */
    public int[] f15751d;

    public JsonTreeReader(JsonElement jsonElement) {
        super(f15746e);
        this.f15748a = new Object[32];
        this.f15749b = 0;
        this.f15750c = new String[32];
        this.f15751d = new int[32];
        m4433f(jsonElement);
    }

    /* renamed from: a */
    public final void m4428a(JsonToken jsonToken) {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + m4429b());
    }

    /* renamed from: b */
    public final String m4429b() {
        return " at path " + getPath();
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        m4428a(JsonToken.BEGIN_ARRAY);
        m4433f(((JsonArray) m4431d()).iterator());
        this.f15751d[this.f15749b - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        m4428a(JsonToken.BEGIN_OBJECT);
        m4433f(((JsonObject) m4431d()).entrySet().iterator());
    }

    /* renamed from: c */
    public final String m4430c(boolean z) {
        String str;
        m4428a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m4431d()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f15750c;
        int i = this.f15749b - 1;
        if (z) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i] = str;
        m4433f(entry.getValue());
        return str2;
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15748a = new Object[]{f15747f};
        this.f15749b = 1;
    }

    /* renamed from: d */
    public final Object m4431d() {
        return this.f15748a[this.f15749b - 1];
    }

    /* renamed from: e */
    public final Object m4432e() {
        Object[] objArr = this.f15748a;
        int i = this.f15749b - 1;
        this.f15749b = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        m4428a(JsonToken.END_ARRAY);
        m4432e();
        m4432e();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        m4428a(JsonToken.END_OBJECT);
        this.f15750c[this.f15749b - 1] = null;
        m4432e();
        m4432e();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    /* renamed from: f */
    public final void m4433f(Object obj) {
        int i = this.f15749b;
        Object[] objArr = this.f15748a;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.f15748a = Arrays.copyOf(objArr, i2);
            this.f15751d = Arrays.copyOf(this.f15751d, i2);
            this.f15750c = (String[]) Arrays.copyOf(this.f15750c, i2);
        }
        Object[] objArr2 = this.f15748a;
        int i3 = this.f15749b;
        this.f15749b = i3 + 1;
        objArr2[i3] = obj;
    }

    public final String getPath(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.f15749b;
            if (i < i2) {
                Object[] objArr = this.f15748a;
                Object obj = objArr[i];
                if (obj instanceof JsonArray) {
                    i++;
                    if (i < i2 && (objArr[i] instanceof Iterator)) {
                        int i3 = this.f15751d[i];
                        if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                            i3--;
                        }
                        sb.append('[');
                        sb.append(i3);
                        sb.append(']');
                    }
                } else if ((obj instanceof JsonObject) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                    sb.append('.');
                    String str = this.f15750c[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                i++;
            } else {
                return sb.toString();
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken peek = peek();
        if (peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY && peek != JsonToken.END_DOCUMENT) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        m4428a(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) m4432e()).getAsBoolean();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + m4429b());
        }
        double asDouble = ((JsonPrimitive) m4431d()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + asDouble);
        }
        m4432e();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + m4429b());
        }
        int asInt = ((JsonPrimitive) m4431d()).getAsInt();
        m4432e();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + m4429b());
        }
        long asLong = ((JsonPrimitive) m4431d()).getAsLong();
        m4432e();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        return m4430c(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        m4428a(JsonToken.NULL);
        m4432e();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + m4429b());
        }
        String asString = ((JsonPrimitive) m4432e()).getAsString();
        int i = this.f15749b;
        if (i > 0) {
            int[] iArr = this.f15751d;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.f15749b == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object m4431d = m4431d();
        if (m4431d instanceof Iterator) {
            boolean z = this.f15748a[this.f15749b - 2] instanceof JsonObject;
            Iterator it = (Iterator) m4431d;
            if (it.hasNext()) {
                if (z) {
                    return JsonToken.NAME;
                }
                m4433f(it.next());
                return peek();
            }
            if (z) {
                return JsonToken.END_OBJECT;
            }
            return JsonToken.END_ARRAY;
        }
        if (m4431d instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (m4431d instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (m4431d instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) m4431d;
            if (jsonPrimitive.isString()) {
                return JsonToken.STRING;
            }
            if (jsonPrimitive.isBoolean()) {
                return JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.isNumber()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (m4431d instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (m4431d == f15747f) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + m4431d.getClass().getName() + " is not supported");
    }

    public void promoteNameToValue() {
        m4428a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m4431d()).next();
        m4433f(entry.getValue());
        m4433f(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        int i = b71.f7912a[peek().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        m4432e();
                        int i2 = this.f15749b;
                        if (i2 > 0) {
                            int[] iArr = this.f15751d;
                            int i3 = i2 - 1;
                            iArr[i3] = iArr[i3] + 1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                endObject();
                return;
            }
            endArray();
            return;
        }
        m4430c(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return "JsonTreeReader" + m4429b();
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }
}
