package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p000.dy0;
import p000.gm2;

/* loaded from: classes2.dex */
public final class Gson {

    /* renamed from: a */
    public final ThreadLocal f15663a;

    /* renamed from: b */
    public final ConcurrentHashMap f15664b;

    /* renamed from: c */
    public final ConstructorConstructor f15665c;

    /* renamed from: d */
    public final JsonAdapterAnnotationTypeAdapterFactory f15666d;

    /* renamed from: e */
    public final List f15667e;

    /* renamed from: f */
    public final Excluder f15668f;

    /* renamed from: g */
    public final FieldNamingStrategy f15669g;

    /* renamed from: h */
    public final Map f15670h;

    /* renamed from: i */
    public final boolean f15671i;

    /* renamed from: j */
    public final boolean f15672j;

    /* renamed from: k */
    public final boolean f15673k;

    /* renamed from: l */
    public final boolean f15674l;

    /* renamed from: m */
    public final boolean f15675m;

    /* renamed from: n */
    public final boolean f15676n;

    /* renamed from: o */
    public final boolean f15677o;

    /* renamed from: p */
    public final boolean f15678p;

    /* renamed from: q */
    public final String f15679q;

    /* renamed from: r */
    public final int f15680r;

    /* renamed from: s */
    public final int f15681s;

    /* renamed from: t */
    public final LongSerializationPolicy f15682t;

    /* renamed from: u */
    public final List f15683u;

    /* renamed from: v */
    public final List f15684v;

    /* renamed from: w */
    public final ToNumberStrategy f15685w;

    /* renamed from: x */
    public final ToNumberStrategy f15686x;

    /* renamed from: y */
    public final List f15687y;

    /* renamed from: z */
    public static final FieldNamingPolicy f15662z = FieldNamingPolicy.IDENTITY;

    /* renamed from: A */
    public static final ToNumberPolicy f15660A = ToNumberPolicy.DOUBLE;

    /* renamed from: B */
    public static final ToNumberPolicy f15661B = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    public Gson() {
        this(Excluder.DEFAULT, f15662z, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f15660A, f15661B, Collections.emptyList());
    }

