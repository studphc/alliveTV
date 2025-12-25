package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {

    /* renamed from: a */
    public final JsonReader f15711a;

    /* renamed from: b */
    public final Object f15712b;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.f15712b) {
            try {
                try {
                    try {
                        if (this.f15711a.peek() != JsonToken.END_DOCUMENT) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } catch (IOException e) {
                        throw new JsonIOException(e);
                    }
                } catch (MalformedJsonException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.f15711a = jsonReader;
        jsonReader.setLenient(true);
        this.f15712b = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() {
        if (hasNext()) {
            try {
                return Streams.parse(this.f15711a);
            } catch (OutOfMemoryError e) {
                throw new JsonParseException("Failed parsing JSON source to Json", e);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source to Json", e2);
            }
        }
        throw new NoSuchElementException();
    }
}
