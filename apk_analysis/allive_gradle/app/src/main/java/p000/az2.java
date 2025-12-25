package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class az2 implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Type f7820a;

    public az2(Type type) {
        this.f7820a = gz2.f17893c.mo2180d(type);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return Objects.equal(this.f7820a, ((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f7820a;
    }

    public final int hashCode() {
        return this.f7820a.hashCode();
    }

    public final String toString() {
        String obj;
        Joiner joiner = mz2.f23181a;
        Type type = this.f7820a;
        if (type instanceof Class) {
            obj = ((Class) type).getName();
        } else {
            obj = type.toString();
        }
        return String.valueOf(obj).concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }
}
