package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import p000.dt1;
import p000.et1;

/* loaded from: classes2.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {

    /* renamed from: b */
    public static final dt1 f15759b = new dt1(0, new NumberTypeAdapter(ToNumberPolicy.LAZILY_PARSED_NUMBER));

    /* renamed from: a */
    public final ToNumberStrategy f15760a;

    public NumberTypeAdapter(ToNumberStrategy toNumberStrategy) {
        this.f15760a = toNumberStrategy;
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return f15759b;
        }
        return new dt1(0, new NumberTypeAdapter(toNumberStrategy));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        int i = et1.f16979a[peek.ordinal()];
        if (i == 1) {
            jsonReader.nextNull();
            return null;
        }
        if (i != 2 && i != 3) {
            throw new JsonSyntaxException("Expecting number, got: " + peek + "; at path " + jsonReader.getPath());
        }
        return this.f15760a.readNumber(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Number number) {
        jsonWriter.value(number);
    }
}
