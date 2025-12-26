package p000;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import java.util.Collection;

/* loaded from: classes.dex */
public final class cq2 extends CacheLoader {
    @Override // com.google.common.cache.CacheLoader
    public final Object load(Object obj) {
        return ImmutableSet.copyOf((Collection) TypeToken.m4293of((Class) obj).getTypes().rawTypes());
    }
}
