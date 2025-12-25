package p000;

import com.google.gson.internal.UnsafeAllocator;

/* loaded from: classes2.dex */
public final class m03 extends UnsafeAllocator {
    @Override // com.google.gson.internal.UnsafeAllocator
    public final Object newInstance(Class cls) {
        throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
    }
}
