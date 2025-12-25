package p000;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.DisposableHandle;

/* renamed from: de */
/* loaded from: classes2.dex */
public final class C1119de extends CancelHandler {

    /* renamed from: a */
    public final C0590ce[] f16349a;

    public C1119de(C0590ce[] c0590ceArr) {
        this.f16349a = c0590ceArr;
    }

    /* renamed from: a */
    public final void m4572a() {
        for (C0590ce c0590ce : this.f16349a) {
            DisposableHandle disposableHandle = c0590ce.f8343e;
            if (disposableHandle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handle");
                disposableHandle = null;
            }
            disposableHandle.dispose();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        m4572a();
        return Unit.INSTANCE;
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f16349a + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        m4572a();
    }
}
