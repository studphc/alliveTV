package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000.ye0;

/* loaded from: classes.dex */
public class Loader<D> {

    /* renamed from: a */
    public int f6626a;

    /* renamed from: b */
    public OnLoadCompleteListener f6627b;

    /* renamed from: c */
    public OnLoadCanceledListener f6628c;

    /* renamed from: d */
    public final Context f6629d;

    /* renamed from: e */
    public boolean f6630e = false;

    /* renamed from: f */
    public boolean f6631f = false;

    /* renamed from: g */
    public boolean f6632g = true;

    /* renamed from: h */
    public boolean f6633h = false;

    /* renamed from: i */
    public boolean f6634i = false;

    /* loaded from: classes.dex */
    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    /* loaded from: classes.dex */
    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> loader);
    }

    /* loaded from: classes.dex */
    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d);
    }

    public Loader(@NonNull Context context) {
        this.f6629d = context.getApplicationContext();
    }

    @MainThread
    public void abandon() {
        this.f6631f = true;
        onAbandon();
    }

    @MainThread
    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.f6634i = false;
    }

    @NonNull
    public String dataToString(@Nullable D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void deliverCancellation() {
        OnLoadCanceledListener onLoadCanceledListener = this.f6628c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    @MainThread
    public void deliverResult(@Nullable D d) {
        OnLoadCompleteListener onLoadCompleteListener = this.f6627b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f6626a);
        printWriter.print(" mListener=");
        printWriter.println(this.f6627b);
        if (this.f6630e || this.f6633h || this.f6634i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f6630e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f6633h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f6634i);
        }
        if (this.f6631f || this.f6632g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f6631f);
            printWriter.print(" mReset=");
            printWriter.println(this.f6632g);
        }
    }

    @MainThread
    public void forceLoad() {
        onForceLoad();
    }

    @NonNull
    public Context getContext() {
        return this.f6629d;
    }

    public int getId() {
        return this.f6626a;
    }

    public boolean isAbandoned() {
        return this.f6631f;
    }

    public boolean isReset() {
        return this.f6632g;
    }

    public boolean isStarted() {
        return this.f6630e;
    }

    @MainThread
    public void onAbandon() {
    }

    @MainThread
    public boolean onCancelLoad() {
        return false;
    }

    @MainThread
    public void onContentChanged() {
        if (this.f6630e) {
            forceLoad();
        } else {
            this.f6633h = true;
        }
    }

    @MainThread
    public void onForceLoad() {
    }

    @MainThread
    public void onReset() {
    }

    @MainThread
    public void onStartLoading() {
    }

    @MainThread
    public void onStopLoading() {
    }

    @MainThread
    public void registerListener(int i, @NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f6627b == null) {
            this.f6627b = onLoadCompleteListener;
            this.f6626a = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void registerOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f6628c == null) {
            this.f6628c = onLoadCanceledListener;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void reset() {
        onReset();
        this.f6632g = true;
        this.f6630e = false;
        this.f6631f = false;
        this.f6633h = false;
        this.f6634i = false;
    }

    public void rollbackContentChanged() {
        if (this.f6634i) {
            onContentChanged();
        }
    }

    @MainThread
    public final void startLoading() {
        this.f6630e = true;
        this.f6632g = false;
        this.f6631f = false;
        onStartLoading();
    }

    @MainThread
    public void stopLoading() {
        this.f6630e = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.f6633h;
        this.f6633h = false;
        this.f6634i |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        return ye0.m8298r(sb, "}", this.f6626a);
    }

    @MainThread
    public void unregisterListener(@NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.f6627b;
        if (onLoadCompleteListener2 != null) {
            if (onLoadCompleteListener2 == onLoadCompleteListener) {
                this.f6627b = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        throw new IllegalStateException("No listener register");
    }

    @MainThread
    public void unregisterOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.f6628c;
        if (onLoadCanceledListener2 != null) {
            if (onLoadCanceledListener2 == onLoadCanceledListener) {
                this.f6628c = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        throw new IllegalStateException("No listener register");
    }
}
