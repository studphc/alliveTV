package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class iz2 implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Type f20322a;

    /* renamed from: b */
    public final ImmutableList f20323b;

    /* renamed from: c */
    public final Class f20324c;

    public iz2(Type type, Class cls, Type[] typeArr) {
        boolean z;
        Preconditions.checkNotNull(cls);
        if (typeArr.length == cls.getTypeParameters().length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        mz2.m6265b(typeArr, "type parameter");
        this.f20322a = type;
        this.f20324c = cls;
        this.f20323b = gz2.f17893c.m5028c(typeArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        if (!this.f20324c.equals(parameterizedType.getRawType())) {
            return false;
        }
        if (!Objects.equal(this.f20322a, parameterizedType.getOwnerType()) || !Arrays.equals(mz2.m6266c(this.f20323b), parameterizedType.getActualTypeArguments())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return mz2.m6266c(this.f20323b);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f20322a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f20324c;
    }

    public final int hashCode() {
        int hashCode;
        Type type = this.f20322a;
        if (type == null) {
            hashCode = 0;
        } else {
            hashCode = type.hashCode();
        }
        return (hashCode ^ this.f20323b.hashCode()) ^ this.f20324c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Type type = this.f20322a;
        if (type != null) {
            gz2 gz2Var = gz2.f17893c;
            gz2Var.getClass();
            if (!(gz2Var instanceof ez2)) {
                sb.append(gz2Var.mo4650b(type));
                sb.append('.');
            }
        }
        sb.append(this.f20324c.getName());
        sb.append(Typography.less);
        Joiner joiner = mz2.f23181a;
        gz2 gz2Var2 = gz2.f17893c;
        java.util.Objects.requireNonNull(gz2Var2);
        sb.append(joiner.join(Iterables.transform(this.f20323b, new z90(3, gz2Var2))));
        sb.append(Typography.greater);
        return sb.toString();
    }
}
