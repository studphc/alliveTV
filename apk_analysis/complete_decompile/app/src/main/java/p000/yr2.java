package p000;

import java.io.Serializable;
import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import kotlin.UNINITIALIZED_VALUE;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class yr2 implements Lazy, Serializable {

    /* renamed from: a */
    public Function0 f29112a;

    /* renamed from: b */
    public volatile Object f29113b;

    /* renamed from: c */
    public final Object f29114c;

    public yr2(Object obj, Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.f29112a = initializer;
        this.f29113b = UNINITIALIZED_VALUE.INSTANCE;
        this.f29114c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj;
        Object obj2 = this.f29113b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        if (obj2 != uninitialized_value) {
            return obj2;
        }
        synchronized (this.f29114c) {
            obj = this.f29113b;
            if (obj == uninitialized_value) {
                Function0 function0 = this.f29112a;
                Intrinsics.checkNotNull(function0);
                obj = function0.invoke();
                this.f29113b = obj;
                this.f29112a = null;
            }
        }
        return obj;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f29113b != UNINITIALIZED_VALUE.INSTANCE) {
            return true;
        }
        return false;
    }

    public final String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
