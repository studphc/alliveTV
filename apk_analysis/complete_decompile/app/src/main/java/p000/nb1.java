package p000;

import com.google.common.cache.CacheLoader;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class nb1 extends CacheLoader {

    /* renamed from: a */
    public final /* synthetic */ Callable f23319a;

    public nb1(Callable callable) {
        this.f23319a = callable;
    }

    @Override // com.google.common.cache.CacheLoader
    public final Object load(Object obj) {
        return this.f23319a.call();
    }
}
