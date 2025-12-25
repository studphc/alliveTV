package com.google.common.eventbus;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class DeadEvent {

    /* renamed from: a */
    public final Object f15019a;

    /* renamed from: b */
    public final Object f15020b;

    public DeadEvent(Object obj, Object obj2) {
        this.f15019a = Preconditions.checkNotNull(obj);
        this.f15020b = Preconditions.checkNotNull(obj2);
    }

    public Object getEvent() {
        return this.f15020b;
    }

    public Object getSource() {
        return this.f15019a;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(FirebaseAnalytics.Param.SOURCE, this.f15019a).add(NotificationCompat.CATEGORY_EVENT, this.f15020b).toString();
    }
}
