package p000;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.C0445b;
import androidx.print.PrintHelper;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class l72 extends AsyncTask {

    /* renamed from: a */
    public final /* synthetic */ CancellationSignal f22378a;

    /* renamed from: b */
    public final /* synthetic */ PrintAttributes f22379b;

    /* renamed from: c */
    public final /* synthetic */ PrintAttributes f22380c;

    /* renamed from: d */
    public final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f22381d;

    /* renamed from: e */
    public final /* synthetic */ C0445b f22382e;

    public l72(C0445b c0445b, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
        this.f22382e = c0445b;
        this.f22378a = cancellationSignal;
        this.f22379b = printAttributes;
        this.f22380c = printAttributes2;
        this.f22381d = layoutResultCallback;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        try {
            C0445b c0445b = this.f22382e;
            return c0445b.f6753h.m1567c(c0445b.f6747b);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        this.f22381d.onLayoutCancelled();
        this.f22382e.f6751f = null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        PrintAttributes.MediaSize mediaSize;
        boolean z;
        Bitmap bitmap = (Bitmap) obj;
        super.onPostExecute(bitmap);
        if (bitmap != null && (!PrintHelper.f6732g || this.f22382e.f6753h.f6739f == 0)) {
            synchronized (this) {
                mediaSize = this.f22382e.f6750e.getMediaSize();
            }
            if (mediaSize != null) {
                boolean isPortrait = mediaSize.isPortrait();
                if (bitmap.getWidth() <= bitmap.getHeight()) {
                    z = true;
                } else {
                    z = false;
                }
                if (isPortrait != z) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        }
        this.f22382e.f6752g = bitmap;
        if (bitmap != null) {
            this.f22381d.onLayoutFinished(new PrintDocumentInfo.Builder(this.f22382e.f6746a).setContentType(1).setPageCount(1).build(), true ^ this.f22379b.equals(this.f22380c));
        } else {
            this.f22381d.onLayoutFailed(null);
        }
        this.f22382e.f6751f = null;
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        this.f22378a.setOnCancelListener(new k72(this));
    }
}
