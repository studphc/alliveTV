package p000;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import kotlin.UNINITIALIZED_VALUE;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class zd2 implements Lazy, Serializable {

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater f29323c;

    /* renamed from: a */
    public volatile Function0 f29324a;

    /* renamed from: b */
    public volatile Object f29325b;

    static {
        final DefaultConstructorMarker defaultConstructorMarker = null;
        new Object(defaultConstructorMarker) { // from class: kotlin.SafePublicationLazyImpl$Companion
        };
        f29323c = AtomicReferenceFieldUpdater.newUpdater(zd2.class, Object.class, "b");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj = this.f29325b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        if (obj != uninitialized_value) {
            return obj;
        }
        Function0 function0 = this.f29324a;
        if (function0 != null) {
            Object invoke = function0.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29323c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, uninitialized_value, invoke)) {
                if (atomicReferenceFieldUpdater.get(this) != uninitialized_value) {
                }
            }
            this.f29324a = null;
            return invoke;
        }
        return this.f29325b;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f29325b != UNINITIALIZED_VALUE.INSTANCE) {
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
