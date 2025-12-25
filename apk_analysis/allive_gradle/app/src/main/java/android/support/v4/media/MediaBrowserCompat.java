package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.C1540m9;
import p000.pk1;
import p000.qk1;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";

    /* renamed from: b */
    public static final boolean f274b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a */
    public final C0037l f275a;

    /* loaded from: classes.dex */
    public static class ConnectionCallback {

        /* renamed from: a */
        public final C0026a f276a = new C0026a(this);

        /* renamed from: b */
        public AbstractC0036k f277b;

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* loaded from: classes.dex */
    public static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d */
        public final String f278d;

        /* renamed from: e */
        public final Bundle f279e;

        /* renamed from: f */
        public final CustomActionCallback f280f;

        public CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, qk1 qk1Var) {
            super(qk1Var);
            this.f278d = str;
            this.f279e = bundle;
            this.f280f = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            CustomActionCallback customActionCallback = this.f280f;
            if (customActionCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            String str = this.f278d;
            Bundle bundle2 = this.f279e;
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + bundle2 + ", resultData=" + bundle + ")");
                        return;
                    }
                    customActionCallback.onProgressUpdate(str, bundle2, bundle);
                    return;
                }
                customActionCallback.onResult(str, bundle2, bundle);
                return;
            }
            customActionCallback.onError(str, bundle2, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback {

        /* renamed from: a */
        public final C0027b f281a = new C0027b(this);

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    /* loaded from: classes.dex */
    public static class ItemReceiver extends ResultReceiver {

        /* renamed from: d */
        public final String f282d;

        /* renamed from: e */
        public final ItemCallback f283e;

        public ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.f282d = str;
            this.f283e = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            String str = this.f282d;
            ItemCallback itemCallback = this.f283e;
            if (i == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                if (parcelable != null && !(parcelable instanceof MediaItem)) {
                    itemCallback.onError(str);
                    return;
                } else {
                    itemCallback.onItemLoaded((MediaItem) parcelable);
                    return;
                }
            }
            itemCallback.onError(str);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SearchCallback {
        public void onError(@NonNull String str, Bundle bundle) {
        }

        public void onSearchResult(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    /* loaded from: classes.dex */
    public static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: d */
        public final String f286d;

        /* renamed from: e */
        public final Bundle f287e;

        /* renamed from: f */
        public final SearchCallback f288f;

        public SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, qk1 qk1Var) {
            super(qk1Var);
            this.f286d = str;
            this.f287e = bundle;
            this.f288f = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            Bundle bundle2 = this.f287e;
            String str = this.f286d;
            SearchCallback searchCallback = this.f288f;
            if (i == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
                if (parcelableArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                    searchCallback.onSearchResult(str, bundle2, arrayList);
                    return;
                }
                searchCallback.onError(str, bundle2);
                return;
            }
            searchCallback.onError(str, bundle2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SubscriptionCallback {

        /* renamed from: a */
        public final C0042q f289a;

        /* renamed from: b */
        public final Binder f290b = new Binder();

        /* renamed from: c */
        public WeakReference f291c;

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f289a = new C0043r(this);
            } else {
                this.f289a = new C0042q(this);
            }
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String str) {
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.support.v4.media.k, android.support.v4.media.l] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v4.media.k, android.support.v4.media.l] */
    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f275a = new AbstractC0036k(context, componentName, connectionCallback, bundle);
        } else {
            this.f275a = new AbstractC0036k(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.f275a.f341b.connect();
    }

    public void disconnect() {
        Messenger messenger;
        C0037l c0037l = this.f275a;
        C1540m9 c1540m9 = c0037l.f346g;
        if (c1540m9 != null && (messenger = c0037l.f347h) != null) {
            try {
                c1540m9.m6109s(7, null, messenger);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        c0037l.f341b.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.f275a.f341b.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        C0037l c0037l = this.f275a;
        C1540m9 c1540m9 = c0037l.f346g;
        MediaBrowser mediaBrowser = c0037l.f341b;
        if (c1540m9 == null) {
            mediaBrowser.getItem(str, itemCallback.f281a);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (itemCallback != null) {
                boolean isConnected = mediaBrowser.isConnected();
                qk1 qk1Var = c0037l.f343d;
                if (!isConnected) {
                    Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                    qk1Var.post(new RunnableC0029d(str, itemCallback));
                    return;
                }
                if (c0037l.f346g == null) {
                    qk1Var.post(new RunnableC0030e(str, itemCallback));
                    return;
                }
                ItemReceiver itemReceiver = new ItemReceiver(str, itemCallback, qk1Var);
                try {
                    C1540m9 c1540m92 = c0037l.f346g;
                    Messenger messenger = c0037l.f347h;
                    c1540m92.getClass();
                    Bundle bundle = new Bundle();
                    bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
                    bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, itemReceiver);
                    c1540m92.m6109s(5, bundle, messenger);
                    return;
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    qk1Var.post(new RunnableC0031f(str, itemCallback));
                    return;
                }
            }
            throw new IllegalArgumentException("cb is null");
        }
        throw new IllegalArgumentException("mediaId is empty");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.f275a.f349j;
    }

    @NonNull
    public String getRoot() {
        return this.f275a.f341b.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.f275a.f341b.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        C0037l c0037l = this.f275a;
        if (c0037l.f348i == null) {
            c0037l.f348i = MediaSessionCompat.Token.fromToken(c0037l.f341b.getSessionToken());
        }
        return c0037l.f348i;
    }

    public boolean isConnected() {
        return this.f275a.f341b.isConnected();
    }

    public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (!TextUtils.isEmpty(str)) {
            if (searchCallback != null) {
                C0037l c0037l = this.f275a;
                if (c0037l.f341b.isConnected()) {
                    C1540m9 c1540m9 = c0037l.f346g;
                    qk1 qk1Var = c0037l.f343d;
                    if (c1540m9 == null) {
                        Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
                        qk1Var.post(new RunnableC0032g(str, bundle, searchCallback));
                        return;
                    }
                    SearchResultReceiver searchResultReceiver = new SearchResultReceiver(str, bundle, searchCallback, qk1Var);
                    try {
                        C1540m9 c1540m92 = c0037l.f346g;
                        Messenger messenger = c0037l.f347h;
                        c1540m92.getClass();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
                        bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
                        bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, searchResultReceiver);
                        c1540m92.m6109s(8, bundle2, messenger);
                        return;
                    } catch (RemoteException e) {
                        Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                        qk1Var.post(new RunnableC0033h(str, bundle, searchCallback));
                        return;
                    }
                }
                throw new IllegalStateException("search() called while not connected");
            }
            throw new IllegalArgumentException("callback cannot be null");
        }
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty(str)) {
            C0037l c0037l = this.f275a;
            if (c0037l.f341b.isConnected()) {
                C1540m9 c1540m9 = c0037l.f346g;
                qk1 qk1Var = c0037l.f343d;
                if (c1540m9 == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        qk1Var.post(new RunnableC0034i(str, bundle, customActionCallback));
                    }
                }
                CustomActionResultReceiver customActionResultReceiver = new CustomActionResultReceiver(str, bundle, customActionCallback, qk1Var);
                try {
                    C1540m9 c1540m92 = c0037l.f346g;
                    Messenger messenger = c0037l.f347h;
                    c1540m92.getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
                    bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
                    bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, customActionResultReceiver);
                    c1540m92.m6109s(9, bundle2, messenger);
                    return;
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                    if (customActionCallback != null) {
                        qk1Var.post(new RunnableC0035j(str, bundle, customActionCallback));
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
        }
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.f275a.mo117a(str, null, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void unsubscribe(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f275a.mo118b(str, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.f275a.mo118b(str, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle != null) {
            this.f275a.mo117a(str, bundle, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Object();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;

        /* renamed from: a */
        public final int f284a;

        /* renamed from: b */
        public final MediaDescriptionCompat f285b;

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat != null) {
                if (!TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                    this.f284a = i;
                    this.f285b = mediaDescriptionCompat;
                    return;
                }
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj != null) {
                MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
                return new MediaItem(MediaDescriptionCompat.fromMediaDescription(pk1.m6915a(mediaItem)), pk1.m6916b(mediaItem));
            }
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromMediaItem(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.f285b;
        }

        public int getFlags() {
            return this.f284a;
        }

        @Nullable
        public String getMediaId() {
            return this.f285b.getMediaId();
        }

        public boolean isBrowsable() {
            if ((this.f284a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isPlayable() {
            if ((this.f284a & 2) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.f284a + ", mDescription=" + this.f285b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f284a);
            this.f285b.writeToParcel(parcel, i);
        }

        public MediaItem(Parcel parcel) {
            this.f284a = parcel.readInt();
            this.f285b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
