package p000;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameCallback;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zw0 {

    /* renamed from: a */
    public final GifDecoder f29528a;

    /* renamed from: b */
    public final Handler f29529b;

    /* renamed from: c */
    public final ArrayList f29530c;

    /* renamed from: d */
    public final RequestManager f29531d;

    /* renamed from: e */
    public final BitmapPool f29532e;

    /* renamed from: f */
    public boolean f29533f;

    /* renamed from: g */
    public boolean f29534g;

    /* renamed from: h */
    public boolean f29535h;

    /* renamed from: i */
    public RequestBuilder f29536i;

    /* renamed from: j */
    public xw0 f29537j;

    /* renamed from: k */
    public boolean f29538k;

    /* renamed from: l */
    public xw0 f29539l;

    /* renamed from: m */
    public Bitmap f29540m;

    /* renamed from: n */
    public Transformation f29541n;

    /* renamed from: o */
    public xw0 f29542o;

    /* renamed from: p */
    public int f29543p;

    /* renamed from: q */
    public int f29544q;

    /* renamed from: r */
    public int f29545r;

    public zw0(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation transformation, Bitmap bitmap) {
        BitmapPool bitmapPool = glide.getBitmapPool();
        RequestManager with = Glide.with(glide.getContext());
        RequestBuilder<Bitmap> apply = Glide.with(glide.getContext()).asBitmap().apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(i, i2));
        this.f29530c = new ArrayList();
        this.f29531d = with;
        Handler handler = new Handler(Looper.getMainLooper(), new yw0(0, this));
        this.f29532e = bitmapPool;
        this.f29529b = handler;
        this.f29536i = apply;
        this.f29528a = gifDecoder;
        m8445c(transformation, bitmap);
    }

    /* renamed from: a */
    public final void m8443a() {
        boolean z;
        if (this.f29533f && !this.f29534g) {
            boolean z2 = this.f29535h;
            GifDecoder gifDecoder = this.f29528a;
            if (z2) {
                if (this.f29542o == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "Pending target must be null when starting from the first frame");
                gifDecoder.resetFrameIndex();
                this.f29535h = false;
            }
            xw0 xw0Var = this.f29542o;
            if (xw0Var != null) {
                this.f29542o = null;
                m8444b(xw0Var);
                return;
            }
            this.f29534g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + gifDecoder.getNextDelay();
            gifDecoder.advance();
            this.f29539l = new xw0(this.f29529b, gifDecoder.getCurrentFrameIndex(), uptimeMillis);
            this.f29536i.apply((BaseRequestOptions<?>) RequestOptions.signatureOf(new ObjectKey(Double.valueOf(Math.random())))).mo8491load((Object) gifDecoder).into((RequestBuilder) this.f29539l);
        }
    }

    /* renamed from: b */
    public final void m8444b(xw0 xw0Var) {
        this.f29534g = false;
        boolean z = this.f29538k;
        Handler handler = this.f29529b;
        if (z) {
            handler.obtainMessage(2, xw0Var).sendToTarget();
            return;
        }
        if (!this.f29533f) {
            if (this.f29535h) {
                handler.obtainMessage(2, xw0Var).sendToTarget();
                return;
            } else {
                this.f29542o = xw0Var;
                return;
            }
        }
        if (xw0Var.f28752g != null) {
            Bitmap bitmap = this.f29540m;
            if (bitmap != null) {
                this.f29532e.put(bitmap);
                this.f29540m = null;
            }
            xw0 xw0Var2 = this.f29537j;
            this.f29537j = xw0Var;
            ArrayList arrayList = this.f29530c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((GifFrameLoader$FrameCallback) arrayList.get(size)).onFrameReady();
            }
            if (xw0Var2 != null) {
                handler.obtainMessage(2, xw0Var2).sendToTarget();
            }
        }
        m8443a();
    }

    /* renamed from: c */
    public final void m8445c(Transformation transformation, Bitmap bitmap) {
        this.f29541n = (Transformation) Preconditions.checkNotNull(transformation);
        this.f29540m = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.f29536i = this.f29536i.apply((BaseRequestOptions<?>) new RequestOptions().transform((Transformation<Bitmap>) transformation));
        this.f29543p = Util.getBitmapByteSize(bitmap);
        this.f29544q = bitmap.getWidth();
        this.f29545r = bitmap.getHeight();
    }
}
