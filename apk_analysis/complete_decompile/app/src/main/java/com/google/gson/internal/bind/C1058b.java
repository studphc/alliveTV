package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import p000.AbstractC1726qj;
import p000.p92;

/* renamed from: com.google.gson.internal.bind.b */
/* loaded from: classes2.dex */
public final class C1058b extends ReflectiveTypeAdapterFactory.Adapter {

    /* renamed from: b */
    public final ObjectConstructor f15778b;

    public C1058b(ObjectConstructor objectConstructor, LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
        this.f15778b = objectConstructor;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
    /* renamed from: a */
    public final Object mo4440a() {
        return this.f15778b.construct();
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
    /* renamed from: b */
    public final Object mo4441b(Object obj) {
        return obj;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
    /* renamed from: c */
    public final void mo4442c(Object obj, JsonReader jsonReader, p92 p92Var) {
        Object read = p92Var.f25085i.read(jsonReader);
        if (read != null || !p92Var.f25088l) {
            Field field = p92Var.f25078b;
            if (p92Var.f25082f) {
                ReflectiveTypeAdapterFactory.m4438a(field, obj);
            } else if (p92Var.f25089m) {
                throw new JsonIOException(AbstractC1726qj.m7038C("Cannot set value of 'static final' ", ReflectionHelper.getAccessibleObjectDescription(field, false)));
            }
            field.set(obj, read);
        }
    }
}
