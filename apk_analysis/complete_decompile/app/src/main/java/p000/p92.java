package p000;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.C1060d;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class p92 {

    /* renamed from: a */
    public final String f25077a;

    /* renamed from: b */
    public final Field f25078b;

    /* renamed from: c */
    public final String f25079c;

    /* renamed from: d */
    public final boolean f25080d;

    /* renamed from: e */
    public final boolean f25081e;

    /* renamed from: f */
    public final /* synthetic */ boolean f25082f;

    /* renamed from: g */
    public final /* synthetic */ Method f25083g;

    /* renamed from: h */
    public final /* synthetic */ boolean f25084h;

    /* renamed from: i */
    public final /* synthetic */ TypeAdapter f25085i;

    /* renamed from: j */
    public final /* synthetic */ Gson f25086j;

    /* renamed from: k */
    public final /* synthetic */ TypeToken f25087k;

    /* renamed from: l */
    public final /* synthetic */ boolean f25088l;

    /* renamed from: m */
    public final /* synthetic */ boolean f25089m;

    public p92(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z5, boolean z6) {
        this.f25082f = z3;
        this.f25083g = method;
        this.f25084h = z4;
        this.f25085i = typeAdapter;
        this.f25086j = gson;
        this.f25087k = typeToken;
        this.f25088l = z5;
        this.f25089m = z6;
        this.f25077a = str;
        this.f25078b = field;
        this.f25079c = field.getName();
        this.f25080d = z;
        this.f25081e = z2;
    }

    /* renamed from: a */
    public final void m6893a(JsonWriter jsonWriter, Object obj) {
        Object obj2;
        if (!this.f25080d) {
            return;
        }
        boolean z = this.f25082f;
        Field field = this.f25078b;
        Method method = this.f25083g;
        if (z) {
            if (method == null) {
                ReflectiveTypeAdapterFactory.m4438a(field, obj);
            } else {
                ReflectiveTypeAdapterFactory.m4438a(method, obj);
            }
        }
        if (method != null) {
            try {
                obj2 = method.invoke(obj, null);
            } catch (InvocationTargetException e) {
                throw new JsonIOException(ye0.m8296p("Accessor ", ReflectionHelper.getAccessibleObjectDescription(method, false), " threw exception"), e.getCause());
            }
        } else {
            obj2 = field.get(obj);
        }
        if (obj2 == obj) {
            return;
        }
        jsonWriter.name(this.f25077a);
        boolean z2 = this.f25084h;
        TypeAdapter typeAdapter = this.f25085i;
        if (!z2) {
            typeAdapter = new C1060d(this.f25086j, typeAdapter, this.f25087k.getType());
        }
        typeAdapter.write(jsonWriter, obj2);
    }
}
