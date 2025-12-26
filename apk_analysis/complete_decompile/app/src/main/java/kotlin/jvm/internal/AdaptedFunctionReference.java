package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
import p000.ye0;

@SinceKotlin(version = "1.4")
/* loaded from: classes2.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {

    /* renamed from: a */
    public final Class f21153a;

    /* renamed from: b */
    public final String f21154b;

    /* renamed from: c */
    public final String f21155c;

    /* renamed from: d */
    public final boolean f21156d;

    /* renamed from: e */
    public final int f21157e;

    /* renamed from: f */
    public final int f21158f;
    protected final Object receiver;

    public AdaptedFunctionReference(int i, Class cls, String str, String str2, int i2) {
        this(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.f21156d == adaptedFunctionReference.f21156d && this.f21157e == adaptedFunctionReference.f21157e && this.f21158f == adaptedFunctionReference.f21158f && Intrinsics.areEqual(this.receiver, adaptedFunctionReference.receiver) && Intrinsics.areEqual(this.f21153a, adaptedFunctionReference.f21153a) && this.f21154b.equals(adaptedFunctionReference.f21154b) && this.f21155c.equals(adaptedFunctionReference.f21155c)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f21157e;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.f21153a;
        if (cls == null) {
            return null;
        }
        if (this.f21156d) {
            return Reflection.getOrCreateKotlinPackage(cls);
        }
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        int i;
        int i2;
        Object obj = this.receiver;
        int i3 = 0;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        Class cls = this.f21153a;
        if (cls != null) {
            i3 = cls.hashCode();
        }
        int m8286f = ye0.m8286f(ye0.m8286f((i4 + i3) * 31, 31, this.f21154b), 31, this.f21155c);
        if (this.f21156d) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        return ((((m8286f + i2) * 31) + this.f21157e) * 31) + this.f21158f;
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }

    public AdaptedFunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.receiver = obj;
        this.f21153a = cls;
        this.f21154b = str;
        this.f21155c = str2;
        this.f21156d = (i2 & 1) == 1;
        this.f21157e = i;
        this.f21158f = i2 >> 1;
    }
}
