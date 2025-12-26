package p000;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class tw2 {

    /* renamed from: a */
    public final Object f27008a;

    /* renamed from: b */
    public final Iterator f27009b;

    public tw2(Iterator it, Object obj) {
        this.f27008a = Preconditions.checkNotNull(obj);
        this.f27009b = (Iterator) Preconditions.checkNotNull(it);
    }
}
