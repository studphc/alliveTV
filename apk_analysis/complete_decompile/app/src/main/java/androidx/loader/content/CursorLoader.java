package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: p */
    public final Loader.ForceLoadContentObserver f6618p;

    /* renamed from: q */
    public Uri f6619q;

    /* renamed from: r */
    public String[] f6620r;

    /* renamed from: s */
    public String f6621s;

    /* renamed from: t */
    public String[] f6622t;

    /* renamed from: u */
    public String f6623u;

    /* renamed from: v */
    public Cursor f6624v;

    /* renamed from: w */
    public CancellationSignal f6625w;

    public CursorLoader(@NonNull Context context) {
        super(context);
        this.f6618p = new Loader.ForceLoadContentObserver();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            try {
                CancellationSignal cancellationSignal = this.f6625w;
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f6619q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f6620r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f6621s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f6622t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f6623u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f6624v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f6633h);
    }

    @Nullable
    public String[] getProjection() {
        return this.f6620r;
    }

    @Nullable
    public String getSelection() {
        return this.f6621s;
    }

    @Nullable
    public String[] getSelectionArgs() {
        return this.f6622t;
    }

    @Nullable
    public String getSortOrder() {
        return this.f6623u;
    }

    @NonNull
    public Uri getUri() {
        return this.f6619q;
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.f6624v;
        if (cursor != null && !cursor.isClosed()) {
            this.f6624v.close();
        }
        this.f6624v = null;
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        Cursor cursor = this.f6624v;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.f6624v == null) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@Nullable String[] strArr) {
        this.f6620r = strArr;
    }

    public void setSelection(@Nullable String str) {
        this.f6621s = str;
    }

    public void setSelectionArgs(@Nullable String[] strArr) {
        this.f6622t = strArr;
    }

    public void setSortOrder(@Nullable String str) {
        this.f6623u = str;
    }

    public void setUri(@NonNull Uri uri) {
        this.f6619q = uri;
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f6624v;
        this.f6624v = cursor;
        if (isStarted()) {
            super.deliverResult((CursorLoader) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.f6625w = new CancellationSignal();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            Cursor query = ContentResolverCompat.query(getContext().getContentResolver(), this.f6619q, this.f6620r, this.f6621s, this.f6622t, this.f6623u, this.f6625w);
            if (query != null) {
                try {
                    query.getCount();
                    query.registerContentObserver(this.f6618p);
                } catch (RuntimeException e) {
                    query.close();
                    throw e;
                }
            }
            synchronized (this) {
                this.f6625w = null;
            }
            return query;
        } catch (Throwable th) {
            synchronized (this) {
                this.f6625w = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        this.f6618p = new Loader.ForceLoadContentObserver();
        this.f6619q = uri;
        this.f6620r = strArr;
        this.f6621s = str;
        this.f6622t = strArr2;
        this.f6623u = str2;
    }
}
