package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p000.o81;
import p000.qs1;
import p000.rs1;
import p000.ss1;
import p000.tr1;
import p000.ts1;
import p000.ur1;
import p000.us1;
import p000.vs1;
import p000.ws1;
import p000.zs1;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;

    /* renamed from: d */
    public static String f3461d;

    /* renamed from: g */
    public static zs1 f3464g;

    /* renamed from: a */
    public final Context f3465a;

    /* renamed from: b */
    public final NotificationManager f3466b;

    /* renamed from: c */
    public static final Object f3460c = new Object();

    /* renamed from: e */
    public static HashSet f3462e = new HashSet();

    /* renamed from: f */
    public static final Object f3463f = new Object();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface InterruptionFilter {
    }

    public NotificationManagerCompat(Context context) {
        this.f3465a = context;
        this.f3466b = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        HashSet hashSet;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f3460c) {
            if (string != null) {
                try {
                    if (!string.equals(f3461d)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet2 = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet2.add(unflattenFromString.getPackageName());
                            }
                        }
                        f3462e = hashSet2;
                        f3461d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hashSet = f3462e;
        }
        return hashSet;
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return rs1.m7298a(this.f3466b);
        }
        Context context = this.f3465a;
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i), packageName)).intValue() != 0) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public boolean canUseFullScreenIntent() {
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            return true;
        }
        if (i < 34) {
            if (this.f3465a.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0) {
                return true;
            }
            return false;
        }
        return vs1.m7932a(this.f3466b);
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancelAll() {
        this.f3466b.cancelAll();
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            ss1.m7402a(this.f3466b, notificationChannel);
        }
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat notificationChannelGroupCompat) {
        NotificationChannelGroup notificationChannelGroup;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            notificationChannelGroupCompat.getClass();
            notificationChannelGroup = null;
        } else {
            NotificationChannelGroup m7505a = tr1.m7505a(notificationChannelGroupCompat.f3306a, notificationChannelGroupCompat.f3307b);
            if (i >= 28) {
                ur1.m7764c(m7505a, notificationChannelGroupCompat.f3308c);
            }
            notificationChannelGroup = m7505a;
        }
        createNotificationChannelGroup(notificationChannelGroup);
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            ss1.m7404c(this.f3466b, list);
        }
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> list) {
        NotificationChannelGroup notificationChannelGroup;
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelGroupCompat notificationChannelGroupCompat : list) {
                int i = Build.VERSION.SDK_INT;
                if (i < 26) {
                    notificationChannelGroupCompat.getClass();
                    notificationChannelGroup = null;
                } else {
                    NotificationChannelGroup m7505a = tr1.m7505a(notificationChannelGroupCompat.f3306a, notificationChannelGroupCompat.f3307b);
                    if (i >= 28) {
                        ur1.m7764c(m7505a, notificationChannelGroupCompat.f3308c);
                    }
                    notificationChannelGroup = m7505a;
                }
                arrayList.add(notificationChannelGroup);
            }
            ss1.m7404c(this.f3466b, arrayList);
        }
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            ss1.m7405d(this.f3466b, list);
        }
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<NotificationChannelCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m692a());
            }
            ss1.m7405d(this.f3466b, arrayList);
        }
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            ss1.m7406e(this.f3466b, str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            ss1.m7407f(this.f3466b, str);
        }
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = this.f3466b;
            Iterator<NotificationChannel> it = ss1.m7412k(notificationManager).iterator();
            while (it.hasNext()) {
                NotificationChannel m6499d = o81.m6499d(it.next());
                if (!collection.contains(ss1.m7408g(m6499d)) && (Build.VERSION.SDK_INT < 30 || !collection.contains(us1.m7766b(m6499d)))) {
                    ss1.m7406e(notificationManager, ss1.m7408g(m6499d));
                }
            }
        }
    }

    @NonNull
    public List<StatusBarNotification> getActiveNotifications() {
        return qs1.m7145a(this.f3466b);
    }

    public int getCurrentInterruptionFilter() {
        return qs1.m7146b(this.f3466b);
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return rs1.m7299b(this.f3466b);
        }
        return -1000;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ss1.m7410i(this.f3466b, str);
        }
        return null;
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String str) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return ts1.m7511a(this.f3466b, str);
        }
        if (i >= 26) {
            Iterator<NotificationChannelGroup> it = getNotificationChannelGroups().iterator();
            while (it.hasNext()) {
                NotificationChannelGroup m6500e = o81.m6500e(it.next());
                if (ss1.m7409h(m6500e).equals(str)) {
                    return m6500e;
                }
            }
        }
        return null;
    }

    @Nullable
    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(@NonNull String str) {
        NotificationChannelGroup notificationChannelGroup;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            NotificationChannelGroup notificationChannelGroup2 = getNotificationChannelGroup(str);
            if (notificationChannelGroup2 != null) {
                return new NotificationChannelGroupCompat(notificationChannelGroup2);
            }
            return null;
        }
        if (i >= 26 && (notificationChannelGroup = getNotificationChannelGroup(str)) != null) {
            return new NotificationChannelGroupCompat(notificationChannelGroup, getNotificationChannels());
        }
        return null;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ss1.m7411j(this.f3466b);
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        List<NotificationChannel> notificationChannels;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            List<NotificationChannelGroup> notificationChannelGroups = getNotificationChannelGroups();
            if (!notificationChannelGroups.isEmpty()) {
                if (i >= 28) {
                    notificationChannels = Collections.emptyList();
                } else {
                    notificationChannels = getNotificationChannels();
                }
                ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
                Iterator<NotificationChannelGroup> it = notificationChannelGroups.iterator();
                while (it.hasNext()) {
                    NotificationChannelGroup m6500e = o81.m6500e(it.next());
                    if (Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new NotificationChannelGroupCompat(m6500e));
                    } else {
                        arrayList.add(new NotificationChannelGroupCompat(m6500e, notificationChannels));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ss1.m7412k(this.f3466b);
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = getNotificationChannels();
            if (!notificationChannels.isEmpty()) {
                ArrayList arrayList = new ArrayList(notificationChannels.size());
                Iterator<NotificationChannel> it = notificationChannels.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NotificationChannelCompat(o81.m6499d(it.next())));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(int i, @NonNull Notification notification) {
        notify(null, i, notification);
    }

    public void cancel(@Nullable String str, int i) {
        this.f3466b.cancel(str, i);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@NonNull List<NotificationWithIdAndTag> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            NotificationWithIdAndTag notificationWithIdAndTag = list.get(i);
            notify(notificationWithIdAndTag.f3467a, notificationWithIdAndTag.f3468b, notificationWithIdAndTag.f3469c);
        }
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat notificationChannelCompat) {
        createNotificationChannel(notificationChannelCompat.m692a());
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return us1.m7765a(this.f3466b, str, str2);
        }
        return getNotificationChannel(str);
    }

    /* loaded from: classes.dex */
    public static class NotificationWithIdAndTag {

        /* renamed from: a */
        public final String f3467a;

        /* renamed from: b */
        public final int f3468b;

        /* renamed from: c */
        public final Notification f3469c;

        public NotificationWithIdAndTag(@Nullable String str, int i, @NonNull Notification notification) {
            this.f3467a = str;
            this.f3468b = i;
            this.f3469c = notification;
        }

        public NotificationWithIdAndTag(int i, @NonNull Notification notification) {
            this(null, i, notification);
        }
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String str, @NonNull String str2) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str, str2)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@Nullable String str, int i, @NonNull Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        NotificationManager notificationManager = this.f3466b;
        if (extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL)) {
            ws1 ws1Var = new ws1(this.f3465a.getPackageName(), i, str, notification);
            synchronized (f3463f) {
                try {
                    if (f3464g == null) {
                        f3464g = new zs1(this.f3465a.getApplicationContext());
                    }
                    f3464g.f29510b.obtainMessage(0, ws1Var).sendToTarget();
                } catch (Throwable th) {
                    throw th;
                }
            }
            notificationManager.cancel(str, i);
            return;
        }
        notificationManager.notify(str, i, notification);
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            ss1.m7403b(this.f3466b, notificationChannelGroup);
        }
    }
}
