package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public final class LazilyParsedNumber extends Number {

    /* renamed from: a */
    public final String f15727a;

    public LazilyParsedNumber(String str) {
        this.f15727a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new BigDecimal(this.f15727a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f15727a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        Object obj2 = ((LazilyParsedNumber) obj).f15727a;
        String str = this.f15727a;
        if (str == obj2 || str.equals(obj2)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f15727a);
    }

    public int hashCode() {
        return this.f15727a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        String str = this.f15727a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(str).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        String str = this.f15727a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public String toString() {
        return this.f15727a;
    }
}
