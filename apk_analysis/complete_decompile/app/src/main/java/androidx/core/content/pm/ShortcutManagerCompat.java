package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p000.C1150e9;
import p000.ci2;
import p000.di2;
import p000.y70;

/* loaded from: classes.dex */
public class ShortcutManagerCompat {
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;

    /* renamed from: a */
    public static volatile ShortcutInfoCompatSaver f3602a;

    /* renamed from: b */
    public static volatile ArrayList f3603b;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ShortcutMatchFlags {
    }

    /* renamed from: a */
    public static boolean m807a(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap decodeStream;
        IconCompat createWithBitmap;
        IconCompat iconCompat = shortcutInfoCompat.f3579i;
        if (iconCompat == null) {
            return false;
        }
        int i = iconCompat.mType;
        if (i != 6 && i != 4) {
            return true;
        }
        InputStream uriInputStream = iconCompat.getUriInputStream(context);
        if (uriInputStream == null || (decodeStream = BitmapFactory.decodeStream(uriInputStream)) == null) {
            return false;
        }
        if (i == 6) {
            createWithBitmap = IconCompat.createWithAdaptiveBitmap(decodeStream);
        } else {
            createWithBitmap = IconCompat.createWithBitmap(decodeStream);
        }
        shortcutInfoCompat.f3579i = createWithBitmap;
        return true;
    }

