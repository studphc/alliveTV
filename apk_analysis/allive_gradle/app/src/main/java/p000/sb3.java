package p000;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public final class sb3 implements Runnable {

    /* renamed from: a */
    public final rb3 f26360a;

    /* renamed from: b */
    public final int f26361b;

    /* renamed from: c */
    public final IOException f26362c;

    /* renamed from: d */
    public final byte[] f26363d;

    /* renamed from: e */
    public final String f26364e;

    /* renamed from: f */
    public final Map f26365f;

    public /* synthetic */ sb3(String str, rb3 rb3Var, int i, IOException iOException, byte[] bArr, Map map) {
        Preconditions.checkNotNull(rb3Var);
        this.f26360a = rb3Var;
        this.f26361b = i;
        this.f26362c = iOException;
        this.f26363d = bArr;
        this.f26364e = str;
        this.f26365f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26360a.zza(this.f26364e, this.f26361b, this.f26362c, this.f26363d, this.f26365f);
    }
}
