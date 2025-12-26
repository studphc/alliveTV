package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import p000.C0556bg;

/* loaded from: classes.dex */
public final class BaseUrlExclusionList {

    /* renamed from: a */
    public final HashMap f11208a;

    /* renamed from: b */
    public final HashMap f11209b;

    /* renamed from: c */
    public final HashMap f11210c;

    /* renamed from: d */
    public final Random f11211d;

    public BaseUrlExclusionList() {
        Random random = new Random();
        this.f11210c = new HashMap();
        this.f11211d = random;
        this.f11208a = new HashMap();
        this.f11209b = new HashMap();
    }

    /* renamed from: a */
    public static void m2771a(Object obj, long j, HashMap hashMap) {
        if (hashMap.containsKey(obj)) {
            j = Math.max(j, ((Long) Util.castNonNull((Long) hashMap.get(obj))).longValue());
        }
        hashMap.put(obj, Long.valueOf(j));
    }

    /* renamed from: c */
    public static void m2772c(long j, HashMap hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.remove(arrayList.get(i));
        }
    }

    public static int getPriorityCount(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Integer.valueOf(list.get(i).priority));
        }
        return hashSet.size();
    }

    /* renamed from: b */
    public final ArrayList m2773b(List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashMap hashMap = this.f11208a;
        m2772c(elapsedRealtime, hashMap);
        HashMap hashMap2 = this.f11209b;
        m2772c(elapsedRealtime, hashMap2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            BaseUrl baseUrl = (BaseUrl) list.get(i);
            if (!hashMap.containsKey(baseUrl.serviceLocation) && !hashMap2.containsKey(Integer.valueOf(baseUrl.priority))) {
                arrayList.add(baseUrl);
            }
        }
        return arrayList;
    }

    public void exclude(BaseUrl baseUrl, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        m2771a(baseUrl.serviceLocation, elapsedRealtime, this.f11208a);
        int i = baseUrl.priority;
        if (i != Integer.MIN_VALUE) {
            m2771a(Integer.valueOf(i), elapsedRealtime, this.f11209b);
        }
    }

    public int getPriorityCountAfterExclusion(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        ArrayList m2773b = m2773b(list);
        for (int i = 0; i < m2773b.size(); i++) {
            hashSet.add(Integer.valueOf(((BaseUrl) m2773b.get(i)).priority));
        }
        return hashSet.size();
    }

    public void reset() {
        this.f11208a.clear();
        this.f11209b.clear();
        this.f11210c.clear();
    }

    @Nullable
    public BaseUrl selectBaseUrl(List<BaseUrl> list) {
        ArrayList m2773b = m2773b(list);
        if (m2773b.size() < 2) {
            return (BaseUrl) Iterables.getFirst(m2773b, null);
        }
        Collections.sort(m2773b, new C0556bg(1));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = ((BaseUrl) m2773b.get(0)).priority;
        int i3 = 0;
        while (true) {
            if (i3 >= m2773b.size()) {
                break;
            }
            BaseUrl baseUrl = (BaseUrl) m2773b.get(i3);
            if (i2 != baseUrl.priority) {
                if (arrayList.size() == 1) {
                    return (BaseUrl) m2773b.get(0);
                }
            } else {
                arrayList.add(new Pair(baseUrl.serviceLocation, Integer.valueOf(baseUrl.weight)));
                i3++;
            }
        }
        HashMap hashMap = this.f11210c;
        BaseUrl baseUrl2 = (BaseUrl) hashMap.get(arrayList);
        if (baseUrl2 == null) {
            List subList = m2773b.subList(0, arrayList.size());
            int i4 = 0;
            for (int i5 = 0; i5 < subList.size(); i5++) {
                i4 += ((BaseUrl) subList.get(i5)).weight;
            }
            int nextInt = this.f11211d.nextInt(i4);
            int i6 = 0;
            while (true) {
                if (i < subList.size()) {
                    BaseUrl baseUrl3 = (BaseUrl) subList.get(i);
                    i6 += baseUrl3.weight;
                    if (nextInt < i6) {
                        baseUrl2 = baseUrl3;
                        break;
                    }
                    i++;
                } else {
                    baseUrl2 = (BaseUrl) Iterables.getLast(subList);
                    break;
                }
            }
            hashMap.put(arrayList, baseUrl2);
        }
        return baseUrl2;
    }
}
