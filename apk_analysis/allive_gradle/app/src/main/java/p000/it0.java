package p000;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class it0 extends kt0 {

    /* renamed from: a */
    public final /* synthetic */ Function f20251a;

    /* renamed from: b */
    public final /* synthetic */ AtomicReference f20252b;

    /* renamed from: c */
    public final /* synthetic */ ActivityResultContract f20253c;

    /* renamed from: d */
    public final /* synthetic */ ActivityResultCallback f20254d;

    /* renamed from: e */
    public final /* synthetic */ Fragment f20255e;

    public it0(Fragment fragment, Function function, AtomicReference atomicReference, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        this.f20255e = fragment;
        this.f20251a = function;
        this.f20252b = atomicReference;
        this.f20253c = activityResultContract;
        this.f20254d = activityResultCallback;
    }

    @Override // p000.kt0
    /* renamed from: a */
    public final void mo4992a() {
        StringBuilder sb = new StringBuilder("fragment_");
        Fragment fragment = this.f20255e;
        sb.append(fragment.f4452f);
        sb.append("_rq#");
        sb.append(fragment.f4445a0.getAndIncrement());
        this.f20252b.set(((ActivityResultRegistry) this.f20251a.apply(null)).register(sb.toString(), fragment, this.f20253c, this.f20254d));
    }
}
