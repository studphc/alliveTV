package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import p000.y80;

/* loaded from: classes.dex */
public class EncoderRegistry {

    /* renamed from: a */
    public final ArrayList f8998a = new ArrayList();

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f8998a.add(new y80(cls, encoder));
    }

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        Iterator it = this.f8998a.iterator();
        while (it.hasNext()) {
            y80 y80Var = (y80) it.next();
            if (y80Var.f28861a.isAssignableFrom(cls)) {
                return y80Var.f28862b;
            }
        }
        return null;
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f8998a.add(0, new y80(cls, encoder));
    }
}
