package p000;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public final class uw2 implements TypeAdapterFactory {

    /* renamed from: a */
    public final TypeToken f27507a;

    /* renamed from: b */
    public final boolean f27508b;

    /* renamed from: c */
    public final Class f27509c;

    /* renamed from: d */
    public final JsonSerializer f27510d;

    /* renamed from: e */
    public final JsonDeserializer f27511e;

    public uw2(Object obj, TypeToken typeToken, boolean z, Class cls) {
        JsonSerializer jsonSerializer;
        boolean z2;
        if (obj instanceof JsonSerializer) {
            jsonSerializer = (JsonSerializer) obj;
        } else {
            jsonSerializer = null;
        }
        this.f27510d = jsonSerializer;
        JsonDeserializer jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
        this.f27511e = jsonDeserializer;
        if (jsonSerializer == null && jsonDeserializer == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        C$Gson$Preconditions.checkArgument(z2);
        this.f27507a = typeToken;
        this.f27508b = z;
        this.f27509c = cls;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        boolean isAssignableFrom;
        TypeToken typeToken2 = this.f27507a;
        if (typeToken2 != null) {
            if (!typeToken2.equals(typeToken) && (!this.f27508b || typeToken2.getType() != typeToken.getRawType())) {
                isAssignableFrom = false;
            } else {
                isAssignableFrom = true;
            }
        } else {
            isAssignableFrom = this.f27509c.isAssignableFrom(typeToken.getRawType());
        }
        if (isAssignableFrom) {
            return new TreeTypeAdapter(this.f27510d, this.f27511e, gson, typeToken, this);
        }
        return null;
    }
}
