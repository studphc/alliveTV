package p000;

import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final /* synthetic */ class do2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16461a;

    /* renamed from: b */
    public final /* synthetic */ Object f16462b;

    public /* synthetic */ do2(int i, Object obj) {
        this.f16461a = i;
        this.f16462b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f16462b;
        switch (this.f16461a) {
            case 0:
                ((eo2) obj).m4739c();
                return;
            case 1:
                int i = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                ((StyledPlayerControlView) obj).m2935j();
                return;
            default:
                ((Function0) obj).invoke();
                return;
        }
    }
}