    /* renamed from: a */
    public static void m4411a(double d) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            return;
        }
        throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    @Deprecated
    public Excluder excluder() {
        return this.f15668f;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.f15669g;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        return (T) Primitives.wrap(cls).cast(fromJson(str, TypeToken.get((Class) cls)));
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.gson.internal.bind.SerializationDelegatingTypeAdapter, java.lang.Object, ey0] */
    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        boolean z;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f15664b;
        TypeAdapter<T> typeAdapter = (TypeAdapter) concurrentHashMap.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        ThreadLocal threadLocal = this.f15663a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z = false;
        }
        try {
            ?? serializationDelegatingTypeAdapter = new SerializationDelegatingTypeAdapter();
            serializationDelegatingTypeAdapter.f17034a = null;
            map.put(typeToken, serializationDelegatingTypeAdapter);
            Iterator it = this.f15667e.iterator();
            TypeAdapter<T> typeAdapter3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                typeAdapter3 = ((TypeAdapterFactory) it.next()).create(this, typeToken);
                if (typeAdapter3 != null) {
                    if (serializationDelegatingTypeAdapter.f17034a == null) {
                        serializationDelegatingTypeAdapter.f17034a = typeAdapter3;
                        map.put(typeToken, typeAdapter3);
                    } else {
                        throw new AssertionError("Delegate is already set");
                    }
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (typeAdapter3 != null) {
                if (z) {
                    concurrentHashMap.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        List<TypeAdapterFactory> list = this.f15667e;
        if (!list.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f15666d;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : list) {
            if (!z) {
                if (typeAdapterFactory2 == typeAdapterFactory) {
                    z = true;
                }
            } else {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.f15674l;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.f15676n);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer writer) {
        if (this.f15673k) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f15675m) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setHtmlSafe(this.f15674l);
        jsonWriter.setLenient(this.f15676n);
        jsonWriter.setSerializeNulls(this.f15671i);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.f15671i;
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.f15671i + ",factories:" + this.f15667e + ",instanceCreators:" + this.f15665c + "}";
    }

    public <T> T fromJson(String str, Type type) {
        return (T) fromJson(str, TypeToken.get(type));
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public <T> T fromJson(String str, TypeToken<T> typeToken) {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), typeToken);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) {
        return (T) Primitives.wrap(cls).cast(fromJson(reader, TypeToken.get((Class) cls)));
    }

    public void toJson(Object obj, Appendable appendable) {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List list, List list2, List list3, ToNumberStrategy toNumberStrategy, ToNumberStrategy toNumberStrategy2, List list4) {
        TypeAdapter dy0Var;
        TypeAdapter dy0Var2;
        TypeAdapter dy0Var3;
        this.f15663a = new ThreadLocal();
        this.f15664b = new ConcurrentHashMap();
        this.f15668f = excluder;
        this.f15669g = fieldNamingStrategy;
        this.f15670h = map;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map, z8, list4);
        this.f15665c = constructorConstructor;
        this.f15671i = z;
        this.f15672j = z2;
        this.f15673k = z3;
        this.f15674l = z4;
        this.f15675m = z5;
        this.f15676n = z6;
        this.f15677o = z7;
        this.f15678p = z8;
        this.f15682t = longSerializationPolicy;
        this.f15679q = str;
        this.f15680r = i;
        this.f15681s = i2;
        this.f15683u = list;
        this.f15684v = list2;
        this.f15685w = toNumberStrategy;
        this.f15686x = toNumberStrategy2;
        this.f15687y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.getFactory(toNumberStrategy));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            dy0Var = TypeAdapters.LONG;
        } else {
            dy0Var = new dy0(2);
        }
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, dy0Var));
        Class cls = Double.TYPE;
        if (z7) {
            dy0Var2 = TypeAdapters.DOUBLE;
        } else {
            dy0Var2 = new dy0(0);
        }
        arrayList.add(TypeAdapters.newFactory(cls, Double.class, dy0Var2));
        Class cls2 = Float.TYPE;
        if (z7) {
            dy0Var3 = TypeAdapters.FLOAT;
        } else {
            dy0Var3 = new dy0(1);
        }
        arrayList.add(TypeAdapters.newFactory(cls2, Float.class, dy0Var3));
        arrayList.add(NumberTypeAdapter.getFactory(toNumberStrategy2));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, new gm2(dy0Var, 1).nullSafe()));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, new gm2(dy0Var, 2).nullSafe()));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList.add(SqlTypesSupport.TIME_FACTORY);
            arrayList.add(SqlTypesSupport.DATE_FACTORY);
            arrayList.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.f15666d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f15667e = Collections.unmodifiableList(arrayList);
    }

    public <T> T fromJson(Reader reader, Type type) {
        return (T) fromJson(reader, TypeToken.get(type));
    }

    public void toJson(Object obj, Type type, Appendable appendable) {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public <T> T fromJson(Reader reader, TypeToken<T> typeToken) {
        JsonReader newJsonReader = newJsonReader(reader);
        T t = (T) fromJson(newJsonReader, typeToken);
        if (t != null) {
            try {
                if (newJsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
        return t;
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f15674l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f15671i);
        try {
            try {
                adapter.write(jsonWriter, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) {
        return (T) fromJson(jsonReader, TypeToken.get(type));
    }

    public <T> T fromJson(JsonReader jsonReader, TypeToken<T> typeToken) {
        boolean isLenient = jsonReader.isLenient();
        boolean z = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    return getAdapter(typeToken).read(jsonReader);
                } catch (EOFException e) {
                    if (z) {
                        jsonReader.setLenient(isLenient);
                        return null;
                    }
                    throw new JsonSyntaxException(e);
                } catch (IllegalStateException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } catch (IOException e3) {
                throw new JsonSyntaxException(e3);
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) {
        return (T) Primitives.wrap(cls).cast(fromJson(jsonElement, TypeToken.get((Class) cls)));
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) {
        return (T) fromJson(jsonElement, TypeToken.get(type));
    }

    public <T> T fromJson(JsonElement jsonElement, TypeToken<T> typeToken) {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new JsonTreeReader(jsonElement), typeToken);
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f15674l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f15671i);
        try {
            try {
                Streams.write(jsonElement, jsonWriter);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }
}
