package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f15745a;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f15745a = constructorConstructor;
    }

    /* renamed from: a */
    public static TypeAdapter m4427a(ConstructorConstructor constructorConstructor, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter) {
        JsonSerializer jsonSerializer;
        JsonDeserializer jsonDeserializer;
        TypeAdapter treeTypeAdapter;
        Object construct = constructorConstructor.get(TypeToken.get((Class) jsonAdapter.value())).construct();
        boolean nullSafe = jsonAdapter.nullSafe();
        if (construct instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) construct).create(gson, typeToken);
        } else {
            boolean z = construct instanceof JsonSerializer;
            if (!z && !(construct instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            if (z) {
                jsonSerializer = (JsonSerializer) construct;
            } else {
                jsonSerializer = null;
            }
            if (construct instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) construct;
            } else {
                jsonDeserializer = null;
            }
            treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, null, nullSafe);
            nullSafe = false;
        }
        if (treeTypeAdapter != null && nullSafe) {
            return treeTypeAdapter.nullSafe();
        }
        return treeTypeAdapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return m4427a(this.f15745a, gson, typeToken, jsonAdapter);
    }
}
