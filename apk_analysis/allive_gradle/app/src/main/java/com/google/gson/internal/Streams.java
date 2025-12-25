package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import p000.C2017ye;

/* loaded from: classes2.dex */
public final class Streams {
    public static JsonElement parse(JsonReader jsonReader) {
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
                try {
                    return TypeAdapters.JSON_ELEMENT.read(jsonReader);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
        } catch (MalformedJsonException e3) {
            throw new JsonSyntaxException(e3);
        } catch (IOException e4) {
            throw new JsonIOException(e4);
        } catch (NumberFormatException e5) {
            throw new JsonSyntaxException(e5);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new C2017ye(appendable);
    }
}
