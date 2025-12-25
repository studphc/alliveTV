package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p000.AbstractC1726qj;
import p000.p92;
import p000.ye0;

/* loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f15764a;

    /* renamed from: b */
    public final FieldNamingStrategy f15765b;

    /* renamed from: c */
    public final Excluder f15766c;

    /* renamed from: d */
    public final JsonAdapterAnnotationTypeAdapterFactory f15767d;

    /* renamed from: e */
    public final List f15768e;

    /* loaded from: classes2.dex */
    public static abstract class Adapter<T, A> extends TypeAdapter<T> {

        /* renamed from: a */
        public final LinkedHashMap f15769a;

        public Adapter(LinkedHashMap linkedHashMap) {
            this.f15769a = linkedHashMap;
        }

        /* renamed from: a */
        public abstract Object mo4440a();

        /* renamed from: b */
        public abstract Object mo4441b(Object obj);

        /* renamed from: c */
        public abstract void mo4442c(Object obj, JsonReader jsonReader, p92 p92Var);

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object mo4440a = mo4440a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    p92 p92Var = (p92) this.f15769a.get(jsonReader.nextName());
                    if (p92Var != null && p92Var.f25081e) {
                        mo4442c(mo4440a, jsonReader, p92Var);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return (T) mo4441b(mo4440a);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator it = this.f15769a.values().iterator();
                while (it.hasNext()) {
                    ((p92) it.next()).m6893a(jsonWriter, t);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.f15764a = constructorConstructor;
        this.f15765b = fieldNamingStrategy;
        this.f15766c = excluder;
        this.f15767d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f15768e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m4438a(AccessibleObject accessibleObject, Object obj) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.canAccess(accessibleObject, obj)) {
        } else {
            throw new JsonIOException(AbstractC1726qj.m7057m(ReflectionHelper.getAccessibleObjectDescription(accessibleObject, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0208 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0108  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LinkedHashMap m4439b(Gson gson, TypeToken typeToken, Class cls, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        Method method;
        SerializedName serializedName;
        ArrayList arrayList;
        ?? singletonList;
        int size;
        ?? r3;
        p92 p92Var;
        int i;
        int i2;
        boolean z6;
        boolean z7;
        Field[] fieldArr;
        Class cls2;
        LinkedHashMap linkedHashMap;
        boolean z8;
        boolean z9;
        TypeAdapter typeAdapter;
        boolean z10;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Gson gson2 = gson;
        Class cls3 = cls;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap2;
        }
        TypeToken typeToken2 = typeToken;
        boolean z11 = z;
        Class cls4 = cls3;
        while (cls4 != Object.class) {
            Field[] declaredFields = cls4.getDeclaredFields();
            boolean z12 = false;
            boolean z13 = true;
            if (cls4 != cls3 && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.f15768e, cls4);
                if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls4 + " (supertype of " + cls3 + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z14 = z11;
            int length = declaredFields.length;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                Class<?> type = field.getType();
                Excluder excluder = reflectiveTypeAdapterFactory.f15766c;
                if (!excluder.excludeClass(type, z13) && !excluder.excludeField(field, z13)) {
                    z3 = z13 ? 1 : 0;
                } else {
                    z3 = z12;
                }
                if (!excluder.excludeClass(field.getType(), z12) && !excluder.excludeField(field, z12)) {
                    z4 = z13 ? 1 : 0;
                } else {
                    z4 = z12;
                }
                if (!z3 && !z4) {
                    i = i3;
                    i2 = length;
                    z6 = z13 ? 1 : 0;
                    z7 = z12;
                    fieldArr = declaredFields;
                    cls2 = cls4;
                    linkedHashMap = linkedHashMap2;
                } else {
                    if (z2) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            z5 = z12;
                        } else {
                            Method accessor = ReflectionHelper.getAccessor(cls4, field);
                            if (!z14) {
                                ReflectionHelper.makeAccessible(accessor);
                            }
                            if (accessor.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                                throw new JsonIOException(ye0.m8296p("@SerializedName on ", ReflectionHelper.getAccessibleObjectDescription(accessor, z12), " is not supported"));
                            }
                            z5 = z4;
                            method = accessor;
                            if (!z14 && method == null) {
                                ReflectionHelper.makeAccessible(field);
                            }
                            Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls4, field.getGenericType());
                            serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                            if (serializedName != null) {
                                singletonList = Collections.singletonList(reflectiveTypeAdapterFactory.f15765b.translateName(field));
                            } else {
                                String value = serializedName.value();
                                String[] alternate = serializedName.alternate();
                                if (alternate.length == 0) {
                                    singletonList = Collections.singletonList(value);
                                } else {
                                    ArrayList arrayList2 = new ArrayList(alternate.length + (z13 ? 1 : 0));
                                    arrayList2.add(value);
                                    Collections.addAll(arrayList2, alternate);
                                    arrayList = arrayList2;
                                    size = arrayList.size();
                                    r3 = z12;
                                    p92 p92Var2 = null;
                                    ?? r5 = arrayList;
                                    while (r3 < size) {
                                        String str = (String) r5.get(r3);
                                        if (r3 != 0) {
                                            z8 = z12;
                                        } else {
                                            z8 = z3;
                                        }
                                        TypeToken<?> typeToken3 = TypeToken.get(resolve);
                                        boolean isPrimitive = Primitives.isPrimitive(typeToken3.getRawType());
                                        int modifiers = field.getModifiers();
                                        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                                            z9 = z13;
                                        } else {
                                            z9 = z12;
                                        }
                                        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
                                        if (jsonAdapter != null) {
                                            reflectiveTypeAdapterFactory.f15767d.getClass();
                                            typeAdapter = JsonAdapterAnnotationTypeAdapterFactory.m4427a(reflectiveTypeAdapterFactory.f15764a, gson2, typeToken3, jsonAdapter);
                                        } else {
                                            typeAdapter = null;
                                        }
                                        if (typeAdapter != null) {
                                            z10 = true;
                                        } else {
                                            z10 = false;
                                        }
                                        if (typeAdapter == null) {
                                            typeAdapter = gson2.getAdapter(typeToken3);
                                        }
                                        p92 p92Var3 = p92Var2;
                                        int i4 = r3;
                                        int i5 = size;
                                        Object obj = r5;
                                        Field field2 = field;
                                        int i6 = i3;
                                        int i7 = length;
                                        Field[] fieldArr2 = declaredFields;
                                        Class cls5 = cls4;
                                        LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                        p92Var2 = (p92) linkedHashMap3.put(str, new p92(str, field, z8, z5, z14, method, z10, typeAdapter, gson, typeToken3, isPrimitive, z9));
                                        if (p92Var3 != null) {
                                            p92Var2 = p92Var3;
                                        }
                                        reflectiveTypeAdapterFactory = this;
                                        cls4 = cls5;
                                        linkedHashMap2 = linkedHashMap3;
                                        z3 = z8;
                                        size = i5;
                                        r5 = obj;
                                        field = field2;
                                        i3 = i6;
                                        length = i7;
                                        z13 = true;
                                        z12 = false;
                                        declaredFields = fieldArr2;
                                        gson2 = gson;
                                        r3 = i4 + 1;
                                    }
                                    p92Var = p92Var2;
                                    Field field3 = field;
                                    i = i3;
                                    i2 = length;
                                    z6 = z13;
                                    z7 = z12;
                                    fieldArr = declaredFields;
                                    cls2 = cls4;
                                    linkedHashMap = linkedHashMap2;
                                    if (p92Var != null) {
                                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + p92Var.f25077a + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(p92Var.f25078b) + " and " + ReflectionHelper.fieldToString(field3));
                                    }
                                }
                            }
                            arrayList = singletonList;
                            size = arrayList.size();
                            r3 = z12;
                            p92 p92Var22 = null;
                            ?? r52 = arrayList;
                            while (r3 < size) {
                            }
                            p92Var = p92Var22;
                            Field field32 = field;
                            i = i3;
                            i2 = length;
                            z6 = z13;
                            z7 = z12;
                            fieldArr = declaredFields;
                            cls2 = cls4;
                            linkedHashMap = linkedHashMap2;
                            if (p92Var != null) {
                            }
                        }
                    } else {
                        z5 = z4;
                    }
                    method = null;
                    if (!z14) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type resolve2 = C$Gson$Types.resolve(typeToken2.getType(), cls4, field.getGenericType());
                    serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                    }
                    arrayList = singletonList;
                    size = arrayList.size();
                    r3 = z12;
                    p92 p92Var222 = null;
                    ?? r522 = arrayList;
                    while (r3 < size) {
                    }
                    p92Var = p92Var222;
                    Field field322 = field;
                    i = i3;
                    i2 = length;
                    z6 = z13;
                    z7 = z12;
                    fieldArr = declaredFields;
                    cls2 = cls4;
                    linkedHashMap = linkedHashMap2;
                    if (p92Var != null) {
                    }
                }
                i3 = i + 1;
                reflectiveTypeAdapterFactory = this;
                cls4 = cls2;
                linkedHashMap2 = linkedHashMap;
                length = i2;
                z13 = z6;
                z12 = z7;
                declaredFields = fieldArr;
                gson2 = gson;
            }
            Class cls6 = cls4;
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls6, cls6.getGenericSuperclass()));
            cls4 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
            cls3 = cls;
            z11 = z14;
            gson2 = gson;
        }
        return linkedHashMap2;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z;
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.f15768e, rawType);
        if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            if (ReflectionHelper.isRecord(rawType)) {
                return new C1059c(rawType, m4439b(gson, typeToken, rawType, z2, true), z2);
            }
            return new C1058b(this.f15764a.get(typeToken), m4439b(gson, typeToken, rawType, z2, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
