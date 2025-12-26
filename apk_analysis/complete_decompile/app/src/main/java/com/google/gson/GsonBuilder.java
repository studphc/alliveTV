package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class GsonBuilder {

    /* renamed from: a */
    public Excluder f15688a;

    /* renamed from: b */
    public LongSerializationPolicy f15689b;

    /* renamed from: c */
    public FieldNamingStrategy f15690c;

    /* renamed from: d */
    public final HashMap f15691d;

    /* renamed from: e */
    public final ArrayList f15692e;

    /* renamed from: f */
    public final ArrayList f15693f;

    /* renamed from: g */
    public boolean f15694g;

    /* renamed from: h */
    public String f15695h;

    /* renamed from: i */
    public int f15696i;

    /* renamed from: j */
    public int f15697j;

    /* renamed from: k */
    public boolean f15698k;

    /* renamed from: l */
    public boolean f15699l;

    /* renamed from: m */
    public boolean f15700m;

    /* renamed from: n */
    public boolean f15701n;

    /* renamed from: o */
    public boolean f15702o;

    /* renamed from: p */
    public boolean f15703p;

    /* renamed from: q */
    public boolean f15704q;

    /* renamed from: r */
    public ToNumberStrategy f15705r;

    /* renamed from: s */
    public ToNumberStrategy f15706s;

    /* renamed from: t */
    public final LinkedList f15707t;

    public GsonBuilder() {
        this.f15688a = Excluder.DEFAULT;
        this.f15689b = LongSerializationPolicy.DEFAULT;
        this.f15690c = FieldNamingPolicy.IDENTITY;
        this.f15691d = new HashMap();
        this.f15692e = new ArrayList();
        this.f15693f = new ArrayList();
        this.f15694g = false;
        FieldNamingPolicy fieldNamingPolicy = Gson.f15662z;
        this.f15695h = null;
        this.f15696i = 2;
        this.f15697j = 2;
        this.f15698k = false;
        this.f15699l = false;
        this.f15700m = true;
        this.f15701n = false;
        this.f15702o = false;
        this.f15703p = false;
        this.f15704q = true;
        this.f15705r = Gson.f15660A;
        this.f15706s = Gson.f15661B;
        this.f15707t = new LinkedList();
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        Objects.requireNonNull(exclusionStrategy);
        this.f15688a = this.f15688a.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter reflectionAccessFilter) {
        Objects.requireNonNull(reflectionAccessFilter);
        this.f15707t.addFirst(reflectionAccessFilter);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        Objects.requireNonNull(exclusionStrategy);
        this.f15688a = this.f15688a.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Gson create() {
        TypeAdapterFactory typeAdapterFactory;
        TypeAdapterFactory typeAdapterFactory2;
        ArrayList arrayList = this.f15692e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f15693f;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        String str = this.f15695h;
        int i = this.f15696i;
        int i2 = this.f15697j;
        boolean z = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory typeAdapterFactory3 = null;
        if (str != null && !str.trim().isEmpty()) {
            typeAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(str);
            if (z) {
                typeAdapterFactory3 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(str);
                typeAdapterFactory2 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(str);
                arrayList3.add(typeAdapterFactory);
                if (z) {
                }
            }
            typeAdapterFactory2 = null;
            arrayList3.add(typeAdapterFactory);
            if (z) {
            }
        } else if (i != 2 && i2 != 2) {
            TypeAdapterFactory createAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(i, i2);
            if (z) {
                typeAdapterFactory3 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(i, i2);
                TypeAdapterFactory createAdapterFactory2 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(i, i2);
                typeAdapterFactory = createAdapterFactory;
                typeAdapterFactory2 = createAdapterFactory2;
                arrayList3.add(typeAdapterFactory);
                if (z) {
                    arrayList3.add(typeAdapterFactory3);
                    arrayList3.add(typeAdapterFactory2);
                }
            } else {
                typeAdapterFactory = createAdapterFactory;
                typeAdapterFactory2 = null;
                arrayList3.add(typeAdapterFactory);
                if (z) {
                }
            }
        }
        return new Gson(this.f15688a, this.f15690c, new HashMap(this.f15691d), this.f15694g, this.f15698k, this.f15702o, this.f15700m, this.f15701n, this.f15703p, this.f15699l, this.f15704q, this.f15689b, this.f15695h, this.f15696i, this.f15697j, new ArrayList(arrayList), new ArrayList(arrayList2), arrayList3, this.f15705r, this.f15706s, new ArrayList(this.f15707t));
    }

    public GsonBuilder disableHtmlEscaping() {
        this.f15700m = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.f15688a = this.f15688a.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.f15704q = false;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.f15698k = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        Objects.requireNonNull(iArr);
        this.f15688a = this.f15688a.withModifiers(iArr);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.f15688a = this.f15688a.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.f15702o = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        boolean z;
        Objects.requireNonNull(type);
        boolean z2 = obj instanceof JsonSerializer;
        if (!z2 && !(obj instanceof JsonDeserializer) && !(obj instanceof InstanceCreator) && !(obj instanceof TypeAdapter)) {
            z = false;
        } else {
            z = true;
        }
        C$Gson$Preconditions.checkArgument(z);
        if (obj instanceof InstanceCreator) {
            this.f15691d.put(type, (InstanceCreator) obj);
        }
        ArrayList arrayList = this.f15692e;
        if (z2 || (obj instanceof JsonDeserializer)) {
            arrayList.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            arrayList.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        Objects.requireNonNull(typeAdapterFactory);
        this.f15692e.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z;
        Objects.requireNonNull(cls);
        boolean z2 = obj instanceof JsonSerializer;
        if (!z2 && !(obj instanceof JsonDeserializer) && !(obj instanceof TypeAdapter)) {
            z = false;
        } else {
            z = true;
        }
        C$Gson$Preconditions.checkArgument(z);
        if ((obj instanceof JsonDeserializer) || z2) {
            this.f15693f.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f15692e.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.f15694g = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.f15699l = true;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.f15695h = str;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        Objects.requireNonNull(exclusionStrategyArr);
        for (ExclusionStrategy exclusionStrategy : exclusionStrategyArr) {
            this.f15688a = this.f15688a.withExclusionStrategy(exclusionStrategy, true, true);
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        return setFieldNamingStrategy(fieldNamingPolicy);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        Objects.requireNonNull(fieldNamingStrategy);
        this.f15690c = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLenient() {
        this.f15703p = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        Objects.requireNonNull(longSerializationPolicy);
        this.f15689b = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        Objects.requireNonNull(toNumberStrategy);
        this.f15706s = toNumberStrategy;
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        Objects.requireNonNull(toNumberStrategy);
        this.f15705r = toNumberStrategy;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.f15701n = true;
        return this;
    }

    public GsonBuilder setVersion(double d) {
        if (!Double.isNaN(d) && d >= 0.0d) {
            this.f15688a = this.f15688a.withVersion(d);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d);
    }

    public GsonBuilder setDateFormat(int i) {
        this.f15696i = i;
        this.f15695h = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i, int i2) {
        this.f15696i = i;
        this.f15697j = i2;
        this.f15695h = null;
        return this;
    }

    public GsonBuilder(Gson gson) {
        this.f15688a = Excluder.DEFAULT;
        this.f15689b = LongSerializationPolicy.DEFAULT;
        this.f15690c = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        this.f15691d = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f15692e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f15693f = arrayList2;
        this.f15694g = false;
        FieldNamingPolicy fieldNamingPolicy = Gson.f15662z;
        this.f15695h = null;
        this.f15696i = 2;
        this.f15697j = 2;
        this.f15698k = false;
        this.f15699l = false;
        this.f15700m = true;
        this.f15701n = false;
        this.f15702o = false;
        this.f15703p = false;
        this.f15704q = true;
        this.f15705r = Gson.f15660A;
        this.f15706s = Gson.f15661B;
        LinkedList linkedList = new LinkedList();
        this.f15707t = linkedList;
        this.f15688a = gson.f15668f;
        this.f15690c = gson.f15669g;
        hashMap.putAll(gson.f15670h);
        this.f15694g = gson.f15671i;
        this.f15698k = gson.f15672j;
        this.f15702o = gson.f15673k;
        this.f15700m = gson.f15674l;
        this.f15701n = gson.f15675m;
        this.f15703p = gson.f15676n;
        this.f15699l = gson.f15677o;
        this.f15689b = gson.f15682t;
        this.f15695h = gson.f15679q;
        this.f15696i = gson.f15680r;
        this.f15697j = gson.f15681s;
        arrayList.addAll(gson.f15683u);
        arrayList2.addAll(gson.f15684v);
        this.f15704q = gson.f15678p;
        this.f15705r = gson.f15685w;
        this.f15706s = gson.f15686x;
        linkedList.addAll(gson.f15687y);
    }
}
