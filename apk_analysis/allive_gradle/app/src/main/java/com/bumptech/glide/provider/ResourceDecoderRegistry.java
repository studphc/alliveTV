package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p000.ub2;

/* loaded from: classes.dex */
public class ResourceDecoderRegistry {

    /* renamed from: a */
    public final ArrayList f9005a = new ArrayList();

    /* renamed from: b */
    public final HashMap f9006b = new HashMap();

    /* renamed from: a */
    public final synchronized List m2378a(String str) {
        List list;
        try {
            if (!this.f9005a.contains(str)) {
                this.f9005a.add(str);
            }
            list = (List) this.f9006b.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f9006b.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized <T, R> void append(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m2378a(str).add(new ub2(cls, cls2, resourceDecoder));
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        boolean z;
        arrayList = new ArrayList();
        Iterator it = this.f9005a.iterator();
        while (it.hasNext()) {
            List<ub2> list = (List) this.f9006b.get((String) it.next());
            if (list != null) {
                for (ub2 ub2Var : list) {
                    if (ub2Var.f27189a.isAssignableFrom(cls) && cls2.isAssignableFrom(ub2Var.f27190b)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(ub2Var.f27191c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> getResourceClasses(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        boolean z;
        arrayList = new ArrayList();
        Iterator it = this.f9005a.iterator();
        while (it.hasNext()) {
            List<ub2> list = (List) this.f9006b.get((String) it.next());
            if (list != null) {
                for (ub2 ub2Var : list) {
                    if (ub2Var.f27189a.isAssignableFrom(cls) && cls2.isAssignableFrom(ub2Var.f27190b)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !arrayList.contains(ub2Var.f27190b)) {
                        arrayList.add(ub2Var.f27190b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void prepend(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m2378a(str).add(0, new ub2(cls, cls2, resourceDecoder));
    }

    public synchronized void setBucketPriorityList(@NonNull List<String> list) {
        try {
            ArrayList arrayList = new ArrayList(this.f9005a);
            this.f9005a.clear();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f9005a.add(it.next());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (!list.contains(str)) {
                    this.f9005a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
