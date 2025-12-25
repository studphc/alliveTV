package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KFunction;

@SinceKotlin(version = "1.7")
/* loaded from: classes2.dex */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {

    /* renamed from: h */
    public final Class f21174h;

    public FunInterfaceConstructorReference(Class cls) {
        super(1);
        this.f21174h = cls;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FunInterfaceConstructorReference)) {
            return false;
        }
        return this.f21174h.equals(((FunInterfaceConstructorReference) obj).f21174h);
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.f21174h.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return "fun interface ".concat(this.f21174h.getName());
    }

    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
