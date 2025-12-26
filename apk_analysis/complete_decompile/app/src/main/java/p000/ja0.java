package p000;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* loaded from: classes2.dex */
public final class ja0 extends TypeAdapter {

    /* renamed from: a */
    public TypeAdapter f20432a;

    /* renamed from: b */
    public final /* synthetic */ boolean f20433b;

    /* renamed from: c */
    public final /* synthetic */ boolean f20434c;

    /* renamed from: d */
    public final /* synthetic */ Gson f20435d;

    /* renamed from: e */
    public final /* synthetic */ TypeToken f20436e;

    /* renamed from: f */
    public final /* synthetic */ Excluder f20437f;

    public ja0(Excluder excluder, boolean z, boolean z2, Gson gson, TypeToken typeToken) {
        this.f20437f = excluder;
        this.f20433b = z;
        this.f20434c = z2;
        this.f20435d = gson;
        this.f20436e = typeToken;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        if (this.f20433b) {
            jsonReader.skipValue();
            return null;
        }
        TypeAdapter typeAdapter = this.f20432a;
        if (typeAdapter == null) {
            typeAdapter = this.f20435d.getDelegateAdapter(this.f20437f, this.f20436e);
            this.f20432a = typeAdapter;
        }
        return typeAdapter.read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        if (this.f20434c) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter typeAdapter = this.f20432a;
        if (typeAdapter == null) {
            typeAdapter = this.f20435d.getDelegateAdapter(this.f20437f, this.f20436e);
            this.f20432a = typeAdapter;
        }
        typeAdapter.write(jsonWriter, obj);
    }
}
