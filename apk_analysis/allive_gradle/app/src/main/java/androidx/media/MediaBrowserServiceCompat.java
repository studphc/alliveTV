package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.rk1;
import p000.sk1;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";

    /* renamed from: h */
    public static final boolean f6658h = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a */
    public C0438o f6659a;

    /* renamed from: e */
    public C0431h f6663e;

    /* renamed from: g */
    public MediaSessionCompat.Token f6665g;

    /* renamed from: b */
    public final C0431h f6660b = new C0431h(this, MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, -1, -1, null, null);

    /* renamed from: c */
    public final ArrayList f6661c = new ArrayList();

    /* renamed from: d */
    public final ArrayMap f6662d = new ArrayMap();

    /* renamed from: f */
    public final HandlerC0443u f6664f = new HandlerC0443u(this);

    /* loaded from: classes.dex */
    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";

        /* renamed from: a */
        public final String f6666a;

        /* renamed from: b */
        public final Bundle f6667b;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str != null) {
                this.f6666a = str;
                this.f6667b = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }

        public Bundle getExtras() {
            return this.f6667b;
        }

        public String getRootId() {
            return this.f6666a;
        }
    }

    /* loaded from: classes.dex */
    public static class Result<T> {

        /* renamed from: a */
        public final Object f6668a;

        /* renamed from: b */
        public boolean f6669b;

        /* renamed from: c */
        public boolean f6670c;

        /* renamed from: d */
        public boolean f6671d;

        /* renamed from: e */
        public int f6672e;

        public Result(Object obj) {
            this.f6668a = obj;
        }

        /* renamed from: a */
        public final boolean m1551a() {
            if (!this.f6669b && !this.f6670c && !this.f6671d) {
                return false;
            }
            return true;
        }

        /* renamed from: b */
        public void mo1552b(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f6668a);
        }

        /* renamed from: c */
        public void mo1553c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.f6668a);
        }

        /* renamed from: d */
        public void mo1554d(Object obj) {
        }

        public void detach() {
            boolean z = this.f6669b;
            Object obj = this.f6668a;
            if (!z) {
                if (!this.f6670c) {
                    if (!this.f6671d) {
                        this.f6669b = true;
                        return;
                    } else {
                        throw new IllegalStateException("detach() called when sendError() had already been called for: " + obj);
                    }
                }
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + obj);
            }
            throw new IllegalStateException("detach() called when detach() had already been called for: " + obj);
        }

        public void sendError(@Nullable Bundle bundle) {
            if (!this.f6670c && !this.f6671d) {
                this.f6671d = true;
                mo1552b(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f6668a);
            }
        }

        public void sendProgressUpdate(@Nullable Bundle bundle) {
            if (!this.f6670c && !this.f6671d) {
                if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                    float f = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                    if (f < -1.0E-5f || f > 1.00001f) {
                        throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0]");
                    }
                }
                mo1553c(bundle);
                return;
            }
            throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.f6668a);
        }

        public void sendResult(@Nullable T t) {
            if (!this.f6670c && !this.f6671d) {
                this.f6670c = true;
                mo1554d(t);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f6668a);
            }
        }
    }

    /* renamed from: a */
    public static List m1549a(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i >= 0 && i2 >= 1 && i3 < list.size()) {
            if (i4 > list.size()) {
                i4 = list.size();
            }
            return list.subList(i3, i4);
        }
        return Collections.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    /* renamed from: b */
    public final void m1550b(String str, C0431h c0431h, Bundle bundle, Bundle bundle2) {
        C0427d c0427d = new C0427d(this, str, c0431h, str, bundle, bundle2);
        this.f6663e = c0431h;
        if (bundle == null) {
            onLoadChildren(str, c0427d);
        } else {
            onLoadChildren(str, c0427d, bundle);
        }
        this.f6663e = null;
        if (c0427d.m1551a()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + c0431h.f6699a + " id=" + str);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Bundle getBrowserRootHints() {
        return this.f6659a.mo1559a();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.f6659a.mo1560b();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.f6665g;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str != null) {
            C0438o c0438o = this.f6659a;
            c0438o.mo1562d(str, null);
            c0438o.f6717d.f6664f.post(new sk1(c0438o, str, (Parcelable) null, 0));
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f6659a.f6715b.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f6659a = new C0441s(this);
        } else if (i >= 26) {
            this.f6659a = new C0440q(this);
        } else {
            this.f6659a = new C0438o(this);
        }
        this.f6659a.onCreate();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError(null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.f6672e = 1;
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.f6672e = 2;
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.f6672e = 4;
        result.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onUnsubscribe(String str) {
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token != null) {
            if (this.f6665g == null) {
                this.f6665g = token;
                C0438o c0438o = this.f6659a;
                c0438o.f6717d.f6664f.m1564a(new rk1(c0438o, token));
                return;
            }
            throw new IllegalStateException("The session token has already been set");
        }
        throw new IllegalArgumentException("Session token may not be null");
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            C0438o c0438o = this.f6659a;
            c0438o.mo1562d(str, bundle);
            c0438o.f6717d.f6664f.post(new sk1(c0438o, str, bundle, 0));
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            C0438o c0438o = this.f6659a;
            c0438o.f6717d.f6664f.post(new RunnableC0434k(c0438o, remoteUserInfo, str, bundle));
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
}
