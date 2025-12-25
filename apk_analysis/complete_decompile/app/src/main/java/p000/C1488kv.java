package p000;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;

/* renamed from: kv */
/* loaded from: classes2.dex */
public final class C1488kv implements ObjectConstructor {

    /* renamed from: a */
    public final /* synthetic */ int f22211a;

    /* renamed from: b */
    public final /* synthetic */ Type f22212b;

    public /* synthetic */ C1488kv(Type type, int i) {
        this.f22211a = i;
        this.f22212b = type;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f22211a) {
            case 0:
                Type type = this.f22212b;
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        return EnumSet.noneOf((Class) type2);
                    }
                    throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                }
                throw new JsonIOException("Invalid EnumSet type: " + type.toString());
            default:
                Type type3 = this.f22212b;
                if (type3 instanceof ParameterizedType) {
                    Type type4 = ((ParameterizedType) type3).getActualTypeArguments()[0];
                    if (type4 instanceof Class) {
                        return new EnumMap((Class) type4);
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type3.toString());
                }
                throw new JsonIOException("Invalid EnumMap type: " + type3.toString());
        }
    }
}
