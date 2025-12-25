package androidx.core.os;

import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5569d2 = {"<anonymous>", "", "run"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n*L\n1#1,69:1\n*E\n"})
/* loaded from: classes.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Function0 f3709a;

    public HandlerKt$postDelayed$runnable$1(Function0<Unit> function0) {
        this.f3709a = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3709a.invoke();
    }
}