    public static boolean addDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        boolean addDynamicShortcuts;
        List<ShortcutInfoCompat> m812f = m812f(list);
        int i = Build.VERSION.SDK_INT;
        if (i <= 29) {
            m808b(context, m812f);
        }
        if (i >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<ShortcutInfoCompat> it = m812f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            addDynamicShortcuts = ci2.m2236b(context.getSystemService(ci2.m2237c())).addDynamicShortcuts(arrayList);
            if (!addDynamicShortcuts) {
                return false;
            }
        }
        m811e(context).addShortcuts(m812f);
        Iterator it2 = ((ArrayList) m810d(context)).iterator();
        while (it2.hasNext()) {
            ((ShortcutInfoChangeListener) it2.next()).onShortcutAdded(list);
        }
        return true;
    }

    /* renamed from: b */
    public static void m808b(Context context, List list) {
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
            if (!m807a(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    /* renamed from: c */
    public static int m809c(Context context, boolean z) {
        int i;
        float f;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && !activityManager.isLowRamDevice()) {
            i = 96;
        } else {
            i = 48;
        }
        int max = Math.max(1, i);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            f = displayMetrics.xdpi;
        } else {
            f = displayMetrics.ydpi;
        }
        return (int) (max * (f / 160.0f));
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = ci2.m2236b(context.getSystemService(ci2.m2237c())).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new Intent();
        }
        shortcutInfoCompat.m806a(intent);
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List m810d(Context context) {
        Bundle bundle;
        if (f3603b == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                    String string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl");
                    if (string != null) {
                        try {
                            arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                        } catch (Exception unused) {
                        }
                    }
                    while (it.hasNext()) {
                    }
                }
            }
            if (f3603b == null) {
                f3603b = arrayList;
            }
        }
        return f3603b;
    }

    public static void disableShortcuts(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ci2.m2236b(context.getSystemService(ci2.m2237c())).disableShortcuts(list, charSequence);
        }
        m811e(context).removeShortcuts(list);
        Iterator it = ((ArrayList) m810d(context)).iterator();
        while (it.hasNext()) {
            ((ShortcutInfoChangeListener) it.next()).onShortcutRemoved(list);
        }
    }

    /* renamed from: e */
    public static ShortcutInfoCompatSaver m811e(Context context) {
        if (f3602a == null) {
            try {
                f3602a = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (f3602a == null) {
                f3602a = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return f3602a;
    }

    public static void enableShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> m812f = m812f(list);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<ShortcutInfoCompat> it = m812f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f3572b);
            }
            ci2.m2236b(context.getSystemService(ci2.m2237c())).enableShortcuts(arrayList);
        }
        m811e(context).addShortcuts(m812f);
        Iterator it2 = ((ArrayList) m810d(context)).iterator();
        while (it2.hasNext()) {
            ((ShortcutInfoChangeListener) it2.next()).onShortcutAdded(list);
        }
    }

    /* renamed from: f */
    public static List m812f(List list) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
            if (shortcutInfoCompat.isExcludedFromSurfaces(1)) {
                arrayList.remove(shortcutInfoCompat);
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context context) {
        List dynamicShortcuts;
        if (Build.VERSION.SDK_INT >= 25) {
            dynamicShortcuts = ci2.m2236b(context.getSystemService(ci2.m2237c())).getDynamicShortcuts();
            ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
            Iterator it = dynamicShortcuts.iterator();
            while (it.hasNext()) {
                arrayList.add(new ShortcutInfoCompat.Builder(context, y70.m8236h(it.next())).build());
            }
            return arrayList;
        }
        try {
            return m811e(context).getShortcuts();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static int getIconMaxHeight(@NonNull Context context) {
        int iconMaxHeight;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            iconMaxHeight = ci2.m2236b(context.getSystemService(ci2.m2237c())).getIconMaxHeight();
            return iconMaxHeight;
        }
        return m809c(context, false);
    }

    public static int getIconMaxWidth(@NonNull Context context) {
        int iconMaxWidth;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            iconMaxWidth = ci2.m2236b(context.getSystemService(ci2.m2237c())).getIconMaxWidth();
            return iconMaxWidth;
        }
        return m809c(context, true);
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context context) {
        int maxShortcutCountPerActivity;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            maxShortcutCountPerActivity = ci2.m2236b(context.getSystemService(ci2.m2237c())).getMaxShortcutCountPerActivity();
            return maxShortcutCountPerActivity;
        }
        return 5;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context context, int i) {
        List pinnedShortcuts;
        List dynamicShortcuts;
        List manifestShortcuts;
        List shortcuts;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            shortcuts = ci2.m2236b(context.getSystemService(ci2.m2237c())).getShortcuts(i);
            return ShortcutInfoCompat.m805b(context, shortcuts);
        }
        if (i2 >= 25) {
            ShortcutManager m2236b = ci2.m2236b(context.getSystemService(ci2.m2237c()));
            ArrayList arrayList = new ArrayList();
            if ((i & 1) != 0) {
                manifestShortcuts = m2236b.getManifestShortcuts();
                arrayList.addAll(manifestShortcuts);
            }
            if ((i & 2) != 0) {
                dynamicShortcuts = m2236b.getDynamicShortcuts();
                arrayList.addAll(dynamicShortcuts);
            }
            if ((i & 4) != 0) {
                pinnedShortcuts = m2236b.getPinnedShortcuts();
                arrayList.addAll(pinnedShortcuts);
            }
            return ShortcutInfoCompat.m805b(context, arrayList);
        }
        if ((i & 2) != 0) {
            try {
                return m811e(context).getShortcuts();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(@NonNull Context context) {
        boolean isRateLimitingActive;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            isRateLimitingActive = ci2.m2236b(context.getSystemService(ci2.m2237c())).isRateLimitingActive();
            return isRateLimitingActive;
        }
        if (getShortcuts(context, 3).size() == getMaxShortcutCountPerActivity(context)) {
            return true;
        }
        return false;
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context context) {
        boolean isRequestPinShortcutSupported;
        if (Build.VERSION.SDK_INT >= 26) {
            isRequestPinShortcutSupported = ci2.m2236b(context.getSystemService(ci2.m2237c())).isRequestPinShortcutSupported();
            return isRequestPinShortcutSupported;
        }
        if (ContextCompat.checkSelfPermission(context, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0) {
            return false;
        }
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.permission;
            if (TextUtils.isEmpty(str) || "com.android.launcher.permission.INSTALL_SHORTCUT".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pushDynamicShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        boolean isRateLimitingActive;
        List dynamicShortcuts;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutInfoCompat);
        int i = Build.VERSION.SDK_INT;
        if (i <= 32 && shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            Iterator it = ((ArrayList) m810d(context)).iterator();
            while (it.hasNext()) {
                ((ShortcutInfoChangeListener) it.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            return true;
        }
        int maxShortcutCountPerActivity = getMaxShortcutCountPerActivity(context);
        if (maxShortcutCountPerActivity == 0) {
            return false;
        }
        if (i <= 29) {
            m807a(context, shortcutInfoCompat);
        }
        if (i >= 30) {
            ci2.m2236b(context.getSystemService(ci2.m2237c())).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
        } else if (i >= 25) {
            ShortcutManager m2236b = ci2.m2236b(context.getSystemService(ci2.m2237c()));
            isRateLimitingActive = m2236b.isRateLimitingActive();
            if (isRateLimitingActive) {
                return false;
            }
            dynamicShortcuts = m2236b.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= maxShortcutCountPerActivity) {
                m2236b.removeDynamicShortcuts(Arrays.asList(di2.m4586a(dynamicShortcuts)));
            }
            m2236b.addDynamicShortcuts(Arrays.asList(shortcutInfoCompat.toShortcutInfo()));
        }
        ShortcutInfoCompatSaver m811e = m811e(context);
        try {
            List<ShortcutInfoCompat> shortcuts = m811e.getShortcuts();
            if (shortcuts.size() >= maxShortcutCountPerActivity) {
                int i2 = -1;
                String str = null;
                for (ShortcutInfoCompat shortcutInfoCompat2 : shortcuts) {
                    if (shortcutInfoCompat2.getRank() > i2) {
                        str = shortcutInfoCompat2.getId();
                        i2 = shortcutInfoCompat2.getRank();
                    }
                }
                m811e.removeShortcuts(Arrays.asList(str));
            }
            m811e.addShortcuts(Arrays.asList(shortcutInfoCompat));
            Iterator it2 = ((ArrayList) m810d(context)).iterator();
            while (it2.hasNext()) {
                ((ShortcutInfoChangeListener) it2.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            reportShortcutUsed(context, shortcutInfoCompat.getId());
            return true;
        } catch (Exception unused) {
            Iterator it3 = ((ArrayList) m810d(context)).iterator();
            while (it3.hasNext()) {
                ((ShortcutInfoChangeListener) it3.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            reportShortcutUsed(context, shortcutInfoCompat.getId());
            return false;
        } catch (Throwable th) {
            Iterator it4 = ((ArrayList) m810d(context)).iterator();
            while (it4.hasNext()) {
                ((ShortcutInfoChangeListener) it4.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            reportShortcutUsed(context, shortcutInfoCompat.getId());
            throw th;
        }
    }

    public static void removeAllDynamicShortcuts(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ci2.m2236b(context.getSystemService(ci2.m2237c())).removeAllDynamicShortcuts();
        }
        m811e(context).removeAllShortcuts();
        Iterator it = ((ArrayList) m810d(context)).iterator();
        while (it.hasNext()) {
            ((ShortcutInfoChangeListener) it.next()).onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ci2.m2236b(context.getSystemService(ci2.m2237c())).removeDynamicShortcuts(list);
        }
        m811e(context).removeShortcuts(list);
        Iterator it = ((ArrayList) m810d(context)).iterator();
        while (it.hasNext()) {
            ((ShortcutInfoChangeListener) it.next()).onShortcutRemoved(list);
        }
    }

    public static void removeLongLivedShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 30) {
            ci2.m2236b(context.getSystemService(ci2.m2237c())).removeLongLivedShortcuts(list);
            m811e(context).removeShortcuts(list);
            Iterator it = ((ArrayList) m810d(context)).iterator();
            while (it.hasNext()) {
                ((ShortcutInfoChangeListener) it.next()).onShortcutRemoved(list);
            }
            return;
        }
        removeDynamicShortcuts(context, list);
    }

    public static void reportShortcutUsed(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        if (Build.VERSION.SDK_INT >= 25) {
            ci2.m2236b(context.getSystemService(ci2.m2237c())).reportShortcutUsed(str);
        }
        Iterator it = ((ArrayList) m810d(context)).iterator();
        while (it.hasNext()) {
            ((ShortcutInfoChangeListener) it.next()).onShortcutUsageReported(Collections.singletonList(str));
        }
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable IntentSender intentSender) {
        boolean requestPinShortcut;
        int i = Build.VERSION.SDK_INT;
        if (i <= 32 && shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            return false;
        }
        if (i >= 26) {
            requestPinShortcut = ci2.m2236b(context.getSystemService(ci2.m2237c())).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
            return requestPinShortcut;
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutInfoCompat.m806a(intent);
        if (intentSender == null) {
            context.sendBroadcast(intent);
            return true;
        }
        context.sendOrderedBroadcast(intent, null, new C1150e9(5, intentSender), null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        boolean dynamicShortcuts;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(list);
        List<ShortcutInfoCompat> m812f = m812f(list);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(m812f.size());
            Iterator<ShortcutInfoCompat> it = m812f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            dynamicShortcuts = ci2.m2236b(context.getSystemService(ci2.m2237c())).setDynamicShortcuts(arrayList);
            if (!dynamicShortcuts) {
                return false;
            }
        }
        m811e(context).removeAllShortcuts();
        m811e(context).addShortcuts(m812f);
        Iterator it2 = ((ArrayList) m810d(context)).iterator();
        while (it2.hasNext()) {
            ShortcutInfoChangeListener shortcutInfoChangeListener = (ShortcutInfoChangeListener) it2.next();
            shortcutInfoChangeListener.onAllShortcutsRemoved();
            shortcutInfoChangeListener.onShortcutAdded(list);
        }
        return true;
    }

    public static boolean updateShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        boolean updateShortcuts;
        List<ShortcutInfoCompat> m812f = m812f(list);
        int i = Build.VERSION.SDK_INT;
        if (i <= 29) {
            m808b(context, m812f);
        }
        if (i >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<ShortcutInfoCompat> it = m812f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            updateShortcuts = ci2.m2236b(context.getSystemService(ci2.m2237c())).updateShortcuts(arrayList);
            if (!updateShortcuts) {
                return false;
            }
        }
        m811e(context).addShortcuts(m812f);
        Iterator it2 = ((ArrayList) m810d(context)).iterator();
        while (it2.hasNext()) {
            ((ShortcutInfoChangeListener) it2.next()).onShortcutUpdated(list);
        }
        return true;
    }
}
