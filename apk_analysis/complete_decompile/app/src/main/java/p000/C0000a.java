package p000;

import com.google.gson.internal.C$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.HttpUrl;

/* renamed from: a */
/* loaded from: classes2.dex */
public final class C0000a implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Type f0a;

    public C0000a(Type type) {
        Objects.requireNonNull(type);
        this.f0a = C$Gson$Types.canonicalize(type);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f0a;
    }

    public final int hashCode() {
        return this.f0a.hashCode();
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.f0a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
