package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import p000.vb2;

/* loaded from: classes.dex */
public class ResourceEncoderRegistry {

    /* renamed from: a */
    public final ArrayList f9007a = new ArrayList();

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f9007a.add(new vb2(cls, resourceEncoder));
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> cls) {
        int size = this.f9007a.size();
        for (int i = 0; i < size; i++) {
            vb2 vb2Var = (vb2) this.f9007a.get(i);
            if (vb2Var.f27732a.isAssignableFrom(cls)) {
                return vb2Var.f27733b;
            }
        }
        return null;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f9007a.add(0, new vb2(cls, resourceEncoder));
    }
}
