package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import p000.cg1;

/* loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f15757a;

    /* renamed from: b */
    public final boolean f15758b;

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.f15757a = constructorConstructor;
        this.f15758b = z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        TypeAdapter<Boolean> typeAdapter;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, rawType);
        Type type2 = mapKeyAndValueTypes[0];
        if (type2 != Boolean.TYPE && type2 != Boolean.class) {
            typeAdapter = gson.getAdapter(TypeToken.get(type2));
        } else {
            typeAdapter = TypeAdapters.BOOLEAN_AS_STRING;
        }
        return new cg1(this, gson, mapKeyAndValueTypes[0], typeAdapter, mapKeyAndValueTypes[1], gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[1])), this.f15757a.get(typeToken));
    }
}
