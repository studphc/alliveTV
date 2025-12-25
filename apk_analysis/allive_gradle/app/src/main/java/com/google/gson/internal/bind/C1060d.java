package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.gson.internal.bind.d */
/* loaded from: classes2.dex */
public final class C1060d extends TypeAdapter {

    /* renamed from: a */
    public final Gson f15783a;

    /* renamed from: b */
    public final TypeAdapter f15784b;

    /* renamed from: c */
    public final Type f15785c;

    public C1060d(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f15783a = gson;
        this.f15784b = typeAdapter;
        this.f15785c = type;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        return this.f15784b.read(jsonReader);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if ((r1 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter) == false) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void write(JsonWriter jsonWriter, Object obj) {
        Class<?> cls;
        TypeAdapter serializationDelegate;
        ?? r0 = this.f15785c;
        if (obj != null && ((r0 instanceof Class) || (r0 instanceof TypeVariable))) {
            cls = obj.getClass();
        } else {
            cls = r0;
        }
        TypeAdapter typeAdapter = this.f15784b;
        if (cls != r0) {
            TypeAdapter adapter = this.f15783a.getAdapter(TypeToken.get((Type) cls));
            if (adapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter typeAdapter2 = typeAdapter;
                while ((typeAdapter2 instanceof SerializationDelegatingTypeAdapter) && (serializationDelegate = ((SerializationDelegatingTypeAdapter) typeAdapter2).getSerializationDelegate()) != typeAdapter2) {
                    typeAdapter2 = serializationDelegate;
                }
            }
            typeAdapter = adapter;
        }
        typeAdapter.write(jsonWriter, obj);
    }
}
