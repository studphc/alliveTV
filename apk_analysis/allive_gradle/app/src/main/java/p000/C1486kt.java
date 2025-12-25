package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;

/* renamed from: kt */
/* loaded from: classes2.dex */
public final class C1486kt {

    /* renamed from: a */
    public final Object f22186a;

    /* renamed from: b */
    public final CancelHandler f22187b;

    /* renamed from: c */
    public final Function1 f22188c;

    /* renamed from: d */
    public final Object f22189d;

    /* renamed from: e */
    public final Throwable f22190e;

    public C1486kt(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th) {
        this.f22186a = obj;
        this.f22187b = cancelHandler;
        this.f22188c = function1;
        this.f22189d = obj2;
        this.f22190e = th;
    }

    /* renamed from: a */
    public static C1486kt m5788a(C1486kt c1486kt, CancelHandler cancelHandler, Throwable th, int i) {
        Object obj = c1486kt.f22186a;
        if ((i & 2) != 0) {
            cancelHandler = c1486kt.f22187b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        Function1 function1 = c1486kt.f22188c;
        Object obj2 = c1486kt.f22189d;
        if ((i & 16) != 0) {
            th = c1486kt.f22190e;
        }
        c1486kt.getClass();
        return new C1486kt(obj, cancelHandler2, function1, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1486kt)) {
            return false;
        }
        C1486kt c1486kt = (C1486kt) obj;
        if (Intrinsics.areEqual(this.f22186a, c1486kt.f22186a) && Intrinsics.areEqual(this.f22187b, c1486kt.f22187b) && Intrinsics.areEqual(this.f22188c, c1486kt.f22188c) && Intrinsics.areEqual(this.f22189d, c1486kt.f22189d) && Intrinsics.areEqual(this.f22190e, c1486kt.f22190e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i = 0;
        Object obj = this.f22186a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i2 = hashCode * 31;
        CancelHandler cancelHandler = this.f22187b;
        if (cancelHandler == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = cancelHandler.hashCode();
        }
        int i3 = (i2 + hashCode2) * 31;
        Function1 function1 = this.f22188c;
        if (function1 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = function1.hashCode();
        }
        int i4 = (i3 + hashCode3) * 31;
        Object obj2 = this.f22189d;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int i5 = (i4 + hashCode4) * 31;
        Throwable th = this.f22190e;
        if (th != null) {
            i = th.hashCode();
        }
        return i5 + i;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f22186a + ", cancelHandler=" + this.f22187b + ", onCancellation=" + this.f22188c + ", idempotentResume=" + this.f22189d + ", cancelCause=" + this.f22190e + ')';
    }

    public /* synthetic */ C1486kt(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
