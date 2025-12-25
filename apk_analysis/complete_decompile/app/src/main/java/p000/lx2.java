package p000;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public final class lx2 implements TypeAdapterFactory {

    /* renamed from: a */
    public final /* synthetic */ int f22707a;

    /* renamed from: b */
    public final /* synthetic */ Class f22708b;

    /* renamed from: c */
    public final /* synthetic */ Class f22709c;

    /* renamed from: d */
    public final /* synthetic */ TypeAdapter f22710d;

    public /* synthetic */ lx2(Class cls, Class cls2, TypeAdapter typeAdapter, int i) {
        this.f22707a = i;
        this.f22708b = cls;
        this.f22709c = cls2;
        this.f22710d = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        switch (this.f22707a) {
            case 0:
                Class rawType = typeToken.getRawType();
                if (rawType != this.f22708b && rawType != this.f22709c) {
                    return null;
                }
                return this.f22710d;
            default:
                Class rawType2 = typeToken.getRawType();
                if (rawType2 != this.f22708b && rawType2 != this.f22709c) {
                    return null;
                }
                return this.f22710d;
        }
    }

    public final String toString() {
        switch (this.f22707a) {
            case 0:
                return "Factory[type=" + this.f22709c.getName() + "+" + this.f22708b.getName() + ",adapter=" + this.f22710d + "]";
            default:
                return "Factory[type=" + this.f22708b.getName() + "+" + this.f22709c.getName() + ",adapter=" + this.f22710d + "]";
        }
    }
}
