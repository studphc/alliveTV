package p000;

import com.google.common.hash.Funnels;
import java.io.Serializable;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class aw0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final String f7762a;

    public aw0(Charset charset) {
        this.f7762a = charset.name();
    }

    private Object readResolve() {
        return Funnels.stringFunnel(Charset.forName(this.f7762a));
    }
}
