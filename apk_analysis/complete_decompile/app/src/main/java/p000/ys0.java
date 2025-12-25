package p000;

import android.content.Context;
import androidx.core.provider.AbstractC0193h;
import androidx.core.provider.FontRequest;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class ys0 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ String f29118a;

    /* renamed from: b */
    public final /* synthetic */ Context f29119b;

    /* renamed from: c */
    public final /* synthetic */ FontRequest f29120c;

    /* renamed from: d */
    public final /* synthetic */ int f29121d;

    public ys0(String str, Context context, FontRequest fontRequest, int i) {
        this.f29118a = str;
        this.f29119b = context;
        this.f29120c = fontRequest;
        this.f29121d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return AbstractC0193h.m884a(this.f29118a, this.f29119b, this.f29120c, this.f29121d);
    }
}
