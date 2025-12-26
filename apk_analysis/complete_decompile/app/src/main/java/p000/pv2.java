package p000;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final /* synthetic */ class pv2 implements Observer, FunctionAdapter {

    /* renamed from: a */
    public final /* synthetic */ Lambda f25319a;

    /* JADX WARN: Multi-variable type inference failed */
    public pv2(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f25319a = (Lambda) function;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual(this.f25319a, ((FunctionAdapter) obj).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f25319a;
    }

    public final int hashCode() {
        return this.f25319a.hashCode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.f25319a.invoke(obj);
    }
}
