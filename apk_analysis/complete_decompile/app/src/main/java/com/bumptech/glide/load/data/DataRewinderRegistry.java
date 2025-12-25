package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DataRewinderRegistry {

    /* renamed from: b */
    public static final C0606a f8641b = new Object();

    /* renamed from: a */
    public final HashMap f8642a = new HashMap();

    @NonNull
    public synchronized <T> DataRewinder<T> build(@NonNull T t) {
        DataRewinder.Factory factory;
        try {
            Preconditions.checkNotNull(t);
            factory = (DataRewinder.Factory) this.f8642a.get(t.getClass());
            if (factory == null) {
                Iterator it = this.f8642a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DataRewinder.Factory factory2 = (DataRewinder.Factory) it.next();
                    if (factory2.getDataClass().isAssignableFrom(t.getClass())) {
                        factory = factory2;
                        break;
                    }
                }
            }
            if (factory == null) {
                factory = f8641b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return factory.build(t);
    }

    public synchronized void register(@NonNull DataRewinder.Factory<?> factory) {
        this.f8642a.put(factory.getDataClass(), factory);
    }
}
