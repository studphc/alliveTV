package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000.o81;
import p000.tr1;
import p000.ur1;

/* loaded from: classes.dex */
public class NotificationChannelGroupCompat {

    /* renamed from: a */
    public final String f3306a;

    /* renamed from: b */
    public CharSequence f3307b;

    /* renamed from: c */
    public String f3308c;

    /* renamed from: d */
    public final boolean f3309d;

    /* renamed from: e */
    public final List f3310e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final NotificationChannelGroupCompat f3311a;

        public Builder(@NonNull String str) {
            this.f3311a = new NotificationChannelGroupCompat(str);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.f3311a;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.f3311a.f3308c = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f3311a.f3307b = charSequence;
            return this;
        }
    }

    public NotificationChannelGroupCompat(String str) {
        this.f3310e = Collections.emptyList();
        this.f3306a = (String) Preconditions.checkNotNull(str);
    }

    /* renamed from: a */
    public final ArrayList m693a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NotificationChannel m6499d = o81.m6499d(it.next());
            if (this.f3306a.equals(tr1.m7507c(m6499d))) {
                arrayList.add(new NotificationChannelCompat(m6499d));
            }
        }
        return arrayList;
    }

    @NonNull
    public List<NotificationChannelCompat> getChannels() {
        return this.f3310e;
    }

    @Nullable
    public String getDescription() {
        return this.f3308c;
    }

    @NonNull
    public String getId() {
        return this.f3306a;
    }

    @Nullable
    public CharSequence getName() {
        return this.f3307b;
    }

    public boolean isBlocked() {
        return this.f3309d;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.f3306a).setName(this.f3307b).setDescription(this.f3308c);
    }

    public NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    public NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup, List list) {
        this(tr1.m7508d(notificationChannelGroup));
        this.f3307b = tr1.m7509e(notificationChannelGroup);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f3308c = ur1.m7762a(notificationChannelGroup);
        }
        if (i >= 28) {
            this.f3309d = ur1.m7763b(notificationChannelGroup);
            this.f3310e = m693a(tr1.m7506b(notificationChannelGroup));
        } else {
            this.f3310e = m693a(list);
        }
    }
}
