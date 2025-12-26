package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import p000.C1718qb;
import p000.dy0;
import p000.kx2;
import p000.lx2;
import p000.nx2;

/* loaded from: classes2.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    static {
        TypeAdapter<Class> nullSafe = new dy0(13).nullSafe();
        CLASS = nullSafe;
        CLASS_FACTORY = newFactory(Class.class, nullSafe);
        TypeAdapter<BitSet> nullSafe2 = new dy0(23).nullSafe();
        BIT_SET = nullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, nullSafe2);
        dy0 dy0Var = new dy0(24);
        BOOLEAN = dy0Var;
        BOOLEAN_AS_STRING = new dy0(25);
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, dy0Var);
        dy0 dy0Var2 = new dy0(26);
        BYTE = dy0Var2;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, dy0Var2);
        dy0 dy0Var3 = new dy0(27);
        SHORT = dy0Var3;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, dy0Var3);
        dy0 dy0Var4 = new dy0(28);
        INTEGER = dy0Var4;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, dy0Var4);
        TypeAdapter<AtomicInteger> nullSafe3 = new nx2(1).nullSafe();
        ATOMIC_INTEGER = nullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, nullSafe3);
        TypeAdapter<AtomicBoolean> nullSafe4 = new nx2(0).nullSafe();
        ATOMIC_BOOLEAN = nullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, nullSafe4);
        TypeAdapter<AtomicIntegerArray> nullSafe5 = new dy0(3).nullSafe();
        ATOMIC_INTEGER_ARRAY = nullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, nullSafe5);
        LONG = new dy0(4);
        FLOAT = new dy0(5);
        DOUBLE = new dy0(6);
        dy0 dy0Var5 = new dy0(7);
        CHARACTER = dy0Var5;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, dy0Var5);
        dy0 dy0Var6 = new dy0(8);
        STRING = dy0Var6;
        BIG_DECIMAL = new dy0(9);
        BIG_INTEGER = new dy0(10);
        LAZILY_PARSED_NUMBER = new dy0(11);
        STRING_FACTORY = newFactory(String.class, dy0Var6);
        dy0 dy0Var7 = new dy0(12);
        STRING_BUILDER = dy0Var7;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, dy0Var7);
        dy0 dy0Var8 = new dy0(14);
        STRING_BUFFER = dy0Var8;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, dy0Var8);
        dy0 dy0Var9 = new dy0(15);
        URL = dy0Var9;
        URL_FACTORY = newFactory(URL.class, dy0Var9);
        dy0 dy0Var10 = new dy0(16);
        URI = dy0Var10;
        URI_FACTORY = newFactory(URI.class, dy0Var10);
        dy0 dy0Var11 = new dy0(17);
        INET_ADDRESS = dy0Var11;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, dy0Var11);
        dy0 dy0Var12 = new dy0(18);
        UUID = dy0Var12;
        UUID_FACTORY = newFactory(UUID.class, dy0Var12);
        TypeAdapter<Currency> nullSafe6 = new dy0(19).nullSafe();
        CURRENCY = nullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, nullSafe6);
        dy0 dy0Var13 = new dy0(20);
        CALENDAR = dy0Var13;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, dy0Var13);
        dy0 dy0Var14 = new dy0(21);
        LOCALE = dy0Var14;
        LOCALE_FACTORY = newFactory(Locale.class, dy0Var14);
        dy0 dy0Var15 = new dy0(22);
        JSON_ELEMENT = dy0Var15;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, dy0Var15);
        ENUM_FACTORY = new C1718qb(5);
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new kx2(typeToken, typeAdapter, 2);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new lx2(cls, cls2, typeAdapter, 1);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> cls, TypeAdapter<T1> typeAdapter) {
        return new kx2(cls, typeAdapter, 1);
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new kx2(cls, typeAdapter, 0);
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new lx2(cls, cls2, typeAdapter, 0);
    }
}
