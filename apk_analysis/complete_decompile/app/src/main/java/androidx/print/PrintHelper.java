package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import p000.j72;

/* loaded from: classes.dex */
public final class PrintHelper {

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: g */
    public static final boolean f6732g;

    /* renamed from: h */
    public static final boolean f6733h;

    /* renamed from: a */
    public final Context f6734a;

    /* renamed from: b */
    public BitmapFactory.Options f6735b = null;

    /* renamed from: c */
    public final Object f6736c = new Object();

    /* renamed from: d */
    public int f6737d = 2;

    /* renamed from: e */
    public int f6738e = 2;

    /* renamed from: f */
    public int f6739f = 1;

    /* loaded from: classes.dex */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    static {
        boolean z;
        int i = Build.VERSION.SDK_INT;
        boolean z2 = true;
        if (i > 23) {
            z = true;
        } else {
            z = false;
        }
        f6732g = z;
        if (i == 23) {
            z2 = false;
        }
        f6733h = z2;
    }

    public PrintHelper(@NonNull Context context) {
        this.f6734a = context;
    }

    /* renamed from: a */
    public static Bitmap m1565a(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(RecyclerView.f7068F0);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, RecyclerView.f7068F0, RecyclerView.f7068F0, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    /* renamed from: b */
    public final Bitmap m1566b(Uri uri, BitmapFactory.Options options) {
        Context context;
        if (uri != null && (context = this.f6734a) != null) {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e) {
                            Log.w("PrintHelper", "close fail ", e);
                        }
                    }
                    return decodeStream;
                } catch (Throwable th) {
                    th = th;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            Log.w("PrintHelper", "close fail ", e2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
    }

    /* renamed from: c */
    public final Bitmap m1567c(Uri uri) {
        BitmapFactory.Options options;
        if (uri != null && this.f6734a != null) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            m1566b(uri, options2);
            int i = options2.outWidth;
            int i2 = options2.outHeight;
            if (i > 0 && i2 > 0) {
                int max = Math.max(i, i2);
                int i3 = 1;
                while (max > 3500) {
                    max >>>= 1;
                    i3 <<= 1;
                }
                if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                    synchronized (this.f6736c) {
                        options = new BitmapFactory.Options();
                        this.f6735b = options;
                        options.inMutable = true;
                        options.inSampleSize = i3;
                    }
                    try {
                        Bitmap m1566b = m1566b(uri, options);
                        synchronized (this.f6736c) {
                            this.f6735b = null;
                        }
                        return m1566b;
                    } catch (Throwable th) {
                        synchronized (this.f6736c) {
                            this.f6735b = null;
                            throw th;
                        }
                    }
                }
            }
            return null;
        }
        throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }

    /* renamed from: d */
    public final void m1568d(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintAttributes build;
        if (f6733h) {
            build = printAttributes;
        } else {
            PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            if (printAttributes.getDuplexMode() != 0) {
                minMargins.setDuplexMode(printAttributes.getDuplexMode());
            }
            build = minMargins.setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        new j72(this, cancellationSignal, build, bitmap, printAttributes, i, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }

    public int getColorMode() {
        return this.f6738e;
    }

    public int getOrientation() {
        int i = this.f6739f;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public int getScaleMode() {
        return this.f6737d;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void setColorMode(int i) {
        this.f6738e = i;
    }

    public void setOrientation(int i) {
        this.f6739f = i;
    }

    public void setScaleMode(int i) {
        this.f6737d = i;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap == null) {
            return;
        }
        PrintManager printManager = (PrintManager) this.f6734a.getSystemService("print");
        if (bitmap.getWidth() <= bitmap.getHeight()) {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        } else {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        }
        printManager.print(str, new C0444a(this, str, this.f6737d, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.f6738e).build());
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        C0445b c0445b = new C0445b(this, str, uri, onPrintFinishCallback, this.f6737d);
        PrintManager printManager = (PrintManager) this.f6734a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f6738e);
        int i = this.f6739f;
        if (i == 1 || i == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, c0445b, builder.build());
    }
}
