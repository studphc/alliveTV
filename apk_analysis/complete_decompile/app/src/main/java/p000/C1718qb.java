package p000;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: qb */
/* loaded from: classes2.dex */
public final class C1718qb implements TypeAdapterFactory {

    /* renamed from: a */
    public final /* synthetic */ int f25501a;

    public /* synthetic */ C1718qb(int i) {
        this.f25501a = i;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        switch (this.f25501a) {
            case 0:
                Type type = typeToken.getType();
                if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
                return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
            case 1:
                if (typeToken.getRawType() == Date.class) {
                    return new DateTypeAdapter();
                }
                return null;
            case 2:
                if (typeToken.getRawType() == java.sql.Date.class) {
                    return new fm2(0);
                }
                return null;
            case 3:
                if (typeToken.getRawType() == Time.class) {
                    return new fm2(1);
                }
                return null;
            case 4:
                if (typeToken.getRawType() == Timestamp.class) {
                    return new gm2(gson.getAdapter(Date.class));
                }
                return null;
            default:
                Class rawType = typeToken.getRawType();
                if (Enum.class.isAssignableFrom(rawType) && rawType != Enum.class) {
                    if (!rawType.isEnum()) {
                        rawType = rawType.getSuperclass();
                    }
                    return new ox2(rawType);
                }
                return null;
        }
    }
}
