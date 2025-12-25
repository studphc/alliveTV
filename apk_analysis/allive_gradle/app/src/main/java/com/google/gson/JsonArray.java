package com.google.gson;

import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.ye0;

/* loaded from: classes2.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: a */
    public final ArrayList f15708a;

    public JsonArray() {
        this.f15708a = new ArrayList();
    }

    /* renamed from: a */
    public final JsonElement m4412a() {
        ArrayList arrayList = this.f15708a;
        int size = arrayList.size();
        if (size == 1) {
            return (JsonElement) arrayList.get(0);
        }
        throw new IllegalStateException(ye0.m8291k(size, "Array must have size 1, but has size "));
    }

    public void add(Boolean bool) {
        this.f15708a.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void addAll(JsonArray jsonArray) {
        this.f15708a.addAll(jsonArray.f15708a);
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.f15708a);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.f15708a.contains(jsonElement);
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonArray) || !((JsonArray) obj).f15708a.equals(this.f15708a))) {
            return false;
        }
        return true;
    }

    public JsonElement get(int i) {
        return (JsonElement) this.f15708a.get(i);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        return m4412a().getAsBigDecimal();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        return m4412a().getAsBigInteger();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return m4412a().getAsBoolean();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return m4412a().getAsByte();
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        return m4412a().getAsCharacter();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return m4412a().getAsDouble();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return m4412a().getAsFloat();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return m4412a().getAsInt();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return m4412a().getAsLong();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        return m4412a().getAsNumber();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return m4412a().getAsShort();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        return m4412a().getAsString();
    }

    public int hashCode() {
        return this.f15708a.hashCode();
    }

    public boolean isEmpty() {
        return this.f15708a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f15708a.iterator();
    }

    public boolean remove(JsonElement jsonElement) {
        return this.f15708a.remove(jsonElement);
    }

    public JsonElement set(int i, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        return (JsonElement) this.f15708a.set(i, jsonElement);
    }

    public int size() {
        return this.f15708a.size();
    }

    public void add(Character ch) {
        this.f15708a.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        ArrayList arrayList = this.f15708a;
        if (!arrayList.isEmpty()) {
            JsonArray jsonArray = new JsonArray(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jsonArray.add(((JsonElement) it.next()).deepCopy());
            }
            return jsonArray;
        }
        return new JsonArray();
    }

    public JsonElement remove(int i) {
        return (JsonElement) this.f15708a.remove(i);
    }

    public JsonArray(int i) {
        this.f15708a = new ArrayList(i);
    }

    public void add(Number number) {
        this.f15708a.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.f15708a.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f15708a.add(jsonElement);
    }
}
