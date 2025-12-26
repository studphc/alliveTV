package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class JsonObject extends JsonElement {

    /* renamed from: a */
    public final LinkedTreeMap f15709a = new LinkedTreeMap(false);

    public void add(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f15709a.put(str, jsonElement);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? JsonNull.INSTANCE : new JsonPrimitive(str2));
    }

    public Map<String, JsonElement> asMap() {
        return this.f15709a;
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.f15709a.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonObject) || !((JsonObject) obj).f15709a.equals(this.f15709a))) {
            return false;
        }
        return true;
    }

    public JsonElement get(String str) {
        return (JsonElement) this.f15709a.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.f15709a.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.f15709a.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.f15709a.get(str);
    }

    public boolean has(String str) {
        return this.f15709a.containsKey(str);
    }

    public int hashCode() {
        return this.f15709a.hashCode();
    }

    public boolean isEmpty() {
        if (this.f15709a.size() == 0) {
            return true;
        }
        return false;
    }

    public Set<String> keySet() {
        return this.f15709a.keySet();
    }

    public JsonElement remove(String str) {
        return (JsonElement) this.f15709a.remove(str);
    }

    public int size() {
        return this.f15709a.size();
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : this.f15709a.entrySet()) {
            jsonObject.add((String) entry.getKey(), ((JsonElement) entry.getValue()).deepCopy());
        }
        return jsonObject;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }
}
