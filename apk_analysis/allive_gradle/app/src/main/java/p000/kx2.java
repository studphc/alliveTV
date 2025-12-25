package p000;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public final class kx2 implements TypeAdapterFactory {

    /* renamed from: a */
    public final /* synthetic */ int f22243a;

    /* renamed from: b */
    public final /* synthetic */ Object f22244b;

    /* renamed from: c */
    public final /* synthetic */ TypeAdapter f22245c;

    public /* synthetic */ kx2(Object obj, TypeAdapter typeAdapter, int i) {
        this.f22243a = i;
        this.f22244b = obj;
        this.f22245c = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        switch (this.f22243a) {
            case 0:
                if (typeToken.getRawType() == ((Class) this.f22244b)) {
                    return this.f22245c;
                }
                return null;
            case 1:
                Class<?> rawType = typeToken.getRawType();
                if (!((Class) this.f22244b).isAssignableFrom(rawType)) {
                    return null;
                }
                return new C2028yp(this, rawType);
            default:
                if (typeToken.equals((TypeToken) this.f22244b)) {
                    return this.f22245c;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f22243a) {
            case 0:
                return "Factory[type=" + ((Class) this.f22244b).getName() + ",adapter=" + this.f22245c + "]";
            case 1:
                return "Factory[typeHierarchy=" + ((Class) this.f22244b).getName() + ",adapter=" + this.f22245c + "]";
            default:
                return super.toString();
        }
    }
}
