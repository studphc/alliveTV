package com.bumptech.glide;

/* loaded from: classes.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);


    /* renamed from: a */
    public final float f8504a;

    MemoryCategory(float f) {
        this.f8504a = f;
    }

    public float getMultiplier() {
        return this.f8504a;
    }
}
