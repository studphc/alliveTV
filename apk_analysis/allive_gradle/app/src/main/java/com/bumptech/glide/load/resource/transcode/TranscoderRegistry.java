package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.kv2;

/* loaded from: classes.dex */
public class TranscoderRegistry {

    /* renamed from: a */
    public final ArrayList f8963a = new ArrayList();

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> get(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        boolean z;
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.get();
        }
        Iterator it = this.f8963a.iterator();
        while (it.hasNext()) {
            kv2 kv2Var = (kv2) it.next();
            if (kv2Var.f22218a.isAssignableFrom(cls) && cls2.isAssignableFrom(kv2Var.f22219b)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return kv2Var.f22220c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f8963a.iterator();
        while (it.hasNext()) {
            kv2 kv2Var = (kv2) it.next();
            if (kv2Var.f22218a.isAssignableFrom(cls) && cls2.isAssignableFrom(kv2Var.f22219b)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void register(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f8963a.add(new kv2(cls, cls2, resourceTranscoder));
    }
}
