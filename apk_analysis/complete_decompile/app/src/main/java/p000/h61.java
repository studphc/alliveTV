package p000;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class h61 extends AbstractC1205fr implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Pattern f17953a;

    public h61(Pattern pattern) {
        this.f17953a = (Pattern) Preconditions.checkNotNull(pattern);
    }

    public final String toString() {
        return this.f17953a.toString();
    }
}
