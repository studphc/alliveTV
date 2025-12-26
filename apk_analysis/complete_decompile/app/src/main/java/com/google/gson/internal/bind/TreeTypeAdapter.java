package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import p000.ai2;
import p000.uw2;

/* loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a */
    public final JsonSerializer f15770a;

    /* renamed from: b */
    public final JsonDeserializer f15771b;

    /* renamed from: c */
    public final Gson f15772c;

    /* renamed from: d */
    public final TypeToken f15773d;

    /* renamed from: e */
    public final TypeAdapterFactory f15774e;

    /* renamed from: f */
    public final ai2 f15775f;

    /* renamed from: g */
    public final boolean f15776g;

    /* renamed from: h */
    public volatile TypeAdapter f15777h;

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory, boolean z) {
        this.f15775f = new ai2(8, this);
        this.f15770a = jsonSerializer;
        this.f15771b = jsonDeserializer;
        this.f15772c = gson;
        this.f15773d = typeToken;
        this.f15774e = typeAdapterFactory;
        this.f15776g = z;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        return new uw2(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        boolean z;
        if (typeToken.getType() == typeToken.getRawType()) {
            z = true;
        } else {
            z = false;
        }
        return new uw2(obj, typeToken, z, null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new uw2(obj, null, false, cls);
    }

    /* renamed from: a */
    public final TypeAdapter m4443a() {
        TypeAdapter typeAdapter = this.f15777h;
        if (typeAdapter == null) {
            TypeAdapter<T> delegateAdapter = this.f15772c.getDelegateAdapter(this.f15774e, this.f15773d);
            this.f15777h = delegateAdapter;
            return delegateAdapter;
        }
        return typeAdapter;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> getSerializationDelegate() {
        if (this.f15770a != null) {
            return this;
        }
        return m4443a();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) {
        JsonDeserializer jsonDeserializer = this.f15771b;
        if (jsonDeserializer == null) {
            return (T) m4443a().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (this.f15776g && parse.isJsonNull()) {
            return null;
        }
        return (T) jsonDeserializer.deserialize(parse, this.f15773d.getType(), this.f15775f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) {
        JsonSerializer jsonSerializer = this.f15770a;
        if (jsonSerializer == null) {
            m4443a().write(jsonWriter, t);
        } else if (this.f15776g && t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(t, this.f15773d.getType(), this.f15775f), jsonWriter);
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, true);
    }
}
