package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import p000.AbstractC1726qj;
import p000.c71;

/* loaded from: classes2.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: d */
    public static final c71 f15752d = new c71();

    /* renamed from: e */
    public static final JsonPrimitive f15753e = new JsonPrimitive("closed");

    /* renamed from: a */
    public final ArrayList f15754a;

    /* renamed from: b */
    public String f15755b;

    /* renamed from: c */
    public JsonElement f15756c;

    public JsonTreeWriter() {
        super(f15752d);
        this.f15754a = new ArrayList();
        this.f15756c = JsonNull.INSTANCE;
    }

    /* renamed from: a */
    public final JsonElement m4434a() {
        return (JsonElement) AbstractC1726qj.m7053i(this.f15754a, 1);
    }

    /* renamed from: b */
    public final void m4435b(JsonElement jsonElement) {
        if (this.f15755b != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) m4434a()).add(this.f15755b, jsonElement);
            }
            this.f15755b = null;
            return;
        }
        if (this.f15754a.isEmpty()) {
            this.f15756c = jsonElement;
            return;
        }
        JsonElement m4434a = m4434a();
        if (m4434a instanceof JsonArray) {
            ((JsonArray) m4434a).add(jsonElement);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() {
        JsonArray jsonArray = new JsonArray();
        m4435b(jsonArray);
        this.f15754a.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() {
        JsonObject jsonObject = new JsonObject();
        m4435b(jsonObject);
        this.f15754a.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ArrayList arrayList = this.f15754a;
        if (arrayList.isEmpty()) {
            arrayList.add(f15753e);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() {
        ArrayList arrayList = this.f15754a;
        if (!arrayList.isEmpty() && this.f15755b == null) {
            if (m4434a() instanceof JsonArray) {
                arrayList.remove(arrayList.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() {
        ArrayList arrayList = this.f15754a;
        if (!arrayList.isEmpty() && this.f15755b == null) {
            if (m4434a() instanceof JsonObject) {
                arrayList.remove(arrayList.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() {
    }

    public JsonElement get() {
        ArrayList arrayList = this.f15754a;
        if (arrayList.isEmpty()) {
            return this.f15756c;
        }
        throw new IllegalStateException("Expected one JSON element but was " + arrayList);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter jsonValue(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!this.f15754a.isEmpty() && this.f15755b == null) {
            if (m4434a() instanceof JsonObject) {
                this.f15755b = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() {
        m4435b(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        m4435b(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z) {
        m4435b(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        m4435b(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(float f) {
        if (!isLenient() && (Float.isNaN(f) || Float.isInfinite(f))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f);
        }
        m4435b(new JsonPrimitive(Float.valueOf(f)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d) {
        if (!isLenient() && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
        }
        m4435b(new JsonPrimitive(Double.valueOf(d)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j) {
        m4435b(new JsonPrimitive(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m4435b(new JsonPrimitive(number));
        return this;
    }
}
