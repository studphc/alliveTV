package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class JsonPrimitive extends JsonElement {

    /* renamed from: a */
    public final Serializable f15710a;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f15710a = bool;
    }

    /* renamed from: a */
    public static boolean m4413a(JsonPrimitive jsonPrimitive) {
        Serializable serializable = jsonPrimitive.f15710a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        if (!(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        Serializable serializable = this.f15710a;
        Serializable serializable2 = jsonPrimitive.f15710a;
        if (serializable == null) {
            if (serializable2 == null) {
                return true;
            }
            return false;
        }
        if (m4413a(this) && m4413a(jsonPrimitive)) {
            if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
                return true;
            }
            return false;
        }
        if ((serializable instanceof Number) && (serializable2 instanceof Number)) {
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            return false;
        }
        return serializable.equals(serializable2);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Serializable serializable = this.f15710a;
        if (serializable instanceof BigDecimal) {
            return (BigDecimal) serializable;
        }
        return new BigDecimal(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Serializable serializable = this.f15710a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        return new BigInteger(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) this.f15710a).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber()) {
            return getAsNumber().byteValue();
        }
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        String asString = getAsString();
        if (!asString.isEmpty()) {
            return asString.charAt(0);
        }
        throw new UnsupportedOperationException("String value is empty");
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber()) {
            return getAsNumber().doubleValue();
        }
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber()) {
            return getAsNumber().floatValue();
        }
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber()) {
            return getAsNumber().intValue();
        }
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber()) {
            return getAsNumber().longValue();
        }
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Serializable serializable = this.f15710a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new LazilyParsedNumber((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber()) {
            return getAsNumber().shortValue();
        }
        return Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        Serializable serializable = this.f15710a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.f15710a;
        if (serializable == null) {
            return 31;
        }
        if (m4413a(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else if (serializable instanceof Number) {
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        } else {
            return serializable.hashCode();
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public boolean isBoolean() {
        return this.f15710a instanceof Boolean;
    }

    public boolean isNumber() {
        return this.f15710a instanceof Number;
    }

    public boolean isString() {
        return this.f15710a instanceof String;
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.f15710a = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.f15710a = str;
    }

    public JsonPrimitive(Character ch) {
        Objects.requireNonNull(ch);
        this.f15710a = ch.toString();
    }
}
