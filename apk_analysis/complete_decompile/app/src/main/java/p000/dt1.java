package p000;

import com.google.gson.Gson;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public final class dt1 implements TypeAdapterFactory {

    /* renamed from: a */
    public final /* synthetic */ int f16536a;

    /* renamed from: b */
    public final /* synthetic */ Object f16537b;

    public /* synthetic */ dt1(int i, Object obj) {
        this.f16536a = i;
        this.f16537b = obj;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        switch (this.f16536a) {
            case 0:
                if (typeToken.getRawType() == Number.class) {
                    return (NumberTypeAdapter) this.f16537b;
                }
                return null;
            default:
                if (typeToken.getRawType() == Object.class) {
                    return new ObjectTypeAdapter(gson, (ToNumberStrategy) this.f16537b);
                }
                return null;
        }
    }
}
