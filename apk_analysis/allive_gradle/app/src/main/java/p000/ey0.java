package p000;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* loaded from: classes2.dex */
public final class ey0 extends SerializationDelegatingTypeAdapter {

    /* renamed from: a */
    public TypeAdapter f17034a;

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public final TypeAdapter getSerializationDelegate() {
        TypeAdapter typeAdapter = this.f17034a;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        TypeAdapter typeAdapter = this.f17034a;
        if (typeAdapter != null) {
            return typeAdapter.read(jsonReader);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        TypeAdapter typeAdapter = this.f17034a;
        if (typeAdapter != null) {
            typeAdapter.write(jsonWriter, obj);
            return;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }
}
